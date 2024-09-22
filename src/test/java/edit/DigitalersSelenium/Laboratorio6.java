package edit.DigitalersSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio6 {
	
	String url ="http://www.automationpractice.pl/index.php";
	String chromePath = "..\\Digitaler2024SeleniumMartJue\\drivers\\chromedriver128.0.6613.119.exe";
	String fireFoxPath="..\\Digitaler2024SeleniumMartJue\\Drivers\\geckodriver0.35.0.exe";
	WebDriver driver;
	

	@Parameters("navegador") //Permite ejecutar pruebas en diferentes entornos o configuraciones sin modificar el código.
	@BeforeTest
	public void beforetest(String navegador) {
		System.out.println("beforetest -- inicio del test");
		
		
		if(navegador.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", chromePath);
		//ChromeOptions options = new ChromeOptions();
		//aca voy a asignar el navegador que quiero utilizar. el archivo binario
		//options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
		//options.addArguments("incognito");
		//options.addArguments("disable-extensions");
						
		//abrir la pagina
		driver = new ChromeDriver();
		}else if(navegador.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.firefox.driver", fireFoxPath);
			driver = new FirefoxDriver();
			
			
		}
		
		
		//maximizar la ventana
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		//cargar pagina
		driver.get(url);
		
		
	}
	
	
	@Test (description="cp01 -- buscar palabra", priority = 20)
		public void buscarPalabra() {
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		//presionar el boton lupa o dar un ENTER es lo mismo.
		txtBuscador.sendKeys(Keys.ENTER);
		
		
	}
	
		
	
}

