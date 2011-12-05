package edu.virginia.cs4240.webmetrics.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingUtilities;

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
public class NewJFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton Fetch;
	private JTextPane jTextPane1;
	private JTextArea jTextArea3;
	private JTextArea jTextArea2;
	private JTextArea jTextArea1;
	private JSplitPane jSplitPane1;
	private JLabel jLabel1;
	private JFormattedTextField jFormattedTextField1;
	private JButton Cancel;
	private Main controller;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public NewJFrame(Main controller) {		
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
					Cancel = new JButton();
					Cancel.setText("Cancel");
					Cancel.setRolloverEnabled(true);
									}
				{
					Fetch = new JButton();
					Fetch.setText("Fetch");
					Fetch.setRolloverEnabled(true);
					Fetch.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							String x= (String) jFormattedTextField1.getValue();
							controller.fetchPage(x);
						}
					});
				}
				{
					jFormattedTextField1 = new JFormattedTextField();
				}
				{
					jTextArea1 = new JTextArea();
					jTextArea1.setText("Module2");
					jTextArea1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					jTextArea1.setEditable(false);
				}
				{
					jTextPane1 = new JTextPane();
					jTextPane1.setText("HTML PAGE");
					jTextPane1.setEditable(false);
					jTextPane1.setBorder(BorderFactory.createTitledBorder(""));
				}
				{
					jTextArea2 = new JTextArea();
					jTextArea2.setText("Module1");
					jTextArea2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					jTextArea2.setEditable(false);
				}
				{
					jTextArea3 = new JTextArea();
					jTextArea3.setText("Module3");
					jTextArea3.setEditable(false);
					jTextArea3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				}
				{
					jLabel1 = new JLabel();
					jLabel1.setText("Input HMTL:");
				}
				{
					jSplitPane1 = new JSplitPane();
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addComponent(jTextArea3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					            .addComponent(jTextArea2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					            .addComponent(jTextArea1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
					        .addGap(22)
					        .addComponent(jTextPane1, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 14, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addGap(0, 18, Short.MAX_VALUE)
					        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addComponent(Cancel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addPreferredGap(Cancel, Fetch, LayoutStyle.ComponentPlacement.INDENT)
					                .addComponent(Fetch, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap());
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(jFormattedTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(Fetch, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jTextArea2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(jTextArea1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addComponent(jTextArea3, 0, 128, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jTextPane1, 0, 396, Short.MAX_VALUE)
					        .addGap(6)))
					.addComponent(Cancel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap());
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
