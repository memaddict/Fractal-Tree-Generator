/*     */ package Engie3D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Matrix
/*     */ {
/*     */   private double[][] M;
/*     */   
/*     */   public Matrix() {
/*  13 */     this.M = new double[3][];
/*  14 */     for (int i = 0; i < 3; i++) {
/*     */       
/*  16 */       this.M[i] = new double[3];
/*  17 */       for (int j = 0; j < 3; j++) {
/*  18 */         this.M[i][j] = 0.0D;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Matrix(double[][] N) {
/*  25 */     this.M = new double[3][];
/*  26 */     for (int i = 0; i < 3; i++) {
/*     */       
/*  28 */       this.M[i] = new double[3];
/*  29 */       for (int j = 0; j < 3; j++) {
/*  30 */         this.M[i][j] = N[i][j];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix(double x11, double x12, double x13, double x21, double x22, double x23, double x31, double x32, double x33) {
/*  39 */     this.M = new double[3][];
/*  40 */     for (int i = 0; i < 3; i++)
/*  41 */       this.M[i] = new double[3]; 
/*  42 */     set(0, 0, x11); set(0, 1, x12); set(0, 2, x13);
/*  43 */     set(1, 0, x21); set(1, 1, x22); set(1, 2, x23);
/*  44 */     set(2, 0, x31); set(2, 1, x32); set(2, 2, x33);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(int i, int j) {
/*  50 */     return this.M[i][j];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int i, int j, double t) {
/*  56 */     this.M[i][j] = t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void inc(int i, int j, double t) {
/*  65 */     this.M[i][j] = this.M[i][j] + t;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix clone() {
/*  71 */     return new Matrix(this.M);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix plus(Matrix N) {
/*  80 */     Matrix K = clone();
/*  81 */     for (int i = 0; i < 3; i++) {
/*  82 */       for (int j = 0; j < 3; j++)
/*  83 */         K.inc(i, j, N.get(i, j)); 
/*  84 */     }  return K;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix minus(Matrix N) {
/*  93 */     Matrix K = clone();
/*  94 */     for (int i = 0; i < 3; i++) {
/*  95 */       for (int j = 0; j < 3; j++)
/*  96 */         K.inc(i, j, -N.get(i, j)); 
/*  97 */     }  return K;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix mul(Matrix N) {
/* 106 */     Matrix K = createNull();
/* 107 */     for (int i = 0; i < 3; i++) {
/* 108 */       for (int j = 0; j < 3; j++)
/* 109 */       { for (int k = 0; k < 3; k++)
/* 110 */           K.inc(i, j, get(i, k) * N.get(k, j));  } 
/* 111 */     }  return K;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector mul(Vector p) {
/* 120 */     Vector v = Vector.createNull();
/* 121 */     for (int i = 0; i < 3; i++) {
/* 122 */       for (int j = 0; j < 3; j++)
/* 123 */         v.inc(i, get(i, j) * p.get(j)); 
/* 124 */     }  return v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix mul(double a) {
/* 132 */     Matrix K = createNull();
/* 133 */     for (int i = 0; i < 3; i++) {
/* 134 */       for (int j = 0; j < 3; j++)
/* 135 */         K.set(i, j, a * get(i, j)); 
/* 136 */     }  return K;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double det() {
/* 143 */     return this.M[0][0] * this.M[1][1] * this.M[2][2] + this.M[1][0] * this.M[2][1] * this.M[0][2] + this.M[2][0] * this.M[0][1] * this.M[1][2] - this.M[2][0] * this.M[1][1] * this.M[0][2] - this.M[1][0] * this.M[0][1] * this.M[2][2] - this.M[0][0] * this.M[2][1] * this.M[1][2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Matrix inverse() {
/* 155 */     Matrix K = new Matrix(this.M[1][1] * this.M[2][2] - this.M[2][1] * this.M[1][2], -this.M[0][1] * this.M[2][2] + this.M[2][1] * this.M[0][2], this.M[0][1] * this.M[1][2] - this.M[1][1] * this.M[0][2], -this.M[1][0] * this.M[2][2] + this.M[2][0] * this.M[1][2], this.M[0][0] * this.M[2][2] - this.M[2][0] * this.M[0][2], -this.M[0][0] * this.M[1][2] + this.M[1][0] * this.M[0][2], this.M[1][0] * this.M[2][1] - this.M[2][0] * this.M[1][1], -this.M[0][0] * this.M[2][1] + this.M[2][0] * this.M[0][1], this.M[0][0] * this.M[1][1] - this.M[1][0] * this.M[0][1]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     return K.mul(1.0D / det());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Matrix createNull() {
/* 175 */     return new Matrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Matrix createIdent() {
/* 184 */     Matrix K = createNull();
/* 185 */     for (int i = 0; i < 3; i++)
/* 186 */       K.set(i, i, 1.0D); 
/* 187 */     return K;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Matrix createRotateX(double a) {
/* 193 */     Matrix T = new Matrix();
/* 194 */     T.set(0, 0, 1.0D);
/* 195 */     T.set(1, 1, Math.cos(a));
/* 196 */     T.set(2, 2, Math.cos(a));
/* 197 */     T.set(1, 2, -Math.sin(a));
/* 198 */     T.set(2, 1, Math.sin(a));
/* 199 */     return T;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Matrix createRotateY(double a) {
/* 205 */     Matrix T = new Matrix();
/* 206 */     T.set(1, 1, 1.0D);
/* 207 */     T.set(0, 0, Math.cos(a));
/* 208 */     T.set(2, 2, Math.cos(a));
/* 209 */     T.set(0, 2, Math.sin(a));
/* 210 */     T.set(2, 0, -Math.sin(a));
/* 211 */     return T;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Matrix createRotateZ(double a) {
/* 217 */     Matrix T = new Matrix();
/* 218 */     T.set(2, 2, 1.0D);
/* 219 */     T.set(0, 0, Math.cos(a));
/* 220 */     T.set(1, 1, Math.cos(a));
/* 221 */     T.set(0, 1, -Math.sin(a));
/* 222 */     T.set(1, 0, Math.sin(a));
/* 223 */     return T;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Matrix createScale(double a, double b, double c) {
/* 229 */     Matrix T = new Matrix();
/* 230 */     T.set(0, 0, a);
/* 231 */     T.set(1, 1, b);
/* 232 */     T.set(2, 2, c);
/* 233 */     return T;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Matrix createScale(double a) {
/* 238 */     Matrix T = new Matrix();
/* 239 */     T.set(0, 0, a);
/* 240 */     T.set(1, 1, a);
/* 241 */     T.set(2, 2, a);
/* 242 */     return T;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 247 */     StringBuilder builder = new StringBuilder();
/* 248 */     builder.append("(");
/* 249 */     for (int i = 0; i < 3; i++) {
/* 250 */       for (int j = 0; j < 3; j++) {
/*     */         
/* 252 */         builder.append(this.M[i][j]);
/* 253 */         if (j != 2 || i != 2)
/* 254 */           builder.append(", "); 
/*     */       } 
/* 256 */     }  builder.append(")");
/* 257 */     return builder.toString();
/*     */   }
/*     */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Engie3D\Matrix.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */