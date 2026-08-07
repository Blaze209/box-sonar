package com.box.android.activities.filepicker;

import com.box.android.dao.FileInfo;
import com.box.android.utilities.BoxUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LocalFolderChooser.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/dao/FileInfo;", "kotlin.jvm.PlatformType", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.activities.filepicker.LocalFolderChooser$loadFilesAsync$1$fileInfos$1", f = "LocalFolderChooser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LocalFolderChooser$loadFilesAsync$1$fileInfos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<FileInfo>>, Object> {
    final /* synthetic */ File $dir;
    int label;
    final /* synthetic */ LocalFolderChooser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalFolderChooser$loadFilesAsync$1$fileInfos$1(LocalFolderChooser localFolderChooser, File file, Continuation<? super LocalFolderChooser$loadFilesAsync$1$fileInfos$1> continuation) {
        super(2, continuation);
        this.this$0 = localFolderChooser;
        this.$dir = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalFolderChooser$loadFilesAsync$1$fileInfos$1(this.this$0, this.$dir, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<FileInfo>> continuation) {
        return ((LocalFolderChooser$loadFilesAsync$1$fileInfos$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return BoxUtils.getFiles(this.this$0, this.$dir);
    }
}
