package firstaide;

import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * An XML file containing the strings and sectons for the translation into a
 * single language.
 */
public class LanguageXMLFile {

	// HTML escape
	public static String h(String text) {
		return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
	}

	private final Map<String, String> strings = new HashMap<>();
	private final Map<String, Element> sections = new LinkedHashMap<>();
	private final Locale locale;

	public LanguageXMLFile(File file, Locale locale) throws Exception {
		this.locale = locale;
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
		stripWhitespaceNodes(doc.getDocumentElement());
		for (Node n = doc.getDocumentElement().getFirstChild(); n != null; n = n.getNextSibling()) {
			Element elem = (Element) n;
			if (elem.getNodeName().equals("strings")) {
				for (Node nn = elem.getFirstChild(); nn != null; nn = nn.getNextSibling()) {
					Element ee = (Element) nn;
					if (!ee.getNodeName().equals("string")) {
						throw new IOException("Unsupported node: " + ee.getNodeName());
					}
					strings.put(ee.getAttribute("key"), ee.getTextContent());
				}
			} else if (elem.getNodeName().equals("section")) {
				sections.put(elem.getAttribute("id"), elem);
			} else {
				throw new IOException("Unsupported node: " + elem.getNodeName());
			}
		}
	}

	protected static void stripWhitespaceNodes(Element elem) {
		List<Node> whitespaceNodes = new ArrayList<>();
		for (Node n = elem.getFirstChild(); n != null; n = n.getNextSibling()) {
			if (n instanceof Element) {
				stripWhitespaceNodes((Element) n);
			} else if (n instanceof Text && n.getNodeValue().trim().isEmpty()) {
				whitespaceNodes.add(n);
			} else if (n instanceof Comment) {
				whitespaceNodes.add(n);
			}
		}
		for (Node toDelete : whitespaceNodes) {
			elem.removeChild(toDelete);
		}
	}

	public Locale getLocale() {
		return locale;
	}

	public String getString(String key) {
		return strings.get(key);
	}

	public List<String> getSectionIDs() {
		return new ArrayList<>(sections.keySet());
	}

	public Element getSection(String id) {
		return sections.get(id);
	}

	public Map<String, String> getMenuEntries() {
		Map<String, String> unsorted = new HashMap<>();
		for (Element section : sections.values()) {
			String prefix = "";
			if (section.getAttribute("id").equals("aid_general"))
				prefix = "# ";
			for (Node n = section.getFirstChild(); n != null; n = n.getNextSibling()) {
				Element e = (Element) n;
				if (e.getNodeName().equals("title") || e.getNodeName().equals("altTitle")) {
					unsorted.put(prefix + e.getTextContent(), section.getAttribute("id"));
				}
			}
		}
		List<String> labels = new ArrayList<>(unsorted.keySet());
		labels.sort(Comparator.comparing(l -> l.replace("(slight)", "(light)"), Collator.getInstance(locale)));
		Map<String, String> result = new LinkedHashMap<>();
		for (String label : labels) {
			result.put(label, unsorted.get(label));
		}
		return result;
	}

	private static final Pattern VAR_PATTERN = Pattern.compile("\\$\\{([A-Za-z0-9_-]+)\\}");

	public String replaceVariables(String line) {
		if (line.contains("${")) {
			Matcher m = VAR_PATTERN.matcher(line);
			StringBuffer sb = new StringBuffer();
			while (m.find()) {
				m.appendReplacement(sb, "");
				sb.append(h(strings.get(m.group(1))));
			}
			m.appendTail(sb);
			line = sb.toString();
		}
		return line;
	}
}
