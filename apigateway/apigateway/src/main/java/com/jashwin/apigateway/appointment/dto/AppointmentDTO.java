package com.jashwin.apigateway.appointment.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private int slotid;
    private int doctorid;
    private LocalDateTime startiime;
    private LocalDateTime endtime;
    private String status;

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public LocalDateTime getStartiime() {
        return startiime;
    }

    public void setStartiime(LocalDateTime startiime) {
        this.startiime = startiime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
