package attic.web.dao;

import attic.web.model.*;

public interface UserDao {
	    User select(User entity);  
	    boolean insert(User entity); 
	    boolean update(User entity);
}
