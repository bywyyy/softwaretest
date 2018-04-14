package lab2_c;

import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  

public class UntitledTestCase {
  
  public static void main(String[] args){
	  
	  //---打开火狐浏览器---
	  System.setProperty("webdriver.firefox.bin", "E:/firefox/firefox.exe");  
      WebDriver driver=new FirefoxDriver();  
      
      xlxs poi = new xlxs();
      List<List<String>> list = poi.read("D:/university/课程/大三下/软件测试/lab2/input.xlsx");
      if (list != null) {
    	   	  
          for (int i = 0; i < list.size(); i++) {
        	  //---获取xlsx文件中第i行数据
              List<String> cellList = list.get(i);  
              String number = cellList.get(0);
              String adress = cellList.get(1);
              String pwd = number.substring(number.length()-6,number.length());
              
              if(adress.isEmpty()) {
            	  System.out.print(number+" 未提交github地址");
            	  System.out.println();
              }
              else {
	              //---访问给定网址-----
	              driver.get("https://psych.liebes.top/st");    
	              
	              //---输入用户名---
	              WebElement input_name = driver.findElement(By.id("username"));
	              input_name.clear();
	              input_name.sendKeys(number);
	              
	              //---输入密码---
	              WebElement input_pwd = driver.findElement(By.id("password"));
	              input_pwd.clear();
	              input_pwd.sendKeys(pwd);
	              
	              //---点击登录---
	              driver.findElement(By.id("submitButton")).click();
	              
	              //---获取页面中github地址
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