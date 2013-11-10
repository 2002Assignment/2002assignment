import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.lang.*;

public class MovieBookingApp {

	public static void main(String[] args) {
		
		Database db=new Database();
		
		ArrayList <Cineplex> cineplexList=(ArrayList)db.deserialize("Cineplexes.dat");
		ArrayList <Movie> movieList=(ArrayList)db.deserialize("Movies.dat");
	    ArrayList <Session> sessionList=(ArrayList)db.deserialize("Sessions.dat");
	    ArrayList <Booking> bookingList=(ArrayList)db.deserialize("Bookings.dat");
	    
		//atributes
		int displayChoice, movieChoice, movieC=0, cineChoice=0, timeChoice, row, col, ticketChoice = 0;
		boolean b=true, b1=true, b2=true, b3=true, b4=true;
		String cusName, phone, email;
		double price;
		Scanner sc = new Scanner(System.in);
		
		MovieGoer movieGoer = null;
		Booking booking;
	    int ticketType;
		
		
		System.out.println("Choose interface: 1. Customer  2. Administrator");
		
		int c = sc.nextInt();
		if(c == 2){
			Admin admin = new Admin();
			admin.main2();
		}
		else{

	    do {
	    	printMenu();
	    	
	    	displayChoice = sc.nextInt();
	    	
	    	switch(displayChoice) {
	    	case 1: printMovieMenu();
    	    movieChoice = sc.nextInt();
    	    if(movieChoice == 4){
    	    	b = false;
    	    	continue;
    	    }
    	    while (b){
    	        ArrayList newList = printMoviePeriod(movieChoice, movieList);
    	        movieC = sc.nextInt();
    	        if (movieC == 0){
    	        	b = false;
    	        	continue;
    	        }
    	        while (b1){
    	        	//printIndividualMovie(movieC-1, newList);
    	        	
    	        	ArrayList newList1 = printCineplex((Movie)newList.get(movieC), sessionList);
    	        	
        	        //choose the movie first then choose the cineplex
    	        	
        	       /* cineChoice = sc.nextInt();
        	        if (cineChoice == 0){
        	        	b1 = false;
        	        	continue;
        	        }
        	        */
        	       

        	        	//printSession(movie[movieC-1], cineplex[cineChoice-1]);
        	        timeChoice = sc.nextInt();
        	       	if (timeChoice == 0) {
        	       		b1 = false;
        	       		continue;
        	       	}
        	       		
        	       	while (b2) {
        	       		((Session)newList1.get(timeChoice-1)).printSessionLayout();
        	       		System.out.println("Choose the row: ");
                		row = sc.nextInt();
       	        		System.out.println("Choose the column: ");
       	        		col = sc.nextInt();
        	        		
       	        		if (!confirm()){
     
       	        			continue;
       	        		}
        	        		
        	        		
       	        		((Session)newList1.get(timeChoice-1)).assignSeat(row, col);
        	        		
       	        		while(b3){
        	        			
       	        			printTicketType();
       	        			ticketType = sc.nextInt();
        	        			
       	        			if (confirm()){
        	        			b3=false;	
        	        			break;
           	        		}
       	        			else{
       	        				b2=false;
       	        				break;
       	        			}
        	        			
        	        	}
        	        		
        	        		//get customer particulars..need another method?
        	        	System.out.println("Enter your name");
        	       		cusName = sc.next();
        	       		System.out.println("Enter your phone");
        	       		phone = sc.next();
        	      		System.out.println("Enter your email");
        	       		email = sc.next();
        	        		
        	       		movieGoer = new MovieGoer(cusName, phone, email);
        	        	booking = new Booking(row, col, ((Session)newList1.get(timeChoice-1)), movieGoer,ticketChoice);
        	       		
        	       		//price = calPrice(ticketChoice, (Session)newList1.get(timeChoice-1));
        	       		booking.printInvoice();
        	        		
        	     
        	       		System.out.println("Proceed to paying...");
        	       		if (!confirm()){
        	       			continue;
        	       		}
        	        		
        	        	bookingList.add(booking);
        	        	booking.printTicket();
        	        		
        	        	}
        	        
        	        	
        	        }
        	       
    	        
    	        
    	      
    	        
    	    }
    	    
	    		break;
	    	case 2:printCinemaMenu(cineplexList);
    	        cineChoice = sc.nextInt();
    	        if(cineChoice == 0){
    	        	b = false;
    	        	continue;
    	        }
    	        
    	        while (b){
        	       ArrayList newList = printMovieCine(sessionList, cineplexList.get(cineChoice-1));
        	       
            	   timeChoice = sc.nextInt();
            	   if (timeChoice == 0) {
            	        b = false;
            	       	continue;
            	       }
            	        		
            	   while (b1) {
            		   
           	       		((Session)newList.get(timeChoice-1)).printSessionLayout();
           	       		System.out.println("Choose the row: ");
                   		row = sc.nextInt();
          	        		System.out.println("Choose the column: ");
          	        		col = sc.nextInt();
           	        		
          	        		if (!confirm()){
        
          	        			continue;
          	        		}
           	        		
           	        		
          	        		((Session)newList.get(timeChoice-1)).assignSeat(row, col);
           	        		
          	        		while(b2){
           	        			
          	        			printTicketType();
          	        			ticketChoice = sc.nextInt();
           	        			
          	        			if (!confirm()){
            	        			b2=false;	
            	        			break;
               	        		}
           	        			else{
           	        				b1=false;
           	        				break;
           	        			}
           	        			
           	        			
           	        	}
           	        		
           	        		//get customer particulars..need another method?
          	        	sc.nextLine();
           	        	System.out.println("Enter your name:");
           	       		cusName = sc.nextLine();
           	       		System.out.println("Enter your phone:");
           	       		phone = sc.nextLine();
           	      		System.out.println("Enter your email:");
           	       		email = sc.nextLine();
           	        		
           	       		movieGoer = new MovieGoer(cusName, phone, email);
           	        	booking = new Booking(row, col, ((Session)newList.get(timeChoice-1)),movieGoer,ticketChoice);
           	       		
           	       		//price = calPrice(ticketChoice, (Session)newList.get(timeChoice-1));
           	       		booking.printInvoice();
           	        		
           	     
           	       		System.out.println("Proceed to paying...");
           	       		if (!confirm()){
           	       			b1 = true;
           	       			continue;
           	       		}
           	        		
           	        	//save new booking
           	       	    bookingList.add(booking);
           	        	booking.printTicket();
            	        		
           	        }
            	        
            	        	
            	       
            	       
       	        
        	        
        	      
        	        
       	    }
    	        break;
    	        
	    	case 3:
	    		System.out.println("Platium menu:");
	    		printCinemaMenu(cineplexList);
	    		cineChoice = sc.nextInt();
	    		
	    		if(cineChoice == 0){
	    			b = false;
	    			continue;
	    		}
	        
	            while (b){
	            	ArrayList newList = printMoviePlatium(sessionList, cineplexList.get(cineChoice));
    	        
	            	timeChoice = sc.nextInt();
	            	if (timeChoice == 0) {
	            		b = false;
	            		continue;
	            	}
            	        		
	            	while (b1) {
            		   
           	       		((Session)newList.get(timeChoice-1)).printSessionLayout();
           	       		System.out.println("Choose the row: ");
           	       		row = sc.nextInt();
           	       		System.out.println("Choose the column: ");
           	       		col = sc.nextInt();
           	        		
           	       		if (!confirm()){
        
           	       			continue;
           	       		}
           	        		
           	        		
           	       		((Session)newList.get(timeChoice-1)).assignSeat(row, col);
           	        		
           	       		while(b2){
           	        			
           	       			printTicketType();
           	       			ticketChoice = sc.nextInt();
           	        			
           	       			if (!confirm()){
           	        				
           	       				continue;
           	       			}
           	        			
           	        			
           	       		}
           	        		
           	       		//get customer particulars..need another method?
           	       		System.out.println("Enter your name");
           	       		cusName = sc.next();
           	       		System.out.println("Enter your phone");
           	       		phone = sc.next();
           	       		System.out.println("Enter your email");
           	       		email = sc.next();
           	        		
           	       		movieGoer = new MovieGoer(cusName, phone, email);
           	       		booking = new Booking(row, col, ((Session)newList.get(timeChoice-1)), movieGoer,ticketChoice);
           	       		
           	       		//price = calPrice(ticketChoice, (Session)newList.get(timeChoice-1));
           	       		booking.printInvoice();
           	        		
           	     
           	       		System.out.println("Proceed to paying...");
           	       		if (!confirm()){
           	       			continue;
           	       		}
           	        		
           	       		//save new booking
           	        	bookingList.add(booking);
           	       		booking.printTicket();	        		
	            	}
        	        
        	      
    	        
    	    }
	        break;
	    		
	    		
	    	case 4: 
	    		
	    		printHistory(movieGoer, bookingList);
	    		break;
	    		
	    		
	    		
	    	}
	    	
	    	
	    } while (displayChoice != 5);
		
		
		//System.out.println("Print");

		}
	}
	
	public static void printCinemaMenu(ArrayList<Cineplex> cineplexList){
		System.out.println("->>Cinemas:");
		int i = 1;
		
		for (Cineplex c : cineplexList){
			System.out.println(i + " " +c.getCineplexName());
			i++;
		}
		
		System.out.println("0. Exit");
	}
	
	
	public static void printMenu(){

		System.out.println("->>Display Menu:");
    	System.out.println("1. Movies");
    	System.out.println("2. Cineplexes");
    	System.out.println("3. Platimum movies");
    	System.out.println("4. My account");
    	System.out.println("5. Exit");
	}
	
	public static void printMovieMenu(){
		System.out.println("->>Movies:");
	    System.out.println("1. Now showing");
	    System.out.println("2. Coming soon");
	    System.out.println("3. Preview");
	    System.out.println("4. Exit");
	}
	
	public static ArrayList printMoviePeriod(int num, ArrayList<Movie> movieList){
	    
		int i = 1;
		ArrayList<Movie> newlist =new ArrayList<Movie>() ;
		System.out.println(num+"+"+movieList.get(0).toString());
	    switch(num){
	    case 1: //print now showing
	    
	    	for (Movie m : movieList){
	    		System.out.println(m.getMovieStatus());
	    		if (m.getMovieStatus().equals("NowShowing")){
	    			
	    	        System.out.println(i + ": " + m.getMovieName() +" " + m.getMovieType() +" " + m.getMovieLastTime() 
	    	        		+" " + m.getRating());
	    	        newlist.add(m);
	    		    i++;
	    		} 
	    	}
	    	/*Date currentDate = new Date();
	    	
	    	for (Movie m : movieList){
	    		if (currentDate.after(m.getMovieDateOn()) && currentDate.before(m.getMovieDateOff()))
	    	        System.out.println(m.getMovieName());
	    	    }
	    	*/
	    	break;
	    	
	    case 2: //print coming soon

	    	for (Movie m : movieList){
	    		if (m.getMovieStatus().equals("ComingSoon")){
	    	        System.out.println(i + ": " + m.getMovieName() +" " + m.getMovieType() +" " + m.getMovieLastTime()
	    	        		+" " + m.getRating());
	    	        newlist.add(m);
	    	        i++;
	    		}
	    	}
	    	
	    	
	    	break;
	    case 3: //print sneak preview   ????a new type??
	    	
	    	for (Movie m : movieList){
	    		if (m.getMovieStatus().equals("Preview")){
	    	        System.out.println(i + ": " + m.getMovieName()+" " + m.getMovieType()+" "  + m.getMovieLastTime()
	    	        		+" " + m.getRating());
	    			newlist.add(m);
	    			i++;
	    		}
	    	}
	    	break;
	    }
	    
	    System.out.println("0: Go back");
	    return newlist;
	}
	
	
    public static ArrayList printMovieCine(ArrayList<Session> sessionList, Cineplex cineplex){
	    
    	ArrayList<Session> newlist = new ArrayList<Session>();
    	int j = 1;
	    	
	    for(Session s : sessionList){
			if (s.getCineplex().getCineplexName().equals(cineplex.getCineplexName())){
				System.out.println( j + ": " + s.getMovie().getMovieName() +" " + s.getMovie().getMovieType()+
						" "  + s.getMovie().getMovieLastTime()+" " + s.getMovie().getRating());
				j++;
				newlist.add(s);
			}
    	}
	    
	    System.out.println("0: Go back");	
	    return newlist;
	}
    
    public static ArrayList printMoviePlatium(ArrayList<Session> sessionList, Cineplex cineplex){
	    
    	ArrayList<Session> newlist=new ArrayList<Session>();
    	int j = 1;
	    	
	    for(Session s : sessionList){
	    	for (int i = 0; i<cineplex.getCinema().length; i++){
		    	if (s.getCineplex().getCineplexName() == cineplex.getCineplexName() && !cineplex.getCinema()[i].isCinemaNormal()){
			    	System.out.println( j + ": " + s.getMovie().getMovieName() +" " + s.getMovie().getMovieType()+
				    		" "  + s.getMovie().getMovieLastTime()+" " + s.getMovie().getRating());
				    j++;
				    newlist.add(s);
		    	}
    	    }
	    }
	    System.out.println("0: Go back");	
	    return newlist;
    	
	}
    
    public static void printTicketType(){
	    
    	System.out.println("->>Ticket Type:");
        System.out.println("1. Normal");
        System.out.println("2. Elder");
        System.out.println("3. Child");
        System.out.println("4. Exit");
	}
	
	/*public static void printIndividualMovie(int num, ArrayList<Movie> newlist){
		
		Movie thismovie = newlist.get(num);
		
		System.out.println("Name: "+ thismovie.getMovieName());
		System.out.println("Name: "+ thismovie.getMovieName());
		
		
	}
	*/
	public static ArrayList printCineplex(Movie movie, ArrayList<Session> session){
		
		//how to find the cineplexes that show the movie???????
		ArrayList<Session> newlist=new ArrayList<Session>();
		Cineplex [] cineplexArray = new Cineplex[3];
		
		int i = 0, j = 1;
		
		for (Session s : session){
			cineplexArray[i] = s.getCineplex();
			System.out.println(cineplexArray[i].getCineplexName() + ":");
			for(Session s1 : session){
				if (movie.getMovieName() == s1.getMovie().getMovieName() && (s1.getCineplex()).equals(cineplexArray[i])){
					System.out.println( j + ": " + s.getCineplex());
					j++;
					newlist.add(s1);
				}
    		}
    	        
    		i++;
    	 }
		System.out.println("0: Go back");
		return newlist;
	}
	
	/*public static void printSession(Movie movie, Cineplex cineplex){
		//print the starting times of the movie
		
		for (Movie m : movieList){
    		if (currentDate.after(m.getMovieDateOn()) && currentDate.before(m.getMovieDateOff()))
    	        System.out.println(m.getMovieName());
    	    }
		
	}
	*/
	
	public static boolean confirm(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Confirm? (1. No; 2. yes)");
		return (sc.nextInt()==1)? false: true;
	}
	
	/*public static double calPrice(int ticketChoice, Session session){
		
		PriceSetting priceSetting = new PriceSetting();
		double price = priceSetting.getPriceBasic();
		
		String movieType = session.getMovie().getMovieType();
		int isNormal = session.getCinema().isCinemaNormal()? 1:0;
		
		switch(movieType){
		case "3D": price += priceSetting.getPrice3D();
			break;
		case "Blockbuster": price += priceSetting.getPriceBlockbuster();
			break;
		}
		
		if(isNormal == 0)
			price += priceSetting.getPricePlatium();
		
		
		switch(ticketChoice){
		case 2: price *= priceSetting.getDiscountSenior();
		case 3: price *= priceSetting.getDiscountChild();
		}
		return price;
	} */

	public static void printHistory(MovieGoer movieGoer, ArrayList<Booking> bookingList){
		
		int j = 1;
    	
	    for(Booking b : bookingList){
			if(b.getMovieGoer() == movieGoer)
				System.out.println( j + ": " + b.getMovieGoer().getName() +" " + b.getSession().getMovie().getMovieName()+
						" "  + b.getSession().getMovie().getMovieDateOn()+" " + b.getSession().getCineplex().getCineplexName()+
						" "  + b.getRow() + " " + b.getColumn()+" "  + b.getSession().getSessionTicketPrice());
			
			
    	}
	    
	   
	}
}
