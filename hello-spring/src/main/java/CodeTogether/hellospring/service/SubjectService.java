package CodeTogether.hellospring.service;

import CodeTogether.hellospring.domain.Subject;
import CodeTogether.hellospring.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Long join(Subject subject) {
        validateDuplicateSubject(subject);

        subjectRepository.save(subject);
        return subject.getSubject_id();
    }

    private void validateDuplicateSubject(Subject subject) {
        subjectRepository.findById(subject.getSubject_id())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 서브젝트입니다.");
                });
    }

    public List<Subject> findSubject() {
        return subjectRepository.findAll();
    }
    public Optional<Subject> findOne(Long subject_Id) {
        return subjectRepository.findById(subject_Id);
    }
}
