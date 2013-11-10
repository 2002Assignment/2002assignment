import java.util.Date;
import java.util.List;
import java.lang.String;
import javax.swing.*;
import java.awt.event.*;



public class SearchMovieGUI extends  JFrame {
    
    
    public SearchMovieGUI() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        
        searchField = new  JTextField();
        searchButton = new  JButton();
        showAllMovies = new  JButton();
        movieShowTimeTable = new  JScrollPane();
        
        Database db=new Database();
    	Date dt=new Date();
        List sessionList=(List) db.deserialize("Sessions.dat");
        
        
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
        Object[][] object=new Object[3][sessionList.size()];
        for (int col=0;col<3;col++)
            for(int row=0;row<sessionList.size();row++)
            	object[row][col]=null;
       
        jTable1 = new  JTable(
         object,
        new String [] {
        		 "Movie Name","Cineplex", "Show Time"
       });
        for (int col=0;col<3;col++)
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
		Database db=new Database();
        Date dt=new Date();
        List sessionList=(List) db.deserialize("Sessions.dat");
        System.out.println("The movie you searched:"+searchField.getText());
        //clear table
        for (int col=0;col<3;col++)
            for(int row=0;row<sessionList.size();row++)
                switch(col){
                    case 0:
                        jTable1.setValueAt(((Session)sessionList.get(row)).getMovie().getMovieName(), row, col);
                        break;
                    case 1:
                        jTable1.setValueAt(((Session)sessionList.get(row)).getCineplex().getCineplexName(),row,col);
                        break;
                    case 2:
                        jTable1.setValueAt(((Session)sessionList.get(row)).getdateMovieStart(),row,col);
                        break;
                        
                }
        //reconstruct table 
        for(int i=0;i<jTable1.getRowCount();i++){
        	
            if( searchField.getText().equals(jTable1.getValueAt(i, 0) ))
                System.out.println(jTable1.getValueAt(i,1));
            	
            
        }         
    }                                        
                                                                     
    private void showAllMoviesActionPerformed( ActionEvent evt) {                                              
                //print out all movie show times on windows
                Database db=new Database();
                Date dt=new Date();
                List sessionList=(List) db.deserialize("Sessions.dat");
                for (int col=0;col<3;col++)
                    for(int row=0;row<sessionList.size();row++)
                        switch(col){
                            case 0:
                                jTable1.setValueAt(((Session)sessionList.get(row)).getMovie().getMovieName(), row, col);
                                break;
                            case 1:
                                jTable1.setValueAt(((Session)sessionList.get(row)).getCineplex().getCineplexName(),row,col);
                                break;
                            case 2:
                                jTable1.setValueAt(((Session)sessionList.get(row)).getdateMovieStart(),row,col);
                                break;
                                
                        }
            }                                             
                                                                     
/**
 * @param args the command line arguments
 */
 public static void main(String args[]) {
                
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
