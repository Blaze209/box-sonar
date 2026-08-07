package com.box.android.hubs.hubDetails.domain;

import android.net.Uri;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubSpecificUrlHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/hubs/hubDetails/domain/HubSpecificUrlHandler;", "", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Lcom/box/android/domain/services/IRemoteItemService;)V", "getItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "isHubSpecificUrl", "", "uri", "Landroid/net/Uri;", "isWebLink", "handleBoxWebLink", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubSpecificUrlHandler {
    private static final String WEB_LINK_PATH = "web_link";
    private final IRemoteItemService itemService;
    public static final int $stable = 8;
    private static final Set<String> HUBS_SUPPORTED_PATH = SetsKt.setOf("web_link");

    /* JADX INFO: renamed from: com.box.android.hubs.hubDetails.domain.HubSpecificUrlHandler$handleBoxWebLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubSpecificUrlHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.hubDetails.domain.HubSpecificUrlHandler", f = "HubSpecificUrlHandler.kt", i = {0, 0, 0}, l = {24}, m = "handleBoxWebLink", n = {"uri", BoxCommonConstants.EXTRA_WEB_LINK_ID, "itemId"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HubSpecificUrlHandler.this.handleBoxWebLink(null, this);
        }
    }

    @Inject
    public HubSpecificUrlHandler(IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.itemService = itemService;
    }

    public final IRemoteItemService getItemService() {
        return this.itemService;
    }

    public final boolean isHubSpecificUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return CollectionsKt.contains(HUBS_SUPPORTED_PATH, uri.getAuthority());
    }

    public final boolean isWebLink(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual(uri.getAuthority(), "web_link");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleBoxWebLink(Uri uri, Continuation<? super Result<String, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objItem = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objItem);
                String queryParameter = uri.getQueryParameter("id");
                if (queryParameter == null) {
                    throw new IllegalArgumentException("Web link id not found");
                }
                ItemId.Remote remote = new ItemId.Remote(queryParameter, ItemType.WEBLINK);
                IRemoteItemService iRemoteItemService = this.itemService;
                DataPolicy dataPolicy = DataPolicy.CACHE_OR_REMOTE;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uri);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(queryParameter);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.label = 1;
                objItem = iRemoteItemService.item(remote, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) anonymousClass1);
                if (objItem == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objItem);
            }
            Result result = (Result) objItem;
            if (result instanceof Result.Success) {
                ItemModel itemModel = (ItemModel) ((Result.Success) result).getValue();
                WebLinkModel webLinkModel = itemModel instanceof WebLinkModel ? (WebLinkModel) itemModel : null;
                if (webLinkModel == null) {
                    throw new IllegalStateException("Item is not a web link");
                }
                String url = webLinkModel.getUrl();
                if (url == null) {
                    throw new IllegalStateException("Web link url not found");
                }
                return new Result.Success(url);
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            return new Result.Error(new DomainError.CustomError(message));
        }
    }
}
