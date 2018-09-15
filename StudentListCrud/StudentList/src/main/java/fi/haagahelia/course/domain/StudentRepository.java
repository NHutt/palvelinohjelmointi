package fi.haagahelia.course.domain;

// huolehtii tietokantakäsittelystä

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	//perii metodit findAll, findById, save, deleteById...

    // List<Student> findByLastName(String lastName);
	// hyvin tärkeää, että metodin nimi juuri oikeassa muodossa
	// etsimiset aina findBy + haettavan muuttujan nimi isolla
	// parametriksi annetaan omavalintainen nimi?
    
}