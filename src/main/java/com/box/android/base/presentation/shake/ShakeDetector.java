package com.box.android.base.presentation.shake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShakeDetector.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/shake/ShakeDetector;", "Landroid/hardware/SensorEventListener;", "onShake", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "lastShakeTime", "", "shakeThresholdGravity", "", "shakeCooldownMs", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShakeDetector implements SensorEventListener {
    public static final int $stable = 8;
    private long lastShakeTime;
    private final Function0<Unit> onShake;
    private final long shakeCooldownMs;
    private final float shakeThresholdGravity;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public ShakeDetector(Function0<Unit> onShake) {
        Intrinsics.checkNotNullParameter(onShake, "onShake");
        this.onShake = onShake;
        this.shakeThresholdGravity = 3.0f;
        this.shakeCooldownMs = 1500L;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.sensor.getType() != 1) {
            return;
        }
        float f = event.values[0] / 9.80665f;
        float f2 = event.values[1] / 9.80665f;
        float f3 = event.values[2] / 9.80665f;
        if (((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3))) > this.shakeThresholdGravity) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastShakeTime > this.shakeCooldownMs) {
                this.lastShakeTime = jCurrentTimeMillis;
                this.onShake.invoke();
            }
        }
    }
}
