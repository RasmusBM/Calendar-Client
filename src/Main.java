import javax.swing.JFrame;

import view.CalendarFrame;

/**
 * Main class to start the program
 * @author RasmusM
 *
 */

public class Main {

	public static void main(String[] args) {

		CalendarFrame cf = new CalendarFrame();
		cf.setVisible(true);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
