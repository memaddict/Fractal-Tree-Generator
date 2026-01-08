/*     */ package Engie3D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Vector
/*     */ {
/*     */   private double[] x;
/*     */   
/*     */   public Vector() {
/*  13 */     this.x = new double[3];
/*  14 */     set(0, 0.0D);
/*  15 */     set(1, 0.0D);
/*  16 */     set(2, 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector(double x1, double x2, double x3) {
/*  22 */     this.x = new double[3];
/*  23 */     set(0, x1);
/*  24 */     set(1, x2);
/*  25 */     set(2, x3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector(double[] v) {
/*  31 */     this.x = new double[3];
/*  32 */     set(0, v[0]);
/*  33 */     set(1, v[1]);
/*  34 */     set(2, v[2]);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector clone() {
/*  39 */     return new Vector(this.x);
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(int i) {
/*  44 */     return this.x[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int i, double t) {
/*  49 */     this.x[i] = t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void inc(int i, double t) {
/*  57 */     this.x[i] = this.x[i] + t;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getX() {
/*  62 */     return this.x[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX(double t) {
/*  67 */     this.x[0] = t;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getY() {
/*  72 */     return this.x[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY(double t) {
/*  77 */     this.x[1] = t;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getZ() {
/*  82 */     return this.x[2];
/*     */   }
/*     */ 
/*     */   
/*     */   public void setZ(double t) {
/*  87 */     this.x[2] = t;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector plus(Vector p) {
/*  92 */     Vector q = clone();
/*  93 */     for (int i = 0; i < 3; i++)
/*  94 */       q.inc(i, p.get(i)); 
/*  95 */     return q;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector minus(Vector p) {
/* 100 */     Vector q = clone();
/* 101 */     for (int i = 0; i < 3; i++)
/* 102 */       q.inc(i, -p.get(i)); 
/* 103 */     return q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double dot(Vector p) {
/* 112 */     double r = 0.0D;
/* 113 */     for (int i = 0; i < 3; i++)
/* 114 */       r += get(i) * p.get(i); 
/* 115 */     return r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector cross(Vector p) {
/* 124 */     return new Vector(get(1) * p.get(2) - p.get(1) * get(2), -get(0) * p.get(2) + p.get(0) * get(2), get(0) * p.get(1) - p.get(0) * get(1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double normal() {
/* 133 */     double r = 0.0D;
/* 134 */     for (int i = 0; i < 3; i++)
/* 135 */       r += get(i) * get(i); 
/* 136 */     return Math.sqrt(r);
/*     */   }
/*     */ 
/*     */   
/*     */   public double cos(Vector p) {
/* 141 */     return dot(p) / normal() * p.normal();
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector mul(double a) {
/* 146 */     Vector q = createNull();
/* 147 */     for (int i = 0; i < 3; i++)
/* 148 */       q.set(i, a * get(i)); 
/* 149 */     return q;
/*     */   }
/*     */ 
/*     */   
/*     */   public double projection(Vector p) {
/* 154 */     return dot(p) / p.normal();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vector createNull() {
/* 159 */     return new Vector(0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vector createTranslateX(double d) {
/* 164 */     return new Vector(d, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vector createTranslateY(double d) {
/* 169 */     return new Vector(0.0D, d, 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Vector createTranslateZ(double d) {
/* 175 */     return new Vector(0.0D, 0.0D, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 180 */     return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
/*     */   }
/*     */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Engie3D\Vector.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */