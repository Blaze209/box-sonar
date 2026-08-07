package com.box.android.preview.previousversion;

import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.FragmentActivity;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.cpl.Store;
import com.box.android.preview.utils.ImmersiveModeManager;
import com.box.android.utilities.FlowExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: PreviousVersionPreviewActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionPreviewActivityContent;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "previousVersionRouter", "Lcom/box/android/preview/previousversion/PreviousVersionRouter;", "uiDependencyProvider", "Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/box/android/cpl/Store;Lcom/box/android/preview/previousversion/PreviousVersionRouter;Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;)V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionPreviewActivityContent {
    public static final int $stable = 0;

    public PreviousVersionPreviewActivityContent(FragmentActivity activity, final Store<PreviousVersionReducer.State, PreviousVersionReducer.Action> store, PreviousVersionRouter previousVersionRouter, final PreviousVersionUIDependencyProvider uiDependencyProvider) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(previousVersionRouter, "previousVersionRouter");
        Intrinsics.checkNotNullParameter(uiDependencyProvider, "uiDependencyProvider");
        ComponentActivityKt.setContent$default(activity, null, ComposableLambdaKt.composableLambdaInstance(-1421020048, true, new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivityContent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PreviousVersionPreviewActivityContent._init_$lambda$0(store, uiDependencyProvider, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        store.send(PreviousVersionReducer.Action.Initialize.INSTANCE);
        previousVersionRouter.initRouting();
        ImmersiveModeManager.INSTANCE.configureSystemBarVisibility(activity, FlowExtensionsKt.observe(store.getState(), new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivityContent.2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((PreviousVersionReducer.State) obj).isImmersiveMode());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final Store store, final PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C118@4755L89,118@4746L98:PreviousVersionPreviewActivity.kt#k0omno");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1421020048, i, -1, "com.box.android.preview.previousversion.PreviousVersionPreviewActivityContent.<anonymous> (PreviousVersionPreviewActivity.kt:118)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1793087813, true, new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivityContent$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionPreviewActivityContent.lambda$0$0(store, previousVersionUIDependencyProvider, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$0$0(Store store, PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C119@4773L57:PreviousVersionPreviewActivity.kt#k0omno");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1793087813, i, -1, "com.box.android.preview.previousversion.PreviousVersionPreviewActivityContent.<anonymous>.<anonymous> (PreviousVersionPreviewActivity.kt:119)");
            }
            PreviousVersionPreviewScreenKt.PreviousVersionPreviewScreen(store, previousVersionUIDependencyProvider, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
