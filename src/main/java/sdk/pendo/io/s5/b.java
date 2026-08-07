package sdk.pendo.io.s5;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.s7.e1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/s5/b;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "event", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s5/c;", "observer", "", "b", "", "dispatchTouchEvent", "", "Ljava/util/List;", "observers", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<c> observers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.observers = new ArrayList();
        setBackgroundColor(0);
        setFocusable(false);
        setClickable(false);
    }

    public final void a(c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.observers.contains(observer)) {
            return;
        }
        this.observers.add(observer);
    }

    public final void b(c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean z = false;
        if (event == null) {
            return false;
        }
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return false;
        }
        MotionEvent motionEventA = a(event);
        if (motionEventA != null) {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(motionEventA);
            }
        }
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (z && childAt.getWidth() > 0 && childAt.getHeight() > 0 && childAt.dispatchTouchEvent(event)) {
                break;
            }
            if (childAt == this) {
                z = true;
            }
        }
        if (motionEventA != null) {
            Iterator<T> it2 = this.observers.iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).a(motionEventA);
            }
        }
        return true;
    }

    private final MotionEvent a(MotionEvent event) {
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        Boolean boolA = e1.a(motionEventObtain);
        Intrinsics.checkNotNullExpressionValue(boolA, "isValidMotionEvent(...)");
        if (boolA.booleanValue()) {
            return motionEventObtain;
        }
        return null;
    }
}
