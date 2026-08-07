package com.box.android.base.presentation.components.topbar.component.inbox;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InboxButtonKt {
    public static final ComposableSingletons$InboxButtonKt INSTANCE = new ComposableSingletons$InboxButtonKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1845544930 = ComposableLambdaKt.composableLambdaInstance(1845544930, false, new Function3() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.ComposableSingletons$InboxButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InboxButtonKt.lambda_1845544930$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-448211680, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f187lambda$448211680 = ComposableLambdaKt.composableLambdaInstance(-448211680, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.ComposableSingletons$InboxButtonKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InboxButtonKt.lambda__448211680$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-448211680$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11839getLambda$448211680$base_generalProdRelease() {
        return f187lambda$448211680;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1845544930$base_generalProdRelease() {
        return lambda$1845544930;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1845544930$lambda$0(BoxScope BadgedBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
        ComposerKt.sourceInformation(composer, "C84@3265L40,86@3385L6,83@3233L183:InboxButton.kt#beimh5");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1845544930, i, -1, "com.box.android.base.presentation.components.topbar.component.inbox.ComposableSingletons$InboxButtonKt.lambda$1845544930.<anonymous> (InboxButton.kt:83)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.inbox_topbar, composer, 0), "inbox", (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__448211680$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C98@3605L6,98@3569L290:InboxButton.kt#beimh5");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-448211680, i, -1, "com.box.android.base.presentation.components.topbar.component.inbox.ComposableSingletons$InboxButtonKt.lambda$-448211680.<anonymous> (InboxButton.kt:98)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composer, 6).m11498getAppBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1525169834, "C99@3699L3,99@3642L60,100@3772L3,100@3715L60,101@3846L3,101@3788L61:InboxButton.kt#beimh5");
            Store storeCreateMockStore = ComposePreviewUtilsKt.createMockStore(new InboxCountReducer.State(0));
            ComposerKt.sourceInformationMarkerStart(composer, -1890462003, "CC(remember):InboxButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.ComposableSingletons$InboxButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InboxButtonKt.InboxButton((Store<InboxCountReducer.State, InboxCountReducer.Action>) storeCreateMockStore, (Function0<Unit>) objRememberedValue, composer, 48);
            Store storeCreateMockStore2 = ComposePreviewUtilsKt.createMockStore(new InboxCountReducer.State(4));
            ComposerKt.sourceInformationMarkerStart(composer, -1890459667, "CC(remember):InboxButton.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.ComposableSingletons$InboxButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InboxButtonKt.InboxButton((Store<InboxCountReducer.State, InboxCountReducer.Action>) storeCreateMockStore2, (Function0<Unit>) objRememberedValue2, composer, 48);
            Store storeCreateMockStore3 = ComposePreviewUtilsKt.createMockStore(new InboxCountReducer.State(44));
            ComposerKt.sourceInformationMarkerStart(composer, -1890457299, "CC(remember):InboxButton.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.ComposableSingletons$InboxButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InboxButtonKt.InboxButton((Store<InboxCountReducer.State, InboxCountReducer.Action>) storeCreateMockStore3, (Function0<Unit>) objRememberedValue3, composer, 48);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
