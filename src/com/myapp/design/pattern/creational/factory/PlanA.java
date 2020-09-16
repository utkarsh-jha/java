package com.myapp.design.pattern.creational.factory;

import com.myapp.algoritmn.self.easy.PalindromeNumber;

public class PlanA extends Plan {
    static {
        PlanFactory.registerPlan("PlanA", new PlanC());
    }

    @Override
    public int generateBill() {
        return this.rate * 100;
    }


}
