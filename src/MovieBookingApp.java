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
    	   
    	    while (movieChoice != 4){
    	        ArrayList newList = printMoviePeriod(movieChoice, movieList);
    	        movieC = sc.nextInt();
    	        if (movieC == 0)
    	        	b1 = false;
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
        	       		b2 = false;
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
        	        	booking = new Booking(price ,row, col, ((Session)newList1.get(timeChoice-1)), movieGoer);
        	       		
        	       		price = calPrice(ticketChoice, (Session)newList1.get(timeChoice-1));
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
    	        
    	        while (cineChoice != 0){
        	       ArrayList newList = printMovieCine(sessionList, cineplexList.get(cineChoice-1));
        	       
            	   timeChoice = sc.nextInt();
            	   if (timeChoice == 0) {
            	        b2 = false;
            	       	continue;
            	       }
            	        		
            	   while (b2) {
            		   
           	       		((Session)newList.get(timeChoice-1)).printSessionLayout();
           	       		System.out.println("Choose the row: ");
                   		row = sc.nextInt();
          	        		System.out.println("Choose the column: ");
          	        		col = sc.nextInt();
           	        		
          	        		if (!confirm()){
        
          	        			continue;
          	        		}
           	        		
           	        		
          	        		((Session)newList.get(timeChoice-1)).assignSeat(row, col);
           	        		
          	        		while(b3){
           	        			
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
           	        	booking = new Booking(price,row, col, ((Session)newList.get(timeChoice-1)), movieGoer);
           	       		
           	       		price = calPrice(ticketChoice, (Session)newList.get(timeChoice-1));
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
    	        
	    	case 3:
	    		System.out.println("Platinum menu:");
	    		printCinemaMenu(cineplexList);
	    		cineChoice = sc.nextInt();
	        
	            while (cineChoice != 0){
	            	ArrayList newList = printMoviePlatinum(sessionList, cineplexList.get(cineChoice));
    	        
	            	timeChoice = sc.nextInt();
	            	if (timeChoice == 0) {
	            		b2 = false;
	            		continue;
	            	}
            	        		
	            	while (b2) {
            		   
           	       		((Session)newList.get(timeChoice-1)).printSessionLayout();
           	       		System.out.println("Choose the row: ");
           	       		row = sc.nextInt();
           	       		System.out.println("Choose the column: ");
           	       		col = sc.nextInt();
           	        		
           	       		if (!confirm()){
        
           	       			continue;
           	       		}
           	        		
           	        		
           	       		((Session)newList.get(timeChoice-1)).assignSeat(row, col);
           	        		
           	       		while(b3){
           	        			
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
           	       		booking = new Booking(price,row, col, ((Session)newList.get(timeChoice-1)), movieGoer);
           	       		
           	       		price = calPrice(ticketChoice, (Session)newList.get(timeChoice-1));
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
    	System.out.println("2. Cinemas");
    	System.out.println("3. Platimum movies");
    	System.out.println("4. My account");
    	System.out.println("5. Exit");
	}
	
	public static void printMovieMenu(){
		System.out.println("->>Movies:");
	    System.out.println("1. Now showing");
	    System.out.println("2. Coming soon");
	    System.out.println("3. Sneak preview");
	    System.out.println("4. Exit");
	}
	
	public static ArrayList printMoviePeriod(int num, ArrayList<Movie> movieList){
	    
		int i = 1;
		ArrayList newlist = null ;
		
	    switch(num){
	    case 1: //print now showing
	    
	    	for (Movie m : movieList){
	    		if (m.getMovieStatus() == "Now Showing"){
	    			
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
	    		if (m.getMovieStatus() == "Coming soon"){
	    	        System.out.println(i + ": " + m.getMovieName() +" " + m.getMovieType() +" " + m.getMovieLastTime()
	    	        		+" " + m.getRating());
	    	        newlist.add(m);
	    	        i++;
	    		}
	    	}
	    	
	    	
	    	break;
	    case 3: //print sneak preview   ????a new type??
	    	
	    	for (Movie m : movieList){
	    		if (m.getMovieStatus() == "Sneaker Preview")
	    	        System.out.println(i + ": " + m.getMovieName()+" " + m.getMovieType()+" "  + m.getMovieLastTime()
	    	        		+" " + m.getRating());
	    			newlist.add(m);
	    			i++;
	    	    }
	    	break;
	        }
	    
	    System.out.println("0: Go back");
	    return newlist;
	}
	
	
    public static ArrayList printMovieCine(ArrayList<Session> sessionList, Cineplex cineplex){
	    
    	ArrayList newlist = null;
    	int j = 1;
	    	
	    for(Session s : sessionList){
			if (s.getCineplex().getCineplexName() == cineplex.getCineplexName()){
				System.out.println( j + ": " + s.getMovie().getMovieName() +" " + s.getMovie().getMovieType()+
						" "  + s.getMovie().getMovieLastTime()+" " + s.getMovie().getRating());
				j++;
				newlist.add(s);
			}
    	}
	    
	    System.out.println("0: Go back");	
	    return newlist;
	}
    
    public static ArrayList printMoviePlatinum(ArrayList<Session> sessionList, Cineplex cineplex){
	    
    	ArrayList newlist = null;
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
        System.out.println("3. Student");
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
		
		ArrayList newlist = null;
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
	
	public static double calPrice(int ticketChoice, Session session){
		
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
			price += priceSetting.getPricePlatinum();
		
		
		switch(ticketChoice){
		case 2: price *= priceSetting.getPriceSenior();
		case 3: price *= priceSetting.getPriceStudent();
		}
		return price;
	}

	public static void printHistory(MovieGoer movieGoer, ArrayList<Booking> bookingList){
		
		int j = 1;
    	
	    for(Booking b : bookingList){
			if(b.getMovieGoer() == movieGoer)
				System.out.println( j + ": " + b.getMovieGoer().getCusName() +" " + b.getSession().getMovie().getMovieNme()+
						" "  + b.getSession().getMovie().getMovieDateOn()+" " + b.getSession().getCineplex().getCineplexName()+
						" "  + b.getRow() + " " + b.getCol()+" "  + b.getSession().getPrice());
			
			
    	}
	    
	   
	}
}
