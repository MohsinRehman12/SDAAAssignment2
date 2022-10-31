package Assignement2SDAAGroup17;

//Creates a Product object

public class Product {

	private String name;
	private int UPCCode;
	private double price;

		//constructor method for product using its UPCCode name and Price
		
		public Product(String name, double price, int UPCCode){
			this.UPCCode = UPCCode;
			this.name = name;
			this.price = price;
		}

		//Setter for UPC
		
		public void setUPCCode(int UPCCode) {

			this.UPCCode = UPCCode;

		}


		 //getter for UPC
		 
		public int getUPCCode() {

			return UPCCode;

		}

		//getter for price

		public double getPrice() {
		return price;
	}



	//Represents the Product object as a string
		 
		@Override
		public String toString() {
			return "Product name:"  + name + " Code=" + UPCCode  + ':' + ", price=" + price + '}';
		}
}

