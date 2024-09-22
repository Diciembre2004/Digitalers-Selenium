package edit.DigitalersSelenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Laboratorio3 {

	//atributos: variables que son de uso general

	String url = "http://www.automationpractice.pl/index.php";
	String chromePath = "..\\DigitalersSelenium\\Drivers\\chromedriver129.0.6668.42.exe";
	WebDriver driver; //esta definiendo una variable llamada driver 
	
	//métodos: son las rutinas de testing
	//método para definir que navegador vamos a utilizar
	
	@Test
	
	//path absoluto: buscar la locacion del archivo (direccion fisica donde esta el archivo)
	//direcciones relativas: 

	
	public void BuscaPalabraChromeBeta() {
	// abrir el navegador = configurar el script para poder utilizarlo
	System.setProperty("webdriver.chrome.driver", chromePath);
	ChromeOptions options = new ChromeOptions(); 	//creando un objeto 
	//aca selecciono el navegador que quiero utilizar. El archivo binario
	options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
	options.addArguments("incognito");
	options.addArguments("disable-extensions");
	
	//abrir la pagina
	driver = new ChromeDriver();
	driver.get(url);

	//MAXIMIZAR  VENTANA 
	driver.manage().window().maximize();

	driver.manage().deleteAllCookies();
	
	//pararse en el buscador y escribir "dress".     Ubicacion del elemento
	WebElement txtBuscador = driver.findElement(By.id("search_quey_top"));
	txtBuscador.sendKeys("dress");
	
	//presionar el botón lupa o dar un enter es lo mismo.
	txtBuscador.sendKeys("Keys.ENTER");
	
	//cerrar navegador o conexion

	System.out.println("URL" + driver.getCurrentUrl());
	System.out.println("Titulo de la pagina" + driver.getTitle());

	//navigate.to es lo mismo que el get(url)
	driver.navigate().to(url);

	driver.navigate().refresh();
	driver.close();
	
	}
}
