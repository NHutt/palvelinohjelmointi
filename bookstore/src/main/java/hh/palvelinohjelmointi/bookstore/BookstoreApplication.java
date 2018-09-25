package hh.palvelinohjelmointi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.bookstore.domain.Category;
import hh.palvelinohjelmointi.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("muutama testikirja incoming");
			
			categoryRepository.save(new Category("Psykologia"));
			categoryRepository.save(new Category("Lastenkirjallisuus"));
			repository.save(new Book("Idiootit ympärilläni - kuinka ymmärtää muita ja itseään", "Thomas Erikson", 2017, "9789523003217", 19.95, 
					categoryRepository.findByName("Psykologia").get(0)));
			repository.save(new Book("Herra Hakkarainen kyläilee", "Mauri Kunnas", 2018 , "9789511328254", 19.95,
					categoryRepository.findByName("Lastenkirjallisuus").get(0)));	
			
			log.info("haetaan kaikki kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
