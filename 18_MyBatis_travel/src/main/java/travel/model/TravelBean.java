package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private int num;
	
	@NotEmpty(message="�̸��� �ʼ� �Է� �����Դϴ�.")
	private String name;
	
//	@Min(value = 10, message = "���̴� �ּ� 10�� �̻��Դϴ�.")
//	@Max(value = 100, message = "���̴� �ִ� 100�� �̻��Դϴ�.")
	@Range(min=10, max=100, message="10��~100��� �ۼ��ؾ� �մϴ�.")
	private int age; 
	
	@NotEmpty(message="���������� 1�� �̻� �����ؾ� �մϴ�.")
	private String area;
	
	@NotEmpty(message="���ϴ� ���� Ÿ���� �������ּ���.")
	private String style;
	
	@NotEmpty(message="���ϴ� ���ݴ븦 �����ϼ���.")
	private String price;
	
	public TravelBean() {
		
	}
	public TravelBean(int num, String name, int age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
