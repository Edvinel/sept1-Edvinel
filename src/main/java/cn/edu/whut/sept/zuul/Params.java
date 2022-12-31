package main.java.cn.edu.whut.sept.zuul;

public class Params {

    private Command command;
    private Room room;
    private boolean wantToQuit;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isWantToQuit() {
        return wantToQuit;
    }

    public void setWantToQuit(boolean wantToQuit) {
        this.wantToQuit = wantToQuit;
    }
}
