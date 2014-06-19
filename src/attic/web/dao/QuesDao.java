package attic.web.dao;

import java.util.ArrayList;

import attic.web.model.Question;

public interface QuesDao {
	public ArrayList<Question> select(String subject,int unit);
	 public  Question selectById(int id);
}
