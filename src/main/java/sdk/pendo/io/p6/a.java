package sdk.pendo.io.p6;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.R;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/p6/a;", "", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "I", "AUTO_DISMISS_TIMEOUT", "", "Ljava/lang/String;", "ERROR_TAG", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int AUTO_DISMISS_TIMEOUT = 5000;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String ERROR_TAG = "error";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        FloatingListenerButton.clearDialogFragment();
    }

    public final void a() {
        Activity activityA;
        FloatingListenerButton.clearDialogFragment();
        sdk.pendo.io.x5.a aVarA = sdk.pendo.io.x5.a.a(R.layout.pnd_capture_fail, R.id.imageViewFail);
        c cVarH = c.h();
        aVarA.show((cVarH == null || (activityA = cVarH.a()) == null) ? null : activityA.getFragmentManager(), this.ERROR_TAG);
    }

    public final void b() {
        Activity activityA = c.h().a();
        if (activityA == null) {
            FloatingListenerButton.clearDialogFragment();
        } else {
            final sdk.pendo.io.x5.b progressDialog = FloatingListenerButton.getProgressDialog();
            activityA.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.p6.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(progressDialog, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(sdk.pendo.io.x5.b bVar, a this$0) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar == null || (dialog = bVar.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        Dialog dialog2 = bVar.getDialog();
        dialog2.setContentView(R.layout.pnd_capture_successful);
        new Handler().postDelayed(new Runnable() { // from class: sdk.pendo.io.p6.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                a.c();
            }
        }, this$0.AUTO_DISMISS_TIMEOUT);
        View viewFindViewById = dialog2.findViewById(R.id.imageViewSuccess);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
        Object parent = ((ImageView) viewFindViewById).getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setOnClickListener(new View.OnClickListener() { // from class: sdk.pendo.io.p6.a$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.a(view);
            }
        });
        dialog2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        FloatingListenerButton.clearDialogFragment();
    }
}
