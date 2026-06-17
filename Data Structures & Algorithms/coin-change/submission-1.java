class Solution {
    public int coinChange(int[] coins, int amount) {
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> allLevels = new LinkedList<>();
        allLevels.add(amount);
        int totalCoins = 0;
        while(!allLevels.isEmpty()){
            int size = allLevels.size();
            for(int i = 0; i<size; i++){
                int curr = allLevels.poll();
                for(int coin: coins){
                    if (curr == 0){
                        return totalCoins;
                    }
                    int rem = curr - coin;
                    if(rem >= 0 && !visited.contains(rem)){
                        allLevels.add(rem);
                        visited.add(rem);
                    }
                }
            }

            totalCoins++;

        }
        return -1;
    }
}