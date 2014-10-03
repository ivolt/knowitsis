package junit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import knowitsis.service.CalculatorService;
import knowitsis.service.interfaces.ICalculatorService;

import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCalculator {
	@Autowired
	ICalculatorService calculatorService = new CalculatorService();
	private String name;
	private String grade1;
	private String grade2;
	private String grade3;
	private String grade4;
	
	//Name must be TestStudent 1
	//AvgGrade must be 4.0
	@Test(timeout = 1000)
	public void wholeNumberTestAverage() {
		String nameFromMap = "";
		Double avgGradeFromMap = 0.0;
		name = "TestStudent 1";
		grade1 = "4";
		grade2 = "4";
		grade3 = "4";
		grade4 = "4";
		Element testStudent = getTestStudent(name, grade1, grade2, grade3, grade4);
		Document studentTestDoc = new Document(testStudent);
		Map<String, Double> resultMap = calculatorService.getStudentAverageGrade(studentTestDoc);
		for (Map.Entry<String, Double> testStudentsMap : resultMap.entrySet()) {
			nameFromMap = testStudentsMap.getKey();
			avgGradeFromMap = testStudentsMap.getValue();
		}
		assertTrue(nameFromMap.equals("TestStudent 1"));
		assertTrue(avgGradeFromMap == 4.0);
	}
	
	//Name must be TestStudent 2
	//AvgGrade must be 4.5
	@Test(timeout = 1000)
	public void decimalPointNumberTestAverage() {
		String nameFromMap = "";
		Double avgGradeFromMap = 0.0;
		name = "TestStudent 2";
		grade1 = "5";
		grade2 = "5";
		grade3 = "5";
		grade4 = "3";
		Element testStudent = getTestStudent(name, grade1, grade2, grade3, grade4);
		Document testStudentDoc = new Document(testStudent);
		Map<String, Double> resultMap = calculatorService.getStudentAverageGrade(testStudentDoc);
		for (Map.Entry<String, Double> testStudentsMap : resultMap.entrySet()) {
			nameFromMap = testStudentsMap.getKey();
			avgGradeFromMap = testStudentsMap.getValue();
		}
		assertTrue(nameFromMap.equals("TestStudent 2"));
		assertTrue(avgGradeFromMap == 4.5);
	}
	
	//Weighted average must be 4.3
	@Test(timeout = 1000)
	public void decialPointWeightedAverageTest() {
		Double result = 0.0;
		Map<String, Double> testStudentAverageMap = new HashMap<String, Double>();
		testStudentAverageMap.put("student 1", 5.0);
		testStudentAverageMap.put("student 2", 4.0);
		testStudentAverageMap.put("student 3", 4.5);
		testStudentAverageMap.put("student 4", 5.0);
		testStudentAverageMap.put("student 5", 3.0);
		result = calculatorService.weightedAverageCalculator(testStudentAverageMap);
		assertTrue(result == 4.3);
	}
	
	//Weighted average must be 4.0
	@Test(timeout = 1000)
	public void wholeNumberWeightedAverageTest() {
		Double result = 0.0;
		Map<String, Double> testStudentAverageMap = new HashMap<String, Double>();
		testStudentAverageMap.put("student 1", 4.0);
		testStudentAverageMap.put("student 2", 4.0);
		testStudentAverageMap.put("student 3", 4.0);
		testStudentAverageMap.put("student 4", 4.0);
		testStudentAverageMap.put("student 5", 4.0);
		result = calculatorService.weightedAverageCalculator(testStudentAverageMap);
		assertTrue(result == 4.0);
	}
	
	
	private Element getTestStudent(String name, String grade1, String grade2, String grade3, String grade4){
		Element student = new Element("grades")
		.addContent(new Element("student")
			.setAttribute("name", name)
			.addContent(new Element("math")
				.addContent(grade1))
			.addContent(new Element("physics")
				.addContent(grade2))
			.addContent(new Element("programming")
				.addContent(grade3))
			.addContent(new Element("Java")
				.addContent(grade4)));
		return student;
	}
}
