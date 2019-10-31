package comt.tieunt.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Address {
	@Id
	@GeneratedValue
	private Long id;

	private String city;
	private String provice;

	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;
}
