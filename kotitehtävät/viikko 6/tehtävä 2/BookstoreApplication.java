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
import hh.palvelinohjelmointi.bookstore.domain.User;
import hh.palvelinohjelmointi.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("muutama testikirja incoming");
			
			categoryRepository.save(new Category("Psykologia"));
			categoryRepository.save(new Category("Lastenkirjallisuus"));
			repository.save(new Book("Idiootit ympärilläni - kuinka ymmärtää muita ja itseään", "Thomas Erikson", 2017, "9789523003217", 19.95, 
					categoryRepository.findByName("Psykologia").get(0)));
			repository.save(new Book("Herra Hakkarainen kyläilee", "Mauri Kunnas", 2018 , "9789511328254", 19.95,
					categoryRepository.findByName("Lastenkirjallisuus").get(0)));	
			
			// Luodaan käyttäjät tavallinenPulliainen/juuhmoi ja herraIsoherra/nojoohei
			// joiden tunnukset eivät kuitenkaan valitettavasti toimi :<
			// konsoliin tulee varoitus o.s.s.c.bcrypt.BCryptPasswordEncoder     : Encoded password does not look like BCrypt
			User user1 = new User("tavallinenPulliainen", "$2y$12$ThM/Kt7ivKWQyywGcIYmBudlFUXTh4awRpXU8UGzlathZS0Po8WK2", "juuh@moi.fi", "USER");
			User user2 = new User("herraIsoherra", "$2y$12$JY4agADPsB5PUSUb4HZJF.gbhoMY0r02Cz/DMYgLlWMXlgrlpxF.q", "nojoo@hei.com", "ADMIN");
		
			// Luodaan käyttäjät user/user ja admin/admin
			// nämä tunnukset taas toimivat niinkuin pitääkin
			User user3 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "edfrfqae", "USER");
			User user4 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "wesgwsh", "ADMIN");
				
				userRepository.save(user1);
				userRepository.save(user2);
				userRepository.save(user3);
				userRepository.save(user4);
			
			log.info("haetaan kaikki kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("haetaan kaikki käyttäjät");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}

		};
	}
}
