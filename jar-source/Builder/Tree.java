/*    */ package Builder;
/*    */ import Engie3D.Colorer;
/*    */ import Engie3D.Solid;
/*    */ import Engie3D.Transform;
/*    */ import Engie3D.Vector;
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class Tree extends Solid {
/*    */   Colorer treeColorer;
/*    */   Colorer leafColorer;
/*    */   double brFinal;
/*    */   
/*    */   public double randMethod(double min, double max) {
/* 14 */     return Math.random() * (max - min) + min;
/*    */   } double bhFinal; int degreeFinal; Color branchFinal; Color leafFinal;
/*    */   Tree(int iterationNum, double brMin, double brMax, double bhMin, double bhMax, int degreeMin, int degreeMax, Color branchLeft, Color branchRight, Color leafLeft, Color leafRight) {
/* 17 */     qRandomizer(brMin, brMax, bhMin, bhMax, degreeMin, degreeMax, branchLeft, branchRight, leafLeft, leafRight);
/* 18 */     treeLogic(iterationNum, this.bhFinal, this.brFinal, this.degreeFinal, Transform.createIdent());
/*    */   }
/*    */   
/*    */   public static Solid createBranch(double height, double radius, int countCorners, Colorer colorer) {
/* 22 */     Solid solid = new Solid();
/*    */     
/* 24 */     for (int i = 0; i < countCorners; i++) {
/*    */       
/* 26 */       double phi1 = 6.283185307179586D / countCorners * i;
/* 27 */       double phi2 = 6.283185307179586D / countCorners * (i + 1);
/* 28 */       Vector[] leftPoly = new Vector[3];
/* 29 */       Vector[] rightPoly = new Vector[3];
/* 30 */       leftPoly[0] = new Vector(radius * Math.cos(phi1), radius * Math.sin(phi1), 0.0D);
/* 31 */       rightPoly[2] = new Vector(radius * Math.cos(phi2), radius * Math.sin(phi2), 0.0D); leftPoly[1] = new Vector(radius * Math.cos(phi2), radius * Math.sin(phi2), 0.0D);
/* 32 */       rightPoly[1] = new Vector(radius * Math.cos(phi1), radius * Math.sin(phi1), height); leftPoly[2] = new Vector(radius * Math.cos(phi1), radius * Math.sin(phi1), height);
/* 33 */       rightPoly[0] = new Vector(radius * Math.cos(phi2), radius * Math.sin(phi2), height);
/* 34 */       solid.add(new Triangle(leftPoly, colorer));
/* 35 */       solid.add(new Triangle(rightPoly, colorer));
/*    */     } 
/* 37 */     return solid;
/*    */   }
/*    */   
/*    */   public static Solid createLeaf(double size, Colorer colorer) {
/* 41 */     Solid solid = new Solid();
/* 42 */     Vector[] leftPoly = new Vector[3];
/* 43 */     Vector[] rightPoly = new Vector[3];
/* 44 */     rightPoly[2] = new Vector(0.0D, 0.0D, 0.0D); leftPoly[0] = new Vector(0.0D, 0.0D, 0.0D);
/* 45 */     leftPoly[1] = new Vector(0.0D, size / 3.0D, size / 2.0D);
/* 46 */     rightPoly[0] = new Vector(0.0D, 0.0D, size); leftPoly[2] = new Vector(0.0D, 0.0D, size);
/* 47 */     rightPoly[1] = new Vector(0.0D, -size / 3.0D, size / 2.0D);
/* 48 */     solid.add(new Triangle(leftPoly, colorer));
/* 49 */     solid.add(new Triangle(rightPoly, colorer));
/* 50 */     return solid;
/*    */   }
/*    */ 
/*    */   
/*    */   void treeLogic(int n, double size, double radius, double anC, Transform T) {
/* 55 */     double angleCoef = Math.PI / 180.0D / anC * 0.5D;
/* 56 */     if (--n > 0) {
/*    */       
/* 58 */       double randomABB = (Math.random() * 2.0D - 1.0D) * Math.PI / 4.0D;
/* 59 */       treeLogic(n, size * 0.7D, radius / 1.23D, anC, Transform.createRotateZ(Math.PI * Math.random()).composite(Transform.createRotateX(randomABB + angleCoef).composite(Transform.createTranslateZ(size).composite(T))));
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 64 */       treeLogic(n, size * 0.7D, radius / 1.23D, anC, Transform.createRotateZ(Math.PI * Math.random()).composite(Transform.createRotateX(randomABB - angleCoef).composite(Transform.createTranslateZ(size).composite(T))));
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 69 */       addAll((Collection)T.apply(createBranch(size, radius, n + 2, this.treeColorer)));
/*    */     } else {
/*    */       
/* 72 */       addAll((Collection)T.apply(createLeaf(18.0D, this.leafColorer)));
/*    */     } 
/*    */   } public void qRandomizer(double brMin, double brMax, double bhMin, double bhMax, int degreeMin, int degreeMax, Color branchLeft, Color branchRight, Color leafLeft, Color leafRight) {
/* 75 */     this.brFinal = randMethod(brMin, brMax);
/* 76 */     this.bhFinal = randMethod(bhMin, bhMax);
/* 77 */     this.degreeFinal = (int)randMethod(degreeMin, degreeMax);
/* 78 */     this.branchFinal = qRandomColor(branchLeft, branchRight);
/* 79 */     this.leafFinal = qRandomColor(leafLeft, leafRight);
/* 80 */     this.treeColorer = (Colorer)new SimpleColorer(this.branchFinal);
/* 81 */     this.leafColorer = (Colorer)new SimpleColorer(this.leafFinal);
/*    */   }
/*    */   public Color qRandomColor(Color First, Color Second) {
/* 84 */     float[] cFirst = new float[3];
/* 85 */     float[] cSecond = new float[3];
/* 86 */     Color.RGBtoHSB(First.getRed(), First.getGreen(), First.getBlue(), cFirst);
/* 87 */     Color.RGBtoHSB(Second.getRed(), Second.getGreen(), Second.getBlue(), cSecond);
/* 88 */     return Color.getHSBColor((float)randMethod(cFirst[0], cSecond[0]), (float)randMethod(cFirst[1], cSecond[1]), (float)randMethod(cFirst[2], cSecond[2]));
/*    */   }
/*    */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Builder\Tree.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */