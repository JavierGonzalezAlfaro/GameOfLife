package gameoflife.persistance;

import gameoflife.model.Matrix;

public interface MatrixStorer {

    public void store(Matrix matrix, String name);
}
