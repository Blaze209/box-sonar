package com.box.android.browse.cpl.createfolder;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxCheckBoxKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxInputDialogKt;
import com.box.android.base.compose.dialog.BoxProgressDialogKt;
import com.box.android.browse.R;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateFolderDialog.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0007\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"CreateFolderDialog", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$State;", "Lcom/box/android/browse/cpl/createfolder/CreateFolderReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "InviteCollaboratorsCheckbox", "checked", "", "(Lcom/box/android/cpl/Store;ZLandroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFolderDialog$lambda$8(Store store, int i, Composer composer, int i2) {
        CreateFolderDialog(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCollaboratorsCheckbox$lambda$1(Store store, boolean z, int i, Composer composer, int i2) {
        InviteCollaboratorsCheckbox(store, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0153  */
    /* JADX WARN: Code duplicated, block: B:54:0x0155  */
    /* JADX WARN: Code duplicated, block: B:59:0x0164  */
    /* JADX WARN: Code duplicated, block: B:62:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:63:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x01cf  */
    public static final void CreateFolderDialog(final Store<CreateFolderReducer.State, CreateFolderReducer.Action> store, Composer composer, final int i) {
        int i2;
        final Store<CreateFolderReducer.State, CreateFolderReducer.Action> store2;
        String str;
        boolean z;
        Object objRememberedValue;
        boolean z2;
        boolean z3;
        Object objRememberedValue2;
        int i3;
        Context context;
        boolean z4;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(2092058897);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateFolderDialog)N(store)30@1361L29,31@1422L7,70@3146L217,70@3106L257:CreateFolderDialog.kt#m1dqoi");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(store) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            store2 = store;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2092058897, i2, -1, "com.box.android.browse.cpl.createfolder.CreateFolderDialog (CreateFolderDialog.kt:29)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context2 = (Context) objConsume;
            if (CreateFolderDialog$lambda$0(stateCollectAsStateWithLifecycle).isPendingCreation()) {
                composerStartRestartGroup.startReplaceGroup(256394077);
                ComposerKt.sourceInformation(composerStartRestartGroup, "33@1501L39,33@1473L68");
                BoxProgressDialogKt.BoxProgressDialog(StringResources_androidKt.stringResource(R.string.LS_Creating___, composerStartRestartGroup, 0), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                context = context2;
                i3 = i2;
                z4 = true;
            } else {
                composerStartRestartGroup.startReplaceGroup(256528710);
                ComposerKt.sourceInformation(composerStartRestartGroup, "36@1599L43,37@1664L41,38@1733L41,39@1800L66,40@1897L64,45@2181L55,50@2427L66,53@2580L141,61@2903L167,35@1563L1531");
                String strStringResource = StringResources_androidKt.stringResource(R.string.LS_Create_folder_n, composerStartRestartGroup, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.folder_name_hint, composerStartRestartGroup, 0);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.folder_name_hint, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423923539, "CC(remember):CreateFolderDialog.kt#9igjgp");
                int i4 = i2 & 14;
                boolean z5 = i4 == 4;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateFolderDialogKt.CreateFolderDialog$lambda$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423926641, "CC(remember):CreateFolderDialog.kt#9igjgp");
                boolean z6 = i4 == 4;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateFolderDialogKt.CreateFolderDialog$lambda$2$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function1 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String folderName = CreateFolderDialog$lambda$0(stateCollectAsStateWithLifecycle).getFolderName();
                int i5 = R.string.create;
                boolean zIsCreatedEnabled = CreateFolderDialog$lambda$0(stateCollectAsStateWithLifecycle).isCreatedEnabled();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423935720, "CC(remember):CreateFolderDialog.kt#9igjgp");
                boolean z7 = i4 == 4;
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    str = strStringResource;
                } else {
                    str = strStringResource;
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(zIsCreatedEnabled, (Function0) objRememberedValue5, i5);
                    int i6 = R.string.alert_dialog_cancel;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423943603, "CC(remember):CreateFolderDialog.kt#9igjgp");
                    if (i4 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CreateFolderDialogKt.CreateFolderDialog$lambda$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonItem.TextButtonItem textButtonItem2 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue, i6);
                    String nameError = CreateFolderDialog$lambda$0(stateCollectAsStateWithLifecycle).getNameError();
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(592570626, true, new Function2() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateFolderDialogKt.CreateFolderDialog$lambda$5(stateCollectAsStateWithLifecycle, store, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423958936, "CC(remember):CreateFolderDialog.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                    if (i4 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = zChanged | z2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CreateFolderDialogKt.CreateFolderDialog$lambda$6$0(store, stateCollectAsStateWithLifecycle, (KeyboardActionScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 = i2;
                    context = context2;
                    z4 = true;
                    BoxInputDialogKt.BoxInputDialog(str, strStringResource2, strStringResource3, function0, function1, folderName, textButtonItem, textButtonItem2, null, nameError, composableLambdaRememberComposableLambda, true, keyboardOptions, new KeyboardActions((Function1) objRememberedValue2, null, null, null, null, null, 62, null), composerStartRestartGroup, 0, 438, 256);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateFolderDialogKt.CreateFolderDialog$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonItem.TextButtonItem textButtonItem3 = new ButtonItem.TextButtonItem(zIsCreatedEnabled, (Function0) objRememberedValue5, i5);
                int i7 = R.string.alert_dialog_cancel;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423943603, "CC(remember):CreateFolderDialog.kt#9igjgp");
                if (i4 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateFolderDialogKt.CreateFolderDialog$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateFolderDialogKt.CreateFolderDialog$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonItem.TextButtonItem textButtonItem4 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue, i7);
                String nameError2 = CreateFolderDialog$lambda$0(stateCollectAsStateWithLifecycle).getNameError();
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(592570626, true, new Function2() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateFolderDialogKt.CreateFolderDialog$lambda$5(stateCollectAsStateWithLifecycle, store, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423958936, "CC(remember):CreateFolderDialog.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                if (i4 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChanged2 | z2;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateFolderDialogKt.CreateFolderDialog$lambda$6$0(store, stateCollectAsStateWithLifecycle, (KeyboardActionScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateFolderDialogKt.CreateFolderDialog$lambda$6$0(store, stateCollectAsStateWithLifecycle, (KeyboardActionScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i3 = i2;
                context = context2;
                z4 = true;
                BoxInputDialogKt.BoxInputDialog(str, strStringResource2, strStringResource3, function0, function1, folderName, textButtonItem3, textButtonItem4, null, nameError2, composableLambdaRememberComposableLambda2, true, keyboardOptions2, new KeyboardActions((Function1) objRememberedValue2, null, null, null, null, null, 62, null), composerStartRestartGroup, 0, 438, 256);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            String createFolderError = CreateFolderDialog$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderError();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 423966762, "CC(remember):CreateFolderDialog.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(context) | ((i3 & 14) == 4 ? z4 : false);
            CreateFolderDialogKt$CreateFolderDialog$7$1 createFolderDialogKt$CreateFolderDialog$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || createFolderDialogKt$CreateFolderDialog$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                store2 = store;
                createFolderDialogKt$CreateFolderDialog$7$1RememberedValue = new CreateFolderDialogKt$CreateFolderDialog$7$1(stateCollectAsStateWithLifecycle, context, store2, null);
                composerStartRestartGroup.updateRememberedValue(createFolderDialogKt$CreateFolderDialog$7$1RememberedValue);
            } else {
                store2 = store;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(createFolderError, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) createFolderDialogKt$CreateFolderDialog$7$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateFolderDialogKt.CreateFolderDialog$lambda$8(store2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFolderDialog$lambda$1$0(Store store) {
        store.send(CreateFolderReducer.Action.FolderCreationCancelled.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFolderDialog$lambda$2$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new CreateFolderReducer.Action.FolderNameUpdated(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFolderDialog$lambda$3$0(Store store) {
        store.send(CreateFolderReducer.Action.CreateFolder.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFolderDialog$lambda$4$0(Store store) {
        store.send(CreateFolderReducer.Action.FolderCreationCancelled.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFolderDialog$lambda$5(State state, Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:CreateFolderDialog.kt#m1dqoi");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(592570626, i, -1, "com.box.android.browse.cpl.createfolder.CreateFolderDialog.<anonymous> (CreateFolderDialog.kt:54)");
            }
            Boolean inviteCollaborators = CreateFolderDialog$lambda$0(state).getInviteCollaborators();
            if (inviteCollaborators == null) {
                composer.startReplaceGroup(955979789);
            } else {
                composer.startReplaceGroup(955979790);
                ComposerKt.sourceInformation(composer, "*55@2651L38");
                InviteCollaboratorsCheckbox(store, inviteCollaborators.booleanValue(), composer, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFolderDialog$lambda$6$0(Store store, State state, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (CreateFolderDialog$lambda$0(state).isCreatedEnabled()) {
            store.send(CreateFolderReducer.Action.CreateFolder.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    public static final void InviteCollaboratorsCheckbox(final Store<CreateFolderReducer.State, CreateFolderReducer.Action> store, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(2039211686);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InviteCollaboratorsCheckbox)N(store,checked)82@3666L694,82@3579L781:CreateFolderDialog.kt#m1dqoi");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2039211686, i2, -1, "com.box.android.browse.cpl.createfolder.InviteCollaboratorsCheckbox (CreateFolderDialog.kt:80)");
            }
            CompositionLocalKt.CompositionLocalProvider(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize().provides(Dp.m9685boximpl(Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())), ComposableLambdaKt.rememberComposableLambda(-1766007962, true, new Function2() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateFolderDialogKt.InviteCollaboratorsCheckbox$lambda$0(z, store, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateFolderDialogKt.InviteCollaboratorsCheckbox$lambda$1(store, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCollaboratorsCheckbox$lambda$0(boolean z, final Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C83@3676L678:CreateFolderDialog.kt#m1dqoi");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1766007962, i, -1, "com.box.android.browse.cpl.createfolder.InviteCollaboratorsCheckbox.<anonymous> (CreateFolderDialog.kt:83)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(16), 0.0f, 0.0f, 13, null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1290323221, "C89@3900L155,87@3818L309,97@4169L52,99@4313L6,96@4140L204:CreateFolderDialog.kt#m1dqoi");
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(10), 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1898041573, "CC(remember):CreateFolderDialog.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.createfolder.CreateFolderDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateFolderDialogKt.InviteCollaboratorsCheckbox$lambda$0$0$0$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxCheckBoxKt.BoxCheckbox(modifierM1222paddingqDBjuR0$default2, z, (Function1) objRememberedValue, false, composer, 6, 8);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.Invite_people_to_contribute, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131066);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCollaboratorsCheckbox$lambda$0$0$0$0(Store store, boolean z) {
        store.send(new CreateFolderReducer.Action.InviteCollaboratorsChecked(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CreateFolderReducer.State CreateFolderDialog$lambda$0(State<CreateFolderReducer.State> state) {
        return state.getValue();
    }
}
