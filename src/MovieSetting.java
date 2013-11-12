import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class MovieSetting {
	
	Database db=new Database();
	ArrayList <Cineplex> cineplexList=(ArrayList)db.deserialize("Cineplexes.dat");
	ArrayList <Movie> movieList=(ArrayList)db.deserialize("Movies.dat");
    
    
	private String movieName;
	private Date movieDateOn;
	private String movieType;
	private String rating;
	private int movieLastTime;
	private String movieStatus;
	private int upC;
	private String input;
	
	
	//constructor
	public MovieSetting() {
		this.movieName = null;
		this.movieDateOn = null;
		this.movieType = null;
		this.rating = null;
		this.movieLastTime = 0;
		this.movieStatus =null;
		this.upC = 0;
		this.input = null;
		this.db =new Database();
	}

	
  
	
	public void addMovie() throws ParseException{
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("----Initialize New Movie----");
	    System.out.println("Enter movie name:");
	    movieName = sc.nextLine();
	    System.out.println("Enter date on in YYYY-MM-DD format: ");
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
		input = sc.nextLine();
		int i = 0;
		while (i == 0){
			if(checkDate(input) == true){
				movieDateOn = dateFormatter.parse(input);
				i = 1;
			}
			else
				System.out.println("Error input, please enter again");
		}
	    System.out.printf("Enter movie type:\n1. 2D\n2. 3D\n");
	    
		movieType = selectType(sc. nextInt());
	    System.out.printf("Enter movie rating:\n1. G\n2. PG\n3. PG13\n4. NC16\n5.M18\n6.R21\n");
		rating = selectRating(sc. nextInt());
	    System.out.println("Enter movie last time(minutes in integer):");
	    int m = sc.nextInt();
	    i = 0;
	    while (i == 0){
		    if (m>0 & m<240){
		    	movieLastTime = m;
		    	i = 1;
		    }
		    else
				System.out.println("Error input, please enter again");
	    }
	    System.out.printf("Enter movie status:\n1. ComingSoon\n2. Preview\n3. NowShowing\n4. EndOfShowing\n");
		movieStatus = selectStatus(sc.nextInt());
		Movie movie = new Movie(movieName, movieDateOn,movieType, rating,
				movieLastTime, movieStatus);
		movieList.add(movie);
		db.serialize(movieList, "Movies.dat");
		System.out.println("Movie added successfully: "+movie.getMovieName());
	}
	
	public void deleteMovie(){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter integer to delete movie:");
	    int movieIndex =sc.nextInt();
	    movieList.remove(movieIndex-1);
	    db.serialize(movieList, "Movies.dat");
	    System.out.println("Movie delated successfully.");
	}
	public void printMovie() {
		int i=1;
		System.out.println("======================================Movies in Database====================================== ");
		System.out.println("No. |          Movie Name          |  Type  |  Length   |Rating|    Status    |Movie Launch Time|");
    	for (Movie m : movieList){
    			System.out.printf("%-4d |%-30s|  %-4s  |    %-6d |  %-4s| %-12s | %-17s|\n", i,m.getMovieName(), m.getMovieType() , m.getMovieLastTime() 
    	        		, m.getRating(), m.getMovieStatus(), m.getMovieDateOn());
    			i++;
    		
    	} 
		 
	}
	public void updateMovie() throws ParseException{
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter integer to update movie");
	    int movieIndex = sc.nextInt();
	    Movie mv=movieList.get(movieIndex-1);
	    
	    
	    System.out.println("Enter your choice to update movie:");
	    System.out.println("1. Movie name");
	    System.out.println("2. Movie launch date");
	    System.out.println("3. Movie rating");
	    System.out.println("4. Movie type");
	    System.out.println("5. Movie length");
	    System.out.println("6. Change movie status");
	    
	    
	    SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
	    
	    upC = sc.nextInt();
	    sc.nextLine();
		switch(upC){
		case 1: 
			System.out.println("Enter new name:");
			mv.setMovieName(sc.nextLine());
			break;
		case 2:
			input = sc.nextLine();
			int i = 0;
			System.out.println("Enter new date on: ");
			while (i == 0){
				if(checkDate(input) == true){
					mv.setMovieDateOn(dateFormatter.parse(input));
					i = 1;
				}
				else
					System.out.println("Error input, please enter again");
			}
		    
		    break;
		case 3:
			System.out.printf("Enter new rating: \n1. G\n2. PG\n3. PG13\n4. NC16\n5.M18\n6.R21\n");
			mv.setRating(selectRating(sc.nextInt()));
			break;
		case 4:
			System.out.printf("Enter new type: \n1. 2D\n2. 3D\n");
			mv.setMovieType(selectType(sc.nextInt()));
			break;
		case 5:
			System.out.println("Enter new last time: ");
			int m = sc.nextInt();
		    int c = 0;
		    while (c == 0){
			    if (m>0 & m<240){
			    	mv.setMovieLastTime(m);
			    	c = 1;
			    }
			    else
					System.out.println("Error input, please enter again");
		    }
			
			break;
		case 6:
			System.out.printf("Enter new status:\n1. ComingSoon\n2. Preview\n3. NowShowing\n4. EndOfShowing\n");
			mv.setMovieStatus(selectStatus(sc.nextInt()));
			break;
		}
		db.serialize(movieList, "Movies.dat"); 
	}


	//selection methods
	public String selectType(int C){
		int T = 0;
	    while (T == 0){
	    	switch(C){
	    	case 1:
	    		return "2D";
	    	case 2: 
	    		return "3D";
	    	default:
	    		System.out.println("Invalid selection, please reselect.");
	    	}
	    }return "a";
	}
	
	public String selectRating(int C){
	    int T = 0;
		while (T == 0){
			switch(C){
			case 1:
		   		return "G";
	    	case 2: 
	    		return "PG";	    	
		   	case 3: 
		   		return "PG13";
	    	case 4: 
	    		return "NC16";		  
		   	case 5: 
		    	return "M18";
		   	case 6: 
		    	return "R21";
		    default:
		    	System.out.println("Invalid selection, please reselect.");
		    	
		    }
		}return "a";
	}
	public String selectStatus(int C){
		int T = 0;
	    while (T == 0){
	    	switch(C){
	    	case 1:
	    		return "ComingSoon";
	    	case 2: 
	    		return "Preview";
	    	case 3: 
	    		return "NowShowing";
	    	case 4:
	    		return "EndOfShowing";
	    	default:
	    		System.out.println("Invalid selection, please reselect.");
	    	}
	    }return "a";
	}
	
	public boolean checkDate(String s) throws ParseException{
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");
		int a=1;
		Date day = new Date();
		for (int i = 0; i<9; i++){
			if (i == 4 || i == 7){
				if(s.charAt(i) == '-')
					a*=1;
				else
					a*=0;
			}
			else{
				if(Character.isDigit(s.charAt(i)))
					a*=1;
				else
					a*=0;			
			}
		}
		if (a == 1){
			Date today = new Date();
			day = dateFormatter.parse(s);
			if (day.after(today))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
