package org.example.model;

import java.util.Date;

public class ParkingReceipt {

    String receiptNumber;
    Date entryDate;
    Date exitDate;

    Integer fees;

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "ParkingReceipt{" +
                "receiptNumber='" + receiptNumber + '\'' +
                ", entryDate=" + entryDate +
                ", exitDate=" + exitDate +
                ", fees=" + fees +
                '}';
    }
}
