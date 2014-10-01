package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.ICalculatorService;


@RestController
@RequestMapping("/data")
public class GradeController {
	@Autowired
	private ICalculatorService calculatorService;
	@RequestMapping("/calculate")
	public Double getWeightedAverage(@RequestParam(value = "id",required = true,defaultValue = "0") Integer id) {
		Person p = personService.getPersonDetail(id);
		return p;
	}
}
