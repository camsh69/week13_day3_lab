package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findByYear(2018);
		assertEquals(6, found.size());
	}

	@Test
	public void canGetDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findByRegion("Islay");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge() {
		List<Whisky> found = whiskyRepository.findByDistilleryNameAndAge("Blair Athol", 12);
		assertEquals(1, found.size());
		assertEquals("Flora and Fauna", found.get(0).getName());
	}

	@Test
	public void canGetAllWhiskiesFromRegion() {
		List<Whisky> found = whiskyRepository.findByDistilleryRegion("Lowland");
		assertEquals(4, found.size());
	}

	@Test
	public void canGetWhiskiesOfParticularAge() {
		List<Distillery> found = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, found.size());
	}
}
