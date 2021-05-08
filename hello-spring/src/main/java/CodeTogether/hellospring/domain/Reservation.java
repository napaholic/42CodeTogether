package CodeTogether.hellospring.domain;

public class Reservation {

    private Long reservation_id;
    private String intra_id;
    private Long pool_id;
    private Boolean is_closed;

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getIntra_id() {
        return intra_id;
    }

    public void setIntra_id(String intra_id) {
        this.intra_id = intra_id;
    }

    public Long getPool_id() {
        return pool_id;
    }

    public void setPool_id(Long pool_id) {
        this.pool_id = pool_id;
    }

    public Boolean getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(Boolean is_closed) {
        this.is_closed = is_closed;
    }
}
