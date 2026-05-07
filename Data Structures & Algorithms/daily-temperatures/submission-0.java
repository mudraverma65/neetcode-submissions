class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Deque<int[]> tempIndex = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++){
            while(!tempIndex.isEmpty() && tempIndex.peek()[0] < temperatures[i]){
                int[] tp = tempIndex.pop();
                result[tp[1]] = i - tp[1];
            }
            tempIndex.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
