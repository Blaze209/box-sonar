package com.pspdfkit.annotations.note;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÂ\u0003J+\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/pspdfkit/annotations/note/AnnotationStateChange;", "", "author", "", "authorState", "Lcom/pspdfkit/annotations/note/AuthorState;", "_creationDate", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Lcom/pspdfkit/annotations/note/AuthorState;Ljava/util/Date;)V", "getAuthor", "()Ljava/lang/String;", "getAuthorState", "()Lcom/pspdfkit/annotations/note/AuthorState;", "creationDate", "getCreationDate", "()Ljava/util/Date;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AnnotationStateChange {
    public static final int $stable = 8;
    private final Date _creationDate;
    private final String author;
    private final AuthorState authorState;

    public AnnotationStateChange(String str, AuthorState authorState, Date date) {
        authorState.getClass();
        this.author = str;
        this.authorState = authorState;
        this._creationDate = date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Date get_creationDate() {
        return this._creationDate;
    }

    public static /* synthetic */ AnnotationStateChange copy$default(AnnotationStateChange annotationStateChange, String str, AuthorState authorState, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = annotationStateChange.author;
        }
        if ((i & 2) != 0) {
            authorState = annotationStateChange.authorState;
        }
        if ((i & 4) != 0) {
            date = annotationStateChange._creationDate;
        }
        return annotationStateChange.copy(str, authorState, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AuthorState getAuthorState() {
        return this.authorState;
    }

    public final AnnotationStateChange copy(String author, AuthorState authorState, Date _creationDate) {
        authorState.getClass();
        return new AnnotationStateChange(author, authorState, _creationDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationStateChange)) {
            return false;
        }
        AnnotationStateChange annotationStateChange = (AnnotationStateChange) other;
        return Intrinsics.areEqual(this.author, annotationStateChange.author) && this.authorState == annotationStateChange.authorState && Intrinsics.areEqual(this._creationDate, annotationStateChange._creationDate);
    }

    public final String getAuthor() {
        return this.author;
    }

    public final AuthorState getAuthorState() {
        return this.authorState;
    }

    public final Date getCreationDate() {
        Date date = this._creationDate;
        if (date != null) {
            return new Date(date.getTime());
        }
        return null;
    }

    public int hashCode() {
        String str = this.author;
        int iHashCode = (this.authorState.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31;
        Date date = this._creationDate;
        return iHashCode + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "AnnotationStateChange(author=" + this.author + ", authorState=" + this.authorState + ", _creationDate=" + this._creationDate + ")";
    }

    public /* synthetic */ AnnotationStateChange(String str, AuthorState authorState, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, authorState, (i & 4) != 0 ? null : date);
    }
}
