package firstaide;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

/**
 * Generate JavaScript files (for HTML5 offline version) from XML files.
 */
public class XML2JS {

	private static String DISCLAIMER_TEMPLATE = "<section audio=\"0.mp3\" id=\"aid_disclaimer\">" +
			"<title>${disclaimerTitle}</title>" +
			"<subsection>${softwareHeader}</subsection>" +
			"<description>${softwareName}</description>" +
			"<description>${softwareCopyright}</description>" +
			"<description>${translatorCopyright}</description>" +
			"<description>${softwareLicense}</description>" +
			"<image file=\"__cc88x31\"/>" +
			"<description>${softwareNotice}</description>" +
			"<description>${softwareIllustrations} © Med4Teens</description>" +
			"<subsection>${disclaimerHeader}</subsection>" +
			"<description>${disclaimerNotice1}</description>" +
			"<description>${disclaimerNotice2}</description>" +
			"<description>${disclaimerNotice3}</description>" +
			"<description>${disclaimerNotice4}</description>" +
			"<subsection>${slogan}</subsection>" +
			"</section>";

	public static void main(String[] args) throws Exception {
		EmergencyNumberXMLFile sosNumbers = new EmergencyNumberXMLFile(new File("../xml/emergencyNumbers.xml"));
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../../html5-offline-version/sosnumbers.js"), StandardCharsets.UTF_8))) {
			bw.write("// Generated file, do not edit\n");
			bw.write("var sosContinents={");
			boolean first = true;
			List<String> allCountries = new ArrayList<>();
			for (String continent : sosNumbers.getContinents()) {
				if (!first)
					bw.write(",");
				bw.write("\n\t" + continent + ": [");
				first = true;
				for (String country : sosNumbers.getCountries(continent)) {
					if (!first)
						bw.write(", ");
					first = false;
					bw.write(js(country));
					allCountries.add(country);
				}
				bw.write("]");
				first = false;
			}
			bw.write("\n};\n");
			bw.write("var sosNumbers = {");
			first = true;
			for (String country : allCountries) {
				if (!first)
					bw.write(",");
				first = false;
				String[] numbers = sosNumbers.getNumbers(country);
				bw.write("\n\t" + js(country) + ": {fire: " + js(numbers[0]) + ", medical: " + js(numbers[1]) + ", police: " + js(numbers[2]));
				if (!numbers[3].isEmpty())
					bw.write(", cancelcard: " + js(numbers[3]));
				bw.write("}");
			}
			bw.write("\n};\n");
		}

		if (args.length == 0)
			args = "de en fr pt lt vi cz es it pl zh".split(" ");

		for (String lang : args) {
			System.out.println("--" + lang + "--");
			LanguageXMLFile language = new LanguageXMLFile(new File("../xml/lang-" + lang + ".xml"), Locale.forLanguageTag(lang));
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../../html5-offline-version/lang-" + lang + ".js"), StandardCharsets.UTF_8))) {
				bw.write("//:" + language.getString("title") + "\n");
				bw.write("// Generated file, do not edit\n");
				boolean first = true;
				bw.write("var langTexts={");
				for (String key : Arrays.asList("title", "back", "continent", "emergency_fire", "emergency_medical", "emergency_police", "emergency_cancelcard", "emergency_local", "emergency_nosystem", "emergency_radioonly", "emergency_none", "emergency_or", "emergency_mobile", "emergency_tourist")) {
					if (!first)
						bw.write(",");
					first = false;
					bw.write("\n\t" + key + ": " + js(language.getString(key)));
				}
				bw.write("\n};\n");
				bw.write("var langMenu=[\n");
				bw.write("\t{h: " + js("#aid_disclaimer") + ", t: " + js(language.getString("disclaimerMenuTitle")) + "},\n");
				bw.write("\t{h: " + js("#numbers") + ", t: " + js(language.getString("emergencyNumbersMenuTitle")) + "},\n");
				for (Map.Entry<String, String> entry : language.getMenuEntries().entrySet()) {
					bw.write("\t{h: " + js("#" + entry.getValue()) + ", t: " + js(entry.getKey()) + "},\n");
				}
				bw.write("\t{h: " + js("tel:112") + ", t: " + js(language.getString("dial112")) + "}\n];\n");
				String replaced = language.replaceVariables(DISCLAIMER_TEMPLATE).replace("<description></description>", "");
				Element disclaimerElem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(replaced))).getDocumentElement();
				List<String> sections = language.getSectionIDs();
				sections.add(0, "aid_disclaimer");
				bw.write("var langSections={");
				first = true;
				for (String id : sections) {
					Element section = id.equals("aid_disclaimer") ? disclaimerElem : language.getSection(id);
					if (!first)
						bw.write(",");
					bw.write("\n\t" + id + ": [");
					first = true;
					for (Node n = section.getFirstChild(); n != null; n = n.getNextSibling()) {
						Element elem = (Element) n;
						if (elem.getNodeName().equals("altTitle") || elem.getTagName().equals("audio"))
							continue;
						if (!first)
							bw.write(',');
						bw.write("\n\t\t{k: " + js(elem.getNodeName()));
						if (elem.getNodeName().equals("title")) {
							bw.write(", t: " + js(elem.getTextContent()));
							if (!section.getAttribute("headImage").isEmpty())
								bw.write(", i: " + js("aid" + String.format("%03d", Integer.parseInt(section.getAttribute("headImage")))));
						} else if (elem.getNodeName().equals("description") || elem.getNodeName().equals("subsection")) {
							bw.write(", t: " + js(elem.getTextContent()));
						} else if (elem.getNodeName().equals("image")) {
							if (elem.getAttribute("file").startsWith("__"))
								bw.write(", i: " + js(elem.getAttribute("file").substring(2)));
							else
								bw.write(", i: " + js("aid" + elem.getAttribute("file")));
						} else if (elem.getNodeName().equals("step")) {
							bw.write(", p: [");
							first = true;
							for (Node sub = elem.getFirstChild(); sub != null; sub = sub.getNextSibling()) {
								if (!first)
									bw.write(", ");
								if (sub instanceof Text) {
									bw.write("{t: " + js(sub.getNodeValue()) + "}");
								} else {
									Element se = (Element) sub;
									bw.write("{t: " + js(se.getTextContent()) + ", h: " + js("#" + se.getAttribute("target")) + "}");
								}
								first = false;
							}
							bw.write("]");
						}
						bw.write("}");
						first = false;
					}
					bw.write("\n\t]");
					first = false;
				}
				bw.write("\n};\n");
				bw.write("var langContinents=[");
				List<String> sortedContinents = sosNumbers.getContinents();
				List<String> sortedCountries = new ArrayList<>();
				sortedContinents.sort(Comparator.comparing(cn -> language.getString("continent_" + cn), Collator.getInstance(language.getLocale())));
				first = true;
				for (String sc : sortedContinents) {
					if (!first)
						bw.write(',');
					first = false;
					bw.write("\n\t{i: " + js(sc) + ", t: " + js(language.getString("continent_" + sc)) + "}");
					sortedCountries.addAll(sosNumbers.getCountries(sc));
				}
				bw.write("\n];\n");
				sortedCountries.sort(Comparator.comparing(c -> language.getString("country_" + c), Collator.getInstance(language.getLocale())));
				bw.write("var langCountries=[");
				first = true;
				for (String sc : sortedCountries) {
					if (!first)
						bw.write(',');
					first = false;
					bw.write("\n\t{i: " + js(sc) + ", t: " + js(language.getString("country_" + sc)) + "}");
				}
				bw.write("\n];\n");
			}
		}
	}

	private static String js(String str) {
		return "\"" + str.replace("\\", "\\\\").replace("\n", "\\n").replace("\"", "\\\"") + "\"";
	}
}
