import java.util.ArrayList;
import java.util.Scanner; 
import java.util.Arrays;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Random;

public class MovieBookingApp {

	public static void main(String[] args) {
		
		ArrayList <Cineplex> cineplexList=(ArrayList)Database.deserialize("Cineplexes.dat");
		ArrayList <Movie> movieList=(ArrayList)Database.deserialize("Movies.dat");
	    ArrayList <Session> sessionList=(ArrayList)Database.deserialize("Sessions.dat");
	    ArrayList <Booking> bookingList=(ArrayList)Database.deserialize("Bookings.dat");
	    
		//Attributes
		int displayChoice, movieChoice, movieC=0, cineChoice=0, timeChoice, row, col;
		boolean b=true, b1=true, b2=true, b3=true, b4=true;
		String cusName, phone, email;
		Scanner sc = new Scanner(System.in);
		
		MovieGoer movieGoer = null;
		Booking booking;
	    int ticketType=0;
	    boolean isAssigned;
	    
		
	    System.out.println("================Welcome================");
		System.out.print  ("Choose interface: 1. Customer  2. Admin\n>>");
		
		int c = sc.nextInt();
		if(c == 2){
			Admin admin = new Admin();
			try {
				admin.main2();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{

	    do {
	    	
	    	mainMenu:{
	    	
	    	
	    	b = true; b1 = true; b2 = true; b3 = true;
	    	printMenu();
	    	
	    	displayChoice = sc.nextInt();
	    	
	    	switch(displayChoice) {
	    	case 1: printMovieMenu();
    	    movieChoice = sc.nextInt();
    	    if(movieChoice == 5){
    	    	b = false;
    	    	continue;
    	    }
    	    while (b){
    	    	
    	    	
    	    	b1 = true; b2 = true; b3 = true;
    	        ArrayList newList = printMoviePeriod(movieChoice, movieList);
    	        movieC = sc.nextInt();
    	        if (movieC == 0){
    	        	b = false;
    	        	continue;
    	        }
    	        
    	        while (b1){
    	        	b2 = true; b3 = true;
    	        	ArrayList newList1 = printCineplex((Movie)newList.get(movieC-1), sessionList, cineplexList);
        	        timeChoice = sc.nextInt();
        	       	if (timeChoice == 0) {
        	       		b1 = false;
        	       		continue;
        	       	}
        	       		
        	       	while (b2) {
        	       		b3 = true;
        	       		((Session)newList1.get(timeChoice-1)).printSessionLayout();
        	       		System.out.println("Choose the row: ");
                		row = sc.nextInt();
       	        		System.out.println("Choose the column: ");
       	        		col = sc.nextInt();
        	        		
       	        		if (!confirm()){
     
       	        			continue;
       	        		}
        	        		
       	        		isAssigned = ((Session)newList1.get(timeChoice-1)).assignSeat(row, col);	
       	        		
        	        	if(!isAssigned){
        	        		continue;
        	        	}
        	        	
       	        		while(b3){
        	        			
       	        			printTicketType();
       	        			ticketType = sc.nextInt();
       	        			if(ticketType == 4)
       	        				break mainMenu;
       	        				
       	        			
       	        			if (confirm()){
        	        			b3 = false;	
        	        			
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
        	        	booking = new Booking(row, col, ((Session)newList1.get(timeChoice-1)), movieGoer,ticketType);
        	       		
        	       		//price = calPrice(ticketType, (Session)newList1.get(timeChoice-1));
        	       		booking.printInvoice();
        	        		
        	     
        	       		
        	       		if (!confirm()){
        	       			((Session)newList1.get(timeChoice-1)).unAssignSeat(row, col);
        	       			continue;
        	       		}
        	       		
        	       		System.out.println("Proceed to paying...");
        	       		
        	       		Database.serialize(sessionList, "Sessions.dat");
        	       		
        	 
        	       		
        	        	bookingList.add(booking);
        	        	Database.serialize(bookingList, "Bookings.dat");
        	        	booking.printTicket();
        	        	b1 = false; b2 = false;
        	        		
        	        	}
        	        
        	        	
        	        }
     
    	    }
    	    
	    		break;
	    	case 2:printCineplexMenu(cineplexList);
    	        cineChoice = sc.nextInt();
    	        if(cineChoice == 0){
    	        	b = false;
    	        	continue;
    	        }
    	        
    	        while (b){
    	        	
    	        	b1 = true; b2 = true;
        	       ArrayList newList = printMovieCine(sessionList, cineplexList.get(cineChoice-1));
        	       
            	   timeChoice = sc.nextInt();
            	   if (timeChoice == 0) {
            	        b = false;
            	       	continue;
            	       }
            	        		
            	   while (b1) {
            		    b2 = true;
           	       		((Session)newList.get(timeChoice-1)).printSessionLayout();
           	       		System.out.println("Choose the row: ");
                   		row = sc.nextInt();
          	        		System.out.println("Choose the column: ");
          	        		col = sc.nextInt();
          	        		
          	        		isAssigned = ((Session)newList.get(timeChoice-1)).assignSeat(row, col);
          	        		if (!confirm()){
        
          	        			continue;
          	        		}
           	        		
          	        		if(!isAssigned){
            	        		continue;
            	        	}
           	        		
          	        		while(b2){
           	        			
          	        			printTicketType();
          	        			ticketType = sc.nextInt();
           	        			
          	        			if(ticketType == 4)
           	        				break mainMenu;
          	        			
          	        			if (confirm()){
            	        			b2=false;	
            	        			
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
           	        	booking = new Booking(row, col, ((Session)newList.get(timeChoice-1)),movieGoer,ticketType);
           	       		
           	       		//price = calPrice(ticketType, (Session)newList.get(timeChoice-1));
           	       		booking.printInvoice();
           	        		  		
           	       		if (!confirm()){
           	       			((Session)newList.get(timeChoice-1)).unAssignSeat(row, col);
           	       			b1 = true;
           	       			continue;
           	       		}
           	        		
           	       	    System.out.println("Proceed to paying...");
           	        	//save new booking
           	       		
           	       	    Database.serialize(sessionList, "Sessions.dat");
           	       	    bookingList.add(booking);
           	       	    Database.serialize(bookingList, "Bookings.dat");
           	        	booking.printTicket();
           	        	b1 = false;
            	        		
           	        }

        	        
       	    }
    	        break;
    	        
	    	case 3:
	    		System.out.println("Platinum menu:");
	    		printCineplexMenu(cineplexList);
	    		cineChoice = sc.nextInt();
	    		
	    		if(cineChoice == 0){
	    			b = false;
	    			continue;
	    		}
	        
	            while (b){
	            	b1 = true; b2 = true;
	            	ArrayList newList = printMoviePlatinum(sessionList, cineplexList.get(cineChoice-1));
    	        
	            	timeChoice = sc.nextInt();
	            	if (timeChoice == 0) {
	            		b = false;
	            		continue;
	            	}
            	        		
	            	while (b1) {
            		    b2 = true;
           	       		((Session)newList.get(timeChoice-1)).printSessionLayout();
           	       		System.out.println("Choose the row: ");
           	       		row = sc.nextInt();
           	       		System.out.println("Choose the column: ");
           	       		col = sc.nextInt();
           	       		isAssigned = ((Session)newList.get(timeChoice-1)).assignSeat(row, col);
           	       		
           	       		if (!confirm()){
        
           	       			continue;
           	       		}
           	        		

      	        		if(!isAssigned){
        	        		continue;
        	        	}
           	        		
           	       		while(b2){
           	        			
           	       			printTicketType();
           	       			ticketType = sc.nextInt();
           	       			
           	       			if(ticketType == 4)
   	        				break mainMenu;
           	        			
	           	       		if (confirm()){
	    	        			b2=false;	
	    	        			
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
           	       		booking = new Booking(row, col, ((Session)newList.get(timeChoice-1)), movieGoer,ticketType);
           	       		
           	       		//price = calPrice(ticketType, (Session)newList.get(timeChoice-1));
           	       		booking.printInvoice();
           	        		
           	     
           	       		
           	       		if (!confirm()){
           	       			((Session)newList.get(timeChoice-1)).unAssignSeat(row, col);
           	       			continue;
           	       		}
           	        		
           	       		System.out.println("Proceed to paying...");
           	       		//save new booking
           	        	
           	       		Database.serialize(sessionList, "Sessions.dat");
           	       		
           	        	bookingList.add(booking);
           	        	Database.serialize(bookingList, "Bookings.dat");
           	       		booking.printTicket();	
           	       		b1 = false;
	            	}
        	        
        	      
    	        
    	    }
	        break;
	    		
	    	case 4: 
	    		
	    		System.out.println("Enter your email: ");
	    		
	    		sc.nextLine();
	    		String cusEmail = sc.nextLine();
	    		
	    		printHistory(cusEmail, bookingList);
	    		break;
	    		
	    		
	    		
	    	}
	    
	    	}
	    	
	    } while (displayChoice != 5);
		
		
		//System.out.println("Print");

		}
	}
	
	public static void printCineplexMenu(ArrayList<Cineplex> cineplexList){
		System.out.println("======Cineplexes======");
		
		int i = 1;
		for (Cineplex c : cineplexList){
			System.out.printf("%d. %-18s|\n", i,c.getCineplexName());
			i++;
		}
		
		System.out.printf("0. %-18s|\n","Exit");
		System.out.print("======================\n>>");
	}
	
	
	public static void printMenu(){

		System.out.println("=====Display Menu=====");
    	System.out.println("1. Check Movies      |");
    	System.out.println("2. Seclect Cineplexes|");
    	System.out.println("3. Platinum Movies   |");
    	System.out.println("4. My account        |");
    	System.out.println("5. Exit              |");
    	System.out.print  ("======================\n>>");
	}
	
	public static void printMovieMenu(){
		System.out.println("=======Movies=========");
	    System.out.println("1. Now showing       |");
	    System.out.println("2. Coming soon       |");
	    System.out.println("3. Preview           |");
	    System.out.println("4. Search/List Movies|");
	    System.out.println("5. Exit              |");
	    System.out.print  ("======================\n>>");
	}
	
	public static ArrayList printMoviePeriod(int num, ArrayList<Movie> movieList){
	    
		int i = 1;
		ArrayList<Movie> newlist =new ArrayList<Movie>() ;
		switch(num){
	    case 1: //print now showing
	    	System.out.println("====================Movies On Show=====================");
			System.out.println("No.|      Movie Name      |  Type  |  Length   |Rating|");
	    	for (Movie m : movieList){
	    		
	    		if (m.getMovieStatus().equals("NowShowing")){
	    			
	    	        System.out.printf("%2d |%-22s|  %-4s  |    %-6d |  %-4s|\n", i,m.getMovieName(), m.getMovieType() , m.getMovieLastTime() 
	    	        		,m.getRating());
	    	        
	    	        newlist.add(m);
	    		    i++;
	    		} 
	    	}
	    	
	    	break;
	    	
	    case 2: //print coming soon
	    	System.out.println("==================Movies Coming Soon===================");
			System.out.println("No.|      Movie Name      |  Type  |  Length   |Rating|");
	    	for (Movie m : movieList){
	    		if (m.getMovieStatus().equals("ComingSoon")){
	    			System.out.printf("%2d |%-22s|  %-4s  |    %-6d |  %-4s|\n", i,m.getMovieName(), m.getMovieType() , m.getMovieLastTime() 
	    	        		,m.getRating());
	    	        newlist.add(m);
	    	        i++;
	    		}
	    	}
	    	
	    	
	    	break;
	    case 3: //print preview   ????a new type??
	    	System.out.println("====================Movies Preview=====================");
			System.out.println("No.|      Movie Name      |  Type  |  Length   |Rating|");
	    	for (Movie m : movieList){
	    		if (m.getMovieStatus().equals("Preview")){
	    			System.out.printf("%2d |%-22s|  %-4s  |    %-6d |  %-4s|\n", i,m.getMovieName(), m.getMovieType() , m.getMovieLastTime() 
	    	        		,m.getRating());
	    			newlist.add(m);
	    			i++;
	    		}
	    	} 
	    	break;
	    case 4:
	    	System.out.println("GUI activating...");
	    	SearchMovieGUI gui=new SearchMovieGUI();
	    	gui.mainGUI();
	    	break;
	    
	    }

	    
	    System.out.print("0 : Go back\n>>");
	    return newlist;
	}
	
	
    public static ArrayList printMovieCine(ArrayList<Session> sessionList, Cineplex cineplex){
	    
    	ArrayList<Session> newlist = new ArrayList<Session>();
    	SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	int j = 1;
    	System.out.println("================Movie Sessions Available===============");
		System.out.println("No.|      Movie Name      |  Cinema  |  Session Time  |");		
	    for(Session s : sessionList){
			if (s.getCineplex().getCineplexName().equals(cineplex.getCineplexName()) &&
					!s.getMovie().getMovieStatus().equals("EndOfShowing")){
				System.out.printf("%2d.|%-22s| %-9s|%s|\n" ,j, s.getMovie().getMovieName() ,
				( s.getCinema().isCinemaNormal()? "Normal":"Platinum")  ,dateFormatter.format(s.getMovie().getMovieDateOn()));
				j++;
				newlist.add(s);
			}
    	}
	    
	    System.out.print("0 : Go back\n>>");
	    return newlist;
	}
    
    public static ArrayList printMoviePlatinum(ArrayList<Session> sessionList, Cineplex cineplex){
	    
    	ArrayList<Session> newlist=new ArrayList<Session>();
    	SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	int j = 1;
    	System.out.println("================Movie Sessions Available===============");
    	System.out.println("No.|      Movie Name      |  Cineplex  |  Cinema  |  Session Time  |");		
	    for(Session s : sessionList){
	    	for (int i = 0; i<cineplex.getCinema().length; i++){
		    	if ((s.getCineplex().getCineplexName()).equals(cineplex.getCineplexName()) &&(!s.getCinema().isCinemaNormal())
		    			&& (!cineplex.getCinema()[i].isCinemaNormal() )&& (!s.getMovie().getMovieStatus().equals("EndOfShowing"))){
		    		System.out.printf("%2d.|%-22s| %-11s|  %-8s|%10s|\n" ,j, s.getMovie().getMovieName() ,
		    				s.getCineplex().getCineplexName(),(s.getCinema().isCinemaNormal()?"Normal":"Platinum")  ,dateFormatter.format(s.getdateMovieStart()));
				    j++;
				    newlist.add(s);
		    	} 
    	    }
	    }
	    System.out.println("0: Go back");	 
	    return newlist;
    	
	}
    
    public static void printTicketType(){
	    
    	System.out.println("=====Display Menu=====");
        System.out.println("1. Normal            |");
        System.out.println("2. Elder             |");
        System.out.println("3. Child             |");
        System.out.println("4. Exit              |");
        System.out.print  ("======================\n>>");
	}
	
	public static ArrayList printCineplex(Movie movie, ArrayList<Session> session, ArrayList<Cineplex> cineplex){
		
		ArrayList<Session> newlist=new ArrayList<Session>();
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		int j = 1;
		
		for (Cineplex c : cineplex){
	
			System.out.println("Cineplex:"+c.getCineplexName());
			System.out.println("======================Movie Sessions Available====================");
			System.out.println("No.|      Movie Name      |  Cineplex  | Cinema |  Session Time  |");
			for(Session s1 : session){
				
				if ((s1.getCineplex().getCineplexName()).equals(c.getCineplexName())&&
						(movie.getMovieName()).equals(s1.getMovie().getMovieName())){
					System.out.printf("%2d.|%-22s| %-11s|  %-6s|%10s|\n", j , s1.getMovie().getMovieName(),
							c.getCineplexName(), s1.getCinema().getCinemaCode(),dateFormatter.format(s1.getdateMovieStart()));
					j++;
					newlist.add(s1);
					
				}
				
    		}
    	        
    		
    	 }
		System.out.print("0 : Go back\n>>");
		return newlist;
	}

	
	public static boolean confirm(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Confirm? (1. Yes; 2. No)");
		return (sc.nextInt()==1)? true: false;
	}
	

	public static void printHistory(String email, ArrayList<Booking> bookingList){
		
		int j = 1;
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("===========================Booking History=============================");
		System.out.println("No.|      Movie Name      |  Cineplex  |  Session Time  |Row/Col|Price|");
	    for(Booking b : bookingList){
			if((b.getMovieGoer().getEmail()). equals(email)){
				System.out.printf("%2d |%-22s|%-12s|%-10s| %2d/%-2d |%.1f |\n", j , b.getSession().getMovie().getMovieName(),b.getSession().getCineplex().getCineplexName(),dateFormatter.format(b.getSession().getdateMovieStart())
	 					,b.getRow(), b.getColumn(), b.getSession().getSessionTicketPrice());
			
			 j++;
			} 
			
			
    	} 
	    if(j == 1)
			System.out.println("This account is not available.");
	   
	}
}