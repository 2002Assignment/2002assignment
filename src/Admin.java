import java.util.Scanner;

public class Admin {
	private String accessKey="123456";

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void main2(){
		int choice=0;
		Staff staff=new Staff();
	    if(staff.inputPwd().equals(accessKey)){
		do{
			System.out.println("----Welcome to Admin System----");
			System.out.println("1.add movie");
			System.out.println("2.add movie session");
			System.out.println("3.update movie");
			System.out.println("4.set price");
			System.out.println("5.set public holiday");
			System.out.println("6.generate revenue report");
			System.out.println("7.quit");
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice){
			case 1:
				staff.addMovie();
				
				break;
			case 2:
				staff.movieSession();
				break;
			case 3:
				staff.updateMoive();
				break;
			case 4:
				System.out.println("Please enter the price:");
				staff.setPrice(sc.nextDouble());
				
				break;
			case 5:
				System.out.println("Please set public holiday:");
				staff.setPublicHoliday();//???????????????
				
				break;
			case 6:
				System.out.println("__________");
				System.out.println("1)by period;2)by movie;3)by cineplex");
				switch(sc.nextInt()){
				case 1:
					staff.generateRevenueReportByPeriod();
					break;
				case 2:
					staff.generateRevenueReportByMovie();
					break;
				case 3:
					staff.generateRevenueReportByCineplex();
					break;
				default:
					System.out.println("Invalid Access");
				}
				break;
			}
		
		}while(choice<7);
	}
	
	}
	else {
		return 0;
	}
}
