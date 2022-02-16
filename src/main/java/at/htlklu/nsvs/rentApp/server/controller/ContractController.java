package at.htlklu.nsvs.rentApp.server.controller;

import at.htlklu.nsvs.rentApp.server.model.Contract;
import at.htlklu.nsvs.rentApp.server.service.interfaces.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "endpoints for creating, retrieving, updating and deleting of Contracts")
@RestController
@RequestMapping("/v1/contracts")
public class ContractController {

    @Autowired
    ContractService contractService;

    @ApiOperation(value = "ContractList-Endpoint", notes = "returns a list of all Contracts")
    @GetMapping(path = "")
    public Contract[] listAllContracts() {
        return contractService.listAllContracts();
    }

    @ApiOperation(value = "CreateContract-Endpoint", notes = "Contract to add")
    @PostMapping(path = "")
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }

    @ApiOperation(value = "UpdateContract-Endpoint", notes = "updates an existing Contract")
    @PutMapping(path = "/{uuid}")
    public Contract updateContract(@PathVariable @ApiParam(value = "UUID of Contract to be updated", required = true) String uuid,
                                   @RequestBody @ApiParam(value = "Contract to be updatet", required = true) Contract contract) {
        return contractService.updateContract(uuid, contract.getCustomer(), contract.getVehicle(), contract.getContractDate(), contract.getRentStartDate(), contract.getRentEndDate());
    }

    @ApiOperation(value = "DeleteContract-Endpoint", notes = "deletes an existing Contract")
    @DeleteMapping(path = "/{uuid}")
    public void deleteContract(@PathVariable @ApiParam(value = "UUID of Contract to be deleted", required = true) String uuid) {
        contractService.deleteContract(uuid);
    }
}