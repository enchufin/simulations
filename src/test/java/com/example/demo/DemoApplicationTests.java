package com.example.demo;

import com.example.demo.model.Enrollment;
import com.example.demo.model.Player;
import com.example.demo.model.TrafficTrial;
import com.example.demo.model.University;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TrafficTrialRepository;
import com.example.demo.repository.UniversityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	UniversityRepository universityRepository;
	@Autowired
	TrafficTrialRepository trafficTrialRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Test
	void createOneEnrollment() {

		String id1 = UUID.randomUUID().toString();
		Player p1 = new Player();
		p1.setId(id1);
		// we must set all the fields of p1

		String id2 = UUID.randomUUID().toString();
		Player p2 = new Player();
		p2.setId(id2);
		// we must set all the fields of p2

		String id3 = UUID.randomUUID().toString();
		Player p3 = new Player();
		p3.setId(id3);
		// we must set all the fields of p3

		String id4 = UUID.randomUUID().toString();
		Player p4 = new Player();
		p4.setId(id4);
		// we must set all the fields of p4

		playerRepository.save(p1);
		playerRepository.save(p2);
		playerRepository.save(p3);
		playerRepository.save(p4);
		// save all them on DB H2

		assertEquals(id1,
				playerRepository.findById(id1).get().getId());
		assertEquals(id2,
				playerRepository.findById(id2).get().getId());
		assertEquals(id3,
				playerRepository.findById(id3).get().getId());
		assertEquals(id4,
				playerRepository.findById(id4).get().getId());
		// CHECKOUT and compare the expected result with
		// the actual data on db

		String tt_id1 = UUID.randomUUID().toString();
		TrafficTrial tt1 = new TrafficTrial();
		tt1.setId(tt_id1);
		// we create a traffic trial object and set the id

		trafficTrialRepository.save(tt1);
		// we save it at DB H2

		String e_id1 = UUID.randomUUID().toString();
		Enrollment e1 = new Enrollment();
		e1.setId(e_id1);
		// We create the enrollment object

		tt1.addEnrollment(e1);
		p1.addEnrollment(e1);
		// assign

		e1.setPlayer(p1);
		e1.setTrafficTrial(tt1);
		// assign

		enrollmentRepository.save(e1);

		assertEquals(e_id1,
				enrollmentRepository.findById(e_id1).get().getId());

		System.out.println("e1-id: " + enrollmentRepository.findById(e_id1).get().getId());
		System.out.println("p1-id: " + enrollmentRepository.findById(e_id1).get().getPlayer().getId());
		System.out.println("tt1-id: " + enrollmentRepository.findById(e_id1).get().getTrafficTrial().getId());




	}

	@Test
	void createOneTrial_University() {

		String u_id1 = UUID.randomUUID().toString();
		University u1 = new University();
		u1.setId(u_id1);

		universityRepository.save(u1);

		String tt_id1 = UUID.randomUUID().toString();
		TrafficTrial tt1 = new TrafficTrial();
		tt1.setId(tt_id1);

		trafficTrialRepository.save(tt1);

		u1.addTrafficTrial(tt1);

		universityRepository.save(u1);

		System.out.println("u1-id: " + universityRepository.findById(u_id1).get().getId());
		System.out.println("tt1-id: " + trafficTrialRepository.findById(tt_id1).get().getId());

	}

}
