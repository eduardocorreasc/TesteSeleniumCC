import org.openqa.selenium.WebDriver;

public class ComprarProdutoPage {
	private DSL DSL;

	public ComprarProdutoPage(WebDriver driver) {
		DSL = new DSL(driver);
	}
	
	public void SelecionaProduto() {
		DSL.ClickaButton("//*[@id=\"main\"]/ul/li[1]/a[1]/img");
	}
	
	public void VerCarrinho() {
		DSL.ClickaButton("//*[@id=\"content\"]/div/div[1]/div/a");
	}
	
	public void SelecionaComboOrdenacao(String text) {
		DSL.SelecionaCombo("//*[@id=\"main\"]/div[1]/form/select", text);
	}
	public String RetornaProduto(){
		return DSL.obterValorCampo("//*[@id=\"product-74\"]/div[2]/h1");
	}
	
	public String RetornaValorProduto(){
		return DSL.obterValorCampo("//*[@id=\"product-74\"]/div[2]/p/span/bdi");
	}
	
	public String RetornaPodutoTelaFinal(){
		return DSL.obterValorCampo("//*[@id=\"order_review\"]/table/tbody/tr/td[1]");
	}
	
	public String RetornaValorPodutoTelaFinal(){
		return DSL.obterValorCampo("//*[@id=\"order_review\"]/table/tbody/tr/td[2]/span/bdi");
	}
	
	
	public void ClickaComprar() {
		DSL.ClickaButton("//*[@id=\"product-74\"]/div[2]/form/button");
	}
	
	public String RetornaProdutoCarrinho(){
		return DSL.obterValorCampo("//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[3]/a");
	}
	
	public void VaiParaFinalizarCompra() {
		DSL.ClickaButton("//*[@id=\"post-7\"]/div/div/div[2]/div/div/a");
	}
	
	public void SetNome(String text) {
		DSL.Escreve("//*[@id=\"billing_first_name\"]", text);
	}
	
	public void SetSobrenome(String text) {
		DSL.Escreve("//*[@id=\"billing_last_name\"]", text);
	}
	
	public void SetCPF(String text) {
		DSL.Escreve("//*[@id=\"billing_cpf\"]", text);
	}
	
	public void SetCEP(String text) {
		DSL.Escreve("//*[@id=\"billing_postcode\"]", text);
	}
	
	public void SetEndereco(String text) {
		DSL.Escreve("//*[@id=\"billing_address_1\"]", text);
	}

	public void SetNumero(String text) {
		DSL.Escreve("//*[@id=\"billing_number\"]", text);
	}
	
	public void SetCidade(String text) {
		DSL.Escreve("//*[@id=\"billing_city\"]", text);
	}
	
	public void SetTelefone(String text) {
		DSL.Escreve("//*[@id=\"billing_phone\"]", text);
	}
	
	public void SetEmail(String text) {
		DSL.Escreve("//*[@id=\"billing_email\"]", text);
	}
	
	public void SelecionaPix() {
		DSL.ClickaButton("//*[@id=\"payment\"]/ul/li[3]/label");
	}
	
	public void ClickaFinalizarPedido() {
		DSL.ClickaButton("//*[@id=\"place_order\"]");
	}
	
	public String RetornaValorPosCompra(){
		return DSL.obterValorCampo("//*[@id=\"post-8\"]/div/div/div/ul/li[4]/strong/span/bdi");
	}
	
	public String RetornaEmailPosCompra(){
		return DSL.obterValorCampo("//*[@id=\"post-8\"]/div/div/div/ul/li[3]/strong");
	}
	
	public String RetornaTipoPagamentoPosCompra(){
		return DSL.obterValorCampo("//*[@id=\"post-8\"]/div/div/div/ul/li[5]/strong");
	}
}
