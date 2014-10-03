package knowitsis.controller;

import java.util.Map;

import knowitsis.model.GradesModel;
import knowitsis.service.interfaces.ICalculatorService;
import knowitsis.service.interfaces.ISorterService;
import knowitsis.service.interfaces.IXmlUtilService;

import org.jdom2.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class StudentGradesController {
	GradesModel gradesModel = new GradesModel();
	@Autowired
	IXmlUtilService xmlUtilService;
	@Autowired
	ICalculatorService calculatorService;
	@Autowired
	ISorterService sorterService;
	
	@RequestMapping(value = "/")
	public String indexDisplay(ModelMap model) {
		//Get Test grades
		Document grades = xmlUtilService.getTestXml();
		// Calculate average grade of each student
		Map<String, Double> avgStudentGrades = calculatorService.getStudentAverageGrade(grades);
		gradesModel.setStudentAverageGrades(avgStudentGrades);
		//Sort students
		Map<String, Double> sortedStudents = sorterService.getSortedStudentList(avgStudentGrades);
		gradesModel.setSortedStudentsByGradeAndName(sortedStudents);
		// Calculate weighted average grade of all students
		Double weightedAverage = calculatorService.weightedAverageCalculator(avgStudentGrades);
		gradesModel.setWeightedAverage(weightedAverage);
		return "index";
	}
	
	@RequestMapping(params = "sort", method = RequestMethod.POST)
	public String sortStudents(ModelMap model) {
		model.addAttribute("studentMap", gradesModel.getSortedStudentsByGradeAndName());
		return "index";
	}
	
	@RequestMapping(params = "calc", method = RequestMethod.POST)
	public String calculateWeightedAverage(ModelMap model) {
		model.addAttribute("weighted", gradesModel.getWeightedAverage());
		return "index";
	}
}
