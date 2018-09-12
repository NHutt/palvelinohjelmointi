package hh.palvelinohjelmointi.bookstore.web;

import hh.palvelinohjelmointi.bookstore.domain.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
		public String getNewBook(Model model) {
			model.addAttribute("book", new Book());
			
			return "bookthingy";
		}
	}


