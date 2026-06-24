class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Deque<int[]> lastMerged = new ArrayDeque<>();

        for(int[] interval: intervals){
            if(!lastMerged.isEmpty()){
                int[] lastInt = lastMerged.peekLast();
                if(lastInt[1] >= interval[0]){
                    lastMerged.pollLast();
                    lastMerged.addLast(new int[]{Math.min(interval[0], lastInt[0]), Math.max(interval[1], lastInt[1])});
                    continue;
                }
            }
            lastMerged.addLast(interval);
        }

        return lastMerged.toArray(new int[lastMerged.size()][]);

    }
}
