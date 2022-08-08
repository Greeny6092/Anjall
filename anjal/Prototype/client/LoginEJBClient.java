import java.io.*;
import javax.naming.Context;  
import javax.naming.InitialContext;  
import com.anjal.Login.LoingEJBRemote;
import java.util.*;
  
public class LoginEJBClient {  
Context context;
public LoingEJBRemote loginremote;
Properties props;

public LoginEJBClient()
{
try {
	props = new Properties();
props.load(new FileInputStream("jndi.properties"));
	context=new InitialContext(props);
	loginremote=(LoingEJBRemote)context.lookup("ejb:/Login-ejb/LoginBeanStateless!com.anjal.Login.LoingEJBRemote");
	
}
catch(IOException ioe)
{
	System.out.println("Exception Message : "+ioe.getMessage());
}
catch(Exception e)
{
	System.out.println("Exception : "+e.getMessage());
}

//remote=(LoingEJBRemote)context.lookup("st1");
}



}  