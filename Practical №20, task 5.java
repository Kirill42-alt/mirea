// Объявление публичного класса
public class Matrix<T extends Number> {
    private final int rows;
    private final int cols;
    private final Number[][] data;

    // Конструктор на основе двумерного массива
    public Matrix(Number[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new Number[rows][cols];

// Цикл для прохода по элементам массива
        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) {
                throw new IllegalArgumentException("Все строки должны иметь одинаковую длину");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    // Метод сложения матриц
    public Matrix<Double> add(Matrix<? extends Number> other) {
        checkSameSize(other);
        Number[][] result = new Number[rows][cols];

// Цикл для прохода по элементам массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j].doubleValue() + other.data[i][j].doubleValue();
            }
        }

        return new Matrix<>(result);
    }

    // Метод вычитания матриц
    public Matrix<Double> subtract(Matrix<? extends Number> other) {
        checkSameSize(other);
        Number[][] result = new Number[rows][cols];

// Цикл для прохода по элементам массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j].doubleValue() - other.data[i][j].doubleValue();
            }
        }

        return new Matrix<>(result);
    }

    // Метод умножения на скаляр
    public Matrix<Double> multiplyByScalar(Number scalar) {
        Number[][] result = new Number[rows][cols];

// Цикл для прохода по элементам массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j].doubleValue() * scalar.doubleValue();
            }
        }

        return new Matrix<>(result);
    }

    // Метод умножения двух матриц
    public Matrix<Double> multiply(Matrix<? extends Number> other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Несовместимые размеры матриц для умножения");
        }

        Number[][] result = new Number[this.rows][other.cols];

// Цикл для прохода по элементам массива
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
// Прибавление текущего элемента массива к сумме
                    sum += this.data[i][k].doubleValue() * other.data[k][j].doubleValue();
                }
                result[i][j] = sum;
            }
        }

        return new Matrix<>(result);
    }

    // Вывод матрицы на экран
    public void print() {
// Цикл для прохода по элементам массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%10.2f ", data[i][j].doubleValue());
            }
            System.out.println();
        }
    }

    // Проверка на совпадение размеров
    private void checkSameSize(Matrix<?> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}


// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Number[][] data1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Number[][] data2 = {
                {7, 8, 9},
                {10, 11, 12}
        };

        Number[][] data3 = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        Matrix<Number> matrix1 = new Matrix<>(data1);
        Matrix<Number> matrix2 = new Matrix<>(data2);
        Matrix<Number> matrix3 = new Matrix<>(data3);

        System.out.println("Матрица 1:");
        matrix1.print();

        System.out.println("\nМатрица 2:");
        matrix2.print();

        System.out.println("\nСложение матриц 1 и 2:");
        Matrix<Double> sum = matrix1.add(matrix2);
        sum.print();

        System.out.println("\nВычитание матриц 1 и 2:");
        Matrix<Double> diff = matrix1.subtract(matrix2);
        diff.print();

        System.out.println("\nУмножение матрицы 1 на скаляр 2:");
        Matrix<Double> scalarMult = matrix1.multiplyByScalar(2);
        scalarMult.print();

        System.out.println("\nУмножение матрицы 1 на матрицу 3:");
        Matrix<Double> mult = matrix1.multiply(matrix3);
        mult.print();
    }
}
