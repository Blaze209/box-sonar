package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "Lcom/box/android/domain/models/DomainModel;", "<init>", "()V", "Area", "TextSelection", "Drawing", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel$Area;", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel$Drawing;", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel$TextSelection;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnnotationTargetModel implements DomainModel {
    public /* synthetic */ AnnotationTargetModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AnnotationTargetModel() {
    }

    /* JADX INFO: compiled from: AnnotationModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationTargetModel$Area;", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "Lcom/box/android/domain/models/DomainModel;", "annotationRectangle", "Lcom/box/android/domain/models/annotations/AnnotationRectangle;", "annotationStroke", "Lcom/box/android/domain/models/annotations/AnnotationStroke;", "<init>", "(Lcom/box/android/domain/models/annotations/AnnotationRectangle;Lcom/box/android/domain/models/annotations/AnnotationStroke;)V", "getAnnotationRectangle", "()Lcom/box/android/domain/models/annotations/AnnotationRectangle;", "getAnnotationStroke", "()Lcom/box/android/domain/models/annotations/AnnotationStroke;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Area extends AnnotationTargetModel implements DomainModel {
        private final AnnotationRectangle annotationRectangle;
        private final AnnotationStroke annotationStroke;

        public static /* synthetic */ Area copy$default(Area area, AnnotationRectangle annotationRectangle, AnnotationStroke annotationStroke, int i, Object obj) {
            if ((i & 1) != 0) {
                annotationRectangle = area.annotationRectangle;
            }
            if ((i & 2) != 0) {
                annotationStroke = area.annotationStroke;
            }
            return area.copy(annotationRectangle, annotationStroke);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnnotationRectangle getAnnotationRectangle() {
            return this.annotationRectangle;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AnnotationStroke getAnnotationStroke() {
            return this.annotationStroke;
        }

        public final Area copy(AnnotationRectangle annotationRectangle, AnnotationStroke annotationStroke) {
            Intrinsics.checkNotNullParameter(annotationRectangle, "annotationRectangle");
            return new Area(annotationRectangle, annotationStroke);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Area)) {
                return false;
            }
            Area area = (Area) other;
            return Intrinsics.areEqual(this.annotationRectangle, area.annotationRectangle) && Intrinsics.areEqual(this.annotationStroke, area.annotationStroke);
        }

        public int hashCode() {
            int iHashCode = this.annotationRectangle.hashCode() * 31;
            AnnotationStroke annotationStroke = this.annotationStroke;
            return iHashCode + (annotationStroke == null ? 0 : annotationStroke.hashCode());
        }

        public String toString() {
            return "Area(annotationRectangle=" + this.annotationRectangle + ", annotationStroke=" + this.annotationStroke + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Area(AnnotationRectangle annotationRectangle, AnnotationStroke annotationStroke) {
            super(null);
            Intrinsics.checkNotNullParameter(annotationRectangle, "annotationRectangle");
            this.annotationRectangle = annotationRectangle;
            this.annotationStroke = annotationStroke;
        }

        public final AnnotationRectangle getAnnotationRectangle() {
            return this.annotationRectangle;
        }

        public final AnnotationStroke getAnnotationStroke() {
            return this.annotationStroke;
        }
    }

    /* JADX INFO: compiled from: AnnotationModel.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationTargetModel$TextSelection;", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "Lcom/box/android/domain/models/DomainModel;", "highlightColor", "", "highlightStroke", "Lcom/box/android/domain/models/annotations/AnnotationStroke;", "highlights", "", "Lcom/box/android/domain/models/annotations/AnnotationRectangle;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/AnnotationStroke;Ljava/util/List;)V", "getHighlightColor", "()Ljava/lang/String;", "getHighlightStroke", "()Lcom/box/android/domain/models/annotations/AnnotationStroke;", "getHighlights", "()Ljava/util/List;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextSelection extends AnnotationTargetModel implements DomainModel {
        private final String highlightColor;
        private final AnnotationStroke highlightStroke;
        private final List<AnnotationRectangle> highlights;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TextSelection copy$default(TextSelection textSelection, String str, AnnotationStroke annotationStroke, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textSelection.highlightColor;
            }
            if ((i & 2) != 0) {
                annotationStroke = textSelection.highlightStroke;
            }
            if ((i & 4) != 0) {
                list = textSelection.highlights;
            }
            return textSelection.copy(str, annotationStroke, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHighlightColor() {
            return this.highlightColor;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AnnotationStroke getHighlightStroke() {
            return this.highlightStroke;
        }

        public final List<AnnotationRectangle> component3() {
            return this.highlights;
        }

        public final TextSelection copy(String highlightColor, AnnotationStroke highlightStroke, List<AnnotationRectangle> highlights) {
            Intrinsics.checkNotNullParameter(highlights, "highlights");
            return new TextSelection(highlightColor, highlightStroke, highlights);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextSelection)) {
                return false;
            }
            TextSelection textSelection = (TextSelection) other;
            return Intrinsics.areEqual(this.highlightColor, textSelection.highlightColor) && Intrinsics.areEqual(this.highlightStroke, textSelection.highlightStroke) && Intrinsics.areEqual(this.highlights, textSelection.highlights);
        }

        public int hashCode() {
            String str = this.highlightColor;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            AnnotationStroke annotationStroke = this.highlightStroke;
            return ((iHashCode + (annotationStroke != null ? annotationStroke.hashCode() : 0)) * 31) + this.highlights.hashCode();
        }

        public String toString() {
            return "TextSelection(highlightColor=" + this.highlightColor + ", highlightStroke=" + this.highlightStroke + ", highlights=" + this.highlights + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextSelection(String str, AnnotationStroke annotationStroke, List<AnnotationRectangle> highlights) {
            super(null);
            Intrinsics.checkNotNullParameter(highlights, "highlights");
            this.highlightColor = str;
            this.highlightStroke = annotationStroke;
            this.highlights = highlights;
        }

        public final String getHighlightColor() {
            return this.highlightColor;
        }

        public final AnnotationStroke getHighlightStroke() {
            return this.highlightStroke;
        }

        public final List<AnnotationRectangle> getHighlights() {
            return this.highlights;
        }
    }

    /* JADX INFO: compiled from: AnnotationModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationTargetModel$Drawing;", "Lcom/box/android/domain/models/annotations/AnnotationTargetModel;", "Lcom/box/android/domain/models/DomainModel;", "pathGroups", "", "Lcom/box/android/domain/models/annotations/AnnotationPathGroup;", "<init>", "(Ljava/util/List;)V", "getPathGroups", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Drawing extends AnnotationTargetModel implements DomainModel {
        private final List<AnnotationPathGroup> pathGroups;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Drawing copy$default(Drawing drawing, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = drawing.pathGroups;
            }
            return drawing.copy(list);
        }

        public final List<AnnotationPathGroup> component1() {
            return this.pathGroups;
        }

        public final Drawing copy(List<AnnotationPathGroup> pathGroups) {
            Intrinsics.checkNotNullParameter(pathGroups, "pathGroups");
            return new Drawing(pathGroups);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Drawing) && Intrinsics.areEqual(this.pathGroups, ((Drawing) other).pathGroups);
        }

        public int hashCode() {
            return this.pathGroups.hashCode();
        }

        public String toString() {
            return "Drawing(pathGroups=" + this.pathGroups + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drawing(List<AnnotationPathGroup> pathGroups) {
            super(null);
            Intrinsics.checkNotNullParameter(pathGroups, "pathGroups");
            this.pathGroups = pathGroups;
        }

        public final List<AnnotationPathGroup> getPathGroups() {
            return this.pathGroups;
        }
    }
}
