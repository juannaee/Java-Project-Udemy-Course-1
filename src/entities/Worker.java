package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String workerName;
	private WorkerLevel workerLevel;
	private Double baseSalary;

	private Department department;
	private List<HourContract> listContract = new ArrayList<>();

	public Worker() {
	}

	public Worker(String workerName, WorkerLevel workerLevel, Double baseSalary, Department department) {
		super();
		this.workerName = workerName;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getListContract() {
		return listContract;
	}

	public void addContract(HourContract contract) {
		listContract.add(contract);

	}

	public void removeContract(HourContract contract) {
		listContract.remove(contract);
	}

	public double income(int year, int month) {
		double sum = baseSalary;
		LocalDate d01 = LocalDate.of(year, month, 0);
		for (HourContract obj : listContract) {
			int obj_year = d01.getYear();
			int obj_month = d01.getMonthValue();
			if (year == obj_year && month == obj_month) {
				sum += obj.TotalValue();
			}
		}

		return sum;

	}

	
}
