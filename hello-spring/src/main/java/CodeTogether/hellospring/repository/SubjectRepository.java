package CodeTogether.hellospring.repository;

import CodeTogether.hellospring.domain.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    Subject save(Subject subject);

    Optional<Subject> findById(Long id);
    Optional<Subject> findBySubjectName(String subject_name);
    List<Subject> findByCircle(Long subject_circle);
    List<Subject> findAll();
}
