package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число точек на координатной плоскости: ");
        int n = scanner.nextInt();
        int[] quarterCounts = new int[5];
        Point[] closestPoints = new Point[5];

        for (int i = 0; i < n; i++) {
            System.out.print("x" + (i+1) + ": ");
            int x = scanner.nextInt();
            System.out.print("y" + (i+1) + ": ");
            int y = scanner.nextInt();

            if (x == 0 || y == 0) {
                continue; // пропускаем точки на осях
            }

            int quarter = getQuarter(x, y);
            quarterCounts[quarter]++;

            if (closestPoints[quarter] == null || Math.min(Math.abs(x), Math.abs(y)) < Math.min(Math.abs(closestPoints[quarter].x), Math.abs(closestPoints[quarter].y))) {
                closestPoints[quarter] = new Point(x, y);
            }
        }

        int maxQuarter = 0;
        int maxCount = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i <= 4; i++) {
            if (quarterCounts[i] > maxCount || (quarterCounts[i] == maxCount && Math.min(Math.abs(closestPoints[i].x), Math.abs(closestPoints[i].y)) < minDistance)) {
                maxQuarter = i;
                maxCount = quarterCounts[i];
                minDistance = Math.min(Math.abs(closestPoints[i].x), Math.abs(closestPoints[i].y));
            }
        }

        System.out.println("K = " + maxQuarter);
        System.out.println("M = " + maxCount);
        System.out.println("A = (" + closestPoints[maxQuarter].x + ", " + closestPoints[maxQuarter].y + ")");
        System.out.println("R = " + minDistance);
    }

    private static int getQuarter(int x, int y) {
        if (x > 0 && y > 0) return 1;
        if (x < 0 && y > 0) return 2;
        if (x < 0 && y < 0) return 3;
        if (x > 0 && y < 0) return 4;
        return 0;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
