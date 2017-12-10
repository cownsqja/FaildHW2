package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@ToString
public class DivisionNum {
	private String ryvlf;
	private String gorry;
	private String wjswl;
	private String wjsrl;
	private String wjstjs;
	private String total;
}
