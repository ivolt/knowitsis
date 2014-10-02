package knowitsis.controller;

import knowitsis.model.GradesModel;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartPageController {
	private GradesModel gradesModel = new GradesModel ();
	
	@RequestMapping(value = "/")
	public String printHello(ModelMap model) {
		Document testCalculationData = testGradeData();
		String message = "Upload the XML from this projects resources folder or press calculate putton to get the weighted average on test data";

		model.addAttribute("message", message);


		return "index";
	}

	private Document testGradeData () {
		Element testGradeEl = new Element("grades")
				.addContent(new Element("student")
					.setAttribute("name", "Aike")
					.addContent(new Element("topic1").addContent("5"))
					.addContent(new Element("topic2").addContent("3"))
					.addContent(new Element("topic3").addContent("4"))
				.addContent(new Element("student")
					.setAttribute("name", "Nike")
					.addContent(new Element("topic1").addContent("2"))
					.addContent(new Element("topic2").addContent("3"))
					.addContent(new Element("topic3").addContent("4"))
				.addContent(new Element("student")
					.setAttribute("name", "Bike")
					.addContent(new Element("topic1").addContent("1"))
					.addContent(new Element("topic2").addContent("2"))
					.addContent(new Element("topic3").addContent("3"))
						)));
		return new Document(testGradeEl);
	}

	public GradesModel getGradesModel() {
		return gradesModel;
	}
	public void setGradesModel(GradesModel gradesModel) {
		this.gradesModel = gradesModel;
	}
}
