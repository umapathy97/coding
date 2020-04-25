package com.freshworks.fieldservice.kafkaprocessor.processor;// A Java program to print topological sorting of a DAG
import java.io.*;
import java.util.*;


class Graph
{
    private int V;
    private List<List<Integer>> adj;
    //Constructor
    Graph(int v)
    {
        V = v;
        adj = new ArrayList<>();
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) {
        adj.get(v).add(w);
    }
    void TopologicalSort(){
        Set<Integer> set = new HashSet<>();
        Stack<Integer>stack = new Stack<>();
        for (int i=0;i<V;i++)
            TopologicalSortUtil(i, set,stack);
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    private void TopologicalSortUtil(int v, Set<Integer> set, Stack<Integer> stack) {
        if(set.contains(v))
            return;
        set.add(v);
        for(int vertex:adj.get(v)){
            if(!set.contains(vertex))
                TopologicalSortUtil(vertex,set,stack);
        }
        stack.push(v);
    }

    public static void main(String args[])
    {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.TopologicalSort();
        System.out.println(" ");
        System.out.println("Following is a Depth " +
                "Search of the given graph");
        g.dfs();
    }

    private void dfs() {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<V;i++)
         dfsUtil(set,i,result);
        for(int num:result)
            System.out.print(" " + num + " ");
    }

    private void dfsUtil(Set<Integer> set, int i, List<Integer> result) {
        if(set.contains(i))
            return;
        set.add(i);
        result.add(i);
        for(int vertex:adj.get(i))
            dfsUtil(set,vertex,result);
    }
}
