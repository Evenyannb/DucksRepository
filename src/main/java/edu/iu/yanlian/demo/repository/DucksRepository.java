package edu.iu.yanlian.demo.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.iu.yanlian.demo.model.*;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DucksRepository {

    private final String dbPath = "DuckDatabase.txt";
    private final String imagePath = "ducks/images/";
    private final String audioPath = "ducks/audio/";
    private List<Duck> ducks;

    private final ObjectMapper mapper = new ObjectMapper();
    public DucksRepository() {
        ducks = new ArrayList<>();
    }

    public void addDuck(Duck duck) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dbPath, true))) {
            writer.write(ducktoSting(duck));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to the database file: " + e.getMessage());
        }
    }

    public Duck findById(int id) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            List<Duck> duck = reader.lines()
                    .map(this::stringToDuck)
                    .filter(d -> d != null && d.getId() == id)
                    .collect(Collectors.toList());

            if (!duck.isEmpty()){
                return duck.get(0);
            }
        } catch (IOException e) {
            System.err.println("Error reading the database file: " + e.getMessage());
        }
        return null;// Duck not found
    }

    public List<Duck> getAllDucks() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            List<Duck> duck = reader.lines()
                    .map(this::stringToDuck)
                    .collect(Collectors.toList());

            if (!duck.isEmpty()) {
                return duck; // return the first match
            }
        } catch (IOException e) {
            System.err.println("Error reading the database file: " + e.getMessage());
        }
        return null;
    }

    public List<Duck> search(String type) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            List<Duck> ducks = reader.lines()
                    .map(this::stringToDuck)
                    .filter(d -> d != null && d.getType().toString().equals(type.toUpperCase()))
                    .collect(Collectors.toList());

            return ducks;
        } catch (IOException e) {
            System.err.println("Error reading the database file: " + e.getMessage());
            throw e; // Re-throw to maintain method signature or handle appropriately
        }
    }

    public void uploadImage(int id, InputStream image) throws IOException {
        Path path = Paths.get(imagePath + id + ".png");
        Files.copy(image, path, StandardCopyOption.REPLACE_EXISTING);
    }

    public byte[] downloadImage(int id) throws IOException {
        Path path = Paths.get(imagePath + id + ".png");
        return Files.readAllBytes(path);
    }

    public void uploadAudio(int id, InputStream audio) throws IOException {
        Path path = Paths.get(audioPath + id + ".mp3");
        Files.copy(audio, path, StandardCopyOption.REPLACE_EXISTING);
    }

    public byte[] downloadAudio(int id) throws IOException {
        Path path = Paths.get(audioPath + id + ".mp3");
        return Files.readAllBytes(path);
    }

    public void clear() {
        try (FileWriter fileWriter = new FileWriter(dbPath, false)) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String ducktoSting (Duck duck){
        return  duck.getId() + ", " + duck.getType().toSting();

    }
    private Duck stringToDuck(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 2) {
            return null;
        }
        int id = Integer.parseInt(parts[0]);
        String type = parts[1].toUpperCase();
        switch (type) {
            case "MALLARD":
                return new MallardDuck(id);
            case "REDHEAD":
                return new RedheadDuck(id);
            case "RUBBER":
                return new RubberDuck(id);
            case "DECOY":
                return new DecoyDuck(id);
            default:
                return null;
        }
    }

}
