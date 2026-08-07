package com.bumptech.glide.integration.ktx;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: Flows.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B!\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016J2\u0010\u001c\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010#\u001a\u00020\u001eH\u0016J\u0012\u0010$\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J'\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00028\u00002\u0010\u0010'\u001a\f\u0012\u0006\b\u0000\u0012\u00028\u0000\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J;\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010*\u001a\u00020+2\u0006\u0010#\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0012\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bumptech/glide/integration/ktx/FlowTarget;", "ResourceT", "", "Lcom/bumptech/glide/request/target/Target;", "Lcom/bumptech/glide/request/RequestListener;", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/bumptech/glide/integration/ktx/GlideFlowInstant;", "size", "Lcom/bumptech/glide/integration/ktx/ResolvableGlideSize;", "(Lkotlinx/coroutines/channels/ProducerScope;Lcom/bumptech/glide/integration/ktx/ResolvableGlideSize;)V", "currentRequest", "Lcom/bumptech/glide/request/Request;", "lastResource", "Lcom/bumptech/glide/integration/ktx/Resource;", "resolvedSize", "Lcom/bumptech/glide/integration/ktx/Size;", "sizeReadyCallbacks", "", "Lcom/bumptech/glide/request/target/SizeReadyCallback;", "getRequest", "getSize", "", "cb", "onDestroy", "onLoadCleared", ReactTextInputShadowNode.PROP_PLACEHOLDER, "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "target", "isFirstResource", "onLoadStarted", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "(Ljava/lang/Object;Lcom/bumptech/glide/request/transition/Transition;)V", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z", "onStart", "onStop", "removeCallback", "setRequest", "request", "ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FlowTarget<ResourceT> implements Target<ResourceT>, RequestListener<ResourceT> {
    private volatile Request currentRequest;
    private volatile Resource<ResourceT> lastResource;
    private volatile Size resolvedSize;
    private final ProducerScope<GlideFlowInstant<ResourceT>> scope;
    private final ResolvableGlideSize size;
    private final List<SizeReadyCallback> sizeReadyCallbacks;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowTarget(ProducerScope<? super GlideFlowInstant<ResourceT>> scope, ResolvableGlideSize size) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(size, "size");
        this.scope = scope;
        this.size = size;
        this.sizeReadyCallbacks = new ArrayList();
        if (size instanceof ImmediateGlideSize) {
            this.resolvedSize = ((ImmediateGlideSize) size).getSize();
        } else if (size instanceof AsyncGlideSize) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(this, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.integration.ktx.FlowTarget$1, reason: invalid class name */
    /* JADX INFO: compiled from: Flows.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "ResourceT", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bumptech.glide.integration.ktx.FlowTarget$1", f = "Flows.kt", i = {0}, l = {287}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FlowTarget<ResourceT> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlowTarget<ResourceT> flowTarget, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = flowTarget;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.util.ArrayList] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object size = ((AsyncGlideSize) ((FlowTarget) this.this$0).size).getSize(this);
                if (size == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = size;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Size size2 = (Size) obj;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            FlowTarget<ResourceT> flowTarget = this.this$0;
            synchronized (coroutineScope) {
                ((FlowTarget) flowTarget).resolvedSize = size2;
                objectRef.element = new ArrayList(((FlowTarget) flowTarget).sizeReadyCallbacks);
                ((FlowTarget) flowTarget).sizeReadyCallbacks.clear();
                Unit unit = Unit.INSTANCE;
            }
            Iterator it = ((Iterable) objectRef.element).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).onSizeReady(size2.getWidth(), size2.getHeight());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable placeholder) {
        this.lastResource = null;
        this.scope.mo11206trySendJP2dKIU(new Placeholder(Status.RUNNING, placeholder));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable errorDrawable) {
        this.scope.mo11206trySendJP2dKIU(new Placeholder(Status.FAILED, errorDrawable));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(ResourceT resource, Transition<? super ResourceT> transition) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable placeholder) {
        this.lastResource = null;
        this.scope.mo11206trySendJP2dKIU(new Placeholder(Status.CLEARED, placeholder));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        Size size = this.resolvedSize;
        if (size != null) {
            cb.onSizeReady(size.getWidth(), size.getHeight());
            return;
        }
        synchronized (this) {
            Size size2 = this.resolvedSize;
            if (size2 != null) {
                cb.onSizeReady(size2.getWidth(), size2.getHeight());
                Unit unit = Unit.INSTANCE;
            } else {
                Boolean.valueOf(this.sizeReadyCallbacks.add(cb));
            }
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        synchronized (this) {
            this.sizeReadyCallbacks.remove(cb);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        this.currentRequest = request;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* JADX INFO: renamed from: getRequest, reason: from getter */
    public Request getCurrentRequest() {
        return this.currentRequest;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException e, Object model, Target<ResourceT> target, boolean isFirstResource) {
        Intrinsics.checkNotNullParameter(target, "target");
        Resource<ResourceT> resource = this.lastResource;
        Request request = this.currentRequest;
        if (resource == null || request == null || request.isComplete() || request.isRunning()) {
            return false;
        }
        this.scope.getChannel().mo11206trySendJP2dKIU(resource.asFailure());
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(ResourceT resource, Object model, Target<ResourceT> target, DataSource dataSource, boolean isFirstResource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Request request = this.currentRequest;
        Resource<ResourceT> resource2 = new Resource<>((request == null || !request.isComplete()) ? Status.RUNNING : Status.SUCCEEDED, resource, isFirstResource, dataSource);
        this.lastResource = resource2;
        this.scope.mo11206trySendJP2dKIU(resource2);
        return true;
    }
}
