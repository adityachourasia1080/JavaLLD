package LLD.DesignPatterns.AdapterDesignPattern;

import LLD.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import LLD.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Client {

    public static void main(String[] args) {
        WeightMachineInPounds weightMachine = new WeightMachineInPoundsImpl(150.0);
        WeightMachineAdapter adapter = new WeightMachineAdapterImpl(weightMachine);

        double weightInKg = adapter.getWeightInKg();
        System.out.println("Weight in Kilograms: " + weightInKg);
    }
}
