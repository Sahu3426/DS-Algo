class Platform {
	/* This is the Train class definition
	class Train {
		public int arrival, departure;
		public Train(int arrival, int departure) {
			this.arrival = arrival;
			this.departure = departure;
		}
	}
	*/

    int minPlatforms(Train[] trains) {
        int len = trains.length;
        int[] arrivalTimes = new int[len];
        int[] departureTimes = new int[len];

        for(int i=0; i<len; i++){
            arrivalTimes[i] = trains[i].arrival;
            departureTimes[i] = trains[i].departure;
        }
        int ans = 1, maxPlat = 1;
        Arrays.sort(arrivalTimes);
        Arrays.sort(departureTimes);
        int  j = 0, i = 1;
        while(i < len && j < len){
            if(arrivalTimes[i] <= departureTimes[j]){
                maxPlat++;
                ans = Math.max(ans, maxPlat);
                i++;

            } else {
                maxPlat-- ;
                j++;
            }


        }
        return ans;
    }
}