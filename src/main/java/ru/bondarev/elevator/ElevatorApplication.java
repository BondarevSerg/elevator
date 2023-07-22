package ru.bondarev.elevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bondarev.elevator.entity.Elevator;

import java.util.Scanner;

@SpringBootApplication
public class ElevatorApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ElevatorApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		Elevator bigElevator = new Elevator("Big ",10, 14,"стоит на 14 этаже");
		Elevator smallElevator = new Elevator("Small ",5, 10, "стоит на 10 этаже");

		System.out.println("Select floor number"); //кнопка вызова лифта. передаем номер этажа
		int userFloor = scanner.nextInt();
		System.out.println("How many people go to elevator");//сколько пассажиров поедет
		int passengers = scanner.nextInt();

		if(smallElevator.getPassengerCapacity()>=passengers){//если пассажиров не больше грузоподьемности малого лифта,
			// то едет он

			smallElevator.callElevator(userFloor);
			int futureFloor = scanner.nextInt();
			smallElevator.movingBetweenFloor(futureFloor);


		}else {

			bigElevator.callElevator(userFloor);
			int futureFloor = scanner.nextInt();
			bigElevator.movingBetweenFloor(futureFloor);

		}

	}

}
