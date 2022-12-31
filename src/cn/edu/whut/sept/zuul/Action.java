/**
 * 动作接口, 用于多态
 */

package cn.edu.whut.sept.zuul;

import java.util.HashMap;

public interface Action {
    public Parser parser = new Parser();

    /**
     *
     * @param params 所有关于游戏的参数的封装
     * @return 所有关于游戏的参数的封装, 对params做出改变
     */
    public Params doAction(Params params);
}
