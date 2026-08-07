package androidx.compose.animation.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0005R$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0005¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "<init>", "(F)V", "getFinalPosition", "()F", "setFinalPosition", "naturalFreq", "", "value", "stiffness", "getStiffness", "setStiffness", "dampingRatio", "getDampingRatio", "setDampingRatio", "getAcceleration", "lastDisplacement", "lastVelocity", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core", "(FFJ)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpringSimulation {
    public static final int $stable = 8;
    private float finalPosition;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f) {
        this.finalPosition = f;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final void setFinalPosition(float f) {
        this.finalPosition = f;
    }

    public final void setStiffness(float f) {
        if (getStiffness() <= 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f);
    }

    public final float getStiffness() {
        double d = this.naturalFreq;
        return (float) (d * d);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final void setDampingRatio(float f) {
        if (f < 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f;
    }

    public final float getAcceleration(float lastDisplacement, float lastVelocity) {
        float f = lastDisplacement - this.finalPosition;
        double d = this.naturalFreq;
        return (float) (((-(d * d)) * ((double) f)) - (((d * 2.0d) * ((double) this.dampingRatio)) * ((double) lastVelocity)));
    }

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core, reason: not valid java name */
    public final long m508updateValuesIJZedt4$animation_core(float lastDisplacement, float lastVelocity, long timeElapsed) {
        double dExp;
        double dExp2;
        float f = lastDisplacement - this.finalPosition;
        double d = timeElapsed / 1000.0d;
        float f2 = this.dampingRatio;
        double d2 = ((double) f2) * ((double) f2);
        double d3 = this.naturalFreq;
        double d4 = ((double) (-f2)) * d3;
        if (f2 > 1.0f) {
            double dSqrt = d3 * Math.sqrt(d2 - ((double) 1));
            double d5 = d4 + dSqrt;
            double d6 = d4 - dSqrt;
            double d7 = f;
            double d8 = ((d6 * d7) - ((double) lastVelocity)) / (d6 - d5);
            double d9 = d7 - d8;
            double d10 = d6 * d;
            double d11 = d * d5;
            dExp2 = (Math.exp(d10) * d9) + (Math.exp(d11) * d8);
            dExp = (d9 * d6 * Math.exp(d10)) + (d8 * d5 * Math.exp(d11));
        } else if (f2 == 1.0f) {
            double d12 = f;
            double d13 = ((double) lastVelocity) + (d3 * d12);
            double d14 = (-d3) * d;
            double d15 = d12 + (d * d13);
            dExp2 = d15 * Math.exp(d14);
            dExp = (d15 * Math.exp(d14) * (-this.naturalFreq)) + (d13 * Math.exp(d14));
        } else {
            double d16 = 1;
            double dSqrt2 = d3 * Math.sqrt(d16 - d2);
            double d17 = f;
            double d18 = (d16 / dSqrt2) * (((-d4) * d17) + ((double) lastVelocity));
            double d19 = dSqrt2 * d;
            double d20 = d * d4;
            double dExp3 = Math.exp(d20) * ((Math.cos(d19) * d17) + (Math.sin(d19) * d18));
            dExp = (d4 * dExp3) + (Math.exp(d20) * (((-dSqrt2) * d17 * Math.sin(d19)) + (dSqrt2 * d18 * Math.cos(d19))));
            dExp2 = dExp3;
        }
        return Motion.m498constructorimpl((((long) Float.floatToRawIntBits((float) dExp)) & 4294967295L) | (Float.floatToRawIntBits((float) (dExp2 + ((double) this.finalPosition))) << 32));
    }
}
