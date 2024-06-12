import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Escreve(String id_campo, String texto){
		driver.findElement(By.xpath(id_campo)).sendKeys(texto);
	}
	
	public void ClickaButton(String id_campo){
		driver.findElement(By.xpath(id_campo)).click();
	}
	
	public String obterValorCampo(String id_campo){
		return driver.findElement(By.xpath(id_campo)).getText();
	}
	
	public String obterValueCampo(String id_campo){
		return driver.findElement(By.xpath(id_campo)).getAttribute("value");
	}
	
	public void SelecionaCombo(String id_campo, String text){
		WebElement element = driver.findElement(By.xpath(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
	}
	
	public Object executarJS(String cmd, Object ...param){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}
	
}
