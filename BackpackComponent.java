package Brainstorm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BackpackComponent extends JComponent implements GameListener
{
    private static final int SQUARE_SIZE = 20;
    private static final int MARGIN = 2;

    private List<GearComponent> gearComponents = new ArrayList<GearComponent>();


    private Backpack backpack;

    public BackpackComponent(Backpack backpack) {
	this.backpack = backpack;
	this.setPreferredSize(getPreferredSize());
	this.setLayout(null);
    }

    public Dimension getPreferredSize() {
	Dimension dim = new Dimension(SQUARE_SIZE * backpack.getSize() + MARGIN * backpack.getSize(),
				      SQUARE_SIZE * backpack.getSize() + MARGIN * backpack.getSize());
	return dim;
    }

    @Override protected void paintComponent(Graphics g) {
   	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	for (int r = 0; r<backpack.getSize(); r++) {
	    for (int c = 0; c<backpack.getSize(); c++) {
		GearComponent gearComponent = new GearComponent(backpack.getGear(r, c), r, c);
		this.add(gearComponent);
		gearComponents.add(gearComponent);
		//gearComponent.setLocation(c * SQUARE_SIZE + c * MARGIN,r * SQUARE_SIZE + r * MARGIN);
		gearComponent.paintComponent(g);

		/*
		Shape rectangle = new Rectangle(c * SQUARE_SIZE + c * MARGIN,
						r * SQUARE_SIZE + r * MARGIN,
						SQUARE_SIZE, SQUARE_SIZE);
		g2d.setPaint(palette(backpack.getGear(r, c)));
		g2d.fill(rectangle);
		*/
	    }
	}
    }

    public void hasChanged() {
	repaint();
    }

    public List<GearComponent> getGearComponents() {
	return gearComponents;
    }
}