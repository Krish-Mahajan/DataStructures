package datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Course      {
    
    private static class Graph{
        int v;
        Map<Integer,List<Integer>> adjList;
        
        Graph(int v){
            this.v = v;
            adjList = new HashMap<>();
            for(int i=0;i<v;i++){
                adjList.put(i,new ArrayList<>());
            }
        }
        
        public void addEdge(int i1,int i2){
            this.adjList.get(i1).add(i2);
        }
        
        
        
        public boolean isGraphCyclic(){
            
            Map<Integer,Boolean> visited = new HashMap<>();
            Map<Integer,Boolean> recStack = new HashMap<>();
            
            for(int i=0;i<this.v;i++) {
                visited.put(i,false);
                recStack.put(i,false);
            }
            
            for(int i=0;i<this.v;i++){
                if(!visited.get(i)){
                    if(isGraphCyclicUtil(i,visited,recStack)) return true;
                }
            }
            
            return false;
        }
        
        private boolean isGraphCyclicUtil(int index ,   Map<Integer,Boolean> visited, Map<Integer,Boolean> recStack) {
                
                visited.put(index,true);
                recStack.put(index,true);
            
                for(Integer neighbourIndex : this.adjList.get(index)){
                    if(!visited.get(neighbourIndex)){
                        if(isGraphCyclicUtil(neighbourIndex,visited,recStack)) return true;
                    }
                    else if(recStack.get(neighbourIndex)) return true;
                }
            
                recStack.put(index,false);
                return false;
        }
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        
        //Ready the graph 
        Graph g = new Graph(numCourses);
        for(int r=0 ; r<prerequisites.length;r++){
                g.addEdge(prerequisites[r][0],prerequisites[r][1]);
            }
        
        if(g.isGraphCyclic()) return false;
        else return true;
        }
    
    
    public static void main(String[] args) {
    	
    	int numCourses = 2;
    	int[][] prerequisites = {{1,0},{0,1}};
    	Course c = new Course();
    	System.out.print(c.canFinish(numCourses, prerequisites));
    }
        
    }
