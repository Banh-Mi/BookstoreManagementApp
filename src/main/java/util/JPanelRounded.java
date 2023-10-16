package util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class JPanelRounded extends JPanel {

    private int roundedTopLeft = 0;
    private int roundedTopRight = 0;
    private int roundedBottomLeft = 0;
    private int roundedBottomRight = 0;

    public int getRoundedTopLeft() {
        return roundedTopLeft;
    }

    public void setRoundedTopLeft(int roundedTopLeft) {
        this.roundedTopLeft = roundedTopLeft;
        repaint();
    }

    public int getRoundedTopRight() {
        return roundedTopRight;
        
    }

    public void setRoundedTopRight(int roundedTopRight) {
        this.roundedTopRight = roundedTopRight;
          repaint();
    }

    public int getRoundedBottomLeft() {
        return roundedBottomLeft;
    }

    public void setRoundedBottomLeft(int roundedBottomLeft) {
        this.roundedBottomLeft = roundedBottomLeft;
          repaint();
    }

    public int getRoundedBottomRight() {
        return roundedBottomRight;
    }

    public void setRoundedBottomRight(int roundedBottomRight) {
        this.roundedBottomRight = roundedBottomRight;
          repaint();
    }

    public JPanelRounded() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundedTopLeft());
        if(roundedTopRight>0) {
            area.intersect(new Area(createRoundedTopRight()));
        }
        if(roundedBottomLeft>0) {
            area.intersect(new Area(createRoundedBottomLeft()));
        }
        if(roundedBottomRight>0) {
            area.intersect(new Area(createRoundedBottomRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }

    private Shape createRoundedTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundedTopRight);
        int roundY = Math.min(height, roundedTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundedTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundedTopLeft);
        int roundY = Math.min(height, roundedTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX/2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }
    
     private Shape createRoundedBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundedBottomLeft);
        int roundY = Math.min(height, roundedBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX/2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
     
     
    private Shape createRoundedBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundedBottomRight);
        int roundY = Math.min(height, roundedBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
      area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
}
