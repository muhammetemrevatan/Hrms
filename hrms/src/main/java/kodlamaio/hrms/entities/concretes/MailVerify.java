package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "mail_verify")
@NoArgsConstructor
@AllArgsConstructor
public class MailVerify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@Column(name = "verify_code")
	private String verifyCode;
	@Column(name = "is_verified")
	@JsonIgnore
	private boolean isVerified;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "confirmed_date")
	private Date comfirmedDate;
}
