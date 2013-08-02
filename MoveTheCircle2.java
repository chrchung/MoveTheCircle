import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.applet.*; 

//program description: moves a circle around a scren
//arrow keys to moves around screen, space bar to stop moving 

public class MoveTheCircle2{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoveTheCircle2 () {
		JFrame f = new JFrame (); 
		f.setSize(500, 500); 
		f.setResizable (false); 
		f.add (new DrawCircle()); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	public class DrawCircle extends JPanel implements KeyListener, ActionListener {
		/**
		 * 
		 */		
		private static final long serialVersionUID = 1L;
		int x = 100;
		int y = 100;
		int dx = 0;
		int dy = 0;
		Timer t = new Timer (1, this); 

		public DrawCircle (){
			t.start ();
			setBackground(Color.BLACK);
			setFocusTraversalKeysEnabled(false);
			addKeyListener(this);
			setFocusable (true);
		}
		
		public void paintComponent (Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(
			    RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
			
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.fillOval(x, y, 50, 50);
		}

		public void actionPerformed(ActionEvent e) {
			if (x + dx <= 0){
				x = 500; 
			}
			if (x + dx >= 500){
				x = 0; 
			}
			if (y + dy <= 0){
				y = 478;
			}
			if (y + dy >= 478){
				y = 0;
			}
				x +=dx; 
				y +=dy;
		
			repaint();
		}

		//set movement 
		public void keyPressed(KeyEvent e) {
			int event = e.getKeyCode();
			
			if (event == KeyEvent.VK_RIGHT){
					dx = 1;
					dy = 0;
			}
			if (event == KeyEvent.VK_LEFT){
					dx = -1;
					dy = 0; 
			}
			if (event == KeyEvent.VK_DOWN){
					dx = 0;
					dy = 1; 
			}
			if (event == KeyEvent.VK_UP){
					dx = 0;
					dy = -1; 
			}
			if (event == KeyEvent.VK_SPACE){
					dx = 0;
					dy = 0;
			}
		}


		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		new MoveTheCircle2 ();
	}

}
