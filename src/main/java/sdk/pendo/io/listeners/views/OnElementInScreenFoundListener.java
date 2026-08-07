package sdk.pendo.io.listeners.views;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, d2 = {"Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "", "onViewFound", "", "viewAsJson", "Lorg/json/JSONObject;", "viewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface OnElementInScreenFoundListener {
    void onViewFound(JSONObject viewAsJson, WeakReference<View> viewRef);
}
