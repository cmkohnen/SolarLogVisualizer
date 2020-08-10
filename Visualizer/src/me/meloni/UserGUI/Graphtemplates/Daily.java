package me.meloni.UserGUI.Graphtemplates;

import me.meloni.Tools.Nord;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Daily extends JPanel {
    private final Color gridColor = Nord.n2();
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private final List<List<Double>> scores;

    public Daily(List<List<Double>> scores) {
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
        double xScale = ((double) getWidth() - sidespacing - (2 * padding) - labelPadding - labelPadding) / (scores.size() - 1);
        int topspacing = 40;
        double yaScale = ((double) getHeight()- topspacing - 2 * padding - labelPadding) / (getMaxaScore() - getMinScore());
        double ybScale = ((double) getHeight()- topspacing - 2 * padding - labelPadding) / (getMaxbScore() - getMinScore());

        List<Point> Reihe1 = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding + sidespacing);
            int y1 = (int) ((getMaxaScore() - scores.get(i).get(0)) * yaScale + padding + 40);
            Reihe1.add(new Point(x1, y1));
        }

        List<Point> Reihe2 = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding + sidespacing);
            int y1 = (int) ((getMaxbScore() - scores.get(i).get(1)) * ybScale + padding + 40);
            Reihe2.add(new Point(x1, y1));
        }

        List<Point> Reihe3 = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding + sidespacing);
            int y1 = (int) ((getMaxaScore() - scores.get(i).get(2)) * yaScale + padding + 40);
            Reihe3.add(new Point(x1, y1));
        }

        List<Point> Reihe4 = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding + sidespacing);
            int y1 = (int) ((getMaxbScore() - scores.get(i).get(3)) * ybScale + padding + 40);
            Reihe4.add(new Point(x1, y1));
        }

        List<Point> Reihe5 = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding + sidespacing);
            int y1 = (int) ((getMaxaScore() - scores.get(i).get(4)) * yaScale + padding + 40);
            Reihe5.add(new Point(x1, y1));
        }

        //paint background
        g2.setColor(Nord.n4());
        g2.fillRect(0,0,getWidth(),getHeight());

        // draw white background
        g2.setColor(Nord.n6());
        g2.fillRect(padding + labelPadding + sidespacing, padding + topspacing, getWidth() - sidespacing - (2 * padding) - labelPadding - labelPadding, getHeight() - 2 * padding - labelPadding-40);
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
                g2.drawLine(padding + labelPadding + 1 + pointWidth + sidespacing, y0, getWidth() - padding - labelPadding, y0);
                g2.setColor(Color.BLACK);
                String y1Label = ((int) ((getMinScore() + (getMaxaScore() - getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                String y2Label = ((int) ((getMinScore() + (getMaxbScore() - getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int label1Width = metrics.stringWidth(y1Label);
                g2.drawString(y1Label, x0 - label1Width - 5, y0 + (metrics.getHeight() / 2) - 3);
                g2.drawString(y2Label, getWidth() - padding - labelPadding + 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(x0, y0, x1, y0);
        }

        // and for x axis
        for (int i = 0; i < scores.size(); i++) {
            if (scores.size() > 1) {
                //int x0 = i * (getWidth() - padding * 2 - labelPadding) / (scores.size() - 1) + padding + labelPadding;
                int x0 = i * (getWidth() - sidespacing - padding * 2 - labelPadding - labelPadding) / 24 + sidespacing + padding + labelPadding;
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

        // create x and y*2 axes
        g2.setColor(Nord.n0());
        g2.drawLine(padding + labelPadding + sidespacing, getHeight() - padding - labelPadding, padding + labelPadding + sidespacing, padding + topspacing);
        g2.drawLine(padding + labelPadding + sidespacing, getHeight() - padding - labelPadding, getWidth() - padding - labelPadding , getHeight() - padding - labelPadding);
        g2.drawLine(getWidth() - padding - labelPadding, getHeight() - padding - labelPadding, getWidth() - padding - labelPadding ,   padding + topspacing);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(Nord.n11());
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < Reihe1.size() - 1; i++) {
            int x1 = Reihe1.get(i).x;
            int y1 = Reihe1.get(i).y;
            int x2 = Reihe1.get(i + 1).x;
            int y2 = Reihe1.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
        g2.setColor(Nord.n10());
        for (int i = 0; i < Reihe2.size() - 1; i++) {
            int x1 = Reihe2.get(i).x;
            int y1 = Reihe2.get(i).y;
            int x2 = Reihe2.get(i + 1).x;
            int y2 = Reihe2.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
        g2.setColor(Nord.n13());
        for (int i = 0; i < Reihe3.size() - 1; i++) {
            int x1 = Reihe3.get(i).x;
            int y1 = Reihe3.get(i).y;
            int x2 = Reihe3.get(i + 1).x;
            int y2 = Reihe3.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
            //g2.drawLine(x1,y1,x1,getHeight() - padding - labelPadding);
        }
        g2.setColor(Nord.n8());
        for (int i = 0; i < Reihe4.size() - 1; i++) {
            int x1 = Reihe4.get(i).x;
            int y1 = Reihe4.get(i).y;
            int x2 = Reihe4.get(i + 1).x;
            int y2 = Reihe4.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
        g2.setColor(Nord.n14());
        for (int i = 0; i < Reihe5.size() - 1; i++) {
            int x1 = Reihe5.get(i).x;
            int y1 = Reihe5.get(i).y;
            int x2 = Reihe5.get(i + 1).x;
            int y2 = Reihe5.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setStroke(oldStroke);
    }

    private double getMinScore() {
        double minScore = Double.MAX_VALUE;
        for (List<Double> score : scores) {
            for (Double aDouble : score) minScore = Math.min(minScore, aDouble);
        }
        return minScore;
    }

    private double getMaxaScore() {
        double maxScore = Double.MIN_VALUE;
        for (List<Double> score : scores) {
            maxScore = Math.max(maxScore, score.get(0));
            maxScore = Math.max(maxScore, score.get(2));
            maxScore = Math.max(maxScore, score.get(4));
        }
        return maxScore;
    }

    private double getMaxbScore() {
        double maxScore = Double.MIN_VALUE;
        for (List<Double> score : scores) {
            maxScore = Math.max(maxScore, score.get(1));
            maxScore = Math.max(maxScore, score.get(3));
        }
        return maxScore;
    }

}