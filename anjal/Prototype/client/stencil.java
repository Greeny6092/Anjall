import java.util.*;
public class stencil
{
static boolean stencil [][] = new boolean[60][150];
static boolean finalBoard [][] = new boolean[1000][1000];
static int rowSize;
static int colSize;
static ArrayList<Lines> lines =  new ArrayList<Lines>();
public static void initialiseStencil()
{
	//stencil[0][0]=; stencil[0][1]=; stencil[0][2]=; stencil[0][3]=; stencil[0][4]=; stencil[0][5]=; stencil[0][6]=; stencil[0][7]=; stencil[0][8]=; stencil[0][9]=; stencil[0][10]=; stencil[0][11]=; stencil[0][12]=; stencil[0][13]=; stencil[0][14]=; stencil[0][15]=; stencil[0][16]=; stencil[0][17]=; stencil[0][18]=; stencil[0][19]=; stencil[0][20]=;  
	int rowLength = stencil.length;
	int colLength = stencil[0].length;
	for(int row = 0;row<rowLength;row++)
	{
		for(int col = 0;col < colLength;col++)
		{
			if(row < 10)
			{
				stencil[row][col] = false;
			}
			else if((row >= 10 && row <= 15) && ((col >= 60 && col <=65) || (col >= 29 && col <= 34)))
			{
				stencil[row][col] = true;
			}
		}
	}
	plotLines();
	for(Lines curLine:lines)
	{
		//int horizontalEndIndex = curLine.horizontalStartingPosition + curLine.length;
		//int verticalEndIndex = curLine.verticalStartingPosition + curLine.width;
		
		int horizontalEndIndex = 0;
		int verticalEndIndex = 0;
		if(curLine.orientation == 'h')
		{
			horizontalEndIndex = curLine.horizontalStartingPosition + curLine.width;
			verticalEndIndex = curLine.verticalStartingPosition + curLine.length;
		}
	else if(curLine.orientation == 'v')
	{
		horizontalEndIndex = curLine.horizontalStartingPosition + curLine.length;
		verticalEndIndex = curLine.verticalStartingPosition + curLine.width;		
	}
		System.out.println("curLine.horizontalStartingPosition : "+curLine.horizontalStartingPosition+" | curLine.length : "+curLine.length);
		System.out.println("curLine.verticalStartingPosition : "+curLine.verticalStartingPosition+" | curLine.width : "+curLine.width);
		
		for(int row = curLine.horizontalStartingPosition ; row < horizontalEndIndex ; row++)
		{
			for(int col = curLine.verticalStartingPosition ; col < verticalEndIndex ; col++)
			{
				stencil[row][col] = true;
			}
		}
	}
	
}

public static void scale(int length, int breadth)
{
	if(length == 0 && breadth == 0)
	{
		rowSize = stencil.length;
		colSize = stencil[0].length;
		
		for(int row = 0;row < rowSize;row++)
		{
			System.arraycopy(stencil[row],0,finalBoard[row],0,colSize);
		}
	}
	else
	{
		rowSize=stencil.length;
		colSize = stencil[0].length;
		if(length != 0)
			rowSize = stencil.length * (length+1);
		if(breadth != 0)
			colSize = stencil[0].length * (breadth+1);
		int finalRow = 0;
		int finalCol = 0;
		for(int row = 0 ; row < stencil.length ; row++)
		{
			finalCol=0;
			for(int col=0 ; col < stencil[0].length ; col++)
			{
				finalBoard[finalRow][finalCol] = stencil[row][col];
				finalCol+=length+1;
			}
			finalRow+=breadth+1;
		}
	}
}

private static void plotLines()
{
		lines.add(new Lines('h',32,3,46,5));
		lines.add(new Lines('v',40,3,18,34));
		lines.add(new Lines('h',17,3,18,61));
		lines.add(new Lines('v',28,3,18,67));
		lines.add(new Lines('h',17,3,18,91));
		lines.add(new Lines('v',14,3,18,91));
		lines.add(new Lines('v',14,3,18,99));
}

public static void printFinalBoard()
{
			for(int row = 0;row < rowSize;row++)
		{
			for(int col = 0;col < colSize;col++)
			{
				//System.out.print(finalBoard[row][col]);
				if(finalBoard[row][col])
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
}

}