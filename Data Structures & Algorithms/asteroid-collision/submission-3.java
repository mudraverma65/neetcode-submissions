class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid: asteroids){
            boolean destroy = false;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && !destroy){
                if(Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                    destroy = true;
                } else if(Math.abs(stack.peek()) > Math.abs(asteroid)){
                    destroy = true;
                } else{
                    stack.pop();
                }
            }
            if(!destroy){
                stack.push(asteroid);
            }
        }

        int size = stack.size();
        int[] arr = new int[size];

        for(int i = size-1; i >= 0; i--){
            arr[i] = stack.pop();
        }
        return arr;
    }
}