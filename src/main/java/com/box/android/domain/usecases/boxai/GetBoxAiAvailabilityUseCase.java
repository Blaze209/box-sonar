package com.box.android.domain.usecases.boxai;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.boxai.AiItemAvailabilityStatus;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxFile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GetBoxAiAvailabilityUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\nJ4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0012H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;", "", "isBoxAiEnabled", "", "()Z", "getAiAvailabilityForItem", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "isMultidoc", "(Lcom/box/android/domain/models/item/ItemModel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAiAvailabilityForItemWithCallback", "", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onResult", "Lkotlin/Function1;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GetBoxAiAvailabilityUseCase {
    Object getAiAvailabilityForItem(ItemModel itemModel, boolean z, Continuation<? super AiItemAvailabilityStatus> continuation);

    boolean isBoxAiEnabled();

    /* JADX INFO: compiled from: GetBoxAiAvailabilityUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void getAiAvailabilityForItemWithCallback(GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase, BoxFile boxFile, boolean z, Lifecycle lifecycle, Function1<? super AiItemAvailabilityStatus, Unit> onResult) {
            Intrinsics.checkNotNullParameter(boxFile, "boxFile");
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(onResult, "onResult");
            GetBoxAiAvailabilityUseCase.super.getAiAvailabilityForItemWithCallback(boxFile, z, lifecycle, onResult);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase$getAiAvailabilityForItemWithCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetBoxAiAvailabilityUseCase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase$getAiAvailabilityForItemWithCallback$1", f = "GetBoxAiAvailabilityUseCase.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxFile $boxFile;
        final /* synthetic */ boolean $isMultidoc;
        final /* synthetic */ Function1<AiItemAvailabilityStatus, Unit> $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(BoxFile boxFile, boolean z, Function1<? super AiItemAvailabilityStatus, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$boxFile = boxFile;
            this.$isMultidoc = z;
            this.$onResult = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GetBoxAiAvailabilityUseCase.this.new AnonymousClass1(this.$boxFile, this.$isMultidoc, this.$onResult, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GetBoxAiAvailabilityUseCase.this.getAiAvailabilityForItem(FileModelMapper.INSTANCE.toFileModel(this.$boxFile, false), this.$isMultidoc, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$onResult.invoke((AiItemAvailabilityStatus) obj);
            return Unit.INSTANCE;
        }
    }

    default void getAiAvailabilityForItemWithCallback(BoxFile boxFile, boolean isMultidoc, Lifecycle lifecycle, Function1<? super AiItemAvailabilityStatus, Unit> onResult) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new AnonymousClass1(boxFile, isMultidoc, onResult, null), 3, null);
    }
}
