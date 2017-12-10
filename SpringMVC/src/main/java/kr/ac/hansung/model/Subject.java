package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {
	private int id;
	
	@NotEmpty(message="subject_code Cannot be empty!")
	private String subject_code;

	private int year;

	@NotEmpty(message="division Cannot be empty!")
	private String division;

	@NotEmpty(message="name Cannot be empty!")
	private String name;

	@NotEmpty(message="semester Cannot be empty!")
	private String semester;

	private int credit;
	
	

}
