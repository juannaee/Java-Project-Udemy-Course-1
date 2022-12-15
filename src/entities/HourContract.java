package entities;

import java.util.Date;

public class HourContract {

	private Date contractDate;
	private Double valuePerHour;
	private Integer workedHours;

	public HourContract() {

	}

	public HourContract(Date contractDate, Double valuePerHour, Integer workedHours) {
		super();
		this.contractDate = contractDate;
		this.valuePerHour = valuePerHour;
		this.workedHours = workedHours;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(Integer workedHours) {
		this.workedHours = workedHours;
	}

	public Double TotalValue() {
		return valuePerHour * workedHours;
	}

}
