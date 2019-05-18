package com.jnu.model;


import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.util.HashMap;  
import java.util.Map;

import com.jnu.view.PanelLeaveDocEdit;

import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;
import freemarker.template.Version;

/**
 * 生成文档测试
 *
 */
public class EditDoc 
{
	private Configuration configuration = null;
	
	public EditDoc(){  
	        configuration = new Configuration(new Version("2.3.0"));  
	        configuration.setDefaultEncoding("UTF-8");  
	    }
	/* public static void main(String[] args) {  
	        WordTest test = new WordTest();  
	        test.createWord();  
	    }*/
	 public void createWord(){  
	        Map<String,Object> dataMap=new HashMap<String,Object>();  
	        getData(dataMap);  
	        String path = System.getProperty("user.dir")+"./documents";
	        try {
				configuration.setDirectoryForTemplateLoading(new File(path));
			} catch (IOException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}  //FTL文件所存在的位置  
	        Template t=null;  
	        try {  
	            t = configuration.getTemplate("doc.ftl", "utf-8"); //文件名  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        File outFile = new File("./请假条.docx");  //导出文档的存放位置
	        Writer out = null;  
	        try {  
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));  
	        } catch (FileNotFoundException e1) {  
	            e1.printStackTrace();  
	        }  
	           
	        try {  
	            t.process(dataMap, out);  
	        } catch (TemplateException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }
    
	 private void getData(Map<String, Object> dataMap) {
		 	String s1 =new String(UserManager.getUser().get_studentId());
		 	String s2 =new String(UserManager.getUser().get_name());
		 	String s3 =new String(UserManager.getUser().get_college());
		 	String s4 =new String(UserManager.getUser().get_major());
	/*	 	String s5 =new String(PanelLeaveDocEdit.DocReason);*/
	        dataMap.put("number", s1);  
	        dataMap.put("name", s2);
	        dataMap.put("college",s3); 
	        dataMap.put("major",s4);
	        dataMap.put("reason",PanelLeaveDocEdit.DocReason);
	        dataMap.put("by",PanelLeaveDocEdit.DocBeginYear);
	        dataMap.put("bm",PanelLeaveDocEdit.DocBeginMonth);
	        dataMap.put("bd",PanelLeaveDocEdit.DocBeginDay);
	        dataMap.put("ey",PanelLeaveDocEdit.DocEndYear);
	        dataMap.put("em",PanelLeaveDocEdit.DocEndMonth);
	        dataMap.put("ed",PanelLeaveDocEdit.DocEndDay);
	    }
}
