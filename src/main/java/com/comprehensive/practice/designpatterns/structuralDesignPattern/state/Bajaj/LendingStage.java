package com.comprehensive.practice.designpatterns.structuralDesignPattern.state.Bajaj;

public class LendingStage implements CustomerStage{
    public StageDao stageDao;
    @Override
    public void currentStage() {
        System.out.println("stage move to 0% to 10%");
        stageDao.setPercentage(10);
    }
}
