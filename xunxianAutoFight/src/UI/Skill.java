/*
 * Skill.java
 *
 * Created on __DATE__, __TIME__
 */

package UI;

import include.Command;
import Func.Press;
import action.UIFunc;

/**
 *
 * @author  __USER__
 */
public class Skill extends javax.swing.JFrame {

	/** Creates new form Skill */
	public Skill() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jCheckBox1 = new javax.swing.JCheckBox();
		jPanel1 = new javax.swing.JPanel();
		jComboBox1Use = new javax.swing.JComboBox();
		jTextField1Key = new javax.swing.JTextField();
		jButtonCursorSet1 = new javax.swing.JButton();
		jComboBox2Use = new javax.swing.JComboBox();
		jTextField2Key = new javax.swing.JTextField();
		jButtonCursorSet2 = new javax.swing.JButton();
		jButtonCursorSet3 = new javax.swing.JButton();
		jComboBox3Use = new javax.swing.JComboBox();
		jTextField3Key = new javax.swing.JTextField();
		jComboBox4Use = new javax.swing.JComboBox();
		jButtonCursorSet4 = new javax.swing.JButton();
		jTextField4Key = new javax.swing.JTextField();
		jComboBox5Use = new javax.swing.JComboBox();
		jButtonCursorSet5 = new javax.swing.JButton();
		jTextField5Key = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField1Time = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField2Time = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jTextField3Time = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jTextField4Time = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jTextField5Time = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setTitle("\u540e\u53f0\u952e\u76d8\u9f20\u6807\u6a21\u62df\u64cd\u4f5c");

		jCheckBox1.setSelected(true);
		jCheckBox1.setText("\u5faa\u73af\u6267\u884c");
		jCheckBox1.setEnabled(false);

		jPanel1
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("\u952e\u76d8\u9f20\u6807\u6a21\u62df\u8bbe\u7f6e"));

		jComboBox1Use.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "不启用", "模拟按键", "鼠标左键单击", "鼠标右键单击" }));
		jComboBox1Use.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox1UseItemStateChanged(evt);
			}
		});

		jTextField1Key.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jTextField1KeyMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jTextField1KeyMouseExited(evt);
			}
		});
		jTextField1Key.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField1KeyKeyReleased(evt);
			}
		});

		jButtonCursorSet1.setText("\u8bbe\u7f6e");
		jButtonCursorSet1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jButtonCursorSet1MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jButtonCursorSet1MouseExited(evt);
			}
		});
		jButtonCursorSet1
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonCursorSet1ActionPerformed(evt);
					}
				});

		jComboBox2Use.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "不启用", "模拟按键", "鼠标左键单击", "鼠标右键单击" }));
		jComboBox2Use.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox2UseItemStateChanged(evt);
			}
		});

		jTextField2Key.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jTextField2KeyMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jTextField2KeyMouseExited(evt);
			}
		});
		jTextField2Key.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField2KeyKeyReleased(evt);
			}
		});

		jButtonCursorSet2.setText("\u8bbe\u7f6e");
		jButtonCursorSet2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jButtonCursorSet2MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jButtonCursorSet2MouseExited(evt);
			}
		});
		jButtonCursorSet2
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonCursorSet2ActionPerformed(evt);
					}
				});

		jButtonCursorSet3.setText("\u8bbe\u7f6e");
		jButtonCursorSet3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jButtonCursorSet3MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jButtonCursorSet3MouseExited(evt);
			}
		});
		jButtonCursorSet3
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonCursorSet3ActionPerformed(evt);
					}
				});

		jComboBox3Use.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "不启用", "模拟按键", "鼠标左键单击", "鼠标右键单击" }));
		jComboBox3Use.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox3UseItemStateChanged(evt);
			}
		});

		jTextField3Key.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jTextField3KeyMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jTextField3KeyMouseExited(evt);
			}
		});
		jTextField3Key.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField3KeyKeyReleased(evt);
			}
		});

		jComboBox4Use.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "不启用", "模拟按键", "鼠标左键单击", "鼠标右键单击" }));
		jComboBox4Use.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox4UseItemStateChanged(evt);
			}
		});

		jButtonCursorSet4.setText("\u8bbe\u7f6e");
		jButtonCursorSet4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jButtonCursorSet4MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jButtonCursorSet4MouseExited(evt);
			}
		});
		jButtonCursorSet4
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonCursorSet4ActionPerformed(evt);
					}
				});

		jTextField4Key.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jTextField4KeyMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jTextField4KeyMouseExited(evt);
			}
		});
		jTextField4Key.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField4KeyKeyReleased(evt);
			}
		});

		jComboBox5Use.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "不启用", "模拟按键", "鼠标左键单击", "鼠标右键单击" }));
		jComboBox5Use.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox5UseItemStateChanged(evt);
			}
		});

		jButtonCursorSet5.setText("\u8bbe\u7f6e");
		jButtonCursorSet5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jButtonCursorSet5MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jButtonCursorSet5MouseExited(evt);
			}
		});
		jButtonCursorSet5
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonCursorSet5ActionPerformed(evt);
					}
				});

		jTextField5Key.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jTextField5KeyMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jTextField5KeyMouseExited(evt);
			}
		});
		jTextField5Key.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField5KeyKeyReleased(evt);
			}
		});

		jLabel3.setText("\u7b49\u5f85\u65f6\u95f4\uff1a");

		jLabel4.setText("\u6beb\u79d2");

		jLabel5.setText("\u7b49\u5f85\u65f6\u95f4\uff1a");

		jLabel6.setText("\u6beb\u79d2");

		jLabel7.setText("\u6beb\u79d2");

		jLabel8.setText("\u7b49\u5f85\u65f6\u95f4\uff1a");

		jLabel9.setText("\u7b49\u5f85\u65f6\u95f4\uff1a");

		jLabel10.setText("\u6beb\u79d2");

		jLabel11.setText("\u7b49\u5f85\u65f6\u95f4\uff1a");

		jLabel12.setText("\u6beb\u79d2");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jComboBox5Use,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												148,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField5Key))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jComboBox4Use,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												148,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField4Key,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												84,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				9,
																				9,
																				9)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jButtonCursorSet4)
																										.addGap(
																												18,
																												18,
																												18)
																										.addComponent(
																												jLabel9,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												75,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField4Time,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												70,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel10))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jButtonCursorSet5)
																										.addGap(
																												18,
																												18,
																												18)
																										.addComponent(
																												jLabel11,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												75,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField5Time,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												70,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel12))))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jComboBox3Use,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												148,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField3Key))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jComboBox2Use,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												148,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField2Key))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jComboBox1Use,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												148,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField1Key,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												83,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				9,
																				9,
																				9)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jButtonCursorSet3)
																										.addGap(
																												18,
																												18,
																												18)
																										.addComponent(
																												jLabel8,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												75,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField3Time,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												71,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jLabel7))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jButtonCursorSet1)
																																		.addGap(
																																				18,
																																				18,
																																				18)
																																		.addComponent(
																																				jLabel3,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				75,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jTextField1Time,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				71,
																																				Short.MAX_VALUE))
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jButtonCursorSet2)
																																		.addGap(
																																				18,
																																				18,
																																				18)
																																		.addComponent(
																																				jLabel5,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				75,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jTextField2Time,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				71,
																																				Short.MAX_VALUE)))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel6,
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jLabel4,
																																javax.swing.GroupLayout.Alignment.TRAILING))))))
										.addGap(17, 17, 17)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox1Use,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonCursorSet1)
														.addComponent(jLabel4)
														.addComponent(
																jTextField1Key,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3)
														.addComponent(
																jTextField1Time,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox2Use,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6)
														.addComponent(
																jTextField2Key,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonCursorSet2)
														.addComponent(jLabel5)
														.addComponent(
																jTextField2Time,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox3Use,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel7)
														.addComponent(
																jTextField3Key,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonCursorSet3)
														.addComponent(jLabel8)
														.addComponent(
																jTextField3Time,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox4Use,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonCursorSet4)
														.addComponent(jLabel10)
														.addComponent(
																jTextField4Key,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField4Time,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel9))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox5Use,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel12)
														.addComponent(
																jTextField5Key,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonCursorSet5)
														.addComponent(jLabel11)
														.addComponent(
																jTextField5Time,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jLabel1
				.setText("\u540e\u53f0\u6a21\u62df\u952e\u76d8\u9f20\u6807\u64cd\u4f5c\uff01");

		jLabel2
				.setText("\u64cd\u4f5c\u518d\u5feb\u4e5f\u4e0d\u6015\u6389\u7ebf\u4e86\uff01\uff01");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jCheckBox1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 322,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(303, Short.MAX_VALUE)).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625,
				Short.MAX_VALUE).addComponent(jLabel2,
				javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup().addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(63, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(jCheckBox1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).addComponent(
												jLabel2).addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButtonCursorSet5MouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jButtonCursorSet4MouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jButtonCursorSet3MouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jButtonCursorSet2MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void jButtonCursorSet1MouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jButtonCursorSet5MouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillCursorMessage(evt);
	}

	private void jButtonCursorSet4MouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillCursorMessage(evt);
	}

	private void jButtonCursorSet3MouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillCursorMessage(evt);
	}

	private void jButtonCursorSet2MouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillCursorMessage(evt);
	}

	private void jButtonCursorSet1MouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillCursorMessage(evt);
	}

	private void jTextField5KeyMouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jTextField4KeyMouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jTextField3KeyMouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jTextField2KeyMouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jTextField1KeyMouseExited(java.awt.event.MouseEvent evt) {
		new action.UIFunc().hiddenMessage();
	}

	private void jTextField5KeyMouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillKeyMessage(evt,
				Command.JframeSkill.jComboBox5Use.getSelectedIndex() == 1);
	}

	private void jTextField4KeyMouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillKeyMessage(evt,
				Command.JframeSkill.jComboBox4Use.getSelectedIndex() == 1);
	}

	private void jTextField3KeyMouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillKeyMessage(evt,
				Command.JframeSkill.jComboBox3Use.getSelectedIndex() == 1);
	}

	private void jTextField2KeyMouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillKeyMessage(evt,
				Command.JframeSkill.jComboBox2Use.getSelectedIndex() == 1);
	}

	private void jTextField1KeyMouseEntered(java.awt.event.MouseEvent evt) {
		new action.UIFunc().skillKeyMessage(evt,
				Command.JframeSkill.jComboBox1Use.getSelectedIndex() == 1);
	}

	private void jTextField5KeyKeyReleased(java.awt.event.KeyEvent evt) {
		Press press = new Func.Press();
		int keyCode = press.keyCodeTransform(evt.getKeyCode());
		Command.JframeSkill.jTextField5Key.setText(press.keyCodeName(keyCode,
				evt.getKeyChar() + ""));
		Command.skillSetData[4][0] = keyCode;
		press = null;
	}

	private void jTextField4KeyKeyReleased(java.awt.event.KeyEvent evt) {
		Press press = new Func.Press();
		int keyCode = press.keyCodeTransform(evt.getKeyCode());
		Command.JframeSkill.jTextField4Key.setText(press.keyCodeName(keyCode,
				evt.getKeyChar() + ""));
		Command.skillSetData[3][0] = keyCode;
		press = null;
	}

	private void jTextField3KeyKeyReleased(java.awt.event.KeyEvent evt) {
		Press press = new Func.Press();
		int keyCode = press.keyCodeTransform(evt.getKeyCode());
		Command.JframeSkill.jTextField3Key.setText(press.keyCodeName(keyCode,
				evt.getKeyChar() + ""));
		Command.skillSetData[2][0] = keyCode;
		press = null;
	}

	private void jTextField2KeyKeyReleased(java.awt.event.KeyEvent evt) {
		Press press = new Func.Press();
		int keyCode = press.keyCodeTransform(evt.getKeyCode());
		Command.JframeSkill.jTextField2Key.setText(press.keyCodeName(keyCode,
				evt.getKeyChar() + ""));
		Command.skillSetData[1][0] = keyCode;
		press = null;
	}

	private void jTextField1KeyKeyReleased(java.awt.event.KeyEvent evt) {
		Press press = new Func.Press();
		int keyCode = press.keyCodeTransform(evt.getKeyCode());
		Command.JframeSkill.jTextField1Key.setText(press.keyCodeName(keyCode,
				evt.getKeyChar() + ""));
		Command.skillSetData[0][0] = keyCode;
		press = null;
	}

	private void jButtonCursorSet5ActionPerformed(java.awt.event.ActionEvent evt) {
		new action.Skill().setCursorAction(4);
	}

	void jComboBox5UseItemStateChanged(java.awt.event.ItemEvent evt) {
		new action.Skill().jComboBox5UseItemStateChanged();
	}

	private void jButtonCursorSet4ActionPerformed(java.awt.event.ActionEvent evt) {
		new action.Skill().setCursorAction(3);
	}

	void jComboBox4UseItemStateChanged(java.awt.event.ItemEvent evt) {
		new action.Skill().jComboBox4UseItemStateChanged();
	}

	void jComboBox3UseItemStateChanged(java.awt.event.ItemEvent evt) {
		new action.Skill().jComboBox3UseItemStateChanged();
	}

	private void jButtonCursorSet3ActionPerformed(java.awt.event.ActionEvent evt) {
		new action.Skill().setCursorAction(2);
	}

	private void jButtonCursorSet2ActionPerformed(java.awt.event.ActionEvent evt) {
		new action.Skill().setCursorAction(1);
	}

	void jComboBox2UseItemStateChanged(java.awt.event.ItemEvent evt) {
		new action.Skill().jComboBox2UseItemStateChanged();
	}

	private void jButtonCursorSet1ActionPerformed(java.awt.event.ActionEvent evt) {
		new action.Skill().setCursorAction(0);
	}

	private void jComboBox1UseItemStateChanged(java.awt.event.ItemEvent evt) {
		new action.Skill().jComboBox1UseItemStateChanged();
	}

	private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
		System.out.println(evt.getKeyCode());
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Skill().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	public static javax.swing.JButton jButtonCursorSet1;
	public static javax.swing.JButton jButtonCursorSet2;
	public static javax.swing.JButton jButtonCursorSet3;
	public static javax.swing.JButton jButtonCursorSet4;
	public static javax.swing.JButton jButtonCursorSet5;
	private javax.swing.JCheckBox jCheckBox1;
	public static javax.swing.JComboBox jComboBox1Use;
	public static javax.swing.JComboBox jComboBox2Use;
	public static javax.swing.JComboBox jComboBox3Use;
	public static javax.swing.JComboBox jComboBox4Use;
	public static javax.swing.JComboBox jComboBox5Use;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	public static javax.swing.JTextField jTextField1Key;
	public static javax.swing.JTextField jTextField1Time;
	public static javax.swing.JTextField jTextField2Key;
	public static javax.swing.JTextField jTextField2Time;
	public static javax.swing.JTextField jTextField3Key;
	public static javax.swing.JTextField jTextField3Time;
	public static javax.swing.JTextField jTextField4Key;
	public static javax.swing.JTextField jTextField4Time;
	public static javax.swing.JTextField jTextField5Key;
	public static javax.swing.JTextField jTextField5Time;
	// End of variables declaration//GEN-END:variables

}