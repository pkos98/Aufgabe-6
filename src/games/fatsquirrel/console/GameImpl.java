package games.fatsquirrel.console;

import games.fatsquirrel.Game;
import games.fatsquirrel.State;
import games.fatsquirrel.UI;
import games.fatsquirrel.botapi.ControllerContext;
import games.fatsquirrel.core.MasterSquirrelBot;
import games.fatsquirrel.entities.Entity;
import games.fatsquirrel.util.XYSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class GameImpl extends Game {

    private Logger logger = Logger.getLogger(getClass().getName());

    public GameImpl(State state, UI ui) {
        super(state, ui);
        initProxy();
        ui.setContext(state.flattenedBoard());
    }

    private void initProxy() {
        int width = state.flattenedBoard().getSize().getX();
        int height = state.flattenedBoard().getSize().getY();
        MasterSquirrelBot bot = new MasterSquirrelBot(Entity.ID_AUTO_GENERATE, 100, XYSupport.getRandomEmptyPosition(width, height, state.flattenedBoard()));
        // Is called every time a method of ControllerContext is being called
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                logger.info(method.getName() + " executed");
                // Invoke original method
                Method[] methods = bot.getClass().getMethods();
                for (int i = 0; i < bot.getClass().getMethods().length; i++) {
                    Method iterMethod = methods[i];
                    if (iterMethod.getName() == method.getName())
                        methods[i].invoke(bot, args);
                }
                return null;
            }
        };
        ControllerContext proxy = (ControllerContext) Proxy.newProxyInstance(
                ControllerContext.class.getClassLoader(),
                new Class[]{ControllerContext.class},
                handler);
    }

    @Override
    protected void render() {
        ui.render(state.flattenedBoard());
    }

    @Override
    protected void processInput() {
        state.setInput(ui.getCommand());
        ui.resetCommand();
    }

}
