/*     */ package Builder;
/*     */ import java.awt.AWTException;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Robot;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class wOptions extends JPanel implements ActionListener, MouseListener {
/*  17 */   private static iJButton[] bOptions = new iJButton[42];
/*  18 */   int xA = 170; int yCount = 35; int yHelp; boolean rRadius;
/*     */   boolean rHeight;
/*  20 */   double brMin = 10.0D, brMax = 13.0D; boolean rDegree; boolean rColor; boolean rFull;
/*  21 */   double bhMin = 300.0D; double bhMax = 500.0D;
/*  22 */   int degreeMin = 55, degreeMax = 85;
/*  23 */   int iterationNum = 13; int colorChanger = 0; Color branchLeft; Color branchRight; Color leafLeft;
/*     */   Color leafRight;
/*  25 */   private static Image oBackground = (new ImageIcon("textures/oBackground.png")).getImage();
/*  26 */   private static Image oPalitre = (new ImageIcon("textures/oButtons/oPalitre.png")).getImage(); public String sInt(int i) {
/*  27 */     Integer nI = Integer.valueOf(i); return nI.toString();
/*     */   } public void bShow(int i) {
/*  29 */     if (i < 12) bOptions[i].changeImage("textures/oButtons/" + sInt(i) + ".png"); 
/*  30 */     if (i == 12) bOptions[i].changeImage("textures/oButtons/Nums/" + sInt((int)this.brMin) + ".png"); 
/*  31 */     if (i == 13) bOptions[i].changeImage("textures/oButtons/Nums/" + sInt((int)this.brMax) + ".png"); 
/*  32 */     if (i == 14) bOptions[i].changeImage("textures/oButtons/Nums/" + sInt((int)this.bhMin) + ".png"); 
/*  33 */     if (i == 15) bOptions[i].changeImage("textures/oButtons/Nums/" + sInt((int)this.bhMax) + ".png"); 
/*  34 */     if (i == 16) bOptions[i].changeImage("textures/oButtons/Nums/" + sInt(this.degreeMin) + ".png"); 
/*  35 */     if (i == 17) bOptions[i].changeImage("textures/oButtons/Nums/" + sInt(this.degreeMax) + ".png"); 
/*  36 */     if (i == 18) bOptions[i].changeImage("textures/oButtons/Nums/" + sInt(this.iterationNum) + ".png"); 
/*  37 */     if (i > 18 && i < 33) if (i % 2 == 0) { bOptions[i].changeImage("textures/oButtons/Counters/Plus.png"); }
/*  38 */       else { bOptions[i].changeImage("textures/oButtons/Counters/Minus.png"); }
/*  39 */         if (i > 32 && i < 37) { bOptions[i].changeImage("textures/oButtons/null.png"); bOptions[i].setOpaque(true); }
/*  40 */      if (i > 36) bOptions[i].changeImage("textures/oButtons/defis.png"); 
/*     */   } public void bHide(int i) {
/*  42 */     bOptions[i].changeImage("textures/oButtons/hidden.png");
/*     */   }
/*     */   public wOptions() {
/*  45 */     setLayout((LayoutManager)null);
/*  46 */     addMouseListener(this); int i;
/*  47 */     for (i = 1; i <= 41; i++) {
/*  48 */       if (i < 12) bOptions[i] = new iJButton("textures/oButtons/" + sInt(i) + ".png"); 
/*  49 */       if (i == 12) bOptions[i] = new iJButton("textures/oButtons/Nums/" + sInt((int)this.brMin) + ".png"); 
/*  50 */       if (i == 13) bOptions[i] = new iJButton("textures/oButtons/Nums/" + sInt((int)this.brMax) + ".png"); 
/*  51 */       if (i == 14) bOptions[i] = new iJButton("textures/oButtons/Nums/" + sInt((int)this.bhMin) + ".png"); 
/*  52 */       if (i == 15) bOptions[i] = new iJButton("textures/oButtons/Nums/" + sInt((int)this.bhMax) + ".png"); 
/*  53 */       if (i == 16) bOptions[i] = new iJButton("textures/oButtons/Nums/" + sInt(this.degreeMin) + ".png"); 
/*  54 */       if (i == 17) bOptions[i] = new iJButton("textures/oButtons/Nums/" + sInt(this.degreeMax) + ".png"); 
/*  55 */       if (i == 18) bOptions[i] = new iJButton("textures/oButtons/Nums/" + sInt(this.iterationNum) + ".png"); 
/*  56 */       if (i > 18 && i < 33) if (i % 2 == 0) { bOptions[i] = new iJButton("textures/oButtons/Counters/Plus.png"); }
/*  57 */         else { bOptions[i] = new iJButton("textures/oButtons/Counters/Minus.png"); }
/*  58 */           if (i > 32 && i < 37) { bOptions[i] = new iJButton("textures/oButtons/null.png"); bOptions[i].setOpaque(true); }
/*  59 */        if (i > 36) bOptions[i] = new iJButton("textures/oButtons/defis.png"); 
/*     */     } 
/*  61 */     this.branchLeft = this.branchRight = this.leafLeft = this.leafRight = Color.white;
/*  62 */     for (i = 1; i <= 41; ) { bOptions[i].addActionListener(this); i++; }
/*  63 */      bOptions[1].setLocation(this.xA - 130, this.yCount);
/*  64 */     bOptions[37].setLocation(this.xA - 10, this.yCount + 70);
/*  65 */     bOptions[20].setLocation(this.xA - 35, this.yCount + 65);
/*  66 */     bOptions[21].setLocation(this.xA + 5, this.yCount + 65);
/*  67 */     bOptions[12].setLocation(this.xA - 85, this.yCount + 55);
/*  68 */     bOptions[13].setLocation(this.xA + 35, this.yCount + 55);
/*  69 */     bOptions[19].setLocation(this.xA - 115, this.yCount + 65);
/*  70 */     bOptions[22].setLocation(this.xA + 85, this.yCount + 65); this.yCount += 115;
/*  71 */     bOptions[2].setLocation(this.xA - 130, this.yCount);
/*  72 */     bOptions[38].setLocation(this.xA - 10, this.yCount + 70);
/*  73 */     bOptions[24].setLocation(this.xA - 35, this.yCount + 65);
/*  74 */     bOptions[25].setLocation(this.xA + 5, this.yCount + 65);
/*  75 */     bOptions[14].setLocation(this.xA - 85, this.yCount + 55);
/*  76 */     bOptions[15].setLocation(this.xA + 35, this.yCount + 55);
/*  77 */     bOptions[23].setLocation(this.xA - 115, this.yCount + 65);
/*  78 */     bOptions[26].setLocation(this.xA + 85, this.yCount + 65); this.yCount += 115;
/*  79 */     bOptions[3].setLocation(this.xA - 130, this.yCount);
/*  80 */     bOptions[39].setLocation(this.xA - 10, this.yCount + 70);
/*  81 */     bOptions[28].setLocation(this.xA - 35, this.yCount + 65);
/*  82 */     bOptions[29].setLocation(this.xA + 5, this.yCount + 65);
/*  83 */     bOptions[16].setLocation(this.xA - 85, this.yCount + 55);
/*  84 */     bOptions[17].setLocation(this.xA + 35, this.yCount + 55);
/*  85 */     bOptions[27].setLocation(this.xA - 115, this.yCount + 65);
/*  86 */     bOptions[30].setLocation(this.xA + 85, this.yCount + 65); this.yCount += 135;
/*  87 */     bOptions[4].setLocation(this.xA - 75, this.yCount); this.yCount += 245;
/*  88 */     bOptions[5].setLocation(this.xA - 110, this.yCount); this.yCount = 35; this.xA += 600;
/*  89 */     bOptions[6].setLocation(this.xA - 95, this.yCount); this.yCount += 65;
/*  90 */     bOptions[7].setLocation(this.xA - 120, this.yCount);
/*  91 */     bOptions[8].setLocation(this.xA + 20, this.yCount);
/*  92 */     bOptions[40].setLocation(this.xA - 75, this.yCount + 30);
/*  93 */     bOptions[41].setLocation(this.xA + 65, this.yCount + 30);
/*  94 */     bOptions[33].setLocation(this.xA - 120, this.yCount + 20);
/*  95 */     bOptions[35].setLocation(this.xA + 20, this.yCount + 20);
/*  96 */     bOptions[34].setLocation(this.xA - 50, this.yCount + 20);
/*  97 */     bOptions[36].setLocation(this.xA + 90, this.yCount + 20); this.yCount += 90;
/*  98 */     bOptions[9].setLocation(this.xA - 130, this.yCount); this.yCount += 140;
/*  99 */     bOptions[10].setLocation(this.xA - 60, this.yCount);
/* 100 */     bOptions[18].setLocation(this.xA - 25, this.yCount + 35);
/* 101 */     bOptions[31].setLocation(this.xA - 55, this.yCount + 45);
/* 102 */     bOptions[32].setLocation(this.xA + 25, this.yCount + 45); this.xA -= 40; this.yCount += 190;
/* 103 */     bOptions[11].setLocation(this.xA, this.yCount);
/* 104 */     for (i = 1; i <= 41; ) { add(bOptions[i]); i++; }
/*     */   
/*     */   }
/*     */   public void paintComponent(Graphics g) {
/* 108 */     g.drawImage(oBackground, 0, 0, getWidth(), getHeight(), this);
/* 109 */     if (!this.rColor) g.drawImage(oPalitre, 640, 210, 270, 78, this); 
/* 110 */     for (int i = 1; i <= 41; ) { bOptions[i].repaint(); i++; }
/*     */   
/*     */   }
/*     */   public void actionPerformed(ActionEvent e) {
/* 114 */     JButton oCase = (JButton)e.getSource();
/* 115 */     if (oCase.equals(bOptions[1]))
/* 116 */       if (this.rRadius) {
/* 117 */         this.rRadius = false;
/* 118 */         bOptions[1].changeImage("textures/oButtons/1.png");
/* 119 */         bShow(19); bShow(12); bShow(20); bShow(37);
/* 120 */         bShow(21); bShow(13); bShow(22);
/*     */       } else {
/* 122 */         this.rRadius = true;
/* 123 */         bOptions[1].changeImage("textures/oButtons/1f.png");
/* 124 */         bHide(19); bHide(12); bHide(20); bHide(37);
/* 125 */         bHide(21); bHide(13); bHide(22);
/*     */       }  
/* 127 */     if (oCase.equals(bOptions[2]))
/* 128 */       if (this.rHeight) {
/* 129 */         this.rHeight = false;
/* 130 */         bOptions[2].changeImage("textures/oButtons/2.png");
/* 131 */         bShow(23); bShow(14); bShow(24); bShow(38);
/* 132 */         bShow(25); bShow(15); bShow(26);
/*     */       } else {
/* 134 */         this.rHeight = true;
/* 135 */         bOptions[2].changeImage("textures/oButtons/2f.png");
/* 136 */         bHide(23); bHide(14); bHide(24); bHide(38);
/* 137 */         bHide(25); bHide(15); bHide(26);
/*     */       }  
/* 139 */     if (oCase.equals(bOptions[3]))
/* 140 */       if (this.rDegree) {
/* 141 */         this.rDegree = false;
/* 142 */         bOptions[3].changeImage("textures/oButtons/3.png");
/* 143 */         bShow(27); bShow(16); bShow(28); bShow(39);
/* 144 */         bShow(29); bShow(17); bShow(30);
/*     */       } else {
/* 146 */         this.rDegree = true;
/* 147 */         bOptions[3].changeImage("textures/oButtons/3f.png");
/* 148 */         bHide(27); bHide(16); bHide(28); bHide(39);
/* 149 */         bHide(29); bHide(17); bHide(30);
/*     */       }  
/* 151 */     if (oCase.equals(bOptions[6]))
/* 152 */       if (this.rColor) {
/* 153 */         this.rColor = false;
/* 154 */         bOptions[9].setSize(270, 15);
/* 155 */         bOptions[6].changeImage("textures/oButtons/6.png");
/* 156 */         bShow(7); bShow(8); bShow(33); bShow(40); bShow(34);
/* 157 */         bShow(35); bShow(41); bShow(36); bShow(9);
/*     */       } else {
/* 159 */         this.rColor = true;
/* 160 */         bOptions[9].setSize(270, 110);
/* 161 */         bOptions[6].changeImage("textures/oButtons/6f.png");
/* 162 */         bHide(7); bHide(8); bHide(33); bHide(40); bHide(34);
/* 163 */         bHide(35); bHide(41); bHide(36); bHide(9);
/*     */       }  
/* 165 */     if (oCase.equals(bOptions[4]))
/* 166 */       if (this.rFull) {
/* 167 */         this.rColor = false;
/* 168 */         this.rDegree = false;
/* 169 */         this.rHeight = false;
/* 170 */         this.rRadius = false;
/* 171 */         this.rFull = false;
/* 172 */         bOptions[9].setSize(270, 15);
/* 173 */         bOptions[6].changeImage("textures/oButtons/6.png");
/* 174 */         bOptions[3].changeImage("textures/oButtons/3.png");
/* 175 */         bOptions[2].changeImage("textures/oButtons/2.png");
/* 176 */         bOptions[1].changeImage("textures/oButtons/1.png");
/* 177 */         bOptions[4].changeImage("textures/oButtons/4.png");
/* 178 */         bShow(7); bShow(8); bShow(33); bShow(40); bShow(34);
/* 179 */         bShow(35); bShow(41); bShow(36); bShow(9); bShow(27);
/* 180 */         bShow(16); bShow(28); bShow(39); bShow(29); bShow(17);
/* 181 */         bShow(30); bShow(23); bShow(14); bShow(24); bShow(38);
/* 182 */         bShow(25); bShow(15); bShow(26); bShow(19); bShow(12);
/* 183 */         bShow(20); bShow(37); bShow(21); bShow(13); bShow(22);
/*     */       } else {
/* 185 */         this.rColor = true;
/* 186 */         this.rDegree = true;
/* 187 */         this.rHeight = true;
/* 188 */         this.rRadius = true;
/* 189 */         this.rFull = true;
/* 190 */         bOptions[9].setSize(270, 110);
/* 191 */         bOptions[6].changeImage("textures/oButtons/6f.png");
/* 192 */         bOptions[3].changeImage("textures/oButtons/3f.png");
/* 193 */         bOptions[2].changeImage("textures/oButtons/2f.png");
/* 194 */         bOptions[1].changeImage("textures/oButtons/1f.png");
/* 195 */         bOptions[4].changeImage("textures/oButtons/4f.png");
/* 196 */         bHide(7); bHide(8); bHide(33); bHide(40); bHide(34);
/* 197 */         bHide(35); bHide(41); bHide(36); bHide(9); bHide(27);
/* 198 */         bHide(16); bHide(28); bHide(39); bHide(29); bHide(17);
/* 199 */         bHide(30); bHide(23); bHide(14); bHide(24); bHide(38);
/* 200 */         bHide(25); bHide(15); bHide(26); bHide(19); bHide(12);
/* 201 */         bHide(20); bHide(37); bHide(21); bHide(13); bHide(22);
/*     */       }  
/* 203 */     if (oCase.equals(bOptions[19])) {
/* 204 */       if (this.brMin <= 18.0D && this.brMin > 7.0D) {
/* 205 */         this.brMin--;
/* 206 */         bOptions[20].changeImage("textures/oButtons/Counters/Plus.png");
/*     */       }
/* 208 */       else if (this.brMin == 7.0D) {
/* 209 */         this.brMin = 7.0D;
/* 210 */         bOptions[19].changeImage("textures/oButtons/Counters/sMinus.png");
/*     */       } 
/*     */       
/* 213 */       bOptions[12].changeImage("textures/oButtons/Nums/" + sInt((int)this.brMin) + ".png");
/*     */     } 
/* 215 */     if (oCase.equals(bOptions[20])) {
/* 216 */       if (this.brMin < 18.0D && this.brMin >= 7.0D) {
/* 217 */         this.brMin++;
/* 218 */         bOptions[19].changeImage("textures/oButtons/Counters/Minus.png");
/*     */       }
/* 220 */       else if (this.brMin == 18.0D) {
/* 221 */         this.brMin = 18.0D;
/* 222 */         bOptions[20].changeImage("textures/oButtons/Counters/sPlus.png");
/*     */       } 
/*     */       
/* 225 */       bOptions[12].changeImage("textures/oButtons/Nums/" + sInt((int)this.brMin) + ".png");
/*     */     } 
/* 227 */     if (oCase.equals(bOptions[21])) {
/* 228 */       if (this.brMax <= 18.0D && this.brMax > 7.0D) {
/* 229 */         this.brMax--;
/* 230 */         bOptions[22].changeImage("textures/oButtons/Counters/Plus.png");
/*     */       }
/* 232 */       else if (this.brMax == 7.0D) {
/* 233 */         this.brMax = 7.0D;
/* 234 */         bOptions[21].changeImage("textures/oButtons/Counters/sMinus.png");
/*     */       } 
/*     */       
/* 237 */       bOptions[13].changeImage("textures/oButtons/Nums/" + sInt((int)this.brMax) + ".png");
/* 238 */       bShow(13);
/*     */     } 
/* 240 */     if (oCase.equals(bOptions[22])) {
/* 241 */       if (this.brMax < 18.0D && this.brMax >= 7.0D) {
/* 242 */         this.brMax++;
/* 243 */         bOptions[21].changeImage("textures/oButtons/Counters/Minus.png");
/*     */       }
/* 245 */       else if (this.brMax == 18.0D) {
/* 246 */         this.brMax = 18.0D;
/* 247 */         bOptions[22].changeImage("textures/oButtons/Counters/sPlus.png");
/*     */       } 
/*     */       
/* 250 */       bOptions[13].changeImage("textures/oButtons/Nums/" + sInt((int)this.brMax) + ".png");
/*     */     } 
/* 252 */     if (oCase.equals(bOptions[23])) {
/* 253 */       if (this.bhMin <= 600.0D && this.bhMin > 200.0D) {
/* 254 */         this.bhMin -= 20.0D;
/* 255 */         bOptions[24].changeImage("textures/oButtons/Counters/Plus.png");
/*     */       }
/* 257 */       else if (this.bhMin == 200.0D) {
/* 258 */         this.bhMin = 200.0D;
/* 259 */         bOptions[23].changeImage("textures/oButtons/Counters/sMinus.png");
/*     */       } 
/*     */       
/* 262 */       bOptions[14].changeImage("textures/oButtons/Nums/" + sInt((int)this.bhMin) + ".png");
/*     */     } 
/* 264 */     if (oCase.equals(bOptions[24])) {
/* 265 */       if (this.bhMin < 600.0D && this.bhMin >= 200.0D) {
/* 266 */         this.bhMin += 20.0D;
/* 267 */         bOptions[23].changeImage("textures/oButtons/Counters/Minus.png");
/*     */       }
/* 269 */       else if (this.bhMin == 600.0D) {
/* 270 */         this.bhMin = 600.0D;
/* 271 */         bOptions[24].changeImage("textures/oButtons/Counters/sPlus.png");
/*     */       } 
/*     */       
/* 274 */       bOptions[14].changeImage("textures/oButtons/Nums/" + sInt((int)this.bhMin) + ".png");
/*     */     } 
/* 276 */     if (oCase.equals(bOptions[25])) {
/* 277 */       if (this.bhMax <= 600.0D && this.bhMax > 200.0D) {
/* 278 */         this.bhMax -= 20.0D;
/* 279 */         bOptions[26].changeImage("textures/oButtons/Counters/Plus.png");
/*     */       }
/* 281 */       else if (this.bhMax == 200.0D) {
/* 282 */         this.bhMax = 200.0D;
/* 283 */         bOptions[25].changeImage("textures/oButtons/Counters/sMinus.png");
/*     */       } 
/*     */       
/* 286 */       bOptions[15].changeImage("textures/oButtons/Nums/" + sInt((int)this.bhMax) + ".png");
/*     */     } 
/* 288 */     if (oCase.equals(bOptions[26])) {
/* 289 */       if (this.bhMax < 600.0D && this.bhMax >= 200.0D) {
/* 290 */         this.bhMax += 20.0D;
/* 291 */         bOptions[25].changeImage("textures/oButtons/Counters/Minus.png");
/*     */       }
/* 293 */       else if (this.bhMax == 600.0D) {
/* 294 */         this.bhMax = 600.0D;
/* 295 */         bOptions[26].changeImage("textures/oButtons/Counters/sPlus.png");
/*     */       } 
/*     */       
/* 298 */       bOptions[15].changeImage("textures/oButtons/Nums/" + sInt((int)this.bhMax) + ".png");
/*     */     } 
/*     */     
/* 301 */     if (oCase.equals(bOptions[27])) {
/* 302 */       if (this.degreeMin <= 100 && this.degreeMin > 35) {
/* 303 */         this.degreeMin -= 5;
/* 304 */         bOptions[28].changeImage("textures/oButtons/Counters/Plus.png");
/*     */       }
/* 306 */       else if (this.degreeMin == 35) {
/* 307 */         this.degreeMin = 35;
/* 308 */         bOptions[27].changeImage("textures/oButtons/Counters/sMinus.png");
/*     */       } 
/*     */       
/* 311 */       bOptions[16].changeImage("textures/oButtons/Nums/" + sInt(this.degreeMin) + ".png");
/*     */     } 
/* 313 */     if (oCase.equals(bOptions[28])) {
/* 314 */       if (this.degreeMin < 100 && this.degreeMin >= 35) {
/* 315 */         this.degreeMin += 5;
/* 316 */         bOptions[27].changeImage("textures/oButtons/Counters/Minus.png");
/*     */       }
/* 318 */       else if (this.degreeMin == 100) {
/* 319 */         this.degreeMin = 100;
/* 320 */         bOptions[28].changeImage("textures/oButtons/Counters/sPlus.png");
/*     */       } 
/*     */       
/* 323 */       bOptions[16].changeImage("textures/oButtons/Nums/" + sInt(this.degreeMin) + ".png");
/*     */     } 
/* 325 */     if (oCase.equals(bOptions[29])) {
/* 326 */       if (this.degreeMax <= 100 && this.degreeMax > 35) {
/* 327 */         this.degreeMax -= 5;
/* 328 */         bOptions[30].changeImage("textures/oButtons/Counters/Plus.png");
/*     */       }
/* 330 */       else if (this.degreeMax == 35) {
/* 331 */         this.degreeMax = 35;
/* 332 */         bOptions[29].changeImage("textures/oButtons/Counters/sMinus.png");
/*     */       } 
/*     */       
/* 335 */       bOptions[17].changeImage("textures/oButtons/Nums/" + sInt(this.degreeMax) + ".png");
/*     */     } 
/* 337 */     if (oCase.equals(bOptions[30])) {
/* 338 */       if (this.degreeMax < 100 && this.degreeMax >= 35) {
/* 339 */         this.degreeMax += 5;
/* 340 */         bOptions[29].changeImage("textures/oButtons/Counters/Minus.png");
/*     */       }
/* 342 */       else if (this.degreeMax == 100) {
/* 343 */         this.degreeMax = 100;
/* 344 */         bOptions[30].changeImage("textures/oButtons/Counters/sPlus.png");
/*     */       } 
/*     */       
/* 347 */       bOptions[17].changeImage("textures/oButtons/Nums/" + sInt(this.degreeMax) + ".png");
/*     */     } 
/* 349 */     if (oCase.equals(bOptions[31])) {
/* 350 */       if (this.iterationNum <= 14 && this.iterationNum > 6) {
/* 351 */         this.iterationNum--;
/* 352 */         bOptions[32].changeImage("textures/oButtons/Counters/Plus.png");
/*     */       }
/* 354 */       else if (this.iterationNum == 6) {
/* 355 */         this.iterationNum = 6;
/* 356 */         bOptions[31].changeImage("textures/oButtons/Counters/sMinus.png");
/*     */       } 
/*     */       
/* 359 */       bOptions[18].changeImage("textures/oButtons/Nums/" + sInt(this.iterationNum) + ".png");
/*     */     } 
/* 361 */     if (oCase.equals(bOptions[32])) {
/* 362 */       if (this.iterationNum < 14 && this.iterationNum >= 6) {
/* 363 */         this.iterationNum++;
/* 364 */         bOptions[31].changeImage("textures/oButtons/Counters/Minus.png");
/*     */       }
/* 366 */       else if (this.iterationNum == 14) {
/* 367 */         this.iterationNum = 14;
/* 368 */         bOptions[32].changeImage("textures/oButtons/Counters/sPlus.png");
/*     */       } 
/*     */       
/* 371 */       bOptions[18].changeImage("textures/oButtons/Nums/" + sInt(this.iterationNum) + ".png");
/*     */     } 
/* 373 */     if (oCase.equals(bOptions[33])) {
/* 374 */       bShow(34); bShow(35); bShow(36); this.colorChanger = 1;
/* 375 */       bOptions[33].changeImage("textures/oButtons/null_focus.png");
/*     */     } 
/* 377 */     if (oCase.equals(bOptions[34])) {
/* 378 */       bShow(33); bShow(35); bShow(36); this.colorChanger = 2;
/* 379 */       bOptions[34].changeImage("textures/oButtons/null_focus.png");
/*     */     } 
/* 381 */     if (oCase.equals(bOptions[35])) {
/* 382 */       bShow(34); bShow(33); bShow(36); this.colorChanger = 3;
/* 383 */       bOptions[35].changeImage("textures/oButtons/null_focus.png");
/*     */     } 
/* 385 */     if (oCase.equals(bOptions[36])) {
/* 386 */       bShow(34); bShow(35); bShow(33); this.colorChanger = 4;
/* 387 */       bOptions[36].changeImage("textures/oButtons/null_focus.png");
/*     */     } 
/* 389 */     if (oCase.equals(bOptions[5])) {
/* 390 */       Main.fNook.Switch(0);
/*     */     }
/* 392 */     if (oCase.equals(bOptions[11])) {
/* 393 */       if (this.rDegree) { this.degreeMin = 35; this.degreeMax = 100; }
/* 394 */        if (this.rHeight) { this.bhMin = 200.0D; this.bhMax = 600.0D; }
/* 395 */        if (this.rRadius) { this.brMin = 7.0D; this.brMax = 18.0D; }
/* 396 */        if (this.rColor) { this.branchLeft = Color.orange;
/* 397 */         this.branchRight = Color.lightGray;
/* 398 */         this.leafLeft = Color.yellow;
/* 399 */         this.leafRight = Color.green; }
/* 400 */        Main.fNook.Generate(this.iterationNum, this.brMin, this.brMax, this.bhMin, this.bhMax, this.degreeMin, this.degreeMax, this.branchLeft, this.branchRight, this.leafLeft, this.leafRight);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(MouseEvent e) {
/* 407 */     if (this.colorChanger != 0)
/*     */       try {
/* 409 */         Robot cRobot = new Robot();
/* 410 */         Color grabbedColor = cRobot.getPixelColor(e.getXOnScreen(), e.getYOnScreen());
/* 411 */         switch (this.colorChanger) {
/*     */           case 1:
/* 413 */             bOptions[33].setBackground(grabbedColor);
/* 414 */             this.colorChanger = 0; bShow(33);
/* 415 */             this.branchLeft = grabbedColor;
/*     */             break;
/*     */           case 2:
/* 418 */             bOptions[34].setBackground(grabbedColor);
/* 419 */             this.colorChanger = 0; bShow(34);
/* 420 */             this.branchRight = grabbedColor;
/*     */             break;
/*     */           case 3:
/* 423 */             bOptions[35].setBackground(grabbedColor);
/* 424 */             this.colorChanger = 0; bShow(35);
/* 425 */             this.leafLeft = grabbedColor;
/*     */             break;
/*     */           case 4:
/* 428 */             bOptions[36].setBackground(grabbedColor);
/* 429 */             this.colorChanger = 0; bShow(36);
/* 430 */             this.leafRight = grabbedColor;
/*     */             break;
/*     */         } 
/* 433 */       } catch (AWTException ex) {} 
/*     */   }
/*     */   
/*     */   public void mousePressed(MouseEvent e) {}
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {}
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */ }


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Builder\wOptions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */