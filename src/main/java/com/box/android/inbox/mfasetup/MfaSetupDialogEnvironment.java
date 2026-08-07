package com.box.android.inbox.mfasetup;

import android.content.Context;
import com.box.android.common.utilities.Clock;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogEnvironment;", "", "mfaSetupAnalytics", "Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;", "mfaSetupUrlBuilder", "Lcom/box/android/inbox/mfasetup/MfaSetupUrlBuilder;", "context", "Landroid/content/Context;", "clock", "Lcom/box/android/common/utilities/Clock;", "<init>", "(Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;Lcom/box/android/inbox/mfasetup/MfaSetupUrlBuilder;Landroid/content/Context;Lcom/box/android/common/utilities/Clock;)V", "getMfaSetupAnalytics", "()Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;", "getMfaSetupUrlBuilder", "()Lcom/box/android/inbox/mfasetup/MfaSetupUrlBuilder;", "getContext", "()Landroid/content/Context;", "getClock", "()Lcom/box/android/common/utilities/Clock;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MfaSetupDialogEnvironment {
    public static final int $stable = 8;
    private final Clock clock;
    private final Context context;
    private final MfaSetupAnalytics mfaSetupAnalytics;
    private final MfaSetupUrlBuilder mfaSetupUrlBuilder;

    @Inject
    public MfaSetupDialogEnvironment(MfaSetupAnalytics mfaSetupAnalytics, MfaSetupUrlBuilder mfaSetupUrlBuilder, @ApplicationContext Context context, Clock clock) {
        Intrinsics.checkNotNullParameter(mfaSetupAnalytics, "mfaSetupAnalytics");
        Intrinsics.checkNotNullParameter(mfaSetupUrlBuilder, "mfaSetupUrlBuilder");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.mfaSetupAnalytics = mfaSetupAnalytics;
        this.mfaSetupUrlBuilder = mfaSetupUrlBuilder;
        this.context = context;
        this.clock = clock;
    }

    public final MfaSetupAnalytics getMfaSetupAnalytics() {
        return this.mfaSetupAnalytics;
    }

    public final MfaSetupUrlBuilder getMfaSetupUrlBuilder() {
        return this.mfaSetupUrlBuilder;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Clock getClock() {
        return this.clock;
    }
}
