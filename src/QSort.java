// Author:  Siddharth Shankar  Id: 800935002


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class QSort {
	
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
	
		String contents;
		
		//Fetching the program start time from the system
		long initTime=System.currentTimeMillis();
		
		//Storing the present working directly of the system
		String currentDir = System.getProperty("user.dir");
		
		//Creating arraylist object to store all the values from the input file and process it for sorting
		ArrayList<Double> unsortedList=new ArrayList<Double>();
		
		//Creating file where the sorted array needs to be printed
			PrintWriter pw=new PrintWriter(currentDir+"/answer.txt","UTF-8");
		for(int count=0;count<args.length;count++)
		{
		BufferedReader br=new BufferedReader(new FileReader(currentDir+"/"+args[count]));
		Double[] nums = null;
		pw.write("\nSorting Result:\n");
		while((contents=br.readLine())!=null)
		{
			//Splitting the numbers by ';'
			String[] num=contents.split(";");
			nums=new Double[num.length];
			for(int i=0;i<num.length;i++)
			{
				unsortedList.add(Double.parseDouble(num[i]));
				System.out.println(unsortedList);
			}
			
		}
		
		//Calling the quicksort method and storing the sorted output it into an arraylist
		ArrayList<Double> sortedList=(sorting(unsortedList,0,unsortedList.size()-1));
		System.out.println(sortedList);
		
		//Calculating the time consumed in total running of the file
		long timeConsumed=(System.currentTimeMillis()-initTime);
		System.out.println("Total time consumed="+timeConsumed);
		
		//Writing in the file in the required format
		String arrayOfPath[]=args[0].split("/");
		pw.append(arrayOfPath[arrayOfPath.length-1]+" sorted :- ");
		for(int i=0;i<unsortedList.size();i++)
		{
			pw.append(""+unsortedList.get(i));
			pw.append(";");
			
		}
		
		
		pw.println(" ");
		pw.append("\n\nPerformance analysis:");
		pw.append("\n\ninput file\tSize\tSorting time in milliseconds");
		pw.append("\n"+arrayOfPath[arrayOfPath.length-1]+"\t"+unsortedList.size()+"\t\t"+timeConsumed); 
		
		}
		pw.close();
		
	}
	
	
	//Method which is performing Quick Sort
	public static ArrayList<Double> sorting(ArrayList<Double> unsortedList,int low,int high)
	{
		int pos=high;
		if(low<high){
		
		//Choosing the pivot element as the last element of the list
		Double pivot=unsortedList.get(pos);
		
		//Checking the pivot element with all other elements of the list and swapping when there is a number greater than pivot found
		for(int i=low;i<pos;i++)
		{
			if(pivot<unsortedList.get(i))
			{
				unsortedList.set(pos,unsortedList.get(i));
				unsortedList.set(i,unsortedList.get(pos-1));
				unsortedList.set(pos-1,pivot);
				pos--;
			}
			
		}
		
		//Till only single element is left, the recursive process continues on the sub-list
		if(pos>0)
		{
			sorting(unsortedList,low,pos-1);
		}
		if(pos+1<high)
			sorting(unsortedList,pos+1,high);
		}
		
		//Return the sorted list
		return unsortedList;
	}
	

}
