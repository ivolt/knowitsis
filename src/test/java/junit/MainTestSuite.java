package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TestCalculator.class, 
	TestSorter.class,
})
public class MainTestSuite {
}
