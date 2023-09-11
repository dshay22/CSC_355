import java.util.Scanner;

class HelloWorld {
    // Your program begins with a call to main().
    // Prints "Hello, World" to the terminal window.
    public static void main(String args[])
    {
        long answer;
        for(int i = 0; i < 20; i ++){
            answer = Fact(i);
            System.out.println(answer);
        }
    }

    public static long Fact(int Num){
        long result = 1;
        
        for(int i = Num; i > 0; --i){
            result = result * i;
        }
        return result;
    }
}
