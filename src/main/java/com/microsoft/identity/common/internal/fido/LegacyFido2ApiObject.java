package com.microsoft.identity.common.internal.fido;

import android.app.PendingIntent;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.android.gms.common.internal.BaseGmsClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LegacyFido2ApiObject.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ$\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J$\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\rHÆ\u0003J]\u0010\u0017\u001a\u00020\u00002#\b\u0002\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R,\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/LegacyFido2ApiObject;", "", "assertionCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "", "errorCallback", "Lcom/microsoft/identity/common/internal/fido/LegacyFido2ApiException;", "exception", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroid/app/PendingIntent;)V", "getAssertionCallback", "()Lkotlin/jvm/functions/Function1;", "getErrorCallback", "getPendingIntent", "()Landroid/app/PendingIntent;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LegacyFido2ApiObject {
    private final Function1<String, Unit> assertionCallback;
    private final Function1<LegacyFido2ApiException, Unit> errorCallback;
    private final PendingIntent pendingIntent;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LegacyFido2ApiObject copy$default(LegacyFido2ApiObject legacyFido2ApiObject, Function1 function1, Function1 function2, PendingIntent pendingIntent, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = legacyFido2ApiObject.assertionCallback;
        }
        if ((i & 2) != 0) {
            function2 = legacyFido2ApiObject.errorCallback;
        }
        if ((i & 4) != 0) {
            pendingIntent = legacyFido2ApiObject.pendingIntent;
        }
        return legacyFido2ApiObject.copy(function1, function2, pendingIntent);
    }

    public final Function1<String, Unit> component1() {
        return this.assertionCallback;
    }

    public final Function1<LegacyFido2ApiException, Unit> component2() {
        return this.errorCallback;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final LegacyFido2ApiObject copy(Function1<? super String, Unit> assertionCallback, Function1<? super LegacyFido2ApiException, Unit> errorCallback, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(assertionCallback, "assertionCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        return new LegacyFido2ApiObject(assertionCallback, errorCallback, pendingIntent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyFido2ApiObject)) {
            return false;
        }
        LegacyFido2ApiObject legacyFido2ApiObject = (LegacyFido2ApiObject) other;
        return Intrinsics.areEqual(this.assertionCallback, legacyFido2ApiObject.assertionCallback) && Intrinsics.areEqual(this.errorCallback, legacyFido2ApiObject.errorCallback) && Intrinsics.areEqual(this.pendingIntent, legacyFido2ApiObject.pendingIntent);
    }

    public int hashCode() {
        return (((this.assertionCallback.hashCode() * 31) + this.errorCallback.hashCode()) * 31) + this.pendingIntent.hashCode();
    }

    public String toString() {
        return "LegacyFido2ApiObject(assertionCallback=" + this.assertionCallback + ", errorCallback=" + this.errorCallback + ", pendingIntent=" + this.pendingIntent + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LegacyFido2ApiObject(Function1<? super String, Unit> assertionCallback, Function1<? super LegacyFido2ApiException, Unit> errorCallback, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(assertionCallback, "assertionCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        this.assertionCallback = assertionCallback;
        this.errorCallback = errorCallback;
        this.pendingIntent = pendingIntent;
    }

    public final Function1<String, Unit> getAssertionCallback() {
        return this.assertionCallback;
    }

    public final Function1<LegacyFido2ApiException, Unit> getErrorCallback() {
        return this.errorCallback;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }
}
