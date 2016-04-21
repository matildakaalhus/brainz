package Brainstorm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ArenaFrame extends JFrame
{
    private final ArenaComponent arenaComponent;

    public ArenaFrame(final Arena arena, final Backpack backpack) {

	JPanel contentPane = new JPanel(new BorderLayout());
	this.add(contentPane);
	JPanel smtPane = new JPanel(new BorderLayout());
	contentPane.add(smtPane, BorderLayout.CENTER);
	arenaComponent = new ArenaComponent(arena);
	smtPane.add(arenaComponent, BorderLayout.PAGE_START);

	BackpackComponent backpackComponent = new BackpackComponent(backpack);
	smtPane.add(backpackComponent, BorderLayout.CENTER);
	backpack.addListener(backpackComponent);
	arena.addListener(arenaComponent);


	class FleeAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
		arena.flee();
	    }
	}

	JButton flee = new JButton(new FleeAction());
	flee.setText("FLIGHT!");
	contentPane.add(flee, BorderLayout.LINE_START);


	class FightAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
		arena.fight();
	    }
	}

	JButton fight = new JButton(new FightAction());
	fight.setText("FIGHT!");
	contentPane.add(fight, BorderLayout.LINE_END);

	class FlirtAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
			arena.flirt();
		    }
	}

	JButton flirt = new JButton(new FlirtAction());
	flirt.setText("flirt");
	flirt.setPreferredSize(new Dimension(50, 20));
	smtPane.add(flirt, BorderLayout.PAGE_END);

	this.pack();
	this.setLocationRelativeTo(null);


	class QuitAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		    }
	}


	final InputMap in = arenaComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("ESCAPE"), "quit");
	final ActionMap act = arenaComponent.getActionMap();
	act.put("quit", new QuitAction());
    }

    public ArenaComponent getArenaComponent() {
	return arenaComponent;
    }
}