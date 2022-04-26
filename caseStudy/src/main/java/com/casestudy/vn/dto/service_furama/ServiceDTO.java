package com.casestudy.vn.dto.service_furama;

import com.casestudy.vn.model.contract.Contract;
import com.casestudy.vn.model.service_furama.RentType;
import com.casestudy.vn.model.service_furama.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;


public class ServiceDTO implements Validator {
    private Integer serviceId;
    @NotBlank(message = "không được để trống tên!")
    private String serviceName;
    private String serviceArea;
    @NotBlank(message = "không được để trống dữ liệu")
    private String serviceCost;
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloor;


    @NotNull(message = "Không được để trống")
    private RentType rentType;

    @NotNull(message = "Không được để trống")
    private ServiceType serviceType;

    private Set<Contract> contractSet;

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public ServiceDTO() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDTO serviceDTO = (ServiceDTO) target;

        if (serviceDTO.serviceArea.trim().isEmpty()) {
        } else {
            if (!serviceDTO.serviceArea.matches("^(-?)[0-9]*$")) {
                errors.rejectValue("serviceArea",
                        "std.type", "Định dạng nhập vào không hợp lệ");
            } else if (Double.parseDouble(serviceDTO.serviceArea) < 0) {
                errors.rejectValue("serviceArea",
                        "std.number", "Số không được âm, xin nhập lại!");
            } }


        if (serviceDTO.serviceCost.trim().isEmpty()) {
        } else {
            if (!serviceDTO.serviceCost.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                errors.rejectValue("serviceCost",
                        "std.type", "Định dạng nhập vào không hợp lệ!");
            } else if (Double.parseDouble(serviceDTO.serviceCost) < 0) {
                errors.rejectValue("serviceCost",
                        "std.number", "Số không được âm, xin nhập lại!");
            }
        }

        if (serviceDTO.serviceMaxPeople.trim().isEmpty()) {
        } else {
            if (!serviceDTO.serviceMaxPeople.matches("^(-?)[0-9]*$")) {
                errors.rejectValue("serviceMaxPeople",
                        "std.type", "Định dạng nhập vào không hợp lệ");
            } else if (Double.parseDouble(serviceDTO.serviceMaxPeople) < 0) {
                errors.rejectValue("serviceMaxPeople",
                        "std.number", "Số không được âm, xin nhập lại!");
            } }

        if (serviceDTO.poolArea.trim().isEmpty()) {
        } else {
            if (!serviceDTO.poolArea.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                errors.rejectValue("poolArea",
                        "std.type", "Định dạng nhập vào không hợp lệ!");
            } else if (Double.parseDouble(serviceDTO.poolArea) < 0) {
                errors.rejectValue("poolArea",
                        "std.number", "Số không được âm, xin nhập lại!");
            }
        }

        if (serviceDTO.numberOfFloor.trim().isEmpty()) {
        } else {
            if (!serviceDTO.numberOfFloor.matches("^(-?)[0-9]*$")) {
                errors.rejectValue("numberOfFloor",
                        "std.type", "Định dạng nhập vào không hợp lệ");
            } else if (Double.parseDouble(serviceDTO.numberOfFloor) < 0) {
                errors.rejectValue("numberOfFloor",
                        "std.number", "Số không được âm, xin nhập lại!");
            } }
    }
}
