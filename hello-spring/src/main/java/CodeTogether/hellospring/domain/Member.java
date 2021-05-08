package CodeTogether.hellospring.domain;

public class Member {

    private Long member_id;
    private String intra_id;
    private String subject_name;

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getIntra_id() {
        return intra_id;
    }

    public void setIntra_id(String intra_id) {
        this.intra_id = intra_id;
    }
}
