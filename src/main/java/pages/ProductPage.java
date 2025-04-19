package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	private WebDriver driver;
	
	private final By header = By.tagName("h1");
	private final By images = By.cssSelector("a.thumbnail>img");
	private final By brand = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li[1]");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductHeader() {
		return driver.findElement(header).getText();
	}
	
	public int getProductImages() {
		return driver.findElements(images).size();
	}
	
	public String getProductBrand() {
		String brandValue = driver.findElement(brand).getText();//Brand : Apple
		return brandValue.split(":")[1].trim();
	}

}
