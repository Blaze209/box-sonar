package sdk.pendo.io.a6;

import android.content.Context;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H$R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/a6/a;", "", "", "b", "Lorg/json/JSONObject;", "json", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Z", "mCalled", "", "Ljava/lang/String;", "getPackageName$pendoIO_release", "()Ljava/lang/String;", "setPackageName$pendoIO_release", "(Ljava/lang/String;)V", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "Landroid/content/Context;", "()Landroid/content/Context;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private boolean mCalled;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private String packageName = "";

    private final void b() {
        if (a() == null || !this.mCalled) {
            Context contextA = a();
            Intrinsics.checkNotNull(contextA);
            String packageName = contextA.getApplicationInfo().packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            this.packageName = packageName;
            this.mCalled = true;
        }
    }

    public final void a(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        b();
        b(json);
    }

    protected abstract void b(JSONObject json);

    public final Context a() {
        return PendoInternal.n().getApplicationContext();
    }
}
