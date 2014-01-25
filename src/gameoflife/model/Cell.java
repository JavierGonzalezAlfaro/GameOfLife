package gameoflife.model;

public class Cell {

    private boolean state;
    private boolean nextState;

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public boolean getNextState() {
        return nextState;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setNextState(boolean nextState) {
        this.nextState = nextState;
    }
}
