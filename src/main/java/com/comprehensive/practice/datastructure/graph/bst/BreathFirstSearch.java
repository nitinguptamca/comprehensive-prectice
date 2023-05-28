package com.comprehensive.practice.datastructure.graph.bst;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.comprehensive.practice.datastructure.graph.bst.BreathFirstSearch.Vertex;


public class BreathFirstSearch<T extends Comparable<T>> {


    public void traversal(Vertex<T> root) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);
        while (!queue.isEmpty()){
           Vertex<T> current =queue.remove();
            System.out.println("Actual visited vertex   " + current);
            List<Vertex<T>> list = current.getAdjacencyList();
            for (Vertex<T> v : list){
                queue.add(v);
                v.setVisited(true);
            }
        }
    }

    @Data
    static class Vertex<T extends Comparable<T>>{
        private T name;
        private  boolean isVisited;
        private List<Vertex<T>> adjacencyList;
        Vertex(T name){
            this.name=name;
            adjacencyList= new ArrayList<>();
        }
        public void addNeighbour(Vertex<T> vertex){
            this.adjacencyList.add(vertex);
        }
        public String toString(){
            return "name: "+name + " isVisited: "+isVisited +" adjacencyList :"+adjacencyList;
        }
    }
}

 class BFSTesting {
    public static void main(String[] args) {
        BreathFirstSearch<String> bsf = new BreathFirstSearch<>();
        Vertex<String> a = new Vertex<>("A");
        Vertex<String>  b = new Vertex<>("B");
        Vertex<String>  c = new Vertex<>("C");
        Vertex<String>  d = new Vertex<>("D");
        Vertex<String>  e = new Vertex<>("E");
        Vertex<String>  f = new Vertex<>("F");
        Vertex<String>  g = new Vertex<>("G");
        Vertex<String>  h = new Vertex<>("H");
        a.addNeighbour(b);
        a.addNeighbour(f);
        a.addNeighbour(g);
        b.addNeighbour(c);
        b.addNeighbour(d);
        d.addNeighbour(e);
        g.addNeighbour(h);

        bsf.traversal(a);

    }
}