import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        createOceanmap();
        userDeployShip();
        computerDeployShip();
        battle();
    }
    static String[][] ocean = new String[10][10];
    static int getRandomNumber(int min,int max){
        int n = (int)(Math.random()*(max - min))+min;
        return n;
    }
    public static void createOceanmap(){
        System.out.println("  0123456789");
        for(int i=0;i<ocean.length;i++){
            System.out.print(i);
            System.out.print("|");
            for(int j=0;j<ocean.length;j++){
                if(ocean[i][j]==null){
                    System.out.print(" ");
                }
                if (ocean[i][j]=="1"){
                    System.out.print("@");
                }
                else if(ocean[i][j]=="2"){
                    System.out.print(" ");
                }
                else if(ocean[i][j]=="x"){
                    System.out.print("x");
                }
                else if(ocean[i][j]=="!"){
                    System.out.print("!");
                }
                else if(ocean[i][j]=="-"){
                    System.out.print("-");
                }
            }
            System.out.print("|");
            System.out.println(i);
        }
        System.out.println("  0123456789");
    }
    public static void userDeployShip(){
        int x,y,shipNo=1;

        Scanner input = new Scanner(System.in);
        while (shipNo<=5){
            System.out.print("enter the x coordinate of ship "+shipNo+" : ");
            x=input.nextInt();
            System.out.print("enter the y coordinate of ship "+shipNo+" : ");
            y=input.nextInt();
            if(x>0 && x<10 && y>0 && y<10){
                if(ocean[x][y] != null){
                    System.out.println("Already some ship is present in that location");
                }
                else {
                    ocean[x][y]="1";
                    shipNo++;
                }
            }
            else {
                System.out.println("the coordinate is out of the battle range");
            }
        }
        try {
            System.out.println("Loading....\n");
            Thread.sleep(2000);
            createOceanmap();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
    public static void computerDeployShip(){
        try {
            int x,y,shipNo = 1;
            System.out.println("\nComputer's turn to deploying the  ship");
            Thread.sleep(2000);
            while (shipNo<=5){
                System.out.println(shipNo+".computer deploying the ship");
                x = getRandomNumber(1,9);
                y = getRandomNumber(1,9);
                Thread.sleep(2000);
                System.out.println(x+" "+y);
                if(x>0 && x<10 && y>0 && y<10){
                    if(ocean[x][y] != null){
                        System.out.println("Already some ship is present in that location");
                    }
                    else {
                        ocean[x][y]="2";
                        shipNo++;
                    }
                }
                else {
                    System.out.println("the coordinate is out of the battle range");
                }
            }
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }

        createOceanmap();
    }
    public static void battle(){
        System.out.println("\nBattle begin");
        int x,y,j=0,userShips=5,computerShips=5;
        Scanner input = new Scanner(System.in);
        while(j<=5){
            j++;
            System.out.println("\nyour turn");
            System.out.print("input x coordinate : ");
            x = input.nextInt();
            System.out.print("input your y coordinate : ");
            y = input.nextInt();
            if(x>0 && x<10 && y>0 && y<10){
                if(ocean[x][y]!=null){
                    switch (ocean[x][y]){
                        case "1":
                            System.out.println("Oh no, you sunk your own ship");
                            ocean[x][y]="x";
                            userShips--;
                            break;
                        case "2":
                            System.out.println("Boom! You sunk the ship!");
                            ocean[x][y]="!";
                            computerShips--;
                            break;
                    }
                }
                else {
                    System.out.println("you missed");
                    ocean[x][y]="-";
                }

            }
            else {
                System.out.println("the coordinate is out of the battle range");
            }
            System.out.println("\nEnemy turn");
            x = getRandomNumber(1,9);
            y = getRandomNumber(1,9);
            if(x>0 && x<10 && y>0 && y<10){
                if(ocean[x][y]!=null){
                    switch (ocean[x][y]){
                        case "1":
                            System.out.println("The Computer sunk one of your ships!");
                            ocean[x][y]="x";
                            userShips--;
                            break;
                        case "2":
                            System.out.println("The Computer sunk one of its own ships");
                            ocean[x][y]="!";
                            computerShips--;
                            break;
                    }
                }
                else {
                    System.out.println("Enemy missed");
                    ocean[x][y]="-";
                }
            }
            else {
                System.out.println("the coordinate is out of the battle range");
            }
            createOceanmap();
            System.out.println("your ships : "+userShips+"   "+"enemy ships : "+computerShips);
        }


        if(userShips>computerShips){
            System.out.println("\n\n\nYou win!!");
        }
        else if(userShips==computerShips){
            System.out.println("\n\n\ntie!!");
        }
        else{
            System.out.println("\n\n\nEnemy win!");
        }
        createOceanmap();
        System.out.println("your ships : "+userShips+"   "+"enemy ships : "+computerShips);
    }

}