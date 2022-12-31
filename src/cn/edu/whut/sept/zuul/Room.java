/**
 * 该类是“World-of-Zuul”应用程序的房间类
 * 负责记录房间的描述与出口
 */
package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
    private String description;
    private HashMap<String, Room> exits; //出口

    /**
     * 创建房间
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * 设置出口
     * @param direction: 东南西北方位
     * @param neighbor: 出口所连接的对象
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     *
     * @return 返回房间的简短描述
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     *
     * @return 返回房间的完整描述
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     *
     * @return 返回房间的所有出口
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     *
     * @param direction 当前房间的direction方向
     * @return 当前房间的direction方向的另外一间房间
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}


