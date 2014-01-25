package gameoflife.model;

public class Matrix {

    private Cell[][] matrix;

    public Matrix(Cell[][] matrix) {
        this.matrix = matrix;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Cell[][] matrix) {
        this.matrix = matrix;
    }

    public int getWidth() {
        return matrix[0].length;
    }

    public int getHeigth() {
        return matrix.length;
    }

    public void checkStatus() {
        int contador = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                contador = 0;
                if (i > 0 && i < matrix.length - 1 && j > 0 && j < matrix[0].length - 1) {
                    if (matrix[i - 1][j - 1].getState()) {
                        contador++;
                    }
                    if (matrix[i - 1][j].getState()) {
                        contador++;
                    }
                    if (matrix[i - 1][j + 1].getState()) {
                        contador++;
                    }
                    if (matrix[i][j - 1].getState()) {
                        contador++;
                    }
                    if (matrix[i][j + 1].getState()) {
                        contador++;
                    }
                    if (matrix[i + 1][j - 1].getState()) {
                        contador++;
                    }
                    if (matrix[i + 1][j].getState()) {
                        contador++;
                    }
                    if (matrix[i + 1][j + 1].getState()) {
                        contador++;
                    }
                } else if (i == 0) { //BIEN
                    if (j == 0) { //BIEN
                        if (matrix[i][j + 1].getState()) {
                            contador++;
                        }
                        if (matrix[i + 1][j].getState()) {
                            contador++;
                        }
                        if (matrix[i + 1][j + 1].getState()) {
                            contador++;
                        }
                    } else if (j == matrix[0].length - 1) { //BIEN
                        if (matrix[i][j - 1].getState()) {
                            contador++;
                        }
                        if (matrix[i + 1][j].getState()) {
                            contador++;
                        }
                        if (matrix[i + 1][j - 1].getState()) {
                            contador++;
                        }
                    } else { //BIEN
                        if (matrix[i][j - 1].getState()) {
                            contador++;
                        }
                        if (matrix[i][j + 1].getState()) {
                            contador++;
                        }
                        if (matrix[i + 1][j].getState()) {
                            contador++;
                        }
                        if (matrix[i + 1][j + 1].getState()) {
                            contador++;
                        }
                        if (matrix[i + 1][j - 1].getState()) {
                            contador++;
                        }
                    }
                } else if (i == matrix.length - 1) { //BIEN
                    if (j == 0) { //BIEN
                        if (matrix[i - 1][j].getState()) {
                            contador++;
                        }
                        if (matrix[i - 1][j + 1].getState()) {
                            contador++;
                        }
                        if (matrix[i][j + 1].getState()) {
                            contador++;
                        }
                    } else if (j == matrix[0].length - 1) { //BIEN
                        if (matrix[i][j - 1].getState()) {
                            contador++;
                        }
                        if (matrix[i - 1][j].getState()) {
                            contador++;
                        }
                        if (matrix[i - 1][j - 1].getState()) {
                            contador++;
                        }
                    } else { //BIEN
                        if (matrix[i][j - 1].getState()) {
                            contador++;
                        }
                        if (matrix[i][j + 1].getState()) {
                            contador++;
                        }
                        if (matrix[i - 1][j].getState()) {
                            contador++;
                        }
                        if (matrix[i - 1][j + 1].getState()) {
                            contador++;
                        }
                        if (matrix[i - 1][j - 1].getState()) {
                            contador++;
                        }
                    }
                } else if (j == 0 && i != 0 && i != matrix.length - 1) {
                    if (matrix[i - 1][j].getState()) {
                        contador++;
                    }
                    if (matrix[i - 1][j + 1].getState()) {
                        contador++;
                    }
                    if (matrix[i + 1][j].getState()) {
                        contador++;
                    }
                    if (matrix[i + 1][j + 1].getState()) {
                        contador++;
                    }
                    if (matrix[i][j + 1].getState()) {
                        contador++;
                    }
                } else if (j == matrix[0].length - 1 && i != 0 && i != matrix.length - 1) {
                    if (matrix[i][j - 1].getState()) {
                        contador++;
                    }
                    if (matrix[i - 1][j].getState()) {
                        contador++;
                    }
                    if (matrix[i - 1][j - 1].getState()) {
                        contador++;
                    }
                    if (matrix[i + 1][j].getState()) {
                        contador++;
                    }
                    if (matrix[i + 1][j - 1].getState()) {
                        contador++;
                    }
                }
                if (matrix[i][j].getState()) {
                    if (contador == 3 || contador == 2) { //vivo
                        matrix[i][j].setNextState(true);
                    } else {
                        matrix[i][j].setNextState(false);
                    }
                } else {
                    if (contador == 3) { //muerto
                        matrix[i][j].setNextState(true);
                    } else {
                        matrix[i][j].setNextState(false);
                    }
                }
            }
        }
    }

    public void changeStatus() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].getNextState()) {
                    matrix[i][j].setState(true);
                } else {
                    matrix[i][j].setState(false);
                }
            }
        }
    }

    public Cell getCell(int i, int j) {
        return matrix[i][j];
    }

    public void setCell(int i, int j, boolean state) {
        matrix[i][j] = new Cell(state);
    }
}