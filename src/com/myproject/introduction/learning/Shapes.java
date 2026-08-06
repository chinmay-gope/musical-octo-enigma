package com.myproject.introduction.learning;

import java.util.Scanner;

public class Shapes {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        Shapes obj = new Shapes();

        System.out.print("Enter Length: ");
        double l = sc.nextDouble();
        System.out.print("Enter Width: ");
        double w = sc.nextDouble();
        displayArea("Rectangle", obj.getAreaRectangle(l, w));

        System.out.print("Enter radius: ");
        double r = sc.nextDouble();
        displayArea("Circle", obj.getAreaCircle(r));

        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double ht = sc.nextDouble();
        displayArea("Triangle", obj.getAreaTriangle(base, ht));

        System.out.print("Enter base A: ");
        double a = sc.nextDouble();
        System.out.print("Enter base B: ");
        double b = sc.nextDouble();
        System.out.print("Enter height of Trapezoid: ");
        double h = sc.nextDouble();
        displayArea("Trapezoid", obj.getAreaTrapezoid(a, b, h));

        System.out.println("Enter side: ");
        double side = sc.nextDouble();
        displayArea("Square", obj.getAreaSquare(side));

        System.out.println("Enter base of Parallelogram: ");
        double baseP = sc.nextDouble();
        System.out.println("Enter height of Parallelogram: ");
        double heightP = sc.nextDouble();
        displayArea("Parallelogram", obj.getAreaRectangle(baseP, heightP)); //same formula as Rectangle

        System.out.println("Enter diagonal1 of Rhombus: ");
        double d1R = sc.nextDouble();
        System.out.println("Enter diagonal2 of Rhombus: ");
        double d2R = sc.nextDouble();
        displayArea("Rhombus", obj.getAreaRhombus(d1R, d2R));

        System.out.println("Enter semi-major axis of Ellipse: ");
        double aE = sc.nextDouble();
        System.out.println("Enter semi-minor axis of Ellipse: ");
        double bE = sc.nextDouble();
        displayArea("Ellipse", obj.getAreaEllipse(aE, bE));

        System.out.println("Enter diagonal1 of Kite: ");
        double d1K = sc.nextDouble();
        System.out.println("Enter diagonal2 of Kite: ");
        double d2K = sc.nextDouble();
        displayArea("Kite", obj.getAreaRhombus(d1K, d2K)); // same formula as Rhombus

        System.out.println("Enter radius of Sector: ");
        double rS = sc.nextDouble();
        System.out.println("Enter angle (degrees) of Sector: ");
        double thetaS = sc.nextDouble();
        displayArea("Sector", obj.getAreaSector(rS, thetaS));

        System.out.println("Enter outer radius of Annulus: ");
        double R = sc.nextDouble();
        System.out.println("Enter inner radius of Annulus: ");
        double rA = sc.nextDouble();
        displayArea("Annulus", obj.getAreaAnnulus(R, rA));

        System.out.println("Enter side of Regular Pentagon: ");
        double sidePentagon = sc.nextDouble();
        displayArea("Pentagon", obj.getAreaPentagon(sidePentagon));

        System.out.println("Enter side of Regular Hexagon: ");
        double sideHex = sc.nextDouble();
        displayArea("Hexagon", obj.getAreaHexagon(sideHex));

        System.out.println("Enter side of Regular Octagon: ");
        double sideOct = sc.nextDouble();
        displayArea("Octagon", obj.getAreaOctagon(sideOct));

        System.out.println("Enter number of sides of Regular Polygon: ");
        int nPoly = sc.nextInt();
        System.out.println("Enter side length of Regular Polygon: ");
        double sidePoly = sc.nextDouble();
        displayArea("Regular Polygon", obj.getAreaRegularPolygon(nPoly, sidePoly));

        System.out.println("Enter radius of Semicircle: ");
        double rSemi = sc.nextDouble();
        displayArea("Semicircle", obj.getAreaSemicircle(rSemi));

        System.out.println("Enter radius of Quarter Circle: ");
        double rQuarter = sc.nextDouble();
        displayArea("Quarter Circle", obj.getAreaQuarterCircle(rQuarter));


    }

    double getAreaEllipse(double A, double B) {
        return Math.PI * A * B;
    }

    double getAreaSquare(double side) {
        return side * side;
    }

    double getAreaRectangle(double l, double b) {
        return l * b;
    }

    double getAreaCircle(double r) {
        return Math.PI * r * r;
    }

    double getAreaTriangle(double b, double h) {
        return 0.5 * b * h;
    }

    double getAreaTrapezoid(double a, double b, double h) {
        return 0.5 * (a + b) * h;
    }

    double getAreaRhombus(double d1, double d2) {
        return (d1 * d2) / 2.0;
    }

    double getAreaAnnulus(double R, double r) {
        return Math.PI * (R * R - r * r);
    }

    double getAreaSector(double rS, double thetaS) {
        return (thetaS / 360.0) * getAreaCircle(rS);
    }

    double getAreaPentagon(double side) {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * getAreaSquare(side);
    }

    double getAreaHexagon(double side) {
        return (3 * Math.sqrt(3) / 2.0) * getAreaSquare(side);
    }

    double getAreaOctagon(double side) {
        return 2 * (1 + Math.sqrt(2)) * getAreaSquare(side);
    }

    double getAreaRegularPolygon(int n, double side) {
        return (n * getAreaSquare(side)) / (4.0 * Math.tan(Math.PI / n));
    }

    double getAreaSemicircle(double r) {
        return 0.5 * getAreaCircle(r);
    }

    double getAreaQuarterCircle(double r) {
        return 0.25 * getAreaCircle(r);
    }


    // cm² to mm²
    static double convertCm2ToMm2(double area) {
        return area * 100;
    }

    // cm² to m²
    static double convertCm2ToM2(double area) {
        return area / 10_000;
    }

    // cm² to km²
    static double convertCm2ToKm2(double area) {
        return area / 10_000_000_000.0;
    }

    // cm² to hectares
    static double convertCm2ToHectare(double area) {
        return area / 100_000_000.0;
    }

    // cm² to ares
    static double convertCm2ToAre(double area) {
        return area / 1_000_000.0;
    }

    // cm² to acre
    static double convertCm2ToAcre(double area) {
        return area / 40_468_564.224;
    }

    static void printArea(String shape, double area) {
        System.out.println("\nArea of " + shape + ": " + area + " cm²");
    }

    static void printMetricAreas(String shape, double areaCm2) {
        System.out.println();
        System.out.printf("""
                        Area Conversions of %s
                        ----------------------------
                        %.2f mm²
                        %.2f cm²
                        %.6f m²
                        %.10f km²
                        %.8f hectares
                        %.6f ares,
                        %.8f acres
                        """,
                shape,
                convertCm2ToMm2(areaCm2),
                areaCm2,
                convertCm2ToM2(areaCm2),
                convertCm2ToKm2(areaCm2),
                convertCm2ToHectare(areaCm2),
                convertCm2ToAre(areaCm2),
                convertCm2ToAcre(areaCm2)
        );
    }

    static void displayArea(String shape, double area) {
        printArea(shape, area);
        printMetricAreas(shape, area);
    }
}
