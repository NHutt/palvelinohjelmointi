package hh.palvelinohjelmointi.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.bookstore.domain.Category;
import hh.palvelinohjelmointi.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void createNewCategory() {
		Category kauhu = new Category("Kauhu");
		categoryRepository.save(kauhu);
		assertThat(kauhu.getCategoryId()).isNotNull();
	}  
	
	@Test
	public void deleteCategory() {
		Category kauhu = new Category("Kauhu");
		categoryRepository.save(kauhu);
		
		Long id = kauhu.getCategoryId();
		
		categoryRepository.deleteById(id);
		
		Optional<Category> deletedCategory = categoryRepository.findById(id);
		assertThat(deletedCategory).isEmpty();
	}  
	
	@Test
	public void findCategoryById() {
		Category kauhu = new Category("Kauhu");
		categoryRepository.save(kauhu);
		
		Long id = kauhu.getCategoryId();
		
		assertThat(categoryRepository.findById(id)).isNotNull();
	}  

}

