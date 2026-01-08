/*    */ package zBuffer;
/*    */ 
/*    */ import Engie3D.Solid;
/*    */ import Engie3D.Triangle;
/*    */ import Engie3D.Vector;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class ZBufferAction implements Action {
/*    */   private ZBuffer buffer;
/*    */   private BufferedImage image;
/*    */   private Triangle triangle;
/*    */   private Solid solid;
/*    */   private Vector sun;
/*    */   
/*    */   public ZBufferAction(Solid solid, ZBuffer buffer, BufferedImage image, Vector sun) {
/* 16 */     this.buffer = buffer;
/* 17 */     this.image = image;
/* 18 */     this.solid = solid;
/* 19 */     this.sun = sun;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTriangle(Triangle triangle) {
/* 24 */     this.triangle = triangle;
/*    */   }
/*    */ 
/*    */   
/*    */   private int getXFromYZ(Triangle triangle, int x, int y) {
/* 29 */     Vector n = triangle.getNormal();
/* 30 */     if (n.getX() != 0.0D) {
/* 31 */       return (int)Math.round((-n.getY() * (x - triangle.getVertexes()[0].getY()) - n.getZ() * (y - triangle.getVertexes()[0].getZ())) / n.getX() + triangle.getVertexes()[0].getX());
/*    */     }
/*    */     
/* 34 */     return Integer.MIN_VALUE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void action(int y, int z) {
/* 41 */     int x = getXFromYZ(this.triangle, y, z);
/* 42 */     if (this.buffer.test(y, z, x))
/*    */     {
/* 44 */       this.image.setRGB(y, z, this.triangle.getColor(this.solid, new Vector(x, y, z), this.sun).getRGB());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\zBuffer\ZBufferAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */