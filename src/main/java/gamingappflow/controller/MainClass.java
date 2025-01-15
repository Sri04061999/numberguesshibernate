package gamingappflow.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import gamingappflow.dao.HibernateLogic;
import gamingappflow.dao.RandomNumberGenerator;
import gamingappflow.dto.Player;
import gamingappflow.services.AES;

public class MainClass { // controller package
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		HibernateLogic logic = new HibernateLogic();
		boolean flag = true;
		while (flag) {
			System.out.println("1.Play the Game\n2.Fetch Object\n3.Delete Object\n4.update Object name\n5.Exit\nEnter the valid option......");
			switch (sc.nextInt()) {
			case 1: {
				Player p = new Player();
				System.out.println("Enter Name");
				Scanner sc3=new Scanner(System.in);
				p.setName(sc3.nextLine());
				System.out.println("Enter Age");
				p.setAge(sc.nextInt());
				System.out.println("Enter mail id");
				p.setEmail(sc.next());
				System.out.println("Enter password");
				p.setPassword(AES.encrypt(sc.next(), "77"));
				System.out.println("Enter the image path");
				Scanner sc2 = new Scanner(System.in);
				FileInputStream stream = new FileInputStream(sc2.nextLine());
				byte[] arr = new byte[stream.available()];
				stream.read(arr);
				p.setImage(arr);
				System.out.println("Enter Phone number");
				p.setPhNumber(sc.nextLong());
				// ---------------------------------------------------------------
				System.out.println("Enter the Amount to deposite");
				double depositedAmount = sc.nextDouble();
				p.setDepositedAmount(depositedAmount);
				System.out.println("All the best");
				RandomNumberGenerator generator = new RandomNumberGenerator();
				int[] randomNumbers = generator.generator();
				double amountPreMatch = depositedAmount / 3;
				double totalEarnedAmount = 0;
				double profit = 0;
				for (int i = 0; i <= 2; i++) {
					System.out.println("Enter number");
					int no1 = sc.nextInt();
					if (no1 == randomNumbers[i]) {
						profit = profit + amountPreMatch;
						System.out.println("Congraluation..................");
					} else {
						depositedAmount = depositedAmount - amountPreMatch;
						System.out.println("oops wrong guess");
					}
				}
				totalEarnedAmount = profit + depositedAmount;
				p.setProfit(profit);
				p.setTotalearnedAmount(totalEarnedAmount);
				logic.addObject(p);
			}
				break;
			case 2: {
				System.out.println("Enter email to fetch the details");
				logic.fetchObject(sc.next());
			}
				break;
			case 3: {
				System.out.println("Enter email to delete the object");
				logic.deleteObject(sc.next());
			}
				break;
			case 4: {
				System.out.println("Enter email ");
				String email = sc.next();
				System.out.println("Enter new Name");
				Scanner sc2 = new Scanner(System.in);
				String newName = sc2.nextLine();
				logic.updateObject(email, newName);
			}
				break;
			case 5: {
				System.out.println("Thank you");
				flag = false;
			}
				break;
			default: {
				System.out.println("Invalid option");
			}
			}
		}

	}
}
