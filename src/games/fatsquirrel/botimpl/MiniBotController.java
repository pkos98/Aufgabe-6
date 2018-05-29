package games.fatsquirrel.botimpl;

import games.fatsquirrel.botapi.BotController;
import games.fatsquirrel.botapi.ControllerContext;
import games.fatsquirrel.util.XYSupport;

public class MiniBotController implements BotController {
    private int implodeRadius = 5;

    @Override
    public void nextStep(ControllerContext view) {
        view.move(XYSupport.getRandomMoveVector());
    }

    public int getImplodeRadius() {
        return implodeRadius;
    }
}
