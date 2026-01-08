/*    */ package Engie3D;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Triangle
/*    */ {
/* 10 */   private Vector[] vertexes = new Vector[3];
/*    */   
/*    */   private Colorer colorer;
/*    */   
/*    */   public Triangle(Vector[] vertexes, Colorer colorer) {
/* 15 */     setVertexes(vertexes);
/* 16 */     setColorer(colorer);
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector getNormal() {
/* 21 */     return this.vertexes[1].minus(this.vertexes[0]).cross(this.vertexes[2].minus(this.vertexes[0]));
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector[] getVertexes() {
/* 26 */     return this.vertexes;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setVertexes(Vector[] vertexes) {
/* 31 */     this.vertexes = vertexes;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Colorer getColorer() {
/* 37 */     return this.colorer;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setColorer(Colorer colorer) {
/* 42 */     this.colorer = colorer;
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector getCenter() {
/* 47 */     return new Vector((this.vertexes[0].getX() + this.vertexes[1].getX() + this.vertexes[2].getX()) / 3.0D, (this.vertexes[0].getY() + this.vertexes[1].getY() + this.vertexes[2].getY()) / 3.0D, (this.vertexes[0].getZ() + this.vertexes[1].getZ() + this.vertexes[2].getZ()) / 3.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     return "(" + this.vertexes[0] + ", " + this.vertexes[1] + ", " + this.vertexes[2] + ")";
/*    */   }
/*    */ 
/*    */   
/*    */   public Color getColor(Solid solid, Vector point, Vector sun) {
/* 60 */     return this.colorer.getColor(solid, this, point, sun);
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Engie3D\Triangle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */