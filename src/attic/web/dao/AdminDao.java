package attic.web.dao;

import attic.web.model.Admin;

public interface AdminDao {
	    Admin select(Admin entity);  
	    boolean insert(Admin entity);  
}
