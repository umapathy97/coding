import java.util.*;

class Job {
  int start;
  int end;
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {
// sorting approach
  public static int findMaxCPULoad(List<Job> jobs) {
    Collections.sort(jobs, (a, b) -> a.start - b.start);
    Job previousJob = jobs.get(0);
    int max = previousJob.cpuLoad;
    int count = max;
    for (int i = 1; i < jobs.size(); i++) {
      if ( previousJob.end > jobs.get(i).start) {
        count += jobs.get(i).cpuLoad;
      }
      else
      count = jobs.get(i).cpuLoad;
      if (previousJob.end < jobs.get(i).end)
                  previousJob = jobs.get(i);
      max = Math.max(count, max);
    }
    return max;
  }

  public static void main(String[] args) {
    List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
  }
}
