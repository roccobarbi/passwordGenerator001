package passwordGenerator001;

import java.util.*;

/**
 * 
 */
public class Password {

	///////////////
	// CONSTANTS //
	///////////////
	private static final int MIN_LENGTH = 8;
	private static final int DEF_LENGTH = 16;
	private static final char[] AVAIL_SYMBOLS = {(char) 33,
			(char) 35,
			(char) 36,
			(char) 37,
			(char) 38,
			(char) 40,
			(char) 41,
			(char) 42,
			(char) 43,
			(char) 44,
			(char) 45,
			(char) 46,
			(char) 47,
			(char) 58,
			(char) 59,
			(char) 60,
			(char) 61,
			(char) 62,
			(char) 63,
			(char) 64,
			(char) 91,
			(char) 92,
			(char) 93,
			(char) 94,
			(char) 95,
			(char) 123,
			(char) 124,
			(char) 125
	};
	
	////////////
	// FIELDS //
	////////////
	// The actual password
    private String password;

    // A scoring for the password strength (the highest the better)
    private int strength;

    /**
     * A String array with the previous values for the password, not including the current one.
     * Older values are saved at lower indices.
     * The array can be empty. It saves up to 100 previous values.
     */
    private String history[];
    private int historyLength;
	
	//////////////////
	// CONSTRUCTORS //
	//////////////////
    /**
     * Default constructor
     */
    public Password() {
    	this(DEF_LENGTH);
    }
    
    /**
     * Constructor with an indication of length
     */
    public Password(int length) {
    	setPassword(length);
    	setStrength();
    	history = new String[100];
    	historyLength = 0;
    }
    
	///////////////
	// ACCESSORS //
	///////////////
    /**
     * Using default length of 16
     */
    private void setPassword() {
        setPassword(DEF_LENGTH);
    }
    
    /**
     * Using explicitly defined length
     * Precondition: the length is at least MIN_LENGTH, otherwise MIN_LENGTH is used
     */
    private void setPassword(int length) {
    	int lCase = 0, uCase  = 0, digits = 0;
    	char passwordElements [];
        if(length < MIN_LENGTH) length = MIN_LENGTH; // For safety
        passwordElements = new char[length];
        // Length for each element
        lCase = (int) (Math.random() * (length - 4)) + 1;
        uCase = (int) (Math.random() * (length - lCase - 3)) + 1;
        digits = (int) (Math.random() * (length - lCase - uCase - 2)) + 1;
        // I select each element
        for(int i = 0; i < length; i++){
        	if(lCase > 0){
        		passwordElements[i] = (char) (97 + (int) (Math.random() * 26));
        		lCase--;
        	} else if (uCase > 0) {
        		passwordElements[i] = (char) (65 + (int) (Math.random() * 26));
        		uCase--;
        	} else if (digits > 0) {
        		passwordElements[i] = (char) (48 + (int) (Math.random() * 10));
        		digits --;
        	} else {
        		// Symbols have no counter, having been left for last
        		passwordElements[i] = AVAIL_SYMBOLS[(int)(Math.random() * AVAIL_SYMBOLS.length)];
        	}
        }
        // I shuffle everything
        shuffle(passwordElements);
        // I convert to string and save it
        password = new String(passwordElements);
    }

    /**
     * 
     */
    private void setStrength() {
        // TODO implement here
    }

    /**
     * 
     */
    public String getPassword() {
        // TODO implement here
    	return password;
    }

    /**
     * 
     */
    public int getStrength() {
        // TODO implement here
    	return 0;
    }
    

    /**
     * Returns a string array with the history of all previous values for the password, not including the current one. The older values are placed at lower indices in the array.
     */
    public String[] getHistory() {
        // TODO implement here
    	// BAD practice only as a placeholder here
    	return history;
    }
    
	/////////////
	// METHODS //
	/////////////

    /**
     * Creates a new password and saves the previous one to the history array.
     */
    public void reset() {
        // Check the length of the history array.
    	if(historyLength == 100){
    		// If needed, all values are shifted left by one position.
    		for(int i = 0; i < historyLength - 1; i++){
    			history[i] = history[i + 1];
    		}
    	}
    	// The current value is added to the end.
    	history[historyLength] = password;
    	// If needed, historyLength is increased
    	if(historyLength < 100) historyLength++;
    	// The new password is set
    	setPassword();
    	// The new strength is calculated
    	setStrength();
    }
    
    /**
     * Shuffles a char array in place
     */
    private void shuffle(char[] a){
    	int newNumber = 0;
    	char temp = ' ';
    	for(int i = 0; i < a.length - 1; i++){
    		newNumber = i + (int) (Math.random() * (a.length - i));
    		temp = a[i];
    		a[i] = a[newNumber];
    		a[newNumber] = temp;
    	}
    }

}