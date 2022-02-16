package at.htlklu.nsvs.rentApp.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(description = "Contract which is concluded by Customer for renting a Vehicle")
public class Contract {

    //region properties
    @NotNull
    @ApiModelProperty(notes = "unique identifier of Contract", position = 0, required = true)
    private String uuid;

    @NotNull
    @ApiModelProperty(notes = "Vehicle which belongs to Contract", position = 2, required = true)
    private Vehicle vehicle;

    @NotNull
    @ApiModelProperty(notes = "Customer which belongs to Contract", position = 1, required = true)
    private Customer customer;

    @PastOrPresent
    @ApiModelProperty(notes = "date when Contract was concluded", position = 3, example = "2000-02-02", required = true)
    private LocalDate contractDate;

    @NotNull
    @ApiModelProperty(notes = "date when renting starts", position = 4, example = "2000-02-06", required = true)
    private LocalDate rentStartDate;

    @ApiModelProperty(notes = "date when renting ends", example = "2000-02-22", position = 5)
    private LocalDate rentEndDate;
    //endregion


    //region toString
    @Override
    public String toString() {
        return "Contract{" +
                "uuid='" + uuid + '\'' + "\n\t" +
                "vehicle=" + vehicle + "\n\t" +
                "customer=" + customer + "\n\t" +
                "contractDate=" + contractDate + '\'' +
                ", rentStartDate=" + rentStartDate + '\'' +
                ", rentEndDate=" + rentEndDate +
                '}';
    }
    //endregion


    //region getter & setter
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }
    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public LocalDate getRentStartDate() {
        return rentStartDate;
    }
    public void setRentStartDate(LocalDate rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public LocalDate getRentEndDate() {
        return rentEndDate;
    }
    public void setRentEndDate(LocalDate rentEndDate) {
        this.rentEndDate = rentEndDate;
    }
    //endregion


    //region equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(uuid, contract.uuid) && Objects.equals(vehicle, contract.vehicle) && Objects.equals(customer, contract.customer) && Objects.equals(contractDate, contract.contractDate) && Objects.equals(rentStartDate, contract.rentStartDate) && Objects.equals(rentEndDate, contract.rentEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, vehicle, customer, contractDate, rentStartDate, rentEndDate);
    }
    //endregion
}