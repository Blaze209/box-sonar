package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyColumnView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u00070\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0003\u0012*\b\u0002\u0010\f\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0002`\u00100\rj\u0002`\u00110\u0003¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0019\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u00070\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0003HÆ\u0003J+\u0010\u001c\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0002`\u00100\rj\u0002`\u00110\u0003HÆ\u0003J}\u0010\u001d\u001a\u00020\u00002\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u00070\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00032*\b\u0002\u0010\f\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0002`\u00100\rj\u0002`\u00110\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R+\u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R3\u0010\f\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0002`\u00100\rj\u0002`\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006$"}, d2 = {"Lexpo/modules/ui/LazyColumnProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "verticalArrangement", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/convertibles/VerticalArrangementDefault;", "Lexpo/modules/ui/convertibles/VerticalArrangementCustom;", "Lexpo/modules/ui/convertibles/VerticalArrangement;", "horizontalAlignment", "", "contentPadding", "Lexpo/modules/ui/ContentPadding;", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getVerticalArrangement", "()Landroidx/compose/runtime/MutableState;", "getHorizontalAlignment", "getContentPadding", "getModifiers", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class LazyColumnProps implements ComposeProps {
    public static final int $stable = 0;
    private final MutableState<ContentPadding> contentPadding;
    private final MutableState<String> horizontalAlignment;
    private final MutableState<List<Map<String, Object>>> modifiers;
    private final MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> verticalArrangement;

    public LazyColumnProps() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LazyColumnProps copy$default(LazyColumnProps lazyColumnProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = lazyColumnProps.verticalArrangement;
        }
        if ((i & 2) != 0) {
            mutableState2 = lazyColumnProps.horizontalAlignment;
        }
        if ((i & 4) != 0) {
            mutableState3 = lazyColumnProps.contentPadding;
        }
        if ((i & 8) != 0) {
            mutableState4 = lazyColumnProps.modifiers;
        }
        return lazyColumnProps.copy(mutableState, mutableState2, mutableState3, mutableState4);
    }

    public final MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> component1() {
        return this.verticalArrangement;
    }

    public final MutableState<String> component2() {
        return this.horizontalAlignment;
    }

    public final MutableState<ContentPadding> component3() {
        return this.contentPadding;
    }

    public final MutableState<List<Map<String, Object>>> component4() {
        return this.modifiers;
    }

    public final LazyColumnProps copy(MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> verticalArrangement, MutableState<String> horizontalAlignment, MutableState<ContentPadding> contentPadding, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new LazyColumnProps(verticalArrangement, horizontalAlignment, contentPadding, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LazyColumnProps)) {
            return false;
        }
        LazyColumnProps lazyColumnProps = (LazyColumnProps) other;
        return Intrinsics.areEqual(this.verticalArrangement, lazyColumnProps.verticalArrangement) && Intrinsics.areEqual(this.horizontalAlignment, lazyColumnProps.horizontalAlignment) && Intrinsics.areEqual(this.contentPadding, lazyColumnProps.contentPadding) && Intrinsics.areEqual(this.modifiers, lazyColumnProps.modifiers);
    }

    public int hashCode() {
        return (((((this.verticalArrangement.hashCode() * 31) + this.horizontalAlignment.hashCode()) * 31) + this.contentPadding.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "LazyColumnProps(verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ", contentPadding=" + this.contentPadding + ", modifiers=" + this.modifiers + ")";
    }

    public LazyColumnProps(MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> verticalArrangement, MutableState<String> horizontalAlignment, MutableState<ContentPadding> contentPadding, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.verticalArrangement = verticalArrangement;
        this.horizontalAlignment = horizontalAlignment;
        this.contentPadding = contentPadding;
        this.modifiers = modifiers;
    }

    public /* synthetic */ LazyColumnProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState4);
    }

    public final MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public final MutableState<String> getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final MutableState<ContentPadding> getContentPadding() {
        return this.contentPadding;
    }

    public final MutableState<List<Map<String, Object>>> getModifiers() {
        return this.modifiers;
    }
}
