import java.util.ArrayList; //Imports array lists to place words in.
public class MergeSort {
    
    int countMoves = 0; // counts number of move/comparisons.
    private ArrayList<String> lst; // list will store the final value.

    public MergeSort(ArrayList<String> input) {
        lst = input;
    }
     
    public void sort() {
        // run merge sort.
        lst = mergeSort(lst);
    }
 
    public ArrayList<String> mergeSort(ArrayList<String> full) {
        // creating left and right arraylists and midpoint.
        int middle;
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
 
        if (full.size() == 1) {    
            return full;
        } else {
            middle = full.size()/2;
             //left half
            for (int i=0; i<middle; i++) {
                    left.add(full.get(i));
            }
            //right half
            for (int i=middle; i<full.size(); i++) {
                    right.add(full.get(i));
            }
            left  = mergeSort(left);
            right = mergeSort(right);

            //combine results together.
            merge(left, right, full);
        }
        return full;
    }
 
    private void merge(ArrayList<String> left, ArrayList<String> right, ArrayList<String> full) {
        int lIn = 0;
        int rIn = 0;
        int combinedIn = 0;
        //take the smallest of each side and add to combined index
        while (lIn < left.size() && rIn < right.size()) {
            if ( (left.get(lIn).compareTo(right.get(rIn))) < 0) {
                full.set(combinedIn, left.get(lIn)); //move left
                lIn++;
                ++countMoves;
            } else {
                full.set(combinedIn, right.get(rIn)); // move right
                rIn++;
                ++countMoves;
            }
            combinedIn++;
        }
 
        ArrayList<String> rest;
        int restIndex;
        if (lIn >= left.size()) 
        { //left arraylist is full
            rest = right;
            restIndex = rIn;
        } else 
        {
            rest = left; // right arraylist is full
            restIndex = lIn;
        }
 
        for (int i=restIndex; i<rest.size(); i++) 
        {
            full.set(combinedIn, rest.get(i));
            combinedIn++;
        }
        
    }
 
    public void print() {
        // prints result of merge sort and number of moves it took to produce the merge sort.
        System.out.println("Final sorted result:");
        System.out.println(lst);
        System.out.println("--------------------------------------------------");
        System.out.println("Total number of moves/comparisons:");
        System.out.println(countMoves);
    }
 

}