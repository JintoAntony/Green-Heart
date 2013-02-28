/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author prime
 */
public class Schedulingtemp {
    
    
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
    
/* Find the peak load Lp from time t to time t + TRESTARTING
Find the number of necessary servers at time t: Nt = ‫ ڿ‬Lp
div C ‫ۀ‬
Assume Nc = number of servers in ON state
*/     
 int nt = 0;    //total number of servers
 int nc = 0;    //number of servers in on state
 
 //int nt=Integer.parseInt(object.readLine());
 //int nc=Integer.perseInt(object.readLine());
 if(nt==nc)
 {
    System.out.println("\nThe servers in the best state,No action performed");
 }
 else if(nt > nc)
 {
   System.out.println("\nservers in OFF state and signal them to restart");  
 }
 else
 {
 System.out.println("\nThe servers in ON state with free processing cores and signal them to shutdown");
 }

   
}
 