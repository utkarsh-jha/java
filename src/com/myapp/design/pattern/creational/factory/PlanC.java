package com.myapp.design.pattern.creational.factory;

public class PlanC extends Plan {
    static {
        PlanFactory.registerPlan("PlanC", new PlanC());
    }

    @Override
    public int generateBill() {
        return this.rate * 300;
    }


}
