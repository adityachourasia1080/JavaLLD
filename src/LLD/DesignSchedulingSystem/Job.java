package LLD.DesignSchedulingSystem;

public class Job implements Comparable<Job>{
    private String id;
    private int requiredCpu;
    private int requiredRam;
    private int executionTimeInSeconds;
    private int priority; // higher value means higher priority

    public Job(String id, int requiredCpu, int requiredRam, int executionTimeInSeconds, int priority) {
        this.id = id;
        this.requiredCpu = requiredCpu;
        this.requiredRam = requiredRam;
        this.executionTimeInSeconds = executionTimeInSeconds;
        this.priority = priority;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRequiredCpu() {
        return requiredCpu;
    }

    public void setRequiredCpu(int requiredCpu) {
        this.requiredCpu = requiredCpu;
    }

    public int getRequiredRam() {
        return requiredRam;
    }

    public void setRequiredRam(int requiredRam) {
        this.requiredRam = requiredRam;
    }

    public int getExecutionTimeInSeconds() {
        return executionTimeInSeconds;
    }

    public void setExecutionTimeInSeconds(int executionTimeInSeconds) {
        this.executionTimeInSeconds = executionTimeInSeconds;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Job job) {
        return Integer.compare(job.priority, this.priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id != null ? id.equals(job.id) : job.id != null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", requiredCpu=" + requiredCpu +
                ", requiredRam=" + requiredRam +
                ", executionTimeInSeconds=" + executionTimeInSeconds +
                ", priority=" + priority +
                '}';
    }
}