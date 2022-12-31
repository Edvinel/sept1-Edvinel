package main.java.cn.edu.whut.sept.zuul;

public class QuitAction implements Action{

    /**
     * 执行Quit指令，用户退出游戏。如果用户在命令中输入了其他参数，则进一步询问用户是否真的退出.
     * @return 如果游戏需要退出则返回true，否则返回false.
     */
    @Override
    public Params doAction(Params params) {
        Params result = new Params();
        Command command = params.getCommand();
        Room currentRoom = params.getRoom();
        result.setRoom(currentRoom);

        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            result.setWantToQuit(false);
        } else {
            result.setWantToQuit(true); // signal that we want to quit
        }
        return result;
    }
}
