package LLD.DesignPatterns.AdapterDesignPattern.Adapter;

import LLD.DesignPatterns.AdapterDesignPattern.WeightMachineInPounds;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    WeightMachineInPounds weightMachineInPounds;

    public WeightMachineAdapterImpl(WeightMachineInPounds wt) {
        this.weightMachineInPounds=wt;
    }

    @Override
    public int getWeightInKg() {
        double  weightInPounds = weightMachineInPounds.getWeightInPounds();
        return (int)(weightInPounds * 0.453592);
    }
}
