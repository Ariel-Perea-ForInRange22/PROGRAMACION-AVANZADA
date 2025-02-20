package Ejercicio2_Unidad1.src.ejercicio_unidad1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
public class Mainframe extends JFrame {
	
	private textpanel textpanel;
    private toolbar tool;
    private form formp;

    public Mainframe() {
        super("a2203245140 Brenda");

        setLayout(new BorderLayout());
        tool = new toolbar();
        textpanel = new textpanel();
        formp = new form();

        tool.setlistener(new listener() {
            public void textEmitted(String text) {
                textpanel.appendText(text);
            }
        });

        formp.setFormListener(new FormListener() {
            public void formEventOcurred(formevent e) {
                String name = e.getName();
                String ocu = e.getOcu();
                int ageCat = e.getAgeCategory();
                String empCat = e.getEmploymentCategory();
                
                
                textpanel.appendText(name + " : " + ocu + " , " + ageCat+ " , "+empCat);
            }
        });

        add(formp, BorderLayout.WEST);
        add(tool, BorderLayout.NORTH);
        add(textpanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
