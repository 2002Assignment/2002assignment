import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class PriceSetting implements Serializable{
	
	private double priceBasic;  //digital and normal cinema adult price
	
	private double price3D;
	//private double priceBlockbuster;
	private double pricePlatinum;
	private double priceHoliday;
	private double discountSenior;
	private double discountChild;
	
	// constructor
	public PriceSetting(){
		this.priceBasic = 10;
		this.price3D = 3;
		this.pricePlatinum = 5;
		this.priceHoliday = 2;
		this.discountSenior = 0.85;
		this.discountChild = 0.8;
	}
	
	public PriceSetting(double priceBasic, double price3d,
			double priceBlockbuster, double pricePlatinum, double priceHoliday,
			double discountSenior, double discountChild) {
		
		this.priceBasic = priceBasic;
		this.price3D = price3d;
		this.pricePlatinum = pricePlatinum;
		this.priceHoliday = priceHoliday;
		this.discountSenior = discountSenior;
		this.discountChild = discountChild;
	}
	
	public double getPriceBasic() {
		return priceBasic;
	}
	public void setPriceBasic() {
		System.out.println("#Set the basic price for adult who watch digital movie in normal cinema: ");
		Scanner sc= new Scanner(System.in);
		this.priceBasic = sc.nextDouble();
	}
	public double getPrice3D() {
		return price3D;
	}
	public void setPrice3D() {
		double priceBasic;
		System.out.println("#Set the price difference btween 3D and 2D /digital movie: ");
		Scanner sc= new Scanner(System.in);
		this.price3D = sc.nextDouble();
	}
	public double getPricePlatinum() {
		return pricePlatinum;
	}
	public void setPricePlatinum() {
		System.out.println("#Set the price difference btween platinum and normal cinema: ");
		Scanner sc= new Scanner(System.in);
		this.pricePlatinum = sc.nextDouble();
	}
	public double getPriceHoliday() {
		return priceHoliday;
	}
	public void setPriceHoliday() {
		System.out.println("#Set the price difference btween Holiday and normal day: ");
		Scanner sc= new Scanner(System.in);
		this.priceHoliday = sc.nextDouble();
	}
	public double getDiscountSenior() {
		return discountSenior;
	}
	public void setDiscountSenior() {
		System.out.println("#Set the discount for senior member: ");
		Scanner sc= new Scanner(System.in);
		this.discountSenior = sc.nextDouble();
	}
	public double getDiscountChild() {
		return discountChild;
	}
	public void setDiscountChild() {
		System.out.println("#Set the discount for child member: ");
		Scanner sc= new Scanner(System.in);
		this.discountChild = sc.nextDouble();
	}
	@Override
	public String toString() {
		return "PriceSetting [priceBasic=" + priceBasic + ", price3D="
				+ price3D
				+ ", pricePlatinum=" + pricePlatinum + ", priceHoliday="
				+ priceHoliday + ", discountSenior=" + discountSenior
				+ ", discountChild=" + discountChild + "]";
	}
	
	public void printPriceSetting(){
		System.out.println("================Price Settings===============");
		System.out.println("1. Basic price          "+priceBasic);
    	System.out.println("2. Platinum+(basic price)"+pricePlatinum);
    	System.out.println("3. Holiday+(basic price)"+priceHoliday);
    	System.out.println("4. Senior discount      "+discountSenior);
    	System.out.println("5. Child discount       "+discountChild);
	}
	public PriceSetting setAllPrice(){
		int choice;
		do {
		this.printPriceSetting();
		System.out.println("=====================Price Settings====================");
		System.out.println("->>Price Setting Menu:  Note besides basic price, others are incremental price based on basic price");
    	System.out.println("1. Basic price                      "+priceBasic);
    	System.out.println("2. 3D price+(basic price)           "+price3D);
    	System.out.println("3. Platinum +(basic price)          "+pricePlatinum);
    	System.out.println("4. Holiday +(basic price)           "+priceHoliday);
    	System.out.println("5. Senior discount(eg : 0.8=20% OFF)"+discountSenior);
    	System.out.println("6. Child discount(eg : 0.8=20% OFF) "+discountChild);
    	System.out.println("7. EXIT");
		Scanner sc=new Scanner(System.in);
		choice=sc.nextInt();
		switch (choice){
		case 1:this.setPriceBasic();break;
		case 2:this.setPrice3D();break;
		case 3:this.setPricePlatinum();break;
		case 4:this.setPriceHoliday();break;
		case 5:this.setDiscountSenior();break;
		case 6:this.setDiscountChild();break;
		default:System.out.println("===============End of setting price=================");
		}
		}while (choice<7);
		return this;
		
	}
	
}