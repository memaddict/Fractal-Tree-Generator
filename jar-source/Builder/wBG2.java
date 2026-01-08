/*    */ package Builder;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class wBG2 extends JPanel implements ActionListener {
/*    */   private static Image wBackground;
/*    */   private static iJButton bBack;
/*    */   
/*    */   public wBG2(String wBG) {
/* 16 */     setLayout((LayoutManager)null);
/* 17 */     wBackground = (new ImageIcon(wBG)).getImage();
/* 18 */     bBack = new iJButton(50, 645, "textures/oButtons/5.png");
/* 19 */     bBack.addActionListener(this);
/* 20 */     add(bBack);
/*    */   }
/*    */   public void paintComponent(Graphics g) {
/* 23 */     g.drawImage(wBackground, 0, 0, getWidth(), getHeight(), this);
/* 24 */     bBack.repaint();
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 28 */     Main.fNook.Switch(0);
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Builder\wBG2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */