package homeWork7;

import java.util.*;

class Graph {
    private final int VERTS = 10;
    List<Vertex> vertexList;
    final Integer[][] adjMat;
    List<List<Vertex>> routes = new ArrayList<>();

    public Graph() {
        this.vertexList = new ArrayList<>(VERTS);
        this.adjMat = new Integer[VERTS][VERTS];
    }


    public void dfs(String start) {
        cleanVisited();
        int startIndex = indexOf(start);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Wrong vertex start");
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex == null) {
                stack.pop();
            } else {
                visitVertex(stack, vertex);

            }
        }
    }

    private void buildRoute(String start, String end) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(end);
        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Wrong vertex start" + start);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertexForRoute(stack, vertex);
        while (!stack.isEmpty()) {

            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                if (vertex.getLabel().equals(end)) {
                    stack.add(vertex);
                    routes.add(new ArrayList(stack));
                }
            }
            if (vertex == null) {
                stack.pop();
                if (stack.size() == 1) vertexList.get(finishIndex).setWasVisited(false);

            } else {
                visitVertexForRoute(stack, vertex);

            }
        }
    }

    public void displayRoutes(String start, String end) {
        cleanVisited();
        buildRoute(start, end);
        for (int i = 0; i < routes.size(); i++) {
            System.out.println("маршрут " + (i + 1));
            for (int j = 0; j < routes.get(i).size(); j++) {
                if (j < routes.get(i).size() - 1) System.out.print(routes.get(i).get(j) + "->");
                else System.out.println(routes.get(i).get(j));
            }
        }
    }

    private void cleanVisited() {
        for (int i = 0; i < vertexList.size(); i++) {
            vertexList.get(i).setWasVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < vertexList.size(); i++) {
            if (adjMat[currentIndex][i] != null && !vertexList.get(i).isWasVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex + " ");
        stack.push(vertex);
        vertex.setWasVisited(true);
    }

    private void visitVertexForRoute(Stack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        vertex.setWasVisited(true);
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    public boolean addEdge(String start, String end, Integer distance) {
        int startIndex = indexOf(start);
        int endIndex = indexOf(end);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMat[startIndex][endIndex] = distance;

        return true;
    }


    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label))
                return i;
        }
        return -1;
    }

    public void displayVertex() {
        System.out.println(this);
    }

    public void shortRoute() {
        Map<Integer, Integer> map = new HashMap<>();
        int dist;
        for (int i = 0; i < routes.size(); i++) {
            dist = 0;
            for (int j = 0; j < routes.get(i).size() - 1; j++) {
               dist+=adjMat[indexOf(routes.get(i).get(j).getLabel())][indexOf(routes.get(i).get(j+1).getLabel()) ];
                if (j == routes.get(i).size() - 2) map.put(i+1, dist);
            }
        }

        System.out.println("Самый короткий маршрут по заданным точкам будет "+ routes.get(shortDistIndex(map)-1)+","+
         "дальность пути составит "+map.get(shortDistIndex(map))+" км");
    }

    private int shortDistIndex(Map<Integer,Integer> map){
        int dist = Integer.MAX_VALUE;
        int indexRoute = 0;
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() < dist) {
                dist = i.getValue();
                indexRoute = i.getKey();
            }
        }
         return indexRoute;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count;
        for (int i = 0; i < vertexList.size(); i++) {
            sb.append(vertexList.get(i));
            count = 0;
            for (int j = 0; j < vertexList.size(); j++) {
                if (adjMat[i][j] != null) {
                    sb.append(" -> ").append(vertexList.get(j)).append("\n");
                    count++;
                }
                if (count == 0 && j == vertexList.size() - 1) sb.append("\n");
            }
        }
        return sb.toString();
    }

//    void printMatrix() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println();
//            for (int j = 0; j < 10; j++) {
//                System.out.print(adjMat[i][j] + " ");
//            }
//        }
//   }

}



