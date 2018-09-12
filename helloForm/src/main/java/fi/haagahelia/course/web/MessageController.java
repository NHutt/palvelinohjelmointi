package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Message;

@Controller
public class MessageController {

	// tuottaa tyhjän message-lomakkeen selaimeen
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("message", new Message());
        return "hello"; //hello.html Thymeleaf-templaten nimi
    }

    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Message msg, Model model) {
        model.addAttribute("message", msg);
        return "result";
    }

}