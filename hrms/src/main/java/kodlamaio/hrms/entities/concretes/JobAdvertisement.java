package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private int id;
	
	@ManyToOne(targetEntity = JobPosition.class)
	private JobPosition jobPosition;
	
	@NotBlank(message = "İş tanımı alanı boş bırakılamaz.")
	@Size(min = 10, message = "İş tanımı alanı 10 ile 50 karakter aralığında olmalıdır.")
	@Column(name = "job_description")
	private String jobDescription;
	
	@ManyToOne(targetEntity = City.class)
	private City city;
	
	@NotBlank(message = "Minimum maaş alanı boş bırakılamaz.")
	@Size(min = 3, max = 8, message = "Minimum maaş alanı 3 ile 8 karakter aralığında olmalıdır.")
	@Column(name = "salary_min")
	private String salaryMin;
	
	@Size(min = 3, max = 8, message = "Maksimum maaş alanı 3 ile 8 karakter aralığında olmalıdır.")
	@Column(name = "salary_max")
	private String salaryMax;
	
	@Size(min = 1, max = 3, message = "Açık pozisyon adeti alanı 1 ile 3 karakter aralığında olmalıdır.")
	@Column(name = "open_position_number")
	private String openPositionNumber;
	
	@Column(name = "is_active")
	private boolean isActive;

	@NotBlank(message = "Son başvuru tarihi alanı boş bırakılamaz.")
	@Column(name = "deadline")
	private String deadline;
	
	@Column(name = "created_date")
	@JsonIgnore
	private Date createdDate;
	
	@ManyToOne(targetEntity = Employer.class)
	private Employer employer;
	
	@Column(name="employee_confirm")
	private boolean employeeConfirm;
	
	@ManyToOne(targetEntity = WayOfWork.class)
	private WayOfWork wayOfWork;
	
	@ManyToOne(targetEntity = WorkType.class)
	private WorkType workType;
	
	
	
}
