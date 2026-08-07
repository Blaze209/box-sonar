package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.HostNavigationDelegate;
import com.margelo.nitro.boxcontext.providers.HostNavigationRegistry;
import com.margelo.nitro.core.Promise;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostNavigationService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0087\u0001\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\f2N\u0010\r\u001aJ\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00050\u000eH\u0016¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¨\u0006\u0019"}, d2 = {"Lcom/margelo/nitro/boxcontext/HostNavigationService;", "Lcom/margelo/nitro/boxcontext/HybridHostNavigationServiceSpec;", "<init>", "()V", "openContentPicker", "Lcom/margelo/nitro/core/Promise;", "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "recipientId", "", "currentItems", "config", "Lcom/margelo/nitro/boxcontext/PickerConfig;", "getItemsStatus", "Lkotlin/Function2;", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "Lkotlin/ParameterName;", "name", "selectedItemIds", "itemIds", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "(Ljava/lang/String;[Lcom/margelo/nitro/boxcontext/ItemInfo;Lcom/margelo/nitro/boxcontext/PickerConfig;Lkotlin/jvm/functions/Function2;)Lcom/margelo/nitro/core/Promise;", "openPreview", "", "item", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostNavigationService extends HybridHostNavigationServiceSpec {

    /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.HostNavigationService$openContentPicker$1, reason: invalid class name */
    /* JADX INFO: compiled from: HostNavigationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/margelo/nitro/boxcontext/ItemInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.margelo.nitro.boxcontext.HostNavigationService$openContentPicker$1", f = "HostNavigationService.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super ItemInfo[]>, Object> {
        final /* synthetic */ PickerConfig $config;
        final /* synthetic */ ItemInfo[] $currentItems;
        final /* synthetic */ Function2<ItemIdentifier[], ItemIdentifier[], Promise<ItemStatus[]>> $getItemsStatus;
        final /* synthetic */ String $recipientId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, ItemInfo[] itemInfoArr, PickerConfig pickerConfig, Function2<? super ItemIdentifier[], ? super ItemIdentifier[], Promise<ItemStatus[]>> function2, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$recipientId = str;
            this.$currentItems = itemInfoArr;
            this.$config = pickerConfig;
            this.$getItemsStatus = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$recipientId, this.$currentItems, this.$config, this.$getItemsStatus, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ItemInfo[]> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HostNavigationDelegate hostNavigationDelegateDelegate = HostNavigationRegistry.INSTANCE.delegate(this.$recipientId);
                if (hostNavigationDelegateDelegate == null) {
                    throw new IllegalStateException("No HostNavigationDelegate registered for recipientId: " + this.$recipientId);
                }
                this.label = 1;
                obj = hostNavigationDelegateDelegate.showContentPicker(ArraysKt.toList(this.$currentItems), this.$config, new HostNavigationService$openContentPicker$1$items$1(this.$getItemsStatus, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((List) obj).toArray(new ItemInfo[0]);
        }
    }

    @Override // com.margelo.nitro.boxcontext.HybridHostNavigationServiceSpec
    public Promise<ItemInfo[]> openContentPicker(String recipientId, ItemInfo[] currentItems, PickerConfig config, Function2<? super ItemIdentifier[], ? super ItemIdentifier[], Promise<ItemStatus[]>> getItemsStatus) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(currentItems, "currentItems");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(getItemsStatus, "getItemsStatus");
        return Promise.Companion.async$default(Promise.INSTANCE, null, new AnonymousClass1(recipientId, currentItems, config, getItemsStatus, null), 1, null);
    }

    /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.HostNavigationService$openPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HostNavigationService.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.margelo.nitro.boxcontext.HostNavigationService$openPreview$1", f = "HostNavigationService.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    static final class C18031 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemInfo $item;
        final /* synthetic */ String $recipientId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18031(String str, ItemInfo itemInfo, Continuation<? super C18031> continuation) {
            super(1, continuation);
            this.$recipientId = str;
            this.$item = itemInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18031(this.$recipientId, this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C18031) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HostNavigationDelegate hostNavigationDelegateDelegate = HostNavigationRegistry.INSTANCE.delegate(this.$recipientId);
                if (hostNavigationDelegateDelegate == null) {
                    throw new IllegalStateException("No HostNavigationDelegate registered for recipientId: " + this.$recipientId);
                }
                this.label = 1;
                if (hostNavigationDelegateDelegate.showPreview(this.$item, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.margelo.nitro.boxcontext.HybridHostNavigationServiceSpec
    public Promise<Unit> openPreview(String recipientId, ItemInfo item) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(item, "item");
        return Promise.Companion.async$default(Promise.INSTANCE, null, new C18031(recipientId, item, null), 1, null);
    }
}
