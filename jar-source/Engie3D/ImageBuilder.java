package Engie3D;

import java.awt.Image;

public interface ImageBuilder {
  void init(Solid paramSolid, Vector paramVector, int paramInt1, int paramInt2);
  
  void add(Triangle paramTriangle);
  
  Image getResult();
}


/* Location:              D:\BRIDGE\local Git\Fractal-Tree-Generator-1.0\Tree.jar!\Engie3D\ImageBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */