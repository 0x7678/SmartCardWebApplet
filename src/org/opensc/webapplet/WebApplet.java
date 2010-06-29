package org.opensc.webapplet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JLabel;
import netscape.javascript.JSObject;

import javax.smartcardio.*;

public class WebApplet extends JApplet {
	private JSObject window;
	public void init() {
		JLabel label = new JLabel("OpenSC Web Control Applet");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.black));
		getContentPane().add(label, BorderLayout.CENTER);
		System.out.println("init");
		try {
			window = JSObject.getWindow(this);
		} catch (Exception e) {
			System.out.println("No HTML container");
		}
	}
	
	public void sign(String param, String cb1) {
		System.out.println("sign");
		window.eval("window.alert(\'helo\');");
	} 
}
