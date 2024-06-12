import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

public class Main {
	private WebDriver driver;
	private DSL DSL;
	private ComprarProdutoPage page;
	
	public void start(){
		System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "\\src\\test\\chromedriver.exe");
		driver = new ChromeDriver();
		driver = new ChromeDriver();
		DSL = new DSL(driver);
		page = new ComprarProdutoPage(driver);
		
		driver.manage().window().maximize();
		driver.get("https://challenge.homolog.tech/");
	}
	
	   public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination
	                com.google.common.io.Files.copy(SrcFile, DestFile);
	    }
	
	@Test
	public void ComprarProduto() throws Exception{
		
		 // Configura o WebDriver no ReportManager
        ReportManager reportManager = new ReportManager();
        reportManager.setWebDriver(driver);
	     reportManager.startReport();
	        
		start();
		reportManager.createTest("Teste comprar produto");
		page.SelecionaComboOrdenacao("Ordenar por popularidade");
		page.SelecionaProduto();
		String nomeProduto = page.RetornaProduto();
		Thread.sleep(5000);
		String valorProduto = page.RetornaValorProduto();
		System.out.println(valorProduto);
		//System.out.println(DSL.obterValueCampo("//*[@id=\"product-74\"]/div[2]/p/span/bdi/text()"));
		Thread.sleep(3000);
		page.ClickaComprar();
		page.VerCarrinho();
		Thread.sleep(3000);
		
		//Valida se produto que foi selecionado é o mesmo que está no carrinho
        if (nomeProduto.equals(page.RetornaProdutoCarrinho())) {
            reportManager.logStatus(Status.PASS, "Produto no carrinho igual ao selecionado");
        } else {;
            reportManager.logStatus(Status.FAIL, "Produto diferente do selecionado");
            this.takeSnapShot(driver, System.getProperty("user.dir") + "\\src\\test\\test.png") ;       
        }   
        
        page.VaiParaFinalizarCompra();
        Thread.sleep(2000);
        
      //Valida se produto que foi selecionado é o mesmo que está na finalização de compra
        if ((nomeProduto + "  × 1").equals(page.RetornaPodutoTelaFinal())) {
            reportManager.logStatus(Status.PASS, "Produto na tela final igual ao selecionado");
        } else {;
            reportManager.logStatus(Status.FAIL, "Produto na tela final diferente ao selecionado");
            this.takeSnapShot(driver, System.getProperty("user.dir") + "\\src\\test\\test.png") ;       
        }
        
      //Valida se o valor do produto que foi selecionado é o mesmo que está na finalização de compra
        if (valorProduto.equals(page.RetornaValorPodutoTelaFinal())) {
            reportManager.logStatus(Status.PASS, "Valor do produto na tela final igual ao selecionado");
        } else {;
            reportManager.logStatus(Status.FAIL, "Valor do produto na tela final diferente ao selecionado");
            this.takeSnapShot(driver, System.getProperty("user.dir") + "\\src\\test\\test.png") ;       
        }
        
        page.SetNome("Mateus");
        page.SetSobrenome("Santos");
        page.SetCPF("283.441.990-69");
        Thread.sleep(2000);
        page.SetCEP("13036222");
        page.SetEndereco("Avenida brasil");
        page.SetNumero("29");
        page.SetCidade("Belo Horizonte");
        page.SetTelefone("47999322244");
        page.SetEmail("teste4@outlook.com");
        Thread.sleep(2000);
        page.SelecionaPix();
        Thread.sleep(2000);
        page.ClickaFinalizarPedido();
        Thread.sleep(5000);
        
      //Valida se o valor do produto que foi selecionado é o mesmo que está no pós compra
        if (valorProduto.equals(page.RetornaValorPosCompra())) {
            reportManager.logStatus(Status.PASS, "Valor do produto na tela pós compra");
        } else {;
            reportManager.logStatus(Status.FAIL, "Valor do produto na tela pós compra");
            this.takeSnapShot(driver, System.getProperty("user.dir") + "\\src\\test\\test.png") ;       
        }
        
        
      //Valida se o email informado é o mesmo que está na tela de pós compra
        if (("teste4@outlook.com").equals(page.RetornaEmailPosCompra())) {
            reportManager.logStatus(Status.PASS, "Email é igual ao informado no pedido");
        } else {;
            reportManager.logStatus(Status.FAIL, "Email diferente do informado no pedido");
            this.takeSnapShot(driver, System.getProperty("user.dir") + "\\src\\test\\test.png") ;       
        }
        
      //Valida se a forma de pagamento é igual a informada no pedido
        if (("Getnet PIX").equals(page.RetornaTipoPagamentoPosCompra())) {
            reportManager.logStatus(Status.PASS, "Tipo de pagamento é igual ao informado no pedido");
        } else {;
            reportManager.logStatus(Status.FAIL, "Tipo de pagamento é diferente do informado no pedido");
            this.takeSnapShot(driver, System.getProperty("user.dir") + "\\src\\test\\test.png") ;       
        }
       
        //driver.quit();
        reportManager.endReport();
		
	}
	
	
}
