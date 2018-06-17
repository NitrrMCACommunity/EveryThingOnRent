import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UserVarifyCode {
	private static String msg="Your one time password for this transaction ";
	public static boolean varifyUser(User u)
	{
		char[] otp=UserVarifyCode.Code();
		String str=new String(otp);
		String msg1=msg+str;
		System.out.println("running");
		String subject="Everything On Rent Varification Mail";
		StringBuffer res=null;
		UserVarifyCode.SendSMS(u.getPhone(), msg1,res);
		System.out.println(res);
		UserVarifyCode.SendEmail(u.getEmail(),subject, msg1);
		if(UserVarifyCode.insertOTP(u.getId(), str))
		return true;
		return false;
	}
	public static char[] Code()
	{
		String number="0123456789";
		int length=6;
		Random r=new Random();
		char[] otp=new char[length];
		for(int i=0;i<length;i++)
		otp[i]=number.charAt(r.nextInt(number.length()));
		return otp;
	}
	public static void SendEmail(String Email_addr,String subject,String message)
	{
		final String user="everythingonrentabm@gmail.com";
		final String pass="234#mad12";
		Properties p=new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.starttls.enable", "true");
		Session session=Session.getDefaultInstance(p,new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,pass);  
				   }  
				});
		try {
			MimeMessage message1=new MimeMessage(session);
			message1.addRecipient(Message.RecipientType.TO,new InternetAddress(Email_addr));
			message1.setText(message);
			message1.setSubject(subject);
			Transport.send(message1);
			System.out.println("Message sent");
	}catch (Exception e)
		{
		System.out.println("Email does not sent");
		System.out.println(e);
		}
	}
	public static int  SendSMS(String strMSISDN,String strMessage,StringBuffer strResponse)
	{
		String  sRequestURL;
		String  sData;
		int nResult = -1;
		 String  strAccountId="CI00194384";
		 String strEmail="kumarimadhavi25@gmail.com";
		 String strPassword="i2SrQek1";
 
		sRequestURL = "http://www.redoxygen.net/sms.dll?Action=SendSMS";

		try
		{		
		
			sData  = ("AccountId="  + URLEncoder.encode(strAccountId,"UTF-8"));
			sData += ("&Email="     + URLEncoder.encode(strEmail,"UTF-8"));
			sData += ("&Password="  + URLEncoder.encode(strPassword,"UTF-8"));
			sData += ("&Recipient=" + URLEncoder.encode(strMSISDN,"UTF-8"));
			sData += ("&Message="   + URLEncoder.encode(strMessage,"UTF-8"));


		
			URL urlObject = new URL(sRequestURL); 
			
			HttpURLConnection con = (HttpURLConnection) urlObject.openConnection();
			con.setRequestMethod("POST");
			con.setDoInput (true);
                        con.setDoOutput (true);


			DataOutputStream out;
    		        out = new DataOutputStream(con.getOutputStream());
    		        out.writeBytes (sData);
			out.flush();
			out.close();
    		
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 			
			String inputLine; 
			StringBuffer responseBuffer = new StringBuffer(); 
			System.out.print("Test1");
			while ((inputLine = in.readLine()) != null)
			{
                  responseBuffer = responseBuffer.append(inputLine);
			      responseBuffer = responseBuffer.append("\n\n\n");
			}
		
			strResponse.replace(0,0,responseBuffer.toString());

			String sResultCode = strResponse.substring(0,4);
			nResult = Integer.parseInt(sResultCode);
			in.close();
			return 1;
		}
		catch (Exception e)
		{
			System.out.println("Exception caught sending SMS\n"+e); 
			nResult = -2;
		}
		return nResult;
	}
	public static boolean insertOTP(String userid,String str)
	{
		try {
			Connection con=Dbopr.getConnection();
			PreparedStatement ps=con.prepareStatement("Insert into onetp values(?,?)");
			ps.setString(1, userid);
			ps.setString(2, str);
			int m=ps.executeUpdate();
			if(m==1) {
			con.close();return true;}
			return false;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
}