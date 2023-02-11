import java.util.*; 
import java.io.*;

class Main {

  public static int FirstFactorial(int num) {
    // code goes here
    for (int i=0;i<=num;i++)
    {
      num = num*i;
      i--;

    }  
    return num;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(FirstFactorial(s.nextLine())); 
  }

}