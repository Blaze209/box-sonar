package com.box.android.preview.annotations.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Annotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "", "<init>", "()V", "UNSELECTED", "SELECTED", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState$SELECTED;", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState$UNSELECTED;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnnotationSelectedState {
    public static final int $stable = 0;

    public /* synthetic */ AnnotationSelectedState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: Annotation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/model/AnnotationSelectedState$UNSELECTED;", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UNSELECTED extends AnnotationSelectedState {
        public static final int $stable = 0;
        public static final UNSELECTED INSTANCE = new UNSELECTED();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UNSELECTED)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -438494497;
        }

        public String toString() {
            return "UNSELECTED";
        }

        private UNSELECTED() {
            super(null);
        }
    }

    private AnnotationSelectedState() {
    }

    /* JADX INFO: compiled from: Annotation.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/annotations/model/AnnotationSelectedState$SELECTED;", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SELECTED extends AnnotationSelectedState {
        public static final int $stable = 0;
        public static final SELECTED INSTANCE = new SELECTED();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SELECTED)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -626235386;
        }

        public String toString() {
            return "SELECTED";
        }

        private SELECTED() {
            super(null);
        }
    }
}
