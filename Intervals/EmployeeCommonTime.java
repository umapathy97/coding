/*

For ‘K’ employees, we are given a list of intervals representing the working hours of each employee. Our goal is to find out if there is a free interval that is common to all employees. You can assume
 that each list of employee working hours is sorted on the start time.

*/

List <Interval> public minEmployeeCommonTime(List<List<Interval>> schedule) {
  PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a, b) -> a.interval.start      - b.interval.start);
 List<Interval> result = new ArrayList<>();

// build heap
for (int i = 0; i < schedule.size(); i++) {
   minHeap.add(new EmployeeInterval(schedule.get(i), i, 0));
}

Interval previousInterval = minHeap.peek();
while (!minHeap.isEmpty()) {

  EmployeeInterval employeeTop = minHeap.poll();

 // non overlapping intervals. I.e . we found a gap
   if (previousInterval.end < employeeTop.interval.start) {
       result.add(new Interval((previousInterval.end , employeeTop.interval.start);
       previousInterval =  employeeTop.interval.start;
   }





  // overlapping intervals
 else {
      if (previousInterval.end < employeeTop.interval.start)
      previousInterval = employeeTop.interval;

 }

// add remaining intervals
if (schedule.get(employeeTop.employeeIndex).size()  > employeeTop.intervalIndex + 1)
   minHeap.add(
    new EmployeeInterval(
           schedule.get(employeeTop.employeeIndex).get(employeeTop.intervalIndex + 1), 
           employeeTop.employeeIndex),
           employeeTop.intervalIndex + 1
   ));
}
         return result;
} 
