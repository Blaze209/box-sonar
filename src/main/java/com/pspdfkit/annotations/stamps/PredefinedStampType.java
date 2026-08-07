package com.pspdfkit.annotations.stamps;

import com.pspdfkit.R;
import com.pspdfkit.internal.jni.NativeStampAnnotationHelper;
import com.pspdfkit.internal.jni.NativeStampType;

/* JADX INFO: loaded from: classes3.dex */
public enum PredefinedStampType {
    APPROVED(StampType.APPROVED, R.string.pspdf__stamp_approved),
    EXPERIMENTAL(StampType.EXPERIMENTAL, R.string.pspdf__stamp_experimental),
    NOT_APPROVED(StampType.NOT_APPROVED, R.string.pspdf__stamp_not_approved),
    AS_IS(StampType.AS_IS, R.string.pspdf__stamp_as_is),
    EXPIRED(StampType.EXPIRED, R.string.pspdf__stamp_expired),
    DRAFT(StampType.DRAFT, R.string.pspdf__stamp_draft),
    FINAL(StampType.FINAL, R.string.pspdf__stamp_final),
    SOLD(StampType.SOLD, R.string.pspdf__stamp_sold),
    DEPARTMENTAL(StampType.DEPARTMENTAL, R.string.pspdf__stamp_departmental),
    CONFIDENTIAL(StampType.CONFIDENTIAL, R.string.pspdf__stamp_confidential),
    FOR_PUBLIC_RELEASE(StampType.FOR_PUBLIC_RELEASE, R.string.pspdf__stamp_for_public_release),
    NOT_FOR_PUBLIC_RELEASE(StampType.NOT_FOR_PUBLIC_RELEASE, R.string.pspdf__stamp_not_for_public_release),
    FOR_COMMENT(StampType.FOR_COMMENT, R.string.pspdf__stamp_for_comment),
    TOP_SECRET(StampType.TOP_SECRET, R.string.pspdf__stamp_top_secret),
    COMPLETED(StampType.COMPLETED, R.string.pspdf__stamp_completed),
    VOID(StampType.VOID, R.string.pspdf__stamp_void),
    PRELIMINARY_RESULTS(StampType.PRELIMINARY_RESULTS, R.string.pspdf__stamp_preliminary_results),
    INFORMATION_ONLY(StampType.INFORMATION_ONLY, R.string.pspdf__stamp_information_only),
    REVISED(StampType.REVISED, R.string.pspdf__stamp_revised),
    ACCEPTED(StampType.ACCEPTED, R.string.pspdf__stamp_accepted),
    REJECTED(StampType.REJECTED, R.string.pspdf__stamp_rejected),
    INITIAL_HERE(StampType.INITIAL_HERE, R.string.pspdf__stamp_initial_here),
    SIGN_HERE(StampType.SIGN_HERE, R.string.pspdf__stamp_sign_here),
    WITNESS(StampType.WITNESS, R.string.pspdf__stamp_witness),
    CUSTOM(null, R.string.pspdf__custom_stamp);

    private final StampType stampType;
    private final int titleResId;

    PredefinedStampType(StampType stampType, int i) {
        this.stampType = stampType;
        this.titleResId = i;
    }

    public static PredefinedStampType fromName(String str) {
        if (str == null) {
            return null;
        }
        return fromNativeStampType(NativeStampAnnotationHelper.create().getStampType(str));
    }

    private static PredefinedStampType fromNativeStampType(NativeStampType nativeStampType) {
        if (nativeStampType != null) {
            for (PredefinedStampType predefinedStampType : values()) {
                StampType stampType = predefinedStampType.stampType;
                if ((stampType != null ? stampType.getNativeType() : null) == nativeStampType) {
                    return predefinedStampType;
                }
            }
        }
        return null;
    }

    public static PredefinedStampType fromStampType(StampType stampType) {
        if (stampType == null) {
            return null;
        }
        return fromNativeStampType(stampType.getNativeType());
    }

    public String getName() {
        StampType stampType = this.stampType;
        if (stampType == null) {
            return null;
        }
        return stampType.getName();
    }

    public StampType getStampType() {
        return this.stampType;
    }

    public int getTitleResId() {
        return this.titleResId;
    }

    public boolean isStandard() {
        return this != CUSTOM;
    }
}
