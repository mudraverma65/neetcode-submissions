/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> occ = new PriorityQueue<>();


        for (Interval curr : intervals){

            if(!occ.isEmpty() && occ.peek() <= curr.start){
                occ.poll();
            } 
            occ.offer(curr.end);

        }

        return occ.size();
    }
}
