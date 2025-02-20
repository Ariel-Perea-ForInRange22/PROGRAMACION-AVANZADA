package Ejercicio2_Unidad1.src.ejercicio_unidad1;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class form extends JPanel {
	
	private JLabel name;
    private JLabel ocu;
    private JTextField namef;
    private JTextField ocuf;
    private JButton ok;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;

    public form() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        name = new JLabel("name: ");
        ocu = new JLabel("ocupacion: ");
        namef = new JTextField(10);
        ocuf = new JTextField(10);
        ageList = new JList();
        empCombo = new JComboBox();
        
        
        //list box

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "65 or over"));
        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110, 68));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);
        
        // combo box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("umemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        empCombo.setEditable(true);
        
        
        
        ok = new JButton("OK");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namef.getText();
                String ocup = ocuf.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String empCat = (String)empCombo.getSelectedItem();
                		
                		
               System.out.println(empCat);
                
                formevent ev = new formevent(this, name, ocup, ageCat.getId(), empCat);

                if (formListener != null) {
                    formListener.formEventOcurred(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("add person");
        Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outer, innerBorder));
        layoutComponents();
    }
    
    public void layoutComponents () {
    	
    
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(name, gc);

        gc.gridx = 1;
       
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(namef, gc);

        ///second
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
      
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(ocu, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ageList, gc);
        
        //// third
        
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;
        
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel ("Empleo: "), gc);
      
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(empCombo, gc);
///7cuatro 
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 2.0;
        
      
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ok, gc);
    
    
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

class AgeCategory {
    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    
    }
}
