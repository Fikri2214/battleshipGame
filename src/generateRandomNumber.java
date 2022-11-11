public class generateRandomNumber {
    public static void main(String[] args){
        checkNumbers();
    }

    static int getRandomNumber(int min,int max){
        int n = (int)(Math.random()*(max - min))+min;
        return n;
    }
    public static void checkNumbers(){
        int x,y;
        x = getRandomNumber(1,100);
        y = getRandomNumber(1,100);
        System.out.println(x+" "+y);
        }
}

