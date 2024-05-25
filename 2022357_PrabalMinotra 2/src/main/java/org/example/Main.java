package org.example;

import java.util.*;
import java.util.HashMap;



class Ticket {
    private String attractionName;
    private double price;
    private boolean isAvailable;

    public Ticket(String attractionName, double price) {
        this.attractionName = attractionName;
        this.price = price;
        this.isAvailable = true;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

interface sound{
    public String makeSound();

}

class Visitor {
    private String name;
    private int age;
    private String phone;
    private double balance;
    private String email;
    private String password;
    private int visitorPremium;

    public Visitor(String name, int age, String phone, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
        this.email = email;
        this.password = password;
    }

    public int getVisitorPremium(){
        return visitorPremium;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPremium() {
        this.visitorPremium = 1;
    }
}




class Animal {
    private String animalName;
    private String animalType;
    private String sound;


    public Animal(String name, String type) {
        this.animalName = name;
        this.animalType = type;
    }



    public String getName() {
        return animalName;
    }

    public String getType() {
        return animalType;
    }

    public void setName(String newAnimalName) {
        this.animalName = newAnimalName;
    }

    public void setType(String newAnimalType) {
        this.animalType = newAnimalType;
    }

    public String makeSound() {
        return "-";
    }


}

class Mammal extends Animal implements sound{
    public Mammal(String name) {
        super(name, "Mammal");
    }

    public String sound = "Growl";

    @Override
    public String makeSound() {
        return sound;
    }
}

class Amphibian extends Animal implements sound{
    public Amphibian(String name) {
        super(name, "Amphibian");
    }
    public String sound = "Groak";
    @Override
    public String makeSound() {
        return sound;
    }

}

class Reptile extends Animal implements sound{
    public Reptile(String name) {
        super(name, "Reptile");
    }
    public String sound = "Hiss";
    @Override
    public String makeSound() {
        return sound;
    }

    // Implement methods specific to reptiles if needed
}

class Feedback {
    private String visitorName;
    private int rating;
    private String comment;

    public Feedback(String visitorName, String comment) {
        this.visitorName = visitorName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}



class attractions {
    private static final int MAX_TICKETS = 1200;
    private String name;
    private int uniqueID;
    private double ticketPrice;
    private String attdesc;
    private int ticketedVisitors;
    private boolean isOpen;
    private List<String> events;
    private List<Animal> animals;
    private int mammalsCount;
    private int amphibiansCount;
    private int reptilesCount;
    private List<Ticket> tickets;

    private int numberOfTicketsBought = 0;

    public attractions(String name, int uniqueID, double ticketPrice, String attdesc) {
        this.name = name;
        this.uniqueID = uniqueID;
        this.ticketPrice = ticketPrice;
        this.attdesc = attdesc;
        this.ticketedVisitors = 0;
        this.isOpen = false; // Closed by default
        this.events = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.mammalsCount = 0;
        this.amphibiansCount = 0;
        this.reptilesCount = 0;
        this.tickets = new ArrayList<>();
        // Create and add tickets for this attraction
        for (int i = 0; i < MAX_TICKETS; i++) {
            this.tickets.add(new Ticket(name,ticketPrice));
        }
    }
    //Object Class Method
    public String toString(){
        return "Description: " + this.attdesc;

    }
    public int getNumberOfTicketsBought(){
        return numberOfTicketsBought;
    }
    public void setNumberOfTicketsBought(){
        this.numberOfTicketsBought++;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketedPrice(double price){
        this.ticketPrice = price;
    }
    public String getAttdesc(){
        return attdesc;
    }
    public void setAttdesc(String attdesc){
        this.attdesc = attdesc;
    }

    public int getTicketedVisitors() {
        return ticketedVisitors;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void addEvent(String event) {
        events.add(event);
    }

    public void removeEvent(String event) {
        events.remove(event);
    }

    public List<String> getEvents() {
        return events;
    }
    public List<Animal> getAnimals() {
        return animals;
    }

    public void scheduleEvent(String event, boolean open) {
        if (open) {
            events.add(event);
        } else {
            events.remove(event);
        }
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void openAttraction() {
        isOpen = true;
    }

    public void closeAttraction() {
        isOpen = false;
    }

    public void incrementTicketedVisitors() {
        ticketedVisitors++;
    }

    public void decrementTicketedVisitors() {
        ticketedVisitors--;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        // Increment the appropriate animal type counter
        String animalType = animal.getType();
        switch (animalType) {
            case "Mammal":
                mammalsCount++;
                break;
            case "Amphibian":
                amphibiansCount++;
                break;
            case "Reptile":
                reptilesCount++;
                break;
        }
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        // Decrement the appropriate animal type counter
        String animalType = animal.getType();
        switch (animalType) {
            case "Mammal":
                mammalsCount--;
                break;
            case "Amphibian":
                amphibiansCount--;
                break;
            case "Reptile":
                reptilesCount--;
                break;
        }
    }

    public int getMammalsCount() {
        return this.mammalsCount;
    }
    public int getAmphibiansCount() {
        return this.amphibiansCount;
    }
    public int getReptilesCount() {
        return this.reptilesCount;
    }

    public void updateAnimalType(Animal animal, String newType) {
        for (Animal existingAnimal : animals) {
            if (existingAnimal.equals(animal)) {
                // Assuming you have a method to update the type of the animal
                existingAnimal.setType(newType);
                return;
            }
        }
    }

    public void setTicketedVisitors() {
        this.ticketedVisitors++;
    }

}

abstract class Admin {
    private String adminUsername;
    private String adminPassword;

    public Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

}
class SuperAdmin extends Admin {
    public SuperAdmin(String adminUsername, String adminPassword) {
        super(adminUsername, adminPassword);
    }


}





public class Main {
    public static void main(String[] args) {
        int idassigned=0;

        Scanner scanner = new Scanner(System.in);
        List<Visitor> registeredVisitors = new ArrayList<>();
        List<attractions> attractions = new ArrayList<attractions>(); // Create a list to store attractions
        List<Feedback> feedbackList = new ArrayList<>();
        Map<String, Double> discounts = new HashMap<>();
        Map<Integer, Double> specialDeals = new HashMap<>();
        List<Animal> animals = new ArrayList<>();
        List<Ticket> tickets = new ArrayList<>();
        int netVisitors = 0;
        double netRevenue = 0;

        int p;
        for(p=1;p<100;p++){
            specialDeals.put(p,0.0);
        }
        discounts.put("minor",10.0);
        discounts.put("senior",20.0);


        SuperAdmin admin = new SuperAdmin("prabal","prabal12");
        System.out.println("---------------------------------");
        System.out.println("---Welcome to ZOOTOPIA---");
        System.out.println("---------------------------------");

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input should be an integer");
            }
            scanner.nextLine(); // Consume newline
            if (choice > 3 || choice < 1) {
                System.out.println("Invalid Command; Range {1,2,3}");
                System.out.println("---------------------------------");

                continue;
            }
            //______________________________________________________________________________//
            if (choice == 1) {
                System.out.println("Enter Admin Username: ");
                String adminUsernameIn = scanner.nextLine();
                if (adminUsernameIn.equals(admin.getAdminUsername())) {
                    System.out.println("Enter Admin Password: ");
                    String adminPass = scanner.nextLine();
                    if (adminPass.equals(admin.getAdminPassword()) && adminUsernameIn.equals(admin.getAdminUsername())) {

                        while (true) {
                            System.out.println("---------------------------------");
                            System.out.println("1. Manage Attractions");
                            System.out.println("2. Manage Animals");
                            System.out.println("3. Schedule Events");
                            System.out.println("4. Set Discounts");
                            System.out.println("5. Set Special Deal");
                            System.out.println("6. View Visitor Stats");
                            System.out.println("7. View Feedback");
                            System.out.println("8. Exit");
                            System.out.println("---------------------------------");
                            System.out.print("Enter your choice: ");

                            int adminChoice = scanner.nextInt();
                            System.out.println("---------------------------------");
                            scanner.nextLine();

                            if (adminChoice == 1) {
                                while (true) {
                                    System.out.println("---------------------------------");
                                    System.out.println("1. Add Attraction");
                                    System.out.println("2. View Attractions");
                                    System.out.println("3. Modify Attraction");
                                    System.out.println("4. Remove Attraction");
                                    System.out.println("5. Exit");
                                    System.out.println("---------------------------------");
                                    System.out.print("Enter your choice: ");
                                    int attchoice = scanner.nextInt();
                                    System.out.println("---------------------------------");

                                    scanner.nextLine(); // Consume newline
                                    if (attchoice > 5 || attchoice < 1) {
                                        System.out.println("Invalid Command; Range {1,2,3,4,5}");
                                        System.out.println("---------------------------------");

                                        continue;
                                    }

                                    if (attchoice == 1) {

                                        idassigned++;


                                        System.out.println("Enter Attraction Name: ");
                                        String attractionName = scanner.nextLine();
                                        System.out.println("Enter Attraction Description: ");
                                        String attDesc = scanner.nextLine();
                                        System.out.println("Enter Unique ID: " + idassigned);
//                                        int uniqueID = scanner.nextInt();
                                        System.out.println("Enter Ticket Price: ");
                                        double ticketPrice = scanner.nextDouble();


                                        attractions newAttraction = new attractions(attractionName, idassigned, ticketPrice, attDesc);
                                        attractions.add(newAttraction);
                                        Ticket newTicket = new Ticket(newAttraction.getName(), ticketPrice);
                                        tickets.add(newTicket);


                                        System.out.println("Attraction added successfully!");
                                        System.out.println("---------------------------------");
                                    } else if (attchoice == 2) {
                                        //view attraction
                                        // View Attractions
                                        if (attractions.isEmpty()) {
                                            System.out.println("No attractions are available.");
                                        } else {
                                            System.out.println("List of Attractions:");
                                            for (attractions attraction : attractions) {
                                                System.out.println("Attraction Name: " + attraction.getName());
                                                System.out.println("Unique ID: " + attraction.getUniqueID());
                                                System.out.println("Ticket Price: $" + attraction.getTicketPrice());
                                                System.out.println("Is Open: " + (attraction.isOpen() ? "Yes" : "No"));
                                                System.out.println("Events: " + String.join(", ", attraction.getEvents()));
                                                System.out.println("Ticketed Visitors: " + attraction.getTicketedVisitors());
                                                System.out.println("Mammals Count: " + attraction.getMammalsCount());
                                                System.out.println("Amphibians Count: " + attraction.getAmphibiansCount());
                                                System.out.println("Reptiles Count: " + attraction.getReptilesCount());
                                                System.out.println("---------------------------------");
                                            }
                                        }


                                    } else if (attchoice == 3) {
                                        if (attractions.isEmpty()) {
                                            System.out.println("No attractions are available to modify.");
                                        } else {
                                            System.out.println("Enter the Unique ID of the attraction you want to modify: ");
                                            int uniqueIDToModify = scanner.nextInt();

                                            attractions attractionToModify = null;
                                            for (attractions attraction : attractions) {
                                                if (attraction.getUniqueID() == uniqueIDToModify) {
                                                    attractionToModify = attraction;
                                                    break;
                                                }
                                            }

                                            if (attractionToModify != null) {

                                                System.out.println("---------------------------------");

                                                System.out.println("Modify Attraction: " + attractionToModify.getName());
                                                System.out.println("1. Change Attraction Name");
                                                System.out.println("2. Change Ticket Price");
                                                System.out.println("3. Toggle Open/Closed");
                                                System.out.println("4. Add Event");
                                                System.out.println("5. Remove Event");
                                                System.out.println("6. Exit");
                                                System.out.println("---------------------------------");
                                                System.out.print("Enter your choice: ");

                                                int modifyChoice = scanner.nextInt();
                                                scanner.nextLine();
                                                System.out.println("---------------------------------");

                                                switch (modifyChoice) {
                                                    case 1:
                                                        System.out.println("Enter new attraction name: ");
                                                        String newName = scanner.nextLine();
                                                        attractionToModify.setName(newName);
                                                        System.out.println("Attraction name changed to: " + newName);
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter new ticket price: ");
                                                        double newPrice = scanner.nextDouble();
                                                        attractionToModify.setTicketPrice(newPrice);
                                                        System.out.println("Ticket price changed to: $" + newPrice);
                                                        break;
                                                    case 3:
                                                        if (attractionToModify.isOpen()) {
                                                            attractionToModify.closeAttraction();
                                                            System.out.println("Attraction is now closed.");
                                                        } else {
                                                            attractionToModify.openAttraction();
                                                            System.out.println("Attraction is now open.");
                                                        }
                                                        break;
                                                    case 4:
                                                        System.out.println("Enter event to add: ");
                                                        String newEvent = scanner.nextLine();
                                                        attractionToModify.addEvent(newEvent);
                                                        System.out.println("Event added: " + newEvent);
                                                        break;
                                                    case 5:
                                                        System.out.println("Enter event to remove: ");
                                                        String eventToRemove = scanner.nextLine();
                                                        attractionToModify.removeEvent(eventToRemove);
                                                        System.out.println("Event removed: " + eventToRemove);
                                                        break;
                                                    case 6:

                                                        break;
                                                    default:
                                                        System.out.println("Invalid choice.");
                                                }

                                            } else {
                                                System.out.println("Attraction with specified Unique ID not found.");
                                            }
                                        }


                                    } else if (attchoice == 4) {
                                        if (attractions.isEmpty()) {
                                            System.out.println("No attractions are available to remove.");
                                        } else {
                                            System.out.println("Enter the Unique ID of the attraction you want to remove: ");
                                            int uniqueIDToRemove = scanner.nextInt();


                                            attractions attractionToRemove = null;
                                            for (attractions attraction : attractions) {
                                                if (attraction.getUniqueID() == uniqueIDToRemove) {
                                                    attractionToRemove = attraction;
                                                    break;
                                                }
                                            }

                                            if (attractionToRemove != null) {
                                                attractions.remove(attractionToRemove);
                                                System.out.println("Attraction " + attractionToRemove.getName() + " removed successfully.");
                                            } else {
                                                System.out.println("Attraction with specified Unique ID not found.");
                                            }
                                        }


                                    } else if (attchoice == 5) {
                                        System.out.println("Exiting Attraction Management Menu...");
                                        break;
                                    }

                                }

                            } else if (adminChoice == 2) {
                                while(true) {
                                    System.out.println("---------------------------------");

                                    System.out.println("Manage Animals");
                                    System.out.println("1. Add Animal");
                                    System.out.println("2. Update Animal Details");
                                    System.out.println("3. Remove Animal");
                                    System.out.println("4. Exit");
                                    System.out.println("---------------------------------");
                                    System.out.print("Enter your choice: ");

                                    int animalChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("---------------------------------");
                                    if (animalChoice > 4 || animalChoice < 1) {
                                        System.out.println("Invalid Command; Range {1,2,3,4}");
                                        System.out.println("---------------------------------");
                                        continue;
                                    }

                                    if (animalChoice == 1) {
                                        System.out.println("Enter the Unique ID of the attraction to add an animal to: ");
                                        int uniqueIDToAddTo = scanner.nextInt();

                                        attractions attractionToAddTo = null;
                                        for (attractions attraction : attractions) {
                                            if (attraction.getUniqueID() == uniqueIDToAddTo) {
                                                attractionToAddTo = attraction;
                                                break;
                                            }
                                        }

                                        if (attractionToAddTo != null) {
                                            System.out.println("Enter Animal Name: ");
                                            String animalName = scanner.next();
                                            System.out.println("Enter Animal Type (Mammal, Amphibian, Reptile): ");
                                            String animalType = scanner.next();

                                            Animal newAnimal = null;
                                            if (animalType.equalsIgnoreCase("Mammal")) {
                                                newAnimal = new Mammal(animalName);
                                            } else if (animalType.equalsIgnoreCase("Amphibian")) {
                                                newAnimal = new Amphibian(animalName);
                                            } else if (animalType.equalsIgnoreCase("Reptile")) {
                                                newAnimal = new Reptile(animalName);
                                            }

                                            if (newAnimal != null) {
                                                attractionToAddTo.addAnimal(newAnimal);
                                                animals.add(newAnimal);
                                                System.out.println("Animal added to " + attractionToAddTo.getName() + " successfully.");
                                            } else {
                                                System.out.println("Invalid animal type. Animal not added.");
                                            }
                                        } else {
                                            System.out.println("Attraction with specified Unique ID not found.");
                                        }
                                    } else if (animalChoice == 3) {
                                        System.out.println("Enter the Unique ID of the attraction to remove an animal from: ");
                                        int uniqueIDToRemoveFrom = scanner.nextInt();

                                        attractions attractionToRemoveFrom = null;
                                        for (attractions attraction : attractions) {
                                            if (attraction.getUniqueID() == uniqueIDToRemoveFrom) {
                                                attractionToRemoveFrom = attraction;
                                                break;
                                            }
                                        }

                                        if (attractionToRemoveFrom != null) {
                                            System.out.println("Enter the name of the animal to remove: ");
                                            String animalNameToRemove = scanner.next();

                                            Animal animalToRemove = null;
                                            for (Animal animal : attractionToRemoveFrom.getAnimals()) {
                                                if (animal.getName().equalsIgnoreCase(animalNameToRemove)) {
                                                    animalToRemove = animal;
                                                    break;
                                                }
                                            }

                                            if (animalToRemove != null) {
                                                attractionToRemoveFrom.removeAnimal(animalToRemove);
                                                System.out.println("Animal " + animalNameToRemove + " removed from " + attractionToRemoveFrom.getName() + " successfully.");
                                            } else {
                                                System.out.println("Animal with specified name not found in the attraction.");
                                            }
                                        } else {
                                            System.out.println("Attraction with specified Unique ID not found.");
                                        }
                                    } else if (animalChoice == 2) {
                                        System.out.println("Enter the Unique ID of the attraction to update animal details: ");
                                        int uniqueIDToUpdate = scanner.nextInt();

                                        attractions attractionToUpdate = null;
                                        for (attractions attraction : attractions) {
                                            if (attraction.getUniqueID() == uniqueIDToUpdate) {
                                                attractionToUpdate = attraction;
                                                break;
                                            }
                                        }

                                        if (attractionToUpdate != null) {
                                            System.out.println("Enter the name of the animal to update: ");
                                            String animalNameToUpdate = scanner.next();

                                            Animal animalToUpdate = null;
                                            for (Animal animal : attractionToUpdate.getAnimals()) {
                                                if (animal.getName().equalsIgnoreCase(animalNameToUpdate)) {
                                                    animalToUpdate = animal;
                                                    break;
                                                }
                                            }

                                            if (animalToUpdate != null) {
                                                System.out.println("---------------------------------");
                                                System.out.println("Choose what to update: ");
                                                System.out.println("1. Update Animal Name");
                                                System.out.println("2. Update Animal Type");
                                                System.out.print("Enter your choice: ");
                                                int updateChoice = scanner.nextInt();
                                                scanner.nextLine(); // Consume newline
                                                System.out.println("---------------------------------");

                                                if (updateChoice == 1) {
                                                    System.out.println("Enter the new name for the animal: ");
                                                    String newAnimalName = scanner.next();
                                                    animalToUpdate.setName(newAnimalName);
                                                    System.out.println("Animal name updated successfully.");
                                                } else if (updateChoice == 2) {
                                                    System.out.println("Enter the new type for the animal (Mammal, Amphibian, Reptile): ");
                                                    String newAnimalType = scanner.next();

                                                    if (animalToUpdate.getType().equalsIgnoreCase(newAnimalType)) {
                                                        System.out.println("The animal type is already " + newAnimalType);
                                                    } else {
                                                        attractionToUpdate.removeAnimal(animalToUpdate);

                                                        Animal newAnimal = null;
                                                        if (newAnimalType.equalsIgnoreCase("Mammal")) {
                                                            newAnimal = new Mammal(animalToUpdate.getName());
                                                        } else if (newAnimalType.equalsIgnoreCase("Amphibian")) {
                                                            newAnimal = new Amphibian(animalToUpdate.getName());
                                                        } else if (newAnimalType.equalsIgnoreCase("Reptile")) {
                                                            newAnimal = new Reptile(animalToUpdate.getName());
                                                        }

                                                        if (newAnimal != null) {
                                                            attractionToUpdate.addAnimal(newAnimal);
                                                            System.out.println("Animal type updated successfully.");
                                                        } else {
                                                            System.out.println("Invalid animal type. Animal not updated.");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Invalid choice for updating animal details.");
                                                }
                                            } else {
                                                System.out.println("Animal with specified name not found in the attraction.");
                                            }
                                        } else {
                                            System.out.println("Attraction with specified Unique ID not found.");
                                        }

                                    } else if (animalChoice == 4) {
                                        break;
                                    }
                                }
                            } else if (adminChoice == 3) {
                                while(true) {
                                    System.out.println("---------------------------------");
                                    System.out.println("1. Add Event to Attraction");
                                    System.out.println("2. Remove Event from Attraction");
                                    System.out.println("3. Exit");
                                    System.out.println("---------------------------------");
                                    System.out.print("Enter your choice: ");

                                    int eventChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    if (eventChoice == 1) {
                                        System.out.println("Enter the Unique ID of the attraction to add an event: ");
                                        int uniqueIDToAddEventTo = scanner.nextInt();

                                        attractions attractionToAddEventTo = null;
                                        for (attractions attraction : attractions) {
                                            if (attraction.getUniqueID() == uniqueIDToAddEventTo) {
                                                attractionToAddEventTo = attraction;
                                                break;
                                            }
                                        }

                                        if (attractionToAddEventTo != null) {
                                            System.out.println("Enter the name of the event to add: ");
                                            String eventToAdd = scanner.nextLine();
                                            scanner.nextLine();
                                            attractionToAddEventTo.addEvent(eventToAdd);
                                            System.out.println("Event added to " + attractionToAddEventTo.getName() + " successfully.");
                                        } else {
                                            System.out.println("Attraction with specified Unique ID not found.");
                                        }
                                    } else if (eventChoice == 2) {
                                        System.out.println("Enter the Unique ID of the attraction to remove an event: ");
                                        int uniqueIDToRemoveEventFrom = scanner.nextInt();

                                        attractions attractionToRemoveEventFrom = null;
                                        for (attractions attraction : attractions) {
                                            if (attraction.getUniqueID() == uniqueIDToRemoveEventFrom) {
                                                attractionToRemoveEventFrom = attraction;
                                                break;
                                            }
                                        }

                                        if (attractionToRemoveEventFrom != null) {
                                            System.out.println("Enter the name of the event to remove: ");
                                            String eventToRemove = scanner.next();
                                            attractionToRemoveEventFrom.removeEvent(eventToRemove);
                                            System.out.println("Event removed from " + attractionToRemoveEventFrom.getName() + " successfully.");
                                        } else {
                                            System.out.println("Attraction with specified Unique ID not found.");
                                        }
                                    } else if (eventChoice == 3) {
                                        break;
                                    } else {
                                        System.out.println("Invalid choice for event scheduling.");
                                    }
                                }

                            } else if (adminChoice == 4) {
                                while (true) {
                                    System.out.println("---------------------------------");
                                    System.out.println("Set Discounts:");
                                    System.out.println("1. Add Discount");
                                    System.out.println("2. Modify Discount");
                                    System.out.println("3. Remove Discount");
                                    System.out.println("4. Exit");
                                    System.out.println("---------------------------------");
                                    System.out.print("Enter your choice: ");

                                    int discountChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("---------------------------------");

                                    if (discountChoice == 1) {

                                        System.out.println("1. Add Minor Discount");
                                        System.out.println("2. Add Senior Discount");
                                        System.out.print("Enter your choice: ");
                                        int addDiscountChoice = scanner.nextInt();
                                        scanner.nextLine();

                                        if (addDiscountChoice == 1) {

                                            System.out.println("Enter the percentage discount for minors (e.g., 10 for 10%): ");
                                            double minorDiscount = scanner.nextDouble();
                                            discounts.put("minor", minorDiscount);
                                            System.out.println("Minor discount added: " + minorDiscount + "%");
                                        } else if (addDiscountChoice == 2) {

                                            System.out.println("Enter the percentage discount for seniors (e.g., 20 for 20%): ");
                                            double seniorDiscount = scanner.nextDouble();

                                            discounts.put("senior", seniorDiscount);
                                            System.out.println("Senior discount added: " + seniorDiscount + "%");
                                        } else {
                                            System.out.println("Invalid choice for adding a discount.");
                                        }
                                    } else if (discountChoice == 2) {

                                        System.out.println("1. Modify Minor Discount");
                                        System.out.println("2. Modify Senior Discount");
                                        System.out.print("Enter your choice: ");
                                        int modifyDiscountChoice = scanner.nextInt();
                                        scanner.nextLine(); // Consume newline

                                        if (modifyDiscountChoice == 1) {
                                            System.out.println("Enter the new percentage discount for minors (e.g., 15 for 15%): ");
                                            double newMinorDiscount = scanner.nextDouble();
                                            System.out.println("Minor discount modified to: " + newMinorDiscount + "%");
                                        } else if (modifyDiscountChoice == 2) {
                                            System.out.println("Enter the new percentage discount for seniors (e.g., 25 for 25%): ");
                                            double newSeniorDiscount = scanner.nextDouble();
                                            System.out.println("Senior discount modified to: " + newSeniorDiscount + "%");
                                        } else {
                                            System.out.println("Invalid choice for modifying a discount.");
                                        }
                                    } else if (discountChoice == 3) {

                                        System.out.println("1. Remove Minor Discount");
                                        System.out.println("2. Remove Senior Discount");
                                        System.out.print("Enter your choice: ");
                                        int removeDiscountChoice = scanner.nextInt();
                                        scanner.nextLine(); // Consume newline

                                        if (removeDiscountChoice == 1) {
                                            discounts.remove("minor");
                                            System.out.println("Minor discount removed.");
                                        } else if (removeDiscountChoice == 2) {
                                            discounts.remove("senior");
                                            System.out.println("Senior discount removed.");
                                        } else {
                                            System.out.println("Invalid choice for removing a discount.");
                                        }
                                    } else if (discountChoice == 4) {

                                        break;
                                    } else {
                                        System.out.println("Invalid choice for discount management.");
                                    }
                                }
                            } else if (adminChoice == 5) {
                                while (true) {
                                    System.out.println("Set Special Deals:");
                                    System.out.println("1. Add Special Deal");
                                    System.out.println("2. Remove Special Deal");
                                    System.out.println("3. Exit");
                                    System.out.println("---------------------------------");
                                    System.out.print("Enter your choice: ");
                                    int specialDealChoice = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline
                                    specialDeals.put(1,0.0);

                                    if (specialDealChoice == 1) {

                                        System.out.println("Enter the minimum number of attractions for the deal: ");
                                        int minAttractions = scanner.nextInt();
                                        System.out.println("Enter the discount percentage for this deal (e.g., 15 for 15%): ");
                                        double discountPercentage = scanner.nextDouble();

                                        specialDeals.put(minAttractions, discountPercentage);
                                        System.out.println("Special deal added successfully.");
                                    } else if (specialDealChoice == 2) {

                                        System.out.println("Enter the minimum number of attractions to remove the deal for: ");
                                        int minAttractions = scanner.nextInt();

                                        specialDeals.remove(minAttractions);
                                        System.out.println("Special deal removed successfully.");
                                    } else if (specialDealChoice == 3) {

                                        break;
                                    } else {
                                        System.out.println("Invalid choice for special deal management.");
                                    }
                                }
                            } else if (adminChoice == 6) {
//                                int totalVisitors = 0;  // Initialize with the total number of visitors
//                                double totalRevenue = 0.0;  // Initialize with the total revenue
//
//                                for (attractions attraction : attractions) {
//                                    totalVisitors += attraction.getTicketedVisitors();
//                                    totalRevenue += attraction.getTicketedVisitors() * attraction.getTicketPrice();
//                                }

                                System.out.println("Visitor Statistics:");
                                System.out.println("Total Visitors: " + netVisitors);
                                System.out.println("Total Revenue: $" + netRevenue);
                                System.out.println("Popular Attractions:");

                                attractions.sort(Comparator.comparingInt(org.example.attractions::getTicketedVisitors).reversed());
                                for (int i = 0; i < 3 && i < attractions.size(); i++) {
                                    attractions attraction = attractions.get(i);
                                    System.out.println("Attraction: " + attraction.getName() + ", Ticketed Visitors: " + attraction.getTicketedVisitors());
                                }

                                System.out.println("---------------------------------");
                            } else if (adminChoice == 7) {
                                System.out.println("Feedback from Visitors:");

                                for (Feedback feedback : feedbackList) {
                                    System.out.println("Visitor: " + feedback.getVisitorName());
                                    System.out.println("Rating: " + feedback.getRating() + "/5");
                                    System.out.println("Comment: " + feedback.getComment());
                                    System.out.println("---------------------------------");
                                }
                            } else if (adminChoice == 8) {
                                break;

                            }


                        }

                    }else{
                        System.out.println("Wrong username or password");
                    }


                }


            } else if (choice == 2) {
                System.out.println("---------------------------------");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.print("Enter your choice: ");
                int visitorChoice = scanner.nextInt();
                System.out.println("---------------------------------");
                if (visitorChoice == 1) {

                    System.out.println("Enter Visitor Name:");
                    String visitorName = scanner.nextLine();
                    scanner.nextLine();
                    int visitorAge = 0;

                    try {
                        System.out.println("Enter Visitor Age:");
                        visitorAge = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }



                    System.out.println("Enter Visitor Phone Number:");
                    String visitorPhone = scanner.nextLine();

                    System.out.println("Enter Visitor Balance:");
                    double visitorBalance = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter Visitor Email:");
                    String visitorEmail = scanner.nextLine();
                    System.out.println("Enter Visitor Password:");
                    String visitorPassword = scanner.nextLine();

                    Visitor newVisitor = new Visitor(visitorName, visitorAge, visitorPhone, visitorBalance, visitorEmail, visitorPassword);
                    registeredVisitors.add(newVisitor);
                    netVisitors++;

                    System.out.println("Registration successful.");

                } else if (visitorChoice == 2) {
//                    for (Visitor visitor : registeredVisitors) {
//                        // Access visitor properties and perform actions as needed
//                        System.out.println("Visitor Name: " + visitor.getName());
//                        System.out.println("Visitor Age: " + visitor.getAge());
//                        System.out.println("Visitor Phone: " + visitor.getPhone());
//                        System.out.println("Visitor Balance: " + visitor.getBalance());
//                        System.out.println("Visitor Email: " + visitor.getEmail());
//                        System.out.println("Visitor Password: " + visitor.getPassword());
//                        // You can add more actions here based on your requirements
//                        System.out.println("-----"); // Separator for each visitor
//                    }

                    System.out.println("Enter your email:");
                    String email = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();


                    Visitor loggedInVisitor = null;
                    for (Visitor visitor : registeredVisitors) {
                        if (visitor.getPassword().equals(password)) {
                            if(visitor.getEmail().equals(email)){
                                loggedInVisitor = visitor;
                                break;

                            }

                        }
                    }

                    if (loggedInVisitor != null) {

                        System.out.println("Logged in as " + loggedInVisitor.getEmail());
                        int numberTickets = 0;


                        while (true) {

                            System.out.println("---------------------------------");
                            System.out.println("Visitor Menu:");
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy Tickets");
                            System.out.println("4. View Balance");
                            System.out.println("5. View Discounts");
                            System.out.println("6. View Special Deals");
                            System.out.println("7. Visit Animals");
                            System.out.println("8. Visit Attractions");
                            System.out.println("9. Leave Feedback");
                            System.out.println("10. Log Out");
                            System.out.println("---------------------------------");
                            System.out.print("Enter your choice: ");
                            int loginChoice = scanner.nextInt();
                            System.out.println("---------------------------------");

                            if (loginChoice == 1) {
                                while (true) {
                                    System.out.println("---------------------------------");
                                    System.out.println("Explore the Zoo:");
                                    System.out.println("1. View Attractions");
                                    System.out.println("2. View Animals");
                                    System.out.println("3. Exit");
                                    System.out.print("Enter your choice: ");
                                    int exploreChoice = scanner.nextInt();
                                    System.out.println("---------------------------------");

                                    if (exploreChoice == 1) {
                                        System.out.println("Attractions in the Zoo:");
                                        for (int i = 0; i < attractions.size(); i++) {
                                            attractions attraction = attractions.get(i);
                                            System.out.println((i + 1) + ". " + attraction.getName());
                                        }
                                        System.out.print("Enter your choice: ");
                                        int viewattChoice = scanner.nextInt();
                                        scanner.nextLine();
                                        if (viewattChoice >= 1 && viewattChoice <= attractions.size()) {
                                            System.out.println("Attraction Description: " + attractions.get(viewattChoice - 1).getAttdesc());
                                        } else {
                                            System.out.println("Invalid choice. Please try again.");
                                        }


                                    } else if (exploreChoice == 2) {
                                        System.out.println("Animals in the Zoo:");
                                        for (int i = 0; i < animals.size(); i++) {
                                            Animal animal = animals.get(i);
                                            System.out.println((i + 1) + ". " + animal.getName() + " (Type: " + animal.getType() + ")");
                                        }
                                        System.out.print("Enter your choice: ");

                                        int animalChoice = scanner.nextInt();
                                        scanner.nextLine();

                                        if (animalChoice >= 1 && animalChoice <= animals.size()) {
                                            Animal selectedAnimal = animals.get(animalChoice - 1);
                                            System.out.println("Animal Name: " + selectedAnimal.getName() + " (Type: " + selectedAnimal.getType() + ")");
                                        } else {
                                            System.out.println("Invalid choice. Please try again.");
                                        }
                                    } else if (exploreChoice == 3) {
                                        break;
                                    }
                                }
                            } else if (loginChoice == 2) {
                                System.out.println("Buy Membership:");
                                System.out.println("1. Basic Membership (₹20)");
                                System.out.println("2. Premium Membership (₹50)");
                                System.out.print("Enter your choice: ");

                                int membershipChoice = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("---------------------------------");

                                double membershipPrice = 0.0;
                                String membershipType = "";

                                if (membershipChoice == 1) {
                                    membershipPrice = 20.0;
                                    membershipType = "Basic";
                                } else if (membershipChoice == 2) {
                                    membershipPrice = 50.0;
                                    membershipType = "Premium";
                                } else {
                                    System.out.println("Invalid choice. Please try again.");
                                }


                                assert loggedInVisitor != null;
                                if (loggedInVisitor.getBalance() >= membershipPrice) {
                                    loggedInVisitor.setBalance(loggedInVisitor.getBalance() - membershipPrice); // Deduct the membership price from the visitor's balance
                                    System.out.println("Membership purchased successfully. Your balance is now ₹" + loggedInVisitor.getBalance() + ".");

                                    if (membershipChoice==2)  {
                                        loggedInVisitor.setPremium();
                                    } // Set to true for Premium, false for Basic
                                    netRevenue+=membershipPrice;
                                } else {
                                    System.out.println("Insufficient balance to purchase the membership.");
                                }
                            } else if (loginChoice == 3) {

                                if (loggedInVisitor.getVisitorPremium()==1){
                                    System.out.println("All attractions are included with the premium membership");
                                }else {
                                    if (loggedInVisitor.getAge() > 60) {
                                        System.out.println("Buy Tickets");
                                        System.out.println("Special Deals:");
                                        int j = 1;
                                        for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
                                            Integer productName = entry.getKey();
                                            Double price = entry.getValue();
                                            if (price != 0.0) {
                                                System.out.println(j + ". " + " On the purchase of " + productName + " tickets, " + "A discount of " + price + "%");
                                                j++;
                                            } else {
                                                continue;
                                            }
                                        }
                                        System.out.println(j + ". No Offer");

                                        System.out.println("Enter the number of tickets you want to purchase: ");
                                        int specialDealChoice = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("---------------------------------");
                                        for (int m = 0; m < specialDealChoice; m++) {
                                            for (int i = 0; i < attractions.size(); i++) {
                                                attractions attraction = attractions.get(i);
                                                System.out.println((i + 1) + ". " + attraction.getName() + " (Price: ₹" + ((attraction.getTicketPrice() - ((attraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)) * (1 - discounts.get("senior") / 100)) + ")");
                                            }

                                            System.out.print("Enter your choice (Attraction number): ");
                                            int ticketChoice = scanner.nextInt();
                                            scanner.nextLine();

                                            if (ticketChoice >= 1 && ticketChoice <= attractions.size()) {

                                                attractions selectedAttraction = attractions.get(ticketChoice - 1);

                                                Ticket selectedTicket = tickets.get(ticketChoice - 1);


                                                if (selectedTicket.isAvailable()) {
                                                    System.out.println("You selected: " + selectedAttraction.getName());
                                                    System.out.println("Ticket price: ₹" + ((selectedAttraction.getTicketPrice() - ((selectedAttraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)) * (1 - discounts.get("senior") / 100)));

                                                    if (loggedInVisitor.getBalance() >= selectedTicket.getPrice()) {
                                                        loggedInVisitor.setBalance(loggedInVisitor.getBalance() - ((selectedAttraction.getTicketPrice() - ((selectedAttraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)) * (1 - discounts.get("senior") / 100))); // Deduct the ticket price from the visitor's balance
                                                        System.out.println("Senior Discount" + discounts.get("senior") + "and Special deal applied");
                                                        System.out.println("Ticket purchased successfully. Your balance is now ₹" + loggedInVisitor.getBalance() + ".");
//                                                    selectedTicket.setAvailable(false);
                                                        selectedAttraction.setNumberOfTicketsBought();// Mark the ticket as sold
                                                    } else {
                                                        System.out.println("Insufficient balance to purchase the ticket.");
                                                    }
                                                } else {
                                                    System.out.println("Sorry, tickets for " + selectedAttraction.getName() + " are sold out.");
                                                }

                                            }
                                        }

                                    } else if (loggedInVisitor.getAge() < 18) {
                                        System.out.println("Buy Tickets");
                                        System.out.println("Special Deals:");
                                        int j = 1;
                                        for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
                                            Integer productName = entry.getKey();
                                            Double price = entry.getValue();
                                            if (price != 0.0) {
                                                System.out.println(j + ". " + " On the purchase of " + productName + " tickets, " + "A discount of " + price + "%");
                                                j++;
                                            } else {
                                                continue;
                                            }
                                        }
                                        System.out.println(j + ". No Offer");
                                        System.out.println("Enter the number of tickets you want to purchase: ");
                                        int specialDealChoice = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("---------------------------------");
                                        for (int m = 0; m < specialDealChoice; m++) {
                                            for (int i = 0; i < attractions.size(); i++) {
                                                attractions attraction = attractions.get(i);
                                                System.out.println((i + 1) + ". " + attraction.getName() + " (Price: ₹" + ((attraction.getTicketPrice() - ((attraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)) * (1 - discounts.get("minor") / 100)) + ")");
                                            }

                                            System.out.print("Enter your choice (Attraction number): ");
                                            int ticketChoice = scanner.nextInt();
                                            scanner.nextLine();

                                            if (ticketChoice >= 1 && ticketChoice <= attractions.size()) {

                                                attractions selectedAttraction = attractions.get(ticketChoice - 1);

                                                Ticket selectedTicket = tickets.get(ticketChoice - 1);


                                                if (selectedTicket.isAvailable()) {
                                                    System.out.println("You selected: " + selectedAttraction.getName());
                                                    System.out.println("Ticket price: ₹" + (((selectedAttraction.getTicketPrice() - ((selectedAttraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)) * (1 - discounts.get("minor") / 100))));

                                                    if (loggedInVisitor.getBalance() >= selectedTicket.getPrice()) {
                                                        loggedInVisitor.setBalance(loggedInVisitor.getBalance() - ((selectedAttraction.getTicketPrice() - ((selectedAttraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)) * (1 - discounts.get("minor") / 100))); // Deduct the ticket price from the visitor's balance
                                                        System.out.println("Senior Discount" + discounts.get("senior") + "and Special deal applied");
                                                        System.out.println("Ticket purchased successfully. Your balance is now ₹" + loggedInVisitor.getBalance() + ".");
                                                        selectedAttraction.setNumberOfTicketsBought();
                                                    } else {
                                                        System.out.println("Insufficient balance to purchase the ticket.");
                                                    }
                                                } else {
                                                    System.out.println("Sorry, tickets for " + selectedAttraction.getName() + " are sold out.");
                                                }

                                            }
                                        }


                                    } else {
                                        System.out.println("Buy Tickets");
                                        System.out.println("Special Deals:");
                                        int j = 1;
                                        for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
                                            Integer productName = entry.getKey();
                                            Double price = entry.getValue();
                                            if (price != 0.0) {
                                                System.out.println(j + ". " + " On the purchase of " + productName + " tickets, " + "A discount of " + price + "%");
                                                j++;
                                            } else {
                                                continue;
                                            }
                                        }
                                        System.out.println(j + ". No Offer");
                                        System.out.println("Enter the number of tickets you want to purchase: ");
                                        int specialDealChoice = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("---------------------------------");
                                        for (int m = 0; m < specialDealChoice; m++) {
                                            for (int i = 0; i < attractions.size(); i++) {
                                                attractions attraction = attractions.get(i);
                                                System.out.println((i + 1) + ". " + attraction.getName() + " (Price: ₹" + (attraction.getTicketPrice() - ((attraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)) + ")");
                                            }

                                            System.out.print("Enter your choice (Attraction number): ");
                                            int ticketChoice = scanner.nextInt();
                                            scanner.nextLine();

                                            if (ticketChoice >= 1 && ticketChoice <= attractions.size()) {
                                                attractions selectedAttraction = attractions.get(ticketChoice - 1);

                                                Ticket selectedTicket = tickets.get(ticketChoice - 1);


                                                if (selectedTicket.isAvailable()) {
                                                    System.out.println("You selected: " + selectedAttraction.getName());
                                                    System.out.println("Ticket price: ₹" + (selectedAttraction.getTicketPrice() - ((selectedAttraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100)));

                                                    if (loggedInVisitor.getBalance() >= selectedTicket.getPrice()) {
                                                        loggedInVisitor.setBalance(loggedInVisitor.getBalance() - (selectedAttraction.getTicketPrice() - ((selectedAttraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100))); // Deduct the ticket price from the visitor's balance
                                                        System.out.println("Ticket purchased successfully. Your balance is now ₹" + loggedInVisitor.getBalance() + ".");
                                                        netRevenue += (selectedAttraction.getTicketPrice() - ((selectedAttraction.getTicketPrice()) * specialDeals.get(specialDealChoice) / 100));
//                                                    selectedTicket.setAvailable(false); // Mark the ticket as sold
                                                        selectedAttraction.setNumberOfTicketsBought();
                                                    } else {
                                                        System.out.println("Insufficient balance to purchase the ticket.");
                                                    }
                                                } else {
                                                    System.out.println("Sorry, tickets for " + selectedAttraction.getName() + " are sold out.");
                                                }

                                            }
                                        }
                                    }
                                }
                            } else if (loginChoice == 5) {
                                System.out.println("View Discounts:");

                                if (!discounts.isEmpty()) {
                                    for (Map.Entry<String, Double> entry : discounts.entrySet()) {
                                        System.out.println(entry.getKey() + " Discount: " + entry.getValue() + "%");
                                    }
                                } else {
                                    System.out.println("No discounts available.");
                                }
                            } else if (loginChoice == 6) {
                                System.out.println("Special Deals:");
                                int j=1;
                                for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
                                    Integer productName = entry.getKey();
                                    Double price = entry.getValue();
                                    System.out.println(j + ". " + " On the purchase of " + productName + " tickets, " + "A discount of " + price + "%");
                                    j++;
                                }
                                System.out.println(j + ". Exit");
                                System.out.println("---------------------------------");
                            } else if (loginChoice == 7) {
                                System.out.println("Visit Animals:");





                                for (int i = 0; i < animals.size(); i++) {
                                    System.out.println((i + 1) + ". " + animals.get(i).getName());
                                }
                                System.out.println((animals.size() + 1) + ". Exit");
                                System.out.println("Enter your choice:");

                                int animalChoice = scanner.nextInt();
                                scanner.nextLine();


                                if (animalChoice >= 1 && animalChoice <= animals.size()) {
                                    Animal selectedAnimal = animals.get(animalChoice - 1);


                                    attractions selectedAttraction = null;
                                    for (attractions attraction : attractions) {
                                        List<Animal> animuls = attraction.getAnimals();
                                        if (animuls.contains(selectedAnimal)) {
                                            selectedAttraction = attraction;
                                            break;
                                        }
                                    }

                                    if(loggedInVisitor.getVisitorPremium()==1){
                                        System.out.println("You've selected: " + selectedAnimal.getName());
                                        System.out.println("1. Feed the animal");
                                        System.out.println("2. Read about the animal");
                                        System.out.println("3. Exit");

                                        int actionChoice = scanner.nextInt();
                                        scanner.nextLine();

                                        if (actionChoice == 1) {
                                            if (selectedAnimal instanceof Mammal) {
                                                System.out.println("The " + selectedAnimal.getName() + " " + selectedAnimal.getType() + " has been fed");
                                                System.out.println(selectedAnimal.getName() + " lets out a " + selectedAnimal.makeSound());

                                            } else if (selectedAnimal instanceof Amphibian) {
                                                System.out.println("The " + selectedAnimal.getName() + " " + selectedAnimal.getType() + " has been fed");
                                                System.out.println(selectedAnimal.getName() + " lets out a " + selectedAnimal.makeSound());
                                            } else if (selectedAnimal instanceof Reptile) {
                                                System.out.println("The " + selectedAnimal.getName() + " " + selectedAnimal.getType() + " has been fed");
                                                System.out.println(selectedAnimal.getName() + " lets out a " + selectedAnimal.makeSound());
                                            }
                                        } else if (actionChoice == 2) {
                                            System.out.println("The animal q: " + selectedAnimal.getName() + " is of the type " + selectedAnimal.getType());
                                        } else if (actionChoice == 3) {
                                            System.out.println("Exiting animal interaction.");
                                        } else {
                                            System.out.println("Invalid choice for animal interaction.");
                                        }

                                    }else {

                                        if (selectedAttraction.getNumberOfTicketsBought() == 0) {
                                            System.out.println("Kindly Purchase A Ticket");
                                        } else {
                                            System.out.println("You've selected: " + selectedAnimal.getName());
                                            System.out.println("1. Feed the animal");
                                            System.out.println("2. Read about the animal");
                                            System.out.println("3. Exit");

                                            int actionChoice = scanner.nextInt();
                                            scanner.nextLine();

                                            if (actionChoice == 1) {
                                                if (selectedAnimal instanceof Mammal) {
                                                    System.out.println("The " + selectedAnimal.getName() + " " + selectedAnimal.getType() + " has been fed");
                                                    System.out.println(selectedAnimal.getName() + " lets out a " + selectedAnimal.makeSound());

                                                } else if (selectedAnimal instanceof Amphibian) {
                                                    System.out.println("The " + selectedAnimal.getName() + " " + selectedAnimal.getType() + " has been fed");
                                                    System.out.println(selectedAnimal.getName() + " lets out a " + selectedAnimal.makeSound());
                                                } else if (selectedAnimal instanceof Reptile) {
                                                    System.out.println("The " + selectedAnimal.getName() + " " + selectedAnimal.getType() + " has been fed");
                                                    System.out.println(selectedAnimal.getName() + " lets out a " + selectedAnimal.makeSound());
                                                }
                                            } else if (actionChoice == 2) {
                                                System.out.println("The animal q: " + selectedAnimal.getName() + " is of the type " + selectedAnimal.getType());
                                            } else if (actionChoice == 3) {
                                                System.out.println("Exiting animal interaction.");
                                            } else {
                                                System.out.println("Invalid choice for animal interaction.");
                                            }
                                        }
                                    }
                                } else if (animalChoice == animals.size() + 1) {
                                    System.out.println("Exiting animal selection.");
                                } else {
                                    System.out.println("Invalid choice for selecting an animal.");
                                }
                            } else if (loginChoice == 8) {
                                System.out.println("Visit Attractions:");
                                for (int i = 0; i < attractions.size(); i++) {
                                    System.out.println((i + 1) + ". " + attractions.get(i).getName());
                                }
                                System.out.println((attractions.size() + 1) + ". Exit");
                                System.out.print("Enter your choice: ");

                                int attractionChoice = scanner.nextInt();
                                scanner.nextLine();


                                if (attractionChoice >= 1 && attractionChoice <= attractions.size()) {
                                    attractions selectedAttraction = attractions.get(attractionChoice - 1);
                                    if (selectedAttraction.isOpen()) {
                                        if (loggedInVisitor.getVisitorPremium() == 1) {
                                            Ticket selectedTicket = selectedAttraction.getTickets().remove(0); // Remove the ticket
                                            System.out.println("Welcome to the attraction " + selectedAttraction.getName());
                                            selectedAttraction.toString();
                                            selectedAttraction.setTicketedVisitors();
                                        }else {
                                            if (selectedAttraction.getNumberOfTicketsBought() == 0) {
                                                System.out.println("Kindly Purchase A Ticket");
                                            } else {
                                                Ticket selectedTicket = selectedAttraction.getTickets().remove(0); // Remove the ticket
                                                System.out.println("Welcome to the attraction " + selectedAttraction.getName());
                                                selectedAttraction.toString();
                                                selectedAttraction.setTicketedVisitors();

                                            }
                                        }
                                    }else {
                                        System.out.println("Sorry, this attraction is currently closed.");
                                    }
                                } else if (attractionChoice == attractions.size() + 1) {
                                    System.out.println("Exiting attraction selection.");
                                } else {
                                    System.out.println("Invalid choice for selecting an attraction.");
                                }
                            } else if (loginChoice == 9) {
                                System.out.println("Leave Feedback:");
                                System.out.println("Please provide your feedback and suggestions:");
                                String feedback = scanner.nextLine();
                                scanner.nextLine();


                                Feedback newFeedback = new Feedback(loggedInVisitor.getName(), feedback);
                                feedbackList.add(newFeedback);

                                System.out.println("Thank you for your feedback!");
                            }
                            else if (loginChoice == 4){
                                System.out.println("Balance remaining: " + loggedInVisitor.getBalance());

                            }else if (loginChoice == 10) {
                                System.out.println("Logging Out...");
                                break;

                            }


                        }
                    } else {
                        System.out.println("Invalid email or password. Please try again.");
                        System.out.println("----------------------------------------------");
                    }


                }


            } else if (choice == 3) {

                System.out.println("Special Deals:");
//                System.out.println("1. Buy 2 attractions, get 15% off");
//                System.out.println("2. Buy 3 or more attractions, get 30% off");
//                System.out.println("3. Exit");
                int i=1;
                for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
                    Integer productName = entry.getKey();
                    Double price = entry.getValue();
                    System.out.println(i + ". " + " On the purchase of " + productName + " tickets, " + "A discount of " + price + "%");
                    i++;
                }
                System.out.println(i +". Exit");


//                System.out.println("Enter your choice:");

//                int dealChoice = scanner.nextInt();
//                scanner.nextLine(); // Consume newline

//                switch (dealChoice) {
//                    case 1:
//                        System.out.println("Buy 2 attractions and get 15% off on the total amount.");
//                        break;
//                    case 2:
//                        System.out.println("Buy 3 or more attractions and get 30% off on the total amount.");
//                        break;
//                    case 3:
//                        System.out.println("Exiting special deals.");
//                        break;
//                    default:
//                        System.out.println("Invalid choice for special deals.");
//                        break;
//                }
            }
        }
    }
}

