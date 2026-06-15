class Solution {

    HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i< numCourses; i++){
            courseMap.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            courseMap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i< numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int current){
        if(visited.contains(current)){
            //cycle
            return false;
        }

        List<Integer> pre = courseMap.get(current);

        if(pre.isEmpty()){
            return true;
        }

        visited.add(current);

        for(int c: pre){
            if(!dfs(c)){
                return false;
            }
        }

        visited.remove(current);
        courseMap.put(current, new ArrayList<>());
        return true;
    }
}