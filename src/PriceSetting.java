import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class PriceSetting implements Serializable{
	
	private double priceBasic;  //digital and normal cinema adult price
	
	private double price3D;
	private double priceBlockbuster;
	private double pricePlatium;
	private double priceHoliday;
	private double discountSenior;
	private double discountChild;
	
	// constructor
	public PriceSetting(){
		this.priceBasic = 10;
		this.price3D = 2;
		this.priceBlockbuster = 1.5;
		this.pricePlatium = 5;
		this.priceHoliday = 2;
		this.discountSenior = 0.85;
		this.discountChild = 0.8;
	}
	
	public PriceSetting(double priceBasic, double price3d,
			double priceBlockbuster, double pricePlatium, double priceHoliday,
			double discountSenior, double discountChild) {
		
		this.priceBasic = priceBasic;
		this.price3D = price3d;
		this.priceBlockbuster = priceBlockbuster;
		this.pricePlatium = pricePlatium;
		this.priceHoliday = priceHoliday;
		this.discountSenior = discountSenior;
		this.discountChild = discountChild;
	}
	
	public double getPriceBasic() {
		return priceBasic;
	}
	public void setPriceBasic() {
		System.out.println("Set the basic price for adult who watch digital movie in normal cinema: ");
		Scanner sc= new Scanner(System.in);
		this.priceBasic = sc.nextDouble();
	}
	public double getPrice3D() {
		return price3D;
	}
	public void setPrice3D() {
		double priceBasic;
		System.out.println("Set the price difference btween 3D and digital movie: ");
		Scanner sc= new Scanner(System.in);
		this.price3D = sc.nextDouble();
	}
	public double getPriceBlockbuster() {
		return priceBlockbuster;
	}
	public void setPriceBlockbuster() {
		System.out.println("Set the price difference btween blockbuster and digital movie: ");
		Scanner sc= new Scanner(System.in);
		this.priceBlockbuster = sc.nextDouble();
	}
	public double getPricePlatium() {
		return pricePlatium;
	}
	public void setPricePlatium() {
		System.out.println("Set the price difference btween platium and normal cinema: ");
		Scanner sc= new Scanner(System.in);
		this.pricePlatium = sc.nextDouble();
	}
	public double getPriceHoliday() {
		return priceHoliday;
	}
	public void setPriceHoliday() {
		System.out.println("Set the price difference btween Holiday and normal day: ");
		Scanner sc= new Scanner(System.in);
		this.priceHoliday = sc.nextDouble();
	}
	public double getDiscountSenior() {
		return discountSenior;
	}
	public void setDiscountSenior() {
		System.out.println("Set the discount for senior member: ");
		Scanner sc= new Scanner(System.in);
		this.discountSenior = sc.nextDouble();
	}
	public double getDiscountChild() {
		return discountChild;
	}
	public void setDiscountChild() {
		System.out.println("Set the discount for child member: ");
		Scanner sc= new Scanner(System.in);
		this.discountChild = sc.nextDouble();
	}
	@Override
	public String toString() {
		return "PriceSetting [priceBasic=" + priceBasic + ", price3D="
				+ price3D + ", priceBlockbuster=" + priceBlockbuster
				+ ", pricePlatium=" + pricePlatium + ", priceHoliday="
				+ priceHoliday + ", discountSenior=" + discountSenior
				+ ", discountChild=" + discountChild + "]";
	}
	
	public void setAllPrice(){
		int choice;
		do {
		System.out.println("The current price setting : ");
		System.out.println(this.toString());
		System.out.println("->>Price Setting Menu:  Note besides basic price, others are incremental price based on basic price");
    	System.out.println("1. basic price");
    	System.out.println("2. blockBuster+");
    	System.out.println("3. platium+");
    	System.out.println("4. holiday+");
    	System.out.println("5. senior discount(eg : 0.8)");
    	System.out.println("5. child discount(eg : 0.8)");
    	System.out.println("6. EXIT");
		Scanner sc=new Scanner(System.in);
		choice=sc.nextInt();
		switch (choice){
		case 1:this.setPriceBasic();break;
		case 2:this.setPriceBlockbuster();break;
		case 3:this.setPricePlatium();break;
		case 4:this.setPriceHoliday();break;
		case 5:this.setDiscountSenior();break;
		case 6:this.setDiscountChild();break;
		default:System.out.println("End of setting price");
		}
		}while (choice<6);
		
		
		
		
	}
	
}
