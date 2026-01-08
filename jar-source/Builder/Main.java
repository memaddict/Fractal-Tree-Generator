/*    */ package Builder;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class Main extends JFrame {
/*    */   static Main fNook;
/*    */   static wMenu jMenu;
/*    */   static wOptions jOptions;
/*    */   static wBG jHelp;
/*    */   static wBG2 jAbout;
/*    */   static wGibson jEexposition;
/*    */   
/*    */   public Main(String st) {
/* 16 */     super(st);
/* 17 */     addNotify();
/* 18 */     setSize(1024, 760);
/* 19 */     setDefaultCloseOperation(3);
/* 20 */     setResizable(false);
/* 21 */     setLocationRelativeTo((Component)null);
/* 22 */     jEexposition = new wGibson(true);
/* 23 */     jMenu = new wMenu();
/* 24 */     jOptions = new wOptions();
/* 25 */     jHelp = new wBG("textures/tHelp.png");
/* 26 */     jAbout = new wBG2("textures/tAbout.png");
/* 27 */     add(jMenu);
/* 28 */     setVisible(true);
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 32 */     fNook = new Main("Tree Generator Extreme");
/*    */   }
/*    */   
/*    */   public void Switch(int xCase) {
/* 36 */     switch (xCase) {
/*    */       case 0:
/* 38 */         remove(jEexposition);
/* 39 */         remove(jHelp);
/* 40 */         remove(jAbout);
/* 41 */         remove(jOptions);
/* 42 */         add(jMenu);
/*    */         break;
/*    */       case 1:
/* 45 */         remove(jEexposition);
/* 46 */         remove(jHelp);
/* 47 */         remove(jMenu);
/* 48 */         remove(jAbout);
/* 49 */         add(jOptions);
/*    */         break;
/*    */       case 2:
/* 52 */         remove(jEexposition);
/* 53 */         remove(jMenu);
/* 54 */         remove(jAbout);
/* 55 */         remove(jOptions);
/* 56 */         add(jHelp);
/*    */         break;
/*    */       case 3:
/* 59 */         remove(jEexposition);
/* 60 */         remove(jHelp);
/* 61 */         remove(jMenu);
/* 62 */         remove(jOptions);
/* 63 */         add(jAbout);
/*    */         break;
/*    */     } 
/* 66 */     validate();
/* 67 */     repaint();
/*    */   }
/*    */   public void Generate(int iterationNum, double brMin, double brMax, double bhMin, double bhMax, int degreeMin, int degreeMax, Color branchLeft, Color branchRight, Color leafLeft, Color leafRight) {
/* 70 */     remove(jMenu);
/* 71 */     remove(jHelp);
/* 72 */     remove(jAbout);
/* 73 */     remove(jOptions);
/* 74 */     jEexposition = new wGibson(iterationNum, brMin, brMax, bhMin, bhMax, degreeMin, degreeMax, branchLeft, branchRight, leafLeft, leafRight);
/* 75 */     add(jEexposition);
/* 76 */     jEexposition.requestFocus();
/* 77 */     validate();
/* 78 */     repaint();
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Builder\Main.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */