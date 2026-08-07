package com.box.android.data.service.impl;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ITabPersistenceService;
import com.box.androidsdk.content.auth.OAuthActivity;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: TabPersistenceService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001eH\u0096@¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/box/android/data/service/impl/TabPersistenceService;", "Lcom/box/android/domain/services/ITabPersistenceService;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Landroidx/datastore/core/DataStore;Lcom/box/android/domain/identity/IUserContextManager;)V", OAuthActivity.USER_ID, "", "kotlin.jvm.PlatformType", "getUserId", "()Ljava/lang/String;", "lastUsedTabKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "getLastUsedTabKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "innerTabKey", "bottomTabRoute", "saveLastUsedTab", "", "tabRoute", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveInnerTab", "innerTabName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSavedTabState", "Lcom/box/android/domain/services/ITabPersistenceService$SavedTabState;", "availableTabRoutes", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TabPersistenceService implements ITabPersistenceService {
    private final DataStore<Preferences> dataStore;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.TabPersistenceService$loadSavedTabState$1, reason: invalid class name */
    /* JADX INFO: compiled from: TabPersistenceService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.TabPersistenceService", f = "TabPersistenceService.kt", i = {0}, l = {37}, m = "loadSavedTabState", n = {"availableTabRoutes"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TabPersistenceService.this.loadSavedTabState(null, this);
        }
    }

    @Inject
    public TabPersistenceService(@Named("last_used_tab") DataStore<Preferences> dataStore, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.dataStore = dataStore;
        this.userContextManager = userContextManager;
    }

    private final String getUserId() {
        return this.userContextManager.getCurrentContextId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Preferences.Key<String> getLastUsedTabKey() {
        return PreferencesKeys.stringKey("last_used_tab_" + getUserId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Preferences.Key<String> innerTabKey(String bottomTabRoute) {
        return PreferencesKeys.stringKey("inner_tab_" + getUserId() + "_" + bottomTabRoute);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.TabPersistenceService$saveLastUsedTab$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TabPersistenceService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.TabPersistenceService$saveLastUsedTab$2", f = "TabPersistenceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15282 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $tabRoute;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15282(String str, Continuation<? super C15282> continuation) {
            super(2, continuation);
            this.$tabRoute = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15282 c15282 = TabPersistenceService.this.new C15282(this.$tabRoute, continuation);
            c15282.L$0 = obj;
            return c15282;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((C15282) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(TabPersistenceService.this.getLastUsedTabKey(), this.$tabRoute);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.ITabPersistenceService
    public Object saveLastUsedTab(String str, Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(this.dataStore, new C15282(str, null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.TabPersistenceService$saveInnerTab$2, reason: invalid class name */
    /* JADX INFO: compiled from: TabPersistenceService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.TabPersistenceService$saveInnerTab$2", f = "TabPersistenceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bottomTabRoute;
        final /* synthetic */ String $innerTabName;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bottomTabRoute = str;
            this.$innerTabName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = TabPersistenceService.this.new AnonymousClass2(this.$bottomTabRoute, this.$innerTabName, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(TabPersistenceService.this.innerTabKey(this.$bottomTabRoute), this.$innerTabName);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.ITabPersistenceService
    public Object saveInnerTab(String str, String str2, Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(this.dataStore, new AnonymousClass2(str, str2, null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ITabPersistenceService
    public Object loadSavedTabState(List<String> list, Continuation<? super ITabPersistenceService.SavedTabState> continuation) {
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
        Object objFirst = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow<Preferences> data = this.dataStore.getData();
            anonymousClass1.L$0 = list;
            anonymousClass1.label = 1;
            objFirst = FlowKt.first(data, anonymousClass1);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objFirst);
        }
        Preferences preferences = (Preferences) objFirst;
        String str = (String) preferences.get(getLastUsedTabKey());
        if (str == null || !list.contains(str)) {
            str = null;
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (String str2 : list) {
            String str3 = (String) preferences.get(innerTabKey(str2));
            if (str3 != null) {
                mapCreateMapBuilder.put(str2, str3);
            }
        }
        return new ITabPersistenceService.SavedTabState(str, MapsKt.build(mapCreateMapBuilder));
    }
}
