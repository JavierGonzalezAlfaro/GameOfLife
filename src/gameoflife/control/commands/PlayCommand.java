package gameoflife.control.commands;

import gameoflife.control.Command;
import gameoflife.model.Sound;

public class PlayCommand implements Command {

    @Override
    public void execute() {
        Sound buttonSound = new Sound("Sound\\LockIn.wav");
        buttonSound.play();
        if (OKCommand.getTimer().isRunning()) {
            OKCommand.getTimer().stop();
        } else {
            OKCommand.getTimer().start();
        }
    }
}
