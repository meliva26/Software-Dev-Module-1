package module1;

import java.util.ArrayList;
import java.util.Scanner;

public class CallAttendantTest {

	public static void main(String[] args) {

		//Create the seats
		SeatButton seat1 = new SeatButton();
		SeatButton seat2 = new SeatButton();
		SeatButton seat3 = new SeatButton();
		SeatButton seat4 = new SeatButton();
		SeatButton seat5 = new SeatButton();
		
		//Puts the seats in an ArrayList
		ArrayList<SeatButton> seats = new ArrayList<>();
		seats.add(seat1);
		seats.add(seat2);
		seats.add(seat3);
		seats.add(seat4);
		seats.add(seat5);
		
		//Allow for user input
		Scanner keyboard = new Scanner(System.in);
		
		//The menu components
		String seatStatus = "Is the Call Attendant light on?"
				+ "\nSeat 1: " + seat1.getSeat()
				+ "\nSeat 2: " + seat2.getSeat()
				+ "\nSeat 3: " + seat3.getSeat()
				+ "\nSeat 4: " + seat4.getSeat()
				+ "\nSeat 5: " + seat5.getSeat();
		
		String menu = "Which button would you like to press?"
				+ "\n1. The Call Attendant button"
				+ "\n2. The Attendant's button";
		
		//Display the menu
		System.out.println(seatStatus + "\n\n" + menu);	
		String tempOption = keyboard.nextLine();
		int option = Integer.parseInt(tempOption);
		
		switch(option) {
		
		//The Call Attendant button
		case 1:
			System.out.println("Choose a seat from 1 to 5.");
			String tempSeatChoice = keyboard.nextLine();
			int seatChoice = Integer.parseInt(tempSeatChoice);
			
			seats.get(seatChoice).setSeat(true);

		//The Attendant's button
		case 2:
			System.out.println("This button turns off all the seat lights." 
					+ " Are you sure? (Yes or No)");
			String buttonChoice = keyboard.nextLine();
			buttonChoice.toLowerCase();
			
			if (buttonChoice == "yes") {
				for (SeatButton seat : seats) {
					seat.setSeat(false);
				}
			} else if (buttonChoice == "no") {
				break;
			}
			System.out.println(seatStatus + "\n\n" + menu);
			tempOption = keyboard.nextLine();
			option = Integer.parseInt(tempOption);
		}
		keyboard.close();
	}
}
