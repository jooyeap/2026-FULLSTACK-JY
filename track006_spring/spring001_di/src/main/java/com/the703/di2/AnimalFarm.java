package com.the703.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component("animalFarm") // id 값
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalFarm {
	@Value("bobo") // 벨류값
	private String name;
	
	@Autowired @Qualifier("dog") // id 값
	private Animal ani;
	
	public String aniEat() {return name + ">" + ani.eat();}
	public String aniSleep() {return name + ">" + ani.sleep();}
	public String aniPoo() {return name + ">" + ani.poo();}
	
	public void print() {
		System.out.println(aniEat());
		System.out.println(aniSleep());
		System.out.println(aniPoo());
	}
}
