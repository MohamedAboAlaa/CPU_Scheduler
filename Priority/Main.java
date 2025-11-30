import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		LinkedList<Process> processes = new LinkedList<>();
		
		try {
            Scanner scF = new Scanner(new File("input.txt"));
            while (scF.hasNextLine()) {
                String line = scF.nextLine().trim();
                if(line.isEmpty()) continue;

                String[] parts = line.split(",");
                String name = parts[0].trim();
                int arrival = Integer.parseInt(parts[1].trim());
                int burst = Integer.parseInt(parts[2].trim());
                int priority = Integer.parseInt(parts[3].trim());

                processes.add(new Process(name, arrival, burst, priority));
            }
            scF.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
		
		System.out.println("\nPreemptive(y) or Non-Preemptive(n) ?");
		String str = sc.next();
		boolean isPreemptive = str.equals("y");
		System.out.println("\n\n");

		PriorityScheduler scheduler = new PriorityScheduler(processes, isPreemptive);
		scheduler.run();
	}
}
