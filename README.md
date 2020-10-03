# Matcalc v.1.0
### The ultimate matrix calculator 
Matcalc is a package for vector and matrix operations, implemented in both Python and Java. It is primarily inspired by [matrixcalc.org](https://matrixcalc.org/en/) and offers features such as vector cross products, matrix multiplications and Gauss-Jordan elimination. <br> The aim of which is to enable simple yet powerful matrix calculations.     
<p>
 <img width="400" height="250" src="https://github.com/raymondw99/Matcalc-v.1.0/blob/master/img.png">
</p>

Implemented as a final project in [DD1327 - Fundamentals of computer science](https://www.kth.se/social/course/DD1327/).

## Examples
### Python
Calculate the cross product of two vectors:
#### Code
```python
from matcalc import*
v1 = [1,2,3]
v2 = [4,5,6]
prod = add(v1,v2)
printv(prod)
```
#### Output
```python
[-3,6,-3]
```
### Java
Return the row-reduced echelon form of a matrix:
#### Code
```java
import MatcalcJ.*; 

public class Test {
    public static void main(String[] args) {
        Operations McJ = new Operations();
        double[][] m = {{1,4,-5,4},{6,4,0,6},{2,2,-1,7}};
        double[][] rref = McJ.rref(m);
        McJ.print(rref);
    }

}
```
#### Output
```java
[1,0.0,1.0,0.4]
[0.0,1,-1.5,0.9]
[0.0,0.0,0.0,4.0]
```

## API 
### Documentation 
Matrices and vectors are stored in arrays and nested arrays respectively. The Java version uses the `double` data type for matrix and vector digits. I.e.  `double[]` and `double[][]`. 

#### func sum
```
func sum(array[] v1, array[] v2) 
```
Returns the sum of two vectors.
#### func diff
```
func diff(array[] v1, array[] v2)
```
Returns the difference between two vectors.
#### func scaProd
```
func scaProd(array[] v, scalar k) 
```
Returns the product between a scalar *k* and vector *v*.
#### func dot
```
func dot(array[] v1, array[] v2) 
```
Returns the dot product between two vectors.
#### func cross
```
func cross(array[] v1, array[] v2) 
```
Returns the cross products between two vectors in **R3**.
#### func add
```
func add(array[][] m1, array[][] m2) 
```
Returns the sum of two matrices. 
#### func sub
```
func sub(array[][] m1, array[][] m2) 
```
Returns the difference between two matrices.
#### func scaMult
```
func scaMult(array[][] m, scalar k) 
```
Returns the product between a scalar *k* and matrix *m*.
#### func pow
```
func pow(array[][] m, int n) 
```
Returns the power of a matrix *m* to the *n*th degree.
#### func mult
```
func mult(array[][] m1, array[][] m2) 
```
Returns the product of two matrices (*matrix multiplication*).
#### func trsp
```
func trsp(array[][] m) 
```
Returns the transpose of a matrix. 
#### func det
```
func det(array[][] m) 
```
Returns the determinant of a matrix. 
#### func inv
```
func inv(array[][] m) 
```
Returns the inverse of a matrix. 
#### func rref
```
func rref(array[][] m) 
```
Returns the row-reduced echelon form of a matrix (*Gauss-Jordan elimination*). 
#### func printV
```
func printV(array[] v) 
```
Outputs the elements of a vector.
#### func printM
```
func printM(array[][] m) 
```
Outputs the elements of a matrix.
### Roadmap 
* The API of this library is frozen.
* Version numbers adhere to [semantic versioning](https://semver.org).

The only accepted reason to modify the API of this package is to handle issues that cannot be resolved in any other reasonable way.

Raymond Wang 2020 - [raymondw99](https://github.com/raymondw99)
  
