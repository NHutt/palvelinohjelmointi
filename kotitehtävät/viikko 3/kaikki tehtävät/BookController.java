package hh.palvelinohjelmointi.bookstore.web;

import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
		public String getNewBook(Model model) {
			model.addAttribute("book", new Book());
			
			return "bookstore";
		}

	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String getBooklist(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		
		return "redirect:../booklist";
		
	}
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }  
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }  
	
	@RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", bookRepository.findById(bookId));
        return "editbook";
    }  

}


