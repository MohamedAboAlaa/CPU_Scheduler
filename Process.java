public class Process {
    String name;
    int arrival;
    int brust;
    int remaining;
    int priority; 
    int waiting = 0;
    int turnaround = 0;

    Process(String name, int arrival, int brust, int priority){
        this.name = name;
        this.arrival = arrival;
        this.brust = brust;
        this.remaining = brust;
        this.priority = priority;
    }
}
