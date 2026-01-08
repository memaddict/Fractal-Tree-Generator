/*    */ package Engie3D;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ 
/*    */ public class SimpleColorer
/*    */   implements Colorer
/*    */ {
/*    */   private Color color;
/*    */   
/*    */   public SimpleColorer(Color color) {
/* 12 */     this.color = color;
/*    */   }
/*    */ 
/*    */   
/*    */   public Color getColor(Solid solid, Triangle triangle, Vector point, Vector sun) {
/* 17 */     double s = triangle.getNormal().cos(sun) * 0.5D + 0.5D;
/* 18 */     return new Color((int)(s * this.color.getRed()), (int)(s * this.color.getGreen()), (int)(s * this.color.getBlue()));
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Engie3D\SimpleColorer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */