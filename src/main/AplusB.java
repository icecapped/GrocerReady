package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Random;

public class AplusB
{
    public static void main(String[] argument) throws IOException {
    	int numberOfNumbers;
    	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    	numberOfNumbers= Integer.parseInt(console.readLine());
    	for (int index = 1; index<(numberOfNumbers); index++) {
    		int numberA;
    		int numberB;
    		numberA= Integer.parseInt(console.readLine());
    		numberB= Integer.parseInt(console.readLine());
    		
    		System.out.println(numberA+numberB);
    	}
    }
}
