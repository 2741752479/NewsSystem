import java.util.Date;

public class Small {
    private String id;
    private boolean buy;
    private Date time;

    public Small() {
    }

    public Small(String id, boolean buy, Date time) {
        this.id = id;
        this.buy = buy;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
