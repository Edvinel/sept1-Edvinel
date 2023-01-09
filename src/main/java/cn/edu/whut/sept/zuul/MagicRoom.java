package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicRoom extends Room{

    private List<Room> rooms = new ArrayList<>(); // 存放其他房间

    /**
     * 创建房间
     *
     * @param description
     */
    public MagicRoom(String description, List<Room> rooms) {
        super(description);
        this.rooms = rooms;
    }

    public Room getNextRoomRandom() {
        Random r = new Random();
        int index = r.nextInt(rooms.size() - 1); // 生成[0, room.size()-1]区间的整数
        return rooms.get(index);
    }
}
