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
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Candidate extends User{
	
	@NotBlank(message = "İsim alanı boş bırakılamaz.")
	@Size(min = 3, message = "İsim alanı 3 karakterden az olamaz.")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim alanı boş bırakılamaz.")
	@Size(min = 3, message = "Soyisim alanı 3 karakterden az olamaz.")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "TC kimlik numarası alanı boş bırakılamaz.")
	@Size(min = 11, max = 11, message = "Tc kimlik alanı 11 haneli olmalıdır.")
	@Column(name = "identity_number")
	private String identityNumber;
	
	@NotBlank(message = "Doğum yılı alanı boş bırakılamaz.")
	@Column(name = "birth_of_date")
	private String birthDate;
}
