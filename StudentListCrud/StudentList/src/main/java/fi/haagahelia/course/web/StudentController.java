package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	// metodi palauttaa opiskelijalistauksen
	// osoitteesta http:localhost:8080/studentlist
	
	//@GetMapping("/studentlist")
	@RequestMapping(value="/studentlist", method=RequestMethod.GET)
	public String getStudents(Model model) {
		// haetaan opiskelijatiedot tietokannasta
		model.addAttribute("students", studentRepository.findAll());
		
		return "studentlist"; //palautetaan servletille
		// studentlist.html-templaten nimi ilman tietopäätettä.
		// Servletti kutsuu templatea, joka generoi palvelimella dynaamisesti
		// selaimelle lähtevän html-dokumentin
		
	}
	
	// metodi poistaa tietokannasta yhden opiskelijan, kun se saa poistettavan
	// opiskelijan id-arvon
	// esim. localhost:8080/delete/3
	
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long studentId) {
		//pyydetään poistamaan tietokannasta opiskelija tietyllä id:llä
		studentRepository.deleteById(studentId);
		
		return "redirect:../studentlist";
		
	}
	
	/*
	@Autowired
	private StudentRepository repository; 
	
    @RequestMapping(value="/studentlist")
    public String studentList(Model model) {	
        model.addAttribute("students", repository.findAll());
        return "studentlist";
    }
    
    */
  
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("student", new Student());
        return "addstudent";
    }  
    
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Student student){
        studentRepository.save(student);
        return "redirect:studentlist";
    }  
    
     /*

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
    	repository.deleteById(studentId);
        return "redirect:../studentlist";
    }  
    
       */
}
