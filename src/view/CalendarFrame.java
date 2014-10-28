package view;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalendarFrame extends JFrame {

	//Declaration of global style constants
	public static final int WITDH = 400;
	public static final int HEIGHT = 400;
	
	//Declaration of attributes
	private DayPanel dayPanel;
	private WeekPanel weekPanel;
	private JPanel contentPane;
	private CardLayout c;
	
	public static final String DAYPANEL = "dayPanel";
	public static final String WEEKPANEL = "weekPanel";
	
	public CalendarFrame(){
		
		setSize(WIDTH, HEIGHT);
		
		//instances of the JPanels 
		dayPanel = new DayPanel();
		weekPanel = new WeekPanel();
		
		
		//adding the contentPane
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		c = (CardLayout) getContentPane().getLayout();
		
		contentPane.add(dayPanel, DAYPANEL);
		contentPane.add(weekPanel, WEEKPANEL);
		
	}
	
	public void Show(String card){
		
		c.show(getContentPane(), card);
	}
	
	public DayPanel getDaypanel(){
		return dayPanel;
	}
	
	public WeekPanel getWeekPanel(){
		return weekPanel;
	}
}
