/**
 * 该类是“World-of-Zuul”应用程序的输入解析器。
 *
 * 负责处理用户的输入内容，并将其封装为游戏指令Command
 */
package test.java.cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    /**
     * 创建解析器.
     */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 读取用户输入字符串， 将其解析后封装到Command对象中
     * @return
     */
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();  // 读取用户输入的字符串

        // 将用户输入字符串按空格分隔为word1与word2

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        // 判断用户输入的指令的第一个单词是否是有效动作

        if(commands.isCommand(word1)) { // 如果是有效动作, 那么正常封装为Command对象
            return new Command(word1, word2);
        }
        else { // 如果不是有效动作, 则为Command对象设置动作为null
            return new Command(null, word2);
        }
    }

    /**
     * 向用户展示所有所有有效动作
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
