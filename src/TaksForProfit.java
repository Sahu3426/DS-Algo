class TaskForProfit {
	/* This is the Task class definition
	class Task {
		public int deadline, profit;
		public Task(int deadline, int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	*/

    int getMaxProfit(Task[] tasks) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }

        int maxDeadline = 1;
        for(int i=0; i<tasks.length; i++){
            maxDeadline = Math.max(maxDeadline, tasks[i].deadline);
        }

        boolean [] deadlines = new boolean[maxDeadline+1];
        deadlines[0] = true;

        Arrays.sort(tasks, new Comparator<Task>(){
            public int compare(Task task1, Task task2){
                return task2.profit- task1.profit;
            }
        });

        // for(int i=0; i<tasks.length; i++){
        // 	System.out.println(tasks[i].deadline + " " + tasks[i].profit);
        // }
        int answer = 0;
        for(int i=0; i<tasks.length; i++){
            int deadline = tasks[i].deadline;
            while(deadline > 0){
                if(deadlines[deadline] == false){
                    answer = answer + tasks[i].profit;
                    deadlines[deadline] = true;
                    break;
                }
                deadline--;
            }
        }
        return answer;
    }
}