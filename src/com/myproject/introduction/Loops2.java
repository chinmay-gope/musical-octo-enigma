package com.myproject.introduction;

public class Loops2 {

    void main() {
        meth1();
        meth2();
        meth3();
        meth4();
        meth5(); //doubt
        meth6(); //doubt
        meth7();
        meth8();
        meth9();
        meth10();
        meth11(); //doubt
        meth12(); //doubt

        meth14();
    }

    void meth1() {
        int i = 0;
        for (i = -10; i < 10; i++) ;
        System.out.println("for " + i);
        System.out.println("for " + i);
        System.out.println("for " + i);
        {
            i++;
        }
        System.out.println("Loops2.meth1 : " + i);
    }

    void meth2() {
        int i = 0;
        for (i = 1; i < 10; i++) ;
        {
            i=i+10;
        }
        System.out.println("Loops2.meth2 : " + i);
    }

    void meth10() {
        int i = 0;
        for (i = 12; i < 10; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth10 : " + i);
    }

    void meth3() {
        int i = 0;
        for (i = -10; i < -8; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth3 : " + i);
    }

    void meth11() {
        int i = 0;
        for (i = -10; i > -8; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth11 : " + i);
    }

    void meth4() {
        int i = 0;
        for (i = 1; i > 10; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth4 : " + i);
    }

    void meth12() {
        int i = 0;
        for (i = -10; i < -8; i++) ;
        {
            i++; //-7
//            i--; -9
        }
        System.out.println("Loops2.meth12 : " + i);
    }


    void meth5() {
        int i = 0;
        for (i = 1; i < i++; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth5 : " + i);
    }

    void meth6() {
        int i = 0;
        for (i = 1; i < ++i; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth6 : " + i);
    }

    void meth13() {
        int i = 0;
        for (i = 1; i < ++i; i--) ;
        {
            i++;
        }
        System.out.println("Loops2.meth13 : " + i);
    }

    void meth14() {
        int i = 0;
        for (i = 1; i < --i; i--) ;
        {
            i++;
        }
        System.out.println("Loops2.meth14 : " + i);
    }

    void meth15() {
        int i = 0;
        for (i = 1; i > --i; i--) ;
        {
            i++;
        }
        System.out.println("Loops2.meth15 : " + i);
    }


    void meth7() {
        int i = 0;
        for (i = -2; i < 10; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth7 : " + i);
    }

    void meth8() {
        int i = 0;
        for (i = -21; i < 10; i++) ;
        {
            i++;
        }

        System.out.println("Loops2.meth8 : " + i);
    }

    void meth9() {

        int i = 0;
        for (i = 20; i < 10; i++) ;
        {
            i++;
        }
        System.out.println("Loops2.meth9 : " + i);
    }
}

class LoopCases {

    public static void main(String[] args) {
        standardIncreasing();
        standardDecreasing();
        emptyBody();
        infiniteLoopWithBreak();
        conditionNeverTrue();
        conditionAlwaysTrue();
        postIncrementCondition();
        preIncrementCondition();
        customStepSize();
        noInitializer();
        noCondition();
        noIncrement();
        multipleVariables();
    }

    static void standardIncreasing() {
        for (double i = 10.0; i < 30.5; i = i + 0.5) {
            System.out.println("standardIncreasing: " + i);
        }
    }

    static void standardDecreasing() {
        for (double i = 15.0; i > 0.0; i = i - 0.5) {
            System.out.println("standardDecreasing: " + i);
        }
    }

    static void emptyBody() {
        int i;
        for (i = 0; i < 5; i++) ; // body is empty
        System.out.println("emptyBody final i: " + i);
    }

    static void infiniteLoopWithBreak() {
        int i = 0;
        for (; ; ) {
            if (i >= 3) break;
            System.out.println("infiniteLoopWithBreak: " + i);
            i++;
        }
    }

    static void conditionNeverTrue() {
        for (int i = 10; i < 5; i++) {
            System.out.println("conditionNeverTrue: " + i); // never runs
        }
        System.out.println("conditionNeverTrue finished");
    }

    static void conditionAlwaysTrue() {
        int i = 0;
        for (; i >= 0; i++) {
            if (i > 3) break; // prevent infinite loop
            System.out.println("conditionAlwaysTrue: " + i);
        }
    }

    static void postIncrementCondition() {
        int i = 1;
        for (; i < i++; ) {
            System.out.println("postIncrementCondition: " + i);
            if (i > 5) break; // safety
        }
        System.out.println("postIncrementCondition final i: " + i);
    }

    static void preIncrementCondition() {
        int i = 1;
        for (; i < ++i; ) {
            System.out.println("preIncrementCondition: " + i);
            if (i > 5) break; // safety
        }
        System.out.println("preIncrementCondition final i: " + i);
    }

    static void customStepSize() {
        for (int i = 0; i < 10; i += 2) {
            System.out.println("customStepSize: " + i);
        }
    }

    static void noInitializer() {
        int i = 0;
        for (; i < 3; i++) {
            System.out.println("noInitializer: " + i);
        }
    }

    static void noCondition() {
        for (int i = 0; ; i++) {
            if (i >= 3) break;
            System.out.println("noCondition: " + i);
        }
    }

    static void noIncrement() {
        for (int i = 0; i < 3; ) {
            System.out.println("noIncrement: " + i);
            i++; // manual increment
        }
    }

    static void multipleVariables() {
        for (int i = 0, j = 5; i < j; i++, j--) {
            System.out.println("multipleVariables: i=" + i + ", j=" + j);
        }
    }
}
