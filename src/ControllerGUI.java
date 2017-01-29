import javax.swing.JFrame;
/**
 * 
 * @author Faizan Zaheer, 14038751
 *Here is the GUI controller this is where the context of the GUI derives from
 *here we can change the size and visibility of the GUI, this is also our main frame
 *and can the GUI can be run from here.
 */
public class ControllerGUI {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				aFrame f = new aFrame();
				f.setSize(650, 475);	//size of the GUI
				f.setVisible(true);	//visibilty
				System.out.println("creating frame");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}