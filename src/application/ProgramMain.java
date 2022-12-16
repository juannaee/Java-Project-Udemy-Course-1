package application;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class ProgramMain {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		System.out.println("Enter department's name:");
		String departmentName = read.nextLine();

		System.out.println("Enter worker data:");
		System.out.println("Name:");
		String workerName = read.nextLine();

		String workerLevel = "";
		int opcaoMenu = 0;

		do {
			System.out.printf("Choose your seniority: %n 1 - Senior %n 2 - Mid_Level %n 3 - Junior");
			opcaoMenu = read.nextInt();

			switch (opcaoMenu) {
			case 1: {
				workerLevel = "SENIOR";
				break;
			}

			case 2: {
				workerLevel = "MID_LEVEL";
				break;

			}

			case 3: {
				workerLevel = "JUNIOR";
				break;
			}
			default: {
				System.out.println("Non-existent option, try again!!");
			}
			}

		} while (opcaoMenu != 1 && opcaoMenu != 2 && opcaoMenu != 3);

		System.out.println("Base salary:");
		Double baseSalary = read.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.println("How many contracts to this worker?");
		int numberContracts = read.nextInt();

		for (int i = 0; i < numberContracts; i++) {
			int aux = 1;
			aux += i;
			System.out.println();
			System.out.println("Enter contract" + "#" + aux + " data:");
			System.out.println("enter the day:");
			int day = read.nextInt();
			System.out.printf("%d/MM/yyyy", day);
			System.out.println();
			System.out.println("enter the month:");
			int month = read.nextInt();
			System.out.printf("%d/%d/yyyy", day, month);
			System.out.println();
			System.out.println("enter the year:");
			int year = read.nextInt();
			System.out.printf("%d/%d/%d", day, month, year);
			System.out.println();
			LocalDate dateContract = LocalDate.of(year, month, day);

			System.out.println("Value per hour:");
			double valuePerhour = read.nextDouble();
			System.out.println("Duration (hours):");
			int workedHours = read.nextInt();
			System.out.println();
			HourContract hourContract = new HourContract(dateContract, valuePerhour, workedHours);
			worker.addContract(hourContract);
		}
		System.out.println("Enter month and year to calculate income");
		System.out.println("enter the month:");
		int month = read.nextInt();
		System.out.println("enter the year:");
		int year = read.nextInt();
		DateTimeFormatter dmt1 = DateTimeFormatter.ofPattern("MM/yyyy");
		YearMonth dateAux = YearMonth.of(year, month);
		System.out.println();
		System.out.println("Name: " + worker.getWorkerName());
		System.out.println("Department: " + worker.getDepartment().getNameDepartment());
		System.out.println("Worker Level: " + worker.getWorkerLevel());
		System.out.println("Total Income in the period " + dateAux.format(dmt1) + ": R$"
				+ String.format("%.2f", worker.income(year, month)));

		read.close();

	}

}
