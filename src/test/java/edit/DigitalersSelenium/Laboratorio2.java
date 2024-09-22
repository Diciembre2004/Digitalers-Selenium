package edit.DigitalersSelenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Laboratorio2 {

	//atributos: variables que son de uso general

	String url = "http://www.automationpractice.pl/index.php";
	String chromePath = "..\\DigitalersSelenium\\Drivers\\chromedriver128.0.6613.137.exe";
	WebDriver driver; //esta definiendo una variable llamada driver 
	
	@Test
	
	//path absoluto: buscar la locacion del archivo (direccion fisica donde esta el archivo)
	//direcciones relativas: 

	//métodos: son las rutinas de testing
	
	public void BuscaPalabraChrome() {
	// abrir el navegador = configurar el script para poder utilizarlo
	System.setProperty("webdriver.chrome.driver", chromePath);

	//abrir la pagina
	driver = new ChromeDriver();
	driver.get(url);

	//pararse en el buscador y escribir "dress".     Ubicacion del elemento
	WebElement txtBuscador = driver.findElement(By.id("search_quey_top"));
	txtBuscador.sendKeys("dress");
	txtBuscador.sendKeys("Keys.ENTER");
	
	
	}
}
