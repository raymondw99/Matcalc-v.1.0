from matcalc import*
def assert_mat(op,res,i):
    """Assertion and printing of matrix"""
    if i != 2:
        for row in op:
            for col in range(len(row)):
                row[col] = round(row[col],2)           
    assert op == res
    if i == 2:
        print(op)
    else:
        printm(op)
    if i == 1 or i == 2:
        print("")

def matrix(m1,m2,m3,m4,m5,m6,m7,m8,m9):
    """Output for matrices"""
    # Results calculated using matrixcalc.org
    res1 = [[12, 4, -3],[-7, 5, 8]]
    res2 = [[5, 6, 4],[-8, 7, 5],[1, -3, 9],
            [-2, 0, -1]]
    res3 = 18
    res4 = 4
    res5 = [[1.09, -0.55, -0.09],
            [0.23, 0.14, -0.23],
            [-0.18, 0.09, 0.18]]
    res6 = [[0.31, 0.08, -0.0, -0.38],
            [-0.69, 0.08, 1.0, 1.62],
            [-0.43, 0.09, 0.6, 0.74],
            [-0.34, 0.22, 0.4, 0.72]]
    res7 = [[1, 0.0, -1.0],
            [0.0, 1, 2.0]]
    res8 = [[1, 0.0, 1.0, 0.4],
            [0.0, 1, -1.5, 0.9]]
    res9 = [[1, 0.0, 0.0, 2.2, 5.0, 9.0],
            [0.0, 1, 0.0, 1.4, 1.0, 1.5],
            [0.0, 0.0, 1, 1.2, -1.6, -0.8]]
    
    #Assertion cases for each method
    assert_mat(trsp(m1),res1,1)
    assert_mat(trsp(m2),res2,1)
    assert_mat(det(m3),res3,2)
    assert_mat(det(m4),res4,2)
    assert_mat(inv(m5),res5,1)
    assert_mat(inv(m6),res6,1)
    assert_mat(rref(m7),res7,1)
    assert_mat(rref(m8),res8,1)
    assert_mat(rref(m9),res9,3)
    
def main():
    """Output"""
    m1 = [[12,-7],[4 ,5],[-3 ,8]]
    m2 = [[5,-8,1,-2],[6,7,-3,0],[4,5,9,-1]] 
    m3 = [[-2,2,-3],[-1,1,3],[2,0,-1]]
    m4 = [[1,2],[0,4]]
    m5 = [[1,2,3],[0,4,5],[1,0,6]]
    m6 = [[3,3,-5,0],[1,-2,0,5],[2,0,3,-2],[0,2,-4,1]]
    m7 = [[1,2,3],[4,5,6],[7,8,9]]
    m8 = [[1,4,-5,4],[6,4,0,6],[2,2,-1,7]]
    m9 = [[0,2,1,4,5,9],[1,1,2,6,2,3],[2,1,1,7,4,2]]
    matrix(m1,m2,m3,m4,m5,m6,m7,m8,m9)
    
if __name__ == "__main__":
    main()
