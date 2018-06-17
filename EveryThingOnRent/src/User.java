

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class User {
	private String name;
	private String id;
	private String city;
	private String street;
	private String email;
	private String password;
	private String phone;
	private String about;
	private boolean isActive;
	private String state;
	public void setName(String name1)
	{
		name=name1;
	}
	public String getName()
	{
		return name;
	}
	public void setId(String id1)
	{
		id=id1;
	}
	public String getId()
	{
		return id;
	}
	public void setCity(String city1)
	{
		city=city1;
	}
	public String getCity()
	{
		return city;
	}
	public void setStreet(String Street1)
	{
		street=Street1;
	}
	public String getStreet()
	{
		return street;
	}
	public void setEmail(String Email1)
	{
		email=Email1;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPassword(String password1)
	{
		password=password1;
	}
	public String getpassword()
	{
		return password;
	}
	public void setPhone(String phone1)
	{
		phone=phone1;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setabout(String about1)
	{
		about=about1;
	}
	
	public String getabout()
	{
		return about;
	}
	public void setActive(boolean active1)
	{
		isActive=active1;
	}
	public boolean getActive()
	{
		return isActive;
	}
	public void setState(String state1)
	{
		state =state1;
	}
	public String getState()
	{
		return state;
	}
	public void display()
	{
		System.out.println(name);
		System.out.println(id);
		System.out.println(city);
		System.out.println(street);
		System.out.println(email);
		System.out.println(password);
		System.out.println(phone);
		System.out.println(state);
		System.out.println(about);
		System.out.println(isActive);
	}
}
