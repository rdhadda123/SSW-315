public class ImageHelper {
    public static boolean validMatrix(int[][] matrix){
        if ((matrix.length == matrix[0].length) && (matrix.length >= 1 && matrix.length <= 1000))
            return true;

        return false;
    }

    public static void flipVertical(int[][] matrix){
        if (validMatrix(matrix)){
            for (int x = 0; x < matrix.length / 2; x++){
                for (int y = 0; y < matrix.length; y++){
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[matrix.length - 1 - x][y];
                    matrix[matrix.length - 1 - x][y] = temp;
                }
            }
        }
    }

    public static void flipHorizontal(int[][] matrix){
        if (validMatrix(matrix)){
            for (int x = 0; x < matrix.length; x++){
                for (int y = 0; y < matrix.length / 2; y++){
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[x][matrix.length - 1 - y];
                    matrix[x][matrix.length - 1 - y] = temp;
                }
            }
        }
    }

    public static void rotateClockwise(int[][] matrix){
        if (validMatrix(matrix)){
            for (int x = 0; x < matrix.length / 2; x++){
                for (int y = x; y < matrix.length - 1 - x; y++){
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[matrix.length - 1 - y][x];
                    matrix[matrix.length - 1 - y][x] = matrix[matrix.length - 1 - x][matrix.length - 1 - y];
                    matrix[matrix.length - 1 - x][matrix.length - 1 - y] = matrix[y][matrix.length - 1 - x];
                    matrix[y][matrix.length - 1 - x] = temp;
                }
            }
        }   
    }

    public static void rotateCounterClockwise(int[][] matrix){
        if (validMatrix(matrix)){
            for (int x = 0; x < matrix.length / 2; x++){
                for (int y = x; y < matrix.length - 1 - x; y++){
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[y][matrix.length - 1 - x];
                    matrix[y][matrix.length - 1 - x] = matrix[matrix.length - 1 - x][matrix.length - 1 - y];
                    matrix[matrix.length - 1 - x][matrix.length - 1 - y] = matrix[matrix.length - 1 - y][x];
                    matrix[matrix.length - 1 - y][x] = temp;
                }
            }
        }
    }
}