package com.techelevator.util;

import org.apache.commons.text.RandomStringGenerator;

public  class SerialGenerator {

    private static RandomStringGenerator rsg;

    public SerialGenerator() {
        rsg = new RandomStringGenerator.Builder().selectFrom("ABCDEFGHJKLMNPRSTUVWXYZ23456789".toCharArray()).build();
    }

    public static String generateSerial() {
        System.out.println("testing");
        return rsg.generate(6);
    }

}
