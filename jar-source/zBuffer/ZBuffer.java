/*    */ package zBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZBuffer
/*    */ {
/*    */   private int[][] zBuffer;
/*    */   
/*    */   public void init(int width, int height) {
/* 10 */     this.zBuffer = new int[width][];
/* 11 */     for (int i = 0; i < width; i++) {
/*    */       
/* 13 */       this.zBuffer[i] = new int[height];
/* 14 */       for (int j = 0; j < height; j++) {
/* 15 */         this.zBuffer[i][j] = Integer.MIN_VALUE;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean test(int x, int y, int z) {
/* 21 */     if (x < 0 || x >= this.zBuffer.length || y < 0 || y >= (this.zBuffer[0]).length)
/* 22 */       return false; 
/* 23 */     if (z > this.zBuffer[x][y]) {
/*    */       
/* 25 */       this.zBuffer[x][y] = z;
/* 26 */       return true;
/*    */     } 
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\zBuffer\ZBuffer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */