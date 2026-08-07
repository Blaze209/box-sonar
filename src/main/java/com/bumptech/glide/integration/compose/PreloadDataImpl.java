package com.bumptech.glide.integration.compose;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.geometry.Size;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Preload.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u009a\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012L\u0010\u000f\u001aH\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0010j\b\u0012\u0004\u0012\u00028\u0000`\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0018J(\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0097\u0002¢\u0006\u0002\u0010 R\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000RT\u0010\u000f\u001aH\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0010j\b\u0012\u0004\u0012\u00028\u0000`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Lcom/bumptech/glide/integration/compose/PreloadDataImpl;", "DataT", "", "Lcom/bumptech/glide/integration/compose/GlidePreloadingData;", "size", "", "indexToData", "Lkotlin/Function1;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "preloadImageSize", "Landroidx/compose/ui/geometry/Size;", "fixedVisibleItemCount", "preloader", "Lcom/bumptech/glide/ListPreloader;", "requestBuilderTransform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "requestBuilder", "Lcom/bumptech/glide/integration/compose/PreloadRequestBuilderTransform;", "(ILkotlin/jvm/functions/Function1;Lcom/bumptech/glide/RequestManager;JLjava/lang/Integer;Lcom/bumptech/glide/ListPreloader;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/Integer;", "J", "getSize", "()I", PasskeyWebListener.GET_UNIQUE_KEY, "Lkotlin/Pair;", FirebaseAnalytics.Param.INDEX, "(ILandroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PreloadDataImpl<DataT> implements GlidePreloadingData<DataT> {
    private final Integer fixedVisibleItemCount;
    private final Function1<Integer, DataT> indexToData;
    private final long preloadImageSize;
    private final ListPreloader<DataT> preloader;
    private final Function2<DataT, RequestBuilder<Drawable>, RequestBuilder<Drawable>> requestBuilderTransform;
    private final RequestManager requestManager;
    private final int size;

    public /* synthetic */ PreloadDataImpl(int i, Function1 function1, RequestManager requestManager, long j, Integer num, ListPreloader listPreloader, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function1, requestManager, j, num, listPreloader, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PreloadDataImpl(int i, Function1<? super Integer, ? extends DataT> indexToData, RequestManager requestManager, long j, Integer num, ListPreloader<DataT> preloader, Function2<? super DataT, ? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> requestBuilderTransform) {
        Intrinsics.checkNotNullParameter(indexToData, "indexToData");
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        Intrinsics.checkNotNullParameter(preloader, "preloader");
        Intrinsics.checkNotNullParameter(requestBuilderTransform, "requestBuilderTransform");
        this.size = i;
        this.indexToData = indexToData;
        this.requestManager = requestManager;
        this.preloadImageSize = j;
        this.fixedVisibleItemCount = num;
        this.preloader = preloader;
        this.requestBuilderTransform = requestBuilderTransform;
    }

    @Override // com.bumptech.glide.integration.compose.GlidePreloadingData
    public int getSize() {
        return this.size;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bumptech.glide.integration.compose.GlidePreloadingData
    public Pair<DataT, RequestBuilder<Drawable>> get(int i, Composer composer, int i2) {
        composer.startReplaceableGroup(-1344240489);
        ComposerKt.sourceInformation(composer, "C(get)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344240489, i2, -1, "com.bumptech.glide.integration.compose.PreloadDataImpl.get (Preload.kt:197)");
        }
        DataT datatInvoke = this.indexToData.invoke(Integer.valueOf(i));
        Function2<DataT, RequestBuilder<Drawable>, RequestBuilder<Drawable>> function2 = this.requestBuilderTransform;
        Cloneable cloneableOverride = this.requestManager.asDrawable().override((int) Size.m6638getWidthimpl(this.preloadImageSize), (int) Size.m6635getHeightimpl(this.preloadImageSize));
        Intrinsics.checkNotNullExpressionValue(cloneableOverride, "requestManager.asDrawabl…ImageSize.height.toInt())");
        RequestBuilder requestBuilder = (RequestBuilder) function2.invoke(datatInvoke, cloneableOverride);
        EffectsKt.LaunchedEffect(new Object[]{this.preloader, Size.m6626boximpl(this.preloadImageSize), this.requestBuilderTransform, this.indexToData, Integer.valueOf(i)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(this, i, null), composer, 72);
        Pair<DataT, RequestBuilder<Drawable>> pair = TuplesKt.to(datatInvoke, requestBuilder);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pair;
    }

    /* JADX INFO: renamed from: com.bumptech.glide.integration.compose.PreloadDataImpl$get$1, reason: invalid class name */
    /* JADX INFO: compiled from: Preload.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "DataT", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bumptech.glide.integration.compose.PreloadDataImpl$get$1", f = "Preload.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        int label;
        final /* synthetic */ PreloadDataImpl<DataT> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PreloadDataImpl<DataT> preloadDataImpl, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = preloadDataImpl;
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ListPreloader listPreloader = ((PreloadDataImpl) this.this$0).preloader;
                int i = this.$index;
                Integer num = ((PreloadDataImpl) this.this$0).fixedVisibleItemCount;
                listPreloader.onScroll(null, i, num != null ? num.intValue() : 1, this.this$0.getSize());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
