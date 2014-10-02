package weighted_average_console;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Sorters {

	/**
	 * Sorts students first by grade if grade is same then by name
	 * 
	 * @param avgStudentGrades
	 */
	public Map<String, Double> getSortedStudentList(
			Map<String, Double> avgStudentGrades) {
		Map<String, Double> unSortedStudentsMap = new TreeMap<String, Double>(avgStudentGrades);
		Map<String, Double> sortedStudentsMap = sortByValues(unSortedStudentsMap);
		return sortedStudentsMap;
	}
	
	
	/**
	 * Method to sort Map in Java by value
     * sort values even if they are duplicates
     * 
	 * @param map
	 * @return map
	 */
    @SuppressWarnings("rawtypes")
	private <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {
            @SuppressWarnings("unchecked")
			@Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        //LinkedHashMap will keep the keys in the order they are inserted
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
