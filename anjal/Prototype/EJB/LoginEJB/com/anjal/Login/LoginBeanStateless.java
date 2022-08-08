package com.anjal.Login;
 
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import java.io.*;
 
@Stateless
@Remote
public class LoginBeanStateless implements LoingEJBRemote {
   List users;
   FileOutputStream fileWriter;
   FileInputStream fileReader;
   BufferedReader BufferedFileReader;
   public LoginBeanStateless()
   {
   users= new ArrayList<String>();
   String file = "./User.txt";
   try
   {
	   System.out.println("Constructor called...");
   fileWriter = new FileOutputStream(file);
   fileReader = new FileInputStream(file);
   BufferedFileReader = new BufferedReader(BufferedFileReader);
   }
   catch(FileNotFoundException FileNotFound)
   {
	   System.out.println("File Not found : "+file);
   }
   catch(Exception GenericException)
   {
	   System.out.println("Exception occurred : "+GenericException.getMessage());
   }
   }   
   public boolean userIsExist(String DesiredUserName) throws IOException
   {
	   boolean result=false;
	   String line=new String();
	   while (!result)
	   {
			line = BufferedFileReader.readLine();
			String username[] = line.split(" ");
			if (username == null)
				break;
			if(username[1].equals(DesiredUserName))
			{
				result = true;
			}
	   }
	   return result;
   }
   public boolean createUser(String mac, String UserName)
   {
	   boolean status=false;
	   
	   return status;
   }
   public String getLastLoginDateTime(String username)
   {
	   String dateTime = new String();
	   
	   return dateTime;
   }
   
   public List getUserNames()
   {
	   return users;
   }
}