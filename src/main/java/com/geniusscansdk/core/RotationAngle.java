package com.geniusscansdk.core;

/* JADX INFO: loaded from: classes13.dex */
public enum RotationAngle {
    ROTATION_0(0),
    ROTATION_90_CW(90),
    ROTATION_180(180),
    ROTATION_90_CCW(270);

    private final int clockwiseDegrees;

    RotationAngle(int i) {
        this.clockwiseDegrees = i;
    }

    public int getClockwiseDegrees() {
        return this.clockwiseDegrees;
    }

    public RotationAngle add(RotationAngle rotationAngle) {
        return fromDegrees(this.clockwiseDegrees + rotationAngle.clockwiseDegrees);
    }

    public static RotationAngle fromDegrees(int i) {
        int i2 = ((i % 360) + 360) % 360;
        for (RotationAngle rotationAngle : values()) {
            if (rotationAngle.clockwiseDegrees == i2) {
                return rotationAngle;
            }
        }
        throw new IllegalArgumentException("Invalid angle: " + i);
    }
}
