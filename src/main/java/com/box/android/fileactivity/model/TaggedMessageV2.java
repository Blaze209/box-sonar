package com.box.android.fileactivity.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityUIModelsV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/fileactivity/model/TaggedMessageV2;", "", "message", "", "mentionSpans", "", "Lcom/box/android/fileactivity/model/MentionInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getMentionSpans", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaggedMessageV2 {
    public static final int $stable = 8;
    private final List<MentionInfo> mentionSpans;
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaggedMessageV2 copy$default(TaggedMessageV2 taggedMessageV2, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taggedMessageV2.message;
        }
        if ((i & 2) != 0) {
            list = taggedMessageV2.mentionSpans;
        }
        return taggedMessageV2.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<MentionInfo> component2() {
        return this.mentionSpans;
    }

    public final TaggedMessageV2 copy(String message, List<MentionInfo> mentionSpans) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(mentionSpans, "mentionSpans");
        return new TaggedMessageV2(message, mentionSpans);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaggedMessageV2)) {
            return false;
        }
        TaggedMessageV2 taggedMessageV2 = (TaggedMessageV2) other;
        return Intrinsics.areEqual(this.message, taggedMessageV2.message) && Intrinsics.areEqual(this.mentionSpans, taggedMessageV2.mentionSpans);
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.mentionSpans.hashCode();
    }

    public String toString() {
        return "TaggedMessageV2(message=" + this.message + ", mentionSpans=" + this.mentionSpans + ")";
    }

    public TaggedMessageV2(String message, List<MentionInfo> mentionSpans) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(mentionSpans, "mentionSpans");
        this.message = message;
        this.mentionSpans = mentionSpans;
    }

    public final List<MentionInfo> getMentionSpans() {
        return this.mentionSpans;
    }

    public final String getMessage() {
        return this.message;
    }
}
