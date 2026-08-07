package sdk.pendo.io.v6;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.IActivationManager;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.b0;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.e1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\bB%\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007J!\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006#"}, d2 = {"Lsdk/pendo/io/v6/c;", "Lsdk/pendo/io/s7/b0;", "Lsdk/pendo/io/v6/a;", "composeElementClicked", "", "rawX", "rawY", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "x", "y", "Landroid/view/MotionEvent;", "event", "", "", "allElementsList", "b", "c", "(FF)Ljava/lang/Boolean;", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "shouldIgnoreLowCodeLogic", "Z", "includeFeatureClickTexts", "Lsdk/pendo/io/v6/e;", "Lsdk/pendo/io/v6/e;", "screenManager", "d", "Ljava/util/List;", "clickableElements", "e", "nonClickableElements", "<init>", "(Lkotlin/jvm/functions/Function0;ZLsdk/pendo/io/v6/e;)V", "f", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c implements b0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function0<Boolean> shouldIgnoreLowCodeLogic;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean includeFeatureClickTexts;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final e screenManager;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private List<a> clickableElements;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private List<a> nonClickableElements;

    public c(Function0<Boolean> shouldIgnoreLowCodeLogic, boolean z, e screenManager) {
        Intrinsics.checkNotNullParameter(shouldIgnoreLowCodeLogic, "shouldIgnoreLowCodeLogic");
        Intrinsics.checkNotNullParameter(screenManager, "screenManager");
        this.shouldIgnoreLowCodeLogic = shouldIgnoreLowCodeLogic;
        this.includeFeatureClickTexts = z;
        this.screenManager = screenManager;
        this.clickableElements = CollectionsKt.emptyList();
        this.nonClickableElements = CollectionsKt.emptyList();
    }

    private final void a(a composeElementClicked, float rawX, float rawY) throws JSONException {
        JSONObject jSONObjectA = b1.a.a(composeElementClicked.a(false, this.includeFeatureClickTexts).toJSON());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", (int) rawX);
        jSONObject.put("y", (int) rawY);
        jSONObjectA.put("tapLocation", jSONObject);
        sdk.pendo.io.w6.a.a.a(jSONObjectA, false);
        IActivationManager.DefaultImpls.handleClick$default(ActivationManager.INSTANCE, jSONObjectA, null, 2, null);
    }

    public final a b(float x, float y) {
        return a(x, y);
    }

    public final Boolean c(float rawX, float rawY) {
        Collection<WeakReference<ViewGroup>> collectionValues = this.screenManager.e().values();
        ArrayList<ViewGroup> arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = (ViewGroup) ((WeakReference) it.next()).get();
            if (viewGroup != null) {
                arrayList.add(viewGroup);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int i = (int) rawX;
        int i2 = (int) rawY;
        for (ViewGroup viewGroup2 : arrayList) {
            int[] iArr = new int[2];
            viewGroup2.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int width = viewGroup2.getWidth() + i3;
            int height = viewGroup2.getHeight() + i4;
            if (i3 <= i && i <= width && i4 <= i2 && i2 <= height) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private final a a(float x, float y) {
        Object next;
        Object next2;
        Iterator<T> it = this.clickableElements.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!d.b((a) next, x, y));
        a aVar = (a) next;
        if (aVar != null) {
            return aVar;
        }
        Iterator<T> it2 = this.nonClickableElements.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!d.b((a) next2, x, y));
        a aVar2 = (a) next2;
        if (aVar2 != null) {
            return aVar2;
        }
        PendoLogger.d("ComposeTouchEventHandler", "getClickEventCandidate -> no element was found in the element list for x - " + x + ", y - " + y);
        return null;
    }

    public boolean b(MotionEvent motionEvent) {
        return b0.a.a(this, motionEvent);
    }

    @Override // sdk.pendo.io.s7.b0
    public boolean a(MotionEvent event) {
        if (event != null) {
            try {
                if (!e1.a(event).booleanValue()) {
                    PendoLogger.i("ComposeTouchEventHandler", "Skipping touchEvent with invalid pointer index: actionIndex=" + event.getActionIndex() + " pointerCount=" + event.getPointerCount());
                    return true;
                }
                float rawX = event.getRawX();
                float rawY = event.getRawY();
                PendoLogger.d("ComposeTouchEventHandler", "accept touchEvent: x=" + rawX + ", y=" + rawY);
                if (this.shouldIgnoreLowCodeLogic.invoke().booleanValue()) {
                    PendoLogger.d("ComposeTouchEventHandler", "ignoring low code logic for touch event x=" + rawX + ", y=" + rawY);
                    return true;
                }
                if (Intrinsics.areEqual(c(rawX, rawY), Boolean.FALSE)) {
                    PendoLogger.i("ComposeTouchEventHandler", "Point is not inside compose root");
                    return false;
                }
                if (b(event)) {
                    PendoLogger.d("ComposeTouchEventHandler", "guide is visible and click should not be handled for touch event x=" + rawX + ", y=" + rawY);
                    return true;
                }
                a aVarB = b(rawX, rawY);
                if (aVarB != null) {
                    PendoLogger.d("ComposeTouchEventHandler", "send click analytics and activate guides for touch event x=" + rawX + ", y=" + rawY);
                    a(aVarB, rawX, rawY);
                    return true;
                }
            } catch (Throwable th) {
                PendoLogger.i("ComposeTouchEventHandler", "Skipping touchEvent because of exception:" + th.getMessage());
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.s7.b0
    public void a() {
        this.screenManager.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_SCROLL);
    }

    public final void a(List<a> allElementsList) {
        Intrinsics.checkNotNullParameter(allElementsList, "allElementsList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : allElementsList) {
            if (((a) obj).getClickable()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List<a> list = (List) pair.component1();
        List<a> list2 = (List) pair.component2();
        this.clickableElements = list;
        this.nonClickableElements = list2;
    }
}
