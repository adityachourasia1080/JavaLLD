package LLD.DesignSchedulingSystem;

import java.util.ArrayList;
import java.util.List;

public class ClusterManager {

    private static volatile ClusterManager instance;

    private ClusterManager() {
        clusters = new ArrayList<>();
    }
    List<Cluster> clusters;

    public static ClusterManager getInstance() {
        if (instance == null) {
            synchronized (ClusterManager.class) {
                if (instance == null) {
                    instance = new ClusterManager();
                }
            }
        }
        return instance;
    }

    public void addCluster(Cluster cluster) {
        if (cluster == null) return;
        clusters.add(cluster);

    }

    public Cluster getAvailableCluster(int cpu, int ram) {
        for (Cluster cluster: clusters) {
            if (cluster.allocateResource(cpu, ram)) {
                return cluster;
            }
            System.out.println("Cluster "+cluster.getId()+" is full");
        }
        return null;
    }

    public Cluster checkAvailableCluster(int cpu, int ram) {
        for (Cluster cluster: clusters) {
            if (cluster.isResourceAvailable(cpu, ram)) {
                return cluster;
            }
        }
        return null;
    }


}
