import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class InputFileGenerator {
	
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException
	{
		System.out.println("Files are="+args[0]);
		String currentDir = System.getProperty("user.dir");
		PrintWriter inpFile=new PrintWriter(currentDir+"/src/"+args[0],"UTF-8");
		Random randomGenerator = new Random();
	    for (int i=0;i<100;i++)
	    {
	      int randomInt = randomGenerator.nextInt(100);
	      System.out.println("Generated : " + randomInt);
	      inpFile.write(randomInt+";");
	    }
	    inpFile.close();
	    
	    PrintWriter inpFile1=new PrintWriter(currentDir+"/src/"+args[1],"UTF-8");
		Random randomGenerator1 = new Random();
	    for (int i=0;i<10000;i++)
	    {
	      int randomInt = randomGenerator.nextInt(10000);
	      System.out.println("Generated : " + randomInt);
	      inpFile1.write(randomInt+";");
	    }
	    inpFile1.close();
	    
	    PrintWriter inpFile2=new PrintWriter(currentDir+"/src/"+args[2],"UTF-8");
		Random randomGenerator2 = new Random();
	    for (int i=0;i<1000000;i++)
	    {
	      int randomInt = randomGenerator.nextInt(10000);
	      System.out.println("Generated : " + randomInt);
	      inpFile2.write(randomInt+";");
	    }
	    inpFile2.close();
		
	}
	

}
