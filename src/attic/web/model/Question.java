package attic.web.model;

public class Question {
	private int id;
	private int number;
	private int unit;
	private String subject;
	private String description;
	private String option;
	private int type;
	private String answer;

	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setNumber(int num)
	{
		this.number=num;
	}
	public int getNumber()
	{
		return number;
	}
	public void setUnit(int unit)
	{
		this.unit=unit;
	}
	public int getUnit()
	{
		return unit;
	}
	public void setSubject(String subject)
	{
		this.subject=subject;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public String getDescription()
	{
		return description;
	}
	public void setOption(String option)
	{
		this.option=option;
	}
	public String getOption()
	{
		return option;
	}
	public void setType(int type)
	{
		this.type=type;
	}
	public int getType()
	{
		return type;
	}
	public void setAnswer(String answer)
	{
		this.answer=answer;
	}
	public String getAnswer()
	{
		return answer;
	}
}
