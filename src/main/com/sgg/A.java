package com.sgg;

import java.util.HashSet;
import java.util.Set;

public class A {
    public static void main(String... doYourBest) {
        System.out.println(new Simpson("Bart").equals(new Simpson("Bart")));
        Simpson overriddenHomer = new Simpson("Homer") {
            public int hashCode() {
                return (43 + 777) + 1;
            }
        };

        System.out.println(new Simpson("Homer").equals(overriddenHomer));
        Set set1 = new HashSet();
        set1.add(new Simpson("Homer"));
        set1.add(new Simpson("Marge"));
        Set set = new HashSet(set1);
        set.add(new Simpson("Homer"));
        set.add(overriddenHomer);

        System.out.println(set.size());
    }

    static class Simpson {
        String name;

        Simpson(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            Simpson otherSimpson = (Simpson) obj;
            return this.name.equals(otherSimpson.name) &&
                    this.hashCode() == otherSimpson.hashCode();
        }

        @Override
        public int hashCode() {
            return (43 + 777);
        }
    }

    public void printSeries (int seriesLength) {
        int a = 0;
        int b = 1;
        if (seriesLength==1) {
            System.out.println(a);
            return ;
        }
        if (seriesLength == 2){
            System.out.println(b);
            return;
        };
        for (int i = 2; i <= seriesLength; i++) {
            a=b;
            b = a+b;
            if (i!=seriesLength)
            System.out.print(b+",");
            else System.out.print(b);
        }
    }

}
