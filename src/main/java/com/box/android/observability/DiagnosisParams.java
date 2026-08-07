package com.box.android.observability;

import kotlin.Metadata;

/* JADX INFO: compiled from: DiagnosisParams.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/observability/DiagnosisParams;", "", "<init>", "()V", "DIAGNOSIS_MODE", "", "DIAGNOSIS_DURATION", "UPLOAD_AT_COMPLETION", "CLEAR_ON_LOGOUT", "DIAGNOSIS_LOG_TAG", "DIAGNOSIS_VALUE_YES", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiagnosisParams {
    public static final int $stable = 0;
    public static final String CLEAR_ON_LOGOUT = "clear";
    public static final String DIAGNOSIS_DURATION = "dur";
    public static final String DIAGNOSIS_LOG_TAG = "tag";
    public static final String DIAGNOSIS_MODE = "mode";
    public static final String DIAGNOSIS_VALUE_YES = "y";
    public static final DiagnosisParams INSTANCE = new DiagnosisParams();
    public static final String UPLOAD_AT_COMPLETION = "up";

    private DiagnosisParams() {
    }
}
