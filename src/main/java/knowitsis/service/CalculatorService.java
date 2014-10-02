package knowitsis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.stereotype.Component;

@Component
public class CalculatorService implements ICalculatorService {
	
	/**
	 * Calculates the average grade of student
	 * 
	 * @param Document studentsGradesDoc
	 * @return Map<String, Double>
	 */
	public Map<String, Double> getStudentAverageGrade(Document inputGrades) {
		Map<String, Double> studentAverageMap = new HashMap<String, Double>();
		Element studentGradesEl = inputGrades.getRootElement();
		List<Element> students = studentGradesEl.getChildren("student");
		// Goes through students list
		for (Element student : students) {
			Integer grade = 0;
			String studentName = student.getAttributeValue("name");
			List<Element> topics = student.getChildren();
			// Goes through topics and adds up given grades
			for (Element topic : topics) {
				String topicGrade = topic.getValue();
				grade = grade + Integer.parseInt(topicGrade);
			}
			Integer topicsNumber = topics.size();
			// Calculate the average grade of student
			Double averageGrade = grade.doubleValue()
					/ topicsNumber.doubleValue();
			studentAverageMap.put(studentName, averageGrade);
		}
		return studentAverageMap;
	}
	
	/**
	 * Calculates the average grade of all students
	 * 
	 * @param Map<String, Double> studentsAverage
	 * @return Integer
	 */
	public Double weightedAverageCalculator(Map<String, Double> studentsAverage) {
		Double weightedAverage = 0.0;
		Double gradesSum = 0.0;
		Integer studentCount = studentsAverage.size();
		//Gets the grade SUM
		for (Map.Entry<String, Double> entry : studentsAverage.entrySet()) {
			gradesSum = gradesSum + entry.getValue();
		}
		//Calculates the average
		weightedAverage = gradesSum / studentCount;
		return weightedAverage;
	}
}
