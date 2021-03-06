package junit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import knowitsis.service.SorterService;
import knowitsis.service.interfaces.ISorterService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSorter {
	@Autowired
	private ISorterService sorterService = new SorterService();

	@Test(timeout = 1000)
	public void sorterTest() {
		Map<String, Double> testStudendsAverageMap = new HashMap<String, Double>();
		testStudendsAverageMap.put("XA", 3.0);
		testStudendsAverageMap.put("BB", 4.0);
		testStudendsAverageMap.put("AB", 3.7);
		testStudendsAverageMap.put("ZA", 4.5);
		testStudendsAverageMap.put("AA", 4.0);
		Map<String, Double> resultMap = sorterService.getSortedStudentList(testStudendsAverageMap);
		String resultString = "";
		for (Entry<String, Double> testStudent : resultMap.entrySet()) {
			resultString = resultString + " " +testStudent.getKey() + testStudent.getValue();
		}
		assertTrue(resultString.trim().equals("XA3.0 AB3.7 AA4.0 BB4.0 ZA4.5"));
	}
}
