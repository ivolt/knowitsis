package knowitsis.service;

import java.io.IOException;
import java.net.URL;

import knowitsis.service.interfaces.IXmlUtilService;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Component;

@Component
public class XmlUtilService implements IXmlUtilService {
	/**
	 * Returns Document that is read from studentsGrades.xml file under
	 * resources folder
	 * 
	 * @return Document
	 */
	public Document getTestXml() {
		SAXBuilder saxBuilder = new SAXBuilder();
//		File file = new File("src/main/resources/studentsGrades.xml");
		// converted file to document
		Document docResponse = null;
		try {
			ClassLoader loader = this.getClass().getClassLoader();
			URL gradesFile = loader.getResource("studentsGrades.xml");
			docResponse = saxBuilder.build(gradesFile);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return docResponse;
	}
}
