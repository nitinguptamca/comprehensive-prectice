package com.comprehensive.practice.datastructure.graph.shortestPath.DAG;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * How to find Shortest Paths from Source to all Vertices using Dijkstra’s Algorithm
 */
public class DAGShortestPath<T extends Comparable<T>> {

    @Data
    static class Vertex<T extends Comparable<T>> {
        private T name;
        private boolean isVisited;
        private Vertex<T> predecessor;
        private List<Edge<T>> adjacencyList;
        private int distance;

        Vertex(T name) {
            this.name = name;
            this.adjacencyList = new ArrayList<>();
            this.distance = Integer.MAX_VALUE;
        }

        public void addNeighbour(Edge edge) {
            this.adjacencyList.add(edge);
        }

        public List<Edge<T>> getNeighbour() {
            return this.adjacencyList;
        }

        public String toString() {
            return " name :" + name + " predecessor :" + predecessor;
        }
    }

    @Data
    @AllArgsConstructor
    static class Edge<T extends Comparable<T>> {
        private Vertex<T> target;
        private int weight;
    }

    private Stack<Vertex<T>> stack;

    public Stack<Vertex<T>> getStack() {
        return stack;
    }
    DAGShortestPath(){
        stack = new Stack<>();
    }

    public void  topologicalOrdering(List<Vertex<T>> graph){
        for (Vertex<T> tVertex : graph) {
            if (!tVertex.isVisited()) {
                dfs(tVertex);
            }
        }
    }

    private void dfs(Vertex<T> vertex){
        vertex.setVisited(true);
        for(Edge<T> e : vertex.getNeighbour()){
            if( !e.getTarget().isVisited()){
                dfs(e.getTarget());
            }
        }
        stack.add( vertex);
    }

    public void shortestPath(List<Vertex<T>> graph) {
        topologicalOrdering(graph);
        graph.get(0).setDistance(0);
    }

    public void compute() {
        Stack<Vertex<T>> topologicalOrder = getStack();
        while(!topologicalOrder.isEmpty()) {
            Vertex<T> u = topologicalOrder.pop();
            for(Edge<T> e : u.getNeighbour()) {
                Vertex v = e.getTarget();
                if(v.getDistance() > u.getDistance() + e.getWeight()) {
                    v.setDistance(u.getDistance()+e.getWeight());
                    v.setPredecessor(u);
                }
            }
        }
    }
}

class App {
    public static void main(String[] args) {
        DAGShortestPath<String> stringDAGShortestPath = new DAGShortestPath<>();
        List<DAGShortestPath.Vertex<String>> graph = new ArrayList<>();
        DAGShortestPath.Vertex<String> s = new DAGShortestPath.Vertex<>("S");
        DAGShortestPath.Vertex<String>  a = new DAGShortestPath.Vertex<>("A");
        DAGShortestPath.Vertex<String>  b = new DAGShortestPath.Vertex<>("B");
        DAGShortestPath.Vertex<String>  c = new DAGShortestPath.Vertex<>("C");
        DAGShortestPath.Vertex<String>  d = new DAGShortestPath.Vertex<>("D");
        DAGShortestPath.Vertex<String>  e = new DAGShortestPath.Vertex<>("E");
        s.addNeighbour(new DAGShortestPath.Edge<>(a, 1));
        s.addNeighbour(new DAGShortestPath.Edge<>(c, 2));
        a.addNeighbour(new DAGShortestPath.Edge<>(b, 6));
        b.addNeighbour(new DAGShortestPath.Edge<>(d, 1));
        b.addNeighbour(new DAGShortestPath.Edge<>(e, 2));
        c.addNeighbour(new DAGShortestPath.Edge<>(a, 4));
        c.addNeighbour(new DAGShortestPath.Edge<>(d, 3));
        d.addNeighbour(new DAGShortestPath.Edge<>(e, 1));

        graph.add(s);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        stringDAGShortestPath.shortestPath(graph);
        stringDAGShortestPath.compute();
        for(DAGShortestPath.Vertex<String> v : graph)
            System.out.println("Distance from s: " + v.getDistance()
                    + " - " + v.getPredecessor());
    }

}
