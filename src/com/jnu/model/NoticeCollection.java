package com.jnu.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class NoticeCollection {
	private String fileName;
	
	public NoticeCollection(String fileName){
		this.fileName = "Data/"+fileName+".ser";
	}
	
	public ArrayList load() {
		ArrayList<NoticeContainer> res;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
			File file = new File(fileName);
			if(!file.exists()){
			    //先得到文件的上级目录，并创建上级目录，在创建文件
			    file.getParentFile().mkdir();
			    try {
			        //创建文件
			        file.createNewFile();
			        return new ArrayList<NoticeContainer>();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			fileIn = new FileInputStream(file);
			in = new ObjectInputStream(fileIn);
			res = (ArrayList) in.readObject();
			in.close();
			fileIn.close();
			return res;
		}catch(IOException i)
		{
			i.printStackTrace();
			return new ArrayList();
		}catch(ClassNotFoundException c)
		{
			c.printStackTrace();
			return new ArrayList();
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
	
	//保存通知
	public boolean save(Serializable notices) {
		//fileOut为文件保存的位置
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try
	      {
			 File file = new File(fileName);
	         fileOut = new FileOutputStream(file);
	         out = new ObjectOutputStream(fileOut);
	         out.writeObject(notices);
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

}
