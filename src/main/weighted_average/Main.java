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
		Main main = new Main();
		Calculators calculators = new Calculators();
		XmlReader xmlReader = new XmlReader();
		Sorters sorters = new Sorters();
		DecimalFormat formatter = new DecimalFormat("#0.0");
		
		// Get data from xml file
		Document studentGradesDoc = xmlReader.getXml();
		// Calculate average grade of each student
		Map<String, Double> avgStudentGrades = calculators
				.studentAverageGradeCalculator(studentGradesDoc);
		// Calculate weighted average grade of all students
		Double weightedAverage = calculators
				.weightedAverageCalculator(avgStudentGrades);
		// Prints Student name and their average grade
		main.printMap(sorters.getSortedStudentList(avgStudentGrades));
		// Prints weighted average
		System.out.println("Weighted average of all students: "
				+ formatter.format(weightedAverage));
	}
	
	private void printMap (Map<String,Double> map) {
		DecimalFormat formatter = new DecimalFormat("#0.0");
		for (Map.Entry<String, Double> entry : map.entrySet())  {
			System.out.println("Student: " + entry.getKey()
							+ " Average grade: "+ formatter.format(entry.getValue()));
		}
	}
}
