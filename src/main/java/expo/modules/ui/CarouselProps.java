package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CarouselView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ%\u0010/\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0003J \u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u001bR-\u0010\u000f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lexpo/modules/ui/CarouselProps;", "Lexpo/modules/kotlin/views/ComposeProps;", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/CarouselVariant;", "itemSpacing", "", "contentPadding", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/PaddingValuesRecord;", "minSmallItemWidth", "maxSmallItemWidth", "flingBehavior", "Lexpo/modules/ui/FlingBehaviorType;", "preferredItemWidth", "itemWidth", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/CarouselVariant;Ljava/lang/Float;Lexpo/modules/kotlin/types/Either;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;)V", "getVariant", "()Lexpo/modules/ui/CarouselVariant;", "getItemSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getContentPadding", "()Lexpo/modules/kotlin/types/Either;", "getMinSmallItemWidth", "getMaxSmallItemWidth", "getFlingBehavior", "()Lexpo/modules/ui/FlingBehaviorType;", "getPreferredItemWidth", "getItemWidth", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lexpo/modules/ui/CarouselVariant;Ljava/lang/Float;Lexpo/modules/kotlin/types/Either;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;)Lexpo/modules/ui/CarouselProps;", "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CarouselProps implements ComposeProps {
    public static final int $stable = 8;
    private final Either<Float, PaddingValuesRecord> contentPadding;
    private final FlingBehaviorType flingBehavior;
    private final Float itemSpacing;
    private final Float itemWidth;
    private final Float maxSmallItemWidth;
    private final Float minSmallItemWidth;
    private final List<Map<String, Object>> modifiers;
    private final Float preferredItemWidth;
    private final CarouselVariant variant;

    public CarouselProps() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CarouselProps copy$default(CarouselProps carouselProps, CarouselVariant carouselVariant, Float f, Either either, Float f2, Float f3, FlingBehaviorType flingBehaviorType, Float f4, Float f5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            carouselVariant = carouselProps.variant;
        }
        if ((i & 2) != 0) {
            f = carouselProps.itemSpacing;
        }
        if ((i & 4) != 0) {
            either = carouselProps.contentPadding;
        }
        if ((i & 8) != 0) {
            f2 = carouselProps.minSmallItemWidth;
        }
        if ((i & 16) != 0) {
            f3 = carouselProps.maxSmallItemWidth;
        }
        if ((i & 32) != 0) {
            flingBehaviorType = carouselProps.flingBehavior;
        }
        if ((i & 64) != 0) {
            f4 = carouselProps.preferredItemWidth;
        }
        if ((i & 128) != 0) {
            f5 = carouselProps.itemWidth;
        }
        if ((i & 256) != 0) {
            list = carouselProps.modifiers;
        }
        Float f6 = f5;
        List list2 = list;
        FlingBehaviorType flingBehaviorType2 = flingBehaviorType;
        Float f7 = f4;
        Float f8 = f3;
        Either either2 = either;
        return carouselProps.copy(carouselVariant, f, either2, f2, f8, flingBehaviorType2, f7, f6, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CarouselVariant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getItemSpacing() {
        return this.itemSpacing;
    }

    public final Either<Float, PaddingValuesRecord> component3() {
        return this.contentPadding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getMinSmallItemWidth() {
        return this.minSmallItemWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getMaxSmallItemWidth() {
        return this.maxSmallItemWidth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final FlingBehaviorType getFlingBehavior() {
        return this.flingBehavior;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Float getPreferredItemWidth() {
        return this.preferredItemWidth;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Float getItemWidth() {
        return this.itemWidth;
    }

    public final List<Map<String, Object>> component9() {
        return this.modifiers;
    }

    public final CarouselProps copy(CarouselVariant variant, Float itemSpacing, Either<Float, PaddingValuesRecord> contentPadding, Float minSmallItemWidth, Float maxSmallItemWidth, FlingBehaviorType flingBehavior, Float preferredItemWidth, Float itemWidth, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new CarouselProps(variant, itemSpacing, contentPadding, minSmallItemWidth, maxSmallItemWidth, flingBehavior, preferredItemWidth, itemWidth, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CarouselProps)) {
            return false;
        }
        CarouselProps carouselProps = (CarouselProps) other;
        return this.variant == carouselProps.variant && Intrinsics.areEqual((Object) this.itemSpacing, (Object) carouselProps.itemSpacing) && Intrinsics.areEqual(this.contentPadding, carouselProps.contentPadding) && Intrinsics.areEqual((Object) this.minSmallItemWidth, (Object) carouselProps.minSmallItemWidth) && Intrinsics.areEqual((Object) this.maxSmallItemWidth, (Object) carouselProps.maxSmallItemWidth) && this.flingBehavior == carouselProps.flingBehavior && Intrinsics.areEqual((Object) this.preferredItemWidth, (Object) carouselProps.preferredItemWidth) && Intrinsics.areEqual((Object) this.itemWidth, (Object) carouselProps.itemWidth) && Intrinsics.areEqual(this.modifiers, carouselProps.modifiers);
    }

    public int hashCode() {
        CarouselVariant carouselVariant = this.variant;
        int iHashCode = (carouselVariant == null ? 0 : carouselVariant.hashCode()) * 31;
        Float f = this.itemSpacing;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Either<Float, PaddingValuesRecord> either = this.contentPadding;
        int iHashCode3 = (iHashCode2 + (either == null ? 0 : either.hashCode())) * 31;
        Float f2 = this.minSmallItemWidth;
        int iHashCode4 = (iHashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.maxSmallItemWidth;
        int iHashCode5 = (iHashCode4 + (f3 == null ? 0 : f3.hashCode())) * 31;
        FlingBehaviorType flingBehaviorType = this.flingBehavior;
        int iHashCode6 = (iHashCode5 + (flingBehaviorType == null ? 0 : flingBehaviorType.hashCode())) * 31;
        Float f4 = this.preferredItemWidth;
        int iHashCode7 = (iHashCode6 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.itemWidth;
        return ((iHashCode7 + (f5 != null ? f5.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "CarouselProps(variant=" + this.variant + ", itemSpacing=" + this.itemSpacing + ", contentPadding=" + this.contentPadding + ", minSmallItemWidth=" + this.minSmallItemWidth + ", maxSmallItemWidth=" + this.maxSmallItemWidth + ", flingBehavior=" + this.flingBehavior + ", preferredItemWidth=" + this.preferredItemWidth + ", itemWidth=" + this.itemWidth + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CarouselProps(CarouselVariant carouselVariant, Float f, Either<Float, PaddingValuesRecord> either, Float f2, Float f3, FlingBehaviorType flingBehaviorType, Float f4, Float f5, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.variant = carouselVariant;
        this.itemSpacing = f;
        this.contentPadding = either;
        this.minSmallItemWidth = f2;
        this.maxSmallItemWidth = f3;
        this.flingBehavior = flingBehaviorType;
        this.preferredItemWidth = f4;
        this.itemWidth = f5;
        this.modifiers = modifiers;
    }

    public final CarouselVariant getVariant() {
        return this.variant;
    }

    public final Float getItemSpacing() {
        return this.itemSpacing;
    }

    public final Either<Float, PaddingValuesRecord> getContentPadding() {
        return this.contentPadding;
    }

    public final Float getMinSmallItemWidth() {
        return this.minSmallItemWidth;
    }

    public final Float getMaxSmallItemWidth() {
        return this.maxSmallItemWidth;
    }

    public final FlingBehaviorType getFlingBehavior() {
        return this.flingBehavior;
    }

    public final Float getPreferredItemWidth() {
        return this.preferredItemWidth;
    }

    public final Float getItemWidth() {
        return this.itemWidth;
    }

    public /* synthetic */ CarouselProps(CarouselVariant carouselVariant, Float f, Either either, Float f2, Float f3, FlingBehaviorType flingBehaviorType, Float f4, Float f5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : carouselVariant, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : either, (i & 8) != 0 ? null : f2, (i & 16) != 0 ? null : f3, (i & 32) != 0 ? null : flingBehaviorType, (i & 64) != 0 ? null : f4, (i & 128) != 0 ? null : f5, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
