package com.box.android.domain.metrics.msal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MsalObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/metrics/msal/PolicyBlockedReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_POLICIES_AFTER_ENROLLMENT", "POLICY_REFRESH_OR_LOST", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum PolicyBlockedReason {
    NO_POLICIES_AFTER_ENROLLMENT("no_policies_after_enrollment"),
    POLICY_REFRESH_OR_LOST("policy_refresh_or_lost");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<PolicyBlockedReason> getEntries() {
        return $ENTRIES;
    }

    PolicyBlockedReason(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
