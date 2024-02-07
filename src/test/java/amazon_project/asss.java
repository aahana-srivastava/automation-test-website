package amazon_project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker.Arguments;

import net.bytebuddy.asm.Advice.Argument;

public class asss {
	WebDriver wd;
	Actions act;
	@BeforeTest
	public void test1() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\cynoteck\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");    	
	ChromeOptions options=new ChromeOptions();
	Map<String, Object> prefs=new HashMap<String,Object>();
	prefs.put("profile.default_content_setting_values.notifications", 1);
	options.setExperimentalOption("prefs",prefs);
	wd=new ChromeDriver(options);
   wd.get("https://practice.automationtesting.in/");
   wd.manage().window().maximize();
   wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void t1() throws InterruptedException, IOException {
		act= new Actions(wd);
		 JavascriptExecutor js = (JavascriptExecutor) wd;
         
         
         //blocking google ads
            js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
       
		WebElement a=wd.findElement(By.cssSelector("#text-22-sub_row_1-0-2-0-0 > div > ul > li > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"));
	     js.executeScript("arguments[0].scrollIntoView();", a);
		WebDriverWait w= new WebDriverWait(wd, 10);
		String item1=wd.findElement(By.cssSelector("#text-22-sub_row_1-0-2-0-0 > div > ul > li > a.woocommerce-LoopProduct-link > h3")).getText();
		w.until(ExpectedConditions.elementToBeClickable(a));	
		try {
				List<WebElement> iframes=wd.findElements(By.tagName("iframe"));
			    for (WebElement iframe : iframes) {
			      if (iframe.getAttribute("id").contains("aswift")) {
			        	wd.switchTo().frame("aswift");	
			        	System.out.println("swithced");
			}}}
			    catch(NoSuchFrameException e){
			  	System.out.println("no ad");
			    	
			   }
		
		act.moveToElement(a).click().build().perform();
		
		WebElement shop=wd.findElement(By.cssSelector("#menu-item-40 > a"));
		w.until(ExpectedConditions.elementToBeClickable(shop));
		shop.click();
		
		wd.navigate().refresh();
		
	WebElement item2=wd.findElement(By.cssSelector("#content > ul > li.post-181.product.type-product.status-publish.product_cat-html.product_tag-html.has-post-title.no-post-date.has-post-category.has-post-tag.has-post-comment.has-post-author.instock.taxable.shipping-taxable.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"));
	String Item2text=wd.findElement(By.cssSelector("#content > ul > li.post-181.product.type-product.status-publish.product_cat-html.product_tag-html.has-post-title.no-post-date.has-post-category.has-post-tag.has-post-comment.has-post-author.instock.taxable.shipping-taxable.purchasable.product-type-simple > a.woocommerce-LoopProduct-link > h3")).getText();
	
	w.until(ExpectedConditions.elementToBeClickable(item2));
	try {
		List<WebElement> iframes=wd.findElements(By.tagName("iframe"));
	    for (WebElement iframe : iframes) {
	        if (iframe.getAttribute("id").contains("aswift")) {
	        	wd.switchTo().frame("aswift");
	        	Thread.sleep(2000);
	        	wd.findElement(By.cssSelector("#dismiss-button")).click();
	        	}
	}}
	    catch(NoSuchFrameException e){
	    	System.out.println("no ad");
	    	
	    }
	 js.executeScript("arguments[0].scrollIntoView();", item2);
	act.moveToElement(item2).click(item2).build().perform();
    Thread.sleep(2000);
	WebElement basket=wd.findElement(By.cssSelector("#wpmenucartli > a"));
	w.until(ExpectedConditions.elementToBeClickable(basket));
	act.moveToElement(basket).doubleClick().build().perform();
		
		
	String item1verify=wd.findElement(By.cssSelector("#page-34 > div > div.woocommerce > form > table > tbody > tr:nth-child(1) > td.product-name > a")).getText();	
	assertEquals(item1, item1verify);
	

	
	WebElement checkout= wd.findElement(By.cssSelector("#page-34 > div > div.woocommerce > div > div > div > a"));
	w.until(ExpectedConditions.elementToBeClickable(checkout));
	checkout.click();
	File excel=new File("D:\\sample website.xlsx"); 
    FileInputStream fis=new FileInputStream(excel); 
       XSSFWorkbook book=new XSSFWorkbook(fis);
       XSSFSheet sheet=book.getSheet("Sheet1"); 
   
       int rowcount=sheet.getLastRowNum(); 	 
      
       for(int i=0;i<=rowcount;i++) {
           String firstname=sheet.getRow(i).getCell(0).getStringCellValue();
           String lastname=sheet.getRow(i).getCell(1).getStringCellValue();
           String mail=sheet.getRow(i).getCell(2).getStringCellValue();
           String phone = String.valueOf((Double) sheet.getRow(i).getCell(3).getNumericCellValue());
           String address=sheet.getRow(i).getCell(4).getStringCellValue();
           String city=sheet.getRow(i).getCell(5).getStringCellValue();
           String code=String.valueOf((Double) sheet.getRow(i).getCell(7).getNumericCellValue());
          String password = String.valueOf((Double) sheet.getRow(i).getCell(7).getNumericCellValue());
           
           
         
        wd.findElement(By.cssSelector("input#billing_first_name")).sendKeys(firstname);
       	wd.findElement(By.cssSelector("input#billing_last_name")).sendKeys(lastname);
       	wd.findElement(By.cssSelector("#billing_email")).sendKeys(mail);
       	wd.findElement(By.cssSelector("#billing_phone")).sendKeys(phone);
       	wd.findElement(By.cssSelector("input#billing_address_1")).sendKeys(address);
       	wd.findElement(By.cssSelector("input#billing_city")).sendKeys(city);
       	wd.findElement(By.cssSelector("input#billing_postcode")).sendKeys(code);

       	wd.findElement(By.cssSelector("#createaccount")).click();
       	Thread.sleep(2000);
       	wd.findElement(By.cssSelector("#account_password")).sendKeys(password);
       	wd.findElement(By.cssSelector("#payment_method_cod")).click();
       	wd.findElement(By.cssSelector("#place_order")).click();
}
       
 book.close();
		
	
		
		
		
		
	}
}

