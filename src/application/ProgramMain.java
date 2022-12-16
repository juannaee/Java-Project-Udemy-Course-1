package application;

import java.time.LocalDate;
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
		System.out.println("Level:");
		String workerLevel = read.nextLine();
		System.out.println("Base salary:");
		Double baseSalary = read.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.println("How many contracts to this worker?");
		int numberContracts = read.nextInt();

		DateTimeFormatter dtm01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (int i = 0; i < numberContracts; i++) {
			int aux = 1;
			aux += i;
			System.out.println();
			System.out.println("Enter contract" + "#" + aux + " data:");
			System.out.println("Date (DD/MM/YYYY)");
			LocalDate dateContract = (LocalDate) dtm01.parse(read.next());
			System.out.println("Value per hour:");
			double valuePerhour = read.nextDouble();
			System.out.println("Duration (hours):");
			int workedHours = read.nextInt();
			System.out.println();
			HourContract hourContract = new HourContract(dateContract, valuePerhour, workedHours);
			worker.addContract(hourContract);
		}
		System.out.println("Enter month and year to calculate income (MM/YYYY):");
		System.out.println("enter the month:");
		int month = read.nextInt();
		System.out.println("enter the year:");
		int year = read.nextInt();
		DateTimeFormatter dtm02 = DateTimeFormatter.ofPattern("MM/yyyy");
		LocalDate dateAux = LocalDate.of(year, month, 0);
		System.out.println("Name: " + worker.getWorkerName());
		System.out.println("Department: " + worker.getDepartment().getNameDepartment());
		System.out.println("Income For:" + dateAux.format(dtm02) + " :" + worker.income(year, month));

		read.close();

	}

}
