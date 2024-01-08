
package com.example.Cours.Controller;

        import com.example.Cours.Model.Cours;
        import com.example.Cours.Service.CoursService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping("/Cours")
public class CoursController {

    @Autowired
    private CoursService courservice;

    @GetMapping
    public ResponseEntity<List<Cours>>getAllCours() {
        List<Cours> Cours = courservice.getAllCourses();
        return ResponseEntity.ok(Cours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursyId(@PathVariable Long id) {
        Optional<Cours >Cours= courservice.getCourseById(id);
        return Coursmap(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Cours> addCours(@RequestBody Cours Cours) {
        Cours newCours= courservice.addCourse(Course);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCours;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cours updateCours(@PathVariable Long id, @RequestBody Cours Cours) {
        Cours updatedCours= CoursService.updateCours(id, Cours);
        if (updatedCours!= null) {
            return ResponseEntity.ok(updatedCours);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCours@PathVariable Long id) {
        Courservice.deleteCoursid);
        return ResponseEntity.noContent().build();
    }
}

