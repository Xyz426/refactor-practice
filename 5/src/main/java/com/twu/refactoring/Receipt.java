package com.twu.refactoring;

public class Receipt {
    private static final int fixedCharge = 50;
    private static final double peakTimeMultplier = 1.2;
    private static final double peakMultiplier = 1.0;
    private static final int rateChangeDistance = 10;
    private static final int preRateChangeNonAc = 15;
    private static final int postRateChangeNonAc = 12;
    private static final int preRateChangeAc = 20;
    private static final int postRateChangeAc = 17;
    private static final double taxRate = 0.1;

    private static final double distanceMin = Math.min(rateChangeDistance, totalKms);
    private static final double distanceMax = Math.max(0, totalKms - rateChangeDistance);
    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost = 0;

        // fixed charges
        totalCost += fixedCharge;

        // taxi charges
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? peakTimeMultplier : peakMultiplier;
        if(taxi.isAirConditioned()) {
            totalCost += distanceMin * preRateChangeAc * peakTimeMultiple;
            totalCost += distanceMax * postRateChangeAc * peakTimeMultiple;
        } else {
            totalCost += distanceMin * preRateChangeNonAc * peakTimeMultiple;
            totalCost += distanceMax * postRateChangeNonAc * peakTimeMultiple;
        }

        return totalCost * (1 + taxRate);
    }
}
