package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_confirm")
public class EmployeeConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = Employer.class)
	private Employer employer;
	
	@ManyToOne(targetEntity = Employee.class)
	private Employee employee;
	
	@Column(name = "confirmed_date")
	private Date confirmedDate;
	
	@Column(name = "is_confirmed")
	@JsonIgnore
	private boolean isConfirmed;
}
