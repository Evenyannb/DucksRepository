package edu.iu.yanlian.demo;

import edu.iu.yanlian.demo.model.*;
import edu.iu.yanlian.demo.repository.DucksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DuckServiceApplicationTests {

	@Test
	void addDuck1() throws IOException {
		DucksRepository ducksRepository = new DucksRepository();
		Duck duck1 = new MallardDuck(1);
		ducksRepository.addDuck(duck1);
		Duck duck2 = new RedheadDuck(2);
		ducksRepository.addDuck(duck2);
		Duck duck3 = new RubberDuck(3);
		ducksRepository.addDuck(duck3);
		Duck duck4 = new DecoyDuck(4);
		ducksRepository.addDuck(duck4);
		ducksRepository.clear();
	}
	@Test
	void getDuck() throws IOException {
		DucksRepository ducksRepository = new DucksRepository();
		Duck duck1 = new MallardDuck(1);
		ducksRepository.addDuck(duck1);
		Duck duck2 = new RedheadDuck(2);
		ducksRepository.addDuck(duck2);
		Duck duck3 = new RubberDuck(3);
		ducksRepository.addDuck(duck3);
		Duck duck4 = new DecoyDuck(4);
		ducksRepository.addDuck(duck4);
		System.out.println(ducksRepository.findById(4).getType());
		System.out.println(ducksRepository.findById(2).getType());
		System.out.println(ducksRepository.findById(3).getType());
		System.out.println(ducksRepository.findById(1).getType());
		ducksRepository.clear();
	}

	@Test
	void addDuck2() throws IOException {
		DucksRepository ducksRepository = new DucksRepository();
		Duck duck6 = new MallardDuck(6);
		ducksRepository.addDuck(duck6);
		Duck duck7 = new RedheadDuck(7);
		ducksRepository.addDuck(duck7);
		Duck duck8 = new RubberDuck(8);
		ducksRepository.addDuck(duck8);
		Duck duck9 = new DecoyDuck(9);
		ducksRepository.addDuck(duck9);
		assertEquals(4, ducksRepository.getAllDucks().size());
		ducksRepository.clear();
	}

	@Test
	void getAllDucks() throws IOException {
		DucksRepository ducksRepository = new DucksRepository();
		Duck duck1 = new MallardDuck(1);
		ducksRepository.addDuck(duck1);
		Duck duck2 = new RedheadDuck(2);
		ducksRepository.addDuck(duck2);
		Duck duck3 = new RubberDuck(3);
		ducksRepository.addDuck(duck3);
		Duck duck4 = new DecoyDuck(4);
		ducksRepository.addDuck(duck4);
		List<Duck> duck = ducksRepository.getAllDucks();
		for(int i = 0; i < duck.size(); i++){
			System.out.println("ID: " + duck.get(i).getId() +" Type: " + duck.get(i).getType().toSting());
		}
		ducksRepository.clear();
	}

	@Test
	void search() throws IOException {
		DucksRepository ducksRepository = new DucksRepository();
		Duck duck1 = new MallardDuck(1);
		ducksRepository.addDuck(duck1);
		Duck duck2 = new RedheadDuck(2);
		ducksRepository.addDuck(duck2);
		Duck duck3 = new RubberDuck(3);
		ducksRepository.addDuck(duck3);
		Duck duck4 = new DecoyDuck(4);
		ducksRepository.addDuck(duck4);
		Duck duck6 = new MallardDuck(6);
		ducksRepository.addDuck(duck6);
		Duck duck7 = new RedheadDuck(7);
		ducksRepository.addDuck(duck7);
		Duck duck8 = new RubberDuck(8);
		ducksRepository.addDuck(duck8);
		Duck duck9 = new DecoyDuck(9);
		ducksRepository.addDuck(duck9);
		List<Duck> mallard = ducksRepository.search("MALLARD");
		for(int i = 0; i < mallard.size(); i++){
			System.out.println("ID: " + mallard.get(i).getId() +" Type: " + mallard.get(i).getType().toSting());
		}
		List<Duck> redhead = ducksRepository.search("REDHEAD");
		for(int i = 0; i < redhead.size(); i++){
			System.out.println("ID: " + redhead.get(i).getId() +" Type: " + redhead.get(i).getType().toSting());
		}
		List<Duck> rubber = ducksRepository.search("rubber");
		for(int i = 0; i < rubber.size(); i++){
			System.out.println("ID: " + rubber.get(i).getId() +" Type: " + rubber.get(i).getType().toSting());
		}
		List<Duck> deCoY = ducksRepository.search("DeCoY");
		for(int i = 0; i < deCoY.size(); i++){
			System.out.println("ID: " + deCoY.get(i).getId() +" Type: " + deCoY.get(i).getType().toSting());
		}
		ducksRepository.clear();


	}

}
