package com.box.android.domain.analytics;

import android.os.Bundle;
import com.box.android.common.utilities.ApplicationProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.analytics.Analytics;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAnalytics.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/analytics/BoxAnalytics;", "", "<init>", "()V", "CATEGORY", "", "LABEL", "VALUE", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics$delegate", "Lkotlin/Lazy;", "trackEvent", "", BoxAnalytics.CATEGORY, Analytics.Data.ACTION, "label", "value", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAnalytics {
    private static final String CATEGORY = "category";
    private static final String LABEL = "label";
    private static final String VALUE = "value";
    public static final BoxAnalytics INSTANCE = new BoxAnalytics();

    /* JADX INFO: renamed from: firebaseAnalytics$delegate, reason: from kotlin metadata */
    private static final Lazy firebaseAnalytics = LazyKt.lazy(new Function0() { // from class: com.box.android.domain.analytics.BoxAnalytics$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BoxAnalytics.firebaseAnalytics_delegate$lambda$0();
        }
    });

    public final void trackEvent(String category, String action) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(action, "action");
        trackEvent$default(this, category, action, null, null, 12, null);
    }

    public final void trackEvent(String category, String action, String str) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(action, "action");
        trackEvent$default(this, category, action, str, null, 8, null);
    }

    private BoxAnalytics() {
    }

    private final FirebaseAnalytics getFirebaseAnalytics() {
        return (FirebaseAnalytics) firebaseAnalytics.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseAnalytics firebaseAnalytics_delegate$lambda$0() {
        FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(ApplicationProvider.getApplication().getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
        return firebaseAnalytics2;
    }

    public final void trackEvent(String category, String action, String label, Integer value) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(action, "action");
        trackEvent(category, action, label, value != null ? Long.valueOf(value.intValue()) : null);
    }

    public static /* synthetic */ void trackEvent$default(BoxAnalytics boxAnalytics, String str, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        boxAnalytics.trackEvent(str, str2, str3, l);
    }

    public final void trackEvent(String category, String action, String label, Long value) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(action, "action");
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY, category);
        if (label != null) {
            bundle.putString("label", label);
        }
        if (value != null) {
            bundle.putLong("value", value.longValue());
        }
        getFirebaseAnalytics().logEvent(action, bundle);
    }
}
