package javamod;

final class FishingAutomationState {
    boolean rodIsCast;          // true if we believe a bobber is in the water
    long lastCastTimestamp;     // time we last saw the bobber (or cast ourselves)
    long idleStartTime;         // time we first noticed no bobber
    boolean pausedByEvent;

    void reset() {
        rodIsCast = false;
        lastCastTimestamp = 0L;
        idleStartTime = 0L;
        pausedByEvent = false;
    }
}