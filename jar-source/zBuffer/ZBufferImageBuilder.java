/*    */ package zBuffer;
/*    */ 
/*    */ import Engie3D.ImageBuilder;
/*    */ import Engie3D.Solid;
/*    */ import Engie3D.Triangle;
/*    */ import Engie3D.Vector;
/*    */ import java.awt.Image;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZBufferImageBuilder
/*    */   implements ImageBuilder
/*    */ {
/*    */   private int width;
/*    */   private int height;
/*    */   private BufferedImage image;
/* 24 */   private ZBuffer xBuffer = new ZBuffer();
/*    */   
/*    */   private Solid solid;
/*    */   
/*    */   public void init(Solid solid, Vector sun, int width, int height) {
/* 29 */     this.solid = solid;
/* 30 */     this.sun = sun;
/* 31 */     this.width = width;
/* 32 */     this.height = height;
/* 33 */     this.xBuffer.init(width, height);
/* 34 */     this.image = new BufferedImage(width, height, 2);
/* 35 */     this.zBufferAction = new ZBufferAction(solid, this.xBuffer, this.image, sun);
/*    */   }
/*    */   
/*    */   private Vector sun;
/*    */   private ZBufferAction zBufferAction;
/*    */   
/*    */   public void add(Triangle triangle) {
/* 42 */     TriangleProjectionYZ proj = new TriangleProjectionYZ(triangle, this.width, this.height);
/* 43 */     this.zBufferAction.setTriangle(triangle);
/* 44 */     proj.forEach(this.zBufferAction);
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getResult() {
/* 49 */     return this.image;
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\zBuffer\ZBufferImageBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */