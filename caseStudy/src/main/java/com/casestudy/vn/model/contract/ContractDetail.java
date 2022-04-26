package com.casestudy.vn.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String contractDetailId;
    private String quantity;
    @ManyToOne
    @JoinColumn(name="attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name="contract_id", referencedColumnName = "contractId")
    private Contract contract;

    public ContractDetail() {
    }

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
