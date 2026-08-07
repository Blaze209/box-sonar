package sdk.pendo.io.views.custom;

import android.R;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.o6.a;
import sdk.pendo.io.s7.h0;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/views/custom/PendoBackCapture;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKeyUp", "sendBackButtonPressedAnalytic", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoBackCapture extends FrameLayout {
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoBackCapture(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "PendoBackCapture";
        setFocusable(true);
        setFocusableInTouchMode(true);
        setImportantForAccessibility(2);
        try {
            setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));
        } catch (Exception e) {
            PendoLogger.w(this.TAG + " Failed to set background color to PendoBackCapture " + e, new Object[0]);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode != 4) {
            return false;
        }
        event.startTracking();
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isCanceled()) {
            return false;
        }
        if (keyCode == 4) {
            sendBackButtonPressedAnalytic();
        }
        if (keyCode == 24 && a.d().f()) {
            h0.b();
        }
        return false;
    }

    public final void sendBackButtonPressedAnalytic() throws JSONException {
        if (PlatformStateManager.INSTANCE.isTrackEventSolutionOnly()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IdentificationData.PREDICATE, "[PendoBackButton]");
        sdk.pendo.io.w6.a.a.a(jSONObject, false);
    }
}
