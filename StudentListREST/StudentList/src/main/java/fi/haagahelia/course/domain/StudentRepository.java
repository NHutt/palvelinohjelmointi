package fi.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource //rajapinnan metodit näkyvät REST -palveluna
public interface StudentRepository extends CrudRepository<Student, Long> {

	//http://localhost:8080/restapi/students/search/findByLastName?lastname=Johnson
    List<Student> findByLastName(@Param(value="lastname") String lastName);
    
}