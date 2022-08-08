import java.io.*;
import java.util.*;

public class LoginScreen
{

public static void main(String args[])
{
	System.out.println("Starting system . . .");
	stencil.initialiseStencil();
	stencil.scale(0,0);
	stencil.printFinalBoard();
	
	Console con=System.console();
	String username=new String();
	Scanner sc=new Scanner(System.in);
	LoginEJBClient loginejbclient = new LoginEJBClient();
	boolean IsUserExist=true;
	int choice=0;
	while (choice == 0)
	{
		System.out.println("Enter the options :\n 1. Existing user \n 2. New user");
		choice=sc.nextInt();
		switch(choice)
		{
			case 1 :
				System.out.print("Enter UserName : ");
				username=String.valueOf(con.readPassword());			
				System.out.println("UserName is :"+username);
			break;
			case 2:
				while(IsUserExist)
				{
				System.out.print("Enter the desired user name to check the availability : ");
				username = sc.next();
				try{
				System.out.println("User exist or not : "+loginejbclient.loginremote.userIsExist(username));
				}
				catch(Exception e)
				{
					System.out.print("Exception " +e.getMessage());
				}
				}
				
			break;
		}
	}
}

}