package org.example;

import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        char restart ='Y';
        while(restart!='N'){
            try {
                System.out.println("Select the number of real players :");
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                System.out.println("Select the number of bots :");
                int m = sc.nextInt();
                Game uno = new Game(n, m);
                uno.Start();
                System.out.println("do you want to restart? (Y/N)");
                restart = sc.next().charAt(0);
                if (restart != 'N' && restart != 'Y') {
                    System.out.println("wrong input Try again");
                }
            }catch (Exception e){
                System.out.println("wrong input Try again");
            }
        }
    }
    }
