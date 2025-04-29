package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int t = scanner.nextInt();

        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        int[] mintA = new int[N + 1];
        int[] mintB = new int[N + 1];

        mintA[0] = 0;
        mintB[0] = t;

        for (int i = 1; i <= N; i++) {
            mintA[i] = Math.min(mintA[i - 1] + a[i - 1], mintB[i - 1] + b[i - 1] + t);
            mintB[i] = Math.min(mintB[i - 1] + b[i - 1], mintA[i - 1] + a[i - 1] + t);
        }

        System.out.println(Math.min(mintA[N], mintB[N]));
    }
}
