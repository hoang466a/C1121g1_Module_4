package com.casestudy.vn.model.contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContractDetail {
    @Id
    private String contractDetailId;
    private String quantity;
    @ManyToOne
    @JoinColumn(name="attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name="contract_id", referencedColumnName = "contractId")
    private Contract contract;
}
