package attic.web.dao;

import java.util.ArrayList;

import attic.web.model.PracComplt;

public interface PracCompltDao {
	public ArrayList<PracComplt> select(String uid);
	public int selectCount(String subject);
	public boolean insert(PracComplt pc);
	public PracComplt selectUnit(String uid,String subject,int unit);
}
