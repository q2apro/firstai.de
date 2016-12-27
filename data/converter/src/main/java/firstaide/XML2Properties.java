package firstaide;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * Generate Property files (for translation tools) from XML files.
 */
public class XML2Properties {

	public static final String[] LEGACY_FORMAT_KEYS = {
			"audioPrefix", "iPhoneTitle", "iPhoneTitleOffline", "iPhoneDescription", "iPhoneDescriptionOffline",
			"WinMobTitle", "WinMobDescription", "softwareVersion", "WinMobVersionNumber", "iPhoneVersionNumber",
			"softwareRelease", "WinMobReleaseDate", "iPhoneReleaseDate", "iPhoneBackButton", "iPhoneMenuButton",
			"languageChooser", "iPhoneOfflineFilename", "offlineBookmark", "donateProject", "mailToDeveloper",
			"checkNewVersion", "donate", "whyDonate", "donate1", "donateOnlineVia", "paypalID", "orWireTransfer",
			"everyContributionCounts", "smallStep", "license", "licenseTerms", "licenseAttribution",
			"licenseAttribution1", "licenseAttribution2", "licenseAttribution3", "licenseNoCommercial",
			"licenseNoCommercial1", "licenseNoDeriv", "licenseNoDeriv1", "licenseDistribution1", "licenseSuffix",
			"licenseDistribution2", "licenseWaived", "licenseMoralRights"
	};

	public static void main(String[] args) throws Exception {
		if (args.length == 0)
			args = "de en fr pt lt vi cz es it pl zh".split(" ");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document template = builder.parse(new File("../xml/propertytemplate.xml"));
		LanguageXMLFile.stripWhitespaceNodes(template.getDocumentElement());
		Set<String> legacyFormatKeys = new HashSet<>();
		for (String legacyFormatKey : LEGACY_FORMAT_KEYS) {
			legacyFormatKeys.add("string." + legacyFormatKey);
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println("=== " + args[i] + " ===");
			Document doc = builder.parse(new File("../xml/lang-" + args[i] + ".xml"));
			LanguageXMLFile.stripWhitespaceNodes(doc.getDocumentElement());
			Properties props = new Properties();
			Map<String, List<String>> numericProperties = new HashMap<>();
			handleElement(doc.getDocumentElement(), template.getDocumentElement(), props, numericProperties);
			for (Map.Entry<String, List<String>> numericProp : numericProperties.entrySet()) {
				props.setProperty(numericProp.getKey(), String.join("++", numericProp.getValue()));
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			props.store(baos, null);
			List<String> legacyLines = new ArrayList<>(), continentLines = new ArrayList<>(), countryLines = new ArrayList<>();
			List<String> generalLines = new ArrayList<>(), emergencyLines = new ArrayList<>(), aidLines = new ArrayList<>();
			for (String line : new String(baos.toByteArray(), StandardCharsets.ISO_8859_1).replace("\r\n", "\n").replace('\r', '\n').split("\n")) {
				if (line.startsWith("#"))
					continue;
				int pos = line.indexOf('=');
				String key = line.substring(0, pos);
				if (legacyFormatKeys.contains(key))
					legacyLines.add(line);
				else if (key.startsWith("aid_"))
					aidLines.add(line);
				else if (key.startsWith("string.continent_"))
					continentLines.add(line);
				else if (key.startsWith("string.country_"))
					countryLines.add(line);
				else if (key.startsWith("string.emergency_"))
					emergencyLines.add(line);
				else
					generalLines.add(line);
			}
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../properties/lang-" + args[i] + ".properties"), StandardCharsets.ISO_8859_1))) {
				bw.write("## Language Properties for firstai.de, language=" + args[i] + "\n");
				writeSection(bw, "General", generalLines);
				writeSection(bw, "Continents", continentLines);
				writeSection(bw, "Countries", countryLines);
				writeSection(bw, "Emergency Numbers", emergencyLines);
				writeSection(bw, "Legacy Formats", legacyLines);
				writeSection(bw, "First Aid Sections", aidLines);
			}
			try (InputStream in = new FileInputStream("../properties/lang-" + args[i] + ".properties")) {
				Properties props2 = new Properties();
				props2.load(in);
				if (!props.equals(props2))
					throw new RuntimeException("Load after save failed!");
			}
		}
	}

	private static void handleElement(Element docElem, Element templateElem, Properties props, Map<String, List<String>> numericProperties) {
		Node dn = docElem.getFirstChild();
		for (Node tn = templateElem.getFirstChild(); tn != null; tn = tn.getNextSibling()) {
			if (tn instanceof Text) {
				String tvalue = tn.getNodeValue();
				if (tvalue.startsWith("$")) {
					String dvalue = "";
					if (dn instanceof Text) {
						dvalue = dn.getNodeValue();
						dn = dn.getNextSibling();
					}
					if (tvalue.contains("@")) {
						String[] parts = tvalue.substring(1).split("@");
						if (!numericProperties.containsKey(parts[0]))
							numericProperties.put(parts[0], new ArrayList<>());
						List<String> l = numericProperties.get(parts[0]);
						int idx = Integer.parseInt(parts[1]);
						while (l.size() < idx)
							l.add("");
						l.set(idx - 1, dvalue);
					} else if (tvalue.endsWith("?")) {
						props.setProperty(tvalue.substring(1, tvalue.length() - 1), dvalue);
					} else {
						props.setProperty(tvalue.substring(1), dvalue);
					}
				} else {
					if (!(dn instanceof Text && dn.getNodeValue().equals(tvalue))) {
						throw new RuntimeException("Literals do not match: " + tvalue + " != " + dn.getNodeValue());
					}
					dn = dn.getNextSibling();
				}
			} else if (tn instanceof Element) {
				boolean sameElem = false;
				if (dn instanceof Element && dn.getNodeName().equals(tn.getNodeName())) {
					NamedNodeMap ta = ((Element) tn).getAttributes();
					NamedNodeMap da = ((Element) dn).getAttributes();
					if (ta.getLength() == da.getLength()) {
						sameElem = true;
						for (int i = 0; i < ta.getLength(); i++) {
							String key = ta.item(i).getNodeName();
							String tvalue = ((Element) tn).getAttribute(key);
							String dvalue = ((Element) dn).getAttribute(key);
							if (!tvalue.equals(dvalue)) {
								sameElem = false;
								break;
							}
						}
					}
				}
				if (sameElem) {
					handleElement((Element) dn, (Element) tn, props, numericProperties);
					dn = dn.getNextSibling();
				} else if (tn.getFirstChild() instanceof Text && tn.getFirstChild().getNextSibling() == null) {
					String tcvalue = tn.getFirstChild().getNodeValue();
					if (tcvalue.startsWith("$") && tcvalue.endsWith("?")) {
						props.setProperty(tcvalue.substring(1, tcvalue.length() - 1), "--");
					} else {
						throw new RuntimeException("Unmatched elements: " + tn + " != " + dn);
					}
				}
			} else {
				throw new RuntimeException("Unsupported element: " + tn);
			}
		}
		if (dn != null)
			throw new RuntimeException("Unmatched node: " + dn);
	}

	private static void writeSection(BufferedWriter bw, String headline, List<String> lines) throws IOException {
		bw.write("\n# " + headline + "\n");
		Collections.sort(lines);
		for (String line : lines) {
			bw.write(line + "\n");
		}
	}
}
