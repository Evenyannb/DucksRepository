package edu.iu.yanlian.demo.repository;

import edu.iu.yanlian.demo.model.DecoyDuck;
import edu.iu.yanlian.demo.model.Duck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DucksRepository {

    private final String dbPath = "Duckdatabate.txt";
    private final String imagePath = "ducks/images/";
    private final String audioPath = "ducks/audio/";
    private List<Duck> ducks;

    public DucksRepository() {
        ducks = new ArrayList<>();
    }

    public void addDuck(int id,  Duck.DuckType type) {
        Duck duck= new DecoyDuck(id, type);
        // Code to add a duck to your database (could be a JSON, CSV, etc.)
    }

    public Optional<Duck> getDuck(int id) {

        // Code to get a single duck by ID from your database
        return Optional.empty();
    }

    public List<Duck> getAllDucks() {
        // Code to return all ducks from your database
        return new ArrayList<>();
    }

    public List<Duck> search(String type) {
        // Code to search ducks by type from your database
        return new ArrayList<>();
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


}
