/**
 * 该类是“World-of-Zuul”应用程序的预设指令, 其中包含了所有有效指令。
 */
package main.java.cn.edu.whut.sept.zuul;

import java.util.HashMap;

public class CommandWords
{
    /**
     * 声明有效动作
     */
    private static final String[] validCommands = {
            "go", "quit", "help", "look", "back"
    };

    public static HashMap<String, Action> actions = null;

    static {
        actions = new HashMap<String, Action>();
        actions.put("go", new GoAction());
        actions.put("quit", new QuitAction());
        actions.put("help", new HelpAction());
        actions.put("look", new LookAction());
        actions.put("back", new BackAction());
    }
    public CommandWords()
    {

        // nothing to do at the moment...
    }

    /**
     * 校验用户的动作是否有效
     * @param aString 用户的动作
     * @return
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     * 向用户展示所有所有有效动作
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
