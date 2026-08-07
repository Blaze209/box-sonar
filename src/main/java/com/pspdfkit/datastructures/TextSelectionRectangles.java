package com.pspdfkit.datastructures;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/pspdfkit/datastructures/TextSelectionRectangles;", "Landroid/os/Parcelable;", "rectangles", "", "Landroid/graphics/RectF;", "markupRectangles", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "(Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getRectangles", "()Ljava/util/List;", "getMarkupRectangles", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", BoxTaskCollaborator.ROLE_CREATOR, "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class TextSelectionRectangles implements Parcelable {
    private final List<RectF> markupRectangles;
    private final List<RectF> rectangles;

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.pspdfkit.datastructures.TextSelectionRectangles$CREATOR, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/pspdfkit/datastructures/TextSelectionRectangles$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/pspdfkit/datastructures/TextSelectionRectangles;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/pspdfkit/datastructures/TextSelectionRectangles;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<TextSelectionRectangles> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextSelectionRectangles createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new TextSelectionRectangles(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextSelectionRectangles[] newArray(int size) {
            return new TextSelectionRectangles[size];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextSelectionRectangles(List<? extends RectF> list, List<? extends RectF> list2) {
        list.getClass();
        list2.getClass();
        this.rectangles = list;
        this.markupRectangles = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextSelectionRectangles copy$default(TextSelectionRectangles textSelectionRectangles, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = textSelectionRectangles.rectangles;
        }
        if ((i & 2) != 0) {
            list2 = textSelectionRectangles.markupRectangles;
        }
        return textSelectionRectangles.copy(list, list2);
    }

    public final List<RectF> component1() {
        return this.rectangles;
    }

    public final List<RectF> component2() {
        return this.markupRectangles;
    }

    public final TextSelectionRectangles copy(List<? extends RectF> rectangles, List<? extends RectF> markupRectangles) {
        rectangles.getClass();
        markupRectangles.getClass();
        return new TextSelectionRectangles(rectangles, markupRectangles);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextSelectionRectangles)) {
            return false;
        }
        TextSelectionRectangles textSelectionRectangles = (TextSelectionRectangles) other;
        return Intrinsics.areEqual(this.rectangles, textSelectionRectangles.rectangles) && Intrinsics.areEqual(this.markupRectangles, textSelectionRectangles.markupRectangles);
    }

    public final List<RectF> getMarkupRectangles() {
        return this.markupRectangles;
    }

    public final List<RectF> getRectangles() {
        return this.rectangles;
    }

    public int hashCode() {
        return this.markupRectangles.hashCode() + (this.rectangles.hashCode() * 31);
    }

    public String toString() {
        return "TextSelectionRectangles(rectangles=" + this.rectangles + ", markupRectangles=" + this.markupRectangles + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.getClass();
        parcel.writeTypedList(this.rectangles);
        parcel.writeTypedList(this.markupRectangles);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextSelectionRectangles(List<? extends RectF> list) {
        this(list, list);
        list.getClass();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextSelectionRectangles(Parcel parcel) {
        parcel.getClass();
        Parcelable.Creator creator = RectF.CREATOR;
        Iterable iterableCreateTypedArrayList = parcel.createTypedArrayList(creator);
        List list = CollectionsKt.toList(iterableCreateTypedArrayList == null ? CollectionsKt.emptyList() : iterableCreateTypedArrayList);
        Iterable iterableCreateTypedArrayList2 = parcel.createTypedArrayList(creator);
        this(list, CollectionsKt.toList(iterableCreateTypedArrayList2 == null ? CollectionsKt.emptyList() : iterableCreateTypedArrayList2));
    }
}
