import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.String;

import javax.swing.*;

import java.awt.event.*;



@SuppressWarnings("serial")
public class SearchMovieGUI extends  JFrame {
    
    
    public SearchMovieGUI() {
        initComponents();
    }

    private void initComponents() {
        
        searchField = new  JTextField();
        searchButton = new  JButton();
        showAllMovies = new  JButton();
        movieShowTimeTable = new  JScrollPane();
        
        List sessionList=(List) Database.deserialize("Sessions.dat");
        
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        
        searchField.setText("");
        searchField.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        
        searchButton.setText("Search");
        searchButton.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        
        showAllMovies.setText("Show All");
        showAllMovies.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                showAllMoviesActionPerformed(evt);
            }
        });
      
        
        Object[][] object=new Object[sessionList.size()][4];
        for (int col=0;col<4;col++)
    
            for(int row=0;row<sessionList.size();row++)
            	object[row][col]=null;
       
        jTable1 = new  JTable(
         object,
        new String [] {
        		 "Movie Name","Cineplex","Status", "Show Time"
       });
        for (int col=0;col<4;col++)
            for(int row=0;row<sessionList.size();row++)
                switch(col){
                    case 0:
                        jTable1.setValueAt(null, row, col);
                        break;
                    case 1:
                        jTable1.setValueAt(null,row,col);
                        break;
                    case 2:
                        jTable1.setValueAt(null,row,col);
                        break;
                    case 3:
                        jTable1.setValueAt(null,row,col);
                        break;
                        
                }
        movieShowTimeTable.setViewportView(jTable1);
        
         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                  .addGroup(layout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                                      .addComponent(movieShowTimeTable,  GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                      .addGroup(layout.createSequentialGroup()
                                                                .addComponent(searchField,  GroupLayout.PREFERRED_SIZE, 252,  GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(searchButton)
                                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(showAllMovies,  GroupLayout.PREFERRED_SIZE, 84,  GroupLayout.PREFERRED_SIZE)))
                                            .addContainerGap(43, Short.MAX_VALUE))
                                  );
        layout.setVerticalGroup(
                                layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                          .addGap(17, 17, 17)
                                          .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                                    .addComponent(searchField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(searchButton)
                                                    .addComponent(showAllMovies))
                                          .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(movieShowTimeTable,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
        
        pack();
    }// </editor-fold>
    
    protected void searchFieldActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}


	private void searchButtonActionPerformed( ActionEvent evt) {
		
        List sessionList=(List) Database.deserialize("Sessions.dat");
        System.out.println("The movie you searched:"+searchField.getText());
        
        ArrayList<String> tempListCol2=new ArrayList<String>();
        ArrayList<String> tempListCol3=new ArrayList<String>();
        ArrayList<String> tempListCol4=new ArrayList<String>();
        for(int i=0;i<jTable1.getRowCount();i++){
        	
            if( searchField.getText().equals(jTable1.getValueAt(i, 0) )){
            	tempListCol2.add((String) jTable1.getValueAt(i,1));
            	tempListCol3.add((String) jTable1.getValueAt(i,2));
            	tempListCol4.add((String) jTable1.getValueAt(i,3));
           
            }
        }
        //reset    
        for (int col=0;col<4;col++)
            for(int row=0;row<sessionList.size();row++)
                 jTable1.setValueAt(null, row, col);
        jTable1.setValueAt(searchField.getText(),0,0);
        int i=0;
        for(String temp2:tempListCol2){
        	
        		jTable1.setValueAt(temp2, i++, 1);
        	
        }
        i=0;
        for(String temp3:tempListCol3){
        	
        		jTable1.setValueAt(temp3, i++, 2);
        	
        }
        i=0;
        for(String temp4:tempListCol4){
        	
        		jTable1.setValueAt(temp4, i++, 3);
        	
        }
        
        
            
                        
                                   
               
    }                                        
                                                                     
    private void showAllMoviesActionPerformed( ActionEvent evt) {                                              
                //print out all movie show times on window
                
                int i=0;//for object array
                SimpleDateFormat dateFormatter=new SimpleDateFormat("MM-dd HH:mm");
                List sessionList=(List) Database.deserialize("Sessions.dat");
                //object initialize
                Object[][] object=new Object[sessionList.size()][4];
                for (int col=0;col<4;col++)
                    for(int row=0;row<sessionList.size();row++)
                    	object[row][col]=null;
                
                for(int row=0;row<sessionList.size();row++){
                	  
                    	if (!((Session)sessionList.get(row)).getMovie().getMovieStatus().equals("EndOfShowing")){
	                        
                    		object[i][0]=((Session)sessionList.get(row)).getMovie().getMovieName();                        
	                       	object[i][1]=((Session)sessionList.get(row)).getCineplex().getCineplexName();	                          
	                     	object[i][2]=((Session)sessionList.get(row)).getMovie().getMovieStatus();                              
	                      	object[i][3]=dateFormatter.format(((Session)sessionList.get(row)).getdateMovieStart());                         
	                        i++;
                    	
                	}
                	
                } 
                for (int col=0;col<4;col++)
                    for(int row=0;row<object.length;row++)
                    	jTable1.setValueAt(object[row][col],row,col);
            }          
    
                                                                     
/**
 * @param args the command line arguments
 */
 public void mainGUI() {          
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new SearchMovieGUI().setVisible(true);
                    }
                });
            }
                                                                     
// Variables declaration - do not modify                     

private  JTable jTable1;
private  JScrollPane movieShowTimeTable;
private  JButton searchButton;
private  JTextField searchField;
private  JButton showAllMovies;
// End of variables declaration                   
}
