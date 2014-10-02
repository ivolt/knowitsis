package knowitsis.service;

import java.util.Map;

import org.jdom2.Document;

public interface ICalculatorService {
	public Map<String, Double> getStudentAverageGrade(Document inputGrades);
	public Double weightedAverageCalculator(Map<String, Double> studentsAverage);
}
