package com.box.android.tasks.ui;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.models.UserMiniUIModel;
import com.box.android.tasks.R;
import com.google.android.material.internal.ViewUtils;
import io.opentelemetry.exporter.internal.grpc.GrpcStatusUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssigneeChipField.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AssigneeChipFieldKt {
    public static final ComposableSingletons$AssigneeChipFieldKt INSTANCE = new ComposableSingletons$AssigneeChipFieldKt();

    /* JADX INFO: renamed from: lambda$-232995039, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f250lambda$232995039 = ComposableLambdaKt.composableLambdaInstance(-232995039, false, new Function2() { // from class: com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssigneeChipFieldKt.lambda__232995039$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1948593630, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f249lambda$1948593630 = ComposableLambdaKt.composableLambdaInstance(-1948593630, false, new Function2() { // from class: com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssigneeChipFieldKt.lambda__1948593630$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1984108701 = ComposableLambdaKt.composableLambdaInstance(1984108701, false, new Function2() { // from class: com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssigneeChipFieldKt.lambda_1984108701$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2106287964 = ComposableLambdaKt.composableLambdaInstance(2106287964, false, new Function2() { // from class: com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AssigneeChipFieldKt.lambda_2106287964$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1948593630$tasks_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m13063getLambda$1948593630$tasks_generalProdRelease() {
        return f249lambda$1948593630;
    }

    /* JADX INFO: renamed from: getLambda$-232995039$tasks_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m13064getLambda$232995039$tasks_generalProdRelease() {
        return f250lambda$232995039;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1984108701$tasks_generalProdRelease() {
        return lambda$1984108701;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2106287964$tasks_generalProdRelease() {
        return lambda$2106287964;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__232995039$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@5268L50,113@5263L56:AssigneeChipField.kt#w4i53x");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-232995039, i, -1, "com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt.lambda$-232995039.<anonymous> (AssigneeChipField.kt:113)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_select_assignees, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1948593630$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C114@5360L54,114@5355L60:AssigneeChipField.kt#w4i53x");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1948593630, i, -1, "com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt.lambda$-1948593630.<anonymous> (AssigneeChipField.kt:114)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_assignee_placeholder, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1984108701$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@7704L51,183@7855L6,180@7671L230:AssigneeChipField.kt#w4i53x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1984108701, i, -1, "com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt.lambda$1984108701.<anonymous> (AssigneeChipField.kt:180)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_loading_assignees, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2106287964$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C282@11221L21,277@11045L1330:AssigneeChipField.kt#w4i53x");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106287964, i, -1, "com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt.lambda$2106287964.<anonymous> (AssigneeChipField.kt:277)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1218padding3ABfNKs(SizeKt.m1254heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(400), 0.0f, 2, null), Dp.m9687constructorimpl(16)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -810933112, "C284@11281L55,285@11365L315,297@11813L14,302@12102L38,303@12169L59,294@11694L671:AssigneeChipField.kt#w4i53x");
            ComposerKt.sourceInformationMarkerStart(composer, -303254423, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("invalid.user@example.com", null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -303251475, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.listOf((Object[]) new UserMiniUIModel[]{new UserMiniUIModel("1", "Alice Johnson", "alice.johnson"), new UserMiniUIModel("2", "Bob Smith", "bob.smith")}), null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            List<UserMiniUIModel> listLambda_2106287964$lambda$0$0$4 = lambda_2106287964$lambda$0$0$4(mutableState2);
            String strLambda_2106287964$lambda$0$0$1 = lambda_2106287964$lambda$0$0$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -303237440, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AssigneeChipFieldKt.lambda_2106287964$lambda$0$0$6$0(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            List listListOf = CollectionsKt.listOf((Object[]) new UserMiniUIModel[]{new UserMiniUIModel(ExifInterface.GPS_MEASUREMENT_3D, "Charlie Brown", "charlie.brown"), new UserMiniUIModel(GrpcStatusUtil.GRPC_STATUS_DEADLINE_EXCEEDED, "Diana Prince", "diana.prince")});
            ComposerKt.sourceInformationMarkerStart(composer, -303228168, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AssigneeChipFieldKt.lambda_2106287964$lambda$0$0$7$0(mutableState2, (UserMiniUIModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -303226003, "CC(remember):AssigneeChipField.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.box.android.tasks.ui.ComposableSingletons$AssigneeChipFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AssigneeChipFieldKt.lambda_2106287964$lambda$0$0$8$0(mutableState2, (UserMiniUIModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AssigneeChipFieldKt.AssigneeChipField(listLambda_2106287964$lambda$0$0$4, strLambda_2106287964$lambda$0$0$1, function1, listListOf, function2, (Function1) objRememberedValue5, false, true, null, false, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer, (UserMiniUIModel.$stable << 9) | 14377344, 6, ViewUtils.EDGE_TO_EDGE_FLAGS);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final String lambda_2106287964$lambda$0$0$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<UserMiniUIModel> lambda_2106287964$lambda$0$0$4(MutableState<List<UserMiniUIModel>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2106287964$lambda$0$0$6$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2106287964$lambda$0$0$7$0(MutableState mutableState, UserMiniUIModel user) {
        Intrinsics.checkNotNullParameter(user, "user");
        mutableState.setValue(CollectionsKt.plus((Collection<? extends UserMiniUIModel>) lambda_2106287964$lambda$0$0$4(mutableState), user));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2106287964$lambda$0$0$8$0(MutableState mutableState, UserMiniUIModel user) {
        Intrinsics.checkNotNullParameter(user, "user");
        List<UserMiniUIModel> listLambda_2106287964$lambda$0$0$4 = lambda_2106287964$lambda$0$0$4(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLambda_2106287964$lambda$0$0$4) {
            if (!Intrinsics.areEqual(((UserMiniUIModel) obj).getId(), user.getId())) {
                arrayList.add(obj);
            }
        }
        mutableState.setValue(arrayList);
        return Unit.INSTANCE;
    }
}
