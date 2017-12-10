package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.DivisionNum;
import kr.ac.hansung.model.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDAO subjectDao;

	public List<Subject> getCurrent() {
		return subjectDao.getSubjects();
	}

	public void insert(Subject subject) {
		subjectDao.insert(subject);
		
	}

	public List<Subject> get2018() {
		
		return subjectDao.get2018();
	}

	public DivisionNum getDivisionNum() {
		// TODO Auto-generated method stub
		return subjectDao.getDivisionNum();
	}

}
