package homeWork7;

import java.util.Arrays;

public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Moscow");
        graph.addVertex("Orel");
        graph.addVertex("Tula");
        graph.addVertex("Voronezh");
        graph.addVertex("Kaluga");
        graph.addVertex("Kursk");
        graph.addVertex("Lipetsk");
        graph.addVertex("Saratov");
        graph.addVertex("Tambov");
        graph.addVertex("Ryazan");

        graph.addEdge("Moscow", "Tula", 183);
        graph.addEdge("Tula", "Lipetsk", 219);
        graph.addEdge("Lipetsk", "Voronezh", 108);
        graph.addEdge("Moscow", "Ryazan", 182);
        graph.addEdge("Ryazan", "Tambov", 240);
        graph.addEdge("Tambov", "Saratov", 339);
        graph.addEdge("Saratov", "Voronezh", 472);
        graph.addEdge("Moscow", "Kaluga", 160);
        graph.addEdge("Kaluga", "Orel", 172);
        graph.addEdge("Orel", "Kursk", 139);
        graph.addEdge("Kursk", "Voronezh", 207);

        System.out.println("Отображение связей между городами(вершинами):");
        graph.displayVertex();
        System.out.println("Отображение всех городов(вершин):");
        graph.dfs("Moscow");
        System.out.println("Отображение маршрутов между заданными городами:");
        graph.displayRoutes("Moscow", "Voronezh");
        System.out.println("Самый короткий путь:");
        graph.shortRoute();

    }
}
