package com.myproject.introduction;

public class Introduction {
    static {
        System.out.println("Static block loaded");
    }

    static int objCreationCount = 0;

    {
        objCreationCount++;
    }

      void main() {
        System.out.println("Hello World");
        Introduction i1 = new Introduction();
        Introduction i2 = new Introduction();
        Introduction i3 = new Introduction();
        Introduction i4 = new Introduction();

//        If main method is static     : it  will not create an object for main() hence o/p is "4"
//        If main method is non-static : it  will create an object for main() also hence o/p is "5"
        System.out.println("Count : " + (objCreationCount - 1));
    }
}
