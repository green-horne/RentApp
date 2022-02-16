package at.htlklu.nsvs.rentApp.server.controller;

import at.htlklu.nsvs.rentApp.server.model.Customer;
import at.htlklu.nsvs.rentApp.server.service.interfaces.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "endpoints for creating, retrieving, updating and deleting of Customers")
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "CustomerList-Endpoint", notes = "returns a list of all Customers")
    @GetMapping(path = "")
    public Customer[] listAllCustomers() {
        return customerService.listAllCustomers();
    }

    @ApiOperation(value = "CreateCustomer-Endpoint", notes = "Customer to add")
    @PostMapping(path = "")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @ApiOperation(value = "UpdateCustomer-Endpoint", notes = "updates an existing Customer")
    @PutMapping(path = "/{uuid}")
    public Customer updateCustomer(@PathVariable @ApiParam(value = "UUID of Customer to be updated", required = true) String uuid,
                                   @RequestBody @ApiParam(value = "Customer to be updated", required = true) Customer customer) {
        return customerService.updateCustomer(uuid, customer.getSurname(), customer.getFirstname(), customer.getDateOfBirth());
    }

    @ApiOperation(value = "DeleteCustomer-Endpoint", notes = "deletes an existing Customer")
    @DeleteMapping(path = "/{uuid}")
    public void deleteCustomer(@PathVariable @ApiParam(value = "UUID of Customer to be deleted", required = true) String uuid) {
        customerService.deleteCustomer(uuid);
    }
}