
/*
 *  Copyright Red Oxygen 2005
 *
 *  Java example code to send an SMS via the Red Oxygen SMS gateway over HTTP.
 *
 */

import java.io.*; 
import java.net.*;
import java.util.LinkedList;
import java.lang.*; 



public class Tester
{ 

	public static int  SendSMS(String strAccountId,String strEmail,String strPassword,String strMSISDN,String strMessage,StringBuffer strResponse)
	{
		String  sRequestURL;
		String  sData;
		int nResult = -1;
 
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

			while ((inputLine = in.readLine()) != null)
			{
                              responseBuffer = responseBuffer.append(inputLine);
			      responseBuffer = responseBuffer.append("\n\n\n");
			}
		
			strResponse.replace(0,0,responseBuffer.toString());

			String sResultCode = strResponse.substring(0,4);
			nResult = Integer.parseInt(sResultCode);
			
			in.close();
		}
		
		catch (Exception e)
		{
			System.out.println("Exception caught sending SMS\n"); 
			nResult = -2;
		}
		return nResult;
	}


	public static void main(String[] args) throws Exception 
	{
		StringBuffer str=new StringBuffer();
		System.out.println(UserVarifyCode.SendSMS("8630325880", "test", str)+"  "+str);
	}
} 

