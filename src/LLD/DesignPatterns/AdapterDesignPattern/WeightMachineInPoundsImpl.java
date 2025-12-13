package LLD.DesignPatterns.AdapterDesignPattern;

public class WeightMachineInPoundsImpl implements WeightMachineInPounds {

    private double weightInPounds;

    public WeightMachineInPoundsImpl(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    @Override
    public double getWeightInPounds() {
        return weightInPounds;
    }
}
