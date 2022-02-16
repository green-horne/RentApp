package at.htlklu.nsvs.rentApp.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@ApiModel(description = "Vehicle which are available for rent")
public class Vehicle {

    //region properties
    @NotNull
    @ApiModelProperty(notes = "unique identifier of Vehicle", position = 0, required = true)
    private String uuid;

    @NotBlank
    @ApiModelProperty(notes = "name of the Vehicle", position = 1, required = true)
    private String name;

    @NotBlank
    @ApiModelProperty(notes = "type of the Vehicle", position = 2, required = true)
    private String typ;

    @NotNull
    @ApiModelProperty(notes = "specifies mileage of the Vehicle", position = 3, required = true)
    private int km;

    @NotNull
    @Min(1980)
    @Max(2030)
    @ApiModelProperty(notes = "specifies the year of construction of the Vehicle", position = 4, required = true)
    private int constructionYear;
    //endregion


    //region toString
    @Override
    public String toString() {
        return "Vehicle{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", typ='" + typ + '\'' +
                ", km=" + km +
                ", constructionYear=" + constructionYear +
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTyp() {
        return typ;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getKm() {
        return km;
    }
    public void setKm(int km) {
        this.km = km;
    }

    public int getConstructionYear() {
        return constructionYear;
    }
    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }
    //endregion


    //region equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return km == vehicle.km && constructionYear == vehicle.constructionYear && Objects.equals(uuid, vehicle.uuid) && Objects.equals(name, vehicle.name) && Objects.equals(typ, vehicle.typ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, typ, km, constructionYear);
    }
    //endregion
}