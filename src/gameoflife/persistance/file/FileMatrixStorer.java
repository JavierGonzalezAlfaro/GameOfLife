package gameoflife.persistance.file;

import gameoflife.model.Matrix;
import gameoflife.persistance.MatrixStorer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileMatrixStorer implements MatrixStorer {

    @Override
    public void store(Matrix matrix, String name) {
        switch (name) { // Eleige el tipo de storer
            case "state1":
                storeState1(matrix);
                break;
            case "state2":
                storeState2(matrix);
                break;
            case "state3":
                storeSate3(matrix);
                break;
        }
    }

    private void storeState1(Matrix matrix) {
        File file = new File("Saves\\State1.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < matrix.getHeigth(); i++) {
                for (int j = 0; j < matrix.getWidth(); j++) {
                    printWriter.println(Integer.toString(i) + "," + Integer.toString(j) + "," + Boolean.toString(matrix.getCell(i, j).getState()));
                }
            }

        } catch (IOException ex) {
        } finally {
            try {
                if (null != fileWriter) {
                    fileWriter.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void storeState2(Matrix matrix) {
        File file = new File("Saves\\State2.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < matrix.getHeigth(); i++) {
                for (int j = 0; j < matrix.getWidth(); j++) {
                    printWriter.println(Integer.toString(i) + "," + Integer.toString(j) + "," + Boolean.toString(matrix.getCell(i, j).getState()));
                }
            }

        } catch (IOException ex) {
        } finally {
            try {
                if (null != fileWriter) {
                    fileWriter.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void storeSate3(Matrix matrix) {
        File file = new File("Saves\\State3.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < matrix.getHeigth(); i++) {
                for (int j = 0; j < matrix.getWidth(); j++) {
                    printWriter.println(Integer.toString(i) + "," + Integer.toString(j) + "," + Boolean.toString(matrix.getCell(i, j).getState()));
                }
            }

        } catch (IOException ex) {
        } finally {
            try {
                if (null != fileWriter) {
                    fileWriter.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
