package DSA.PriorityQueue.TaskScheduler;

//solution approach;
//link :https://leetcode.com/problems/task-scheduler/solutions/3280549/full-explanation-using-priority-queue-an-86fw/
// Using priority queue
// First count the number of occurrences of each task and store that in a map/vector.
// Then push the count into a priority queue, so that the maximum frequency task can be accessed and completed first.
// Then until all tasks are completed (i.e the priority queue is not empty):
// intialise the cycle length as n+1. n is the cooldown period so the cycle will be of n+1 length.
// Example: for ['A','A','A','B','B'] and n=2,
// the tasks can occur in the following manner:
// [A B idle]->[A B idle]->[A]. See here each cycle is n+1 length long, only then A can repeat itself.
// for all elements in the priority queue, until the cycle length is exhausted, pop the elements out of the queue and if the task is occurring more than once then add it to the remaining array (which stores the remaining tasks).
// This means that we are completing that task once in this cycle.So keep counting the time.
// Then, add the occurrence of tasks back to the priority queue.
// Add the idle time into the time count.
// Idle time is the time that was needed in the cycle because no task was available. It is the remaining cycle length in our algorithm. Idle time should be only added if the priority queue is empty (i.e all tasks are completed).


import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for (int i=0;i<tasks.length;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }

        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b)->Integer.compare(b,a));

        for (Map.Entry<Character,Integer> e: mp.entrySet()){
            pq.offer(e.getValue());
        }

        int time=0;
        while(!pq.isEmpty()){
            List<Integer> vec= new ArrayList<>();
            int cycle= n+1;
            while(cycle>0 && !pq.isEmpty()){
                int temp= pq.poll();
                temp--;
                if(temp>0) vec.add(temp);
                cycle--;
                time++;
            }

            for (Integer c: vec){
                pq.add(c);
            }
            if (pq.isEmpty())  break;
            time+=cycle;
        }

        return time;

    }
}