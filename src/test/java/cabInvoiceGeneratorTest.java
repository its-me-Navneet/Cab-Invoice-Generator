import org.example.Ride;
import org.example.User;
import org.example.cabInvoiceGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class cabInvoiceGeneratorTest {

    cabInvoiceGenerator cabInvoice = new cabInvoiceGenerator() ;
     @Test
    public void calculatefareSadTest(){
        double time =2.5 ;
        double dis = 4 ;
        double expected = 40.0 ;
        assertNotEquals(expected,cabInvoice.getFair(dis,time));
    }
    @Test
    public void calculatefare(){
         double time =2.5 ;
         double dis = 4 ;
         double expected = 42.5 ;
       assertEquals(expected,cabInvoice.getFair(dis,time));
    }

    @Test
    public void calculateMinFare(){
        double time =1 ;
        double dis = 0.2 ;
        double expected = 5 ;
        assertEquals(expected,cabInvoice.getFair(dis,time));
    }
   @Test
    public void calculateFareForMultipleRide(){

        Ride ride[] = new Ride[5] ;
        ride[0] = new Ride(5.0,3) ;
        ride[1] = new Ride(10.0,6) ;
        ride[2] = new Ride(5.0,8) ;
        ride[3] = new Ride(10.0,30) ;
        ride[4] = new Ride(5,10) ;

        double expexted = 407.0 ;
        assertEquals(expexted,cabInvoice.totalFair(ride));
    }
    @Test
    public void getDetailsOfRide(){

        Ride ride[] = new Ride[5] ;
        ride[0] = new Ride(5.0,3) ;
        ride[1] = new Ride(10.0,6) ;
        ride[2] = new Ride(5.0,8) ;
        ride[3] = new Ride(10.0,30) ;
        ride[4] = new Ride(5,10) ;

        User detailsExpected = new User(5,407.0,81.4) ;

        assertEquals(detailsExpected,cabInvoice.fairDetails(ride));
    }

    @Test
    public void getTotalFairById(){
         int id=1 ;
         double expected = 335.0 ;

         assertEquals(expected,cabInvoice.getFairThroughUserId(id));
    }

    @Test
    public void userIdNotPresent(){

          int id=5 ;
        Throwable exception = assertThrows(NullPointerException.class, ()->{
            cabInvoice.getFairThroughUserId(id);
        });

        assertEquals("Sorry!! no data found", exception.getMessage());

    }

    @Test
    public void userIdNull(){

         Integer id=null ;
        Throwable exception = assertThrows(NullPointerException.class, ()->{
            cabInvoice.getFairThroughUserId(id);
        });

        assertEquals("Input shouldn't be empty", exception.getMessage());
    }

    @Test
    public void fairOfPremiumRide(){
        double time =1 ;
        double dis = 0.2 ;
        double expected = 10.0 ;
        assertEquals(expected,cabInvoice.getFairPremium(dis,time));
    }



}
