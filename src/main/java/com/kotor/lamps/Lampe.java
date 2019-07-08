package com.kotor.lamps;

public class Lampe {
    private boolean isActive;

    public Lampe(boolean isActive) {
        this.isActive = isActive;
    }

    public Lampe() {}


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean OnOrOffLampe() {
        this.isActive = !this.isActive;
        return this.isActive;
    }
}
