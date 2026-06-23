class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruitBasket = new HashMap<>();
        int left = 0, right =0;
        int maxFruits = Integer.MIN_VALUE;

        while(right < fruits.length){
            fruitBasket.put(fruits[right], fruitBasket.getOrDefault(fruits[right], 0) + 1);
            while(fruitBasket.size() > 2){
                int currCount = fruitBasket.get(fruits[left]);
                if(currCount == 1){
                    fruitBasket.remove(fruits[left]);
                } else{
                    fruitBasket.put(fruits[left], currCount-1);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
            right ++;
        }

        return maxFruits;
    }
}