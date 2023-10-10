package state;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import interfaces.Interface;

public class TimeMachine implements Interface {

	private LocalTime localTime = LocalTime.now();
	private LocalDate localDate = LocalDate.now();    
	public STATE currentState = STATE.DisplayTime;
   
	public enum STATE {
		DisplayTime,
	    DisplayDate,
	    ChangeTime,
	    ChangeDate
	}
	
	/**
	 * Get the time
	 * @return
	 */
	public LocalTime getLocalTime() {
		return localTime;	    
	}
	
	/**
	 * Set the time
	 * @param localTime
	 */
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;	    
	}

	/**
	 * Get the Date
	 * @return
	 */
	public LocalDate getLocalDate() {
		return localDate;	    
	}
	
	/**
	 * Set the Date
	 * @param localDate
	 */
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;   
	}

	/**
	 * Get the current state
	 * @return
	 */
	public STATE getCurrentState() {
		return currentState;	    
	}

	/**
	 * Set current state
	 * @param currentState
	 */
	public void setCurrentState(STATE currentState) {
		this.currentState = currentState;	    
	}
	
	/**
	 * Displays the local time if we are in the correct state, else it swaps to the correct state first
	 */
	public void displayTime() {
		if(currentState == STATE.DisplayTime) {
			System.out.println(localTime);
		} else if(currentState == STATE.DisplayDate) {
			swapState();
		} else if(currentState == STATE.ChangeTime) {
			set();
		} else {
			System.out.println("Invalid State");   
		}
	}
	
	/**
	 * Displays the local date if we are in the correct state, else it swaps to the correct state first
	 */
	public void displayDate() {
		if(currentState == STATE.DisplayDate) {
			System.out.println(localDate);
		} else if(currentState == STATE.DisplayTime) {
			swapState();
		} else if(currentState == STATE.ChangeDate) {
			set();
		} else {
			System.out.println("Invalid State");   
		}   
	}
	
	/**
	 * Checks what state we are in
	 * Sets a new time if we are in the correct state with userInput
	 * If the wrong format is used gives exception 
	 * If wrong state, swaps state
	 */
	public void changeTime(String userInput) {
	    if (currentState == STATE.ChangeTime) {
	        try {
	            LocalTime newTime = LocalTime.parse(userInput, DateTimeFormatter.ofPattern("[H:mm][h:mm a]"));
	            setLocalTime(newTime);
	            System.out.println("Time successfully changed to: " + newTime);
	            System.out.println("Changing State!");
	            set();
	        } catch (DateTimeParseException e) {
	            System.out.println("Invalid time format. Please use HH:MM");
	        }
	    } else if (currentState == STATE.DisplayTime) {
	        setStateChange();
	    } else {
	        System.out.println("Invalid State");
	    }
	}
	
	/**
	 * Checks what state we are in
	 * Sets a new date if we are in the correct state with userInput
	 * If the wrong format is used gives exception 
	 * If wrong state, swaps state
	 */
	public void changeDate(String userInput) {
	    if (currentState == STATE.ChangeDate) {
	        try {
	            LocalDate newDate = LocalDate.parse(userInput);
	            setLocalDate(newDate);
	            System.out.println("Date successfully changed to: " + newDate);
	            System.out.println("Changing State!");
	            set();
	        } catch (DateTimeParseException e) {
	            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
	        }
	    } else if (currentState == STATE.DisplayDate) {
	        setStateChange();
	    } else {
	        System.out.println("Invalid State");
	    }
	}
	
	/**
	 * Swaps the states from Displays Time to Date or vice versa 
	 */
	public void swapState() {
		if(getCurrentState() == STATE.DisplayTime) {
			currentState = STATE.DisplayDate;
		} else if(getCurrentState() == STATE.DisplayDate){
			currentState = STATE.DisplayTime;   
		}	    
	}
	
	/**
	 * Sets state to the Change states if user is in correct corresponding state
	 */
	public void setStateChange() {
		if(getCurrentState() == STATE.DisplayTime) {
			currentState = STATE.ChangeTime;
		} else if(getCurrentState() == STATE.DisplayDate) {
			currentState = STATE.ChangeDate;   
		}	    
	}
	
	/**
	 * Sends user back to Display state 
	 */
	public void set() {
		if(getCurrentState() == STATE.ChangeTime) {
			currentState = STATE.DisplayTime;
		} else if(getCurrentState() == STATE.ChangeDate) {
			currentState = STATE.DisplayDate;
		} else {
			System.out.println("Invalid State");   
		}   
	}
}