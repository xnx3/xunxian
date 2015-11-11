/*
 * Main.java
 *
 * Created on __DATE__, __TIME__
 */

package UI;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;

import include.Command;
import action.File;
import action.Init;
import action.Profession;
import action.UIFunc;

/**
 *
 * @author  __USER__
 */
public class Main extends javax.swing.JFrame {

	/** Creates new form Main */
	public Main() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTabbedPane = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		explainjLabel = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		daGuaiModeljComboBox = new javax.swing.JComboBox();
		daGuaiMapjComboBox = new javax.swing.JComboBox();
		setParamjButton = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		runStartjButton = new javax.swing.JButton();
		runEndjButton = new javax.swing.JButton();
		SaveDatajButton = new javax.swing.JButton();
		jPanel7 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		professionjComboBox = new javax.swing.JComboBox();
		seeJiNengjButton = new javax.swing.JButton();
		jPanel8 = new javax.swing.JPanel();
		setHwndjLabel = new javax.swing.JLabel();
		getHwndjButton = new javax.swing.JButton();
		jPanel9 = new javax.swing.JPanel();
		keyjLabel = new javax.swing.JLabel();
		registerCode = new javax.swing.JTextField();
		registerCodeButton = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		logTextArea = new javax.swing.JTextArea();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		myInfojLabel = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		setMailjTextField = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		roleNamejTextField = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		delayjComboBox = new javax.swing.JComboBox();
		jPanel10 = new javax.swing.JPanel();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jPanel11 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jTextFieldMyOverTime = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jComboBoxErrorXueStart = new javax.swing.JComboBox();
		jLabel10 = new javax.swing.JLabel();
		jComboBoxOptimize = new javax.swing.JComboBox();
		jCheckBoxUseOptimizeCpu = new javax.swing.JCheckBox();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem11 = new javax.swing.JMenuItem();
		jMenuItem12 = new javax.swing.JMenuItem();
		jMenuItem14 = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem10 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenuItem9 = new javax.swing.JMenuItem();
		jMenuItem13 = new javax.swing.JMenuItem();
		jMenu6 = new javax.swing.JMenu();
		jMenu5 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem15 = new javax.swing.JMenuItem();
		jMenu7 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setResizable(false);

		explainjLabel.setForeground(keyjLabel.getForeground());
		explainjLabel.setAutoscrolls(true);
		explainjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				explainjLabelMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				explainjLabelMouseEntered(evt);
			}
		});

		jLabel2.setForeground(keyjLabel.getForeground());
		jLabel2.setText(" \u9009\u62e9\u6a21\u5f0f\uff1a");

		daGuaiModeljComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "选择打怪模式" }));
		daGuaiModeljComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				daGuaiModeljComboBoxItemStateChanged(evt);
			}
		});

		daGuaiMapjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "选择打怪区域" }));
		daGuaiMapjComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				daGuaiMapjComboBoxItemStateChanged(evt);
			}
		});

		setParamjButton.setText("\u53c2\u6570\u8bbe\u7f6e");
		setParamjButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				setParamjButtonMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				setParamjButtonMouseExited(evt);
			}
		});
		setParamjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setParamjButtonActionPerformed(evt);
			}
		});

		jLabel3.setForeground(keyjLabel.getForeground());
		jLabel3.setText("\u7c7b\u578b\uff1a");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addComponent(jLabel2)
										.addGap(12, 12, 12)
										.addComponent(
												daGuaiModeljComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												133,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												daGuaiMapjComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												236,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(setParamjButton)
										.addContainerGap(85, Short.MAX_VALUE)));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addGap(2, 2, 2)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(jLabel3)
														.addComponent(
																daGuaiModeljComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																setParamjButton)
														.addComponent(
																daGuaiMapjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		runStartjButton.setText("\u8fd0\u884c");
		runStartjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				runStartjButtonActionPerformed(evt);
			}
		});

		runEndjButton.setText("\u7ed3\u675f");
		runEndjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				runEndjButtonActionPerformed(evt);
			}
		});

		SaveDatajButton.setText("\u4fdd\u5b58\u6570\u636e");
		SaveDatajButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				SaveDatajButtonMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				SaveDatajButtonMouseExited(evt);
			}
		});
		SaveDatajButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SaveDatajButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout
				.setHorizontalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addGap(112, 112, 112)
										.addComponent(runStartjButton)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												258, Short.MAX_VALUE)
										.addComponent(runEndjButton).addGap(66,
												66, 66).addComponent(
												SaveDatajButton).addGap(74, 74,
												74)));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel6Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(runStartjButton).addComponent(
								runEndjButton).addComponent(SaveDatajButton)));

		jLabel12.setForeground(keyjLabel.getForeground());
		jLabel12.setText("\u6211\u7684\u804c\u4e1a\uff1a");

		professionjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "掌电法师", "控火法师", "乘风法师", "罗刹力士", "金刚力士", "奇门游侠",
						"御剑游侠", "天君符咒师", "幽冥符咒师", "乾坤游侠" }));

		seeJiNengjButton.setText("\u67e5\u770b\u6280\u80fd\u653e\u7f6e");
		seeJiNengjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				seeJiNengjButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout
				.setHorizontalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addGap(21, 21, 21)
										.addComponent(jLabel12)
										.addGap(13, 13, 13)
										.addComponent(
												professionjComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												183,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												seeJiNengjButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												149,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(278, Short.MAX_VALUE)));
		jPanel7Layout
				.setVerticalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel7Layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																seeJiNengjButton)
														.addComponent(jLabel12)
														.addComponent(
																professionjComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		setHwndjLabel.setForeground(keyjLabel.getForeground());
		setHwndjLabel
				.setText("  \u8bf7\u70b9\u51fb\u83b7\u53d6\u76ee\u6807\u7a97\u53e3\u6309\u94ae\u83b7\u53d6\u8981\u64cd\u4f5c\u7684\u6307\u5b9a\u7684\u6e38\u620f\u7a97\u53e3 ");
		setHwndjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				setHwndjLabelMouseClicked(evt);
			}
		});
		setHwndjLabel
				.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
					public void vetoableChange(
							java.beans.PropertyChangeEvent evt)
							throws java.beans.PropertyVetoException {
						setHwndjLabelVetoableChange(evt);
					}
				});

		getHwndjButton.setText("\u83b7\u53d6\u76ee\u6807\u7a97\u53e3");
		getHwndjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				getHwndjButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout
				.setHorizontalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel8Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addComponent(
												getHwndjButton,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												143, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												setHwndjLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												401,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(159, 159, 159)));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel8Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(setHwndjLabel).addComponent(
								getHwndjButton)));

		keyjLabel.setText("\u8bf7\u8f93\u5165\u6ce8\u518c\u7801\uff1a");
		keyjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				keyjLabelMouseClicked(evt);
			}
		});

		registerCode.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				registerCodeMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				registerCodeMouseExited(evt);
			}
		});

		registerCodeButton.setText("\u6ce8\u518c");
		registerCodeButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						registerCodeButtonActionPerformed(evt);
					}
				});

		jButton1.setText("\u8d2d\u4e70\u81ea\u52a8\u8fc7\u9a8c\u8bc1\u7801");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(
				jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout
				.setHorizontalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addGap(27, 27, 27)
										.addComponent(keyjLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												registerCode,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												195,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												registerCodeButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												126,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												213,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(44, Short.MAX_VALUE)));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel9Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(keyjLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(registerCode,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(registerCodeButton)
						.addComponent(jButton1)));

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
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(
																				jPanel5,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jPanel7,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jPanel8,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jPanel9,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addContainerGap()
																						.addComponent(
																								explainjLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								524,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jPanel6,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jPanel9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(
												jPanel8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												explainjLabel,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												18, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(92, 92, 92)));

		jTabbedPane.addTab("\u8f6f\u4ef6\u8bbe\u7f6e", jPanel1);

		logTextArea.setColumns(20);
		logTextArea.setRows(5);
		jScrollPane1.setViewportView(logTextArea);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759,
				Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343,
				Short.MAX_VALUE));

		jTabbedPane.addTab("\u8fd0\u884c\u65e5\u5fd7", jPanel4);

		jPanel3.setBorder(javax.swing.BorderFactory
				.createTitledBorder("\u6211\u7684\u5f53\u524d\u4fe1\u606f"));

		myInfojLabel.setText("\u6570\u636e\u8f7d\u5165\u4e2d\u2026\u2026");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(myInfojLabel,
								javax.swing.GroupLayout.DEFAULT_SIZE, 182,
								Short.MAX_VALUE).addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout.createSequentialGroup().addComponent(
						myInfojLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
						187, Short.MAX_VALUE).addContainerGap()));

		jLabel1.setText("\u6211\u7684\u90ae\u7bb1\uff1a");

		setMailjTextField.setText("123456@qq.com");
		setMailjTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				setMailjTextFieldMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				setMailjTextFieldMouseExited(evt);
			}
		});

		jLabel4.setText("\u6e38\u620f\u89d2\u8272\u540d\uff1a");

		roleNamejTextField
				.setText("\u4f60\u6302\u673a\u7684\u89d2\u8272\u540d\u5b57");
		roleNamejTextField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				roleNamejTextFieldMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				roleNamejTextFieldMouseExited(evt);
			}
		});
		roleNamejTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				roleNamejTextFieldFocusLost(evt);
			}
		});

		jLabel5.setText("\u7f51\u7edc\u5ef6\u8fdf\uff1a");
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel5MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel5MouseExited(evt);
			}
		});

		delayjComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "200以内", "200到500", "500到1000", "1000到2000",
						"2000以上" }));
		delayjComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				delayjComboBoxMouseEntered(evt);
			}
		});
		delayjComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				delayjComboBoxItemStateChanged(evt);
			}
		});

		jButton2.setText("\u5404\u9879\u529f\u80fd\u4f7f\u7528\u5e2e\u52a9");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u51fa\u9519\u6545\u969c\u89e3\u51b3");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("\u8f6f\u4ef6\u51fa\u9519\u6545\u969c\u53cd\u9988");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("\u4f7f\u7528\u8bf4\u660e");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																127,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																127,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																146,
																Short.MAX_VALUE)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																146,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		jPanel10Layout
				.setVerticalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton2)
														.addComponent(jButton5))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton3)
														.addComponent(jButton4))
										.addContainerGap(28, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jPanel3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(17, 17, 17)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jLabel5,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel4,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								78,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								delayjComboBox,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								roleNamejTextField)
																						.addComponent(
																								setMailjTextField,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								223,
																								Short.MAX_VALUE)))
														.addComponent(
																jPanel10,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(184, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jPanel3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(
																				25,
																				25,
																				25)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								setMailjTextField,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								roleNamejTextField,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								delayjComboBox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				69,
																				69,
																				69)
																		.addComponent(
																				jPanel10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(42, Short.MAX_VALUE)));

		jTabbedPane.addTab("\u6211\u7684\u4fe1\u606f", jPanel2);

		jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6
				.setText("\u5bf9\u672c\u8f6f\u4ef6\u4e0d\u662f\u975e\u5e38\u719f\u6089\u7684\u8bf7\u4e0d\u8981\u968f\u610f\u66f4\u6539\u8fd9\u91cc\uff01");

		jLabel7
				.setText("\u6253\u602a\u6b7b\u4ea1\u540e\u590d\u6d3b\u7b49\u5f85\u65f6\u95f4\uff1a");

		jTextFieldMyOverTime.setText("60000");

		jLabel8.setText("\u6beb\u79d2");

		jLabel9
				.setText("\u8840\u91cf\u4e0d\u5339\u914d\u65e0\u6cd5\u5f00\u542f\uff1a");

		jComboBoxErrorXueStart.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "正常模式", "特殊模式" }));

		jLabel10.setText("\u5b9a\u65f6\u4f18\u5316\u8f6f\u4ef6\uff1a");

		jComboBoxOptimize.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "2小时", "6小时", "9小时", "12小时", "18小时", "24小时" }));

		jCheckBoxUseOptimizeCpu
				.setText("\u662f\u5426\u5f00\u542fCPU\u964d\u9891(\u6781\u5927\u51cf\u5c11\u5bfb\u4ed9\u5bf9CPU\u5360\u7528)");

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(
				jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout
				.setHorizontalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel6,
								javax.swing.GroupLayout.DEFAULT_SIZE, 759,
								Short.MAX_VALUE)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel11Layout
										.createSequentialGroup()
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel11Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel9,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								258,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel7,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								258,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				180,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				27,
																				27,
																				27)))
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jComboBoxOptimize,
																0,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jComboBoxErrorXueStart,
																0,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jTextFieldMyOverTime,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																99,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jLabel8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												40,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(350, 350, 350))
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addComponent(
												jCheckBoxUseOptimizeCpu,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												380,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		jPanel11Layout
				.setVerticalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addComponent(
												jLabel6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												36,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextFieldMyOverTime,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8)
														.addComponent(jLabel7))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(
																jComboBoxErrorXueStart,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(15, 15, 15)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel10)
														.addComponent(
																jComboBoxOptimize,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jCheckBoxUseOptimizeCpu)
										.addContainerGap(155, Short.MAX_VALUE)));

		jTabbedPane.addTab("\u9ad8\u7ea7\u8bbe\u7f6e", jPanel11);

		jMenu4
				.setText("\u4e00\u6b65\u4e00\u6b65\u6559\u4f7f\u7528\u3010\u6c47\u603b\u3011");

		jMenuItem11
				.setText("\u81ea\u52a8\u6253\u602a\u6240\u6709\u6b65\u9aa4\u8bf4\u660e");
		jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem11ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem11);

		jMenuItem12
				.setText("\u81ea\u52a8\u626b\u8d27\u6240\u6709\u6b65\u9aa4\u8bf4\u660e");
		jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem12ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem12);

		jMenuItem14
				.setText("\u9ad8\u7ea7\u6253\u602a\u6a21\u5f0f-\u5de5\u4f5c\u5ba4\u4f7f\u7528");
		jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem14ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem14);

		jMenuBar1.add(jMenu4);

		jMenu1.setText("\u89c6\u9891");

		jMenuItem1
				.setText("\u8f6f\u4ef6\u57fa\u7840\u64cd\u4f5c\u53ca\u6e38\u620f\u8bbe\u7f6e");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2
				.setText("\u81ea\u52a8\u6253\u602a\u4f7f\u7528\u89c6\u9891\u8bb2\u89e3");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem3
				.setText("\u81ea\u52a8\u626b\u8d27\u4f7f\u7528\u89c6\u9891\u8bb2\u89e3");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);

		jMenuItem4
				.setText("\u540e\u53f0\u952e\u76d8\u9f20\u6807\u6a21\u62df\u9632\u6389\u7ebf");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem4);

		jMenuBar1.add(jMenu1);

		jMenu3.setText("\u6587\u5b57\u53ca\u56fe\u7247\u8bf4\u660e");
		jMenu3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu3ActionPerformed(evt);
			}
		});

		jMenuItem10.setText("\u8f6f\u4ef6\u4e3b\u9875");
		jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem10ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem10);

		jMenuItem5.setText("\u6e38\u620f\u5185\u7cfb\u7edf\u8bbe\u7f6e\u56fe");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem5);

		jMenuItem6.setText("\u8f6f\u4ef6\u591a\u5f00\u8bf4\u660e");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem6);

		jMenuItem7.setText("\u83b7\u53d6\u76ee\u6807\u7a97\u53e3");
		jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem7);

		jMenuItem8.setText("\u624b\u673a\u5b9e\u65f6\u76d1\u63a7");
		jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem8ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem8);

		jMenuItem9.setText("\u81ea\u52a8\u626b\u8d27\u6587\u5b57\u8bf4\u660e");
		jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem9ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem9);

		jMenuItem13
				.setText("\u81ea\u52a8\u626b\u8d27\u7684\u533a\u57df\u6807\u6ce8");
		jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem13ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem13);

		jMenuBar1.add(jMenu3);

		jMenu6.setText("\u5e38\u89c1\u6545\u969c\u89e3\u51b3");
		jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu6MouseClicked(evt);
			}
		});
		jMenuBar1.add(jMenu6);

		jMenu5.setText("\u66f4\u65b0\u8bb0\u5f55");
		jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu5MouseClicked(evt);
			}
		});
		jMenu5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu5ActionPerformed(evt);
			}
		});
		jMenuBar1.add(jMenu5);

		jMenu2.setText("\u4e8c\u6b21\u5f00\u53d1");

		jMenuItem15.setText("\u62ff\u6e90\u7801\u81ea\u5df1\u5f00\u53d1");
		jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem15ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem15);

		jMenuBar1.add(jMenu2);

		jMenu7.setText("\u8f6f\u4ef6\u4fe1\u606f");
		jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu7MouseClicked(evt);
			}
		});
		jMenu7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu7ActionPerformed(evt);
			}
		});
		jMenuBar1.add(jMenu7);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 764,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 377,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {
		new Func.Message().showMessageDialog("" +
				"一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一<br/>" +
				"作者：蓬莱岛-为将-剑心<br/>" +
				"软件版本："+Command.version+"<br/>"+
				"联系QQ：921153866<br/>" +
				"官方网站：www.xnx3.com<br/>" +
				"联系邮箱：mail@xnx3.com<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>" +
				"一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一");
	}

	private void jMenu7ActionPerformed(java.awt.event.ActionEvent evt) {
		new Func.Message()
				.showMessageDialog(""
						+ "----------------------------------------------------------"
						+ "<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>"
						+ "----------------------------------------------------------");
	}

	private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("软件使用Java编写，使用了大漠、大兵、信诺模块，与游戏的交互、图、色、文字点阵等辨别都已写Java接口，<br/>可以完全使用Java来进行开发！软件源代码会象征性收费1000元<br/>随着时间价格会逐渐降低，甚至，会免费放出！敬请期待！喜欢辅助软件开发的小朋友，可以联系，<br/>当然，喜欢不劳而获的那种人，请勿打扰！<br/><br/>"
						+ "功能简介：<br/>"
						+ "1.打怪挂机点增加So Easy，录入点坐标，一行代码就可增加一个挂机点！<br/>"
						+ "2.多线程监控，打怪线程、辅助线程、日志线程、系统线程、定时监控软件正常运行<br/>"
						+ "3.底层接口丰富，大漠、信诺...等模块操作系统的接口全部用写好，可直接调用！不想做寻仙做其他的游戏也完全可以<br/>"
						+ "4.基本功能模块皆有，JAVA的松耦合完美诠释。每个模块都可单独拿出做其他游戏的辅助，就如，按键精灵！<br/>"
						+ "5.扫货的数据维护，八卦灵石、宠物壳子、可直接一行代码录入数据！这都不是事<br/>"
						+ "6.界面使用MyEclipse8.5设计，可拖拽如VB、易语言的界面设计<br/>"
						+ "7.整套自己的系统，有自己的腾讯云服务器，php软件注册系统！注册码开号实时控制<br/>"
						+ "8.内置代理接口，代理可自行开注册码<br/>"
						+ "<br/>"
						+ "废话不多说，本人QQ921153866，拒加喜欢不劳而获者，贪小便宜者，思想愚笨者<br/>"
						+ "<br/>是否查看源码文件？") == ConfirmationCallback.YES) {
			System.out.println("aaa");
		}
	}

	private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140408/116.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140308/81.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140308/80.html",
				200, 200, 1024, 900);
	}

	private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {
		Command.browser.loadUrl("http://www.xnx3.com/xunxian/error/", 200, 200,
				1024, 900);
	}

	private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140308/79.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140308/77.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140307/76.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140305/73.html",
				200, 200, 1024, 900);
	}

	private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {
		Command.browser.loadUrl("http://www.xnx3.com/xunxian/autoFightUpdate/",
				200, 200, 1024, 900);
	}

	private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl("http://www.xnx3.com/xunxian/fuzhu/shop.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/fuzhu/2012-10-15/6.html", 200,
				200, 1024, 900);
	}

	private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl("http://www.xnx3.com/xunxian/autoFightUpdate/",
				200, 200, 1024, 900);
	}

	private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20130417/13.html",
				200, 200, 1024, 900);
	}

	private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20130425/17.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20130417/13.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20130417/14.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140304/72.html",
				200, 200, 1024, 900);
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/xxautofight/20140216/71.html",
				200, 200, 1024, 900);
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl(
				"http://www.xnx3.com/xunxian/fuzhu/2012-10-15/6.html", 200,
				200, 1024, 900);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl("http://www.xnx3.com/e/tool/feedback/?bid=1",
				200, 200, 800, 600);
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl("http://www.xnx3.com/xunxian/error/", 200, 200,
				1024, 900);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		Command.browser.loadUrl("http://www.xnx3.com/xunxian/xxautofight/",
				200, 200, 1024, 900);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("游戏已不再留恋！软件全部免费！<br/>原本只能购买才能用的自动扫货跟工作室用的高级打怪模式全自动卦机打怪，现免费发布，免费使用！<br/>免费注册码为www.xnx3.com注册便可以用！<br/>本软件使用Java编写！精通Java，对辅助有兴趣的，可联系我QQ921153866购买源码，继续开发下去！<br/><br/>【注】软件已全免费，但答题是用的第三方的答题平台，喜欢软件的仙友仍可以自行购买自动答题服务") == ConfirmationCallback.YES) {
			Command.browser.loadUrl(
					"http://www.xnx3.com/xunxian/fuzhu/shenshan_kefu.html",
					200, 200, 800, 600);
		}
		//		switch (Command.agent) {
		//		case 1: //1是自己的
		//			Object[] options = { "自动扫货购买", "打怪自动过验证码服务" };
		//			int response = JOptionPane
		//					.showOptionDialog(
		//							null,
		//							"自动打怪功能、后台键盘鼠标模拟、捉宝宝打符、免费使用！\n免费注册码：www.xnx3.com\n\n自动扫货续费都是5元一个月超低价！\n自动打怪可以购买自动过验证码服务，无需人工值守",
		//							"软件购买", JOptionPane.YES_OPTION,
		//							JOptionPane.QUESTION_MESSAGE, null, options,
		//							options[0]);
		//			if (response == 0) { //客服购买
		//				Command.browser
		//						.loadUrl(
		//								"http://www.xnx3.com/xunxian/xxautofight/20140308/82.html",
		//								200, 200, 1024, 900);
		//			} else if (response == 1) {
		//				Command.browser
		//						.loadUrl(
		//								"http://www.xnx3.com/xunxian/xxautofight/20140308/83.html",
		//								200, 200, 1024, 900);
		//			}
		//		case 2:
		//			Command.browser.loadUrl(
		//					"http://www.xnx3.com/xunxian/fuzhu/shenshan_kefu.html",
		//					200, 200, 420, 700);
		//		}
	}

	private void delayjComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
		new UIFunc().delayItemIsChange_UI();
	}

	private void delayjComboBoxMouseEntered(java.awt.event.MouseEvent evt) {

	}

	private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {
		new UIFunc()
				.showMessage(
						evt.getXOnScreen() + 10,
						evt.getYOnScreen() + 10,
						285,
						168,
						"你游戏里面的网络延迟，可以将鼠标移动到游戏里面的最右下角看看你游戏的延迟状况。不懂的自己游戏里面喊个大喇叭问问怎么看游戏延迟。<br/>这里的是逻辑延迟与网络延迟相加的数所在的范围。若是延迟非常不稳定的话以最大的延迟数为准。<br/>如：逻辑延迟120，网络延迟150，则总延迟为280，则选择200到500的范围");
	}

	private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {
		new UIFunc().hiddenMessage();
	}

	private void setParamjButtonMouseExited(java.awt.event.MouseEvent evt) {
		new UIFunc().hiddenMessage();
	}

	private void setParamjButtonMouseEntered(java.awt.event.MouseEvent evt) {
		switch (Command.JForm.daGuaiModeljComboBox.getSelectedIndex()) {
		case 2:
			new UIFunc().showMessage(evt.getXOnScreen() + 20, evt
					.getYOnScreen() + 20, 150, 70,
					Command.routeMapXArray[12][1] > 0 ? "已设定挂机点<br/>坐标:"
							+ Command.routeMapXArray[12][0] + "|"
							+ Command.routeMapXArray[12][1]
							: "未设定挂机点<br/>请先设定！");
			break;
		case 4:
			new UIFunc().showMessage(evt.getXOnScreen() + 20, evt
					.getYOnScreen() + 20, 150, 50, "请配置扫货参数");
			break;
		case 5:
			new UIFunc().showMessage(evt.getXOnScreen() + 20, evt
					.getYOnScreen() + 20, 250, 50, "请配置模拟鼠标按键的操作");
			break;
		default:
			break;
		}
	}

	private void registerCodeMouseExited(java.awt.event.MouseEvent evt) {
		new UIFunc().hiddenMessage();
	}

	private void registerCodeMouseEntered(java.awt.event.MouseEvent evt) {
		new UIFunc()
				.showMessage(
						evt.getXOnScreen() + 20,
						evt.getYOnScreen() + 20,
						250,
						120,
						"免费注册码：www.xnx3.com可使用普通打怪模式<br/>付费用户可直接输出购买所得的注册码便可<br/>付费用户注册码请妥善保管！未绑定机型的注册码可以再任意电脑上使用！");
	}

	private void setMailjTextFieldMouseEntered(java.awt.event.MouseEvent evt) {
		new UIFunc()
				.showMessage(
						evt.getXOnScreen() + 20,
						evt.getYOnScreen() + 20,
						300,
						140,
						"输入你的邮箱，当游戏中出现意外事件（出错、掉线、弹出英文错误）等会立马发送至你的邮箱。<br/>QQ邮箱可以在手机安装一个微信客户端，第一时间接收到提醒!<br/>·注意，此项免费用户无法使用，只限付费用户(购买过答题、水底开鼓、扫货的用户)使用");
	}

	private void setMailjTextFieldMouseExited(java.awt.event.MouseEvent evt) {
		new UIFunc().hiddenMessage();
	}

	private void roleNamejTextFieldMouseExited(java.awt.event.MouseEvent evt) {
		new UIFunc().hiddenMessage();
	}

	private void roleNamejTextFieldMouseEntered(java.awt.event.MouseEvent evt) {
		new UIFunc()
				.showMessage(
						evt.getXOnScreen() + 10,
						evt.getYOnScreen() + 10,
						300,
						210,
						"软件对应的寻仙客户端中你游戏的角色名<br/>此项主要为多开的用户使用，方面找到打开的哪个对应着哪个游戏角色<br/>可以填入角色名，或者也可以填入所在服-角色名，如填入：蓬莱岛-寻仙-我欲成仙(蓬莱岛是所在服务器，寻仙-我欲成仙是我的角色名)， 那么软件运行时软件的名字就会变成这个，方便寻找。<br/>若是游戏出现意外事故发送有邮件时，此项也会一起通过邮件发送，及时了解是哪一台电脑、哪一个服务器的哪个角色出现的意外事故");
	}

	private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {

	}

	private void roleNamejTextFieldFocusLost(java.awt.event.FocusEvent evt) {
		Command.JForm.setTitle(Command.JForm.roleNamejTextField.getText() + "-"
				+ Command.title + Command.version);
	}

	private void SaveDatajButtonMouseExited(java.awt.event.MouseEvent evt) {
		new UIFunc().hiddenMessage();
	}

	private void SaveDatajButtonMouseEntered(java.awt.event.MouseEvent evt) {
		new UIFunc().showMessage(evt.getXOnScreen() + 10,
				evt.getYOnScreen() + 10, 200, 100,
				"保存所有设置的数据。<br/>保存后下次打开时直接载入，无需重新再填写!<br/>");
	}

	private void SaveDatajButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message().showConfirmDialog("确定要保存数据？") == ConfirmationCallback.YES) {
			try {
				File file = new action.File();

				file.saoHuoGroceriesSave();
				file.saoHuoStoneSave();
				file.saoHuoPetSave();
				file.saoHuoFengWuZhiSave();
				file.saoHuoLegendSave();
				file.saoHuoElseClassSave();
				file.UISave();

				new Func.Message().showMessageDialog("保存成功");
				file = null;
			} catch (Exception e) {
				new Func.Message().showMessageDialog("执行失败");
			}
		}
	}

	private void setParamjButtonActionPerformed(java.awt.event.ActionEvent evt) {
		switch (Command.JForm.daGuaiModeljComboBox.getSelectedIndex()) {
		case 2: //为2，为打怪模式，设定自定义挂机点
			new UIFunc().setCustomDaGuaiPlace();
			break;
		case 4:
			Command.JframeSaoHuo.setVisible(true);
			break;
		case 5:
			new action.Skill().setVisible();
			break;
		case 7: //高级打怪模式
			Command.JframeSeniorFight.setVisible(true);
			break;
		default:
			break;
		}
	}

	private void daGuaiMapjComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
		new UIFunc().daguaiItemIsChange_UI();
	}

	private void keyjLabelMouseClicked(java.awt.event.MouseEvent evt) {
		new UIFunc().test();
	}

	private void setHwndjLabelMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void explainjLabelMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void explainjLabelMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void setHwndjLabelVetoableChange(java.beans.PropertyChangeEvent evt)
			throws java.beans.PropertyVetoException {
		Command.JForm.setHwndjLabel.setSize(300, 17);
	}

	private void seeJiNengjButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Profession.seeJiNengUI();
	}

	private void runEndjButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Init.runEnd();
	}

	private void runStartjButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Init.startInit();
	}

	private void registerCodeButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		new action.Command_Register().start();
	}

	private void daGuaiModeljComboBoxItemStateChanged(
			java.awt.event.ItemEvent evt) {
		new UIFunc().daguaiModelIsChange_UI();
	}

	private void getHwndjButtonActionPerformed(java.awt.event.ActionEvent evt) {
		action.SetHwnd.setHwnd();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	public static javax.swing.JButton SaveDatajButton;
	public static javax.swing.JComboBox daGuaiMapjComboBox;
	public static javax.swing.JComboBox daGuaiModeljComboBox;
	public static javax.swing.JComboBox delayjComboBox;
	public static javax.swing.JLabel explainjLabel;
	public static javax.swing.JButton getHwndjButton;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	public static javax.swing.JCheckBox jCheckBoxUseOptimizeCpu;
	public static javax.swing.JComboBox jComboBoxErrorXueStart;
	public static javax.swing.JComboBox jComboBoxOptimize;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem10;
	private javax.swing.JMenuItem jMenuItem11;
	private javax.swing.JMenuItem jMenuItem12;
	private javax.swing.JMenuItem jMenuItem13;
	private javax.swing.JMenuItem jMenuItem14;
	private javax.swing.JMenuItem jMenuItem15;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JMenuItem jMenuItem9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	public static javax.swing.JTabbedPane jTabbedPane;
	public static javax.swing.JTextField jTextFieldMyOverTime;
	private javax.swing.JLabel keyjLabel;
	public static javax.swing.JTextArea logTextArea;
	public static javax.swing.JLabel myInfojLabel;
	public static javax.swing.JComboBox professionjComboBox;
	public static javax.swing.JTextField registerCode;
	public static javax.swing.JButton registerCodeButton;
	public static javax.swing.JTextField roleNamejTextField;
	public static javax.swing.JButton runEndjButton;
	public static javax.swing.JButton runStartjButton;
	public static javax.swing.JButton seeJiNengjButton;
	public static javax.swing.JLabel setHwndjLabel;
	public static javax.swing.JTextField setMailjTextField;
	public static javax.swing.JButton setParamjButton;
	// End of variables declaration//GEN-END:variables

}