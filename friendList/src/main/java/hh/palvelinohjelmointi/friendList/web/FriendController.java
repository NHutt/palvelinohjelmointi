package hh.palvelinohjelmointi.friendList.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.palvelinohjelmointi.friendList.domain.Friend;

@Controller
public class FriendController {
	
	ArrayList<Friend> lista = new ArrayList<Friend>();
	
	// tyhjän lomakkeen muodostaminen
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String getNewFriend(Model model) {
		model.addAttribute("friend", new Friend());  // "tyhjä" auto-olio
		return "friendform";
	}
	
	
	// lomakeella syötettyjen tietojen vastaanotto
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String friendList(@ModelAttribute Friend friend, Model model){
		lista.add(friend);
		model.addAttribute("friendList", lista);
		return "friendform";
	}
	
}
	


