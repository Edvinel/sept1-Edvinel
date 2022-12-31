package cn.edu.whut.sept.zuul;

public class GoAction implements Action{

    /**
     * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
     * 否则打印输出错误提示信息.
     */
    @Override
    public Params doAction(Params params) {
        Params result = new Params();
        Command command = params.getCommand();
        Room currentRoom = params.getRoom();
        result.setRoom(currentRoom);

        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return result;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }

        result.setRoom(currentRoom); // 只改变了room
        Record.roomList.add(currentRoom);
        return result;
    }
}
