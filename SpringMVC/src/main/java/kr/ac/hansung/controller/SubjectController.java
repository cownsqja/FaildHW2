 package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.DivisionNum;
import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/subject")
	public String showSubject(Model model){
		List<Subject> subject = subjectService.getCurrent();
		model.addAttribute("subject", subject);
		
		return "subject";
	}
	
	@RequestMapping("/수강신청하기")
	public String createSubject(Model model){
		
		model.addAttribute("subject", new Subject());
		
		return "createsubject";
	}
	
	@RequestMapping("/수강신청조회")
	public String FindSubject(Model model){
		
		List<Subject> subject = subjectService.get2018();
		
		
		model.addAttribute("subject", subject);
		
		return "2018View";
		
	}
	
	
	@RequestMapping("/이수 구분별 학점내역")
	public String FindByDivisionSubject(Model model){
		
		DivisionNum divison = subjectService.getDivisionNum();
		
		
		model.addAttribute("divison", divison);
		
		return "DivisonView";
		
	}
	@RequestMapping("/docreate")
	public String createSubject(Model model, @Valid Subject subject, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println("Form data does not validated");
			List<ObjectError>  errors = result.getAllErrors();
			
			for(ObjectError error:errors){
				System.out.println(error.getDefaultMessage());
			}
			return "createsubject";
		}
		
		subjectService.insert(subject);
		
		return "subjectcreated";
	}
} 
