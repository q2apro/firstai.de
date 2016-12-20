package firstaide;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * An XML file containing information about emergency numbers.
 */
public class EmergencyNumberXMLFile {

	private final Map<String, List<String>> continents = new LinkedHashMap<>();
	private final Map<String, String[]> emergencyNumbers = new LinkedHashMap<>();

	public EmergencyNumberXMLFile(File file) throws Exception {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
		LanguageXMLFile.stripWhitespaceNodes(doc.getDocumentElement());
		for (Node n = doc.getDocumentElement().getFirstChild(); n != null; n = n.getNextSibling()) {
			Element elem = (Element) n;
			if (!elem.getNodeName().equals("continent"))
				throw new IOException("Unsupported node: " + elem.getNodeName());
			List<String> continent = new ArrayList<>();
			continents.put(elem.getAttribute("id"), continent);
			for (Node nn = elem.getFirstChild(); nn != null; nn = nn.getNextSibling()) {
				Element ee = (Element) nn;
				if (!ee.getNodeName().equals("country")) {
					throw new IOException("Unsupported node: " + ee.getNodeName());
				}
				continent.add(ee.getAttribute("id"));
				String[] numbers = new String[] {
						ee.getAttribute("fire"),
						ee.getAttribute("medical"),
						ee.getAttribute("police"),
						ee.getAttribute("cancelcard")
				};
				emergencyNumbers.put(ee.getAttribute("id"), numbers);
			}
		}
	}

	public List<String> getContinents() {
		return new ArrayList<>(continents.keySet());
	}

	public List<String> getCountries(String continent) {
		return new ArrayList<>(continents.get(continent));
	}

	public String[] getNumbers(String country) {
		return emergencyNumbers.get(country);
	}
}
