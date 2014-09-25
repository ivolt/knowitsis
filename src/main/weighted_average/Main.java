package weighted_average;

import java.text.DecimalFormat;
import java.util.Map;

import org.jdom2.Document;

public class Main {
	/**
	 * Main class that prints to console: Students name and the average grade
	 * Weighted average of all students
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Get data from xml file
		Document studentGradesDoc = XmlReader.getXml();
		// Calculate average grade of each student
		Map<String, Double> avgStudentGrades = Calculators
				.studentAverageGradeCalculator(studentGradesDoc);
		// Calculate weighted average grade of all students
		Double weightedAverage = Calculators
				.weightedAverageCalculator(avgStudentGrades);
		// Prints Student name and their average grade
		Sorters.printStudentListSorted(avgStudentGrades);
		// Prints weighted average
		DecimalFormat formatter = new DecimalFormat("#0.0");
		System.out.println("Weighted average of all students: "
				+ formatter.format(weightedAverage));
	}
}
