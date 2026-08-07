package sdk.pendo.io.s7;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/s7/b0;", "", "Landroid/view/MotionEvent;", "event", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface b0 {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        public static void a(b0 b0Var) {
        }

        public static boolean a(b0 b0Var, MotionEvent motionEvent) {
            VisualGuideBase visualGuideBase;
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            try {
                List<VisualGuideBase> showingGuides = VisualGuidesManager.getInstance().getShowingGuides();
                if (showingGuides == null || showingGuides.isEmpty() || (visualGuideBase = showingGuides.get(0)) == null) {
                    return false;
                }
                ViewGroup container = visualGuideBase.getContainer();
                PendoFloatingVisualGuideView pendoFloatingVisualGuideView = container instanceof PendoFloatingVisualGuideView ? (PendoFloatingVisualGuideView) container : null;
                if (pendoFloatingVisualGuideView == null) {
                    return false;
                }
                return pendoFloatingVisualGuideView.consumeTouchEventIfOnPendoView(motionEvent);
            } catch (Exception e) {
                PendoLogger.d("MotionEventHandler", "isClickOnBannerOrTooltipOrBackdrop exception, " + e);
                return false;
            }
        }
    }

    void a();

    boolean a(MotionEvent event);
}
