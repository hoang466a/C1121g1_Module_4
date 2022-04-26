package com.casestudy.vn.model.service_furama;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    private Integer rentTypeId;
    private String rentTypeName;
    @Column(columnDefinition = "Decimal(10,2)")
    private double rentTypeCost;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private Set<Service> service;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}
