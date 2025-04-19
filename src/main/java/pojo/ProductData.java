package pojo;

public class ProductData {

	private String searchKey;
	private String productName;
	private int imageCount;
	private String brand;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getImageCount() {
		return imageCount;
	}

	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ProductData [searchKey=" + searchKey + ", productName=" + productName + ", imageCount=" + imageCount
				+ ", brand=" + brand + "]";
	}
	
	
	
	

}
