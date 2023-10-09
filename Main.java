import java.util.ArrayList;
import java.util.List;

interface BuildingComponent {
    void displayStructure();
}

class Room implements BuildingComponent {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public void displayStructure() {
        System.out.println("Room: " + name);
    }
}

class Facility implements BuildingComponent {
    private String name;

    public Facility(String name) {
        this.name = name;
    }

    @Override
    public void displayStructure() {
        System.out.println("Facility: " + name);
    }
}

class Floor implements BuildingComponent {
    private List<BuildingComponent> components = new ArrayList<>();
    private String name;

    public Floor(String name) {
        this.name = name;
    }

    public void addComponent(BuildingComponent component) {
        components.add(component);
    }

    @Override
    public void displayStructure() {
        System.out.println("Floor: " + name);
        for (BuildingComponent component : components) {
            System.out.print("  ");
            component.displayStructure();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Room livingRoom = new Room("Living Room");
        Room bedroom = new Room("Bedroom");
        Room kitchen = new Room("Kitchen");

        Facility gym = new Facility("Gym");
        Facility pool = new Facility("Pool");

        Floor groundFloor = new Floor("Ground Floor");
        groundFloor.addComponent(livingRoom);
        groundFloor.addComponent(kitchen);

        Floor firstFloor = new Floor("First Floor");
        firstFloor.addComponent(bedroom);

        Floor facilitiesFloor = new Floor("Facilities Floor");
        facilitiesFloor.addComponent(gym);
        facilitiesFloor.addComponent(pool);

        System.out.println("Building Structure:");
        groundFloor.displayStructure();
        firstFloor.displayStructure();
        facilitiesFloor.displayStructure();
    }
}
