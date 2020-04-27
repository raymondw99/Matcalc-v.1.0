import MatcalcJ.*; 

public class CalcTest { 
  /* Assertion and printing of vector */
  public static void assertVec(double[] op, 
  double[] res) {
    Operations McJ = new Operations();
    assert op == res;
    McJ.printV(op);
    System.out.println(" ");
  }
  
  /* Assertion and printing of matrices */
  public static void assertMat(double[][] op, 
  double[][] res, int i, Operations McJ) {
    assert op == res;
    McJ.printM(op);
    if (i != 2) {
      System.out.println("");
    }
  }
  
  /* Output for vectors */
  public static void vector(double[] v1, double[] v2){
    Operations McJ = new Operations();
    double[] res1 = {5,7,9}; double[] res2 = {3,3,3};
    double[] res3 = {3,6,9}; double[] res4 = {-3,6,-3};
    assertVec(McJ.sum(v1,v2),res1);
    assertVec(McJ.diff(v2,v1),res2);
    assertVec(McJ.scaProd(v1,3),res3);
    assertVec(McJ.cross(v1,v2),res4); 
    assert McJ.dot(v1,v2) == 32;
    System.out.printf("%.1f ",McJ.dot(v1,v2));
    System.out.println(" ");
  }
  
  /* Output for matrices */
  public static void matrix(double[][] m1, 
    double[][] m2, double[][] m3,
    double[][] m4,Operations McJ) {
    
    // Results calculated using Matrixcalc.org
    double[][] res1 = {{2, 5, 7},{6,10, 12},
                      {8, 10, 13}};
    double[][] res2 = {{0, -1, -1},{2, 0, 0},
                      {6, 6, 5}};
    double[][] res3 = {{2, 4, 6},{8, 10, 12},
                      {14, 16, 18}};
    double[][] res4 = {{30, 36, 42},{66, 81, 96},
                      {102, 126, 150}};
    double[][] res5 = {{8, 19, 28},{20, 49, 70},
                      {32, 79, 112}};
    double[][] res6 = {{114, 160, 60, 27},
                      {74, 97, 73, 14},
                      {119, 157, 112, 23}};
    
    assertMat(McJ.add(m1,m2),res1,1,McJ);
    assertMat(McJ.sub(m1,m2),res2,1,McJ);
    assertMat(McJ.scaMult(m1,2),res3,1,McJ);
    assertMat(McJ.pow(m1,2),res4,1,McJ);
    assertMat(McJ.mult(m1,m2),res5,1,McJ);
    assertMat(McJ.mult(m3,m4),res6,2,McJ);
  }
  
  /* Output */
  public static void main(String[] args){ 
    Operations McJ = new Operations();
    // Vectors
    double[] v1 = {1,2,3};
    double[] v2 = {4,5,6};
    
    // Matrices
    double[][] m1 = {{1,2,3},{4,5,6},{7,8,9}};
    double[][] m2 = {{1,3,4},{2,5,6},{1,2,4}};
    double[][] m3 = {{12,7,3},{4 ,5,6},{7,8,9}};
    double[][] m4 = {{5,8,1,2},{6,7,3,0},{4,5,9,1}};
    
    vector(v1,v2);
    matrix(m1,m2,m3,m4)M
      
    } 
} 
