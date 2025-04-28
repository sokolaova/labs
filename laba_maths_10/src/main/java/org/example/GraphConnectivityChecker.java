package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GraphConnectivityChecker {

    public static void main(String[] args) {
        String filePath = "graph.txt";
        int[][] adjacencyMatrix = readAdjacencyMatrixFromFile(filePath);

        if (adjacencyMatrix == null) {
            System.out.println("Не удалось прочитать файл.");
            return;
        }

        boolean isConnected = isGraphConnected(adjacencyMatrix);
        System.out.println("Граф " + (isConnected ? "связный." : "не связный."));
    }

    private static int[][] readAdjacencyMatrixFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int numVertices = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[numVertices][numVertices];
            int row = 0;

            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                for (int col = 0; col < values.length; col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isGraphConnected(int[][] adjacencyMatrix) {
        int numVertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        // Начинаем DFS с первой вершины
        stack.push(0);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                for (int i = 0; i < numVertices; i++) {
                    if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        // Проверяем, посещены ли все вершины
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
