package com.ai.problem1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Maze extends JPanel {

	private static final long serialVersionUID = 1L;
	private int size;

	public Maze() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int tileSize = size / 101;

		for (int i = 0; i < 101; i++) {
			g.drawLine(i * tileSize, 0, i * tileSize, 101 * size);
			g.drawLine(0, i * tileSize, 101 * size, i * tileSize);
		}

		g.setColor(Color.BLACK);
		Random rand1 = new Random();
		int RandomNumber = rand1.nextInt(101);

		for (int i = 0; i < RandomNumber; i++) {
			for (int j = 0; i + j < RandomNumber; j++) {
				int RandomRow = rand1.nextInt(101);
				int RandomCol = rand1.nextInt(101);
				g.fillRect(RandomRow * tileSize, RandomCol * tileSize, tileSize, tileSize);
			}
		}
	}

	public JFrame configureFrame(JPanel panel, int size) {
		JFrame f = new JFrame();
		this.size = size;
		JScrollPane pane = new JScrollPane(panel);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		f.setTitle("Maze Runner");
		f.getContentPane().add(pane);
		f.setPreferredSize(new Dimension(size, size));
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
		return f;
	}

}