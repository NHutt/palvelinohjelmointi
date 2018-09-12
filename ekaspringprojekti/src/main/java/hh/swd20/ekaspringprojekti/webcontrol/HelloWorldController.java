package hh.swd20.ekaspringprojekti.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorldController {

	// http://localhost:8080/mitävaan
	@RequestMapping("*")
	public String sayHello() {
		return "Hello World and ..... !!";

	}
	// http://localhost:8080/hello?firstname=Tanja&lastname=Bergius
	@RequestMapping("/hello2")
	public String helloYou(@RequestParam(name="firstname") String etunimi, 
			@RequestParam(name="lastname") String sukunimi) {
		return "Hello " + etunimi + " " +sukunimi;
	} 
	
	@RequestMapping("/index")
	public String index() {
		return "This is the main page";
		
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "This is the contact page";
		
	}
	
	@RequestMapping("/hello")
	public String welcome(@RequestParam(name="location") String location, 
			@RequestParam(name="name") String name) {
		return "Welcome to the " + location + " " + name + "!";
	} 
}
