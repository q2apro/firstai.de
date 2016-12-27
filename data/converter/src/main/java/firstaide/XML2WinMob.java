package firstaide;

import static firstaide.LanguageXMLFile.h;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * Generate Windows Mobile HTML files from XML files.
 */
public class XML2WinMob {

	public static void main(String[] args) throws Exception {
		EmergencyNumberXMLFile sosNumbers = new EmergencyNumberXMLFile(new File("../xml/emergencyNumbers.xml"));
		if (args.length == 0)
			args = "de en fr lt vi".split(" ");
		for (String lang : args) {
			System.out.println("--" + lang + "--");
			LanguageXMLFile language = new LanguageXMLFile(new File("../xml/lang-" + lang + ".xml"), Locale.forLanguageTag(lang));
			try (BufferedReader br = new BufferedReader(new InputStreamReader(XML2WinMob.class.getResourceAsStream("/winmob-template.txt"), StandardCharsets.UTF_8));
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../../winmobile-html-version/firstaid" + lang.toUpperCase() + ".html"), StandardCharsets.UTF_8))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.equals("${MENU}")) {
						for (Map.Entry<String, String> entry : language.getMenuEntries().entrySet()) {
							bw.write("        <li><a href=\"#toptoolbar\" onclick=\"showAid('" + entry.getValue() + "')\">" + h(entry.getKey()) + "</a></li>\n");
						}
					} else if (line.equals("${SOFTWARECOPYRIGHT}")) {
						if (!language.getString("translatorCopyright").isEmpty())
							bw.write(h(language.getString("softwareCopyright")) + "<br />" + h(language.getString("translatorCopyright")) + "<br /><br />\n");
						else
							bw.write(h(language.getString("softwareCopyright")) + "<br /><br />\n");
					} else if (line.equals("${SECTIONS}")) {
						for (String id : language.getSectionIDs()) {
							Element section = language.getSection(id);
							boolean stepOpen = false;
							for (Node n = section.getFirstChild(); n != null; n = n.getNextSibling()) {
								Element elem = (Element) n;
								if (elem.getNodeName().equals("title")) {
									bw.write("<ul id=\"" + id + "\" title=\"" + h(elem.getTextContent()) + "\"><h3>" + h(elem.getTextContent()) + "</h3>");
									if (!section.getAttribute("headImage").isEmpty())
										bw.write("<br /><img src=\"images/aid" + String.format("%03d", Integer.parseInt(section.getAttribute("headImage"))) + ".png\" />");
								} else if (elem.getNodeName().equals("altTitle")) {
									// handled for the menu already
								} else if (elem.getNodeName().equals("audio")) {
									// no audio support
								} else if (elem.getNodeName().equals("description")) {
									if (stepOpen) {
										bw.write("</li></ol>");
										stepOpen = false;
									}
									bw.write("\n<p>" + h(elem.getTextContent()) + "</p>");
								} else if (elem.getNodeName().equals("subsection")) {
									if (stepOpen) {
										bw.write("</li></ol>");
										stepOpen = false;
									}
									bw.write("\n<p><b>" + h(elem.getTextContent()) + "</b></p>");
								} else if (elem.getNodeName().equals("image")) {
									String filename = "aid" + elem.getAttribute("file") + ".png";
									if (filename.equals("aid111.png"))
										filename = "aid111.jpg";
									bw.write(" <br /><img src=\"images/" + filename + "\" />");
								} else if (elem.getNodeName().equals("step")) {
									if (stepOpen)
										bw.write("</li>");
									bw.write('\n');
									if (!stepOpen) {
										bw.write("<ol>");
										stepOpen = true;
									}
									bw.write("<li>");
									for (Node sub = elem.getFirstChild(); sub != null; sub = sub.getNextSibling()) {
										if (sub instanceof Text) {
											bw.write(h(sub.getNodeValue()));
											continue;
										}
										Element se = (Element) sub;
										bw.write("<a href=\"#toptoolbar\" onclick=\"showAid('" + se.getAttribute("target") + "')\">" + h(se.getTextContent()) + "</a>");
									}
								}
							}
							bw.write("</li></ol><br /><a id=\"backButton2\" class=\"button\" href=\"#toptoolbar\" onclick=\"showLast()\">" + h(language.getString("iPhoneBackButton")) + "</a><br /><br /></ul>\n");
						}
					} else if (line.equals("${EMERGENCYNUMBERS}")) {
						bw.write(" <ul id=\"telEmergency\" title=\"" + h(language.getString("continent")) + "\">");
						List<String> sortedContinents = sosNumbers.getContinents();
						sortedContinents.sort(Comparator.comparing(cn -> language.getString("continent_" + cn), Collator.getInstance(language.getLocale())));
						for (String sc : sortedContinents) {
							bw.write("\n  <li><a href=\"#toptoolbar\" onclick=\"showAid('tel" + sc + "')\">" + h(language.getString("continent_" + sc)) + "</a></li>");
						}
						bw.write(" <img src=\"images/aid002.png\" />\n");
						bw.write("</ul>\n");
						bw.write("\n\n");
						List<String> allCountries = new ArrayList<>();
						for (String continent : sosNumbers.getContinents()) {
							bw.write("<ul id=\"tel" + continent + "\" title=\"" + h(language.getString("continent_" + continent)) + "\">\n");
							List<String> sortedCountries = sosNumbers.getCountries(continent);
							sortedCountries.sort(Comparator.comparing(c -> language.getString("country_" + c), Collator.getInstance(language.getLocale())));
							for (String c : sortedCountries) {
								allCountries.add(c);
								bw.write("<li><a href=\"#toptoolbar\" onclick=\"showAid('" + c + "')\">" + h(language.getString("country_" + c)) + "</a></li>\n");
							}
							bw.write("</ul>\n");
						}
						bw.write("\n\n<!-- ALL COUNTRIES WITH EMERGENCY NUMBERS -->\n\n");
						for (String cc : allCountries) {
							String[] numbers = sosNumbers.getNumbers(cc);
							bw.write("<ul id=\"" + cc + "\" title=\"" + h(language.getString("country_" + cc)) + "\"><h3>" + h(language.getString("country_" + cc)) + "</h3><ol>");
							bw.write(formatNumber(language, "emergency_fire", numbers[0]));
							bw.write(formatNumber(language, "emergency_medical", numbers[1]));
							bw.write(formatNumber(language, "emergency_police", numbers[2]));
							if (!numbers[3].isEmpty() && !language.getString("emergency_cancelcard").isEmpty())
								bw.write(formatNumber(language, "emergency_cancelcard", numbers[3]));
							bw.write("</ol></ul>\n");
						}
					} else {
						bw.write(language.replaceVariables(line));
						bw.write('\n');
					}
				}
			}
		}
	}

	public static String formatNumber(LanguageXMLFile language, String label, String number) {
		String html;
		if (number.equals("none"))
			html = "(--)";
		else if (number.equals("local") || number.equals("nosystem") || number.equals("radioonly"))
			html = "(" + h(language.getString("emergency_" + number)) + ")";
		else if (number.matches("[0-9]+"))
			html = "<a href=\"tel:" + number + "\">(" + number + ")</a>";
		else if (number.matches("[0-9]+:(mobile|tourist|):[0-9]+")) {
			String[] parts = number.split(":");
			String suffix = "";
			if (!parts[1].isEmpty())
				suffix = " " + h(language.getString("emergency_" + parts[1]));
			html = "<a href=\"tel:" + parts[0] + "\">(" + parts[0] + ")</a> " + h(language.getString("emergency_or")) + " <a href=\"tel:" + parts[2] + "\">(" + parts[2] + suffix + ")</a>";
		} else {
			throw new RuntimeException(number);
		}
		return "<li>" + h(language.getString(label)) + " " + html + "</li>";
	}
}
