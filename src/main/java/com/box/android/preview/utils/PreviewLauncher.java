package com.box.android.preview.utils;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.preview.PreviewActivity;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxSession;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewLauncher.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ9\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0017H\u0016Je\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0017H\u0096@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/preview/utils/PreviewLauncher;", "Lcom/box/android/base/cpl/IPreviewLauncher;", "previewObservability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "itemService", "Lcom/box/android/domain/services/ILocalItemService;", "previewPrefetcher", "Lcom/box/android/preview/utils/PreviewPrefetcher;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "context", "Landroid/content/Context;", "<init>", "(Lcom/box/android/domain/metrics/preview/PreviewObservability;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/preview/utils/PreviewPrefetcher;Lcom/box/android/domain/identity/IUserContextManager;Landroid/content/Context;)V", "launchPreview", "", "data", "Lcom/box/android/base/cpl/IPreviewLauncher$NavigationData;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "modifyIntent", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "(Lcom/box/android/domain/models/ItemId;Landroid/content/Context;Lcom/box/android/domain/models/preview/PreviewSource;Ljava/lang/String;Landroidx/activity/result/ActivityResultLauncher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewLauncher implements IPreviewLauncher {
    public static final int $stable = 8;
    private final Context context;
    private final ILocalItemService itemService;
    private final PreviewObservability previewObservability;
    private final PreviewPrefetcher previewPrefetcher;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.preview.utils.PreviewLauncher$launchPreview$2, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewLauncher.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.utils.PreviewLauncher", f = "PreviewLauncher.kt", i = {0, 0, 0, 0, 0, 0}, l = {56}, m = "launchPreview", n = {"itemId", "context", "previewSource", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "launcher", "modifyIntent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewLauncher.this.launchPreview(null, null, null, null, null, null, this);
        }
    }

    @Inject
    public PreviewLauncher(PreviewObservability previewObservability, ILocalItemService itemService, PreviewPrefetcher previewPrefetcher, IUserContextManager userContextManager, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(previewObservability, "previewObservability");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(previewPrefetcher, "previewPrefetcher");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.previewObservability = previewObservability;
        this.itemService = itemService;
        this.previewPrefetcher = previewPrefetcher;
        this.userContextManager = userContextManager;
        this.context = context;
    }

    @Override // com.box.android.base.cpl.IPreviewLauncher
    public void launchPreview(IPreviewLauncher.NavigationData data, ActivityResultLauncher<Intent> launcher, Function1<? super Intent, Unit> modifyIntent) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(modifyIntent, "modifyIntent");
        String sharedLink = data.getSharedLink();
        if (sharedLink != null) {
            BoxSession boxSession = this.userContextManager.getBoxSession(this.context);
            CustomBoxSession customBoxSession = boxSession instanceof CustomBoxSession ? (CustomBoxSession) boxSession : null;
            if (customBoxSession != null) {
                customBoxSession.setSharedLink(sharedLink);
            }
        }
        String strStartPreviewMetric$default = PreviewObservability.startPreviewMetric$default(this.previewObservability, data.getFileModel(), data.getPreviewSource(), 0L, null, 12, null);
        this.previewPrefetcher.prefetch(data.getFileModel(), strStartPreviewMetric$default);
        Intent intent = PreviewActivity.INSTANCE.getIntent(data, strStartPreviewMetric$default);
        modifyIntent.invoke(intent);
        if (launcher != null) {
            launcher.launch(intent);
        } else {
            data.getContext().startActivity(intent);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.box.android.base.cpl.IPreviewLauncher
    public Object launchPreview(ItemId itemId, Context context, PreviewSource previewSource, String str, ActivityResultLauncher<Intent> activityResultLauncher, Function1<? super Intent, Unit> function1, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass2 anonymousClass2;
        Context context2;
        String str2;
        ActivityResultLauncher<Intent> activityResultLauncher2;
        Function1<? super Intent, Unit> function2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object objItem = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            ILocalItemService iLocalItemService = this.itemService;
            DataPolicy dataPolicy = DataPolicy.CACHE_OR_REMOTE;
            anonymousClass2.L$0 = itemId;
            anonymousClass2.L$1 = context;
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(previewSource);
            anonymousClass2.L$3 = str;
            anonymousClass2.L$4 = activityResultLauncher;
            anonymousClass2.L$5 = function1;
            anonymousClass2.label = 1;
            objItem = iLocalItemService.item(itemId, dataPolicy, anonymousClass2);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
            context2 = context;
            str2 = str;
            activityResultLauncher2 = activityResultLauncher;
            function2 = function1;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Function1<? super Intent, Unit> function3 = (Function1) anonymousClass2.L$5;
            ActivityResultLauncher<Intent> activityResultLauncher3 = (ActivityResultLauncher) anonymousClass2.L$4;
            String str3 = (String) anonymousClass2.L$3;
            Context context3 = (Context) anonymousClass2.L$1;
            ItemId itemId2 = (ItemId) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objItem);
            function2 = function3;
            itemId = itemId2;
            activityResultLauncher2 = activityResultLauncher3;
            context2 = context3;
            str2 = str3;
        }
        Result result = (Result) objItem;
        if (result instanceof Result.Success) {
            Object value = ((Result.Success) result).getValue();
            FileModel fileModel = value instanceof FileModel ? (FileModel) value : null;
            if (fileModel != null) {
                launchPreview(new IPreviewLauncher.NavigationData(context2, fileModel, PreviewSource.AICenter.INSTANCE, str2, null, false, false, 112, null), activityResultLauncher2, function2);
                return new Result.Success(Unit.INSTANCE);
            }
            return new Result.Error(new DomainError.UnknownError("Item with id " + itemId + " is expected to be file"));
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(((Result.Error) result).getValue());
    }
}
