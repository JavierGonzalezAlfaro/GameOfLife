package gameoflife.control.commands;

import gameoflife.control.Command;

public class FastCommand implements Command {

    @Override
    public void execute() {
        if (OKCommand.getDelay() != 0) {
            OKCommand.setDelay(OKCommand.getDelay() - 10);
            OKCommand.getTimer().setDelay(OKCommand.getDelay());
        }
    }
}
