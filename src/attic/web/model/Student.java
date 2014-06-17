package attic.web.model;

public class Student extends User{
	private String name;
	private int sex;
	private String school;
	private String major;
	private String grade;
	private String classes;
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setSex(int sex)
	{
		this.sex=sex;
	}
	public int getSex()
	{
		return sex;
	}
	public void setSchool(String school)
	{
		this.school=school;
	}
	public String getSchool()
	{
		return school;
	}
	public void setGrade(String grade)
	{
		this.grade=grade;
	}
	public String getGrade()
	{
		return grade;
	}
	public void setMajor(String major)
	{
		this.major=major;
	}
	public String getMajor()
	{
		return major;
	}
	public void setClasses(String classes)
	{
		this.classes=classes;
	}
	public String getClasses()
	{
		return this.classes;
	}

}
