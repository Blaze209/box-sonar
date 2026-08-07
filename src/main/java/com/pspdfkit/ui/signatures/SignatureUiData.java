package com.pspdfkit.ui.signatures;

import android.graphics.PointF;
import com.android.tools.r8.RecordTag;
import com.pspdfkit.internal.n70$a$$ExternalSyntheticRecord0;
import com.pspdfkit.signatures.BiometricSignatureData;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class SignatureUiData extends RecordTag {
    private final BiometricSignatureData.InputMethod inputMethod;
    private final List<List<PointF>> pointSequences;
    private final List<Float> pressureList;
    private final List<Long> timePoints;
    private final List<Float> touchRadii;

    private /* synthetic */ boolean $record$equals(Object obj) {
        if (!(obj instanceof SignatureUiData)) {
            return false;
        }
        SignatureUiData signatureUiData = (SignatureUiData) obj;
        return Objects.equals(this.pointSequences, signatureUiData.pointSequences) && Objects.equals(this.pressureList, signatureUiData.pressureList) && Objects.equals(this.timePoints, signatureUiData.timePoints) && Objects.equals(this.touchRadii, signatureUiData.touchRadii) && Objects.equals(this.inputMethod, signatureUiData.inputMethod);
    }

    private /* synthetic */ Object[] $record$getFieldsAsObjects() {
        return new Object[]{this.pointSequences, this.pressureList, this.timePoints, this.touchRadii, this.inputMethod};
    }

    public SignatureUiData(List<List<PointF>> list, List<Float> list2, List<Long> list3, List<Float> list4, BiometricSignatureData.InputMethod inputMethod) {
        this.pointSequences = list;
        this.pressureList = list2;
        this.timePoints = list3;
        this.touchRadii = list4;
        this.inputMethod = inputMethod;
    }

    public final boolean equals(Object obj) {
        return $record$equals(obj);
    }

    public final int hashCode() {
        return n70$a$$ExternalSyntheticRecord0.m(this.pointSequences, this.pressureList, this.timePoints, this.touchRadii, this.inputMethod);
    }

    public BiometricSignatureData.InputMethod inputMethod() {
        return this.inputMethod;
    }

    public List<List<PointF>> pointSequences() {
        return this.pointSequences;
    }

    public List<Float> pressureList() {
        return this.pressureList;
    }

    public List<Long> timePoints() {
        return this.timePoints;
    }

    public final String toString() {
        return n70$a$$ExternalSyntheticRecord0.m($record$getFieldsAsObjects(), SignatureUiData.class, "pointSequences;pressureList;timePoints;touchRadii;inputMethod");
    }

    public List<Float> touchRadii() {
        return this.touchRadii;
    }
}
