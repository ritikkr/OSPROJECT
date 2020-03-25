import java.util.Scanner;  //Scanner class is use for taking user input
import java.util.Random; //Random class is use to produce random number between given range
class OSPROJECT{
        public static void main(String args[]){
            /* Hey its me Main function, Your program is nothing without me */

            //this is main function which is intially load by JVM automatically

        Scanner input=new Scanner(System.in);  //Scanner object refernce 
        System.out.print("Enter No of user: ");
        int no_of_user=input.nextInt();   //this variable will store no of user
            giftShop(no_of_user);  //calling giftShop function

    
        }
        static void giftShop(int no_of_user){
            /* Hello there I'm giftShop function :-) */

            //I'm going to generate random number of gifts for given number of users

            Random rand=new Random();             //Random class object refernce
            
            int gifts[]=new int[no_of_user]; // Integer array to store no of gifts

            for(int i=0;i<no_of_user;i++){
                gifts[i]=rand.nextInt(50); //this will generate random no of gift between 0 to 50        
            }
             billingCounter(gifts,no_of_user);  //calling billingCounter
        }
        static void billingCounter(int gifts[],int no_of_user){
            /* Hey I'm billingCounter function :-) */
 
            /*this function will set the users according to their number of gift
            i.e., highest the number highest the priority */
            /* In this function we're making a copy of our original gift array so that we won't loose our original data
            and after we're applying sorting on gift_copy array */
            /* here we used bubble sorting method in which we're generating pass for 'n-1' person  and
            in each pass one person gets its original position */
            int gift_copy[]=gifts.clone();
            for(int pass=0; pass<no_of_user-1;pass++){
                int flag=0;
                for(int i=0;i<no_of_user-1-pass;i++){
                    if(gift_copy[i]<gift_copy[i+1]){
                        int temp=gift_copy[i];
                        gift_copy[i]=gift_copy[i+1];
                        gift_copy[i+1]=temp;
                        flag=+1;
                    }
                }
                if(flag==0){
                    /* if flag becomes 0 means our array is now sorted so need to go further it is used to reduce the complexity */
                    break;
                }             
            }
                display(gifts,gift_copy,no_of_user);  // calling the display function for displaying the output

        } //end of billingCounter function
       
       static void display(int gifts[],int gift_copy[],int no_of_user) {
            /* Hey I'm Display function :-) */
            /* I'm going to display output for your program */
            /* here we have two arrays one is sorted and another one that is our original data so we're going to match
            one by one data of sorted array with original data */

           for(int i=0;i<no_of_user;i++){
               for(int j=0;j<no_of_user;j++){
                   if(gift_copy[i]==gifts[j]){
                    try {
                        // thread to sleep for 1000 milliseconds
                        Thread.sleep(1000);
                     } catch (Exception e) {
                        System.out.println(e);
                     }
                       System.out.println((j+1)+" person have "+(i+1)+" priority with gift no: "+gifts[j]+" \n");
                       break;
                   } 
               }  //end of j
           } //end of i

        System.out.println("------------------------------------------");  
        System.out.println("\tExecution Completed ");
        System.out.println("------------------------------------------");
       }//end of display function
}
