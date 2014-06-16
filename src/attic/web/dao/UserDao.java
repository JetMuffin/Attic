package attic.web.dao;

import attic.web.model.User;

public interface UserDao {
	    User select(User entity);  
	    boolean insert(User entity);  
}
