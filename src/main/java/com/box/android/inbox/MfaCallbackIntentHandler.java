package com.box.android.inbox;

import android.content.Intent;
import com.box.android.cpl.Store;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.inbox.mfasetup.MfaSetupAnalytics;
import com.box.android.inbox.notifications.InboxItemsListReducer;
import com.box.android.inbox.notifications.InboxReducer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MfaCallbackIntentHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/inbox/MfaCallbackIntentHandler;", "", "mfaSetupAnalytics", "Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;", "<init>", "(Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;)V", "getMfaSetupAnalytics", "()Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;", "handleIntent", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/inbox/notifications/InboxReducer$State;", "Lcom/box/android/inbox/notifications/InboxReducer$Action;", "intent", "Landroid/content/Intent;", "extractMfaCallbackData", "Lcom/box/android/inbox/MfaCallbackIntentHandler$MfaCallbackData;", "isAlreadyProcessed", "", "markAsProcessed", "Companion", "MfaCallbackData", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MfaCallbackIntentHandler {
    public static final int $stable = 0;
    public static final String EXTRA_MFA_EVENT = "extra_mfa_event";
    public static final String EXTRA_MFA_IS_SUCCESS = "extra_mfa_is_success";
    public static final String EXTRA_MFA_SESSION_ID = "extra_mfa_session_id";
    private static final String MFA_PROCESSED_FLAG = "mfa_processed";
    private final MfaSetupAnalytics mfaSetupAnalytics;

    @Inject
    public MfaCallbackIntentHandler(MfaSetupAnalytics mfaSetupAnalytics) {
        Intrinsics.checkNotNullParameter(mfaSetupAnalytics, "mfaSetupAnalytics");
        this.mfaSetupAnalytics = mfaSetupAnalytics;
    }

    public final MfaSetupAnalytics getMfaSetupAnalytics() {
        return this.mfaSetupAnalytics;
    }

    public final void handleIntent(Store<InboxReducer.State, InboxReducer.Action> store, Intent intent) {
        MfaCallbackData mfaCallbackDataExtractMfaCallbackData;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (isAlreadyProcessed(intent) || (mfaCallbackDataExtractMfaCallbackData = extractMfaCallbackData(intent)) == null) {
            return;
        }
        store.send(new InboxReducer.Action.ItemsListAction(InboxItemsListReducer.Action.RefreshNotifications.INSTANCE));
        if (mfaCallbackDataExtractMfaCallbackData.isSuccess()) {
            this.mfaSetupAnalytics.enrollMfaCompleted(mfaCallbackDataExtractMfaCallbackData.getMobileSessionId());
        }
        markAsProcessed(intent);
    }

    private final MfaCallbackData extractMfaCallbackData(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_MFA_EVENT);
        if (stringExtra == null) {
            return null;
        }
        long longExtra = intent.getLongExtra(EXTRA_MFA_SESSION_ID, -1L);
        return new MfaCallbackData(stringExtra, Long.valueOf(longExtra), intent.getBooleanExtra(EXTRA_MFA_IS_SUCCESS, false));
    }

    private final boolean isAlreadyProcessed(Intent intent) {
        return intent.getBooleanExtra(MFA_PROCESSED_FLAG, false);
    }

    private final void markAsProcessed(Intent intent) {
        intent.putExtra(MFA_PROCESSED_FLAG, true);
    }

    /* JADX INFO: compiled from: MfaCallbackIntentHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/inbox/MfaCallbackIntentHandler$MfaCallbackData;", "", "event", "", "mobileSessionId", "", "isSuccess", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Z)V", "getEvent", "()Ljava/lang/String;", "getMobileSessionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Long;Z)Lcom/box/android/inbox/MfaCallbackIntentHandler$MfaCallbackData;", "equals", "other", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MfaCallbackData {
        public static final int $stable = 0;
        private final String event;
        private final boolean isSuccess;
        private final Long mobileSessionId;

        public static /* synthetic */ MfaCallbackData copy$default(MfaCallbackData mfaCallbackData, String str, Long l, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mfaCallbackData.event;
            }
            if ((i & 2) != 0) {
                l = mfaCallbackData.mobileSessionId;
            }
            if ((i & 4) != 0) {
                z = mfaCallbackData.isSuccess;
            }
            return mfaCallbackData.copy(str, l, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getMobileSessionId() {
            return this.mobileSessionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public final MfaCallbackData copy(String event, Long mobileSessionId, boolean isSuccess) {
            return new MfaCallbackData(event, mobileSessionId, isSuccess);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MfaCallbackData)) {
                return false;
            }
            MfaCallbackData mfaCallbackData = (MfaCallbackData) other;
            return Intrinsics.areEqual(this.event, mfaCallbackData.event) && Intrinsics.areEqual(this.mobileSessionId, mfaCallbackData.mobileSessionId) && this.isSuccess == mfaCallbackData.isSuccess;
        }

        public int hashCode() {
            String str = this.event;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.mobileSessionId;
            return ((iHashCode + (l != null ? l.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSuccess);
        }

        public String toString() {
            return "MfaCallbackData(event=" + this.event + ", mobileSessionId=" + this.mobileSessionId + ", isSuccess=" + this.isSuccess + ")";
        }

        public MfaCallbackData(String str, Long l, boolean z) {
            this.event = str;
            this.mobileSessionId = l;
            this.isSuccess = z;
        }

        public final String getEvent() {
            return this.event;
        }

        public final Long getMobileSessionId() {
            return this.mobileSessionId;
        }

        public final boolean isSuccess() {
            return this.isSuccess;
        }
    }
}
