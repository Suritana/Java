public class Table {
    private int[][] data;
    private int rows;
    private int cols;


    public Table(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = 0;
            }
        }
    }


    public int getValue(int row, int col) {
        checkIndexes(row, col);
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        checkIndexes(row, col);
        data[row][col] = value;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public double average() {
        if (rows == 0 || cols == 0) {
            return 0.0;
        }

        int sum = 0;
        int totalElements = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j];
            }
        }

        return (double) sum / totalElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]);
                if (j < cols - 1) {
                    sb.append("\t");
                }
            }
            if (i < rows - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private void checkIndexes(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException(
                    String.format("Индексы [%d][%d] выходят за границы таблицы [%d][%d]",
                            row, col, rows, cols)
            );
        }
    }
}