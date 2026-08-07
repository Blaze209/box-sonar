package com.box.brownfieldApi.featuresNavigator;

import android.content.Intent;
import android.os.Bundle;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsInitialContext.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0002\b\rJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/HubDetailsInitialContext;", "", HubDetailsInitialContext.HUB_ID_KEY, "", "<init>", "(Ljava/lang/String;)V", "getHubId", "()Ljava/lang/String;", "toLaunchOptions", "Landroid/os/Bundle;", "writeTo", "", "bundle", "writeTo$brownfieldApi_release", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HubDetailsInitialContext {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String HUB_ID_KEY = "hubId";
    private final String hubId;

    /* JADX WARN: Multi-variable type inference failed */
    public HubDetailsInitialContext() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HubDetailsInitialContext copy$default(HubDetailsInitialContext hubDetailsInitialContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubDetailsInitialContext.hubId;
        }
        return hubDetailsInitialContext.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHubId() {
        return this.hubId;
    }

    public final HubDetailsInitialContext copy(String hubId) {
        return new HubDetailsInitialContext(hubId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HubDetailsInitialContext) && Intrinsics.areEqual(this.hubId, ((HubDetailsInitialContext) other).hubId);
    }

    public int hashCode() {
        String str = this.hubId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "HubDetailsInitialContext(hubId=" + this.hubId + ")";
    }

    public HubDetailsInitialContext(String str) {
        this.hubId = str;
    }

    public /* synthetic */ HubDetailsInitialContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getHubId() {
        return this.hubId;
    }

    public final Bundle toLaunchOptions() {
        Bundle bundle = new Bundle();
        writeTo$brownfieldApi_release(bundle);
        return bundle;
    }

    public final void writeTo$brownfieldApi_release(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String str = this.hubId;
        if (str != null) {
            bundle.putString(HUB_ID_KEY, str);
        }
    }

    /* JADX INFO: compiled from: HubDetailsInitialContext.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/HubDetailsInitialContext$Companion;", "", "<init>", "()V", "HUB_ID_KEY", "", "fromIntent", "Lcom/box/brownfieldApi/featuresNavigator/HubDetailsInitialContext;", "intent", "Landroid/content/Intent;", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HubDetailsInitialContext fromIntent(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return new HubDetailsInitialContext(intent.getStringExtra(HubDetailsInitialContext.HUB_ID_KEY));
        }
    }
}
