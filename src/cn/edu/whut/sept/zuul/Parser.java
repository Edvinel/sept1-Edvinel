package cn.edu.whut.sept.zuul;

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
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
