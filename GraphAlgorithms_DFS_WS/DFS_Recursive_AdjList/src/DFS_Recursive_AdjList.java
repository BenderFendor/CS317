
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFS_Recursive_AdjList {
	    public static void main(String[] args) {
	    	Graph1 g = new Graph1(13);
	    	
	    	g.readGraph();
	        g.DFS();
	        g.displayVisitingOrder();
	        g.displayNumOfConnectedComponents();
	        
	    }
}//end of DFS_NonRecursive1
