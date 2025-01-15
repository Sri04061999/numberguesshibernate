package gamingappflow.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
public class Player {
	private String name;
	@Id
	private String email;
	@Column(nullable = false)
	private int age;
	@Column(unique = true,nullable = false)
	private String password;
	@Column(length = 10,unique = true)
	private long phNumber;
	private double depositedAmount;
	private double totalearnedAmount;
	private double profit;
	@Lob
	private byte[] image;
	@CreationTimestamp
	private Date playedTime;
	@UpdateTimestamp
	private Date updatedTime;
}
