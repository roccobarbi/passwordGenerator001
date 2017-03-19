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
	private static final int DEF_LENGTH = 8;
	
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
    	setPassword();
    	setStrength();
    	history = new String[100];
    	historyLength = 0;
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
        // TODO implement here
    }
    
    /**
     * Using explicitly defined length
     * Precondition: the length is at least MIN_LENGTH, otherwise MIN_LENGTH is used
     */
    private void setPassword(int length) {
        // TODO implement here
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
    public void getPassword() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getStrength() {
        // TODO implement here
    }
    

    /**
     * Returns a string array with the history of all previous values for the password, not including the current one. The older values are placed at lower indices in the array.
     */
    public void getHistory() {
        // TODO implement here
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
    		newNumber = i + (int) (Math.random() * (a.length - i + 1));
    		temp = a[i];
    		a[i] = a[newNumber];
    		a[newNumber] = a[i];
    	}
    }

}