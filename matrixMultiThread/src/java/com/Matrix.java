package java.com;

public class Matrix implements Runnable {

    int[][] matrix1 = {{1, 2, 3},
            {1, 2, 3}};
    int[][] matrix2 = {{1, 2},
            {2, 1},
            {3, 2}};
    int[][] matrixResult = new int[matrix1.length][matrix2[0].length];

    @Override
    public void run() {
        for (int row = 0; row < matrixResult.length; row++) {
            for (int column = 0; column < matrixResult[row].length; column++) {

                // using multiplyMatricesCell method for multiplication
                matrixResult[row][column] = multiplyMatricesCell(matrix1, matrix2, row, column);

                //printing matrixResult
                for (int i = 0; i < matrixResult.length; i++) {
                    for (int j = 0; j < matrixResult[i].length; j++) {
                        System.out.print(matrixResult[i][j] + " ");
                    }
                    //Go to the next line
                    System.out.println();
                }

                System.out.println("matrix \t" + Thread.currentThread()
                        .getName() );
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    int multiplyMatricesCell(int[][] firstMatrix, int[][] secondMatrix, int row, int col) {
        int temp = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            temp += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return temp;
    }
}
