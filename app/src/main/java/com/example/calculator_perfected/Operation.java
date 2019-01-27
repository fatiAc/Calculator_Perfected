package com.example.calculator_perfected;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "operation")
public class Operation {

    @Id(autoincrement = true)
    private Long id;
    private Double operation;

    public Operation(Double operation) {
        this.operation = operation;
    }

    @Generated(hash = 120111609)
    public Operation(Long id, Double operation) {
        this.id = id;
        this.operation = operation;
    }
    @Generated(hash = 1326595030)
    public Operation() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getOperation() {
        return this.operation;
    }
    public void setOperation(Double operation) {
        this.operation = operation;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operation=" + operation +
                '}';
    }
}
