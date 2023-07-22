package ru.bondarev.elevator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Elevator {

    /**
     * имя лифта
     */
    private  String name;

    /**
     * вместимость
     */
    private final  Integer passengerCapacity;


    /**
     * этаж на котором находится лифт
     */
    private Integer floor;
    /**
     * состояние лифта
     */
    private  String status;

    /**
     * едем вверх
     */
    public void moveUp(Integer floorNumber){

        status = "elevator move up";
        System.out.println(name +""+ status);
        floor = floorNumber;//присваиваем новое значение этажа где будет лифт
    }
    /**
     * едем вниз
     */
    public void moveDown(Integer floorNumber){

        status = "elevator move down";
        System.out.println(name +" "+ status);
        floor = floorNumber;//присваиваем новое значение этажа где будет лифт
    }
    /**
     * двери открыты
     */
    public void openDoors(){

        status = "elevator open doors";
        System.out.println(name +""+ status);
    }
    /**
     * двери закрыты
     */
    public void closeDoors(){

        status = "elevator close doors";
        System.out.println(name +""+ status);
    }
    /**
     * движение лифта к этажу пользователя(вызов лифта)
     */
    public void callElevator(Integer userFloor) throws InterruptedException {
        if(floor> userFloor){//если  лифт выше
            moveDown(userFloor);// лифт едет вниз
            Thread.sleep(2000);//ждем пока едет
            openDoors();//открываем двери
            System.out.println("Select floor number");

        }else if (floor < userFloor){//если  лифт ниже
            moveUp(userFloor);//  лифт едет вверх
            Thread.sleep(2000);//ждем пока едет
            openDoors();//открываем двери
            System.out.println("Select floor number");//выбираем этаж куда едем


        }else if (floor == userFloor) {// лифт на нашем этаже
            openDoors();//открываем двери
            System.out.println("Select floor number");//выбираем этаж куда едем

        }
    }
    /**
     * движение между этажами(пользователь в кабине)
     * передаем в метод нужный нам этаж
     */
    public void movingBetweenFloor(Integer futureFloor) throws InterruptedException {
        if (futureFloor>floor){//если нужный этаж выше
            closeDoors();//закрыли двери
            moveUp(futureFloor);// едем вверх
            Thread.sleep(2000);
            openDoors();//открываем двери
            System.out.println("You are on the floor "+futureFloor);
            closeDoors();//закрываем двери

        }else  if(futureFloor<floor){//если нужный этаж ниже
            closeDoors();//закрыли двери
            moveDown(futureFloor);//едем вниз
            Thread.sleep(2000);
            openDoors();//открываем двери
            System.out.println("You are on the floor "+futureFloor);
            closeDoors();//закрываем двери

        }
    }
}
