package com.myapp.design.pattern.creational.factory;

import java.util.HashMap;

public class PlanFactory {
    private static final HashMap<String, Plan> REGISTERED_PLANS = new HashMap<>();

    public static void registerPlan(String s, Plan p) {
        REGISTERED_PLANS.put(s, p);
    }

    public Plan getPlan(String planType) {
        return REGISTERED_PLANS.get(planType);
    }
}
