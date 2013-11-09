import java.util.*;
import java.io.*;

public class SettingPrice {
	private double basicPrice;
	private double []price;
	public enum Price{
		DIGITAL, M3D, BLOCKBUSTER, NORMAL, PLATINUM, CHILDREN,ADULT, SENIOR,HOLIDAY
	}
	public String[] PriceType={"DIGITAL", "M3D", "BLOCKBUSTER", "NORMAL", "PLATINUM", "CHILDREN","ADULT", "SENIOR","HOLIDAY"};
	//constructor 
	SettingPrice(){
		basicPrice=8;
		price=new double[8]; 
				
		for (int counter=0; counter < 8; counter++) {
		     int index = 0;
		     index++;
		     price[index] = 0;
	    }
	}
	public void setBasicPrice(){
		System.out.println("please input the basic price for movie: ");
		Scanner sc=new Scanner(System.in);
		this.basicPrice=sc.nextDouble();
	}
	public void setTypePrice(){
		System.out.println("please input the price adding to basic price for the following types: ");
		
	}

}
