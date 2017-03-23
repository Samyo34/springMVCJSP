package fr.dta.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.dta.model.User;

@Service
public class UserDao {
	
	private static List<User> users = new ArrayList<>();
	
	public UserDao() {}
	
	private static UserDao INSTANCE = null;
	
	public static UserDao getInstance(){
		if(INSTANCE == null){
			INSTANCE = new UserDao();
		}
		
		return INSTANCE;
	}
	
	public User get(int id){
		User res = null;
		for (User user : users) {
			if(user.getId() == id){
				res = user;
				break;
			}
		}
		
		return res;
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public void create(User u){
		users.add(u);
	}
	
	public void udpate(int id,User u){
		for (User user : users) {
			if(user.getId() == id){
				users.set(users.indexOf(user), u);
				break;
			}
		}
	}
	
	public void delete(int id){
		for (User user : users) {
			if(user.getId() == id){
				users.remove(user);
				break;
			}
		}
	}
}

