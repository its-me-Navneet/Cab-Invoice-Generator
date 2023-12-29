package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class cabInvoiceGenerator {

    private final double minFair =5.0 ;
    private final double fairPerMin =1.0 ;
    private final double fairPerKm =10.0 ;
    private final double fairPerKmPre =20.0 ;
    private final double fairPerMinPre =2.0 ;
    private final double minFairPre =10.0 ;
    private HashMap<Integer, ArrayList<Ride>> map ;

    public cabInvoiceGenerator(){
        map = new HashMap<>() ;
        ArrayList<Ride>user1 = new ArrayList<>() ;
        user1.add(new Ride(10,5)) ;
        user1.add(new Ride(2,30)) ;
        user1.add(new Ride(15,30)) ;

        ArrayList<Ride> user2 = new ArrayList<>() ;

        user2.add(new Ride(2.5,3)) ;
        user2.add(new Ride(3,2)) ;


        map.put(1,user1) ;
        map.put(2,user2) ;


    }

    public double getFair(double dis,double time){
          double fairPrice=0 ;
          fairPrice = dis*fairPerKm + time*fairPerMin ;

          fairPrice =Math.max(fairPrice,minFair) ;
          return  fairPrice;
    }

    public double totalFair(Ride ride[]){

        double fairPrice =0 ;
        for(Ride r :ride){
            fairPrice += (r.getDis()*fairPerKm + r.getTime()*fairPerMin) ;
        }
        fairPrice = Math.max(minFair,fairPrice) ;
        return fairPrice ;
    }

    public User fairDetails(Ride ride[]){

        double fairPrice =0 ;
        for(Ride r :ride){
            fairPrice += (r.getDis()*fairPerKm + r.getTime()*fairPerMin) ;
        }
        fairPrice = Math.max(5.0,fairPrice) ;

        return new User(ride.length,fairPrice,fairPrice/ ride.length);
    }

    public double getFairThroughUserId(Integer id){

        double fairPrice =0 ;
        if(id==null){
            throw new NullPointerException("Input shouldn't be empty");
        }

        if(!map.containsKey(id)){
            throw new NullPointerException("Sorry!! no data found");
        } else {
            ArrayList<Ride> ride = map.get(id) ;

            for(Ride r :ride){
                fairPrice += (r.getDis()*fairPerKm + r.getTime()*fairPerMin) ;
            }
            fairPrice = Math.max(5.0,fairPrice) ;


        }
        return  fairPrice ;

    }
    public double getFairPremium(double dis,double time){
        double fairPrice=0 ;
        fairPrice = dis*fairPerKmPre + time*fairPerMinPre ;

        fairPrice =Math.max(fairPrice,minFairPre) ;
        return  fairPrice;
    }

}
