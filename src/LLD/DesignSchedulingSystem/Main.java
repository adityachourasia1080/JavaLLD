package LLD.DesignSchedulingSystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ClusterManager clusterManager = ClusterManager.getInstance();

        clusterManager.addCluster(new Cluster("A", 8, 32)); // 8 CPU, 32 GB RAM
        clusterManager.addCluster(new Cluster("B", 16, 64)); // 16 CPU, 64 GB RAM

        Job job1 = new Job("1", 4, 16, 6, 1); // 4 CPU, 16 GB RAM, 6s, Priority 1
        Job job2 = new Job("2", 2, 8, 9, 2);  // 2 CPU, 8 GB RAM, 9s, Priority 2
        Job job3 = new Job("3", 6, 24, 12, 1); // 6 CPU, 24 GB RAM, 12s, Priority 1

        JobScheduler scheduler = new JobScheduler();
        scheduler.schedule(Arrays.asList(job1, job2, job3)); // jobs submitted in a batch
    }
}