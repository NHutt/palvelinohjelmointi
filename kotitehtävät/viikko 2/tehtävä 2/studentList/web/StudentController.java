package hh.palvelinohjelmointi.studentList.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.palvelinohjelmointi.studentList.domain.Student;


@Controller
public class StudentController {
	
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String heyStudents(Model model){
    	
    	ArrayList<Student> lista = new ArrayList<Student>();
    	lista.add(new Student("Noora", "Huttunen", "nhutt@gmail.com"));
    	lista.add(new Student("Lauri", "Niiniskorpi", "boiii@gmail.com"));
    	lista.add(new Student("Hurdels", "Durdels", "mjau@gmail.com"));
		model.addAttribute("studentList", lista);
		return "helloStudents";
	}

}
