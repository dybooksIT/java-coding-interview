package coding.challenge;

public final class Clock {
    private Clock() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static float findAngle(int hour, int minute) {
        if (hour <= 0 || hour > 12) {
            throw new IllegalArgumentException("Hour must be between 1-12");
        }

        if (minute < 0 || minute > 60) {
            throw new IllegalArgumentException("Minute must be between 0-60");
        }

        float angle = (float) Math.abs(((30f * hour) + (0.5f * minute)) - (6f * minute));

        return angle > 180f ? (360f - angle) : angle;
    }
}