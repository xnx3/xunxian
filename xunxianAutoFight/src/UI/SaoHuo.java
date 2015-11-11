/*
 * SaoHuo.java
 *
 * Created on __DATE__, __TIME__
 */

package UI;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import action.SaoHuoFunc;
import Func.Lang;
import include.Command;

/**
 *
 * @author  __USER__
 */
public class SaoHuo extends javax.swing.JFrame {

	/** Creates new form SaoHuo */
	public SaoHuo() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTabbedPane = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jPanel6 = new javax.swing.JPanel();
		jButton5 = new javax.swing.JButton();
		jTextFieldSearch = new javax.swing.JTextField();
		jButton6 = new javax.swing.JButton();
		jPanel10 = new javax.swing.JPanel();
		saoHuoOneTongjCheckBox = new javax.swing.JCheckBox();
		saoHuoGroceriesjCheckBox = new javax.swing.JCheckBox();
		saoHuoStonejCheckBox = new javax.swing.JCheckBox();
		saoHuoPetjCheckBox = new javax.swing.JCheckBox();
		saoHuoFengWuZhijCheckBox = new javax.swing.JCheckBox();
		saoHuoLegendjCheckBox = new javax.swing.JCheckBox();
		saoHuoQiangLiJuejCheckBox = new javax.swing.JCheckBox();
		saoHuoTongShenJuejCheckBox = new javax.swing.JCheckBox();
		saoHuoZhanHunjCheckBox = new javax.swing.JCheckBox();
		jPanel5 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		stonejTable = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		petjTable = new javax.swing.JTable();
		jScrollPane4 = new javax.swing.JScrollPane();
		fengWuZhijTable = new javax.swing.JTable();
		jPanel7 = new javax.swing.JPanel();
		jScrollPane5 = new javax.swing.JScrollPane();
		legendjTable = new javax.swing.JTable();
		jPanel8 = new javax.swing.JPanel();
		jScrollPane6 = new javax.swing.JScrollPane();
		groceriesjTable = new javax.swing.JTable();
		jPanel9 = new javax.swing.JPanel();
		jScrollPane7 = new javax.swing.JScrollPane();
		elseClassjTable = new javax.swing.JTable();

		jPanel6
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("\u5feb\u901f\u641c\u7d22\u67d0\u4ef6\u7269\u54c1\u5b9a\u4f4d"));

		jButton5.setText("\u641c\u7d22");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("\u8bf4\u660e");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
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
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel6Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jTextFieldSearch,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												395, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												81,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												90,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel6Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButton6).addComponent(jButton5)
						.addComponent(jTextFieldSearch,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		jPanel10
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("\u5bf9\u54ea\u4e9b\u7269\u54c1\u5f00\u542f\u626b\u63cf"));

		saoHuoOneTongjCheckBox.setText("1\u94dc\u7269\u54c1");

		saoHuoGroceriesjCheckBox.setSelected(true);
		saoHuoGroceriesjCheckBox.setText("\u6742\u8d27\u7c7b");

		saoHuoStonejCheckBox.setText("\u516b\u5366\u7075\u77f3\u7c7b");
		saoHuoStonejCheckBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saoHuoStonejCheckBoxActionPerformed(evt);
					}
				});

		saoHuoPetjCheckBox.setText("\u5ba0\u7269\u58f3\u5b50");

		saoHuoFengWuZhijCheckBox.setText("\u98ce\u7269\u5fd7");

		saoHuoLegendjCheckBox.setText("\u4f20\u5947\u914d\u65b9");
		saoHuoLegendjCheckBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saoHuoLegendjCheckBoxActionPerformed(evt);
					}
				});

		saoHuoQiangLiJuejCheckBox.setText("\u5f3a\u529b\u8bc0");

		saoHuoTongShenJuejCheckBox.setText("\u901a\u795e\u8bc0");

		saoHuoZhanHunjCheckBox.setText("\u6218\u9b42\u6c34\u6676");
		saoHuoZhanHunjCheckBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saoHuoZhanHunjCheckBoxActionPerformed(evt);
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
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																saoHuoOneTongjCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																110,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel10Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel10Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								saoHuoQiangLiJuejCheckBox,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								103,
																								Short.MAX_VALUE)
																						.addComponent(
																								saoHuoStonejCheckBox,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel10Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								saoHuoTongShenJuejCheckBox,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								saoHuoPetjCheckBox,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								104,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel10Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								saoHuoZhanHunjCheckBox,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								saoHuoFengWuZhijCheckBox,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								104,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				saoHuoLegendjCheckBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				107,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				saoHuoGroceriesjCheckBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				95,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				270,
																				270,
																				270)))));
		jPanel10Layout
				.setVerticalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addComponent(
												saoHuoOneTongjCheckBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																saoHuoStonejCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saoHuoPetjCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saoHuoFengWuZhijCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saoHuoLegendjCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																21,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saoHuoGroceriesjCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																saoHuoQiangLiJuejCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																21,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saoHuoTongShenJuejCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																21,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																saoHuoZhanHunjCheckBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																21,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		jPanel5
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("\u5feb\u901f\u8bbe\u7f6e\u6b64\u7c7b\u7684\u6240\u6709\u7269\u54c1\u4e3a2\u94dc(\u4ece\u800c\u8fbe\u5230\u64a4\u9500\u5bf9\u6b64\u7269\u54c1\u626b\u63cf\u7684\u76ee\u7684)"));

		jButton1.setText("\u6742\u8d27");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u516b\u5366\u7075\u77f3");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u5ba0\u7269\u58f3\u5b50");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("\u98ce\u7269\u5fd7");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton7.setText("\u4f20\u5947\u914d\u65b9");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setText("\u5176\u4ed6\u7c7b\u522b");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

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
										.addComponent(jButton2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												92,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton7)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												90,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton8,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).addGap(15, 15,
												15)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButton2).addComponent(jButton3)
						.addComponent(jButton4).addComponent(jButton7)
						.addComponent(jButton1).addComponent(jButton8)));

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
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jPanel5,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(
																				jPanel6,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jPanel10,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				623,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(27, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jPanel10,
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
										.addGap(45, 45, 45)
										.addComponent(
												jPanel6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(24, Short.MAX_VALUE)));

		jTabbedPane.addTab("\u57fa\u7840\u8bbe\u7f6e", jPanel1);

		stonejTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "物品名", "购买价格", "编辑价格(单位:铜)" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		stonejTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				stonejTableKeyReleased(evt);
			}
		});
		jScrollPane2.setViewportView(stonejTable);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302,
				Short.MAX_VALUE));

		jTabbedPane.addTab("\u516b\u5366\u7075\u77f3", jPanel2);

		petjTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "物品名", "购买价格", "编辑价格(单位:铜)" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		petjTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				petjTableKeyReleased(evt);
			}
		});
		jScrollPane3.setViewportView(petjTable);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 302,
				Short.MAX_VALUE));

		jTabbedPane.addTab("\u5ba0\u7269\u58f3\u5b50", jPanel3);

		fengWuZhijTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "物品名", "购买价格", "编辑价格(单位:铜)" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		fengWuZhijTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				fengWuZhijTableKeyReleased(evt);
			}
		});
		jScrollPane4.setViewportView(fengWuZhijTable);

		jTabbedPane.addTab("\u98ce\u7269\u5fd7", jScrollPane4);

		legendjTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "物品名", "购买价格", "编辑价格(单位:铜)" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		legendjTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				legendjTableKeyReleased(evt);
			}
		});
		jScrollPane5.setViewportView(legendjTable);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 653,
				Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 302,
				Short.MAX_VALUE));

		jTabbedPane.addTab("\u4f20\u5947\u914d\u65b9", jPanel7);

		groceriesjTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "物品名", "购买价格", "编辑价格(单位:铜)" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		groceriesjTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				groceriesjTableKeyReleased(evt);
			}
		});
		jScrollPane6.setViewportView(groceriesjTable);

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 653,
				Short.MAX_VALUE));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 302,
				Short.MAX_VALUE));

		jTabbedPane.addTab("\u6742\u8d27", jPanel8);

		elseClassjTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "物品名", "购买价格", "编辑价格(单位:铜)" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		elseClassjTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				elseClassjTableKeyReleased(evt);
			}
		});
		jScrollPane7.setViewportView(elseClassjTable);

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(
				jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 653,
				Short.MAX_VALUE));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 302,
				Short.MAX_VALUE));

		jTabbedPane.addTab("\u5176\u4ed6\u7c7b\u522b", jPanel9);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 658,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void saoHuoLegendjCheckBox7ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saoHuoLegendjCheckBox6ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saoHuoLegendjCheckBox5ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saoHuoLegendjCheckBox4ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saoHuoStonejCheckBox1ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saoHuoZhanHunjCheckBoxActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saoHuoLegendjCheckBox2ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saoHuoLegendjCheckBox1ActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void elseClassjTableKeyReleased(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == evt.VK_ENTER) {
			int row = Command.JframeSaoHuo.elseClassjTable.getSelectedRow();
			Lang lang = new Func.Lang();
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			//			
			//			
			TableModel model = (TableModel) Command.JframeSaoHuo.elseClassjTable
					.getModel();
			String now = model.getValueAt(row, 2).toString();
			model.setValueAt(saoHuoFunc.moneyToString(lang.Integer_(now, 2)),
					row, 1);

			saoHuoFunc = null;
			lang = null;
			model = null;
		}
	}

	private void groceriesjTableKeyReleased(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == evt.VK_ENTER) {
			int row = Command.JframeSaoHuo.groceriesjTable.getSelectedRow();
			Lang lang = new Func.Lang();
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			//			
			//			
			TableModel model = (TableModel) Command.JframeSaoHuo.groceriesjTable
					.getModel();
			String now = model.getValueAt(row, 2).toString();
			model.setValueAt(saoHuoFunc.moneyToString(lang.Integer_(now, 2)),
					row, 1);

			saoHuoFunc = null;
			lang = null;
			model = null;
		}

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("设置宠物壳子所有物品的价格为2铜之内自动买进。<br/>注意：设置后原本配置的数据会都变成2铜<br/>确定要进行快速设置？") == ConfirmationCallback.YES) {
			int money = 2;
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			TableModel model = (TableModel) Command.JframeSaoHuo.stonejTable
					.getModel();
			for (int row = model.getRowCount() - 1; row >= 0; row--) {
				model.setValueAt(money, row, 2);
				model.setValueAt(saoHuoFunc.moneyToString(money), row, 1);

			}

			saoHuoFunc = null;
			model = null;
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("设置宠物壳子所有物品的价格为2铜之内自动买进。<br/>注意：设置后原本配置的数据会都变成2铜<br/>确定要进行快速设置？") == ConfirmationCallback.YES) {
			int money = 2;
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			TableModel model = (TableModel) Command.JframeSaoHuo.petjTable
					.getModel();
			for (int row = model.getRowCount() - 1; row >= 0; row--) {
				model.setValueAt(money, row, 2);
				model.setValueAt(saoHuoFunc.moneyToString(money), row, 1);

			}

			saoHuoFunc = null;
			model = null;
		}
	}

	private void legendjTable1KeyReleased(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("设置其他分类里面所有物品的价格为2铜之内自动买进。<br/>注意：设置后原本配置的数据会都变成2铜<br/>确定要进行快速设置？") == ConfirmationCallback.YES) {
			int money = 2;
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			TableModel model = (TableModel) Command.JframeSaoHuo.elseClassjTable
					.getModel();
			for (int row = model.getRowCount() - 1; row >= 0; row--) {
				model.setValueAt(money, row, 2);
				model.setValueAt(saoHuoFunc.moneyToString(money), row, 1);

			}

			saoHuoFunc = null;
			model = null;
		}
	}

	private void saoHuoLegendjCheckBoxActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("设置传奇图纸所有物品的价格为2铜之内自动买进。<br/>注意：设置后原本配置的数据会都变成2铜<br/>确定要进行快速设置？") == ConfirmationCallback.YES) {
			int money = 2;
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			TableModel model = (TableModel) Command.JframeSaoHuo.legendjTable
					.getModel();
			for (int row = model.getRowCount() - 1; row >= 0; row--) {
				model.setValueAt(money, row, 2);
				model.setValueAt(saoHuoFunc.moneyToString(money), row, 1);

			}

			saoHuoFunc = null;
			model = null;
		}
	}

	private void legendjTableKeyReleased(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == evt.VK_ENTER) {
			int row = Command.JframeSaoHuo.legendjTable.getSelectedRow();
			Lang lang = new Func.Lang();
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			//			
			//			
			TableModel model = (TableModel) Command.JframeSaoHuo.legendjTable
					.getModel();
			String now = model.getValueAt(row, 2).toString();
			model.setValueAt(saoHuoFunc.moneyToString(lang.Integer_(now, 2)),
					row, 1);

			saoHuoFunc = null;
			lang = null;
			model = null;
		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		new Func.Message().showMessageDialog("输入某种物品，进行快速搜索定位<br/>"
				+ "自动从所有杂货、八卦灵石、宠物、风物志、传奇配方……中进行搜索");
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		new action.UIFunc().saoHuoSearch();
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("设置风物志类所有物品的价格为2铜之内自动买进。<br/>注意：设置后原本配置的数据会都变成2铜<br/>确定要进行快速设置？") == ConfirmationCallback.YES) {
			int money = 2;
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			TableModel model = (TableModel) Command.JframeSaoHuo.fengWuZhijTable
					.getModel();
			for (int row = model.getRowCount() - 1; row >= 0; row--) {
				model.setValueAt(money, row, 2);
				model.setValueAt(saoHuoFunc.moneyToString(money), row, 1);

			}

			saoHuoFunc = null;
			model = null;
		}
	}

	private void fengWuZhijTableKeyReleased(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == evt.VK_ENTER) {
			int row = Command.JframeSaoHuo.fengWuZhijTable.getSelectedRow();
			Lang lang = new Func.Lang();
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			//			
			//			
			TableModel model = (TableModel) Command.JframeSaoHuo.fengWuZhijTable
					.getModel();
			String now = model.getValueAt(row, 2).toString();
			model.setValueAt(saoHuoFunc.moneyToString(lang.Integer_(now, 2)),
					row, 1);

			saoHuoFunc = null;
			lang = null;
			model = null;
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (new Func.Message()
				.showConfirmDialog("设置杂货类所有物品的价格为2铜之内自动买进。<br/>注意：设置后原本配置的数据会都变成2铜<br/>确定要进行快速设置？") == ConfirmationCallback.YES) {
			int money = 2;
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			TableModel model = (TableModel) Command.JframeSaoHuo.groceriesjTable
					.getModel();
			for (int row = model.getRowCount() - 1; row >= 0; row--) {
				model.setValueAt(money, row, 2);
				model.setValueAt(saoHuoFunc.moneyToString(money), row, 1);

			}

			saoHuoFunc = null;
			model = null;
		}
	}

	private void saoHuoStonejCheckBoxActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void petjTableKeyReleased(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == evt.VK_ENTER) {
			int row = Command.JframeSaoHuo.petjTable.getSelectedRow();
			Lang lang = new Func.Lang();
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			//			
			//			
			TableModel model = (TableModel) Command.JframeSaoHuo.petjTable
					.getModel();
			String now = model.getValueAt(row, 2).toString();
			model.setValueAt(saoHuoFunc.moneyToString(lang.Integer_(now, 2)),
					row, 1);

			saoHuoFunc = null;
			lang = null;
			model = null;
		}
	}

	private void stonejTableKeyReleased(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == evt.VK_ENTER) {
			int row = Command.JframeSaoHuo.stonejTable.getSelectedRow();
			Lang lang = new Func.Lang();
			SaoHuoFunc saoHuoFunc = new SaoHuoFunc();
			//			
			//			
			TableModel model = (TableModel) Command.JframeSaoHuo.stonejTable
					.getModel();
			String now = model.getValueAt(row, 2).toString();
			model.setValueAt(saoHuoFunc.moneyToString(lang.Integer_(now, 2)),
					row, 1);

			saoHuoFunc = null;
			lang = null;
			model = null;
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SaoHuo().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	public static javax.swing.JTable elseClassjTable;
	public static javax.swing.JTable fengWuZhijTable;
	public static javax.swing.JTable groceriesjTable;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	public static javax.swing.JTabbedPane jTabbedPane;
	public static javax.swing.JTextField jTextFieldSearch;
	public static javax.swing.JTable legendjTable;
	public static javax.swing.JTable petjTable;
	public static javax.swing.JCheckBox saoHuoFengWuZhijCheckBox;
	public static javax.swing.JCheckBox saoHuoGroceriesjCheckBox;
	public static javax.swing.JCheckBox saoHuoLegendjCheckBox;
	public static javax.swing.JCheckBox saoHuoOneTongjCheckBox;
	public static javax.swing.JCheckBox saoHuoPetjCheckBox;
	public static javax.swing.JCheckBox saoHuoQiangLiJuejCheckBox;
	public static javax.swing.JCheckBox saoHuoStonejCheckBox;
	public static javax.swing.JCheckBox saoHuoTongShenJuejCheckBox;
	public static javax.swing.JCheckBox saoHuoZhanHunjCheckBox;
	public static javax.swing.JTable stonejTable;
	// End of variables declaration//GEN-END:variables

}