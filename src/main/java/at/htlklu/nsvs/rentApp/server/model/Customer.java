package at.htlklu.nsvs.rentApp.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(description = "Customer which rents a Vehicle")
public class Customer {

    //region properties
    @NotNull
    @ApiModelProperty(notes = "unique identifier of Customer", position = 0, required = true)
    private String uuid;

    @NotBlank
    @Length(min = 2, max = 3)
    @ApiModelProperty(notes = "surname of Customer", position = 1, required = true)
    private String surname;

    @NotBlank
    @Length(min = 2, max = 3)
    @ApiModelProperty(notes = "firstname of Customer", position = 2, required = true)
    private String firstname;

    @Past
    @ApiModelProperty(notes = "date of birth of Customer - must be in the past", position = 3, example = "2000-02-02", required = true)
    private LocalDate dateOfBirth;
    //endregion


    //region toString
    @Override
    public String toString() {
        return "Customer{" +
                "uuid='" + uuid + '\'' +
                "surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
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

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    //endregion


    //region equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(uuid, customer.uuid) && Objects.equals(surname, customer.surname) && Objects.equals(firstname, customer.firstname) && Objects.equals(dateOfBirth, customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, surname, firstname, dateOfBirth);
    }
    //endregion
}