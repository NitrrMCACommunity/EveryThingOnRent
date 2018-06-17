import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.regex.Pattern;

import oracle.sql.CHAR;
public class InputRestrictions {
	 static boolean isPhone(String str)
	 {
		LinkedList<Character> al=new LinkedList<Character>();
		al.add('0');
		al.add('1');
		al.add('2');
		al.add('3');
		al.add('4');
		al.add('5');
		al.add('6');
		al.add('7');
		al.add('8');
		al.add('9');
		 char ch[]=str.toCharArray();
		 for(int i=0;i<ch.length;i++)
			 if(!al.contains(ch[i])){
				 return false;
			 }
		if(ch.length==10||ch.length==12)
			return true;
		 return false;
	 }
	static boolean isUniqueUser(String userid)
	{
		try {
		Connection con=Dbopr.getConnection();
		PreparedStatement ps=con.prepareStatement("select *from users where userid=?");
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			con.close();
			return false;
		}
		return true;
		}catch(Exception e)
		{
			System.out.println("At isUniqueUser() "+e);
			return false;
		}
	}
	static boolean isEmail(String email)
	{
		String sp="!@#$%^&*)(";
		 char ch[]=email.toCharArray();
		 LinkedList<Character> al=new LinkedList<Character>();
		 String str=".com";
		 for(int i=0;i<ch.length;i++)
			 al.add(ch[i]);
			 if(!al.contains('@'))
			 return false;
			 else if(!email.contains(str))
				 return false;
			 else if(!al.contains('.'))
				 return false;
			 else 
				 return true;
	}
	static boolean isName(String str)
	{
		LinkedList<Character> al=new LinkedList<Character>();
		al.add('a');
		al.add('b');
		al.add('c');
		al.add('d');
		al.add('e');
		al.add('f');
		al.add('g');
		al.add('h');
		al.add('i');
		al.add('j');
		al.add('k');
		al.add('l');
		al.add('m');
		al.add('n');
		al.add('o');
		al.add('p');
		al.add('q');
		al.add('r');
		al.add('s');
		al.add('t');
		al.add('z');
		al.add('y');
		al.add('x');
		al.add('w');
		al.add('v');
		al.add('u');
		al.add(' ');
		
		al.add('A');
		al.add('B');
		al.add('C');
		al.add('D');
		al.add('E');
		al.add('F');
		al.add('G');
		al.add('H');
		al.add('I');
		al.add('J');
		al.add('K');
		al.add('L');
		al.add('M');
		al.add('N');
		al.add('O');
		al.add('P');
		al.add('Q');
		al.add('R');
		al.add('S');
		al.add('T');
		al.add('U');
		al.add('V');
		al.add('W');
		al.add('X');
		al.add('Y');
		al.add('Z');
		 char ch[]=str.toCharArray();
		 for(int i=0;i<ch.length;i++)
			 if(!al.contains(ch[i])) 
				 return false; 
		return true;
	}
}
