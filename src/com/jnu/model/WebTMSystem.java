package com.jnu.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebTMSystem {
	private Logger Log = Logger.getLogger(getClass());
	
	private static WebClient wc;
	private HtmlPage page;
	
	private static boolean IS_INITIALIZED = false;
	
	public void initialize() {
		if(IS_INITIALIZED)
			return;		
		wc = new WebClient(BrowserVersion.CHROME);
		wc.getOptions().setJavaScriptEnabled(true);
		wc.getOptions().setCssEnabled(true);
		wc.setAjaxController(new NicelyResynchronizingAjaxController());
		wc.getOptions().setThrowExceptionOnScriptError(false);
		IS_INITIALIZED = true;
	}
	
	public ImageIcon gettxtFJM() {
		initialize();
		try {
			page = wc.getPage("https://jwxt.jnu.edu.cn/Login.aspx");
//			page.refresh();
			HtmlImage login=(HtmlImage) page.getFirstByXPath(
				"//*[@id=\"Table16\"]/tbody/tr[9]/td[3]/img");
			File storeFile = new File("Data/vc.gif");
			login.saveAs(storeFile);
			Log.info("验证码已下载");
			ImageIcon icon = new ImageIcon(ImageIO.read(new File("Data/vc.gif")));
			return icon;
		
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

	public boolean logintmsystem(String username, String password, String vc) {
		initialize();
	    LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",    "org.apache.commons.logging.impl.NoOpLog");  
	    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit")  
	        .setLevel(Level.OFF);  
	    java.util.logging.Logger.getLogger("org.apache.commons.httpclient")  
	        .setLevel(Level.OFF); 
	        
	    Log.info(username + " " + " " + password.length() + vc);
	    
	    try {        		
			HtmlInput txtYHBS = page.getHtmlElementById("txtYHBS");
			HtmlInput txtYHMM = page.getHtmlElementById("txtYHMM");				
			HtmlInput txtFJM=(HtmlInput) page.getElementById("txtFJM");   
			HtmlInput btn = page.getFirstByXPath("//*[@id=\"btnLogin\"]");

			txtYHBS.setAttribute("value", username);
			txtYHMM.setAttribute("value", password);
			txtFJM.setAttribute("value", vc);
					
			HtmlPage res = btn.click();
					
			Log.info(res.getBaseURI());
				
			if(!res.getBaseURI().equals("https://jwxt.jnu.edu.cn/Login.aspx")) {
				return true;
			}
				
		}
		catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    return false;
	}
	
	public void searchScores() {	
		initialize();
		try {
			//LoginTMSystem loginTMSytem =new LoginTMSystem();
			//loginTMSytem.logintmsystem();
			HtmlPage cj_page = wc.getPage("https://jwxt.jnu.edu.cn/Secure/Cjgl/Cjgl_Cjcx_WdCj.aspx");
			//System.out.println(cj_page.asXml());
			HtmlElement cx_btn = (HtmlElement)cj_page.getFirstByXPath("//*[@id=\"lbtnQuery\"]");
			HtmlPage cjall_page=cx_btn.click();
			System.out.println(cjall_page.asXml());
			
			ArrayList<Score> scores=new ArrayList<Score>();
			//Document doc=Jsoup.connect(cjall_page.asXml()).timeout(8000).get();
			Document doc=Jsoup.parse(cjall_page.asXml());
			Elements elements=doc.select("#GVLSCJ").select("tbody");
			Elements trs=elements.select("tr");
			//#GVLSCJ > tbody > tr:nth-child(3) > td:nth-child(1)
			//Elements a=doc.select("#GVLSCJ").select("tbody").select("tr:nth-child(3)").select("td:nth-child(1)");
			//System.out.println(a);
			//System.out.println(trs.get(1).select("td").get(1));
			for(int i=1;i<trs.size();i++) {
				Elements tds=trs.get(i).select("td");
				Score score=new Score();
				score.setAcademic_year(tds.get(0).text());
				score.setTerm(tds.get(1).text());
				score.setCourse(tds.get(2).text());
				score.setCredit(tds.get(3).text());
				score.setGrades(tds.get(4).text());
				score.setGPA(tds.get(5).text());
				score.setExam_date(tds.get(6).text());
				score.setExam_properties(tds.get(7).text());
				score.setCourse_type(tds.get(8).text());
				score.setStudy_type(tds.get(9).text());
				score.setStatus(tds.get(10).text());
				scores.add(score);
			}

			
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}	
