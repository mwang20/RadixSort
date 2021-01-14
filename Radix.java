import java.util.*;

public class Radix{
  
  public static int nth(int n, int col){
    if (Math.pow(n, col) > n){
      throw new IllegalArgumentException();
    }
    int move = col;
    while (move != 0){
      n = n / 10;
    }
    int nth = n % 10;
    return nth;
  }
  
}