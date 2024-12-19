package com.example.bluemigoTest.Models;

public class Grade_Details {
	
    private String grade;
	private String grade_Grp;
	private String Grade_Grp1;
	private String vD_TYPE;
	private String GRADE_TYPE;
	private String rolling_MILL;
	private String Scrafting_Group;
	
	public Grade_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade_Details(String grade, String grade_Grp, String Grade_Grp1, String vD_TYPE, String GRADE_TYPE,
			String rolling_MILL, String Scrafting_Group) {
		super();
		this.grade = grade;
		this.grade_Grp = grade_Grp;
		this.Grade_Grp1 = Grade_Grp1;
		this.vD_TYPE = vD_TYPE;
		this.GRADE_TYPE = GRADE_TYPE;
		this.rolling_MILL = rolling_MILL;
		this.Scrafting_Group = Scrafting_Group;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade_Grp() {
		return grade_Grp;
	}

	public void setGrade_Grp(String grade_Grp) {
		this.grade_Grp = grade_Grp;
	}

	public String getGrade_Grp1() {
		return Grade_Grp1;
	}

	public void setGrade_Grp1(String grade_Grp1) {
		Grade_Grp1 = grade_Grp1;
	}

	public String getvD_TYPE() {
		return vD_TYPE;
	}

	public void setvD_TYPE(String vD_TYPE) {
		this.vD_TYPE = vD_TYPE;
	}

	public String getGRADE_TYPE() {
		return GRADE_TYPE;
	}

	public void setGRADE_TYPE(String gRADE_TYPE) {
		GRADE_TYPE = gRADE_TYPE;
	}

	public String getRolling_MILL() {
		return rolling_MILL;
	}

	public void setRolling_MILL(String rolling_MILL) {
		this.rolling_MILL = rolling_MILL;
	}

	public String getScrafting_Group() {
		return Scrafting_Group;
	}

	public void setScrafting_Group(String scrafting_Group) {
		Scrafting_Group = scrafting_Group;
	}
	
	
	
	
	
	
	

}
