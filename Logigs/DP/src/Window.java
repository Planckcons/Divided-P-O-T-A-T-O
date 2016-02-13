import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	String mapS = "Map";
	String cabS = "Cab";
	String engineS = "Engine";
	String reactorS = "Reactor";
	
	public Window(String purpose) 
	{
		super("Tadaaa!!");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 450);
		
		if(purpose == "Game")
		{		
			TopMenu top_menu = new TopMenu("Crew", "Ship", "Resources");
			setJMenuBar(top_menu);
			System.out.println("WGS");
			
			JPanel p = new JPanel();
			JButton map = new JButton("Map");
			map.addActionListener(this);
			map.setActionCommand(mapS);
			
			p.add(map);
			add(p);
		}
		else if(purpose == "Ship set")
		{	
			JPanel p = new JPanel();
			
			JButton engine = new JButton("Frecking warp drive");
			JButton reactor = new JButton("Fusion-man");
			JButton cab = new JButton("Cabin");
			
			cab.setActionCommand(cabS);
			engine.setActionCommand(engineS);
			reactor.setActionCommand(reactorS);
			
			cab.addActionListener(this);
			engine.addActionListener(this);
			reactor.addActionListener(this);

			p.add(engine);
			p.add(reactor);
			p.add(cab);
			
			add(p);
			System.out.println("WSS");
		}
		else if(purpose == "Map")
		{
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == cabS || e.getActionCommand() == engineS || e.getActionCommand() == reactorS)
		{
			GameSet a = new GameSet();
			a.setPart_type(e.getActionCommand());
			a.ShipSet();
		}
		else if(e.getActionCommand() == mapS)
		{
			Map map = new Map();
			map.window();
		}
	}

}
