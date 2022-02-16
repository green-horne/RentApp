package at.htlklu.nsvs.rentApp.server.controller;

import at.htlklu.nsvs.rentApp.server.model.Vehicle;
import at.htlklu.nsvs.rentApp.server.service.interfaces.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "endpoints for creating, retrieving, updating and deleting of Vehicles")
@RestController
@RequestMapping("/v1/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @ApiOperation(value = "VehicleList-Endpoint", notes = "returns a list of all Vehicles")
    @GetMapping(path = "")
    public Vehicle[] listAllVehicles() {
        return vehicleService.listAllVehicles();
    }

    @ApiOperation(value = "CreateVehicle-Endpoint", notes = "Vehicle to add")
    @PostMapping(path = "")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @ApiOperation(value = "UpdateVehicle-Endpoint", notes = "updates an existing Vehicle")
    @PutMapping(path = "/{uuid}")
    public Vehicle updateVehicle(@PathVariable @ApiParam(value = "UUID of Vehicle to be updated", required = true) String uuid,
                                 @RequestBody @ApiParam(value = "Vehicle to be updated", required = true) Vehicle vehicle) {
        return vehicleService.updateVehicle(uuid, vehicle.getName(), vehicle.getTyp(), vehicle.getKm(), vehicle.getConstructionYear());
    }

    @ApiOperation(value = "DeleteVehicle-Endpoint", notes = "deletes an existing Vehicle")
    @DeleteMapping(path = "/{uuid}")
    public void deleteVehicle(@PathVariable @ApiParam(value = "UUID of Vehicle to be deleted", required = true) String uuid) {
        vehicleService.deleteVehicle(uuid);
    }
}