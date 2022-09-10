package com.flipkartpurchase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.Assert;
public class MobilePur {

		public static WebDriver driver;
		
		@BeforeClass
		
		public static void launch() throws InterruptedException {
			System.out.println("launch");
		    System.setProperty("webdriver.chrome.driver", "C:\\chrome workspace old\\junit-purchase\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		    driver.get("https://www.flipkart.com/");
		    driver.manage().window().maximize();
		    Thread.sleep(3000);
		}
		
		@AfterClass
		public static void close() {
			//driver.quit();
		}
		
		@Before
		public void startTime() {
			System.out.println(java.time.LocalTime.now());
		}
		@After
		public void endTime() {
			System.out.println(java.time.LocalTime.now());
		}
		   @Test
		     public void method1() throws InterruptedException 
			   {
				System.out.println("login");
				   WebElement close=   driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
					close.click();
		     }
		@Test
		public void method2 () throws IOException, InterruptedException{
			System.out.println("search");
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys("realme mobile");
			driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
			
			File s = new File("C:\\Users\\ELCOT\\Desktop\\New Microsoft Excel Worksheet.xlsx");
			
			FileOutputStream fos = new FileOutputStream(s);
			Workbook w = new XSSFWorkbook();
		      Sheet sh =w.createSheet("list of mobiles");
			  Thread.sleep(2000);
			List<WebElement> data = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			for (int i = 0; i < data.size(); i++) {
				WebElement tdata = data.get(i);
				String st = tdata.getText();
				 Row r= sh.createRow(i);
		     	  Cell c= r.createCell(0);
		     	  c.setCellValue(st);
			}
		      w.write(fos);
		       w.close();  
			}
		@Test
		   public void method3()throws InterruptedException{
			   System.out.println("windowhandle");
			   Thread.sleep(3000);
			   driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]")).click();
			   Thread.sleep(3000);
			   String parent=  driver.getWindowHandle();
	 		   Set<String>child=driver.getWindowHandles();
	 		
	 		           for(String r:child){
	 			   if(!parent.equals(r)){
	 				driver.switchTo().window(r);
	 			  }
	 		       }
		          }
		         @Test
		         public void method4() throws IOException{
	         WebElement mobile = driver.findElement(By.xpath("(//*[@class='B_NuCI']") );
	           String mname= mobile.getText();
	           
	         File s= new File("C:\\Users\\ELCOT\\Desktop\\New Microsoft Excel Worksheet.xlsx");
	       FileInputStream fis= new FileInputStream(s);s
	       Workbook w= new XSSFWorkbook(fis);
	       Sheet sh= w.getSheet("list of mobiles");
	      
	     	        Row u=sh.getRow(2);
	     	  for (int j = 0; j < u.getPhysicalNumberOfCells(); j++) {
	     		  Cell c= u.getCell(j);
					Assert.assertEquals(mname, c);
				}
		   }
		   @Test
		            public void method5() throws IOException, Exception{
			   
			    System.out.println("Screenshot");
			    Thread.sleep(2000);
			    JavascriptExecutor j= (JavascriptExecutor)driver;
			   j.executeScript("window.scrollBy(0,2500)","");
			   
			   TakesScreenshot ts= (TakesScreenshot)driver;
		         File src=  ts.getScreenshotAs(OutputType.FILE);
		        File d= new File("C:\\chrome workspace old\\junit-purchase\\screenshotScreenshotpage\\photo.png");
		        FileUtils.copyFile(src, d);
		 }	
		}


