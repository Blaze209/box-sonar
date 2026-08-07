package com.pspdfkit.annotations.measurements;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "Lcom/pspdfkit/annotations/measurements/ScaleAndPrecision;", "name", "", "scale", "Lcom/pspdfkit/annotations/measurements/Scale;", "precision", "Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;", "<init>", "(Ljava/lang/String;Lcom/pspdfkit/annotations/measurements/Scale;Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;)V", "getName", "()Ljava/lang/String;", "getScale", "()Lcom/pspdfkit/annotations/measurements/Scale;", "getPrecision", "()Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;", "getNameForDisplay", "includePrecision", "", "getDefaultName", "hashCode", "", "equalsAll", "other", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MeasurementValueConfiguration extends ScaleAndPrecision {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static MeasurementValueConfiguration defaultConfiguration;
    private final String name;
    private final MeasurementPrecision precision;
    private final Scale scale;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "scaleAndPrecision", "Lcom/pspdfkit/annotations/measurements/ScaleAndPrecision;", "defaultConfiguration", "setDefaultConfiguration", "", "newDefault", "createDefaultConfiguration", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MeasurementValueConfiguration createDefaultConfiguration() {
            return new MeasurementValueConfiguration(null, new Scale(1.0f, Scale.UnitFrom.IN, 1.0f, Scale.UnitTo.IN), MeasurementPrecision.TWO_DP);
        }

        @JvmStatic
        public final MeasurementValueConfiguration defaultConfiguration() {
            return MeasurementValueConfiguration.defaultConfiguration;
        }

        @JvmStatic
        public final MeasurementValueConfiguration from(ScaleAndPrecision scaleAndPrecision) {
            scaleAndPrecision.getClass();
            return new MeasurementValueConfiguration(null, scaleAndPrecision.getScale(), scaleAndPrecision.getPrecision());
        }

        @JvmStatic
        public final void setDefaultConfiguration(MeasurementValueConfiguration newDefault) {
            if (newDefault == null) {
                newDefault = createDefaultConfiguration();
            }
            MeasurementValueConfiguration.defaultConfiguration = newDefault;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        defaultConfiguration = companion.createDefaultConfiguration();
    }

    public MeasurementValueConfiguration(String str, Scale scale, MeasurementPrecision measurementPrecision) {
        scale.getClass();
        measurementPrecision.getClass();
        this.name = str;
        this.scale = scale;
        this.precision = measurementPrecision;
    }

    @JvmStatic
    public static final MeasurementValueConfiguration defaultConfiguration() {
        return INSTANCE.defaultConfiguration();
    }

    @JvmStatic
    public static final MeasurementValueConfiguration from(ScaleAndPrecision scaleAndPrecision) {
        return INSTANCE.from(scaleAndPrecision);
    }

    @JvmStatic
    public static final void setDefaultConfiguration(MeasurementValueConfiguration measurementValueConfiguration) {
        INSTANCE.setDefaultConfiguration(measurementValueConfiguration);
    }

    public final boolean equalsAll(Object other) {
        if (this == other) {
            return true;
        }
        if (super.equals(other) && (other instanceof MeasurementValueConfiguration)) {
            return Intrinsics.areEqual(((MeasurementValueConfiguration) other).name, this.name);
        }
        return false;
    }

    public final String getDefaultName(boolean includePrecision) {
        String displayString = getScale().getDisplayString();
        if (!includePrecision) {
            return displayString;
        }
        return displayString + " (Precision: " + MeasurementPrecision.toDisplayString(getPrecision(), getScale().unitTo) + ")";
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameForDisplay(boolean includePrecision) {
        String str = this.name;
        return (str == null || str.length() == 0) ? getDefaultName(includePrecision) : this.name;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public MeasurementPrecision getPrecision() {
        return this.precision;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public Scale getScale() {
        return this.scale;
    }

    @Override // com.pspdfkit.annotations.measurements.ScaleAndPrecision
    public int hashCode() {
        return getPrecision().hashCode() + ((getScale().hashCode() + 527) * 31);
    }
}
