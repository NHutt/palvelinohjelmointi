package hh.palvelinohjelmointi.helloAge.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.palvelinohjelmointi.helloAge.domain.Message;

@Controller
public class MessageController {

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greetingAge(@RequestParam(name="name") String name, 
			@RequestParam(name="age") int age, Model model) {
    	
        model.addAttribute("message", new Message(name, age));
        return "hello";
    }
    
}