public class BitManipulation {
    
    public static void evenOdd(int n) {
        int bit = 1;
        if ((n & bit) == 1 ){
            System.out.println("Odd");
        }
        else
        System.out.println("Even");

    }

    public static void getIthBit(int n,int i) {
        int bit = 1;

        if ((n&(bit<<i))!=0){
            System.out.println("The "+i+" bit of "+n+" is 1");
        }
        else
        System.out.println("The "+i+" bit of "+n+" is 0");
    }

    public static void setIthBit(int n,int i) {
        int bit = 1;
        n = n | ( bit<<i );
        System.out.println( n );
    }

    public static void clearIthBit(int n,int i) {
        int bit = 1;
        n = n & ( ~(bit<<i) );
        System.out.println( n );
        
        }
    
    public static void updateIthBit(int n,int i){
        int bit = 1;

        if ((n&(bit<<i))!=0){
            clearIthBit(n, i);
        }
        else
            setIthBit(n, i);
    }

    public static void nthMagicNumber(int n){
        int sum=0,base = 5;
        while(n>0){
            int lastbit = n & 1;
            n=n>>1;
            sum+=base*lastbit;
            base*=5;
        }
        System.out.println(sum);
    }
    
    public static void swapNos(int a,int b){
        a=a^b;
        b=b^a;
        a=a^b;
        System.out.println("After swap value of a is "+a);
        System.out.println("After swap value of b is "+b);
    }
    
    public static void upperTolower(){
        for (char ch='A';ch<='Z';ch++){
            System.out.print((char)(ch | ' ')+" ");
        }
    }
    
    
    public static void main(String[] args) {
        // evenOdd(2);
        // getIthBit(8,2);
        // setIthBit(8,2);  // setting the bit to 1 no matter what
        // clearIthBit(10, 1);  // setting the bit to 0 no matter what
        // updateIthBit(12, 2);  // updating the bit to different bit 
        // nthMagicNumber(5);
        // swapNos(4,10);
        // upperTolower();

    }
}