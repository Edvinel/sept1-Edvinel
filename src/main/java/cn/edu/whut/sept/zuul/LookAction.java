/**
 * 看房间中有什么物品
 */
package cn.edu.whut.sept.zuul;

public class LookAction implements Action{
    @Override
    public Params doAction(Params params) {
        Room room = params.getRoom();
        String materialsString = room.getMaterialsString();
        System.out.println(materialsString);
        return params;
    }
}
