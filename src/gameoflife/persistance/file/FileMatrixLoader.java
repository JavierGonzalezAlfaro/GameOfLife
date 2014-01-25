package gameoflife.persistance.file;

import gameoflife.model.Matrix;
import gameoflife.persistance.MatrixLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileMatrixLoader implements MatrixLoader {

    @Override
    public Matrix load(int width, int height) {
        return null;
    }

    @Override
    public void load(Matrix matrix, String name) {
        switch (name) { // Eleige el tipo de loader
            case "state1":
                loadState1(matrix);
                break;
            case "state2":
                loadState2(matrix);
                break;
            case "state3":
                loadSate3(matrix);
                break;
        }
    }

    private void loadState1(Matrix matrix) {
        File file = new File("Saves\\State1.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            String line;
            while ((line = buffer.readLine()) != null) {
                matrix.getCell(Integer.parseInt(line.split(",")[0]), Integer.parseInt(line.split(",")[1])).setState((Boolean.parseBoolean(line.split(",")[2])));
            }
        } catch (IOException ex) {
        }
    }

    private void loadState2(Matrix matrix) {
        File file = new File("Saves\\State2.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            String line;
            while ((line = buffer.readLine()) != null) {
                matrix.getCell(Integer.parseInt(line.split(",")[0]), Integer.parseInt(line.split(",")[1])).setState(Boolean.parseBoolean(line.split(",")[2]));

            }
        } catch (IOException ex) {
        }
    }

    private void loadSate3(Matrix matrix) {
        File file = new File("Saves\\State3.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            String line;
            while ((line = buffer.readLine()) != null) {
                matrix.getCell(Integer.parseInt(line.split(",")[0]), Integer.parseInt(line.split(",")[1])).setState(Boolean.parseBoolean(line.split(",")[2]));

            }
        } catch (IOException ex) {
        }
    }
}