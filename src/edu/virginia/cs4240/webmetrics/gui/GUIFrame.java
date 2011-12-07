package edu.virginia.cs4240.webmetrics.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import edu.virginia.cs4240.webmetrics.WebRequest;
import edu.virginia.cs4240.webmetrics.modules.AllModules;
import edu.virginia.cs4240.webmetrics.modules.DisplayOption;
import edu.virginia.cs4240.webmetrics.modules.ElementModule;
import edu.virginia.cs4240.webmetrics.modules.Module;
import edu.virginia.cs4240.webmetrics.modules.PageModule;


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
	private JScrollPane jScrollPane1;
	private JButton fetch;
	private JScrollPane jScrollPane2;
	private JLabel text1;
	private JComboBox statChoice;
	private JTextArea statText;
	private JTextField urlText;
	private JTextArea htmlText;
	private final LinkedList<DisplayOption> options;
	private final Dimension screenSize;
	
	/**
	* Auto-generated main method to display this JFrame
	*/

	public GUIFrame(String title) {		
		super(title);
		
		options = new LinkedList<DisplayOption>();
		options.add(new DisplayOption("Element Statistics", new ElementModule()));
		options.add(new DisplayOption("Page Statistics", new PageModule()));
		options.addFirst(new DisplayOption("All Statistics", new AllModules((List<DisplayOption>) options.clone())));
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				htmlText = new JTextArea();
				jScrollPane1 = new JScrollPane(htmlText);
				jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				htmlText.setText(" ");
				//htmlText.setPreferredSize(new java.awt.Dimension(352, 1299));
				htmlText.setEditable(false);
			}
			{
				urlText = new JTextField();
				urlText.setText("https://www.google.com");
			}
			{
				ComboBoxModel statChoiceModel = 
						new DefaultComboBoxModel(options.toArray());
				statChoice = new JComboBox();
				statChoice.setModel(statChoiceModel);
				statChoice.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DisplayOption opt = (DisplayOption) statChoice.getSelectedItem();
						statText.setText(opt.fetchOptionStatistics());
					}
				});
			}
			{
				text1 = new JLabel();
				text1.setText("Input URL:");
			}
			{
				fetch = new JButton();
				fetch.setText("Fetch");
				fetch.setRolloverEnabled(true);
				fetch.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						String url= urlText.getText();
						DisplayOption choice = (DisplayOption) statChoice.getSelectedItem();
						try {
							WebRequest req = new WebRequest(url);
							req.validateRequest();
							Module.setRequest(req);
							
							String html = req.getDocument().toString();
							htmlText.setText(html);
							statText.setText(choice.fetchOptionStatistics());
						} catch(IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							// Alert the user that the page doesn't work
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "Error parsing document:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}		
			{
				statText = new JTextArea();
				jScrollPane2 = new JScrollPane(statText);
				jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);	
			
				statText.setText(" ");
				statText.setEditable(false);
			}
			
			JPanel northPanel = new JPanel();
			northPanel.add(text1);
			northPanel.add(urlText);
			northPanel.add(fetch);
			add(northPanel, BorderLayout.NORTH);
			JPanel leftPanel = new JPanel(new BorderLayout());
			leftPanel.add(statChoice, BorderLayout.NORTH);
			leftPanel.add(jScrollPane2, BorderLayout.CENTER);
			JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, jScrollPane1);
			splitPane.setDividerLocation((int)(screenSize.getWidth() * 0.3));
			add(splitPane, BorderLayout.CENTER);
			pack();
			this.setSize(screenSize);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error creating the GUI.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
