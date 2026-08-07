package com.box.brownfieldApi.featuresNavigator;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/PreviewRequest;", "", "item", "Lcom/margelo/nitro/boxcontext/ItemInfo;", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "", "<init>", "(Lcom/margelo/nitro/boxcontext/ItemInfo;Lkotlin/jvm/functions/Function0;)V", "getItem", "()Lcom/margelo/nitro/boxcontext/ItemInfo;", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PreviewRequest {
    public static final int $stable = 8;
    private final ItemInfo item;
    private final Function0<Unit> onDismiss;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreviewRequest copy$default(PreviewRequest previewRequest, ItemInfo itemInfo, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            itemInfo = previewRequest.item;
        }
        if ((i & 2) != 0) {
            function0 = previewRequest.onDismiss;
        }
        return previewRequest.copy(itemInfo, function0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemInfo getItem() {
        return this.item;
    }

    public final Function0<Unit> component2() {
        return this.onDismiss;
    }

    public final PreviewRequest copy(ItemInfo item, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        return new PreviewRequest(item, onDismiss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewRequest)) {
            return false;
        }
        PreviewRequest previewRequest = (PreviewRequest) other;
        return Intrinsics.areEqual(this.item, previewRequest.item) && Intrinsics.areEqual(this.onDismiss, previewRequest.onDismiss);
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + this.onDismiss.hashCode();
    }

    public String toString() {
        return "PreviewRequest(item=" + this.item + ", onDismiss=" + this.onDismiss + ")";
    }

    public PreviewRequest(ItemInfo item, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        this.item = item;
        this.onDismiss = onDismiss;
    }

    public final ItemInfo getItem() {
        return this.item;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }
}
