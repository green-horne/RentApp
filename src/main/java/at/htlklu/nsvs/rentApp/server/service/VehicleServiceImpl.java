package at.htlklu.nsvs.rentApp.server.service;

import at.htlklu.nsvs.rentApp.server.model.Vehicle;
import at.htlklu.nsvs.rentApp.server.service.interfaces.VehicleService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@Scope("singleton")
public class VehicleServiceImpl implements VehicleService {

    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        vehicle.setUuid(UUID.randomUUID().toString());
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle[] listAllVehicles() {
        Vehicle[] vehicleArray = vehicles.toArray(new Vehicle[vehicles.size()]);
        return vehicleArray;
    }

    @Override
    public Vehicle updateVehicle(String uuid, String name, String typ, int km, int constructionYear) {
        Vehicle vehicle = vehicles.stream().filter(c -> c.getUuid().equals(uuid)).findFirst().get();
        vehicle.setName(name);
        vehicle.setTyp(typ);
        vehicle.setKm(km);
        vehicle.setConstructionYear(constructionYear);

        return vehicle;
    }

    @Override
    public void deleteVehicle(String uuid) {
        Vehicle vehicle = vehicles.stream().filter(v -> v.getUuid().equals(uuid)).findFirst().get();
        vehicles.remove(vehicle);
    }
}