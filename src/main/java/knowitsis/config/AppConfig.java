package knowitsis.config;

import knowitsis.service.CalculatorService;
import knowitsis.service.SorterService;
import knowitsis.service.XmlUtilService;
import knowitsis.service.interfaces.ICalculatorService;
import knowitsis.service.interfaces.ISorterService;
import knowitsis.service.interfaces.IXmlUtilService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("knowitsis")
@EnableWebMvc
//@EnableAutoConfiguration
public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	@Bean
	public ICalculatorService calculatorService(){
		return new CalculatorService();
	}
	@Bean
	public IXmlUtilService xmlUtilService(){
		return new XmlUtilService();
	}
	@Bean
	public ISorterService sorterService(){
		return new SorterService();
	}
}
