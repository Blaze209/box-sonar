package com.box.android.inbox.notifications;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.inbox.notifications.router.InboxNotificationRoutingMapper;
import com.box.android.inbox.notifications.router.InboxRouter;
import com.box.androidsdk.content.views.DefaultAvatarController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"NotificationsScreen", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/box/android/inbox/notifications/InboxViewModel;", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/coreservices/services/IntentServices;Landroidx/compose/ui/Modifier;Lcom/box/android/inbox/notifications/InboxViewModel;Landroidx/compose/runtime/Composer;II)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotificationsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsScreen$lambda$2(IUserContextManager iUserContextManager, IntentServices intentServices, Modifier modifier, InboxViewModel inboxViewModel, int i, int i2, Composer composer, int i3) {
        NotificationsScreen(iUserContextManager, intentServices, modifier, inboxViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:68:0x010b A[PHI: r3 r4
      0x010b: PHI (r3v15 int) = (r3v8 int), (r3v17 int) binds: [B:58:0x00af, B:53:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x010b: PHI (r4v10 androidx.compose.ui.Modifier) = (r4v5 androidx.compose.ui.Modifier), (r4v12 androidx.compose.ui.Modifier) binds: [B:58:0x00af, B:53:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x0116  */
    /* JADX WARN: Code duplicated, block: B:74:0x014a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0152  */
    /* JADX WARN: Code duplicated, block: B:79:0x0171  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:87:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    public static final void NotificationsScreen(final IUserContextManager userContextManager, final IntentServices intentServices, Modifier modifier, InboxViewModel inboxViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        InboxViewModel inboxViewModel2;
        boolean z;
        final Modifier modifier3;
        final InboxViewModel inboxViewModel3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        int i4;
        InboxViewModel inboxViewModel4;
        Context context;
        boolean zChanged;
        Object objRememberedValue;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Composer composerStartRestartGroup = composer.startRestartGroup(-569592106);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotificationsScreen)N(userContextManager,intentServices,modifier,viewModel)23@974L7,24@1004L147,30@1176L57,34@1239L407:NotificationsScreen.kt#1rb0q9");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(userContextManager) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(intentServices) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    inboxViewModel2 = inboxViewModel;
                    int i6 = composerStartRestartGroup.changedInstance(inboxViewModel2) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    inboxViewModel2 = inboxViewModel;
                }
                i3 |= i6;
            } else {
                inboxViewModel2 = inboxViewModel;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "21@923L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) InboxViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        InboxViewModel inboxViewModel5 = (InboxViewModel) viewModel;
                        i4 = i3 & (-7169);
                        inboxViewModel4 = inboxViewModel5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-569592106, i4, -1, "com.box.android.inbox.notifications.NotificationsScreen (NotificationsScreen.kt:22)");
                    }
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1917158999, "CC(remember):NotificationsScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(intentServices);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new InboxRouter(context, intentServices);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    InboxRouter inboxRouter = (InboxRouter) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1917153585, "CC(remember):NotificationsScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new InboxNotificationRoutingMapper();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    InboxContentKt.InboxContent(inboxViewModel4.getStore(), new DefaultAvatarControllerWrapper(new DefaultAvatarController(userContextManager.getBoxSession(context))), inboxRouter, (InboxNotificationRoutingMapper) objRememberedValue2, TestTagKt.testTag(companion, "NotificationsScreen"), true, composerStartRestartGroup, 199680, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    Modifier modifier4 = companion;
                    inboxViewModel3 = inboxViewModel4;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    companion = modifier2;
                }
                i4 = i3;
                inboxViewModel4 = inboxViewModel2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-569592106, i4, -1, "com.box.android.inbox.notifications.NotificationsScreen (NotificationsScreen.kt:22)");
                }
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1917158999, "CC(remember):NotificationsScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(intentServices);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new InboxRouter(context, intentServices);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new InboxRouter(context, intentServices);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                InboxRouter inboxRouter2 = (InboxRouter) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1917153585, "CC(remember):NotificationsScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new InboxNotificationRoutingMapper();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                InboxContentKt.InboxContent(inboxViewModel4.getStore(), new DefaultAvatarControllerWrapper(new DefaultAvatarController(userContextManager.getBoxSession(context))), inboxRouter2, (InboxNotificationRoutingMapper) objRememberedValue2, TestTagKt.testTag(companion, "NotificationsScreen"), true, composerStartRestartGroup, 199680, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                Modifier modifier5 = companion;
                inboxViewModel3 = inboxViewModel4;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                inboxViewModel3 = inboxViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.NotificationsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationsScreenKt.NotificationsScreen$lambda$2(userContextManager, intentServices, modifier3, inboxViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                inboxViewModel2 = inboxViewModel;
                if (composerStartRestartGroup.changedInstance(inboxViewModel2)) {
                }
                i3 |= i6;
            } else {
                inboxViewModel2 = inboxViewModel;
            }
            i3 |= i6;
        } else {
            inboxViewModel2 = inboxViewModel;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "21@923L15");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) InboxViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    InboxViewModel inboxViewModel6 = (InboxViewModel) viewModel2;
                    i4 = i3 & (-7169);
                    inboxViewModel4 = inboxViewModel6;
                } else {
                    i4 = i3;
                    inboxViewModel4 = inboxViewModel2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory3 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel3 = ViewModelKt.viewModel((Class<ViewModel>) InboxViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    InboxViewModel inboxViewModel7 = (InboxViewModel) viewModel3;
                    i4 = i3 & (-7169);
                    inboxViewModel4 = inboxViewModel7;
                } else {
                    i4 = i3;
                    inboxViewModel4 = inboxViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569592106, i4, -1, "com.box.android.inbox.notifications.NotificationsScreen (NotificationsScreen.kt:22)");
            }
            ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localContext3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1917158999, "CC(remember):NotificationsScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(context) | composerStartRestartGroup.changed(intentServices);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new InboxRouter(context, intentServices);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new InboxRouter(context, intentServices);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            InboxRouter inboxRouter3 = (InboxRouter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1917153585, "CC(remember):NotificationsScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new InboxNotificationRoutingMapper();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            InboxContentKt.InboxContent(inboxViewModel4.getStore(), new DefaultAvatarControllerWrapper(new DefaultAvatarController(userContextManager.getBoxSession(context))), inboxRouter3, (InboxNotificationRoutingMapper) objRememberedValue2, TestTagKt.testTag(companion, "NotificationsScreen"), true, composerStartRestartGroup, 199680, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Modifier modifier6 = companion;
            inboxViewModel3 = inboxViewModel4;
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            inboxViewModel3 = inboxViewModel2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.NotificationsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationsScreenKt.NotificationsScreen$lambda$2(userContextManager, intentServices, modifier3, inboxViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
