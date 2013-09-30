package net.tmt.td;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.tmt.td.engine.GameEngine;


public class Main {
	public static void main(final String[] args) {
		GameEngine engine = new GameEngine();
		JFrame frame = new JFrame("Tower Proto");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(engine);
		frame.setContentPane(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		engine.start();
	}
}
