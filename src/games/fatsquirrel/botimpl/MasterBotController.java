package games.fatsquirrel.botimpl;

import games.fatsquirrel.botapi.BotController;
import games.fatsquirrel.botapi.ControllerContext;
import games.fatsquirrel.util.XYSupport;

public class MasterBotController implements BotController {

    @Override
    public void nextStep(ControllerContext view) {
        view.move(XYSupport.getRandomMoveVector());
    }
}
