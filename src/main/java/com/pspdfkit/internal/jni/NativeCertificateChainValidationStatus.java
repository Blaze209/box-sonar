package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeCertificateChainValidationStatus {
    final ArrayList<HashSet<NativeCertificateValidationStatus>> mAllStatuses;
    final ArrayList<NativeX509Certificate> mCertificatePath;
    final NativeCertificateValidationStatus mOverallStatus;
    final String mRawErrorMessage;
    final Date mValidFrom;
    final Date mValidUntil;

    public NativeCertificateChainValidationStatus(NativeCertificateValidationStatus nativeCertificateValidationStatus, String str, ArrayList<HashSet<NativeCertificateValidationStatus>> arrayList, Date date, Date date2, ArrayList<NativeX509Certificate> arrayList2) {
        this.mOverallStatus = nativeCertificateValidationStatus;
        this.mRawErrorMessage = str;
        this.mAllStatuses = arrayList;
        this.mValidFrom = date;
        this.mValidUntil = date2;
        this.mCertificatePath = arrayList2;
    }

    public ArrayList<HashSet<NativeCertificateValidationStatus>> getAllStatuses() {
        return this.mAllStatuses;
    }

    public ArrayList<NativeX509Certificate> getCertificatePath() {
        return this.mCertificatePath;
    }

    public NativeCertificateValidationStatus getOverallStatus() {
        return this.mOverallStatus;
    }

    public String getRawErrorMessage() {
        return this.mRawErrorMessage;
    }

    public Date getValidFrom() {
        return this.mValidFrom;
    }

    public Date getValidUntil() {
        return this.mValidUntil;
    }

    public String toString() {
        return "NativeCertificateChainValidationStatus{mOverallStatus=" + this.mOverallStatus + ",mRawErrorMessage=" + this.mRawErrorMessage + ",mAllStatuses=" + this.mAllStatuses + ",mValidFrom=" + this.mValidFrom + ",mValidUntil=" + this.mValidUntil + ",mCertificatePath=" + this.mCertificatePath + "}";
    }
}
