package com.box.brownfieldApi.featuresNavigator;

import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.margelo.nitro.boxcontext.ItemStatus;
import com.margelo.nitro.boxcontext.PickerConfig;
import com.margelo.nitro.boxcontext.providers.HostNavigationDelegate;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: ContentPickerNavigationDelegate.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\tJf\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2:\u0010\u000f\u001a6\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0010H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/ContentPickerNavigationDelegate;", "Lcom/margelo/nitro/boxcontext/providers/HostNavigationDelegate;", "showContentPicker", "Lkotlin/Function1;", "Lcom/box/brownfieldApi/featuresNavigator/ContentPickerListener;", "", "onShowPreview", "Lcom/box/brownfieldApi/featuresNavigator/PreviewRequest;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "currentItems", "config", "Lcom/margelo/nitro/boxcontext/PickerConfig;", "getItemsStatus", "Lkotlin/Function3;", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "Lkotlin/coroutines/Continuation;", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "", "(Ljava/util/List;Lcom/margelo/nitro/boxcontext/PickerConfig;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showPreview", "item", "(Lcom/margelo/nitro/boxcontext/ItemInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentPickerNavigationDelegate implements HostNavigationDelegate {
    public static final int $stable = 0;
    private final Function1<PreviewRequest, Unit> onShowPreview;
    private final Function1<ContentPickerListener, Unit> showContentPicker;

    /* JADX WARN: Multi-variable type inference failed */
    public ContentPickerNavigationDelegate(Function1<? super ContentPickerListener, Unit> showContentPicker, Function1<? super PreviewRequest, Unit> onShowPreview) {
        Intrinsics.checkNotNullParameter(showContentPicker, "showContentPicker");
        Intrinsics.checkNotNullParameter(onShowPreview, "onShowPreview");
        this.showContentPicker = showContentPicker;
        this.onShowPreview = onShowPreview;
    }

    @Override // com.margelo.nitro.boxcontext.providers.HostNavigationDelegate
    public Object showContentPicker(List<ItemInfo> list, PickerConfig pickerConfig, Function3<? super List<ItemIdentifier>, ? super List<ItemIdentifier>, ? super Continuation<? super List<ItemStatus>>, ? extends Object> function3, Continuation<? super List<ItemInfo>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.showContentPicker.invoke(new ContentPickerListener(list, pickerConfig, new Function1<List<? extends ItemInfo>, Unit>() { // from class: com.box.brownfieldApi.featuresNavigator.ContentPickerNavigationDelegate$showContentPicker$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ItemInfo> list2) {
                invoke2((List<ItemInfo>) list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ItemInfo> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                CancellableContinuation<List<ItemInfo>> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m14780constructorimpl(items));
            }
        }, new Function0<Unit>() { // from class: com.box.brownfieldApi.featuresNavigator.ContentPickerNavigationDelegate$showContentPicker$2$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation<List<ItemInfo>> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(new CancellationException("Content picker cancelled"))));
            }
        }, function3));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.margelo.nitro.boxcontext.providers.HostNavigationDelegate
    public Object showPreview(ItemInfo itemInfo, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.onShowPreview.invoke(new PreviewRequest(itemInfo, new Function0<Unit>() { // from class: com.box.brownfieldApi.featuresNavigator.ContentPickerNavigationDelegate$showPreview$2$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m14780constructorimpl(Unit.INSTANCE));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
