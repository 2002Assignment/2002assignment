import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.lang.String;





public class SearchMovieGUI extends javax.swing.JFrame {
    
    
    public SearchMovieGUI() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        showAllMovies = new javax.swing.JButton();
        movieShowTimeTable = new javax.swing.JScrollPane();
        
        Database db=new Database();
    	Date dt=new Date();
        List sessionList=(List) db.deserialize("Sessions.dat");
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        searchField.setText("");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        
        showAllMovies.setText("Show All");
        showAllMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllMoviesActionPerformed(evt);
            }
        });
        Object[][] object=new Object[3][sessionList.size()];
        for (int col=0;col<3;col++)
            for(int row=0;row<sessionList.size();row++)
            	object[row][col]=null;
       
        jTable1 = new javax.swing.JTable(
         object,
        new String [] {
        		 "Movie Name","Cineplex", "Show Time"
       });
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
        movieShowTimeTable.setViewportView(jTable1);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addGroup(layout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                      .addComponent(movieShowTimeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                      .addGroup(layout.createSequentialGroup()
                                                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(searchButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(showAllMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addContainerGap(43, Short.MAX_VALUE))
                                  );
        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                          .addGap(17, 17, 17)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(searchButton)
                                                    .addComponent(showAllMovies))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(movieShowTimeTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
        
        pack();
    }// </editor-fold>
    
    protected void searchFieldActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}


	private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        System.out.println("The movie you searched:"+searchField.getText());

        for(int i=0;i<jTable1.getRowCount();i++){
        	
            if( searchField.getText().equals(jTable1.getValueAt(i, 0) ))
                System.out.println(jTable1.getValueAt(i,1));
            	
            
        }         
    }                                        
                                                                     
    private void showAllMoviesActionPerformed(java.awt.event.ActionEvent evt) {                                              
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

private javax.swing.JTable jTable1;
private javax.swing.JScrollPane movieShowTimeTable;
private javax.swing.JButton searchButton;
private javax.swing.JTextField searchField;
private javax.swing.JButton showAllMovies;
// End of variables declaration                   
}
