package com.myproject.introduction;


public class GarbageCollector {
    static int objCount;

    @Override
    protected void finalize() throws Throwable {
        try {
            //... clean up here
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            super.finalize();
//            System.out.println("Garbage Collector finalized");
            System.out.println(objCount++);
//
        }
    }

    //        Method scope
    void hello() {
        GarbageCollector gc = new GarbageCollector();
        System.out.println("hello");
    }

    static void main() throws InterruptedException {
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

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        System.gc(); // Manual way


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

class IslandOfIsolation {
    static void main() {

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

        System.out.println(zudio);
        System.out.println(trendz);
    }
}

class Test {

    static void main() {
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


class GCTest {
    static int objCount = 0;

    @Override
    protected void finalize() throws Throwable {
        System.out.println(++objCount);
        super.finalize();
    }

    static void main() throws InterruptedException {
        System.out.println("GCTest started");
        GCTest t1 = new GCTest();
        GCTest t2 = new GCTest();

        t1 = t2;

        t1 = null;
        t2 = null;

        Thread.sleep(2000);
        System.gc();
        System.out.println("GCTest ended");
    }
}