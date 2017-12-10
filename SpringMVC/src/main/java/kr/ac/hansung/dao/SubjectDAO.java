package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.DivisionNum;
import kr.ac.hansung.model.Subject;

@Repository
public class SubjectDAO {
	private JdbcTemplate jdbctemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbctemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from subject";
		return jdbctemplate.queryForObject(sqlStatement, Integer.class);
	}

	public Subject getSubject(String subject_code) {
		String sqlStatement = "select * from subject where subject_code=?";

		return jdbctemplate.queryForObject(sqlStatement, new Object[] {subject_code}, new RowMapper<Subject>() {
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setSubject_code(rs.getString("subject_code"));
				subject.setYear(rs.getInt("year"));
				subject.setDivision(rs.getString("division"));
				subject.setName(rs.getString("name"));
				subject.setSemester(rs.getString("semester"));
				subject.setCredit(rs.getInt("credit"));
				
				return subject;
			}

		});
	}

	public List<Subject> getSubjects() {
		String sqlStatement = "select * from subject ";

		return jdbctemplate.query(sqlStatement, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setSubject_code(rs.getString("subject_code"));
				subject.setYear(rs.getInt("year"));
				subject.setDivision(rs.getString("division"));
				subject.setName(rs.getString("name"));
				subject.setSemester(rs.getString("semester"));
				subject.setCredit(rs.getInt("credit"));
				return subject;
			}

		});
	}

	public boolean insert(Subject subject) {
		String subject_code = subject.getSubject_code();
		int year = subject.getYear();
		String division = subject.getDivision();
		String name = subject.getName();
		String semester = subject.getSemester();
		int credit = subject.getCredit();

		String sqlStatement = "insert into subject (subject_code, year, division, name, semester, credit) values (?,?,?,?,?,?)";

		return (jdbctemplate.update(sqlStatement,
				new Object[] { subject_code, year, division, name, semester, credit }) == 1);
	}

	public boolean update(Subject subject) {
		
		int id = subject.getId();
		String subject_code = subject.getSubject_code();
		int year = subject.getYear();
		String division = subject.getDivision();
		String name = subject.getName();
		String semester = subject.getSemester();
		int credit = subject.getCredit();
		
		System.out.println("업데이트문" + id + subject_code+ year+ division+ name+ semester+ credit);

		String sqlStatement = "update subject set subject_code=?, year=?, division=?, name=?, semester=?, credit=? where id=?";
		return (jdbctemplate.update(sqlStatement,
				new Object[] { subject_code,year, division, name, semester, credit,id}) == 1);
	}

	public boolean delete(int id) {
		String sqlStatement = "delete from subject where id=?";
		return (jdbctemplate.update(sqlStatement, new Object[] { id }) == 1);
	}

	public List<Subject> get2018() {
		String sqlStatement = "select * from subject where year=2018 and semester = '1학기'  ";

		return jdbctemplate.query(sqlStatement, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setSubject_code(rs.getString("subject_code"));
				subject.setYear(rs.getInt("year"));
				subject.setDivision(rs.getString("division"));
				subject.setName(rs.getString("name"));
				subject.setSemester(rs.getString("semester"));
				subject.setCredit(rs.getInt("credit"));
				return subject;
			}

		});
	}

	public DivisionNum getDivisionNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
 