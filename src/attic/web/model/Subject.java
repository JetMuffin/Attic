package attic.web.model;

public class Subject {
	private String name;
	private int unitnum;
	private String title;
	private int unit;
	private int quesnum;
	private int isnav;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getUnitnum()
	{
		return unitnum;
	}
	public void setUnitnum(int unitnum)
	{
		this.unitnum=unitnum;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public int getUnit()
	{
		return unit;
	}
	public void setUnit(int unit)
	{
		this.unit=unit;
	}
	public int getQuesnum()
	{
		return quesnum;
	}
	public void setQuesnum(int quesnum)
	{
		this.quesnum=quesnum;
	}
	public int getIsnav()
	{
		return isnav;
	}
	public void setIsnav(int isnav)
	{
		this.isnav=isnav;
	}
}
