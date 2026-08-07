package com.box.android.base.presentation.components.inputbar;

import com.box.android.base.presentation.components.commentbar.MentionSpanV2;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.errorprone.annotations.Immutable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputBarStates.kt */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "", "textFieldValue", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "mentionSpans", "", "Lcom/box/android/base/presentation/components/commentbar/MentionSpanV2;", "<init>", "(Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;Ljava/util/List;)V", "getTextFieldValue", "()Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "getMentionSpans", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InputBoxValue {
    public static final int $stable = 8;
    private final List<MentionSpanV2> mentionSpans;
    private final TextFieldValueUIModel textFieldValue;

    /* JADX WARN: Multi-variable type inference failed */
    public InputBoxValue() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputBoxValue copy$default(InputBoxValue inputBoxValue, TextFieldValueUIModel textFieldValueUIModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            textFieldValueUIModel = inputBoxValue.textFieldValue;
        }
        if ((i & 2) != 0) {
            list = inputBoxValue.mentionSpans;
        }
        return inputBoxValue.copy(textFieldValueUIModel, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextFieldValueUIModel getTextFieldValue() {
        return this.textFieldValue;
    }

    public final List<MentionSpanV2> component2() {
        return this.mentionSpans;
    }

    public final InputBoxValue copy(TextFieldValueUIModel textFieldValue, List<MentionSpanV2> mentionSpans) {
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(mentionSpans, "mentionSpans");
        return new InputBoxValue(textFieldValue, mentionSpans);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputBoxValue)) {
            return false;
        }
        InputBoxValue inputBoxValue = (InputBoxValue) other;
        return Intrinsics.areEqual(this.textFieldValue, inputBoxValue.textFieldValue) && Intrinsics.areEqual(this.mentionSpans, inputBoxValue.mentionSpans);
    }

    public int hashCode() {
        return (this.textFieldValue.hashCode() * 31) + this.mentionSpans.hashCode();
    }

    public String toString() {
        return "InputBoxValue(textFieldValue=" + this.textFieldValue + ", mentionSpans=" + this.mentionSpans + ")";
    }

    public InputBoxValue(TextFieldValueUIModel textFieldValue, List<MentionSpanV2> mentionSpans) {
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(mentionSpans, "mentionSpans");
        this.textFieldValue = textFieldValue;
        this.mentionSpans = mentionSpans;
    }

    public /* synthetic */ InputBoxValue(TextFieldValueUIModel textFieldValueUIModel, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            textFieldValueUIModel = new TextFieldValueUIModel("", 0, 0, null, 14, null);
        }
        this(textFieldValueUIModel, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final TextFieldValueUIModel getTextFieldValue() {
        return this.textFieldValue;
    }

    public final List<MentionSpanV2> getMentionSpans() {
        return this.mentionSpans;
    }
}
