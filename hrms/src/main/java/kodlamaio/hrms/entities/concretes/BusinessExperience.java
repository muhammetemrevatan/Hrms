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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business_experience")
public class BusinessExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = Resume.class)
	private Resume cv;
	
	@Column(name = "business_name")
	@NotBlank(message = "İş adı alanı boş geçilemez")
	private String businessName;
	
	@Column(name = "business_position")
	@NotBlank(message = "İş pozisyonu alanı boş geçilemez")
	private String businessPosition;
	
	@Column(name = "year_of_start")
	@NotNull(message = "Başlangıç yılı boş geçilemez.")
	private Date yearOfStart;
	
	@Column(name = "year_of_end")
	private Date yearOfEnd;
	
	@Column(name = "created_date")
	@JsonIgnore
	private Date createdDate;
	
}
