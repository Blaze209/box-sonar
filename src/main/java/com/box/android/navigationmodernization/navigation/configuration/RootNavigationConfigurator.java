package com.box.android.navigationmodernization.navigation.configuration;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.inbox.InboxDestination;
import com.box.android.inbox.InboxNavigationConfig;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.navigationmodernization.navigation.RootNavigationConfig;
import com.box.android.navigationmodernization.navigation.RootNavigationDestination;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.navigation.SearchNavigationConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootNavigationConfigurator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/box/android/navigationmodernization/navigation/configuration/RootNavigationConfigurator;", "", "mainNavigationTargetConfigFactory", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "requestedNavigationTarget", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "<init>", "(Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;Lcom/box/android/navigationmodernization/MainNavigationTarget;)V", "mainNavigationConfig", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig;", "navigationError", "Lcom/box/android/domain/models/DomainError;", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeNavigationError", "startNavigationConfig", "Lcom/box/android/navigationmodernization/navigation/RootNavigationConfig;", "getStartNavigationConfig", "()Lcom/box/android/navigationmodernization/navigation/RootNavigationConfig;", "startNavigationConfig$delegate", "Lkotlin/Lazy;", "inboxNavigationConfig", "Lcom/box/android/inbox/InboxNavigationConfig;", "getInboxNavigationConfig", "()Lcom/box/android/inbox/InboxNavigationConfig;", "inboxNavigationConfig$delegate", "searchNavigationConfig", "Lcom/box/android/search/navigation/SearchNavigationConfig;", "getSearchNavigationConfig", "()Lcom/box/android/search/navigation/SearchNavigationConfig;", "searchNavigationConfig$delegate", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RootNavigationConfigurator {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: inboxNavigationConfig$delegate, reason: from kotlin metadata */
    private final Lazy inboxNavigationConfig;
    private MainNavigationConfig mainNavigationConfig;
    private final MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory;
    private DomainError navigationError;
    private final MainNavigationTarget requestedNavigationTarget;

    /* JADX INFO: renamed from: searchNavigationConfig$delegate, reason: from kotlin metadata */
    private final Lazy searchNavigationConfig;

    /* JADX INFO: renamed from: startNavigationConfig$delegate, reason: from kotlin metadata */
    private final Lazy startNavigationConfig;

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: RootNavigationConfigurator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator", f = "RootNavigationConfigurator.kt", i = {}, l = {22}, m = "initialize", n = {}, s = {}, v = 1)
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
            return RootNavigationConfigurator.this.initialize(this);
        }
    }

    public RootNavigationConfigurator(MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, MainNavigationTarget mainNavigationTarget) {
        Intrinsics.checkNotNullParameter(mainNavigationTargetConfigFactory, "mainNavigationTargetConfigFactory");
        this.mainNavigationTargetConfigFactory = mainNavigationTargetConfigFactory;
        this.requestedNavigationTarget = mainNavigationTarget;
        this.startNavigationConfig = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavigationConfigurator.startNavigationConfig_delegate$lambda$0(this.f$0);
            }
        });
        this.inboxNavigationConfig = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavigationConfigurator.inboxNavigationConfig_delegate$lambda$0(this.f$0);
            }
        });
        this.searchNavigationConfig = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavigationConfigurator.searchNavigationConfig_delegate$lambda$0();
            }
        });
    }

    public /* synthetic */ RootNavigationConfigurator(MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory, MainNavigationTarget mainNavigationTarget, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mainNavigationTargetConfigFactory, (i & 2) != 0 ? null : mainNavigationTarget);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initialize(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        RootNavigationConfigurator rootNavigationConfigurator;
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
        Object objCreate = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreate);
            MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory = this.mainNavigationTargetConfigFactory;
            MainNavigationTarget mainNavigationTarget = this.requestedNavigationTarget;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objCreate = mainNavigationTargetConfigFactory.create(mainNavigationTarget, anonymousClass1);
            if (objCreate == coroutine_suspended) {
                return coroutine_suspended;
            }
            rootNavigationConfigurator = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rootNavigationConfigurator = (RootNavigationConfigurator) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objCreate);
        }
        rootNavigationConfigurator.mainNavigationConfig = (MainNavigationConfig) objCreate;
        MainNavigationConfig mainNavigationConfig = this.mainNavigationConfig;
        MainNavigationConfig.Home home = mainNavigationConfig instanceof MainNavigationConfig.Home ? (MainNavigationConfig.Home) mainNavigationConfig : null;
        this.navigationError = home != null ? home.getError() : null;
        return Unit.INSTANCE;
    }

    public final DomainError consumeNavigationError() {
        DomainError domainError = this.navigationError;
        this.navigationError = null;
        return domainError;
    }

    public final RootNavigationConfig getStartNavigationConfig() {
        return (RootNavigationConfig) this.startNavigationConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RootNavigationConfig startNavigationConfig_delegate$lambda$0(RootNavigationConfigurator rootNavigationConfigurator) {
        if (rootNavigationConfigurator.mainNavigationConfig instanceof MainNavigationConfig.Inbox) {
            return new RootNavigationConfig(RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE, CollectionsKt.listOf(RootNavigationDestination.InnerDestination.Inbox.INSTANCE));
        }
        return new RootNavigationConfig(RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE, null, 2, null);
    }

    public final InboxNavigationConfig getInboxNavigationConfig() {
        return (InboxNavigationConfig) this.inboxNavigationConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxNavigationConfig inboxNavigationConfig_delegate$lambda$0(RootNavigationConfigurator rootNavigationConfigurator) {
        InboxDestination.TabsScreen.InboxTab startInboxTab;
        InboxNavigationConfig inboxNavigationConfig;
        MainNavigationConfig mainNavigationConfig = rootNavigationConfigurator.mainNavigationConfig;
        MainNavigationConfig.Inbox inbox = mainNavigationConfig instanceof MainNavigationConfig.Inbox ? (MainNavigationConfig.Inbox) mainNavigationConfig : null;
        if (inbox != null && (inboxNavigationConfig = inbox.getInboxNavigationConfig()) != null) {
            return inboxNavigationConfig;
        }
        EnumEntries<InboxDestination.TabsScreen.InboxTab> entries = InboxDestination.TabsScreen.InboxTab.getEntries();
        MainNavigationTarget mainNavigationTarget = rootNavigationConfigurator.requestedNavigationTarget;
        if (mainNavigationTarget == null || (startInboxTab = RootNavigationConfiguratorKt.getStartInboxTab(mainNavigationTarget)) == null) {
            startInboxTab = InboxDestination.TabsScreen.InboxTab.Notifications;
        }
        return new InboxNavigationConfig(new InboxDestination.TabsScreen(entries, startInboxTab));
    }

    public final SearchNavigationConfig getSearchNavigationConfig() {
        return (SearchNavigationConfig) this.searchNavigationConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchNavigationConfig searchNavigationConfig_delegate$lambda$0() {
        return new SearchNavigationConfig(new SearchDestination.InnerDestination.Search(new SearchMode.Files(null, 1, null), true));
    }
}
