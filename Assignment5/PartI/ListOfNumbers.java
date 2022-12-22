import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {
    private ArrayList <Pair<Integer,Integer>>pairList;
    private String fileName;

    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
    	pairList=new ArrayList<Pair<Integer,Integer>>();
    }
    
    public ArrayList getPairList() {
    	return this.pairList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		// fill the existing list with Pair objects
    		// of two numbers.
    		Pair<Integer, Integer> p = new Pair<Integer, Integer>(number1,number2);
    		pairList.add(p);
    	}
    	System.out.println(pairList);
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;	
    }
    
    public void readList() {
    	pairList=new ArrayList<Pair<Integer,Integer>>();
    	FileReader f=null;
    	try {
	    	f = new FileReader("numberfile.txt");
	    	BufferedReader in = new BufferedReader(f);
	    	String ln = in.readLine();
	    	while (ln != null) {
	    		System.out.println(ln);
	    		String [] line=ln.split(" ");
	    		Pair<Integer, Integer> pobj2 = new Pair<Integer, Integer>(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
	    		pairList.add(pobj2);
	    		ln = in.readLine(); 
	    	}
    	}
    	catch (FileNotFoundException fnfe) {
			System.out.println("File not found: "+ fnfe.getMessage());
		} 
    	catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("array index out of bounds");
		} 
    	catch (IOException ioe) {
			System.out.println("IO error: " + ioe.getMessage());
		} 
    	catch (NullPointerException ne) {
    		System.out.println("Null value/extra line in file: "+ne);
    	}
    	finally {
			if (f != null) {
				try {
					f.close();
				} 
				catch (IOException ioe) {
					System.out.println("Error closing file : "+ ioe.getMessage());
				} 
			}
		}

    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < pairList.size(); i++)
                out.println(pairList.get(i).getKey() + " " + pairList.get(i).getValue());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }
        catch (FileNotFoundException fnfe) {
			System.out.println("File not found: "+ fnfe.getMessage());
		} 
    	catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("array index out of bounds");
		} 
    	catch (IOException ioe) {
			System.out.println("IO error: " + ioe.getMessage());
		} 
    	catch (NullPointerException ne) {
    		System.out.println("Null value/extra line in file: "+ne);
    	}
        finally {
            try {
	        	if (input != null) {
	                input.close();
	            }
            }
            catch(IOException ioe) {
            	System.out.println("Error closing file : "+ ioe.getMessage());
        	}
        }
    }
    
  public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    }

}
