package com.comprehensive.practice.datastructure.graph.bfscycleDectet;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.comprehensive.practice.datastructure.graph.bfscycleDectet.BreathFirstSearch.Vertex;

public class BreathFirstSearch <T extends Comparable<T>>{

    @Data
    static class Vertex<T extends Comparable<T>>{
        private T name;
        private  boolean isVisited;
        private boolean beingVisited;
        private List<Vertex<T>> adjacencyList;
        Vertex(T name){
            this.name=name;
            adjacencyList= new ArrayList<>();
        }
        public void addNeighbour(Vertex<T> vertex){
            this.adjacencyList.add(vertex);
        }
        public List<Vertex<T>> getNeighbour(){
            return this.adjacencyList;
        }
        public String toString(){
            return "name: "+name + " isVisited: "+isVisited +" adjacencyList :"+adjacencyList;
        }
    }

    public void detectCycles(List<Vertex<T>> graph) {
        // there are multiple independent clusters
        for(Vertex<T> v : graph)
            if(!v.isVisited())
                dfs(v);
    }

    private void dfs(Vertex<T> vertex) {
        vertex.setBeingVisited(true);
        for(Vertex<T> v : vertex.getNeighbour()) {
            if(v.isBeingVisited()) {
                System.out.println("Backward edge ... there is a cycle!!!");
                return;
            }
            if(!v.isVisited()) {
                v.setVisited(true);
                dfs(v);
            }
        }
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}


@SuppressWarnings("ALL")
class Testing{

    public static void main(String[] args) {
        BreathFirstSearch<String> bfs = new BreathFirstSearch<>();
        Vertex<String> a = new Vertex<>("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        // we have to handle the connections
        f.addNeighbour(a);
        a.addNeighbour(e);
        a.addNeighbour(c);
        e.addNeighbour(f);
        c.addNeighbour(b);
        c.addNeighbour(d);

        List<Vertex<String>> graph = new ArrayList<>();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);

        bfs.detectCycles(graph);
    }

}
