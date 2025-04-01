package tw.blackcat.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
 @Autowired
 private UsersRepositor usersRepositor;
 
 public boolean checklogin(Users users) {
	  Users resultBean= usersRepositor.findByUsername(users.getUsername());
	  if(resultBean!=null) {
		  return true;
	  }
	return false;
}
}
