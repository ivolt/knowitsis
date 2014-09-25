package weighted_average;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlReader {
	/**
	 * Returns Document that is read from studentsGrades.xml file under
	 * resources folder
	 * 
	 * @return Document
	 */
	public static Document getXml() {
		SAXBuilder saxBuilder = new SAXBuilder();
		// get file
		File file = new File("src/main/resources/studentsGrades.xml");
		// converted file to document
		Document docResponse = null;
		try {
			docResponse = saxBuilder.build(file);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return docResponse;
	}
}
