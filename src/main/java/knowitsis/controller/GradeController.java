package knowitsis.controller;

import knowitsis.service.ICalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GradeController {
	@Autowired
	private ICalculatorService calculatorService;
	@RequestMapping("/calculateWithTestData")
	public Double getWeightedAverage(@RequestParam(value = "id",required = true,defaultValue = "0") Integer id) {
		
		return 0.0;
	}
}
