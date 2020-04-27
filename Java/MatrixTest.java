import MatcalcJ.*; 

public class MatrixTest {
  public static void assertMat(double[][] op1, 
  double[][] res1, double op2, double res2,
  int i, Operations McJ) {
    if (i == 2) {
      assert op2 == res2;
      System.out.println(op2);
    }
    else {
      assert op1 == res1;
      McJ.printM(op1);
    }
    if (i == 1 || i == 2);
      System.out.println("");
  }

  public static void matrix(double[][] m1,double[][] m2, 
  double[][] m3, double[][] m4, double[][] m5,
  double[][] m6,double[][] m7,double[][] m8,
  double[][] m9, Operations McJ) {
    double[][] Null = new double[1][0];
    double[][] res1 = {{12, 4, -3},{-7, 5, 8}};
    double[][] res2 = {{5, 6, 4},{-8, 7, 5},
                       {1, -3, 9},{-2, 0, -1}};
    double[][] res5 = {{1.09, -0.55, -0.09},
                       {0.23, 0.14, -0.23},
                       {-0.18, 0.09, 0.18}};
    double[][] res6 = {{0.31, 0.08, -0.0, -0.38},
                       {-0.69, 0.08, 1.0, 1.62},
                       {-0.43, 0.09, 0.6, 0.74},
                       {-0.34, 0.22, 0.4, 0.72}};
    double[][] res7 = {{1, 0.0, -1.0},
                      {0.0, 1, 2.0}};
    double[][] res8 = {{1, 0.0, 1.0, 0.4},
                       {0.0, 1, -1.5, 0.9},
                       {0.0, 0.0, 0.0, 4.0}};
    double[][] res9 = {{1, 0.0, 0.0, 2.2, 5.0, 9.0},
                       {0.0, 1, 0.0, 1.4, 1.0, 1.5},
                       {0.0, 0.0, 1, 1.2, -1.6, -0.8}};

    assertMat(McJ.trsp(m1),res1,0,0,1,McJ);
    assertMat(McJ.trsp(m2),res2,0,0,1,McJ);
    assertMat(Null,Null,McJ.det(m3),18,2,McJ);
    assertMat(Null,Null,McJ.det(m4),4,2,McJ);
    assertMat(McJ.inv(m5),res5,0,0,1,McJ);
    assertMat(McJ.inv(m5), res6,0,0,1,McJ);
    assertMat(McJ.rref(m7),res7,0,0,1,McJ);
    assertMat(McJ.rref(m8),res8,0,0,1,McJ);
    assertMat(McJ.rref(m9),res9,0,0,3,McJ);
  }

  public static void main(String[] args){ 
    Operations McJ = new Operations();
    double[][] m1 = {{12,-7},{4 ,5},{-3 ,8}};
    double[][] m2 = {{5,-8,1,-2},{6,7,-3,0},{4,5,9,-1}};
    double[][] m3 = {{-2,2,-3},{-1,1,3},{2,0,-1}};
    double[][] m4 = {{1,2},{0,4}};
    double[][] m5 = {{1,2,3},{0,4,5},{1,0,6}};
    double[][] m6 = {{3,3,-5,0},{1,-2,0,5},
                     {2,0,3,-2},{0,2,-4,1}};
    double[][] m7 = {{1,2,3},{4,5,6},{7,8,9}};
    double[][] m8 = {{1,4,-5,4},{6,4,0,6},{2,2,-1,7}};
    double[][] m9 = {{0,2,1,4,5,9},{1,1,2,6,2,3},
                     {2,1,1,7,4,2}};
    matrix(m1,m2,m3,m4,m5,m6,m7,m8,m9,McJ);
  } 
} 
