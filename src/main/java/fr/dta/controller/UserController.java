package fr.dta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import fr.dta.dao.UserService;
import fr.dta.model.User;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView display() {
		//List<User> list = userdao.getAll();
		User user = new User();
		user.setId(4);
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("user", user);
		mv.addObject("users", userService.getAll());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String validation(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,Model mv) {
		if (bindingResult.hasErrors()) {
			System.out.println("failed "+bindingResult.getAllErrors());
		}
		else{
			System.out.println(user.getId());
			userService.add(user);
			mv.addAttribute("users", userService.getAll());
		}
		return "user";
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
