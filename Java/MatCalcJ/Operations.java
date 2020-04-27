package MatcalcJ; 
import java.util.*; 

public class Operations { 

  // Vector operations 

  /* Addition of two vectors */
  public double[] sum(double[] v1, double[] v2) {
    return _vecOp(v1, v2, 1, "+");
  }

  /* Subtraction of two vectors */
  public double[] diff(double[] v1, double[] v2) {
    return _vecOp(v1, v2, 1, "-");
  }

  /* Scalar multiplication of vector */
  public double[] scaProd(double[] v, double k) {
    return _vecOp(v, v, k, "*s");
  }

  /* Dot product of two vectors */
  public double dot(double[] v1, double[] v2) {
    double prod = 0; int n = v1.length; 
    if (n == v2.length)
      for (int i = 0; i < n; i++)  {
        prod += v1[i]*v2[i]; 
      }    
    return prod; 
  }

  /* Cross product of two vectors */
  public double[] cross(double[] v1, double[] v2) {
    int n = v1.length;
    double prod[] = new double[n];
    if  (n == 3 && v2.length == 3)
      prod[0] = v1[1]*v2[2] - v1[2]*v2[1]; 
      prod[1] = v1[2]*v2[0] - v1[0]*v2[2]; 
      prod[2] = v1[0]*v2[1] - v1[1]*v2[0]; 
    return prod; 
  }

  // Matrix operations 

  /* Addition of two matrices */
  public double[][] add(double[][] m1, double[][] m2) {
    return _operation(m1,m2,"+",0);  
  }
  
  /* Subtraction of two matrices */
  public double[][] sub(double[][] m1, double[][] m2) {
    return _operation(m1,m2,"-",0);
  }
  
  /* Scalar multiplication of matrix */
  public double[][] scaMult(double[][] m, double k) {
    return _operation(m,m,"*s",k);
  }
  
  /* Matrix power of degree n */
  public double[][] pow(double[][] m, int n) {
    if ( n == 0 ) {
      return m;
    }
    return (mult(m,pow(m,n-1)));
  }
    
  /* Matrix multiplication */
  public double[][] mult(double[][] m1,
  double[][] m2) {
    double[][] res = new double[m1.length][m2[0].length];
    for(int i=0;i<m1.length;i++){
      for(int j=0;j<m2[0].length;j++){
        for(int k=0;k<m2.length;k++) {
          res[i][j] += m1[i][k]*m2[k][j];
        }
      }
    }
    return res;
  }
  
  /* Transpose of matrix */
  public double[][] trsp(double[][] m) {
    int n = m[0].length; 
    int M = m.length;
    double T[][]=new double[n][M]; 
    for(int i=0;i<n;i++){    
      for(int j=0;j<M;j++){  
        T[i][j]=m[j][i];  
      }
    }
    return T;
  }

  /* Determinant of matrix */
  public double det(double[][] m) {  
    int n = m[0].length;
    return _det(m,n);
  }
  
  /* Inverse of matrix */
  public double[][] inv(double[][] m) {
    int n = m[0].length;
    double det = _det(m,n);
        
    double[][] adj  = new double[n][n];
    double[][] inv  = new double[n][n];
    double[][] Null = new double[1][0];
        
    if (det == 0) {
      System.out.print("Non-invertable matrix");
      return Null;
    }
        
    if (n == 1) {
      adj[0][0] = 1;
    }
    _adjoint(m, adj, n);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        inv[i][j] = adj[i][j]/det; 
      }    
    }
    return inv;
  }

  /* Row-reduced echelon form of matrix */
  public double[][] rref(double m[][]) { 
    int n = m.length;
    int M = m[0].length;
    if (n == M) {
      for (int i=0;i<n;i++) {
        double[] temp = Arrays.copyOf(m[i], n+1);
        temp[n] = 0; m[i] = temp; 
      }

      _rref(m,n,M); 
      for (int i=0;i<n;i++) {
        double[] temp = Arrays.copyOf(m[i], n);
        m[i] = temp; 
      }
    }

    else if (n != M) {
      _rref(m,n,M);  
    }
    return m; 
  }   

  // Display methods

  /* Printing elements of matrix */
  public void printM(double[][] m) {
    int n = m.length;
    int M = m[0].length;
    for(int i=0;i<n;i++) {    
      for(int j=0;j<M;j++) {    
        m[i][j] = Math.round(m[i][j]*10.0)/10.0;
      }
    }
    for (double[] row: m) {
      System.out.println(Arrays.toString(row));
    }
    
  }

  /* Printing elements of vector */
  public void printV(double[] v) {
    int n = v.length;
    for(int i=0;i<n;i++) { 
      v[i] = Math.round(v[i]*10.0)/10.0; 
    }
    System.out.println(Arrays.toString(v));
  }

  // Private methods 
    
  /* Generalized function for basic vector operations */
  private double[] _vecOp(double[] v1,
  double[] v2, double k, String op) { 
    int n = v1.length; 
    double[] res = new double[n];
    if (n == v2.length) {
      for (int i = 0; i < n; i++)  {
        Hashtable<String, Double> tab 
        = new Hashtable<String,Double>();
        tab.put("+", v1[i]+v2[i]);
        tab.put("-", v1[i]-v2[i]);
        tab.put("*s", v1[i]*k);
        res[i] = tab.get(op);
      }  
    }
    return res; 
  }

  /* Generalized function for basic matrix operations */
  private double[][] _operation(double[][] m1,
  double[][] m2, String op, double k) {
    int n = m1.length;
    double res[][]=new double[n][n]; 
    if (n == m2.length) {
      for(int i=0;i<n;i++){    
        for(int j=0;j<n;j++){   
          Hashtable<String, Double> tab 
          = new Hashtable<String, Double>();
          tab.put("+", m1[i][j]+m2[i][j]);
          tab.put("-", m1[i][j]-m2[i][j]);
          tab.put("*s", m1[i][j]*k);
          res[i][j] = tab.get(op);
        }    
      }
    }
    return res;
  }

  /* Calculation of matrix cogfactors */
  private void _getCofact(double m[][],
  double cofact[][], int i, int j, int n) {
    int k = 0; int l= 0; 
    for (int row = 0; row < n; row++) { 
      for (int col = 0; col < n; col++) { 
        if (col != j && row != i) { 
          cofact[k][l++] = m[row][col]; 
          if (l == n-1) { 
            k++; 
            l = 0; 
          } 
        } 
      } 
    } 
  }
  
  /* Recursive calculation of matrix determinant */
  /* utilizing cofactors */
  private double _det(double m[][], int n) {  
    double Det = 0; 
    double sgn = 1;  
    if (n == 1) {
      return m[0][0]; 
    }
    double cofact[][] = new double[n][n];  
          
    for (int i = 0; i < n; i++) { 
      _getCofact(m, cofact,0,i,n);
            
      Det += sgn * m[0][i]
      * _det(cofact, n - 1); 
      sgn = -sgn; 
    }    
    return Det; 
  } 

  /* Adjoint of matrix utilizing cofactors */
  private void _adjoint(double m[][],double[][] adj, int n) {
    double sgn = 1;
    double [][] cofact = new double[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        _getCofact(m,cofact,i,j,n);
        sgn = (i+j) % 2 == 0? 1: -1;
        adj[j][i] = sgn * _det(cofact,n-1);
      }
    }       
  }

  /* Row reduction algorithm utilizing /*
  /* Gauss-Jordan elimination */
  private void _rref(double m[][], int n, int M) {
    int i, j, k, l = 0; 
    double[] dia = {};
        
    for (i = 0; i < n; i++) { 
      if (m[i][i] == 0) { 
        l = 1; 
        while ((l+i) < n && m[l+i][i] == 0)  
          l++;  
        if ((i+1) == n) {
          break;
        }
        for ( k = 0; k <= n; k++) { 
          double temp = m[i][k]; 
          m[i][k] = m[l+i][k]; 
          m[l+i][k] = temp; 
        } 
      } 
  
      for (j = 0; j < n; j++)  { 
        if (i != j)  { 
          double d = m[j][i] / m[i][i]; 
          for (k = 0; k <= n; k++) {                
            m[j][k] -= d*m[i][k]; 
          }
        } 
      } 
    } 
        
    for (i = 0; i < n; i++) {
      dia = Arrays.copyOf(dia, dia.length + 1);
      dia[dia.length - 1] = m[i][i];
      if (m[i][i] != 0) {
        for (j = n; j < M; j++) {
          m[i][j] /= dia[i];
        }
      }
    }
        
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        if (m[i][j] != 0 && i != j) {
          m[i][j] /= dia[i];
        }
      }
    }       
  } 
} 
