/*    */ package Builder;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.border.Border;
/*    */ 
/*    */ class iJButton extends JButton {
/*    */   public iJButton(int x, int y, String sImage) {
/*  9 */     setIcon(new ImageIcon(sImage));
/* 10 */     if ((new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_t" + sImage.substring(sImage.length() - 4, sImage.length()))).getImage().getWidth(this) != -1)
/* 11 */       setPressedIcon(new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_t" + sImage.substring(sImage.length() - 4, sImage.length()))); 
/* 12 */     if ((new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_o" + sImage.substring(sImage.length() - 4, sImage.length()))).getImage().getWidth(this) != -1)
/* 13 */       setRolloverIcon(new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_o" + sImage.substring(sImage.length() - 4, sImage.length()))); 
/* 14 */     setContentAreaFilled(false);
/* 15 */     setBorder((Border)null);
/* 16 */     setFocusable(false);
/* 17 */     setOpaque(false);
/* 18 */     setFocusPainted(false);
/* 19 */     setBounds(x, y, (new ImageIcon(sImage)).getIconWidth(), (new ImageIcon(sImage)).getIconHeight());
/*    */   }
/*    */   public iJButton(String sImage) {
/* 22 */     setIcon(new ImageIcon(sImage));
/* 23 */     if ((new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_t" + sImage.substring(sImage.length() - 4, sImage.length()))).getImage().getWidth(this) != -1)
/* 24 */       setPressedIcon(new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_t" + sImage.substring(sImage.length() - 4, sImage.length()))); 
/* 25 */     if ((new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_o" + sImage.substring(sImage.length() - 4, sImage.length()))).getImage().getWidth(this) != -1)
/* 26 */       setRolloverIcon(new ImageIcon(sImage.substring(0, sImage.length() - 4) + "_o" + sImage.substring(sImage.length() - 4, sImage.length()))); 
/* 27 */     setContentAreaFilled(false);
/* 28 */     setBorder((Border)null);
/* 29 */     setFocusable(false);
/* 30 */     setOpaque(false);
/* 31 */     setFocusPainted(false);
/* 32 */     setSize((new ImageIcon(sImage)).getIconWidth(), (new ImageIcon(sImage)).getIconHeight());
/*    */   }
/*    */   public void changeImage(String nsImage) {
/* 35 */     setIcon(new ImageIcon(nsImage));
/* 36 */     if ((new ImageIcon(nsImage.substring(0, nsImage.length() - 4) + "_t" + nsImage.substring(nsImage.length() - 4, nsImage.length()))).getImage().getWidth(this) != -1)
/* 37 */       setPressedIcon(new ImageIcon(nsImage.substring(0, nsImage.length() - 4) + "_t" + nsImage.substring(nsImage.length() - 4, nsImage.length()))); 
/* 38 */     if ((new ImageIcon(nsImage.substring(0, nsImage.length() - 4) + "_o" + nsImage.substring(nsImage.length() - 4, nsImage.length()))).getImage().getWidth(this) != -1)
/* 39 */       setRolloverIcon(new ImageIcon(nsImage.substring(0, nsImage.length() - 4) + "_o" + nsImage.substring(nsImage.length() - 4, nsImage.length()))); 
/* 40 */     setSize((new ImageIcon(nsImage)).getIconWidth(), (new ImageIcon(nsImage)).getIconHeight());
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Builder\iJButton.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */