package Brainstorm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapFrame extends JFrame
{
    public MapFrame(final Map map, final Backpack backpack) {
	super("Brainstorm");


	final MapComponent mapComponent = new MapComponent(map);
	JPanel contentPane = new JPanel(new BorderLayout());
	this.add(contentPane, BorderLayout.PAGE_END);

	//this.setLayout(new BorderLayout());
	BackpackComponent backpackComponent = new BackpackComponent(backpack);
	contentPane.add(mapComponent, BorderLayout.LINE_START);
	contentPane.add(backpackComponent, BorderLayout.LINE_END);

	map.addListener(mapComponent);
	backpack.addListener(backpackComponent);

	for (GearComponent gearComponent : backpackComponent.getGearComponents()) {
	    MouseListener ml = new ClickPrinter();
	    gearComponent.addMouseListener(new ClickPrinter());
	}

	//this.setVisible(true);
	this.pack();
	this.setLocationRelativeTo(null);

	class DownAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
		map.moveDown();
	    }
	}

	class UpAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
		map.moveUp();
	    }
	}

	class RightAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
		map.moveRight();
	    }
	}

	class LeftAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
		map.moveLeft();
	    }
	}

	class QuitAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
		System.exit(0);
	    }
	}

	final InputMap in = mapComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("UP"), "moveUp");
	in.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
	in.put(KeyStroke.getKeyStroke("ESCAPE"), "quit");
	final ActionMap act = mapComponent.getActionMap();
	act.put("moveUp", new UpAction());
	act.put("moveDown", new DownAction());
	act.put("moveRight", new RightAction());
	act.put("moveLeft", new LeftAction());
	act.put("quit", new QuitAction());
    }

    private class ClickPrinter implements MouseListener {
	public void mouseClicked (MouseEvent e) {
	    System.exit(0);
	}

	public void mousePressed(MouseEvent e) {
	    System.exit(0);
	}

	public void mouseEntered(MouseEvent e){
	    System.exit(0);
	}

	public void mouseReleased(MouseEvent e) {
	    System.exit(0);
	}

	public void mouseExited(MouseEvent e) {
	    System.exit(0);
	}
    }
}