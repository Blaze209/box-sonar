package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextAutoSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0013H\u0002J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "didOverflow", "", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "equals", "other", "", "hashCode", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AutoSizeStepBased implements TextAutoSize {
    private final long maxFontSize;
    private long minFontSize;
    private final long stepSize;

    public /* synthetic */ AutoSizeStepBased(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private AutoSizeStepBased(long j, long j2, long j3) {
        this.minFontSize = j;
        this.maxFontSize = j2;
        this.stepSize = j3;
        if (TextUnit.m9878equalsimpl0(j, TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
        }
        if (TextUnit.m9878equalsimpl0(j2, TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
        }
        if (TextUnit.m9878equalsimpl0(j3, TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
        }
        if (TextUnitType.m9909equalsimpl0(TextUnit.m9880getTypeUIouoOA(this.minFontSize), TextUnit.m9880getTypeUIouoOA(j2))) {
            long j4 = this.minFontSize;
            TextUnitKt.m9895checkArithmeticNB67dxo(j4, j2);
            if (Float.compare(TextUnit.m9881getValueimpl(j4), TextUnit.m9881getValueimpl(j2)) > 0) {
                this.minFontSize = j2;
            }
        }
        if (TextUnitType.m9909equalsimpl0(TextUnit.m9880getTypeUIouoOA(j3), TextUnitType.INSTANCE.m9914getSpUIouoOA())) {
            long sp = TextUnitKt.getSp(1.0E-4f);
            TextUnitKt.m9895checkArithmeticNB67dxo(j3, sp);
            if (Float.compare(TextUnit.m9881getValueimpl(j3), TextUnit.m9881getValueimpl(sp)) < 0) {
                throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
            }
        }
        if (TextUnit.m9881getValueimpl(this.minFontSize) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
        }
        if (TextUnit.m9881getValueimpl(j2) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
        }
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    /* JADX INFO: renamed from: getFontSize-Ci0_558, reason: not valid java name */
    public long mo1581getFontSizeCi0_558(TextAutoSizeLayoutScope textAutoSizeLayoutScope, long j, AnnotatedString annotatedString) {
        float f = textAutoSizeLayoutScope.mo753toPxR2X_6o(this.stepSize);
        float f2 = textAutoSizeLayoutScope.mo753toPxR2X_6o(this.minFontSize);
        float f3 = textAutoSizeLayoutScope.mo753toPxR2X_6o(this.maxFontSize);
        float f4 = 2;
        float f5 = (f2 + f3) / f4;
        float f6 = f2;
        float f7 = f3;
        while (f7 - f6 >= f) {
            if (didOverflow(textAutoSizeLayoutScope.mo2090performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo757toSpkPz2Gy4(f5)))) {
                f7 = f5;
            } else {
                f6 = f5;
            }
            f5 = (f6 + f7) / f4;
        }
        float fFloor = (((float) Math.floor((f6 - f2) / f)) * f) + f2;
        float f8 = f + fFloor;
        if (f8 <= f3 && !didOverflow(textAutoSizeLayoutScope.mo2090performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo757toSpkPz2Gy4(f8)))) {
            fFloor = f8;
        }
        return textAutoSizeLayoutScope.mo757toSpkPz2Gy4(fFloor);
    }

    private final boolean didOverflow(TextLayoutResult textLayoutResult) {
        int overflow = textLayoutResult.getLayoutInput().getOverflow();
        if (TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9583getClipgIe3tQ8()) || TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9587getVisiblegIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9586getStartEllipsisgIe3tQ8()) || TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9585getMiddleEllipsisgIe3tQ8()) || TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8())) {
            return didOverflowByEllipsize(textLayoutResult);
        }
        throw new IllegalArgumentException("TextOverflow type " + ((Object) TextOverflow.m9576toStringimpl(textLayoutResult.getLayoutInput().getOverflow())) + " is not supported.");
    }

    private final boolean didOverflowBounds(TextLayoutResult textLayoutResult) {
        return textLayoutResult.getDidOverflowWidth() || textLayoutResult.getDidOverflowHeight();
    }

    private final boolean didOverflowByEllipsize(TextLayoutResult textLayoutResult) {
        int lineCount = textLayoutResult.getLineCount();
        if (lineCount == 0) {
            return false;
        }
        if (lineCount == 1) {
            return textLayoutResult.isLineEllipsized(0);
        }
        int overflow = textLayoutResult.getLayoutInput().getOverflow();
        if (TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9586getStartEllipsisgIe3tQ8()) || TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9585getMiddleEllipsisgIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m9574equalsimpl0(overflow, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8())) {
            return textLayoutResult.isLineEllipsized(textLayoutResult.getLineCount() - 1);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || !(other instanceof AutoSizeStepBased)) {
            return false;
        }
        AutoSizeStepBased autoSizeStepBased = (AutoSizeStepBased) other;
        return TextUnit.m9878equalsimpl0(autoSizeStepBased.minFontSize, this.minFontSize) && TextUnit.m9878equalsimpl0(autoSizeStepBased.maxFontSize, this.maxFontSize) && TextUnit.m9878equalsimpl0(autoSizeStepBased.stepSize, this.stepSize);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.m9882hashCodeimpl(this.minFontSize) * 31) + TextUnit.m9882hashCodeimpl(this.maxFontSize)) * 31) + TextUnit.m9882hashCodeimpl(this.stepSize);
    }
}
