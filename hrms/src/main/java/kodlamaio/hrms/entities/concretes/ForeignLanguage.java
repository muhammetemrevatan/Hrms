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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foreign_language")
public class ForeignLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = Resume.class)
	private Resume cv;
	
	@Column(name = "language_name")
	@NotBlank(message = "Yabancı dil ismini girmek zorunludur.")
	@Size(max = 25,message = "Yabancı dil adı maksimum 25 karakterli olabilir.")
	private String languageName;
	
	@Column(name = "language_level")
	private char languageLevel;
	
	@Column(name = "created_date")
	@JsonIgnore
	private Date createdDate;
}
