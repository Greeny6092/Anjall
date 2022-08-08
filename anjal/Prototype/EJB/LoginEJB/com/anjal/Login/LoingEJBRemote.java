package com.anjal.Login;
 
import java.util.List;
import javax.ejb.Remote;
import java.io.*;
 
@Remote
public interface LoingEJBRemote{
   public boolean userIsExist(String bookName) throws IOException;
   public boolean createUser(String mac, String UserName);
   public String getLastLoginDateTime(String username);
   public List getUserNames();
}