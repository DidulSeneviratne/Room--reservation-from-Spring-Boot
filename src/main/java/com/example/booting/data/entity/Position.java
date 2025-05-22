package com.example.booting.data.entity;

public enum Position {
    HOUSEKEEPING, FRONT_DESK, SECURITY, CONCIERGE;

    public String toString() {
        switch (this) {
            case HOUSEKEEPING:
                return "HOUSEKEEPING";
            case FRONT_DESK:
                return "FRONT_DESK";
            case SECURITY:
                return "SECURITY";
            case CONCIERGE:
                return "CONCIERGE";
        }
        return "";
    }
}
