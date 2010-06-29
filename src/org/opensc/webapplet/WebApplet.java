package org.opensc.webapplet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JLabel;
import netscape.javascript.JSObject;

import javax.smartcardio.*;

public class WebApplet extends JApplet {
	private JSObject window;
	
	private boolean has_gui = false;
	public void init() {
		has_gui = getParameter("GUI") != null && getParameter("GUI").equalsIgnoreCase("true");
		if (has_gui) {
			JLabel label = new JLabel("OpenSC Web Control Applet");
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.black));
			getContentPane().add(label, BorderLayout.CENTER);
		}
		try {
			window = JSObject.getWindow(this);
		} catch (Exception e) {
			System.out.println("No HTML container");
		}
	}
	
	public ArrayList<String> sign(String param) {
		ArrayList<String> readers = new ArrayList<String>();
		try {
			TerminalFactory factory = TerminalFactory.getDefault();
			CardTerminals terminals = factory.terminals();
			for (CardTerminal terminal : terminals.list(CardTerminals.State.ALL)) {
				readers.add(terminal.getName());
			}
		} catch (CardException e) {
			e.printStackTrace();
		}
		return readers;
		//return new String("Hello from applet " + (has_gui? "with GUI": "without GUI"));
	} 
}
