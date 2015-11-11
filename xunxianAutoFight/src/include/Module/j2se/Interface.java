package include.Module.j2se;

import include.Command;
import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import javax.swing.ImageIcon;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Interface {
	public Cursor cursor(String cursor_path){
		Image xnx3_cursor_image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/pointer.png"));
		Cursor xnx3_cursor = Toolkit.getDefaultToolkit().createCustomCursor(xnx3_cursor_image, new Point(1, 1), "pointer.png");
		
		return xnx3_cursor;
	}

	public Image ico(){
		Image xnx3_img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/ico.png"));
		return xnx3_img;
	}

	
	/** 
     * 创建系统托盘的对象 步骤:  
     * 1,获得当前操作系统的托盘对象  
     * 2,创建弹出菜单popupMenu  
     * 3,创建托盘图标icon 
     * 4,创建系统的托盘对象trayIcon 
     */  
    public void createTrayIcon() {  
    	TrayIcon trayIcon=null;
    	SystemTray sysTray= SystemTray.getSystemTray();// 获得当前操作系统的托盘对象  
    	ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/tray.png")));	//托盘图标
        PopupMenu popupMenu = new PopupMenu();// 弹出菜单  
        MenuItem showUI = new MenuItem("show");  
//        MenuItem activeItem = new MenuItem("exit");  
        popupMenu.add(showUI);  
//        popupMenu.add(activeItem);  
        // 为弹出菜单项添加事件  
        showUI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Command.JForm.setVisible(true);		//显示窗口
				Command.JForm.toFront();			//显示窗口到最前端
				
			}
		});
//        activeItem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(Command.mainThread){
//					Init.runEnd();
//				}else{
//					Init.startInit();
//				}
//			}
//		});
        trayIcon=new TrayIcon(icon.getImage(), Command.title, popupMenu);
        /** 添加鼠标监听器，当鼠标在托盘图标上双击时，默认显示窗口 */  
        trayIcon.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Command.tray){
					Command.JForm.setVisible(true);
					Command.tray=false;
				}else{
					Command.JForm.setVisible(false);
					Command.tray=true;
				}
			}
		});
        
        try {
			sysTray.add(trayIcon);		//将托盘添加到操作系统的托盘  
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }  
}
