package sdk.pendo.io.e8;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoBackCapture;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016R&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/e8/b;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View;", "oldFocus", "newFocus", "", "onGlobalFocusChanged", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/views/custom/PendoBackCapture;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/ref/WeakReference;", "getPendoBackCaptureReference", "()Ljava/lang/ref/WeakReference;", "getPendoBackCaptureReference$annotations", "()V", "pendoBackCaptureReference", "", "b", "Ljava/lang/String;", "TAG", "pendoBackCapture", "<init>", "(Lsdk/pendo/io/views/custom/PendoBackCapture;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final WeakReference<PendoBackCapture> pendoBackCaptureReference;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String TAG;

    public b(PendoBackCapture pendoBackCapture) {
        Intrinsics.checkNotNullParameter(pendoBackCapture, "pendoBackCapture");
        this.pendoBackCaptureReference = new WeakReference<>(pendoBackCapture);
        this.TAG = "PendoOnGlobalFocusChangeListener";
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        if (oldFocus != null) {
            sdk.pendo.io.d8.b.c(oldFocus);
        }
        PendoLogger.d(this.TAG + " oldFocus: " + oldFocus + " newFocus: " + newFocus, new Object[0]);
        sdk.pendo.io.d8.b.a(newFocus, this.pendoBackCaptureReference.get());
    }
}
