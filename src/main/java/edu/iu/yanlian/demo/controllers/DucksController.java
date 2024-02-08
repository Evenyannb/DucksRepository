package edu.iu.yanlian.demo.controllers;
import edu.iu.yanlian.demo.model.Duck;
import edu.iu.yanlian.demo.repository.DucksRepository;
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

    private final DucksRepository duckService;

    public DucksController(DucksRepository duckService) {
        this.duckService = duckService;
    }

    @PostMapping
    public void addDuck(@RequestBody Duck duck) {
        addDuck(duck);

    }

    @GetMapping
    public List<Duck> getAllDucks() throws IOException {

        return duckService.getAllDucks();
    }

    @GetMapping("/{id}")
    public Duck getDuckById(@PathVariable int id) throws IOException {

        return duckService.findById(id);
    }

    @PostMapping("/{id}/image")
    public String uploadDuckImage(@PathVariable int id, @RequestParam("image") MultipartFile image) {
        try {
            Path path = Paths.get("ducks/images/" + id + ".png");
            Files.write(path, image.getBytes());
            return "Image uploaded successfully";
        } catch (Exception e) {
            return "Failed to upload image";
        }
    }

    @GetMapping("/{id}/image")
    public byte[] getDuckImage(@PathVariable int id) throws IOException {
        Path path = Paths.get("ducks/images/" + id + ".png");
        return Files.readAllBytes(path);
    }

    @PostMapping("/{id}/audio")
    public String uploadDuckAudio(@PathVariable int id, @RequestParam("audio") MultipartFile audio) {
        try {
            Path path = Paths.get("ducks/audio/" + id + ".mp3");
            Files.write(path, audio.getBytes());
            return "Audio uploaded successfully";
        } catch (Exception e) {
            return "Failed to upload audio";
        }
    }

    @GetMapping("/{id}/audio")
    public byte[] getDuckAudio(@PathVariable int id) throws IOException {
        Path path = Paths.get("ducks/audio/" + id + ".mp3");
        return Files.readAllBytes(path);
    }

    @GetMapping("/search")
    public List<Duck> searchDucks(@RequestParam String type) throws IOException {
        return duckService.search(type);
    }
}