import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main extends HelloBaseVisitor{

    public static void main(String[] args) throws  IOException{
        run();
    }


    public static void run()  throws IOException {

        //对每一个输入的字符串，构造一个 ANTLRStringStream 流 in
        ANTLRInputStream in = new ANTLRInputStream("hello world");
        //用 in 构造词法分析器 lexer，词法分析的作用是产生记号
        HelloLexer lexer = new HelloLexer(in);

        //用词法分析器 lexer 构造一个记号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        HelloParser parser = new HelloParser(tokens);

        ParseTree tree=parser.r();

        //得到整棵书的文本
        System.out.println(tree.getText().toString());
        //得到第一个子节点文本
        System.out.println(tree.getChild(0));
        //得到第二个子节点文本
        System.out.println(tree.getChild(1));
    }
}
