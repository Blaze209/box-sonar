package com.box.android.domain.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.models.RepresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewerTypeResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/preview/PreviewContentType;", "", "<init>", "()V", PreviewObservability.ORIGINAL_CONTENT_TYPE, "Representation", "Lcom/box/android/domain/preview/PreviewContentType$Original;", "Lcom/box/android/domain/preview/PreviewContentType$Representation;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PreviewContentType {
    public /* synthetic */ PreviewContentType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: PreviewerTypeResolver.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/preview/PreviewContentType$Original;", "Lcom/box/android/domain/preview/PreviewContentType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Original extends PreviewContentType {
        public static final Original INSTANCE = new Original();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Original)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -365478509;
        }

        public String toString() {
            return PreviewObservability.ORIGINAL_CONTENT_TYPE;
        }

        private Original() {
            super(null);
        }
    }

    private PreviewContentType() {
    }

    /* JADX INFO: compiled from: PreviewerTypeResolver.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/preview/PreviewContentType$Representation;", "Lcom/box/android/domain/preview/PreviewContentType;", "model", "Lcom/box/android/domain/models/RepresentationModel;", "<init>", "(Lcom/box/android/domain/models/RepresentationModel;)V", "getModel", "()Lcom/box/android/domain/models/RepresentationModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Representation extends PreviewContentType {
        private final RepresentationModel model;

        public static /* synthetic */ Representation copy$default(Representation representation, RepresentationModel representationModel, int i, Object obj) {
            if ((i & 1) != 0) {
                representationModel = representation.model;
            }
            return representation.copy(representationModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RepresentationModel getModel() {
            return this.model;
        }

        public final Representation copy(RepresentationModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            return new Representation(model);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Representation) && Intrinsics.areEqual(this.model, ((Representation) other).model);
        }

        public int hashCode() {
            return this.model.hashCode();
        }

        public String toString() {
            return "Representation(model=" + this.model + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Representation(RepresentationModel model) {
            super(null);
            Intrinsics.checkNotNullParameter(model, "model");
            this.model = model;
        }

        public final RepresentationModel getModel() {
            return this.model;
        }
    }
}
