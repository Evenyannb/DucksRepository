package edu.iu.yanlian.demo.controllers;
import edu.iu.yanlian.demo.model.Duck;
import edu.iu.yanlian.demo.repository.duckService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/ducks")
public class DucksController {

    // Assuming you have a service for handling duck operations
    private final  duckService;

    public DucksController(DuckService duckService) {
        this.duckService = duckService;
    }

    @PostMapping
    public String addDuck(@RequestBody Duck duck) {
        // Implement logic to add duck to database
        return "Duck added";
    }

    @GetMapping
    public List<Duck> getAllDucks() {
        // Implement logic to return all ducks
        return duckService.findAll();
    }

    @GetMapping("/{id}")
    public Duck getDuckById(@PathVariable String id) {
        // Implement logic to return a duck by id
        return duckService.findById(id);
    }

    @PostMapping("/{id}/image")
    public String uploadDuckImage(@PathVariable String id, @RequestParam("image") MultipartFile image) {
        try {
            Path path = Paths.get("ducks/images/" + id + ".png");
            Files.write(path, image.getBytes());
            return "Image uploaded successfully";
        } catch (Exception e) {
            return "Failed to upload image";
        }
    }

    @GetMapping("/{id}/image")
    public byte[] getDuckImage(@PathVariable String id) throws IOException {
        Path path = Paths.get("ducks/images/" + id + ".png");
        return Files.readAllBytes(path);
    }

    @PostMapping("/{id}/audio")
    public String uploadDuckAudio(@PathVariable String id, @RequestParam("audio") MultipartFile audio) {
        try {
            Path path = Paths.get("ducks/audio/" + id + ".mp3");
            Files.write(path, audio.getBytes());
            return "Audio uploaded successfully";
        } catch (Exception e) {
            return "Failed to upload audio";
        }
    }

    @GetMapping("/{id}/audio")
    public byte[] getDuckAudio(@PathVariable String id) throws IOException {
        Path path = Paths.get("ducks/audio/" + id + ".mp3");
        return Files.readAllBytes(path);
    }

    @GetMapping("/search")
    public List<Duck> searchDucks(@RequestParam String type) {
        // Implement logic to search ducks by type
        return duckService.findByType(type);
    }
}