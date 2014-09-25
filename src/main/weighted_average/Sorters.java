package weighted_average;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Sorters {

	/**
	 * Sorts students first by grade if grade is same then by name
	 * 
	 * @param avgStudentGrades
	 */
	public static void printStudentListSorted(
			Map<String, Double> avgStudentGrades) {
		Map<String, Double> unsortedStudentsMap = new TreeMap<String, Double>(
				avgStudentGrades);
		Set<Entry<String, Double>> sortedStudentsSet = unsortedStudentsMap
				.entrySet();
		DecimalFormat formatter = new DecimalFormat("#0.0");
		for (Entry<String, Double> student : sortedStudentsSet) {
			System.out.println("Student: " + student.getKey()
							+ " Average grade: "+ formatter.format(student.getValue()));
		}
	}
}
