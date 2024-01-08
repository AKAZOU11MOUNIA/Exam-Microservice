
package com.example.Cours.Service;

        import com.example.Cours.Model.Cours;
        import com.example.Cours.Repository.CoursRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class CoursService {

    @Autowired
    private CoursRepository courseRepository;

    public List<Cours> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Cours> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Cours addCourse(Cours course) {
        return courseRepository.save(course);
    }

    public Cours updateCourse(Long id, Cours course) {
        Optional<Cours> existingCourseOptional = courseRepository.findById(id);
        if (existingCourseOptional.isPresent()) {
            Cours existingCourse = existingCourseOptional.get();
            existingCourse.setTitle(course.getTitle());
            existingCourse.setDescription(course.getDescription());
            // Mettez à jour d'autres champs si nécessaire
            return courseRepository.save(existingCourse);
        }
        return null; // Ou renvoyer une exception pour un traitement spécifique
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
