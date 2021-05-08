package CodeTogether.hellospring.controller;

import CodeTogether.hellospring.domain.Subject;
import CodeTogether.hellospring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subject/new")
    public String createForm() {
        return "subjects/createSubject";
    }

    @PostMapping("/subjects/new")
    public String create(SubjectForm form)
    {
        Subject subject = new Subject();
        subject.setSubject_name(form.getSubjectForm_name());
        subject.setSubject_id(form.getSubjectForm_id());
        subject.setSubject_circle(form.getSubjectForm_circle());
        subject.setSubject_desc(form.getSubjectForm_desc());
        subject.setSubject_pref(form.getSubjectForm_pref());

        subjectService.join(subject);

        return "redirect:/";
    }

    @GetMapping(value = "/subjects")
    public String list(Model model) {
        List<Subject> subjects = subjectService.findSubject();
        model.addAttribute("subjects", subjects);
        return "subjects/subjectList";
    }
}
