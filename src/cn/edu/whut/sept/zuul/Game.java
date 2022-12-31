/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

public class Game
{
    private Parser parser;
    private Room currentRoom;

    /**
     * 创建游戏并初始化内部数据和解析器
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, spaceMagic;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // 传送房间
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(outside);
        rooms.add(theater);
        rooms.add(pub);
        rooms.add(lab);
        rooms.add(office);
        spaceMagic = new MagicRoom("in a magic room, you will be sent to a random space", rooms);
        spaceMagic.addMaterials(new Material("手机", "在混乱时空中捡到的", 10));
        spaceMagic.addMaterials(new Material("Mac", "在混乱时空中见到的", 20));

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", spaceMagic);
        outside.addMaterials(new Material("口罩", "用来防范疫情", 1.0));
        outside.addMaterials(new Material("学生手册", "记录学校的规章和制度", 3.0));

        theater.setExit("west", outside);
        theater.addMaterials(new Material("口罩", "学术报告厅好像需要口罩", 1.0));

        pub.setExit("east", outside);
        pub.addMaterials(new Material("香水", "喷一喷香水再进入", 5.0));
        pub.addMaterials(new Material("墨镜", "带着墨镜进去应该比较酷", 3.0));

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.addMaterials(new Material("防护服", "做实验需要穿好防护服", 6.0));
        lab.addMaterials(new Material("护目镜", "做实验需要戴好护目镜", 3.0));

        office.setExit("west", lab);
        office.addMaterials(new Material("资料", "有大量信息", 1.0));
        office.addMaterials(new Material("钢笔", "用来写字", 2.0));

        currentRoom = outside;  // start game outside
        Record.roomList.add(currentRoom);
    }

    /**
     *  游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand(); // 获取指令
            finished = processCommand(command);  // 执行指令
        }
        System.out.println(Record.roomList);
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回true，否则返回false.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        // 指令中没有有效动作
        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        //指令中含有有效动作
        String commandWord = command.getCommandWord();
        Action action = CommandWords.actions.get(commandWord); // 多态, 获取动作对象
        Params data = new Params(); // 用于封装当前变量(状态)
        data.setCommand(command);
        data.setRoom(currentRoom);
        Params result = action.doAction(data); // 多态 返回更改后的变量(状态)
        currentRoom = result.getRoom(); // 变量更新
        if (currentRoom instanceof MagicRoom) {
            try {
                for (int i = 3; i > 0; i--) {
                    Thread.sleep(1000);
                    System.out.println("混乱时空中...还剩" + i + "秒到达一个随机地点\n");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentRoom = ((MagicRoom) currentRoom).getNextRoomRandom(); // 当前房间切换成一个随机房间
            Record.roomList.add(currentRoom);
        }
        wantToQuit = result.isWantToQuit(); // 变量更新
        // else command not recognised.
        return wantToQuit;
    }

}