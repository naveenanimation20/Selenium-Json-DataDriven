package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.type.TypeReference;

import pages.ProductPage;
import pojo.ProductData;
import util.JsonDataReader;

public class ProductPageTest {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("dec2024@opencart.con");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@DataProvider
	public Object[][] getProductTestData() {
		return JsonDataReader.readJsonAsDataProvider("./src/test/resources/data/product.json",
				new TypeReference<List<ProductData>>() {
				});
	}

	@Test(dataProvider = "getProductTestData")
	public void productInfoTest(ProductData product) {
		System.out.println("data used: "+ product);
		
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(product.getSearchKey());
		driver.findElement(By.cssSelector("div#search button")).click();
		driver.findElement(By.linkText(product.getProductName())).click();

		ProductPage productPage = new ProductPage(driver);
		String actualHeader = productPage.getProductHeader();
		String actualBrand = productPage.getProductBrand();
		int actProductImageCount = productPage.getProductImages();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualHeader, product.getProductName());
		softAssert.assertEquals(actualBrand, product.getBrand());
		softAssert.assertEquals(actProductImageCount, product.getImageCount());

		softAssert.assertAll();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
