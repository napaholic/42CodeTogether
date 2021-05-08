package CodeTogether.hellospring.controller;

public class SubjectForm {
    private Long subjectForm_id;
    private String subjectForm_name;
    private String subjectForm_pref;
    private String subjectForm_desc;
    private Long subjectForm_circle;

    public Long getSubjectForm_id() {
        return subjectForm_id;
    }

    public void setSubjectForm_id(Long subjectForm_id) {
        this.subjectForm_id = subjectForm_id;
    }

    public String getSubjectForm_name() {
        return subjectForm_name;
    }

    public void setSubjectForm_name(String subjectForm_name) {
        this.subjectForm_name = subjectForm_name;
    }

    public String getSubjectForm_pref() {
        return subjectForm_pref;
    }

    public void setSubjectForm_pref(String subjectForm_pref) {
        this.subjectForm_pref = subjectForm_pref;
    }

    public String getSubjectForm_desc() {
        return subjectForm_desc;
    }

    public void setSubjectForm_desc(String subjectForm_desc) {
        this.subjectForm_desc = subjectForm_desc;
    }

    public Long getSubjectForm_circle() {
        return subjectForm_circle;
    }

    public void setSubjectForm_circle(Long subjectForm_circle) {
        this.subjectForm_circle = subjectForm_circle;
    }
}