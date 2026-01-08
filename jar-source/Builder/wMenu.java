/*    */ package Builder;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class wMenu extends JPanel implements ActionListener {
/*    */   private static iJButton b1;
/* 14 */   private static Image mBackground = (new ImageIcon("textures/mBackground.png")).getImage(); private static iJButton b2; private static iJButton b3;
/*    */   private static iJButton b4;
/*    */   
/*    */   public wMenu() {
/* 18 */     setLayout((LayoutManager)null);
/* 19 */     b1 = new iJButton(590, 200, "textures/mButtons/mOptions.png");
/* 20 */     b2 = new iJButton(830, 330, "textures/mButtons/mHelp.png");
/* 21 */     b3 = new iJButton(830, 390, "textures/mButtons/mAbout.png");
/* 22 */     b4 = new iJButton(830, 450, "textures/mButtons/mExit.png");
/* 23 */     b3.addActionListener(this); b2.addActionListener(this);
/* 24 */     b4.addActionListener(this); b1.addActionListener(this);
/* 25 */     add(b1); add(b4); add(b3); add(b2);
/*    */   }
/*    */   
/*    */   public void paintComponent(Graphics g) {
/* 29 */     g.drawImage(mBackground, 0, 0, getWidth(), getHeight(), this);
/* 30 */     b1.repaint();
/* 31 */     b2.repaint();
/* 32 */     b3.repaint();
/* 33 */     b4.repaint();
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 37 */     JButton bCase = (JButton)e.getSource();
/* 38 */     if (bCase.equals(b1)) {
/* 39 */       Main.fNook.Switch(1);
/* 40 */       b1.setFocusable(false);
/*    */     } 
/* 42 */     if (bCase.equals(b2)) {
/* 43 */       Main.fNook.Switch(2);
/* 44 */       b2.setFocusable(false);
/*    */     } 
/* 46 */     if (bCase.equals(b3)) {
/* 47 */       Main.fNook.Switch(3);
/* 48 */       b3.setFocusable(false);
/*    */     } 
/* 50 */     if (bCase.equals(b4)) {
/* 51 */       System.exit(0);
/* 52 */       b4.setFocusable(false);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Builder\wMenu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */