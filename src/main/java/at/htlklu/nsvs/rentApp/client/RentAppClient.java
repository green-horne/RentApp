package at.htlklu.nsvs.rentApp.client;

import at.htlklu.nsvs.rentApp.server.model.Contract;
import at.htlklu.nsvs.rentApp.server.model.Customer;
import at.htlklu.nsvs.rentApp.server.model.Vehicle;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class RentAppClient {

    public static void main(String[] args) {

        RestTemplate server = new RestTemplate();
        Scanner scanner = new Scanner(System.in);

        String command = "";
        boolean nextCommand = true;
        String uuid = "";

        Customer currentCustomer = null;
        Vehicle currentVehicle = null;
        Contract currentContract = null;

        Vehicle[] vehicles = null;
        Customer[] customers = null;
        Contract[] contracts = null;

        System.out.println("########## RentAppClient ##########\n");
        System.out.println("Alle Befehle bitte mit >>help<< anzeigen lassen.\n");

        while (nextCommand) {
            System.out.print(">");
            command = scanner.nextLine();

            switch (command) {

                case "exit":
                    nextCommand = false;
                    break;

                case "help":
                    System.out.println("help --> Hilfe wird angezeigt");
                    System.out.println("exit --> Beenden");

                    System.out.println("customer list   --> listet alle Kunden auf");
                    System.out.println("customer create --> neuer Kunde wird angelegt");
                    System.out.println("customer update --> existierender Kunde wird editiert");
                    System.out.println("customer delete --> existierender Kunde wird gelöscht\n");

                    System.out.println("vehicle list    --> listet alle Fahrzeuge auf");
                    System.out.println("vehicle create  --> neues Fahrzeug wird angelegt");
                    System.out.println("vehicle update  --> existierendes Fahrzeug wird editiert");
                    System.out.println("vehicle delete  --> existierendes Fahrzeug wird gelöscht\n");

                    System.out.println("contract list   --> listet alle Verträge auf");
                    System.out.println("contract create --> neuer Vertrag wird angelegt");
                    System.out.println("contract update --> existierender Vertrag wird editiert");
                    System.out.println("contract delete --> existierender Vertrag wird gelöscht\n");

                    break;


                //region customer
                case "customer create":
                    System.out.print("Nachname: ");
                    String surname = scanner.nextLine();
                    System.out.print("Vorname: ");
                    String firstname = scanner.nextLine();
                    System.out.print("Geburtsdatum (yyyy-MM-dd): ");
                    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

                    Customer newCustomer = new Customer();
                    newCustomer.setSurname(surname);
                    newCustomer.setFirstname(firstname);
                    newCustomer.setDateOfBirth(dateOfBirth);

                    currentCustomer = server.postForObject("http://localhost:8080/v1/customers", newCustomer, Customer.class);
                    System.out.println(currentCustomer);

                    break;

                case "customer list":
                    customers = server.getForObject("http://localhost:8080/v1/customers", Customer[].class);

                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }

                    break;

                case "customer update":
                    System.out.print("Customer (uuid): ");
                    uuid = scanner.nextLine();

                    System.out.print("Nachname: ");
                    surname = scanner.nextLine();
                    System.out.print("Vorname: ");
                    firstname = scanner.nextLine();
                    System.out.print("Geburtsdatum (yyyy-MM-dd): ");
                    dateOfBirth = LocalDate.parse(scanner.nextLine());

                    Customer updateCustomer = new Customer();
                    updateCustomer.setSurname(surname);
                    updateCustomer.setFirstname(firstname);
                    updateCustomer.setDateOfBirth(dateOfBirth);

                    server.put("http://localhost:8080/v1/customers/"+uuid, updateCustomer, Customer.class);
                    System.out.println(updateCustomer);

                    break;

                case "customer delete":
                    System.out.print("Customer (uuid): ");
                    uuid = scanner.nextLine();
                    server.delete("http://localhost:8080/v1/customers/"+uuid, Customer.class);

                    break;
                //endregion


                //region vehicle
                case "vehicle create":
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Typ: ");
                    String typ = scanner.nextLine();
                    System.out.print("km: ");
                    int km = scanner.nextInt();
                    System.out.print("Baujahr: ");
                    int constructionYear = scanner.nextInt();

                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setName(name);
                    newVehicle.setTyp(typ);
                    newVehicle.setKm(km);
                    newVehicle.setConstructionYear(constructionYear);

                    currentVehicle = server.postForObject("http://localhost:8080/v1/vehicles", newVehicle, Vehicle.class);
                    System.out.println(currentVehicle);

                    break;

                case "vehicle list":
                    vehicles = server.getForObject("http://localhost:8080/v1/vehicles", Vehicle[].class);

                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle);
                    }

                    break;

                case "vehicle update":
                    System.out.print("Vehicle (uuid): ");
                    uuid = scanner.nextLine();

                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    System.out.print("Typ: ");
                    typ = scanner.nextLine();
                    System.out.print("km: ");
                    km = scanner.nextInt();
                    System.out.print("Baujahr: ");
                    constructionYear = scanner.nextInt();

                    Vehicle updateVehicle = new Vehicle();
                    updateVehicle.setName(name);
                    updateVehicle.setTyp(typ);
                    updateVehicle.setKm(km);
                    updateVehicle.setConstructionYear(constructionYear);

                    server.put("http://localhost:8080/v1/vehicles/"+uuid, updateVehicle, Vehicle.class);
                    System.out.println(updateVehicle);

                    break;

                case "vehicle delete":
                    System.out.print("Vehicle (uuid): ");
                    uuid = scanner.nextLine();
                    server.delete("http://localhost:8080/v1/vehicles/"+uuid, Vehicle.class);

                    break;
                //endregion


                //region contract
                case "contract create":
                    customers = server.getForObject("http://localhost:8080/v1/customers", Customer[].class);
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    System.out.print("Customer (uuid): ");
                    String customerUUID = scanner.nextLine();

                    vehicles = server.getForObject("http://localhost:8080/v1/vehicles", Vehicle[].class);
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle);
                    }
                    System.out.print("Vehicle (uuid): ");
                    String vehicleUUID = scanner.nextLine();

                    System.out.print("Vertragsdatum (yyyy-MM-dd): ");
                    LocalDate contractDate = LocalDate.parse(scanner.nextLine());

                    System.out.print("Leihbeginn (yyyy-MM-dd): ");
                    LocalDate rentStartDate = LocalDate.parse(scanner.nextLine());

                    System.out.print("Leihende (yyyy-MM-dd): ");
                    LocalDate rentEndDate = LocalDate.parse(scanner.nextLine());

                    Contract newContract = new Contract();
                    newContract.setCustomer(Arrays.stream(customers).filter(c -> c.getUuid().equals(customerUUID)).findFirst().get());
                    newContract.setVehicle(Arrays.stream(vehicles).filter(v -> v.getUuid().equals(vehicleUUID)).findFirst().get());
                    newContract.setContractDate(contractDate);
                    newContract.setRentStartDate(rentStartDate);
                    newContract.setRentEndDate(rentEndDate);

                    currentContract = server.postForObject("http://localhost:8080/v1/contracts", newContract, Contract.class);
                    System.out.println(currentContract);

                    break;

                case "contract list":
                    contracts = server.getForObject("http://localhost:8080/v1/contracts", Contract[].class);

                    for (Contract contract : contracts) {
                        System.out.println(contract);
                    }

                    break;

                case "contract update":
                    System.out.print("Contract (uuid): ");
                    uuid = scanner.nextLine();

                    customers = server.getForObject("http://localhost:8080/v1/customers", Customer[].class);
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    System.out.print("Customer (uuid): ");
                    customerUUID = scanner.nextLine();

                    vehicles = server.getForObject("http://localhost:8080/v1/vehicles", Vehicle[].class);
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle);
                    }
                    System.out.print("Vehicle (uuid): ");
                    vehicleUUID = scanner.nextLine();

                    System.out.print("Vertragsdatum (dd-MM-yyyy): ");
                    contractDate = LocalDate.parse(scanner.nextLine());

                    System.out.print("Leihbeginn (yyyy-MM-dd): ");
                    rentStartDate = LocalDate.parse(scanner.nextLine());

                    System.out.print("Leihende (yyyy-MM-dd): ");
                    rentEndDate = LocalDate.parse(scanner.nextLine());

                    Contract updateContract = new Contract();
                    updateContract.setCustomer(Arrays.stream(customers).filter(c -> c.getUuid().equals(customerUUID)).findFirst().get());
                    updateContract.setVehicle(Arrays.stream(vehicles).filter(v -> v.getUuid().equals(vehicleUUID)).findFirst().get());
                    updateContract.setContractDate(contractDate);
                    updateContract.setRentStartDate(rentStartDate);
                    updateContract.setRentEndDate(rentEndDate);

                    server.put("http://localhost:8080/v1/contracts/"+uuid, updateContract, Contract.class);
                    System.out.println(updateContract);

                    break;

                case "contract delete":
                    System.out.print("Contract (uuid): ");
                    uuid = scanner.nextLine();

                    server.delete("http://localhost:8080/v1/contracts/"+uuid, Contract.class);

                    break;
                //endregion


                default:
                    System.out.println("Ungültige Eingabe ---> geben Sie 'help' ein");
                    break;
            }
        }
    }
}