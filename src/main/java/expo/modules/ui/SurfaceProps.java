package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurfaceView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J%\u0010\u001d\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0003J[\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R-\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lexpo/modules/ui/SurfaceProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "color", "Landroid/graphics/Color;", "contentColor", "tonalElevation", "", "shadowElevation", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;FFLjava/util/List;)V", "getColor", "()Landroid/graphics/Color;", "getContentColor", "getTonalElevation", "()F", "getShadowElevation", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SurfaceProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final Color contentColor;
    private final List<Map<String, Object>> modifiers;
    private final float shadowElevation;
    private final float tonalElevation;

    public SurfaceProps() {
        this(null, null, 0.0f, 0.0f, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurfaceProps copy$default(SurfaceProps surfaceProps, Color color, Color color2, float f, float f2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            color = surfaceProps.color;
        }
        if ((i & 2) != 0) {
            color2 = surfaceProps.contentColor;
        }
        if ((i & 4) != 0) {
            f = surfaceProps.tonalElevation;
        }
        if ((i & 8) != 0) {
            f2 = surfaceProps.shadowElevation;
        }
        if ((i & 16) != 0) {
            list = surfaceProps.modifiers;
        }
        List list2 = list;
        float f3 = f;
        return surfaceProps.copy(color, color2, f3, f2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getTonalElevation() {
        return this.tonalElevation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public final List<Map<String, Object>> component5() {
        return this.modifiers;
    }

    public final SurfaceProps copy(Color color, Color contentColor, float tonalElevation, float shadowElevation, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new SurfaceProps(color, contentColor, tonalElevation, shadowElevation, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurfaceProps)) {
            return false;
        }
        SurfaceProps surfaceProps = (SurfaceProps) other;
        return Intrinsics.areEqual(this.color, surfaceProps.color) && Intrinsics.areEqual(this.contentColor, surfaceProps.contentColor) && Float.compare(this.tonalElevation, surfaceProps.tonalElevation) == 0 && Float.compare(this.shadowElevation, surfaceProps.shadowElevation) == 0 && Intrinsics.areEqual(this.modifiers, surfaceProps.modifiers);
    }

    public int hashCode() {
        Color color = this.color;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.contentColor;
        return ((((((iHashCode + (color2 != null ? color2.hashCode() : 0)) * 31) + Float.hashCode(this.tonalElevation)) * 31) + Float.hashCode(this.shadowElevation)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "SurfaceProps(color=" + this.color + ", contentColor=" + this.contentColor + ", tonalElevation=" + this.tonalElevation + ", shadowElevation=" + this.shadowElevation + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SurfaceProps(Color color, Color color2, float f, float f2, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.color = color;
        this.contentColor = color2;
        this.tonalElevation = f;
        this.shadowElevation = f2;
        this.modifiers = modifiers;
    }

    public final Color getColor() {
        return this.color;
    }

    public final Color getContentColor() {
        return this.contentColor;
    }

    public final float getTonalElevation() {
        return this.tonalElevation;
    }

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public /* synthetic */ SurfaceProps(Color color, Color color2, float f, float f2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? 0.0f : f2, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
