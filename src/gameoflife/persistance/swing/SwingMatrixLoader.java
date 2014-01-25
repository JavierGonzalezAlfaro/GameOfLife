package gameoflife.persistance.swing;

import gameoflife.model.Cell;
import gameoflife.model.Matrix;
import gameoflife.persistance.MatrixLoader;

public class SwingMatrixLoader implements MatrixLoader {

    @Override
    public Matrix load(int width, int height) {
        Cell[][] matriz = new Cell[width][height];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (Math.random() < 0.5) {
                    matriz[i][j] = new Cell(true);
                } else {
                    matriz[i][j] = new Cell(false);
                }
            }
        }
        Matrix matrix = new Matrix(matriz);
        return matrix;
    }

    public Matrix loadBlank(Matrix matrix) {
        for (int i = 0; i < matrix.getHeigth(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                matrix.setCell(i, j, false);
            }
        }
        return matrix;
    }

    public Matrix loadGlider(Matrix matrix) {
        matrix.setCell(matrix.getHeigth() - 1, matrix.getWidth() - 2, true);
        matrix.setCell(matrix.getHeigth() - 2, matrix.getWidth() - 3, true);
        matrix.setCell(matrix.getHeigth() - 3, matrix.getWidth() - 3, true);
        matrix.setCell(matrix.getHeigth() - 3, matrix.getWidth() - 2, true);
        matrix.setCell(matrix.getHeigth() - 3, matrix.getWidth() - 1, true);
        return matrix;
    }

    public Matrix loadRandom(Matrix matrix) {
        for (int i = 0; i < matrix.getHeigth(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                matrix.setCell(i, j, (Math.random() < 0.5 ? true : false));
            }
        }
        return matrix;
    }

    @Override
    public void load(Matrix matrix, String name) {
    }
}
