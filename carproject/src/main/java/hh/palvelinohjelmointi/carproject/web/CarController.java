package hh.palvelinohjelmointi.carproject.web;

import hh.palvelinohjelmointi.carproject.domain.Car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {
	
	// tyhjän autolomakkeen muodostaminen
	@RequestMapping(value="/newcar", method=RequestMethod.GET)
	public String getNewCarForm(Model model){
		model.addAttribute("car", new Car());  // "tyhjä" auto-olio
		return "carform";
	}
	
	
	// autolomakeella syötettyjen tietojen vastaanotto
	@RequestMapping(value="/newcar", method=RequestMethod.POST)
	public String getNewCarForm(@ModelAttribute Car car, Model model){
		model.addAttribute("car", car);
		return "carresult";
	}

}
