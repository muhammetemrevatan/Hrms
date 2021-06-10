package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employer extends User{
	
	@NotBlank(message="Şirket ismi alanı boş bırakılamaz")
	@Column(name="company_name")
	@Size(max = 100,message = "Şirket ismi alanı maximum 100 haneli olabilir.")
	private String companyName;
	
	@NotBlank(message="Web sitesi alanı boş bırakılamaz")
	@Column(name="web_address")
	@Size(max = 50,message = "web adresi maximum 50 haneli olabilir.")
	private String webAddress;
	
	@NotBlank(message="Telefon numarası alanı boş bırakılamaz")
	@Column(name="phone_number")
	@Size(min = 11,max = 11,message = "Telefon alanı 11 haneli olmalıdır.")
	private String phoneNumber;
}
