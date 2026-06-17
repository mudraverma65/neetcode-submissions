class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] countChar = new int[26];
        for (char c : tasks) {
            countChar[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int c: countChar){
            if(c>0){
                maxHeap.add(c);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time =0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            } else{
                int task = maxHeap.poll() - 1;
                if(task > 0){
                    q.add(new int[]{task, time + n});
                }    
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }

        }

        return time;


    }
}
