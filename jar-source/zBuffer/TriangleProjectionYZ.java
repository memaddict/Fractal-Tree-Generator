/*    */ package zBuffer;
/*    */ 
/*    */ import Engie3D.Triangle;
/*    */ import java.awt.Point;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ public class TriangleProjectionYZ
/*    */ {
/*    */   ArrayList<Point> vertexes;
/*    */   int width;
/*    */   int height;
/*    */   
/*    */   public TriangleProjectionYZ(Triangle triangle, int width, int height) {
/* 16 */     this.vertexes = new ArrayList<Point>();
/* 17 */     this.width = width;
/* 18 */     this.height = height;
/* 19 */     this.vertexes.add(new Point((int)Math.round(triangle.getVertexes()[0].getY()), (int)Math.round(triangle.getVertexes()[0].getZ())));
/* 20 */     this.vertexes.add(new Point((int)Math.round(triangle.getVertexes()[1].getY()), (int)Math.round(triangle.getVertexes()[1].getZ())));
/* 21 */     this.vertexes.add(new Point((int)Math.round(triangle.getVertexes()[2].getY()), (int)Math.round(triangle.getVertexes()[2].getZ())));
/*    */     
/* 23 */     Collections.sort(this.vertexes, new Comparator<Point>()
/*    */         {
/*    */           public int compare(Point p, Point q)
/*    */           {
/* 27 */             return p.y - q.y;
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void forEach(Action action) {
/* 36 */     if (((Point)this.vertexes.get(1)).y - ((Point)this.vertexes.get(0)).y != 0 && ((Point)this.vertexes.get(2)).y - ((Point)this.vertexes.get(0)).y != 0)
/*    */     {
/* 38 */       for (int z = ((Point)this.vertexes.get(0)).y; z <= ((Point)this.vertexes.get(1)).y; z++) {
/*    */         
/* 40 */         int a = (int)Math.round((((Point)this.vertexes.get(1)).x - ((Point)this.vertexes.get(0)).x) * (z - ((Point)this.vertexes.get(0)).y) / (((Point)this.vertexes.get(1)).y - ((Point)this.vertexes.get(0)).y) + ((Point)this.vertexes.get(0)).x);
/* 41 */         int b = (int)Math.round((((Point)this.vertexes.get(2)).x - ((Point)this.vertexes.get(0)).x) * (z - ((Point)this.vertexes.get(0)).y) / (((Point)this.vertexes.get(2)).y - ((Point)this.vertexes.get(0)).y) + ((Point)this.vertexes.get(0)).x);
/* 42 */         for (int y = Math.min(a, b); y <= Math.max(a, b); y++)
/*    */         {
/* 44 */           action.action(y, z);
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 49 */     if (((Point)this.vertexes.get(1)).y - ((Point)this.vertexes.get(2)).y != 0 && ((Point)this.vertexes.get(2)).y - ((Point)this.vertexes.get(0)).y != 0)
/*    */     {
/* 51 */       for (int z = ((Point)this.vertexes.get(1)).y; z <= ((Point)this.vertexes.get(2)).y; z++) {
/*    */         
/* 53 */         int a = (int)Math.round((((Point)this.vertexes.get(1)).x - ((Point)this.vertexes.get(2)).x) * (z - ((Point)this.vertexes.get(2)).y) / (((Point)this.vertexes.get(1)).y - ((Point)this.vertexes.get(2)).y) + ((Point)this.vertexes.get(2)).x);
/* 54 */         int b = (int)Math.round((((Point)this.vertexes.get(2)).x - ((Point)this.vertexes.get(0)).x) * (z - ((Point)this.vertexes.get(0)).y) / (((Point)this.vertexes.get(2)).y - ((Point)this.vertexes.get(0)).y) + ((Point)this.vertexes.get(0)).x);
/* 55 */         for (int y = Math.min(a, b); y <= Math.max(a, b); y++)
/*    */         {
/* 57 */           action.action(y, z);
/*    */         }
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\zBuffer\TriangleProjectionYZ.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */