package me.meloni.UserGUI.Graphtemplates;

import me.meloni.Tools.Nord;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author "Hovercraft Full of Eels", "Rodrigo Azevedo"
 *
 * This is an improved version of Hovercraft Full of Eels (https://stackoverflow.com/users/522444/hovercraft-full-of-eels)
 * answer on StackOverflow: https://stackoverflow.com/a/8693635/753012
 *
 * GitHub user @maritaria has made some performance improvements which can be found in the comment section of this Gist.
 */
public class Daily extends JPanel {
    private final Color lineColor = new Color(44, 102, 230, 180);
    private final Color pointColor = new Color(100, 100, 100, 180);
    private final Color gridColor = Nord.n2();
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private final List<Double> scores;

    public Daily(List<Double> scores) {
        this.scores = scores;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int padding = 25;
        int labelPadding = 25;
        int sidespacing = 300;
        double xScale = ((double) getWidth() - sidespacing - (2 * padding) - labelPadding) / (scores.size() - 1);
        int topspacing = 40;
        double yScale = ((double) getHeight()- topspacing - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());

        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding + sidespacing);
            int y1 = (int) ((getMaxScore() - scores.get(i)) * yScale + padding + 40);
            graphPoints.add(new Point(x1, y1));
        }

        //paint background
        g2.setColor(Nord.n4());
        g2.fillRect(0,0,getWidth(),getHeight());

        // draw white background
        g2.setColor(Nord.n6());
        g2.fillRect(padding + labelPadding + sidespacing, padding + topspacing, getWidth() - sidespacing - (2 * padding) - labelPadding, getHeight() - 2 * padding - labelPadding-40);
        g2.setColor(Nord.n4());

        // create hatch marks and grid lines for y axis.
        int pointWidth = 4;
        int numberYDivisions = 10;
        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding + sidespacing;
            int x1 = pointWidth + padding + labelPadding + sidespacing;
            int y0 = getHeight() - ((i * (getHeight() - padding * 2 - labelPadding - topspacing)) / numberYDivisions + padding + labelPadding);
            if (scores.size() > 0) {
                g2.setColor(gridColor);
                g2.drawLine(padding + labelPadding + 1 + pointWidth + sidespacing, y0, getWidth() - padding , y0);
                g2.setColor(Color.BLACK);
                String yLabel = ((int) ((getMinScore() + (getMaxScore() - getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(x0, y0, x1, y0);
        }

        // and for x axis
        for (int i = 0; i < scores.size(); i++) {
            if (scores.size() > 1) {
                //int x0 = i * (getWidth() - padding * 2 - labelPadding) / (scores.size() - 1) + padding + labelPadding;
                int x0 = i * (getWidth() - sidespacing - padding * 2 - labelPadding ) / 24 + sidespacing + padding + labelPadding;
                int y0 = getHeight() - padding - labelPadding;
                int y1 = y0 - pointWidth;
                // if ((i % ((int) ((scores.size() / 20.0)) + 1)) == 0) {
                if ((i % ((scores.size() / 144) + 1)) == 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth , x0, padding + topspacing);
                    g2.setColor(Color.BLACK);
                    String xLabel = i + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                }
                g2.drawLine(x0, y0, x0, y1);
            }
        }

        // create x and y axes
        g2.setColor(Nord.n0());
        g2.drawLine(padding + labelPadding + sidespacing, getHeight() - padding - labelPadding, padding + labelPadding + sidespacing, padding + topspacing);
        g2.drawLine(padding + labelPadding + sidespacing, getHeight() - padding - labelPadding, getWidth() - padding , getHeight() - padding - labelPadding);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (Point graphPoint : graphPoints) {
            int x = graphPoint.x - pointWidth / 2;
            int y = graphPoint.y - pointWidth / 2;
            g2.fillOval(x, y, pointWidth, pointWidth);
        }
    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(width, height);
//    }

    private double getMinScore() {
        double minScore = Double.MAX_VALUE;
        for (Double score : scores) {
            minScore = Math.min(minScore, score);
        }
        return minScore;
    }

    private double getMaxScore() {
        double maxScore = Double.MIN_VALUE;
        for (Double score : scores) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

}