
class MaxMeetingInARoom {
	/* This is the Meeting class definition
	class Meeting {
		public int start;
		public int end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	*/

    int getMaxMeetings(Meeting[] meetings) {
        if(meetings == null || meetings.length == 0){
            return 0;
        }
        Arrays.sort(meetings, new Comparator<Meeting>(){
            public int compare(Meeting m1, Meeting m2){
                return m1.end - m2.end;
            }
        });

        int endTime = meetings[0].end;
        int ans = 1;
        for(int i = 1; i<meetings.length; i++){
            if(meetings[i].start >= endTime){
                ans++;
                endTime = meetings[i].end;
            }
        }
        return ans;
    }
}