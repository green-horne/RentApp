package at.htlklu.nsvs.rentApp.server.service;

import at.htlklu.nsvs.rentApp.server.model.Contract;
import at.htlklu.nsvs.rentApp.server.model.Customer;
import at.htlklu.nsvs.rentApp.server.model.Vehicle;
import at.htlklu.nsvs.rentApp.server.service.interfaces.ContractService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Scope("singleton")
public class ContractServiceImpl implements ContractService {

    private ArrayList<Contract> contracts = new ArrayList<Contract>();

    @Override
    public Contract createContract(Contract contract) {
        contract.setUuid(UUID.randomUUID().toString());
        contracts.add(contract);
        return contract;
    }

    @Override
    public Contract[] listAllContracts() {
        Contract[] contractArray = contracts.toArray(new Contract[contracts.size()]);
        return contractArray;
    }

    @Override
    public Contract updateContract(String uuid, Customer customer, Vehicle vehicle, LocalDate contractDate, LocalDate rentStartDate, LocalDate rentEndDate) {
        Contract contract = contracts.stream().filter(c -> c.getUuid().equals(uuid)).findFirst().get();
        contract.setCustomer(customer);
        contract.setVehicle(vehicle);
        contract.setContractDate(contractDate);
        contract.setRentStartDate(rentStartDate);
        contract.setRentEndDate(rentEndDate);

        return contract;
    }

    @Override
    public void deleteContract(String uuid) {
        Contract contract = contracts.stream().filter(c -> c.getUuid().equals(uuid)).findFirst().get();
        contracts.remove(contract);
    }
}