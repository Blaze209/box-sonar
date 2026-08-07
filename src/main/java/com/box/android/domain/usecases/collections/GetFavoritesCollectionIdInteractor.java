package com.box.android.domain.usecases.collections;

import android.content.SharedPreferences;
import com.box.android.domain.identity.IUserContextManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetFavoritesCollectionIdInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0096B¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdInteractor;", "Lcom/box/android/domain/usecases/collections/GetFavoritesCollectionIdUseCase;", "listCollectionsInteractor", "Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/usecases/collections/ListCollectionsInteractor;Lcom/box/android/domain/identity/IUserContextManager;)V", "invoke", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserFavoriteCollectionId", "setUserFavoritesCollectionId", "", "id", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetFavoritesCollectionIdInteractor implements GetFavoritesCollectionIdUseCase {
    public static final String PREF_KEY_FAVORITE_COLLECTION_ID = "favorite_collection_id";
    private final ListCollectionsInteractor listCollectionsInteractor;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.collections.GetFavoritesCollectionIdInteractor$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetFavoritesCollectionIdInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.collections.GetFavoritesCollectionIdInteractor", f = "GetFavoritesCollectionIdInteractor.kt", i = {0, 1, 1, 1}, l = {26, 31}, m = "invoke", n = {"cachedId", "cachedId", "listResult", "liveData"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
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
            return GetFavoritesCollectionIdInteractor.this.invoke(this);
        }
    }

    @Inject
    public GetFavoritesCollectionIdInteractor(ListCollectionsInteractor listCollectionsInteractor, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(listCollectionsInteractor, "listCollectionsInteractor");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.listCollectionsInteractor = listCollectionsInteractor;
        this.userContextManager = userContextManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        if (r11 == r0) goto L28;
     */
    @Override // com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<java.lang.String, ? extends com.box.android.domain.models.DomainError>> r11) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.collections.GetFavoritesCollectionIdInteractor.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getUserFavoriteCollectionId() {
        return this.userContextManager.getUserSharedPrefs().getString(PREF_KEY_FAVORITE_COLLECTION_ID, null);
    }

    private final void setUserFavoritesCollectionId(String id) {
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs();
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
        editorEdit.putString(PREF_KEY_FAVORITE_COLLECTION_ID, id);
        editorEdit.apply();
    }
}
