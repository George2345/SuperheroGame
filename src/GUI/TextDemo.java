
package GUI;

import java.awt.FlowLayout;
import java.awt.TextArea;
import javax.swing.*;

public class TextDemo extends JFrame {
	
	private TextArea textArea;
	
	public TextDemo(String text) {
		setSize(275, 275);
		setLayout(new FlowLayout());
		setTitle("Jugador creado!");
		textArea = new TextArea();
		textArea.setRows(8);
		textArea.setColumns(20);
		textArea.setEditable(false);
		add(textArea);
		textArea.append(text);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
