# Vector operations
def Sum(v1, v2):
    """Addition of two vectors"""
    return _vec_op(v1,v2,1,"+")
    
def diff(v1, v2):
    """Subtraction of two vectors"""
    return _vec_op(v1,v2,1,"-")
    
def sca_prod(v, k):
    """Scalar multiplication of vector"""
    """with constant k"""
    return _vec_op(v,v,k,"*s")

def dot(v1,v2):
  """Dot product of two vectors"""
  n = len(v1)
  prod = 0
  if n == len(v2):
    for i in range(n):
      prod += v1[i]*v2[i]
  return prod

def cross(v1, v2):
    """Cross product of two vectors"""
    n = len(v1)
    prod = n*[0]
    if n == 3 and len(v2) == 3:
        prod[0] = v1[1]*v2[2] - v1[2]*v2[1]
        prod[1] = v1[2]*v2[0] - v1[0]*v2[2]
        prod[2] = v1[0]*v2[1] - v1[1]*v2[0]
    return prod 

#Matrix operations 
def add(m1, m2):
    """Addition of two metrices"""
    return _operation(m1,m2,"+",1)  
    
def sub(m1, m2):
    """Subtraction of two matrices"""
    return _operation(m1,m2,"-",1)

def sca_mult(m,k):
    """Scalar multiplication of matrix"""
    """with constant k"""  
    return _operation(m,m,"*s",k) 

def Pow(m, n):
    """Matrix power of degree n"""
    if n == 0:
        return m
    return mult(m,Pow(m,n-1))

def mult(m1,m2):
    """Matrix multiplication"""
    res = [len(m2[0])*[0] for i in range(len(m1))]
    for i in range(len(m1)):
        for j in range(len(m2[0])):
            for k in range(len(m2)):
                res[i][j] += m1[i][k]*m2[k][j]
    return res
  
def trsp(m):
    """Transpose of matrix"""
    M = len(m[0])
    n = len(m)
    T = [n*[0] for i in range(M)]
    for i in range(n):
        for j in range(M):
           T[j][i] = m[i][j]
    return T

def det(m):
    """Determinant of matrix"""
    n = len(m[0])
    return _det(m, n) 

def inv(m):
    """Inverse of matrix"""
    n = len(m[0])
    det = _det(m,n)
    adj  = [n*[0] for i in range(n)]
    inv  = [n*[0] for i in range(n)]
    null = None
    
    if det == 0:
        print("Non-invertable matrix")
        return null
    if n == 1:
        adj[0][0] = 1
    _adjoint(m,adj,n)
    
    for i in range(n):
        for j in range(n):
            inv[i][j] = adj[i][j]/det
    return inv

def rref(m):
    """Row reduced echelon form of matrix"""
    n = len(m)
    M = len(m[0])
    if n == M:
        for row in m:
            row.append(0)
        _rref(m,n,M)
        for row in m:
            row.pop()         
    elif n != M:
        _rref(m,n,M)
    return m

# Display of datatypes
def printm(m):
    """Printing elements of matrix"""
    for row in m:
        i = [round(elem,2) for elem in row]
        print(i)

def printv(v):
  """Printing elements of vector"""
  print([round(elem,2) for elem in v])

# Private methods
def _vec_op(v1,v2,k,op):
    """Generalized function for basic"""
    """vector operations"""
    n = len(v1)
    res = [0]*n
    if n == len(v2):
        for i in range(n):
            tab = {
            "+" : v1[i]+v2[i],
            "*s": v1[i]*k,
            "-" : v1[i]-v2[i]
            }
        res[i] = tab[op]
    return res 

def _operation(m1, m2, op, k):
    """Generalized function for basic""" 
    """matrix operations"""
    n = len(m1)
    res = [n*[0] for i in range(n)]
    if n == len(m2):
        for i in range(n):
            for j in range(n):
                tab = {
                "+" : m1[i][j]+m2[i][j], 
                "-" : m1[i][j]-m2[i][j],
                "*s": m1[i][j]*k,
                }
        res[i][j] = tab[op]
    return res

def _get_cofact(m,cofact,i,j,n):
    """Calculation of matrix cofactors"""
    k = 0
    l = 0
    for row in range(n):
        for col in range(n):
            if col != j and row != i:
                cofact[k][l] = m[row][col]
                l += 1
                if l == n-1:
                    k += 1
                    l = 0

def _det(m, n):
    """Recursive calculation of matrix determinant"""
    """utilizing cofactors"""
    sgn = 1
    Det = 0 
    if n == 1:
        return m[0][0]
    cofact = [n*[0] for i in range(n)]
    for i in range(n):
        _get_cofact(m, cofact,0,i,n);    
        Det += sgn*m[0][i]*_det(cofact, n - 1); 
        sgn = -sgn; 
    return Det

def _adjoint(m,adj,n):
    """Adjoint of matrix utilizing cofactors"""
    sgn = 1
    cofact = [n*[0] for i in range(n)]
    for i in range(n):
        for j in range(n):
            _get_cofact(m,cofact,i,j,n)
            sgn = 1 if (i+j) % 2 == 0 else -1
            adj[j][i] = sgn*_det(cofact,n-1)

def _rref(m,n,M):
    """Row-rediction algorithm utilizing"""
    """Gauss-Jordan elimination"""
    l = 0
    dia = []
    for i in range(n):
        if m[i][i] == 0:
            l = 1
            while (l+i) < n and m[l+i][i] == 0:
               l += 1
            if i+l == n:
                break
            for k in range(n+1):
                temp = m[i][k] 
                m[i][k] = m[l+i][k]
                m[l+i][k] = temp
    
        for j in range(n):
            if i != j:
                d = m[j][i]/m[i][i]
                for k in range(n+1):
                    m[j][k] -= d*m[i][k]
                    
    for i in range(n):
        dia.append(m[i][i])
        if m[i][i] != 0:
            for j in range(n,M):
                m[i][j] /= dia[i]
            m[i][i] = 1
            
    for i in range(n):
        for j in range(n):
            if m[i][j] != 0 and i != j:
                m[i][j] /= dia[i]

    for row in m:
        count = []
        for elem in row:
            count.append(elem)
        if count[0:n] == n*[0]:
            m.remove(count)
                        
def main():
    return

if __name__ == "__main__":
  main()
