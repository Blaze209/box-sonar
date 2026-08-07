package com.bumptech.glide.integration.ktx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bumptech.glide.GlideIntegrationKt;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Flows.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0007\u001a0\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a0\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\bH\u0003\u001a0\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0003\u001a0\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a8\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007\u001a0\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\bH\u0007\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u000bH\u0007¨\u0006\u0011"}, d2 = {"flow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bumptech/glide/integration/ktx/GlideFlowInstant;", "ResourceT", "", "Lcom/bumptech/glide/RequestBuilder;", "size", "Lcom/bumptech/glide/integration/ktx/AsyncGlideSize;", "Lcom/bumptech/glide/integration/ktx/ResolvableGlideSize;", "Lcom/bumptech/glide/integration/ktx/Size;", TypedValues.Custom.S_DIMENSION, "", "width", "height", "flowResolvable", "isValidGlideDimension", "", "ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowsKt {
    public static final <ResourceT> Flow<GlideFlowInstant<ResourceT>> flow(RequestBuilder<ResourceT> requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        if (!requestBuilder.isValidOverride()) {
            throw new IllegalArgumentException("At least your primary request is missing override dimensions. If you want to use Target.SIZE_ORIGINAL, do so explicitly".toString());
        }
        return flow(requestBuilder, Integer.MIN_VALUE);
    }

    public static final <ResourceT> Flow<GlideFlowInstant<ResourceT>> flow(RequestBuilder<ResourceT> requestBuilder, int i) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        return flow(requestBuilder, i, i);
    }

    public static final <ResourceT> Flow<GlideFlowInstant<ResourceT>> flow(RequestBuilder<ResourceT> requestBuilder, AsyncGlideSize size) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        return flowResolvable(requestBuilder, size);
    }

    public static final <ResourceT> Flow<GlideFlowInstant<ResourceT>> flow(RequestBuilder<ResourceT> requestBuilder, int i, int i2) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        if (!Util.isValidDimensions(i, i2)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return flow(requestBuilder, new Size(i, i2));
    }

    private static final <ResourceT> Flow<GlideFlowInstant<ResourceT>> flow(RequestBuilder<ResourceT> requestBuilder, Size size) {
        return flowResolvable(requestBuilder, new ImmediateGlideSize(size));
    }

    public static final <ResourceT> Flow<GlideFlowInstant<ResourceT>> flowResolvable(RequestBuilder<ResourceT> requestBuilder, ResolvableGlideSize size) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        return flow(requestBuilder, size);
    }

    /* JADX INFO: Add missing generic type declarations: [ResourceT] */
    /* JADX INFO: renamed from: com.bumptech.glide.integration.ktx.FlowsKt$flow$2, reason: invalid class name */
    /* JADX INFO: compiled from: Flows.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "ResourceT", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/bumptech/glide/integration/ktx/GlideFlowInstant;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bumptech.glide.integration.ktx.FlowsKt$flow$2", f = "Flows.kt", i = {}, l = {236}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<ResourceT> extends SuspendLambda implements Function2<ProducerScope<? super GlideFlowInstant<ResourceT>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RequestBuilder<ResourceT> $requestBuilder;
        final /* synthetic */ RequestManager $requestManager;
        final /* synthetic */ ResolvableGlideSize $size;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ResolvableGlideSize resolvableGlideSize, RequestBuilder<ResourceT> requestBuilder, RequestManager requestManager, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$size = resolvableGlideSize;
            this.$requestBuilder = requestBuilder;
            this.$requestManager = requestManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$size, this.$requestBuilder, this.$requestManager, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super GlideFlowInstant<ResourceT>> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                final FlowTarget flowTarget = new FlowTarget(producerScope, this.$size);
                GlideIntegrationKt.intoDirect(this.$requestBuilder, flowTarget);
                final RequestManager requestManager = this.$requestManager;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: com.bumptech.glide.integration.ktx.FlowsKt.flow.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        requestManager.clear(flowTarget);
                    }
                }, this) == coroutine_suspended) {
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

    private static final <ResourceT> Flow<GlideFlowInstant<ResourceT>> flow(RequestBuilder<ResourceT> requestBuilder, ResolvableGlideSize resolvableGlideSize) {
        return FlowKt.callbackFlow(new AnonymousClass2(resolvableGlideSize, requestBuilder, GlideIntegrationKt.requestManager(requestBuilder), null));
    }

    public static final boolean isValidGlideDimension(int i) {
        return Util.isValidDimension(i);
    }
}
