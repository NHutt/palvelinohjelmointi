package hh.palvelinohjelmointi.bookstore.web;

import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.bookstore.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository; 
	
	// REST-palvelu, joka palauttaa kaikki kirjat
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) bookRepository.findAll();
    }   
    
	// REST-palvelu, joka palauttaa kirjan tietyllä id:llä
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return bookRepository.findById(bookId);
    	
    	// Optional -> ei tule virheilmoitusta vaan null, jos haetaan id:tä,
    	// joka ei ole käytössä
    }       
	

	/** palauttaa listauksen kaikista tietokannan kirjoista **/
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String getBooklist(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist";
	}
	
	/** poistaa tietyn kirjan id:n perusteella **/
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		
		return "redirect:../booklist";
		
	}
	
	/** palauttaa tyhjän lomakkeen uuden kirjan lisäämiseen **/
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }  
	
	/** tallentaa kirjan tiedot ja palaa listaukseen **/
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }  
	
    /** palauttaa tietyn kirjan editointisivun **/
	@RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", bookRepository.findById(bookId));
        return "editbook";
    }  

}


