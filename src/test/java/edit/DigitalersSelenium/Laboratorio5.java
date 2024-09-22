package edit.DigitalersSelenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;  
import org.testng.*;
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.AfterTest;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.AfterSuite;  


public class Laboratorio5 {
	String url = "http://www.automationpractice.pl/index.php";
	String chromePath = "..\\DigitalersSelenium\\Drivers\\chromedriver128.0.6613.137.exe";
	WebDriver driver; 
	
	//para ejecutar distintas partes del codigo

	@BeforeSuite
	public void BeforeSuite() {
		 System.out.println("beforeSuite -- Inicio de prueba");
		}
	@BeforeClass
	public void BeforeClass() {
		 System.out.println("BeforeClass -- comienzo de la clase de java");
		}
	@BeforeTest
	public void BeforeTest() {
		System.out.println("BeforeTest -- Inicio de test");
		}
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.id("search_quey_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys("Keys.ENTER");

		//para cambiar url
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.automationpractice.pl/index.php");
	}
	
	@Test (description="cp 002 -- ir a contact us", priority= 10) //priority define la prioridad de cuando se ejecuta 
	public void irAContactoUS() {
		driver.findElement(By.linkText("Contact Us")).click();
		Select subject = new Select(driver.findElement(By.id("id_contact")));
		subject.deselectByValue("2");
		
		driver.findElement(By.name("from")).sendKeys("hola@correoreal.com");
		driver.findElement(By.cssSelector("#id_order")).sendKeys("123456");
		
		driver.findElement(By.id("fileUpload")).sendKeys("c:\\testenvio.txt");
		
		driver.findElement(By.tagName("textarea")).sendKeys("mensaje de queja"); //tagname no suele usarse

		driver.findElement(By.id("submitMessage")).click();
	}
	
	
	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest -- cierre de test");
		}
	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass -- fin de la clase");
		}
	@AfterSuite
	public void fterSuite() {
		System.out.println("fterSuite -- fin de la suite");
		}
}
