/*     */ package Engie3D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Transform
/*     */ {
/*     */   private Matrix M;
/*     */   private Vector v;
/*     */   
/*     */   public Matrix getMatrix() {
/*  14 */     return this.M;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector getVector() {
/*  19 */     return this.v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMatrix(Matrix N) {
/*  28 */     this.M = N;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVector(Vector u) {
/*  36 */     this.v = u;
/*     */   }
/*     */ 
/*     */   
/*     */   private Transform() {
/*  41 */     setMatrix(Matrix.createNull());
/*  42 */     setVector(Vector.createNull());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Transform(Matrix N, Vector u) {
/*  50 */     setMatrix(N);
/*  51 */     setVector(u);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector apply(Vector p) {
/*  57 */     return this.M.mul(p).plus(this.v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector[] apply(Vector[] v) {
/*  63 */     Vector[] u = new Vector[v.length];
/*  64 */     for (int i = 0; i < v.length; i++)
/*  65 */       u[i] = apply(v[i]); 
/*  66 */     return u;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Triangle apply(Triangle triangle) {
/*  72 */     return new Triangle(apply(triangle.getVertexes()), triangle.getColorer());
/*     */   }
/*     */ 
/*     */   
/*     */   public Solid apply(Solid solid) {
/*  77 */     Solid result = new Solid();
/*  78 */     for (Triangle triangle : solid)
/*  79 */       result.add(apply(triangle)); 
/*  80 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transform composite(Transform T) {
/*  88 */     return new Transform(T.getMatrix().mul(getMatrix()), T.getMatrix().mul(getVector()).plus(T.getVector()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transform inverse() {
/*  97 */     return new Transform(getMatrix().inverse(), getMatrix().inverse().mul(getVector()).mul(-1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Transform createNull() {
/* 102 */     return new Transform();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Transform createIdent() {
/* 107 */     return new Transform(Matrix.createIdent(), Vector.createNull());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createRotateX(double a) {
/* 113 */     return new Transform(Matrix.createRotateX(a), Vector.createNull());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createRotateY(double a) {
/* 119 */     return new Transform(Matrix.createRotateY(a), Vector.createNull());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createRotateZ(double a) {
/* 125 */     return new Transform(Matrix.createRotateZ(a), Vector.createNull());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createTranslate(double dx, double dy, double dz) {
/* 131 */     return new Transform(Matrix.createIdent(), new Vector(dx, dy, dz));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createTranslateX(double dx) {
/* 137 */     return new Transform(Matrix.createIdent(), Vector.createTranslateX(dx));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createTranslateY(double dy) {
/* 143 */     return new Transform(Matrix.createIdent(), Vector.createTranslateY(dy));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createTranslateZ(double dz) {
/* 149 */     return new Transform(Matrix.createIdent(), Vector.createTranslateZ(dz));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Transform createScale(double a, double b, double c) {
/* 155 */     return new Transform(Matrix.createScale(a, b, c), Vector.createNull());
/*     */   }
/*     */   
/*     */   public static Transform createScale(double a) {
/* 159 */     return new Transform(Matrix.createScale(a, a, a), Vector.createNull());
/*     */   }
/*     */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Engie3D\Transform.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */