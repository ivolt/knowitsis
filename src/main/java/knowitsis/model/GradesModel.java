package knowitsis.model;

import java.util.Map;

import org.jdom2.Document;

public class GradesModel {
	Document inputGrades;
	Map<String, Double> studentAverageGrades;
	Map<String, Double> sortedStudentsByGradeAndName;
	Double weightedAverage;

	public Document getInputGrades() {
		return inputGrades;
	}
	public void setInputGrades(Document inputGrades) {
		this.inputGrades = inputGrades;
	}
	public Map<String, Double> getStudentAverageGrades() {
		return studentAverageGrades;
	}
	public void setStudentAverageGrades(Map<String, Double> studentAverageGrades) {
		this.studentAverageGrades = studentAverageGrades;
	}
	public Map<String, Double> getSortedStudentsByGradeAndName() {
		return sortedStudentsByGradeAndName;
	}
	public void setSortedStudentsByGradeAndName(Map<String, Double> sortedStudentsByGradeAndName) {
		this.sortedStudentsByGradeAndName = sortedStudentsByGradeAndName;
	}
	public Double getWeightedAverage() {
		return weightedAverage;
	}
	public void setWeightedAverage(Double weightedAverage) {
		this.weightedAverage = weightedAverage;
	}
}
