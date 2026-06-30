package com.myproject.introduction;


public class GarbageCollector {
    @Override
    protected void finalize() throws Throwable {
        try {
            //... clean up here
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            super.finalize();
            System.out.println("Garbage Collector finalized");

        }
    }

    //    Method scope
    void hello() {
        GarbageCollector gc = new GarbageCollector();
        System.out.println("hello");
    }

    static void main() {
        GarbageCollector obj1 = new GarbageCollector(); //ea30797
        GarbageCollector obj2 = new GarbageCollector(); //58d25a40
        GarbageCollector obj3 = new GarbageCollector(); //1b701da1

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        obj1 = null; // Nullify the object

        new GarbageCollector().hello(); // Anonymous object

        obj3.hello(); //Method scope

        obj2 = obj3; // Re-assigning the object

        /*
          Island of Isolation
         */
        Zudio zudio = new Zudio();
        Trendz trendz = new Trendz();

        /*
        A ---> B
        ^      |
        |      v
        +------+
         */
        zudio.trendz = trendz;
        trendz.zudio = zudio;
        System.out.println(zudio);
        System.out.println(trendz);

        /*
        a ──► A ──► B
              ▲     │
              │     ▼
              └─────┘
        b ──────────►
         */

        zudio = null;
        trendz = null;

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        System.out.println(zudio);
        System.out.println(trendz);

        System.gc(); // Manual way

        System.out.println("________________________________");

        int i1 = 65;

        char c1 = (char) i1;

        IO.println(i1 + " " + c1);
        IO.println(i1 + c1);

        Character ch1 = (char) i1;
        Character ch2 = 'i';
        IO.println(ch1 + " " + ch2);
        IO.println(ch1 + ch2);

        byte bite = 127;
        bite++;
        IO.println(bite);

        bite = 127;
        double temp = bite + 1.0;
        IO.println(temp);

        System.out.println(null == null);
        System.out.println("" == "");

        System.out.println("" + null); //null
        System.out.println(null == "" + null); //false
        System.out.println(null instanceof Object); //false


    }
}

class Zudio {
    Trendz trendz;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Zudio finalized");
        super.finalize();
    }
}

class Trendz {
    Zudio zudio;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Trendz finalized");
        super.finalize();
    }
}
