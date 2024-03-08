package com.egov.egov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "reclamation")
public class Reclamation {
    @Id
    @GeneratedValue
    private Integer id;
    private String matriculation_interior;
    private String matriculation_number;
    private Date first_time_in_circulation;
    private Date first_use_in_morocco;
    private Date mutation;
    private Date start_of_validation;
    private String address;
    private Date end_of_validity;
    private String type_of_usage;
    private String owner;
    private UUID payment_id;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Reclamation(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatriculation_number() {
        return matriculation_number;
    }

    public void setMatriculation_number(String matriculation_number) {
        this.matriculation_number = matriculation_number;
    }

    public String getMatriculation_interior() {
        return matriculation_interior;
    }

    public void setMatriculation_interior(String matriculation_interior) {
        this.matriculation_interior = matriculation_interior;
    }

    public Date getFirst_time_in_circulation() {
        return first_time_in_circulation;
    }

    public void setFirst_time_in_circulation(Date first_time_in_circulation) {
        this.first_time_in_circulation = first_time_in_circulation;
    }

    public Date getFirst_use_in_morocco() {
        return first_use_in_morocco;
    }

    public void setFirst_use_in_morocco(Date first_use_in_morocco) {
        this.first_use_in_morocco = first_use_in_morocco;
    }

    public Date getMutation() {
        return mutation;
    }

    public void setMutation(Date mutation) {
        this.mutation = mutation;
    }

    public Date getStart_of_validation() {
        return start_of_validation;
    }

    public void setStart_of_validation(Date start_of_validation) {
        this.start_of_validation = start_of_validation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnd_of_validity() {
        return end_of_validity;
    }

    public void setEnd_of_validity(Date end_of_validity) {
        this.end_of_validity = end_of_validity;
    }

    public String getType_of_usage() {
        return type_of_usage;
    }

    public void setType_of_usage(String type_of_usage) {
        this.type_of_usage = type_of_usage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public UUID getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(UUID payment_id) {
        this.payment_id = payment_id;
    }

    @PrePersist
    public void prePersist() {
        if (this.payment_id == null) {
            this.payment_id = UUID.randomUUID();
        }
    }

}
