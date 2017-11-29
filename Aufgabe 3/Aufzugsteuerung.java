public class Aufzugsteuerung {

    int currentFloor;
    int minFloor;
    int maxFloor;
    IntQueue d = new IntQueue();
    //Door = false = Tür zu
    boolean door = false;


    Aufzugsteuerung(int currentFloor, int minFloor, int maxFloor) {
        this.currentFloor = currentFloor;
        this.minFloor = minFloor;
        this. maxFloor = maxFloor;
        this.door = door;
    }

    void request(int floor) {
        d.enqueue(floor);  
    }

    boolean getDoor() {
        return this.door;
    }
    void setDoor(boolean door) {
        this.door = door;
    }
    
    int getFloor() {
        return this.currentFloor;
    }

    void setFloor(int floor) {
        this.currentFloor = floor;
    }


    int action() {
        //Queue leer
        if(d.isEmpty()) {
            return 0;
        }
        int i = d.peek();
        // Tür zu & im richtigen Stockwerk
        if (currentFloor == i && getDoor() == true) {
            boolean b = false;
            setDoor(b);
            d.dequeue();
            return 3;
            
        }
        //Tür schließen
        if (currentFloor != i && getDoor() == false) {
            boolean a = true;
            setDoor(a);
            return 4;
        }
        //nach oben fahren
        if (getDoor() == true && getFloor() < i) {
                setFloor(getFloor()+1);
                return 1;                   
        }
        //nach unten fahren
        setFloor(getFloor()-1);
        return 2;

    }

}