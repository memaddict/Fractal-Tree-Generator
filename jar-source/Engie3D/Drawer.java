/*    */ package Engie3D;
/*    */ 
/*    */ import java.awt.Image;
/*    */ 
/*    */ 
/*    */ public class Drawer
/*    */ {
/*    */   private Solid solid;
/*    */   private ImageBuilder imager;
/*    */   
/*    */   public Drawer(Solid solid, ImageBuilder imager) {
/* 12 */     this.solid = solid;
/* 13 */     this.imager = imager;
/*    */   }
/*    */ 
/*    */   
/*    */   public Image draw(int width, int height, Vector sun, Transform transform) {
/* 18 */     Solid transformedSolid = transform.apply(this.solid);
/* 19 */     this.imager.init(transformedSolid, sun, width, height);
/* 20 */     for (Triangle triangle : transformedSolid)
/*    */     {
/* 22 */       this.imager.add(triangle);
/*    */     }
/* 24 */     return this.imager.getResult();
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Engie3D\Drawer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */