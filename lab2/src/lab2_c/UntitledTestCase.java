package lab2_c;

import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  

public class UntitledTestCase {
  
  public static void main(String[] args){
	  
	  //---�򿪻�������---
	  System.setProperty("webdriver.firefox.bin", "E:/firefox/firefox.exe");  
      WebDriver driver=new FirefoxDriver();  
      
      xlxs poi = new xlxs();
      List<List<String>> list = poi.read("D:/university/�γ�/������/�������/lab2/input.xlsx");
      if (list != null) {
    	   	  
          for (int i = 0; i < list.size(); i++) {
        	  //---��ȡxlsx�ļ��е�i������
              List<String> cellList = list.get(i);  
              String number = cellList.get(0);
              String adress = cellList.get(1);
              String pwd = number.substring(number.length()-6,number.length());
              
              if(adress.isEmpty()) {
            	  System.out.print(number+" δ�ύgithub��ַ");
            	  System.out.println();
              }
              else {
	              //---���ʸ�����ַ-----
	              driver.get("https://psych.liebes.top/st");    
	              
	              //---�����û���---
	              WebElement input_name = driver.findElement(By.id("username"));
	              input_name.clear();
	              input_name.sendKeys(number);
	              
	              //---��������---
	              WebElement input_pwd = driver.findElement(By.id("password"));
	              input_pwd.clear();
	              input_pwd.sendKeys(pwd);
	              
	              //---�����¼---
	              driver.findElement(By.id("submitButton")).click();
	              
	              //---��ȡҳ����github��ַ
	              String info_web = driver.findElement(By.xpath("//p")).getText();
	              
	              if(adress.equals(info_web)) {
	            	  System.out.print(number + " correct");
	            	  System.out.println();
	              }
	              else {
	            	  System.out.print(number + " error");
	            	  System.out.println();
	              }
              }
          }
      }
	  	  
      driver.close(); 
    
  }

}