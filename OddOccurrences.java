import java.util.HashMap;

public class OddOccurrences {
	// findOddOccurrences(int[] a) finds the element in a that occurs an odd number of times.
	// If no element occurs an odd number of times, or more than one element occurs an odd number of times, an
	// exception is thrown.
	
	// The first time it sees an element, it adds to a map. The next time it sees it, it removes it from the map.
	// The next time it sees it, it adds it back to the map, etc. In this way, once the loop has finished, the map
	// will contain only the elements in a that occur an odd number of times.
    public static int findOddOccurrences(int[] a) throws Exception {
    	if (a == null) {
    		throw new Exception("Input array is null.");
    	}
        HashMap<Integer, Boolean> odds = new HashMap<Integer, Boolean>();
        for (int i = 0; i < a.length; i++) {
            if (odds.get(a[i]) == null) {
                odds.put(a[i], true);
            } else {
                odds.remove(a[i]);
            }
        }        
        if (odds.keySet().size() == 1) {
        	return odds.keySet().iterator().next().intValue();
        } else if (odds.keySet().size() == 0) {
            throw new Exception("No element occurs an odd number of times.");
        } else {
        	throw new Exception("More than one element occurs an odd number of times.");
        }
    }
    
    public static void main(String[] args) throws Exception {
    	// test1
    	int[] a = null;
    	
    	boolean thrown = false;
    	try {
    		findOddOccurrences(a);
    	} catch (Exception e) {
    		if (e.getMessage() == "Input array is null.") {
			thrown = true;
    		}
    	}
    	assert(thrown) == true;
    	
    	// test2
    	a = new int[0];
    	thrown = false;
    	try {
    		findOddOccurrences(a);
    	} catch (Exception e) {
    		if (e.getMessage() == "No element occurs an odd number of times.") {
			thrown = true;
    		}
    	}
    	assert(thrown) == true;
    	
    	// test3
    	a = new int[4];
    	a[0] = 1; a[1] = 1; a[2] = 2; a[3] = 2;
    	thrown = false;
    	try {
    		findOddOccurrences(a);
    	} catch (Exception e) {
    		if (e.getMessage() == "No element occurs an odd number of times.") {
			thrown = true;
    		}
    	}
    	assert(thrown) == true;
    	
    	// test4
    	a = new int[2];
    	a[0] = 1; a[1] = 2;
    	thrown = false;
    	try {
    		findOddOccurrences(a);
    	} catch (Exception e) {
    		if (e.getMessage() == "More than one element occurs an odd number of times.") {
			thrown = true;
    		}
    	}
    	assert(thrown) == true;
    	
    	// test5
    	a = new int[3];
    	a[0] = 1; a[1] = 2; a[2] = 2;
    	assert findOddOccurrences(a) == 1;
    }
}
