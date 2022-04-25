package com.casestudy.vn.model.contract;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AttachService {
    @Id
    private Integer attachServiceId;
    private String attachServiceName;
    private String attachServiceCost;
    private String attachServiceUnit;
    private String attachServiceStatus;
}
