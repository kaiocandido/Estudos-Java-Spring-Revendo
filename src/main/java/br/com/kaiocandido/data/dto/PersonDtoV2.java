package br.com.kaiocandido.data.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonDtoV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String fistName;
    private String lastName;
    private Date birthDay;
    private String address;
    private String gender;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public PersonDtoV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDtoV2 that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(fistName, that.fistName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDay, that.birthDay) && Objects.equals(address, that.address) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fistName, lastName, birthDay, address, gender);
    }
}

