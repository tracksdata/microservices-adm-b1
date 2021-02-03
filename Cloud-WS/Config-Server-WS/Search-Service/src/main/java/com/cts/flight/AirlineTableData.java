package com.cts.flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.AirlineInfo;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.FlightInfo;
import com.cts.flight.entity.Inventory;

@SpringBootApplication
public class AirlineTableData {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac= SpringApplication.run(AirlineTableData.class, args);
		
		FlightDao flightRepository = ac.getBean(FlightDao.class);
		
		List<Flight> flights = new ArrayList<>();
		List<AirlineInfo> airlines = new ArrayList<>();
		
		
		



		AirlineInfo a1 = new AirlineInfo("Air India", "airindia.png");
		AirlineInfo a2 = new AirlineInfo("Indigo", "indigo.png");
		AirlineInfo a3 = new AirlineInfo("Air Asia", "air-asia.png");
		AirlineInfo a4 = new AirlineInfo("Spicejet", "spicejet.png");
		AirlineInfo a5 = new AirlineInfo("Vistara", "vistara.png");
		AirlineInfo a6 = new AirlineInfo("Trujet", "truejet.png");
		AirlineInfo a7 = new AirlineInfo("GoAir", "goair.png");
		
		airlines.add(a1);
		airlines.add(a2);
		airlines.add(a3);
		airlines.add(a4);
		airlines.add(a5);
		airlines.add(a6);
		airlines.add(a7);
		
		
	
		
		FlightInfo f1=new FlightInfo("AI-840", "Airbus", 150);
		FlightInfo f2=new FlightInfo("AI-850", "Airbus", 150);
		FlightInfo f3=new FlightInfo("AI-860", "Airbus", 150);
		FlightInfo f4=new FlightInfo("AI-870", "Airbus", 150);
		
		FlightInfo f5=new FlightInfo("6E-6684", "Airbus", 150);
		FlightInfo f6=new FlightInfo("6E-6685", "Airbus", 150);
		FlightInfo f7=new FlightInfo("6E-6686", "Airbus", 150);
		FlightInfo f8=new FlightInfo("6E-6687", "Airbus", 150);
		
		FlightInfo f9=new FlightInfo("I5-755", "Airbus", 150);
		FlightInfo f10=new FlightInfo("I5-756", "Airbus", 150);
		FlightInfo f11=new FlightInfo("I5-757", "Airbus", 150);
		FlightInfo f12=new FlightInfo("I5-758", "Airbus", 150);
		
		FlightInfo f13=new FlightInfo("SG-432", "Airbus", 150);
		FlightInfo f14=new FlightInfo("SG-433", "Airbus", 150);
		FlightInfo f15=new FlightInfo("SG-434", "Airbus", 150);
		FlightInfo f16=new FlightInfo("SG-435", "Airbus", 150);
		
		FlightInfo f17=new FlightInfo("UK-830", "Airbus", 150);
		FlightInfo f18=new FlightInfo("UK-831", "Airbus", 150);
		FlightInfo f19=new FlightInfo("UK-832", "Airbus", 150);
		FlightInfo f20=new FlightInfo("UK-833", "Airbus", 150);
		
		FlightInfo f21=new FlightInfo("2T-518", "Airbus", 150);
		FlightInfo f22=new FlightInfo("2T-519", "Airbus", 150);
		FlightInfo f23=new FlightInfo("2T-520", "Airbus", 150);
		FlightInfo f24=new FlightInfo("2T-521", "Airbus", 150);
		
		FlightInfo f25=new FlightInfo("G8-424", "Airbus", 150);
		FlightInfo f26=new FlightInfo("G8-425", "Airbus", 150);
		FlightInfo f27=new FlightInfo("G8-426", "Airbus", 150);
		FlightInfo f28=new FlightInfo("G8-427", "Airbus", 150);
		
		
		a1.getFlights().add(f1);
		a1.getFlights().add(f2);
		a1.getFlights().add(f3);
		a1.getFlights().add(f4);
		
		a2.getFlights().add(f5);
		a2.getFlights().add(f6);
		a2.getFlights().add(f7);
		a2.getFlights().add(f8);
		
		a3.getFlights().add(f9);
		a3.getFlights().add(f10);
		a3.getFlights().add(f11);
		a3.getFlights().add(f12);
		
		a4.getFlights().add(f13);
		a4.getFlights().add(f14);
		a4.getFlights().add(f15);
		a4.getFlights().add(f16);
		
		
		a5.getFlights().add(f17);
		a5.getFlights().add(f18);
		a5.getFlights().add(f19);
		a5.getFlights().add(f20);
		
		a6.getFlights().add(f21);
		a6.getFlights().add(f22);
		a6.getFlights().add(f23);
		a6.getFlights().add(f24);
		
		a7.getFlights().add(f25);
		a7.getFlights().add(f26);
		a7.getFlights().add(f27);
		a7.getFlights().add(f28);
		
		
		//airlineDao.saveAll(airlines);
		

		flights.add(new Flight(f1.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2021, 2, 26),LocalTime.of(2, 12), new Fare(4800, "INR"),
				new Inventory(100),a1));
		flights.add(new Flight(f2.getFlightNumber(), "DELHI", "HYDERABAD","2 hrs 45 mins",  LocalDate.of(2021, 2, 26),LocalTime.of(1, 15), new Fare(3500, "INR"),
				new Inventory(100),a1));
		flights.add(new Flight(f3.getFlightNumber(), "CHENNAI", "MUMBAI","2 hrs 50 mins",  LocalDate.of(2021, 2, 26),LocalTime.of(2, 30), new Fare(5000, "INR"),
				new Inventory(100),a1));
		flights.add(new Flight(f4.getFlightNumber(), "PUNE", "HYDERABAD","1 hrs 45 mins",  LocalDate.of(2021, 2, 18),LocalTime.of(2, 45), new Fare(2546, "INR"),
				new Inventory(100),a1));
		flights.add(new Flight(f5.getFlightNumber(), "CHENNAI", "PORTBLAIR","3 hrs 00 mins",  LocalDate.of(2021, 2, 21),LocalTime.of(3, 00), new Fare(7500, "INR"),
				new Inventory(100),a2));
		flights.add(new Flight(f6.getFlightNumber(), "BENGULURU", "DELHI","3 hrs 15 mins",  LocalDate.of(2021, 2, 26),LocalTime.of(3, 15), new Fare(10000, "INR"),
				new Inventory(100),a2));
		flights.add(new Flight(f7.getFlightNumber(), "DELHI", "PUNE","3 hrs 07 mins",  LocalDate.of(2021, 4, 24),LocalTime.of(3, 15), new Fare(7438, "INR"),
				new Inventory(100),a2));
		flights.add(new Flight(f8.getFlightNumber(), "HYDERABAD", "MANGALORE","3 hrs 30 mins",  LocalDate.of(2021, 3, 18),LocalTime.of(3, 15), new Fare(8743, "INR"),
				new Inventory(100),a2));
		flights.add(new Flight(f9.getFlightNumber(), "MUMBAI", "AHMADABAD","6 hrs 00 mins",  LocalDate.of(2021, 2, 13),LocalTime.of(4, 30), new Fare(1955, "INR"),
				new Inventory(100),a3));
		flights.add(new Flight(f10.getFlightNumber(), "HYDERABAD", "KOLKATA","3 hrs 15 mins",  LocalDate.of(2021, 2, 27),LocalTime.of(4, 45), new Fare(2500, "INR"),
				new Inventory(100),a3));
		flights.add(new Flight(f11.getFlightNumber(), "KOLKATA", "DELHI","1 hrs 00 mins",  LocalDate.of(2021, 2, 26),LocalTime.of(7, 45), new Fare(4943, "INR"),
				new Inventory(100),a3));
		flights.add(new Flight(f15.getFlightNumber(), "DELHI", "MUMBAI","1 hrs 20 mins",  LocalDate.of(2021, 2, 26),LocalTime.of(11, 45), new Fare(4943, "INR"),
				new Inventory(100),a4));
		
		flights.add(new Flight(f16.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 10 mins", LocalDate.of(2021, 2, 26),LocalTime.of(2, 45), new Fare(4500, "INR"),
				new Inventory(100),a4));
		flights.add(new Flight(f17.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 05 mins", LocalDate.of(2021, 2, 26),LocalTime.of(10, 15), new Fare(6200, "INR"),
				new Inventory(100),a5));
		flights.add(new Flight(f18.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 14 mins", LocalDate.of(2021, 2, 26),LocalTime.of(11, 30), new Fare(5000, "INR"),
				new Inventory(100),a5));
		
		flights.add(new Flight(f19.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 12 mins", LocalDate.of(2021, 3, 17),LocalTime.of(11, 55), new Fare(1200, "INR"),
				new Inventory(120),a5));
		flights.add(new Flight(f20.getFlightNumber(), "DELHI", "CHENNAI","1 hrs 55 mins", LocalDate.of(2021, 2, 23),LocalTime.of(11, 55), new Fare(1389, "INR"),
				new Inventory(100),a5));
		flights.add(new Flight(f21.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 10 mins", LocalDate.of(2021, 2, 26),LocalTime.of(10, 15), new Fare(11000, "INR"),
				new Inventory(100),a6));
		flights.add(new Flight(f22.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 22 mins", LocalDate.of(2021, 2, 26),LocalTime.of(19, 35), new Fare(15000, "INR"),
				new Inventory(100),a6));
		flights.add(new Flight(f22.getFlightNumber(), "DELHI", "CHENNAI","1 hrs 45 mins", LocalDate.of(2021, 2, 26),LocalTime.of(6, 15), new Fare(3000, "INR"),
				new Inventory(100),a6));
		flights.add(new Flight(f23.getFlightNumber(), "DELHI", "CHENNAI","1 hrs 55 mins", LocalDate.of(2021, 2, 26),LocalTime.of(22, 45), new Fare(9000, "INR"),
				new Inventory(100),a6));
     //  flightRepository.saveAll(flights);

	}

}
