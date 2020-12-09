/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab12;

/**
 *
 * @author balpe
 */
public class Elevator {

    // uretilecek asansorun bilgileri olacak.
    private int floor = 0;
    private int destination = 0;
    private int capacity = 10;
    private int count_inside = 0; // Musteri bindikce atanacak deger
    private boolean active = false; // Atanacak deger
    private int elevatorID = 0; // Atanacak deger
    
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCount_inside() {
        return count_inside;
    }

    public void setCount_inside(int count_inside) {
        this.count_inside = count_inside;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getElevatorID() {
        return elevatorID;
    }

    public void setElevatorID(int elevatorID) {
        this.elevatorID = elevatorID;
    }
    
}
