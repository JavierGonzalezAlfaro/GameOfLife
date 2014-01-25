package gameoflife.persistance;

import gameoflife.model.Matrix;

public interface MatrixLoader {

    public Matrix load(int width, int height);

    public void load(Matrix matrix, String name);
}
