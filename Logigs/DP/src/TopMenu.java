import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class TopMenu extends JMenuBar implements ActionListener {
	private static final long serialVersionUID = 1L;

	
	public TopMenu(String title1, String title2, String title3) {
		// TODO Auto-generated constructor stub
	
		JMenu first = new JMenu(title1);
		first.setMnemonic(KeyEvent.VK_1);
		
		JMenu second = new JMenu(title2);
		second.setMnemonic(KeyEvent.VK_2);
		
		JMenu third = new JMenu(title3);
		third.setMnemonic(KeyEvent.VK_3);
		
		JMenu job0 = new JMenu(GameSet.jobs[0] + "s");
		JMenu job1 = new JMenu(GameSet.jobs[1] + "s");
		JMenu job2 = new JMenu(GameSet.jobs[2] + "s");		
		JMenu job3 = new JMenu(GameSet.jobs[3] + "s");
	
		for(int i = 0; i < GameSet.crew_amount; i++)
		{
			People a = Game.crew[i];
			JMenuItem member = new JMenuItem(a.getName());
			
			if(a.getJob() == GameSet.jobs[0])
				job0.add(member);
			else if(a.getJob() == GameSet.jobs[1])
				job1.add(member);
			else if(a.getJob() == GameSet.jobs[2])
				job2.add(member);
			else if(a.getJob() == GameSet.jobs[3])
				job3.add(member);
			else
				first.add(member);
			
			member.addActionListener(this);
			member.setActionCommand(a.getJob());
		}
		
		for(int i = 0; i < GameSet.max_parts; i++)
		{
			ShipParts a = Game.ship[i];
			System.out.println(a.name);
			
			JMenuItem part = new JMenuItem(a.name/*"Part"*/);
			second.add(part);
			part.addActionListener(this);
			part.setActionCommand(a.type/*"Function"*/);
		}
		
		for(int i = 0; i < GameSet.resource_amount; i++)
		{
			Resource a = GameSet.resources[i];
			JMenuItem resource = new JMenuItem(a.name + " " + a.amount);
			third.add(resource);
			resource.addActionListener(this);
			resource.setActionCommand(a.name);
		}
		
		first.add(job0);
		first.add(job1);
		first.add(job2);
		first.add(job3);

		add(first);
		add(second);
		add(third);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Job: " + e.getActionCommand()); //new window or whatever
	}
	
}
