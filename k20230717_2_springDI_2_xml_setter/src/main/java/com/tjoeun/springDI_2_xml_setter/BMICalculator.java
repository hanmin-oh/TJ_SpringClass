package com.tjoeun.springDI_2_xml_setter;

public class BMICalculator {
	
//	키(height)와 몸무게(weight)를 인수로 넘겨받아 BMI 지수를 계산하고 등급을 출력하는 메소드
//	BMI 지수는 몸무게(kg) / ( 키(cm) * 키(cm) )
//	산출된 값이 18.5 미만이면 저체중, 18.5 이상 23 미만이면 정상, 23 이상 25 미만이면 과체중, 25 이상이면 비만
	public void bmiCalculator(double height , double weight) {
		double bmi = weight / (height / 100 * height / 100);
		System.out.print("키(" + height / 100 + "m, 몸무게(" + weight + "kg)의 bmi는 " + bmi + "이고 ");
		if(bmi < 18.5) {
			System.out.println("저체중입니다.");
		} else if (bmi >= 18.5 && bmi < 23) {
			System.out.println("정상입니다.");
		} else if (bmi >= 25 && bmi <25) {
			System.out.println("과체중입니다.");
		} else {
			System.out.println("비만입니다.");
		}
	}

}
