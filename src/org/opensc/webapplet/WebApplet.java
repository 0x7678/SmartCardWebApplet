package org.opensc.webapplet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JLabel;

import javax.smartcardio.*;

public class WebApplet extends JApplet {
	public void init() {
		JLabel label = new JLabel("SignApplet");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.black));
		getContentPane().add(label, BorderLayout.CENTER);
		System.out.println("init");

	}
}
