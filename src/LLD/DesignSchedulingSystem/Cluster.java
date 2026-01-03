package LLD.DesignSchedulingSystem;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cluster {

    private String id;
    private int totalCpu;
    private int totalRam;
    private int availableCpu;
    private int availableRam;
    private Lock lock;

    public Cluster(String clusterId, int totalCpu, int totalRam) {
        this.id = clusterId;
        this.totalCpu = totalCpu;
        this.totalRam = totalRam;
        this.availableCpu = totalCpu;
        this.availableRam = totalRam;
        this.lock = new ReentrantLock();
    }

    public String getId() {
        return id;
    }

    public int getTotalCpu() {
        return totalCpu;
    }

    public int getTotalRam() {
        return totalRam;
    }

    public int getAvailableCpu() {
        return availableCpu;
    }

    public int getAvailableRam() {
        return availableRam;
    }

    boolean isResourceAvailable(int cpu, int ram) {
        return availableCpu >= cpu && availableRam >= ram;
    }


    boolean allocateResource(int cpu, int ram) {
        lock.lock();
        try {
            if (isResourceAvailable(cpu, ram)) {
                availableCpu -= cpu;
                availableRam -= ram;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }


    boolean deallocateResources(int cpu, int ram) {
        lock.lock();
        try {
            availableCpu += cpu;
            availableRam += ram;
            return true;
        } finally {
            lock.unlock();
        }
    }



}
