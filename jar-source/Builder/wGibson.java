/*     */ package Builder;
/*     */ import Engie3D.Drawer;
/*     */ import Engie3D.ImageBuilder;
/*     */ import Engie3D.Transform;
/*     */ import Engie3D.Vector;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseWheelEvent;
/*     */ import zBuffer.ZBufferImageBuilder;
/*     */ 
/*     */ public class wGibson extends JPanel implements MouseListener, KeyListener, MouseWheelListener {
/*     */   private static Drawer drawer;
/*     */   private static Image image;
/*     */   double tRmin;
/*     */   double tRmax;
/*     */   double tHmin;
/*     */   double tHmax;
/*  21 */   private static Image gBackground = (new ImageIcon("textures/gBackground.png")).getImage(); int tIN; int tDmin; int tDmax; Color tBL; Color tBR; Color tLL; Color tLR;
/*  22 */   double treeSize = 0.5D;
/*  23 */   double rotationAngle = -0.5235987755982988D;
/*     */   int iterationsNum;
/*     */   
/*     */   public wGibson(int iterationNum, double brMin, double brMax, double bhMin, double bhMax, int degreeMin, int degreeMax, Color branchLeft, Color branchRight, Color leafLeft, Color leafRight) {
/*  27 */     this.tIN = iterationNum; this.tBL = branchLeft; this.tBR = branchRight; this.tLL = leafLeft; this.tLR = leafRight;
/*  28 */     this.tRmin = brMin; this.tRmax = brMax; this.tHmin = bhMin; this.tHmax = bhMax; this.tDmin = degreeMin; this.tDmax = degreeMax;
/*  29 */     drawer = new Drawer(new Tree(this.tIN, this.tRmin, this.tRmax, this.tHmin, this.tHmax, this.tDmin, this.tDmax, this.tBL, this.tBR, this.tLL, this.tLR), (ImageBuilder)new ZBufferImageBuilder());
/*  30 */     image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     setSize((getInsets()).left + (getInsets()).right + 1024, (getInsets()).top + (getInsets()).bottom + 780);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  41 */     addMouseListener(this);
/*  42 */     addMouseWheelListener(this);
/*  43 */     addKeyListener(this);
/*  44 */     setFocusable(true);
/*     */   }
/*     */   public void paintComponent(Graphics g) {
/*  47 */     super.paintComponent(g);
/*  48 */     Graphics2D G = (Graphics2D)g;
/*  49 */     g.drawImage(gBackground, 0, 0, 1024, 780, this);
/*  50 */     G.drawImage(image, 0, 0, 1024, 780, null);
/*     */   }
/*     */   public void mouseClicked(MouseEvent e) {
/*  53 */     if (e.getModifiers() == 4) Main.fNook.Switch(1); 
/*  54 */     if (e.getModifiers() == 8) {
/*  55 */       drawer = new Drawer(new Tree(this.tIN, this.tRmin, this.tRmax, this.tHmin, this.tHmax, this.tDmin, this.tDmax, this.tBL, this.tBR, this.tLL, this.tLR), (ImageBuilder)new ZBufferImageBuilder());
/*  56 */       image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  61 */     if (e.getModifiers() == 16) {
/*  62 */       if (e.getX() > 390) { this.rotationAngle += 0.2D; } else { this.rotationAngle -= 0.2D; }
/*  63 */        image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     repaint();
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/*  73 */     int ArrowButton = e.getKeyCode();
/*  74 */     switch (ArrowButton) { case 37:
/*  75 */         this.rotationAngle -= 0.2D; image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 39:
/*  80 */         this.rotationAngle += 0.2D; image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 38:
/*  85 */         this.treeSize += 0.02D; image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 40:
/*  90 */         this.treeSize -= 0.02D; image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 32:
/*  95 */         drawer = new Drawer(new Tree(this.tIN, this.tRmin, this.tRmax, this.tHmin, this.tHmax, this.tDmin, this.tDmax, this.tBL, this.tBR, this.tLL, this.tLR), (ImageBuilder)new ZBufferImageBuilder());
/*  96 */         image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 27:
/* 101 */         Main.fNook.Switch(1);
/*     */         break; }
/*     */     
/* 104 */     repaint();
/*     */   }
/*     */   
/*     */   public void mouseWheelMoved(MouseWheelEvent e) {
/* 108 */     if (e.getWheelRotation() > 0) { this.treeSize -= 0.02D; } else { this.treeSize += 0.02D; }
/* 109 */      image = drawer.draw(1024, 780, new Vector(-1.0D, 1.0D, 1.5D), Transform.createScale(1.0D, 1.0D, -1.0D).composite(Transform.createRotateZ(this.rotationAngle).composite(Transform.createScale(this.treeSize).composite(Transform.createTranslate(0.0D, 512.0D, 680.0D)))));
/*     */ 
/*     */ 
/*     */     
/* 113 */     repaint();
/*     */   }
/*     */   
/*     */   public wGibson(boolean Abstract) {}
/*     */   
/*     */   public void keyReleased(KeyEvent e) {}
/*     */   
/*     */   public void mousePressed(MouseEvent e) {}
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {}
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Builder\wGibson.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */