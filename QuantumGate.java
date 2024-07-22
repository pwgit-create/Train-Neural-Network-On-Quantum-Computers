
import java.lang.Math;
import java.util.Arrays;

public class QuantumGate {
    private double[][] matrix;

    public QuantumGate(int size) {
        this.matrix = new double[size][size];
    }

    // This method will be used to set the value of a specific cell in the quantum gate matrix.
    public void setCellValue(int row, int column, double value) {
        if (row < 0 || row >= this.matrix.length || column < 0 || column >= this.matrix[0].length) {
            throw new IndexOutOfBoundsException("Invalid cell index.");
        }
        this.matrix[row][column] = value;
    }

    // This method will be used to get the value of a specific cell in the quantum gate matrix.
    public double getCellValue(int row, int column) {
        if (row < 0 || row >= this.matrix.length || column < 0 || column >= this.matrix[0].length) {
            throw new IndexOutOfBoundsException("Invalid cell index.");
        }
        return this.matrix[row][column];
    }

    // This method will be used to calculate the matrix multiplication of two quantum gates.
    public QuantumGate multiply(QuantumGate other) {
        if (this.matrix.length != other.matrix.length || this.matrix[0].length != other.matrix[0].length) {
            throw new IllegalArgumentException("Matrices are not compatible for multiplication.");
        }
        int size = this.matrix.length;
        QuantumGate result = new QuantumGate(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += this.matrix[i][k] * other.matrix[k][j];
                }
                result.setCellValue(i, j, sum);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "QuantumGate{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
