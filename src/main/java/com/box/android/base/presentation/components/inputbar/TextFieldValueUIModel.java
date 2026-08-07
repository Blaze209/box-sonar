package com.box.android.base.presentation.components.inputbar;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputBarStates.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\b\u001aJ8\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\b\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "", "text", "", "selectionStart", "", "selectionEnd", "composition", "Landroidx/compose/ui/text/TextRange;", "<init>", "(Ljava/lang/String;IILandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getSelectionStart", "()I", "getSelectionEnd", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "fieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "getFieldValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "component1", "component2", "component3", "component4", "component4-MzsxiRA", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-eCKJ4oM", "equals", "", "other", "hashCode", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextFieldValueUIModel {
    public static final int $stable = 0;
    private final TextRange composition;
    private final int selectionEnd;
    private final int selectionStart;
    private final String text;

    public /* synthetic */ TextFieldValueUIModel(String str, int i, int i2, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, textRange);
    }

    /* JADX INFO: renamed from: copy-eCKJ4oM$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValueUIModel m11824copyeCKJ4oM$default(TextFieldValueUIModel textFieldValueUIModel, String str, int i, int i2, TextRange textRange, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = textFieldValueUIModel.text;
        }
        if ((i3 & 2) != 0) {
            i = textFieldValueUIModel.selectionStart;
        }
        if ((i3 & 4) != 0) {
            i2 = textFieldValueUIModel.selectionEnd;
        }
        if ((i3 & 8) != 0) {
            textRange = textFieldValueUIModel.composition;
        }
        return textFieldValueUIModel.m11826copyeCKJ4oM(str, i, i2, textRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSelectionStart() {
        return this.selectionStart;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    /* JADX INFO: renamed from: component4-MzsxiRA, reason: not valid java name and from getter */
    public final TextRange getComposition() {
        return this.composition;
    }

    /* JADX INFO: renamed from: copy-eCKJ4oM, reason: not valid java name */
    public final TextFieldValueUIModel m11826copyeCKJ4oM(String text, int selectionStart, int selectionEnd, TextRange composition) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TextFieldValueUIModel(text, selectionStart, selectionEnd, composition, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldValueUIModel)) {
            return false;
        }
        TextFieldValueUIModel textFieldValueUIModel = (TextFieldValueUIModel) other;
        return Intrinsics.areEqual(this.text, textFieldValueUIModel.text) && this.selectionStart == textFieldValueUIModel.selectionStart && this.selectionEnd == textFieldValueUIModel.selectionEnd && Intrinsics.areEqual(this.composition, textFieldValueUIModel.composition);
    }

    public int hashCode() {
        int iHashCode = ((((this.text.hashCode() * 31) + Integer.hashCode(this.selectionStart)) * 31) + Integer.hashCode(this.selectionEnd)) * 31;
        TextRange textRange = this.composition;
        return iHashCode + (textRange == null ? 0 : TextRange.m9092hashCodeimpl(textRange.getPackedValue()));
    }

    public String toString() {
        return "TextFieldValueUIModel(text=" + this.text + ", selectionStart=" + this.selectionStart + ", selectionEnd=" + this.selectionEnd + ", composition=" + this.composition + ")";
    }

    private TextFieldValueUIModel(String text, int i, int i2, TextRange textRange) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.selectionStart = i;
        this.selectionEnd = i2;
        this.composition = textRange;
    }

    public /* synthetic */ TextFieldValueUIModel(String str, int i, int i2, TextRange textRange, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : textRange, null);
    }

    public final String getText() {
        return this.text;
    }

    public final int getSelectionStart() {
        return this.selectionStart;
    }

    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m11827getCompositionMzsxiRA() {
        return this.composition;
    }

    public final TextFieldValue getFieldValue() {
        return new TextFieldValue(this.text, TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), this.composition, (DefaultConstructorMarker) null);
    }
}
