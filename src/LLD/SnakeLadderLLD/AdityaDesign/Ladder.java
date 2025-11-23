package LLD.SnakeLadderLLD.AdityaDesign;

import java.util.HashMap;

public class Ladder {

    public HashMap<Integer,Integer> mp;

    public Ladder(){
        mp= new HashMap<>();
    }

    public void addLadder(int  start,int end){
        mp.put(start,end);
    }

    public void removeLadder(int start,int end){
        //logic here
    }
}
