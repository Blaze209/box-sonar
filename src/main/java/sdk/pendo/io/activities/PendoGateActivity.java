package sdk.pendo.io.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.k3.g;
import sdk.pendo.io.k6.a;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q3.h;
import sdk.pendo.io.q3.j;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\r8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/activities/PendoGateActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "e", "d", "", "intentDataString", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "c", "Landroid/content/Intent;", "()Landroid/content/Intent;", "intentToStart", "applicationIntent", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class PendoGateActivity extends MAMActivity {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "token", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;)Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<GetAuthToken.GetAuthTokenResponse, String> {
        public static final b a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(GetAuthToken.GetAuthTokenResponse token) {
            Intrinsics.checkNotNullParameter(token, "token");
            return token.accessToken;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "accessToken", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class c extends Lambda implements Function1<String, Boolean> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            return Boolean.valueOf(true ^ (str == null || StringsKt.isBlank(str)));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;)Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
    static final class d extends Lambda implements Function1<String, String> {
        final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(1);
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            return this.a;
        }
    }

    public final void a(String intentDataString) {
        Intrinsics.checkNotNullParameter(intentDataString, "intentDataString");
        PendoLogger.d("PendoGateActivity", "trying to connect to socket...");
        sdk.pendo.io.p6.b.b(intentDataString);
        a.a.a();
    }

    public final Intent b() {
        Intent intent = null;
        if (PendoInternal.o.get()) {
            Activity activityA = sdk.pendo.io.d6.c.h().a();
            if (activityA == null) {
                activityA = sdk.pendo.io.d6.c.h().i();
            }
            if ((activityA != null ? activityA.getIntent() : null) != null) {
                intent = activityA.getIntent();
            } else {
                Log.i("PendoGateActivity", "There is no last known app activity");
            }
        } else {
            Log.w("PendoGateActivity", "The Setup API needs to be called during app launch. Failing to do so can lead to unexpected behavior with analytics, guides and pairing mode.");
        }
        return intent == null ? a() : intent;
    }

    public final void c() {
        Intent intentB = b();
        if (intentB != null) {
            startActivity(intentB);
        } else {
            Log.w("PendoGateActivity", "Launch intent is null can't start activity");
        }
    }

    public final void d() {
        Uri data = getIntent().getData();
        Log.d("PendoGateActivity", "Launched with schemeId: " + (data != null ? data.getScheme() : null));
        String dataString = getIntent().getDataString();
        if (!Intrinsics.areEqual(data != null ? data.getHost() : null, "pairing") || dataString == null) {
            Log.w("PendoGateActivity", "Invalid intent data. Pairing process aborted.");
        } else {
            b(dataString);
        }
    }

    public final void e() {
        d();
        c();
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        Log.d("PendoGateActivity", "onCreate");
        e();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public final Intent a() {
        return MAMPackageManagement.getLaunchIntentForPackage(getPackageManager(), getPackageName());
    }

    public final void b(String intentDataString) {
        Intrinsics.checkNotNullParameter(intentDataString, "intentDataString");
        g<GetAuthToken.GetAuthTokenResponse> gVarF = sdk.pendo.io.network.interfaces.a.c().f();
        final b bVar = b.a;
        g<R> gVarA = gVarF.a(new h() { // from class: sdk.pendo.io.activities.PendoGateActivity$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.h
            public final Object apply(Object obj) {
                return PendoGateActivity.a(bVar, obj);
            }
        });
        final c cVar = c.a;
        g gVarA2 = gVarA.a((j<? super R>) new j() { // from class: sdk.pendo.io.activities.PendoGateActivity$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return PendoGateActivity.b(cVar, obj);
            }
        });
        final d dVar = new d(intentDataString);
        gVarA2.a(new h() { // from class: sdk.pendo.io.activities.PendoGateActivity$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.h
            public final Object apply(Object obj) {
                return PendoGateActivity.c(dVar, obj);
            }
        }).a(sdk.pendo.io.t6.c.a(new e() { // from class: sdk.pendo.io.activities.PendoGateActivity$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGateActivity.a(this.f$0, (String) obj);
            }
        }, "PendoGateActivity start pairingProcess access token observer"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PendoGateActivity this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(str);
        this$0.a(str);
    }
}
