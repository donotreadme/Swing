package uebung15;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JLabel;




public class Währungsumrechner {

	private JFrame frmWhrungsumrechner;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Währungsumrechner window = new Währungsumrechner();
					window.frmWhrungsumrechner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Währungsumrechner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWhrungsumrechner = new JFrame();
		frmWhrungsumrechner.setTitle("W\u00E4hrungsumrechner");
		frmWhrungsumrechner.setBounds(100, 100, 450, 300);
		frmWhrungsumrechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnUSD = new JRadioButton("sind in USD");
		buttonGroup.add(rdbtnUSD);
		
		JRadioButton rdbtnYin = new JRadioButton("sind in Yin");
		buttonGroup.add(rdbtnYin);
		
		JSlider slider = new JSlider();
		
		
		JLabel lblBetrag = new JLabel("50.00");
		
		JLabel lblNewLabel = new JLabel("EUR");
		
		JLabel lblErgebnis = new JLabel("sind umgerechnet");
		GroupLayout groupLayout = new GroupLayout(frmWhrungsumrechner.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblErgebnis)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBetrag)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel)))))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnYin)
						.addComponent(rdbtnUSD))
					.addGap(71))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBetrag)
								.addComponent(lblNewLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnUSD)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnYin)))
					.addGap(28)
					.addComponent(lblErgebnis)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		frmWhrungsumrechner.getContentPane().setLayout(groupLayout);
		
		
		ActionListener a = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblErgebnis.setText("USD");
				
			}
		};
		
		ActionListener b = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double c = 300.00 * Double.parseDouble(lblBetrag.getText());
				lblErgebnis.setText("sind umgerechnet " + c + " Yin");
				
			}
		};
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				double c = slider.getValue();
				lblBetrag.setText("" + c);
				}
				
			
		});
		
		
		rdbtnUSD.addActionListener(a);
		rdbtnYin.addActionListener(b);
		
		
	}
}
