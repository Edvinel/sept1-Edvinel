/**
 * 回退一个房间
 */
package test.java.cn.edu.whut.sept.zuul;

import java.util.List;

public class BackAction implements Action{
    @Override
    public Params doAction(Params params) {
        Params result = params;
        List<Room> roomList = Record.roomList;
        if (roomList.size() == 1) {
            System.out.println("别退了, 别退了, 已经在学校大门口了!");
            return result;
        }
        roomList.remove(roomList.size() - 1);
        result.setRoom(roomList.get(roomList.size() - 1));
        System.out.println(roomList.get(roomList.size() - 1).getLongDescription());
        return result;
    }
}
