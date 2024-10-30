package pl.pw.mini.po.dom.loty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateFlightsFile {
	

    public static void main(String[] args) {
        String[] destinations = {"Ulm (FMM)", "Paryż (CDG)", "Berlin (TXL)", "Londyn (LHR)", "Madryt (MAD)"};
        String[] airlines = {"Wizz Air", "Air France", "Lufthansa", "British Airways", "Iberia"};
        String[] statuses = {"started", "boarding", "canceled"};
        Random random = new Random();

        // Print current working directory
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + workingDir);

        // File name (the file will be created in the current working directory)
        String fileName = "loty.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < 50; i++) {
                if (random.nextBoolean()) {
                    // Generate departure (odlot)
                    String time = String.format("%02d:%02d", random.nextInt(24), random.nextInt(60));
                    String destination = destinations[random.nextInt(destinations.length)];
                    String flightId = String.format("%s %d", airlines[random.nextInt(airlines.length)].substring(0, 2), random.nextInt(2000) + 1000);
                    String airline = airlines[random.nextInt(airlines.length)];
                    String status = statuses[random.nextInt(statuses.length)];
                    String checkInRange = String.format("%d-%d", random.nextInt(50) + 100, random.nextInt(50) + 150);

                    writer.write(String.format("O###%s###%s###%s###%s###%s###%s###", time, destination, flightId, airline, status, checkInRange));
                } else {
                    // Generate arrival (przylot)
                    String time = String.format("%02d:%02d", random.nextInt(24), random.nextInt(60));
                    String origin = destinations[random.nextInt(destinations.length)];
                    String flightId = String.format("%s %d", airlines[random.nextInt(airlines.length)].substring(0, 2), random.nextInt(2000) + 1000);
                    String airline = airlines[random.nextInt(airlines.length)];
                    String landed = random.nextBoolean() ? "true" : "false";
                    int gate = random.nextInt(20) + 1;

                    writer.write(String.format("P###%s###%s###%s###%s###%s###%d###", time, origin, flightId, airline, landed, gate));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
        	

}

