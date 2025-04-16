package jdbcPractice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ScrollingText extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JLabel label;
    private int x =10;
    private boolean moveRight =true;
    
    public ScrollingText() {
    	setTitle("Scrolling text");
    	setSize(400,200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
    	JPanel panel = new JPanel() {
    		protected void paintComponent(Graphics g) {
    			super.paintComponent(g);
    			label.setLocation(x,getHeight() / 2);
    			
    		}
    	};
    		
    		panel.setLayout(null);
    		
    		label=new JLabel("Scrolling Text");
    		label.setFont(new Font("Arial",Font.BOLD,20));
    		label.setSize(label.getPreferredSize());
    		panel.add(label);
    		
    		Timer timer = new Timer(20,new ActionListener() {
    			
    			public void actionPerformed(ActionEvent e) {
    				if(moveRight) {
    					x += 2;
    					if (x + label.getWidth() >= panel.getWidth()) {
    						moveRight = false ;
    					} 
    				}else {
    					x -= 2;
    						if (x <= 0) {
    							moveRight = true ;
    						}
    					}
    					panel.repaint();
    				}
    		});
    	 timer.start();
    	 add(panel);
    	 
    
    }
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() ->{
    		new ScrollingText().setVisible(true);
    	});
    }
	
}
