import java.util.Arrays;

class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    // Конструктор
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Заполнение матрицы значениями
    public void setValues(double[][] values) {
        if (values.length != rows || values[0].length != cols) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        this.data = values;
    }

    // Вывод матрицы
    public void print() {
        for (double[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Сложение матриц
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }
        Matrix result = new Matrix(rows, cols);
// Цикл для прохода по элементам массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    // Умножение на число
    public Matrix multiplyByNumber(double number) {
        Matrix result = new Matrix(rows, cols);
// Цикл для прохода по элементам массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] * number;
            }
        }
        return result;
    }

    // Умножение матриц
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно быть равно числу строк второй матрицы");
        }
        Matrix result = new Matrix(this.rows, other.cols);
// Цикл для прохода по элементам массива
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setValues(new double[][]{{1, 2}, {3, 4}});
        
        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setValues(new double[][]{{5, 6}, {7, 8}});
        
        System.out.println("Матрица 1:");
        matrix1.print();
        
        System.out.println("Матрица 2:");
        matrix2.print();
        
        Matrix sum = matrix1.add(matrix2);
// Вывод суммы на экран
        System.out.println("Сумма матриц:");
        sum.print();
        
        Matrix multipliedByNumber = matrix1.multiplyByNumber(2);
        System.out.println("Матрица 1, умноженная на 2:");
        multipliedByNumber.print();
        
        Matrix product = matrix1.multiply(matrix2);
        System.out.println("Произведение матриц:");
        product.print();
    }
}
