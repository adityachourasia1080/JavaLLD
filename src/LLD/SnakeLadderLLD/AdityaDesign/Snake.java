package LLD.SnakeLadderLLD.AdityaDesign;

import java.util.HashMap;

public class Snake {

    public HashMap<Integer,Integer> mp;

    public Snake(){
        mp= new HashMap<>();
    }

    public void addSnake(int start,int end){
        mp.put(start,end);
    }

    public void removeSnake(int  start,int end){
        //logic here
    }
}