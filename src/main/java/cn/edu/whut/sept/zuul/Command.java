/**
 * 该类是“World-of-Zuul”应用程序的指令类
 * 负责记录用户输入的指令
 */
package cn.edu.whut.sept.zuul;

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * 封装用户输入的指令
     * @param firstWord 用户输入的第一个单词
     * @param secondWord 用户输入的第二个单词
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * @return 返回用户的动作
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return 返回用户输入的第二个单词
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     *
     * @return 如果用户没有有效动作, 则返回true; 如果用户有有效动作, 则返回false
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     *
     * @return 如果用户有输入两个单词, 则返回true; 否则返回false
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
