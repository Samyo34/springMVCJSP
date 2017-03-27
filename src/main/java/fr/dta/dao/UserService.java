package fr.dta.dao;


import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fr.dta.model.User;

@Repository
@Service
@Transactional
public class UserService extends AbstractRepository<User>{

	public UserService() {
		super(User.class);
	}

}
