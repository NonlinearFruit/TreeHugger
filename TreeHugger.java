import java.lang.StringBuilder;
import java.io.*;

public class TreeHugger{
	static String code = "++++++++[>++++[>++>+++>+++>+^^^^-]>+>+>->>+[^]^-]>>.>---.+++++++..+++.>>.^-.^.+++.------.--------.>>+.>++.";
	static String cmds = "+-<^>.[]";//"+-<^>,.";
	static Tree data = new Tree(null);

	public static void main(String[] args) {
		if( args.length!=0 && args[0].substring(args[0].length()-3).equals(".th"))
		{
			try {
	            FileReader fileReader = 
	                new FileReader(args[0]);

	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            String line;
	            String content = "";
	            while((line = bufferedReader.readLine()) != null) {
	                content += line+"\n";
	            }   

	            read(content);

	            bufferedReader.close();         
        	}
        	catch(Exception e){ System.out.println(e.getMessage());}
		}
		else
		{
			read(code);
		}
	}

	public static void read(String thc)
	{
		System.out.println("\nCode set: "+thc+"\n");
		for(int i=0; i<thc.length();)
		{
			char nextChar = thc.charAt(i);
			if( isValidCmd(nextChar) )
				i=exeCmd(nextChar,thc,i);
			else
				i++;
		}
		System.out.println("\n");
	}

	public static boolean isValidCmd(char c)
	{
		if(cmds.indexOf(c)>=0)
			return true;
		return false;
	}

	public static int exeCmd(char c, String code, int index)
	{
		switch(c)
		{
			case '+':
				data.increment();
				break;

			case '-':
				data.decrement();
				break;

			case '<':
				data = data.getLeft();
				break;

			case '^':
				data = data.getParent();
				break;

			case '>':
				data = data.getRight();
				break;

			case '.':
				System.out.print((char)data.getValue());
				break;

			case '[':
				int pairOpen = pairMe(c,code.substring(index+1))+index+1;
				if (data.getValue()==0)
					return pairOpen+1;
				break;

			case ']':
				int pairClose = pairMe(c,code.substring(0,index));
				if (data.getValue()!=0)
					return pairClose+1;
				break;

			default:
				break;
		}
		return ++index;
	}

	public static int pairMe(char brace, String codeInBrace)
	{
		char findMe = ']';
		int indexOfPair = 0;
		int skippers = 0;
		if(brace==findMe)
		{	
			findMe = '[';
			codeInBrace = new StringBuilder(codeInBrace).reverse().toString();
		}

		for(int i=0; i<codeInBrace.length(); i++)
		{
			char c = codeInBrace.charAt(i);
			if(c==brace)
				skippers++;
			else if(c==findMe)
			{
				if(skippers==0)
				{
					indexOfPair = i;
					break;
				}
				skippers--;
			}
		}

		if(findMe=='[' && indexOfPair!=codeInBrace.length())
		{
			indexOfPair = codeInBrace.length()-indexOfPair-1;
		}
		return indexOfPair;
	}
}