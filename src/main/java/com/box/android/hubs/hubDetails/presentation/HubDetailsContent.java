package com.box.android.hubs.hubDetails.presentation;

import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.FragmentActivity;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.cpl.Store;
import com.box.android.domain.webBridgeAuth.IBoxWebBridgeAuthenticator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsContent;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "authenticator", "Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/box/android/cpl/Store;Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;)V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubDetailsContent {
    public static final int $stable = 0;

    public HubDetailsContent(FragmentActivity activity, final Store<HubDetailsReducer.State, HubDetailsReducer.Action> store, final IBoxWebBridgeAuthenticator authenticator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(authenticator, "authenticator");
        ComponentActivityKt.setContent$default(activity, null, ComposableLambdaKt.composableLambdaInstance(1232425131, true, new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsContent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HubDetailsContent._init_$lambda$0(store, authenticator, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final Store store, final IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C58@1911L70,58@1902L79:HubDetailsActivity.kt#r6dsfu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232425131, i, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsContent.<anonymous> (HubDetailsActivity.kt:58)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-306932490, true, new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsContent$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubDetailsContent.lambda$0$0(store, iBoxWebBridgeAuthenticator, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$0$0(Store store, IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@1929L38:HubDetailsActivity.kt#r6dsfu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-306932490, i, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsContent.<anonymous>.<anonymous> (HubDetailsActivity.kt:59)");
            }
            HubDetailsScreenKt.HubDetailsScreen(store, iBoxWebBridgeAuthenticator, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
