
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
public class Item {
	private String name;
	private String itemid;
	private String userid;
	private String state;
	private String city;
	private String fulladdress;
	private String rent;
	private String category;
	private String description;
	public void setName(String  name1)
	{
		name=name1;
	}
	public String getName()
	{
		return name;
	}
	public void setitemid(String itemid1)
	{
		itemid=itemid1;
	}
	public String getitemid()
	{
		return itemid;
	}
	public void setuserid(String  userid1)
	{
		userid=userid1;
	}
	public String getuserid()
	{
		return userid;
	}
	public void setstate(String  state1)
	{
		state=state1;
	}
	public String getstate()
	{
		return state;
	}
	public void setCity(String city1)
	{
		city=city1;
	}
	public String getcity()
	{
		return city;
	}
	public void setfulladdress(String address1)
	   {
		fulladdress=address1;
	}
	public String getAddr()
	{
		return fulladdress;
	}
	public String getstreet()
	{
		return fulladdress;
	}
	public void setrent(String rent1)
	{
		rent=rent1;
	}
	public String getrent()
	{
		return rent;
	}
	public void setcategory(String cat1)
	{
		category=cat1;
	}
	public String getcategory()
	{
		return category;
	}
	public void setdescription(String dis1)
	{
		description=dis1;
	}
	public String getdescription()
	{
		return description;
	}
	public void display(HttpServletRequest req,PrintWriter out)
	{
		if(HttpResponseHandler.isLogin(req))
			HttpResponseHandler.topViewForOthers(out);
		else 
			HttpResponseHandler.profileUpperView(out, Dbopr.getUser(userid));
		HttpResponseHandler.bottomView(out);
	}
}
