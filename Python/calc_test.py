from matcalc import*

def assert_vec(op,res,i):
    """Assertion and printing of vector"""
    assert op == res
    if i == 1:
        printv(op)
    else:
        print(op)
    print("")

def assert_mat(op,res,i):
    """Assertion and printing of matrix"""
    for row in op:
        for col in range(len(row)):
            row[col] = round(row[col],1)
    assert op == res
    printm(op)
    if i != 2:
        print(" ")

def vector(v1,v2):
    """Output for vectors"""
    # Assertion cases for each method
    assert_vec(Sum(v1,v2),[5,7,9],1)
    assert_vec(diff(v2,v1),[3,3,3],1)
    assert_vec(sca_prod(v1,3),[3,6,9],1)
    assert_vec(cross(v1,v2),[-3,6,-3],1)
    assert_vec(dot(v1,v2),32,2)

def matrix(m1,m2,m3,m4):
    """Output for matrices"""
    # Results calculated using matrixcalc.org
    res1 = [[2, 5, 7],[6,10, 12],[8, 10, 13]]
    res2 = [[0, -1, -1],[2, 0, 0],[6, 6, 5]]
            [7.0, 4.0, 2.2]]
    res3 = [[2, 4, 6],[8, 10, 12],[14, 16, 18]]
    res4 = [[30, 36, 42],[66, 81, 96],[102, 126, 150]]
    res5 = [[8, 19, 28],[20, 49, 70],[32, 79, 112]]
    res6 = [[114, 160, 60, 27],[74, 97, 73, 14],
            [119, 157, 112, 23]]

    # Assertion cases for each method
    assert_mat(add(m1,m2),res1,1)
    assert_mat(sub(m1,m2),res2,1)
    assert_mat(sca_mult(m1,2),res3,1)
    assert_mat(Pow(m1,2),res4,1)
    assert_mat(mult(m1,m2),res5,1)
    assert_mat(mult(m3,m4),res6,2)

def main():
    # Vectors
    v1 = [1,2,3]
    v2 = [4,5,6]
    
    # Matrices
    m1 = [[1,2,3],[4,5,6],[7,8,9]]
    m2 = [[1,3,4],[2,5,6],[1,2,4]]
    m3 = [[12,7,3],[4 ,5,6],[7 ,8,9]]
    m4 = [[5,8,1,2],[6,7,3,0],[4,5,9,1]]
    
    vector(v1,v2)
    matrix(m1,m2,m3,m4)
    
if __name__ == "__main__":
    main()
