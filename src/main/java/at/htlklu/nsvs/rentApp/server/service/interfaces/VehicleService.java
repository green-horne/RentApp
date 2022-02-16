package at.htlklu.nsvs.rentApp.server.service.interfaces;

import at.htlklu.nsvs.rentApp.server.model.Vehicle;

public interface VehicleService {

    public Vehicle createVehicle(Vehicle vehicle);
    public Vehicle[] listAllVehicles();
    public Vehicle updateVehicle(String uuid, String name, String typ, int km, int constructionYear);
    public void deleteVehicle(String uuid);
}