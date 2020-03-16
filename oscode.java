import java.util.Scanner;
import java.util.Random;
class OSProject{
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        Random rand=new Random();
      /*  System.out.println("No of User: ");
        int n=input.nextInt();  */
        int n=10;                        
        int gift[]=new int[n];                          //creating an array for 'n' gift 
        for(int i=0;i<n;i++){
            gift[i]=rand.nextInt(50);
        }    
        int gift_copy[]=gift.clone();
        for(int pass=0;pass<n-1;pass++){
            int flag=0;
            for(int i=0;i<n-1-pass;i++){
                if(gift_copy[i]<gift_copy[i+1]){
                    int temp=gift_copy[i];
                    gift_copy[i]=gift_copy[i+1];
                    gift_copy[i+1]=temp;         
                    flag=flag+1;
                }
            }
            if(flag==0){
                break;
            }
        }
        //now our gift_copy array is now sorted
        for(int i=0;i<n;i++){
            System.out.println(gift_copy[i]+" and gift: "+gift[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                    if(gift_copy[i]==gift[j]){
                        System.out.println((j+1)+" person have "+(i+1)+" priority with gift no: "+gift[j]);
                        break;
                    }
            }
        }

    }
}
