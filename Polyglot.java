package org.example;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.util.Set;
public class Polyglot {
    public static void main(String[] args) {
        Context context = Context.newBuilder()
                .allowAllAccess(true)
                .build();
            Value cin=context.eval("python", """
            def citire():
                n=int(input("Numar: "))
                x=int(input("(1<=x<=n): "))
                if n<1:
                    print("n trebuie sa fie mai mare ca 1")
                    return None
                if x<1 or x>n:
                    print("x trebuie sa fie in interval")
                    return None
                return n,x
            citire
            """);
            Value r=cin.execute();
            int n=r.getArrayElement(0).asInt();
            int x=r.getArrayElement(1).asInt();
            double p=Bin(n,x,0.5);
            System.out.println(p);
            //System.out.println(factorial(5));



    }
    public static double Bin(int n ,int x, double cap)
    {
        double stema=1-cap;
        double sum=0;
        for(int i=0;i<x;++i)
        {
            double c=factorial(n)/(factorial(i)*factorial(n-i));
            double p=c*Math.pow(cap,i)*Math.pow(stema,n-i);
            sum+=p;
        }
        return sum;
    }
public static double factorial(int n) {
    double s = 1;
    for (int i = 1; i <= n; i++) {
        s *= i;
    }
    return s;
}
}
