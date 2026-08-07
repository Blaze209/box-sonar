package com.box.android.base.presentation.components.commentbar;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxCollaborator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CommentBarInputBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/MentionSpanV2;", "", "boxCollaborator", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "startIndex", "", "endIndex", "<init>", "(Lcom/box/androidsdk/content/models/BoxCollaborator;II)V", "getBoxCollaborator", "()Lcom/box/androidsdk/content/models/BoxCollaborator;", "getStartIndex", "()I", "setStartIndex", "(I)V", "getEndIndex", "setEndIndex", "toTag", "", "getToTag", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MentionSpanV2 {
    public static final int $stable = 8;
    private final BoxCollaborator boxCollaborator;
    private int endIndex;
    private int startIndex;
    private final String toTag;

    public static /* synthetic */ MentionSpanV2 copy$default(MentionSpanV2 mentionSpanV2, BoxCollaborator boxCollaborator, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            boxCollaborator = mentionSpanV2.boxCollaborator;
        }
        if ((i3 & 2) != 0) {
            i = mentionSpanV2.startIndex;
        }
        if ((i3 & 4) != 0) {
            i2 = mentionSpanV2.endIndex;
        }
        return mentionSpanV2.copy(boxCollaborator, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BoxCollaborator getBoxCollaborator() {
        return this.boxCollaborator;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    public final MentionSpanV2 copy(BoxCollaborator boxCollaborator, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(boxCollaborator, "boxCollaborator");
        return new MentionSpanV2(boxCollaborator, startIndex, endIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionSpanV2)) {
            return false;
        }
        MentionSpanV2 mentionSpanV2 = (MentionSpanV2) other;
        return Intrinsics.areEqual(this.boxCollaborator, mentionSpanV2.boxCollaborator) && this.startIndex == mentionSpanV2.startIndex && this.endIndex == mentionSpanV2.endIndex;
    }

    public int hashCode() {
        return (((this.boxCollaborator.hashCode() * 31) + Integer.hashCode(this.startIndex)) * 31) + Integer.hashCode(this.endIndex);
    }

    public String toString() {
        return "MentionSpanV2(boxCollaborator=" + this.boxCollaborator + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ")";
    }

    public MentionSpanV2(BoxCollaborator boxCollaborator, int i, int i2) {
        Intrinsics.checkNotNullParameter(boxCollaborator, "boxCollaborator");
        this.boxCollaborator = boxCollaborator;
        this.startIndex = i;
        this.endIndex = i2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String id = boxCollaborator.getUserId();
        String userName = boxCollaborator.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName, "getName(...)");
        String str = String.format(CommentBarInputBoxKt.TAG_FORMAT, Arrays.copyOf(new Object[]{id, StringsKt.removePrefix(userName, (CharSequence) CommentEntityDomainMapper.MENTIONS_SYMBOL)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.toTag = str;
    }

    public final BoxCollaborator getBoxCollaborator() {
        return this.boxCollaborator;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final void setEndIndex(int i) {
        this.endIndex = i;
    }

    public final void setStartIndex(int i) {
        this.startIndex = i;
    }

    public final String getToTag() {
        return this.toTag;
    }
}
