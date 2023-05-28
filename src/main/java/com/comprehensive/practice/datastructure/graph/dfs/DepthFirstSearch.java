package com.comprehensive.practice.datastructure.graph.dfs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static com.comprehensive.practice.datastructure.graph.dfs.DepthFirstSearch.Vertex;
public class DepthFirstSearch<T extends Comparable<T>>{

    private Stack<Vertex<T>> stack;

    @Data
    static class Vertex<T extends Comparable<T>>{
        private T name;
        private boolean isVisited;
        private List<Vertex<T>> adjanceyList;
        Vertex(T name){
            this.name=name;
            this.adjanceyList = new ArrayList<>();
        }
        public String toString(){
            return "   name: "+name +" isVisited : "+isVisited +" neighbours"+ adjanceyList;
        }
        public void addNeighbour(Vertex<T> vertex){
            this.adjanceyList.add(vertex);
        }
        public List<Vertex<T>> getNeighbour(){
            return this.adjanceyList;
        }

    }

    public DepthFirstSearch(){
        stack = new Stack<>();
    }

    public void dfs(List<Vertex<T>> graph){
        for (Vertex<T> vertex : graph){
            if(!vertex.isVisited()){
               vertex.setVisited(true);
                dfsHelper(vertex);
            }
        }
    }

    private void dfsHelper(Vertex<T> vertex) {
        stack.push(vertex);
        vertex.setVisited(true);
        while (!stack.isEmpty()){
            Vertex<T> current = stack.pop();
            System.out.println(current);
            List<Vertex<T>> list = current.getAdjanceyList();
            for(Vertex<T> v : list){
                v.setVisited(true);
                stack.push(v);
            }
        }
    }

}

class Testing{
    public static void main(String[] args) {
        DepthFirstSearch<String> stringDepthFirstSearch = new DepthFirstSearch<>();
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");
        Vertex<String> f = new Vertex<>("F");
        Vertex<String> g = new Vertex<>("G");
        Vertex<String> h = new Vertex<>("H");

        a.addNeighbour(b);
        a.addNeighbour(f);
        a.addNeighbour(g);
        b.addNeighbour(c);
        b.addNeighbour(d);
        d.addNeighbour(e);
        g.addNeighbour(h);

        List<Vertex<String>> list = new ArrayList<>();
        list.add(a);
        list.add(b);
       list.add(c);
        list.add(d);
       list.add(e);
        list.add(f);
       list.add(g);
       list.add(h);
        stringDepthFirstSearch.dfs(list);
    }
}
