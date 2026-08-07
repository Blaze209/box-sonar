package expo.modules.ui.icon;

import android.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003\u0012*\b\u0002\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u00100\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003HÆ\u0003J+\u0010\u001d\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u00100\u0003HÆ\u0003J}\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00032*\b\u0002\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u00100\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R3\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u00100\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006$"}, d2 = {"Lexpo/modules/ui/icon/IconProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "source", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/ui/icon/Source;", "tintColor", "Landroid/graphics/Color;", "size", "", "contentDescription", "", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getSource", "()Landroidx/compose/runtime/MutableState;", "getTintColor", "getSize", "getContentDescription", "getModifiers", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class IconProps implements ComposeProps {
    public static final int $stable = 0;
    private final MutableState<String> contentDescription;
    private final MutableState<List<Map<String, Object>>> modifiers;
    private final MutableState<Integer> size;
    private final MutableState<Source> source;
    private final MutableState<Color> tintColor;

    public IconProps() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IconProps copy$default(IconProps iconProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = iconProps.source;
        }
        if ((i & 2) != 0) {
            mutableState2 = iconProps.tintColor;
        }
        if ((i & 4) != 0) {
            mutableState3 = iconProps.size;
        }
        if ((i & 8) != 0) {
            mutableState4 = iconProps.contentDescription;
        }
        if ((i & 16) != 0) {
            mutableState5 = iconProps.modifiers;
        }
        MutableState mutableState6 = mutableState5;
        MutableState mutableState7 = mutableState3;
        return iconProps.copy(mutableState, mutableState2, mutableState7, mutableState4, mutableState6);
    }

    public final MutableState<Source> component1() {
        return this.source;
    }

    public final MutableState<Color> component2() {
        return this.tintColor;
    }

    public final MutableState<Integer> component3() {
        return this.size;
    }

    public final MutableState<String> component4() {
        return this.contentDescription;
    }

    public final MutableState<List<Map<String, Object>>> component5() {
        return this.modifiers;
    }

    public final IconProps copy(MutableState<Source> source, MutableState<Color> tintColor, MutableState<Integer> size, MutableState<String> contentDescription, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(tintColor, "tintColor");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new IconProps(source, tintColor, size, contentDescription, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IconProps)) {
            return false;
        }
        IconProps iconProps = (IconProps) other;
        return Intrinsics.areEqual(this.source, iconProps.source) && Intrinsics.areEqual(this.tintColor, iconProps.tintColor) && Intrinsics.areEqual(this.size, iconProps.size) && Intrinsics.areEqual(this.contentDescription, iconProps.contentDescription) && Intrinsics.areEqual(this.modifiers, iconProps.modifiers);
    }

    public int hashCode() {
        return (((((((this.source.hashCode() * 31) + this.tintColor.hashCode()) * 31) + this.size.hashCode()) * 31) + this.contentDescription.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "IconProps(source=" + this.source + ", tintColor=" + this.tintColor + ", size=" + this.size + ", contentDescription=" + this.contentDescription + ", modifiers=" + this.modifiers + ")";
    }

    public IconProps(MutableState<Source> source, MutableState<Color> tintColor, MutableState<Integer> size, MutableState<String> contentDescription, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(tintColor, "tintColor");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.source = source;
        this.tintColor = tintColor;
        this.size = size;
        this.contentDescription = contentDescription;
        this.modifiers = modifiers;
    }

    public /* synthetic */ IconProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState4, (i & 16) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState5);
    }

    public final MutableState<Source> getSource() {
        return this.source;
    }

    public final MutableState<Color> getTintColor() {
        return this.tintColor;
    }

    public final MutableState<Integer> getSize() {
        return this.size;
    }

    public final MutableState<String> getContentDescription() {
        return this.contentDescription;
    }

    public final MutableState<List<Map<String, Object>>> getModifiers() {
        return this.modifiers;
    }
}
