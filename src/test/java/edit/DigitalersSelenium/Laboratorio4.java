package edit.DigitalersSelenium;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio4 {

	String url = "http://www.automationpractice.pl/index.php";
	String chromePath = "..\\DigitalersSelenium\\Drivers\\chromedriver129.0.6668.42.exe";
	WebDriver driver; 
	
	@Test
	
	public void registraUsuario() {
		System.setProperty("weddriver.chrome.driver",chromePath);
		driver = new ChromeDriver();

		driver.navigate().to(url);
		
		//primer paso: ingresar una cuenta y apretar un botón

		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create")); //identificacion del elemento
		//txtEmail.sendKeys("holahii@correoreal.com"); 

		//registo con correo variable
		txtEmail.sendKeys("micorreo"+ Math.random() + "@gcorreo.com");
		
		//apretar el botón hay dos opciones
		/*primero
		webElement BtnCreate = driver.findElement(By.id("SubmitCreate"));
		BtnCreate.click();*/

		//segundo
		driver.findElement(By.id("SudmitCreate")).click();
		
		//COMPLETAR FORMULARIO ------

		//necesitamos una espera porque cuando cambia de pagina, los elementos tardan en cargarse
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id.gender1")));

			//title
		driver.findElement(By.id("id.gender1")).click();
		//first name
		WebElement txtFirtName = driver.findElement(By.xpath(""));
		txtFirtName.sendKeys("Daniel");
			//last name
		WebElement txtLastName = driver.findElement(By.name("costumer_lastname"));
		txtLastName.sendKeys("Jerez");
			//password
		driver.findElement(By.cssSelector("#passrd")).sendKeys("12345");

			//bith date
		//dia---
		Select day = new Select(driver.findElement(By.id("days")));
			day.selectByVisibleText("1  "); //doble espacio cuando se usa visibletext
		//mes---
			Select months = new Select(driver.findElement(By.name("months")));
		months.selectByValue("2"); //el 2 es ferbrero segun el css
		//año---
			Select year = new Select(driver.findElement(By.xpath("year")));
		year.selectByIndex(30);
			//newsletter
		driver.findElement(By.cssSelector("#newsletter"));
			//boton registrar
		driver.findElement(By.id("#submitAccount")).click();
		
		
	}
	
	
	
	
	
}
