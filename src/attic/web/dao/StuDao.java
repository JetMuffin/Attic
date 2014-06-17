package attic.web.dao;

import attic.web.model.Student;

public interface StuDao {
	Student select(Student stu);
	boolean insert(Student stu);
	boolean update(Student stu);
}
