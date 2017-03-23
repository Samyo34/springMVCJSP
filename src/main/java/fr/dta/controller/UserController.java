package fr.dta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.dta.dao.UserDao;
import fr.dta.model.User;

@Controller
@RequestMapping("api/user")
public class UserController {
	
	@Autowired private UserDao userdao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView display() {
		User user = new User();
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("user", user);
		return mv;
	}

/*	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public User getUser(@PathVariable int id){
		return user.get(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody @Valid User u,BindingResult binRes){
		if(binRes.hasErrors()){
			System.out.println("erreur "+binRes.toString());
		}else{
			user.create(u);
		}
	}
	
	@RequestMapping(value ="{id}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable int id,@Valid User u, BindingResult binRes){
		if(binRes.hasErrors()){
			System.out.println("erreur "+binRes.toString());
		}else{
			user.udpate(id,u);
		}
		
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id, User u){
		user.delete(id);
	}
*/	
}
