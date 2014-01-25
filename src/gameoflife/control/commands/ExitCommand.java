package gameoflife.control.commands;

import gameoflife.control.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.exit(0);
    }
}
