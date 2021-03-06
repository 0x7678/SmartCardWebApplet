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
	
	private boolean has_gui = true;
	
	public void init() {
		if (getParameter("gui") != null) {
			has_gui = !getParameter("gui").equalsIgnoreCase("false");
		}
		
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
	
	public String sign(String param) {
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
		return "Applet "+ getParameter("nickname") + (has_gui ? " with GUI" : " without GUI") + " found the following readers: " + readers.toString();
	} 
}
