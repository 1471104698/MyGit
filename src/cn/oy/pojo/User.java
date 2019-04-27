package cn.oy.pojo;

public class User {
	private String id;
	private String uname;
	private String upwd;
	private String sex;
	private int age;
	private String grade;
	private String dire;
	private String tel; 
	private String sta;
	private String iden;
	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}
	public String getStatus() {
		return sta;
	}
	public void setStatus(String status) {
		this.sta = status;
	}
	public User(String id, String uname, String upwd, String sex, int age, String grade, String dire, String tel, String status,
			String intro) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
		this.dire = dire;
		this.tel = tel;
		this.sta = status;
		this.intro = intro;
	}
	public User(String id, String uname, String upwd, String sex, int age, String grade, String dire, String tel,
			String intro) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
		this.dire = dire;
		this.tel = tel;
		this.intro = intro;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDire() {
		return dire;
	}
	public void setDire(String dire) {
		this.dire = dire;
	}
	private String intro;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upwd=" + upwd + ", sex=" + sex + ", age=" + age + ", grade="
				+ grade + ", dire=" + dire + ", tel=" + tel + ", sta=" + sta + ", intro=" + intro + "]";
	}
	
	
}
