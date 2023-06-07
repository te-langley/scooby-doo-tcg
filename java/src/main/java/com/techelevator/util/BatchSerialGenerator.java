package com.techelevator.util;

import org.apache.commons.text.RandomStringGenerator;

import java.util.ArrayList;
import java.util.List;

public class BatchSerialGenerator {

    private static RandomStringGenerator rsg;
    List<String> usedSerials; // TODO: Refactor out.
    private int quantity;

    public BatchSerialGenerator() {
        rsg = new RandomStringGenerator.Builder().selectFrom("ABCDEFGHJKLMNPRSTUVWXYZ23456789".toCharArray()).build();
        usedSerials = new ArrayList<>();
    }

    public static void main(String[] args) {
        BatchSerialGenerator bsg = new BatchSerialGenerator();
        bsg.setQuantity(50);
        List<String> serials = bsg.generateSerials();

        for (String serial : serials) {
            System.out.println(serials.indexOf(serial) + ": " + serial);
        }

    }

    public List<String> getUsedSerials() {
        return usedSerials;
    }

    public void setUsedSerials(List<String> usedSerials) {
        this.usedSerials = usedSerials;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> generateSerials() {
        List<String> serials = new ArrayList<>();

        while (serials.size() <= quantity) {
//            String proposedSerial = "";
            String proposedSerial = rsg.generate(6); // TODO: Magic number.
            if (serialIsValid(proposedSerial)) {
                serials.add(proposedSerial);
            }
        }

        return serials;
    }

    private boolean serialIsValid(String serialToCheck) {
        return !usedSerials.contains(serialToCheck);
    }


}
