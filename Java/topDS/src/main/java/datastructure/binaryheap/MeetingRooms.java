
package datastructure.binaryheap;

import java.util.*;

class MeetingRomms {
    
    private static class Meeting{
        int startTime;
        int endTime;
        
        Meeting(int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }   
    }
    
    private static class MeetingComparator implements Comparator<Meeting>{
        
        public int compare(Meeting a , Meeting b ){
            return a.startTime - b.startTime;
        }
    }
    
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals == null || intervals.length ==0) return 0;
        
        PriorityQueue<Integer> roomAllocator = new PriorityQueue<>();
        
        //Grab the meeting List
        List<Meeting> meetingList = new ArrayList<>();
        for(int i=0;i < intervals.length;i++){
            meetingList.add(new Meeting(intervals[i][0],intervals[i][1]));
        }
        
        //Sort the Meeting List
        Collections.sort(meetingList,new MeetingComparator());
        
        roomAllocator.add(meetingList.get(0).endTime);
        
        //Iterate over the remaining meetings 
        for(int i=1 ; i< meetingList.size();i++) {
        	
        	if(meetingList.get(i).startTime >= roomAllocator.peek()) {
        		roomAllocator.poll();
        	}
        	
        	roomAllocator.add(meetingList.get(i).endTime);
        	
        }
        
        return roomAllocator.size();
      
    }
}