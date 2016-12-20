package firstaide;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * Convert Property files (for translation tools) back to XML files.
 */
public class Properties2XML {
	public static void main(String[] args) throws Exception {
		if (args.length == 0)
			args = "de en fr pt lt vi cz es it pl zh".split(" ");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		for (int i = 0; i < args.length; i++) {
			System.out.println("=== " + args[i] + " ===");
			Document doc = builder.parse(new File("../xml/propertytemplate.xml"));
			Properties props = new Properties();
			try (InputStream in = new FileInputStream("../properties/lang-" + args[i] + ".properties")) {
				props.load(in);
			}
			handleElement(doc.getDocumentElement(), props);
			transformer.transform(new DOMSource(doc), new StreamResult(new File("../xml/lang-" + args[i] + ".xml")));
		}
	}

	private static boolean handleElement(Element elem, Properties props) {
		boolean keep = true;
		List<Node> nodesToRemove = new ArrayList<>();
		for (Node n = elem.getFirstChild(); n != null; n = n.getNextSibling()) {
			if (n instanceof Element) {
				if (!handleElement((Element) n, props)) {
					nodesToRemove.add(n);
					if (n.getPreviousSibling() instanceof Text && n.getPreviousSibling().getNodeValue().trim().isEmpty())
						nodesToRemove.add(n.getPreviousSibling());
				}
			} else if (n.getNodeValue().startsWith("$")) {
				String key = n.getNodeValue().substring(1);
				if (key.contains("@")) {
					String[] keyParts = key.split("@");
					String[] parts = props.getProperty(keyParts[0]).split("\\+\\+");
					int idx = Integer.parseInt(keyParts[1]);
					if (idx <= parts.length)
						n.setNodeValue(parts[idx - 1]);
					else
						n.setNodeValue("");
				} else if (key.endsWith("?")) {
					key = key.substring(0, key.length() - 1);
					if (props.getProperty(key, "").equals("--")) {
						n.setNodeValue("");
						keep = false;
					} else {
						n.setNodeValue(props.getProperty(key, ""));
					}
				} else {
					n.setNodeValue(props.getProperty(key, ""));
				}
			}
		}
		for (Node n : nodesToRemove) {
			elem.removeChild(n);
		}
		return keep;
	}
}
