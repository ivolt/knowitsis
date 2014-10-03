package knowitsis.service.interfaces;

import java.util.Map;

public interface ISorterService {
	public Map<String, Double> getSortedStudentList(Map<String, Double> avgStudentGrades);
}
