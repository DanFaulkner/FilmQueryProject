package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int menuChoice;
		String keywordSearch;
		do {
			System.out.println("Menu options: ");
			System.out.println();
			System.out.println("1. Look up a film by its id.");
			System.out.println("2. Look up a film by a search keyword.");
			System.out.println("3. Exit the application.");
			menuChoice = input.nextInt();
			input.nextLine();
			System.out.println();
			System.out.println("===================================");
			System.out.println();
			switch (menuChoice) {
			case 1:
				System.out.print("Input the ID of the film you are searching for: ");
				int userInputFilmId = input.nextInt();
				input.nextLine();
				if(db.findFilmById(userInputFilmId) == null){
					System.out.println("No movie with that ID found");
					System.out.println();
					System.out.println();
				}else {
					System.out.println(db.findFilmById(userInputFilmId));
				}
				break;
				
			case 2: 
				System.out.println("Input the keyword you would like to search: ");
				String userInputKeyword = input.nextLine();
					for(Film f : db.findFilmByKeyword(userInputKeyword)){
						System.out.println(f);
					}
				break;
				
			case 3:
				System.out.println("Goodbye");
				break;
				
			default: 
				System.out.println("Invalid entry please try again");
				// if you have time input a try catch incase someone were to try to input a string instead of int
				break;

			}
		} while (menuChoice != 3);
	}

}
