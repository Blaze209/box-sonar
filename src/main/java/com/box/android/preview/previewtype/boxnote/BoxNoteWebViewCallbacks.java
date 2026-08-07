package com.box.android.preview.previewtype.boxnote;

import android.webkit.WebView;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNoteWebViewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteWebViewCallbacks;", "", "bridgeDelegate", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteBridgeDelegate;", "onWebViewCreated", "Lkotlin/Function1;", "Landroid/webkit/WebView;", "", "onLoadStarted", "Lkotlin/Function0;", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteBridgeDelegate;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getBridgeDelegate", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteBridgeDelegate;", "getOnWebViewCreated", "()Lkotlin/jvm/functions/Function1;", "getOnLoadStarted", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BoxNoteWebViewCallbacks {
    public static final int $stable = 8;
    private final BoxNoteBridgeDelegate bridgeDelegate;
    private final Function0<Unit> onLoadStarted;
    private final Function1<WebView, Unit> onWebViewCreated;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BoxNoteWebViewCallbacks copy$default(BoxNoteWebViewCallbacks boxNoteWebViewCallbacks, BoxNoteBridgeDelegate boxNoteBridgeDelegate, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            boxNoteBridgeDelegate = boxNoteWebViewCallbacks.bridgeDelegate;
        }
        if ((i & 2) != 0) {
            function1 = boxNoteWebViewCallbacks.onWebViewCreated;
        }
        if ((i & 4) != 0) {
            function0 = boxNoteWebViewCallbacks.onLoadStarted;
        }
        return boxNoteWebViewCallbacks.copy(boxNoteBridgeDelegate, function1, function0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BoxNoteBridgeDelegate getBridgeDelegate() {
        return this.bridgeDelegate;
    }

    public final Function1<WebView, Unit> component2() {
        return this.onWebViewCreated;
    }

    public final Function0<Unit> component3() {
        return this.onLoadStarted;
    }

    public final BoxNoteWebViewCallbacks copy(BoxNoteBridgeDelegate bridgeDelegate, Function1<? super WebView, Unit> onWebViewCreated, Function0<Unit> onLoadStarted) {
        Intrinsics.checkNotNullParameter(bridgeDelegate, "bridgeDelegate");
        Intrinsics.checkNotNullParameter(onLoadStarted, "onLoadStarted");
        return new BoxNoteWebViewCallbacks(bridgeDelegate, onWebViewCreated, onLoadStarted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxNoteWebViewCallbacks)) {
            return false;
        }
        BoxNoteWebViewCallbacks boxNoteWebViewCallbacks = (BoxNoteWebViewCallbacks) other;
        return Intrinsics.areEqual(this.bridgeDelegate, boxNoteWebViewCallbacks.bridgeDelegate) && Intrinsics.areEqual(this.onWebViewCreated, boxNoteWebViewCallbacks.onWebViewCreated) && Intrinsics.areEqual(this.onLoadStarted, boxNoteWebViewCallbacks.onLoadStarted);
    }

    public int hashCode() {
        int iHashCode = this.bridgeDelegate.hashCode() * 31;
        Function1<WebView, Unit> function1 = this.onWebViewCreated;
        return ((iHashCode + (function1 == null ? 0 : function1.hashCode())) * 31) + this.onLoadStarted.hashCode();
    }

    public String toString() {
        return "BoxNoteWebViewCallbacks(bridgeDelegate=" + this.bridgeDelegate + ", onWebViewCreated=" + this.onWebViewCreated + ", onLoadStarted=" + this.onLoadStarted + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BoxNoteWebViewCallbacks(BoxNoteBridgeDelegate bridgeDelegate, Function1<? super WebView, Unit> function1, Function0<Unit> onLoadStarted) {
        Intrinsics.checkNotNullParameter(bridgeDelegate, "bridgeDelegate");
        Intrinsics.checkNotNullParameter(onLoadStarted, "onLoadStarted");
        this.bridgeDelegate = bridgeDelegate;
        this.onWebViewCreated = function1;
        this.onLoadStarted = onLoadStarted;
    }

    public /* synthetic */ BoxNoteWebViewCallbacks(BoxNoteBridgeDelegate boxNoteBridgeDelegate, Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(boxNoteBridgeDelegate, (i & 2) != 0 ? null : function1, function0);
    }

    public final BoxNoteBridgeDelegate getBridgeDelegate() {
        return this.bridgeDelegate;
    }

    public final Function1<WebView, Unit> getOnWebViewCreated() {
        return this.onWebViewCreated;
    }

    public final Function0<Unit> getOnLoadStarted() {
        return this.onLoadStarted;
    }
}
