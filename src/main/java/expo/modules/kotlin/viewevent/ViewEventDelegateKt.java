package expo.modules.kotlin.viewevent;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ViewEventDelegate.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a5\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0086\n\u001aQ\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000f21\b\n\u0010\u0010\u001a+\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\n\u0012\u0004\u0012\u0002H\u0001\u0018\u0001`\u0011H\u0086\bø\u0001\u0000\u001an\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u00120\t*\u00020\u000f2I\b\u0002\u0010\u0010\u001aC\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u0012\u0018\u0001`\u0011H\u0007¢\u0006\u0002\b\u0014*F\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\"\u001d\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00022\u001d\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"CoalescingKey", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "event", "", "getValue", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "EventDispatcher", "Landroid/view/View;", "coalescingKey", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "", "", "MapEventDispatcher", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ViewEventDelegateKt {
    public static final <T> ViewEventCallback<T> getValue(ViewEventDelegate<T> viewEventDelegate, Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(viewEventDelegate, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return viewEventDelegate.getValue(property);
    }

    public static /* synthetic */ ViewEventDelegate EventDispatcher$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new ViewEventDelegate(view, function1);
    }

    public static final /* synthetic */ <T> ViewEventDelegate<T> EventDispatcher(View view, Function1<? super T, Short> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new ViewEventDelegate<>(view, function1);
    }

    public static /* synthetic */ ViewEventDelegate MapEventDispatcher$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return MapEventDispatcher(view, function1);
    }

    public static final ViewEventDelegate<Map<String, Object>> MapEventDispatcher(View view, Function1<? super Map<String, ? extends Object>, Short> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new ViewEventDelegate<>(view, function1);
    }
}
