package com.box.android.data.datasource;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao;
import com.box.android.data.persistence.sharedlink.SharedlinkCredentialEntity;
import com.box.android.data.user.UserData;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkCredentialsCacheDatasource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/datasource/SharedLinkCredentialsCacheDatasource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "addSharedLinkCredentials", "", "sharedlinkCredentialEntity", "Lcom/box/android/data/persistence/sharedlink/SharedlinkCredentialEntity;", "(Lcom/box/android/data/persistence/sharedlink/SharedlinkCredentialEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSharedLinkCredential", "fileId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkCredentialsCacheDatasource {
    private final UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.SharedLinkCredentialsCacheDatasource$addSharedLinkCredentials$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharedLinkCredentialsCacheDatasource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.SharedLinkCredentialsCacheDatasource", f = "SharedLinkCredentialsCacheDatasource.kt", i = {0, 0}, l = {15}, m = "addSharedLinkCredentials", n = {"sharedlinkCredentialEntity", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedLinkCredentialsCacheDatasource.this.addSharedLinkCredentials(null, this);
        }
    }

    @Inject
    public SharedLinkCredentialsCacheDatasource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object addSharedLinkCredentials(SharedlinkCredentialEntity sharedlinkCredentialEntity, Continuation<? super Unit> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    SharedLinkCredentialsDao sharedLinkCredentialsDao = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).sharedLinkCredentialsDao();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(sharedlinkCredentialEntity);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    anonymousClass1.label = 1;
                    if (sharedLinkCredentialsDao.insertSharedLinkCredentials(sharedlinkCredentialEntity, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error inserting sharedLink credential: " + ((Result.Error) boxDatabase).getValue());
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error inserting sharedLink credential ", e);
        }
        return Unit.INSTANCE;
    }

    public final Object getSharedLinkCredential(String str, Continuation<? super SharedlinkCredentialEntity> continuation) {
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            return ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).sharedLinkCredentialsDao().getSharedLinkCredential(str, continuation);
        }
        if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error finding sharedlink credentials for fileId " + str + " \n " + ((Result.Error) boxDatabase).getValue());
        return null;
    }
}
