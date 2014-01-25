package gameoflife.control.commands;

import gameoflife.control.Command;

public class SlowCommand implements Command {

    @Override
    public void execute() {
        OKCommand.setDelay(OKCommand.getDelay() + 10);
        OKCommand.getTimer().setDelay(OKCommand.getDelay());
    }
}
