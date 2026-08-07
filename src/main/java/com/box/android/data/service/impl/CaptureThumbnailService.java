package com.box.android.data.service.impl;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ICaptureThumbnailService;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CaptureThumbnailService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/service/impl/CaptureThumbnailService;", "Lcom/box/android/domain/services/ICaptureThumbnailService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "saveThumbnail", "", "url", "", "sha1", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnail", "Ljava/io/File;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureThumbnailService implements ICaptureThumbnailService {
    private final IUserContextManager userContextManager;

    @Inject
    public CaptureThumbnailService(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CaptureThumbnailService$saveThumbnail$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureThumbnailService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CaptureThumbnailService$saveThumbnail$2", f = "CaptureThumbnailService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $sha1;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ CaptureThumbnailService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, CaptureThumbnailService captureThumbnailService, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = str;
            this.this$0 = captureThumbnailService;
            this.$sha1 = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$url, this.this$0, this.$sha1, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(CommonBoxUtil.INSTANCE.compressAndSave(new File(this.$url), this.this$0.getThumbnail(this.$sha1)));
        }
    }

    @Override // com.box.android.domain.services.ICaptureThumbnailService
    public Object saveThumbnail(String str, String str2, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, this, str2, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.services.ICaptureThumbnailService
    public File getThumbnail(String sha1) {
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        File cachedThumbnailFile = this.userContextManager.getPreviewStorage().getCachedThumbnailFile(ICaptureThumbnailService.INSTANCE.getBoxFileForCaptureThumbnail(sha1), null);
        Intrinsics.checkNotNullExpressionValue(cachedThumbnailFile, "getCachedThumbnailFile(...)");
        return cachedThumbnailFile;
    }
}
