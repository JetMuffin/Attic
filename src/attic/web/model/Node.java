package attic.web.model;

public class Node {
	private int id;
	private int pid;
	private boolean is_nav;
	private String name;
	private String title;
	private String icon;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getPid()
	{
		return pid;
	}
	public void setPid(int pid)
	{
		this.pid=pid;
	}
	public boolean getIs_nav()
	{
		return is_nav;
	}
	public void setIs_nav(boolean flag)
	{
		this.is_nav=flag;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getIcon()
	{
		return icon;
	}
	public void setIcon(String icon)
	{
		this.icon=icon;
	}
}
