package at.htlklu.nsvs.rentApp.server.service.interfaces;

import at.htlklu.nsvs.rentApp.server.model.Contract;
import at.htlklu.nsvs.rentApp.server.model.Customer;
import at.htlklu.nsvs.rentApp.server.model.Vehicle;

import java.time.LocalDate;

public interface ContractService {

    public Contract createContract(Contract contract);
    public Contract[] listAllContracts();
    public Contract updateContract(String uuid, Customer customer, Vehicle vehicle, LocalDate contractDate, LocalDate rentStartDate, LocalDate rentEndDate);
    public void deleteContract(String uuid);
}