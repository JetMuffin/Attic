package attic.web.model;

public class Node {
	private int id;
	private int pid;
	private boolean is_nav;
	private String module;
	private String action;
	private String title;
	private String icon;
	private String url;
	
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
	public String getModule()
	{
		return module;
	}
	public void setModule(String module)
	{
		this.module=module;
	}
	public String getAction()
	{
		return action;
	}
	public void setAction(String action)
	{
		this.action=action;
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
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url=url;
	}
}
