package com.pspdfkit.annotations.note;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/annotations/note/AnnotationReviewSummary;", "", "reviewNames", "", "Lcom/pspdfkit/annotations/note/AuthorState;", "", "", "currentUserState", "<init>", "(Ljava/util/Map;Lcom/pspdfkit/annotations/note/AuthorState;)V", "getReviewNames", "()Ljava/util/Map;", "getCurrentUserState", "()Lcom/pspdfkit/annotations/note/AuthorState;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AnnotationReviewSummary {
    public static final int $stable = 8;
    private final AuthorState currentUserState;
    private final Map<AuthorState, List<String>> reviewNames;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationReviewSummary(Map<AuthorState, ? extends List<String>> map, AuthorState authorState) {
        map.getClass();
        authorState.getClass();
        this.reviewNames = map;
        this.currentUserState = authorState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationReviewSummary copy$default(AnnotationReviewSummary annotationReviewSummary, Map map, AuthorState authorState, int i, Object obj) {
        if ((i & 1) != 0) {
            map = annotationReviewSummary.reviewNames;
        }
        if ((i & 2) != 0) {
            authorState = annotationReviewSummary.currentUserState;
        }
        return annotationReviewSummary.copy(map, authorState);
    }

    public final Map<AuthorState, List<String>> component1() {
        return this.reviewNames;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AuthorState getCurrentUserState() {
        return this.currentUserState;
    }

    public final AnnotationReviewSummary copy(Map<AuthorState, ? extends List<String>> reviewNames, AuthorState currentUserState) {
        reviewNames.getClass();
        currentUserState.getClass();
        return new AnnotationReviewSummary(reviewNames, currentUserState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationReviewSummary)) {
            return false;
        }
        AnnotationReviewSummary annotationReviewSummary = (AnnotationReviewSummary) other;
        return Intrinsics.areEqual(this.reviewNames, annotationReviewSummary.reviewNames) && this.currentUserState == annotationReviewSummary.currentUserState;
    }

    public final AuthorState getCurrentUserState() {
        return this.currentUserState;
    }

    public final Map<AuthorState, List<String>> getReviewNames() {
        return this.reviewNames;
    }

    public int hashCode() {
        return this.currentUserState.hashCode() + (this.reviewNames.hashCode() * 31);
    }

    public String toString() {
        return "AnnotationReviewSummary(reviewNames=" + this.reviewNames + ", currentUserState=" + this.currentUserState + ")";
    }
}
