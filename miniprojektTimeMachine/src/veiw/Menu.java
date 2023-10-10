package veiw;

import java.util.Scanner;

import state.TimeMachine;

public class Menu {
	
	TimeMachine tM = new TimeMachine();

    public void run() {
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("q")) {
            System.out.println("Current State: " + tM.getCurrentState());
            System.out.println("" 
            		+ "1. Display Time \n"
            		+ "2. Change time\n"
                    + "3. Display Date\n"
                    + "4. Change Date\n"
                    + "Q. Exit");

            userInput = sc.nextLine();
            switch (userInput) {
                case "1":
                	if(tM.getCurrentState().equals(tM.currentState.DisplayTime)) {
                		tM.displayTime();
                    }else if(tM.getCurrentState().equals(tM.currentState.ChangeTime)){
                    	System.out.println("Changing state...");
                    	tM.set();
                    }else {
                    	System.out.println("Changing state...");
                    	tM.swapState();
                    }
                    break;
                case "2":
                	if(tM.getCurrentState().equals(tM.currentState.DisplayDate)) {
                		System.out.println("You are in the wrong state! Change State!");
                	}else {
                		if(tM.getCurrentState().equals(tM.currentState.ChangeTime)) {
                		System.out.println("Enter new time with the format: HH:MM");
                    	userInput = sc.nextLine();
                    	tM.changeTime(userInput);
                    	}else {
                    		System.out.println("Changing State...");
                        	tM.changeTime("");
                    	}
                	}
                    break;
                case "3":
                    if(tM.getCurrentState().equals(tM.currentState.DisplayDate)) {
                    	tM.displayDate();
                    }else if(tM.getCurrentState().equals(tM.currentState.ChangeDate)){
                    	System.out.println("Changing state...");
                    	tM.set();
                    }else {
                    	System.out.println("Changing state...");
                    	tM.swapState();
                    }
                    break;
                case "4":
                	if(tM.getCurrentState().equals(tM.currentState.DisplayTime)) {
                		System.out.println("You are in the wrong state! Change State!");
                	}else {
                		if(tM.getCurrentState().equals(tM.currentState.ChangeDate)) {
                    		System.out.println("Enter new date with the format YYYY-MM-DD");
                            userInput = sc.nextLine();
                            tM.changeDate(userInput);
                    	}else {
                    		System.out.println("Changing State...");
                            tM.changeDate("");
                    	}
                	}
                    break;
                case "q":
                    break;
                default:
                    System.out.println("ERROR, Don´t do that");
            }
        }
    }
}
