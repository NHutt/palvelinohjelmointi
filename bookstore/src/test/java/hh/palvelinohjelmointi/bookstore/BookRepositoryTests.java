package hh.palvelinohjelmointi.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository bookrepository;
	
	@Test
	public void createNewBook() {
		Book book = new Book("Moro vaan", "Meikalainen", 2018, "450984596", 20.22, new Category("Kauhu"));
		bookrepository.save(book);
		assertThat(book.getId()).isNotNull();
	}  
	
	@Test
	public void deleteBook() {
		Book book = new Book("Moro vaan", "Meikalainen", 2018, "450984596", 20.22, new Category("Kauhu"));
		bookrepository.save(book);
		
		Long id = book.getId();
		
		bookrepository.deleteById(id);
		
		Optional<Book> deletedBook = bookrepository.findById(id);
		assertThat(deletedBook).isEmpty();
	}  
	
	@Test
	public void findBookById() {
		Book book = new Book("Moro vaan", "Meikalainen", 2018, "450984596", 20.22, new Category("Kauhu"));
		bookrepository.save(book);
		
		Long id = book.getId();
		
		assertThat(bookrepository.findById(id)).isNotNull();
	}  

}
