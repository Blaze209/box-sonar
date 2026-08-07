package sdk.pendo.io.actions;

import android.view.View;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "", "retroElement", "Lorg/json/JSONObject;", "viewReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "matchingTrigger", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "(Lorg/json/JSONObject;Ljava/lang/ref/WeakReference;Lsdk/pendo/io/actions/ActivationManager$Trigger;)V", "getMatchingTrigger", "()Lsdk/pendo/io/actions/ActivationManager$Trigger;", "getRetroElement", "()Lorg/json/JSONObject;", "getViewReference", "()Ljava/lang/ref/WeakReference;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ElementInfoAndViewRef {
    private final ActivationManager.Trigger matchingTrigger;
    private final JSONObject retroElement;
    private final WeakReference<View> viewReference;

    public ElementInfoAndViewRef(JSONObject retroElement, WeakReference<View> viewReference, ActivationManager.Trigger matchingTrigger) {
        Intrinsics.checkNotNullParameter(retroElement, "retroElement");
        Intrinsics.checkNotNullParameter(viewReference, "viewReference");
        Intrinsics.checkNotNullParameter(matchingTrigger, "matchingTrigger");
        this.retroElement = retroElement;
        this.viewReference = viewReference;
        this.matchingTrigger = matchingTrigger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ElementInfoAndViewRef copy$default(ElementInfoAndViewRef elementInfoAndViewRef, JSONObject jSONObject, WeakReference weakReference, ActivationManager.Trigger trigger, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = elementInfoAndViewRef.retroElement;
        }
        if ((i & 2) != 0) {
            weakReference = elementInfoAndViewRef.viewReference;
        }
        if ((i & 4) != 0) {
            trigger = elementInfoAndViewRef.matchingTrigger;
        }
        return elementInfoAndViewRef.copy(jSONObject, weakReference, trigger);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JSONObject getRetroElement() {
        return this.retroElement;
    }

    public final WeakReference<View> component2() {
        return this.viewReference;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ActivationManager.Trigger getMatchingTrigger() {
        return this.matchingTrigger;
    }

    public final ElementInfoAndViewRef copy(JSONObject retroElement, WeakReference<View> viewReference, ActivationManager.Trigger matchingTrigger) {
        Intrinsics.checkNotNullParameter(retroElement, "retroElement");
        Intrinsics.checkNotNullParameter(viewReference, "viewReference");
        Intrinsics.checkNotNullParameter(matchingTrigger, "matchingTrigger");
        return new ElementInfoAndViewRef(retroElement, viewReference, matchingTrigger);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ElementInfoAndViewRef)) {
            return false;
        }
        ElementInfoAndViewRef elementInfoAndViewRef = (ElementInfoAndViewRef) other;
        return Intrinsics.areEqual(this.retroElement, elementInfoAndViewRef.retroElement) && Intrinsics.areEqual(this.viewReference, elementInfoAndViewRef.viewReference) && Intrinsics.areEqual(this.matchingTrigger, elementInfoAndViewRef.matchingTrigger);
    }

    public final ActivationManager.Trigger getMatchingTrigger() {
        return this.matchingTrigger;
    }

    public final JSONObject getRetroElement() {
        return this.retroElement;
    }

    public final WeakReference<View> getViewReference() {
        return this.viewReference;
    }

    public int hashCode() {
        return (((this.retroElement.hashCode() * 31) + this.viewReference.hashCode()) * 31) + this.matchingTrigger.hashCode();
    }

    public String toString() {
        return "ElementInfoAndViewRef(retroElement=" + this.retroElement + ", viewReference=" + this.viewReference + ", matchingTrigger=" + this.matchingTrigger + ")";
    }
}
