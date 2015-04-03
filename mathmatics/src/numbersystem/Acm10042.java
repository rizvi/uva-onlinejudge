/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Acm10042 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringBuffer sb = new StringBuffer("");
        int[]primeFact=sievePrime(100000);
        int cases=Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++) {
            int x=Integer.parseInt(br.readLine());
            int temp=x+1,sumN=0,sumP=0;
            while(true){
                sumN=0;
                sumP=0;
                if(!isPrime(temp, primeFact)){
                    sumP=digitSum(temp);
                    int primes[]=primeFactors(temp);
                    for(int j=0;j<primes.length;j++){
                        int num=primes[j];
                        sumN+=digitSum(num);
                    }
                    if(sumP==sumN){
                        break;
                    }
                }
                temp++;
            }
            System.out.println(temp);
        }
    }
   
    static int[] sievePrime(int x) {
        boolean[] notPrime = new boolean[x + 1];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i * i < x + 1; i++) {
            if (!notPrime[i]) {
                for (int j = i; i * j < x + 1; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        LinkedList<Integer> list=new LinkedList<Integer>();
        for (int i = 2;i < x; i++){
            if(!notPrime[i])
                list.add(i);
        }
        int arr[]=new int[list.size()];
        for (int i = 0;i < arr.length; i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
   
    static int[] primeFactors(int x){
        LinkedList<Integer> list=new LinkedList<Integer>();
        int temp=x;
        boolean notprime=false,entered=false;
        while(temp>1 &&!notprime){
            entered=false;
            for(int i=2;i<Math.sqrt(temp)+1;i++){
                if(temp%i==0){
                    list.add(i);
                    temp/=i;
                    notprime=false;
                    entered=true;
                    break;
                }
            }
            if(!entered)
                 notprime=true;
        }
        if(notprime){
                list.add(temp);
            }
        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
   
    static int digitSum(int temp) {
        int sumP=0;
        int num=temp;
        while (num > 0) {
            sumP += num % 10;
            num /= 10;
        }
        return sumP;
    }
   
    static boolean isPrime(int x,int[]arr){
        for(int i=0;i<arr.length && x>arr[i];i++){
            if(x%arr[i]==0)
                return false;
        }
        return true;
    }
}