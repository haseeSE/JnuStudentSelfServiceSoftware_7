package com.jnu.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jnu.model.Score;

public class ScoreTest {

	private Score score;
	
	@Before
	public void setUp() throws Exception {
		score = new Score();
	}

	@Test
	public void testGetStudy_type() {
		assertNull(score.getStudy_type());
	}

	@Test
	public void testSetStudy_type() {
		String str = "String";
		score.setStudy_type(str);
		assertEquals(str, score.getStudy_type());
	}

	@Test
	public void testGetAcademic_year() {
		assertNull(score.getAcademic_year());
	}

	@Test
	public void testSetAcademic_year() {
		String str = "String";
		score.setAcademic_year(str);
		assertEquals(str, score.getAcademic_year());
	}

	@Test
	public void testGetTerm() {
		assertNull(score.getTerm());
	}

	@Test
	public void testSetTerm() {
		String str = "String";
		score.setTerm(str);
		assertEquals(str, score.getTerm());
	}

	@Test
	public void testGetCourse() {
		assertNull(score.getCourse());
	}

	@Test
	public void testSetCourse() {
		String str = "String";
		score.setCourse(str);
		assertEquals(str, score.getCourse());
	}

	@Test
	public void testGetCredit() {
		assertNull(score.getCredit());
	}

	@Test
	public void testSetCredit() {
		String str = "String";
		score.setCredit(str);
		assertEquals(str, score.getCredit());
	}

	@Test
	public void testGetGrades() {
		assertNull(score.getGrades());
	}

	@Test
	public void testSetGrades() {
		String str = "String";
		score.setGrades(str);
		assertEquals(str, score.getGrades());
	}

	@Test
	public void testGetGPA() {
		assertNull(score.getGPA());
	}

	@Test
	public void testSetGPA() {
		String str = "String";
		score.setGPA(str);
		assertEquals(str, score.getGPA());
	}

	@Test
	public void testGetExam_date() {
		assertNull(score.getExam_date());
	}

	@Test
	public void testSetExam_date() {
		String str = "String";
		score.setExam_date(str);
		assertEquals(str, score.getExam_date());
	}

	@Test
	public void testGetExam_properties() {
		assertNull(score.getExam_properties());
	}

	@Test
	public void testSetExam_properties() {
		String str = "String";
		score.setExam_properties(str);
		assertEquals(str, score.getExam_properties());
	}

	@Test
	public void testGetCourse_type() {
		assertNull(score.getCourse_type());
	}

	@Test
	public void testSetCourse_type() {
		String str = "String";
		score.setCourse_type(str);
		assertEquals(str, score.getCourse_type());
	}

	@Test
	public void testGetStatus() {
		assertNull(score.getStatus());
	}

	@Test
	public void testSetStatus() {
		String str = "String";
		score.setStatus(str);
		assertEquals(str, score.getStatus());
	}

}
