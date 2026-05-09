class TimeMap {

    class Pair{
        int timeStamp;
        String emo;

        public Pair(int timeStamp, String emo){
            this.timeStamp = timeStamp;
            this.emo = emo;
        }
    }

     Map<String, List<Pair>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
          .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {

        List<Pair> allEmos = timeMap.get(key);
        if (allEmos == null) return "";
        
        int left = 0;
        int right = allEmos.size() -1;
        String emo = "";
        while(left <= right){
            int mid = (left + right) / 2;
            Pair current = allEmos.get(mid);

            if (current.timeStamp <= timestamp){
                emo = current.emo;
                left = mid+1;
            } else if(current.timeStamp > timestamp){
                right = mid-1;
            }
        }

        return emo;
    }
}
