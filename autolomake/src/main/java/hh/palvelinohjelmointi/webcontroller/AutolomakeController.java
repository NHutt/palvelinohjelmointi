package hh.palvelinohjelmointi.webcontroller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Message;
import hh.palvelinohjelmointi.domain.Auto;


@Controller
public class AutolomakeController {
	
		 @RequestMapping(value="/autolomake", method=RequestMethod.GET)
		    public String autolomake(Model model) {
		        model.addAttribute("auto", new Auto());
		        return "autolomake";
	    }

	    @RequestMapping(value="/hello", method=RequestMethod.POST)
	    public String greetingSubmit(@Valid Message msg, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	        	return "autolomake";
	        	
	        }else {
	        
		    	model.addAttribute("message", msg);
		        return "result";
	        
	        }
	    }

}
