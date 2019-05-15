package com.jnu.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyFileOperator {
	private final static String adr = "Data/UserData.ser";
	
	public static User load() {
		User user = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
			File file = new File(adr);
			if(!file.exists()){
			    //先得到文件的上级目录，并创建上级目录，在创建文件
			    file.getParentFile().mkdir();
			    try {
			        //创建文件
			        file.createNewFile();
			        return new User();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			fileIn = new FileInputStream(file);
			in = new ObjectInputStream(fileIn);
			user = (User) in.readObject();
			in.close();
			fileIn.close();
			return user;
		}catch(IOException i)
		{
			i.printStackTrace();
			return new User();
		}catch(ClassNotFoundException c)
		{
			c.printStackTrace();
			return new User();
		}/*finally {
			try {
				in.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				fileIn.close();
			}catch(Exception e) { 
				e.printStackTrace();
			}

		}*/
	}
	
	//保存用户个人信息的数据
	public static boolean save(User user) {
		//fileOut为文件保存的位置
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try
	      {
			 File file = new File(adr);
	         fileOut = new FileOutputStream(file);
	         out = new ObjectOutputStream(fileOut);
	         out.writeObject(user);
	         return true;
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	  			return false;
	      }finally {
	    	  try {
	    		  out.close();
	    	  }catch (Exception e) {
	    		  e.printStackTrace();
	    	  }
	    	  try {
	    		  fileOut.close();
	    	  }catch (Exception e) {
	    		  e.printStackTrace();
	    	  }
	      }	
	}
	
	//删除用户个人信息的数据
	/*
	 * File userData = new File("/Data/UserData.ser");
	 * userData.delete();
	 */
		
}
