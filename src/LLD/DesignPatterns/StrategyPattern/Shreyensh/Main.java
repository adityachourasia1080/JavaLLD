package LLD.DesignPatterns.StrategyPattern.Shreyensh;


public class Main {

    public static void main(String []args){
        Vehicle sp= new SportsVehicle();
        Vehicle gv= new GoodsVehicle();

        sp.drive();
        gv.drive();
    }

}
