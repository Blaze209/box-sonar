package com.box.brownfieldApi.featuresNavigator;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.margelo.nitro.boxcontext.ItemStatus;
import com.margelo.nitro.boxcontext.PickerConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012:\u0010\f\u001a6\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u001b\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003JB\u0010\"\u001a6\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0092\u0001\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2<\b\u0002\u0010\f\u001a6\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aRG\u0010\f\u001a6\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/ContentPickerListener;", "", "currentItems", "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "config", "Lcom/margelo/nitro/boxcontext/PickerConfig;", "onResult", "Lkotlin/Function1;", "", "onCancel", "Lkotlin/Function0;", "getItemsStatus", "Lkotlin/Function3;", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "Lkotlin/coroutines/Continuation;", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "<init>", "(Ljava/util/List;Lcom/margelo/nitro/boxcontext/PickerConfig;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "getCurrentItems", "()Ljava/util/List;", "getConfig", "()Lcom/margelo/nitro/boxcontext/PickerConfig;", "getOnResult", "()Lkotlin/jvm/functions/Function1;", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "getGetItemsStatus", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/List;Lcom/margelo/nitro/boxcontext/PickerConfig;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Lcom/box/brownfieldApi/featuresNavigator/ContentPickerListener;", "equals", "", "other", "hashCode", "", "toString", "", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ContentPickerListener {
    public static final int $stable = 8;
    private final PickerConfig config;
    private final List<ItemInfo> currentItems;
    private final Function3<List<ItemIdentifier>, List<ItemIdentifier>, Continuation<? super List<ItemStatus>>, Object> getItemsStatus;
    private final Function0<Unit> onCancel;
    private final Function1<List<ItemInfo>, Unit> onResult;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentPickerListener copy$default(ContentPickerListener contentPickerListener, List list, PickerConfig pickerConfig, Function1 function1, Function0 function0, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = contentPickerListener.currentItems;
        }
        if ((i & 2) != 0) {
            pickerConfig = contentPickerListener.config;
        }
        if ((i & 4) != 0) {
            function1 = contentPickerListener.onResult;
        }
        if ((i & 8) != 0) {
            function0 = contentPickerListener.onCancel;
        }
        if ((i & 16) != 0) {
            function3 = contentPickerListener.getItemsStatus;
        }
        Function3 function4 = function3;
        Function1 function2 = function1;
        return contentPickerListener.copy(list, pickerConfig, function2, function0, function4);
    }

    public final List<ItemInfo> component1() {
        return this.currentItems;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PickerConfig getConfig() {
        return this.config;
    }

    public final Function1<List<ItemInfo>, Unit> component3() {
        return this.onResult;
    }

    public final Function0<Unit> component4() {
        return this.onCancel;
    }

    public final Function3<List<ItemIdentifier>, List<ItemIdentifier>, Continuation<? super List<ItemStatus>>, Object> component5() {
        return this.getItemsStatus;
    }

    public final ContentPickerListener copy(List<ItemInfo> currentItems, PickerConfig config, Function1<? super List<ItemInfo>, Unit> onResult, Function0<Unit> onCancel, Function3<? super List<ItemIdentifier>, ? super List<ItemIdentifier>, ? super Continuation<? super List<ItemStatus>>, ? extends Object> getItemsStatus) {
        Intrinsics.checkNotNullParameter(currentItems, "currentItems");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(getItemsStatus, "getItemsStatus");
        return new ContentPickerListener(currentItems, config, onResult, onCancel, getItemsStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentPickerListener)) {
            return false;
        }
        ContentPickerListener contentPickerListener = (ContentPickerListener) other;
        return Intrinsics.areEqual(this.currentItems, contentPickerListener.currentItems) && Intrinsics.areEqual(this.config, contentPickerListener.config) && Intrinsics.areEqual(this.onResult, contentPickerListener.onResult) && Intrinsics.areEqual(this.onCancel, contentPickerListener.onCancel) && Intrinsics.areEqual(this.getItemsStatus, contentPickerListener.getItemsStatus);
    }

    public int hashCode() {
        return (((((((this.currentItems.hashCode() * 31) + this.config.hashCode()) * 31) + this.onResult.hashCode()) * 31) + this.onCancel.hashCode()) * 31) + this.getItemsStatus.hashCode();
    }

    public String toString() {
        return "ContentPickerListener(currentItems=" + this.currentItems + ", config=" + this.config + ", onResult=" + this.onResult + ", onCancel=" + this.onCancel + ", getItemsStatus=" + this.getItemsStatus + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContentPickerListener(List<ItemInfo> currentItems, PickerConfig config, Function1<? super List<ItemInfo>, Unit> onResult, Function0<Unit> onCancel, Function3<? super List<ItemIdentifier>, ? super List<ItemIdentifier>, ? super Continuation<? super List<ItemStatus>>, ? extends Object> getItemsStatus) {
        Intrinsics.checkNotNullParameter(currentItems, "currentItems");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(getItemsStatus, "getItemsStatus");
        this.currentItems = currentItems;
        this.config = config;
        this.onResult = onResult;
        this.onCancel = onCancel;
        this.getItemsStatus = getItemsStatus;
    }

    public final List<ItemInfo> getCurrentItems() {
        return this.currentItems;
    }

    public final PickerConfig getConfig() {
        return this.config;
    }

    public final Function1<List<ItemInfo>, Unit> getOnResult() {
        return this.onResult;
    }

    public final Function0<Unit> getOnCancel() {
        return this.onCancel;
    }

    public final Function3<List<ItemIdentifier>, List<ItemIdentifier>, Continuation<? super List<ItemStatus>>, Object> getGetItemsStatus() {
        return this.getItemsStatus;
    }
}
