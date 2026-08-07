package sdk.pendo.io.s7;

import android.app.Activity;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J8\u0010\u0007\u001a\u0004\u0018\u00010\u00122\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/s7/s;", "", "Landroid/app/Activity;", "activity", "", "ignoreDialogs", "Lsdk/pendo/io/s7/e1$a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "view", "Lorg/json/JSONObject;", "", "rootViews", "isForCapture", "Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "onViewFoundListener", "", "currentScreenId", "Lorg/json/JSONArray;", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface s {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ e1.a a(s sVar, Activity activity, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActivityMostTopRootViewData");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return sVar.a(activity, z);
        }

        public static /* synthetic */ JSONArray a(s sVar, Set set, boolean z, OnElementInScreenFoundListener onElementInScreenFoundListener, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewTree");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                onElementInScreenFoundListener = null;
            }
            return sVar.a(set, z, onElementInScreenFoundListener, str);
        }
    }

    JSONArray a(Set<? extends View> rootViews, boolean isForCapture, OnElementInScreenFoundListener onViewFoundListener, String currentScreenId);

    JSONObject a(View view);

    e1.a a(Activity activity, boolean ignoreDialogs);
}
