package railway.railway_objects;

public class TicketInfo {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String amountTicket;

    public TicketInfo(String departDate, String departFrom, String arriveAt, String seatType, String amountTicket) {
        this.departDate = departDate;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
        this.amountTicket = amountTicket;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getAmountTicket() {
        return amountTicket;
    }

    public void setAmountTicket(String amountTicket) {
        this.amountTicket = amountTicket;
    }
}
