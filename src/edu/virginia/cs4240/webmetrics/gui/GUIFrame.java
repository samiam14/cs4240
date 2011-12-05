package edu.virginia.cs4240.webmetrics.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import edu.virginia.cs4240.webmetrics.Main;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GUIFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton Fetch;
	private JComboBox StatChoice;
	private JTextPane htmlPage;
	private JTextArea StatModule;
	private JLabel text1;
	private JTextField urlInput;
	private Main controller;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public GUIFrame(Main controller) {		
		super();
		
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					Fetch = new JButton();
					Fetch.setText("Fetch");
					Fetch.setRolloverEnabled(true);
					Fetch.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							String url= urlInput.getText();
							String statChoice = (String) StatChoice.getSelectedItem();
							try {
								controller.fetchPage(url);
							} catch(IOException e) {
								urlInput.setText("Invalid url");
								// Alert the user that the page doesn't work
							}
						}
					});
				}
				{
					urlInput = new JTextField();
				}
				{
					htmlPage = new JTextPane();
					htmlPage.setText("HTML PAGE");
					htmlPage.setEditable(false);
					htmlPage.setBorder(BorderFactory.createTitledBorder(""));
					htmlPage.setOpaque(false);
				}
				{
					ComboBoxModel StatChoiceModel = 
							new DefaultComboBoxModel(
									new String[] { "All Statistics", "Link Statistics", "Element Statistics", "Resource Statistics","Page Statistics","Style Statistics" });
					StatChoice = new JComboBox();
					StatChoice.setModel(StatChoiceModel);
				}
				{
					StatModule = new JTextArea();
					StatModule.setText("StatModule");
					StatModule.setBorder(BorderFactory.createTitledBorder(""));
					StatModule.setEditable(false);
				}
				{
					text1 = new JLabel();
					text1.setText("Input URL:");
				}

				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addComponent(StatModule, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					            .addComponent(StatChoice, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
					        .addGap(22)
					        .addComponent(htmlPage, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addPreferredGap(StatModule, text1, LayoutStyle.ComponentPlacement.INDENT)
					        .addComponent(text1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(urlInput, 0, 522, Short.MAX_VALUE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					        .addComponent(Fetch, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, 24));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(urlInput, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(text1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(Fetch, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(StatChoice, 0, 24, Short.MAX_VALUE)
					        .addGap(20)
					        .addComponent(StatModule, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					    .addComponent(htmlPage, GroupLayout.Alignment.LEADING, 0, 444, Short.MAX_VALUE))
					.addContainerGap(17, 17));
			}
			pack();
			this.setSize(786, 555);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void FetchActionPerformed(ActionEvent evt) {
		System.out.println("Fetch.actionPerformed, event="+evt);
		//TODO add your code for Fetch.actionPerformed
	}
	
	private void FetchMouseClicked(MouseEvent evt) {
		System.out.println("Fetch.mouseClicked, event="+evt);
		//TODO add your code for Fetch.mouseClicked
	}


}
