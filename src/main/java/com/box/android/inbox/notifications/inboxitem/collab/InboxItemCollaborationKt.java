package com.box.android.inbox.notifications.inboxitem.collab;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.R;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.inbox.mfasetup.MfaSetupDialogKt;
import com.box.android.utilities.PreviewModels;
import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InboxItemCollaboration.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0003\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"InboxItemCollaboration", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$State;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "toStringRes", "", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "InboxItemCollaborationPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemCollaborationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$7(Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemCollaboration(store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaborationPreview$lambda$0(int i, Composer composer, int i2) {
        InboxItemCollaborationPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0241  */
    /* JADX WARN: Code duplicated, block: B:102:0x0243  */
    /* JADX WARN: Code duplicated, block: B:105:0x024a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0252  */
    /* JADX WARN: Code duplicated, block: B:110:0x026c  */
    /* JADX WARN: Code duplicated, block: B:113:0x0273  */
    /* JADX WARN: Code duplicated, block: B:115:0x027b  */
    /* JADX WARN: Code duplicated, block: B:117:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:119:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:121:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:122:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:125:0x02db  */
    /* JADX WARN: Code duplicated, block: B:127:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:130:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:133:0x0304  */
    /* JADX WARN: Code duplicated, block: B:135:0x030c  */
    /* JADX WARN: Code duplicated, block: B:137:0x032e  */
    /* JADX WARN: Code duplicated, block: B:139:0x0336  */
    /* JADX WARN: Code duplicated, block: B:141:0x0357  */
    /* JADX WARN: Code duplicated, block: B:143:0x0371  */
    /* JADX WARN: Code duplicated, block: B:145:0x0379  */
    /* JADX WARN: Code duplicated, block: B:147:0x038c  */
    /* JADX WARN: Code duplicated, block: B:148:0x038e  */
    /* JADX WARN: Code duplicated, block: B:151:0x0395  */
    /* JADX WARN: Code duplicated, block: B:153:0x039d  */
    /* JADX WARN: Code duplicated, block: B:156:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:157:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:160:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:162:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:165:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:168:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:170:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:175:0x042a  */
    /* JADX WARN: Code duplicated, block: B:177:0x0430  */
    /* JADX WARN: Code duplicated, block: B:179:0x043f  */
    /* JADX WARN: Code duplicated, block: B:181:0x044e  */
    /* JADX WARN: Code duplicated, block: B:184:0x0457  */
    /* JADX WARN: Code duplicated, block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x008b  */
    /* JADX WARN: Code duplicated, block: B:36:0x008d  */
    /* JADX WARN: Code duplicated, block: B:41:0x009c  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:61:0x0108  */
    /* JADX WARN: Code duplicated, block: B:63:0x0133  */
    /* JADX WARN: Code duplicated, block: B:65:0x013c  */
    /* JADX WARN: Code duplicated, block: B:67:0x014f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0151  */
    /* JADX WARN: Code duplicated, block: B:73:0x0165  */
    /* JADX WARN: Code duplicated, block: B:76:0x018b  */
    /* JADX WARN: Code duplicated, block: B:78:0x018f  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:88:0x01da  */
    /* JADX WARN: Code duplicated, block: B:90:0x01de  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:93:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:96:0x020f  */
    /* JADX WARN: Code duplicated, block: B:97:0x021c  */
    /* JADX WARN: Code duplicated, block: B:99:0x022e  */
    public static final void InboxItemCollaboration(final Store<InboxItemCollaborationReducer.State, InboxItemCollaborationReducer.Action> store, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        State stateCollectAsStateWithLifecycle;
        String str;
        int i5;
        boolean z2;
        InboxItemCollaborationKt$InboxItemCollaboration$1$1 inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue;
        final InboxItemCollaborationReducer.CollaborationDisplayState displayState;
        int i6;
        Modifier modifier4;
        boolean z3;
        Object objRememberedValue;
        boolean z4;
        boolean zChanged;
        Object objRememberedValue2;
        InboxItemCollaborationReducer.DialogState dialogState;
        Modifier modifier5;
        boolean z5;
        Object objRememberedValue3;
        boolean z6;
        Object objRememberedValue4;
        boolean z7;
        Object objRememberedValue5;
        InboxItemCollaborationKt$InboxItemCollaboration$6$6$1 inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue;
        boolean z8;
        Object objRememberedValue6;
        Object objRememberedValue7;
        boolean z9;
        Object objRememberedValue8;
        Object objRememberedValue9;
        boolean z10;
        Object objRememberedValue10;
        boolean z11;
        Object objRememberedValue11;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(898588439);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCollaboration)N(store,modifier)25@1129L29,27@1185L75,27@1164L96:InboxItemCollaboration.kt#46vz6n");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(898588439, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaboration (InboxItemCollaboration.kt:24)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Unit unit = Unit.INSTANCE;
                str = "CC(remember):InboxItemCollaboration.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255071266, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                i5 = i4 & 14;
                if (i5 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue = new InboxItemCollaborationKt$InboxItemCollaboration$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue, composerStartRestartGroup, 6);
                displayState = InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).getDisplayState();
                if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Actions.AcceptDecline) {
                    composerStartRestartGroup.startReplaceGroup(-682498176);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "34@1482L72,35@1589L73,33@1419L339");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255080767, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                    if (i5 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (!z10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$2$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Function0 function0 = (Function0) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255084192, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                    if (i5 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (!z11 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier6 = modifier3;
                    i6 = i5;
                    InboxItemCollaborationActionsKt.InboxItemCollaborationActions(function0, (Function0) objRememberedValue11, modifier6, InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).isEnabled(), composerStartRestartGroup, (i4 << 3) & 896, 0);
                    modifier4 = modifier6;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    Modifier modifier7 = modifier3;
                    i6 = i5;
                    modifier4 = modifier7;
                    if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Actions.RequirementDetails) {
                        composerStartRestartGroup.startReplaceGroup(-682042073);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "43@1948L105,42@1881L268");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255095712, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                        if (i6 == 4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        zChanged = z4 | composerStartRestartGroup.changed(displayState);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$4$0(store, displayState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton((Function0) objRememberedValue2, modifier4, InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).isEnabled(), 0, composerStartRestartGroup, i4 & 112, 8);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Actions.MFASetup) {
                            composerStartRestartGroup.startReplaceGroup(-681663749);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "51@2329L65,50@2262L280");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255107864, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                            if (i6 == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$5$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton((Function0) objRememberedValue, modifier4, InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).isEnabled(), R.string.inbox_setup_mfa, composerStartRestartGroup, (i4 & 112) | 3072, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Status) {
                            composerStartRestartGroup.startReplaceGroup(-681288215);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "59@2645L138");
                            InboxItemCollaborationStatusKt.InboxItemCollaborationStatus(((InboxItemCollaborationReducer.CollaborationDisplayState.Status) displayState).getStatus(), modifier4, composerStartRestartGroup, i4 & 112, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Hidden) {
                                composerStartRestartGroup.startReplaceGroup(255075438);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-681052832);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        dialogState = InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).getDialogState();
                        if (dialogState == null) {
                            composerStartRestartGroup.startReplaceGroup(-680895601);
                            composerStartRestartGroup.endReplaceGroup();
                            modifier5 = modifier4;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-680895600);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (dialogState instanceof InboxItemCollaborationReducer.DialogState.CollaborationError) {
                                composerStartRestartGroup.startReplaceGroup(327729455);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "78@3379L66,81@3576L66,73@3093L567");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257507102, str);
                                if (i6 == 4) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (!z9 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue8 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$0$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue8, R.string.button_ok);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257513406, str);
                                z7 = i6 == 4;
                                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                if (!z7 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue9 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$1$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                modifier5 = modifier4;
                                BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_collaboration_error_title, R.string.inbox_collaboration_error_message, textButtonItem, null, null, (Function0) objRememberedValue9, 0L, 0L, composerStartRestartGroup, 54, JfifUtil.MARKER_SOI);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                modifier5 = modifier4;
                                if (dialogState instanceof InboxItemCollaborationReducer.DialogState.RequirementDetails) {
                                    composerStartRestartGroup.startReplaceGroup(328404015);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "91@4059L66,94@4256L66,86@3773L567");
                                    InboxItemCollaborationReducer.DialogState.RequirementDetails requirementDetails = (InboxItemCollaborationReducer.DialogState.RequirementDetails) dialogState;
                                    int stringRes = toStringRes(requirementDetails.getRequirementType());
                                    int stringRes2 = toStringRes(requirementDetails.getRequirementType());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257528862, str);
                                    if (i6 == 4) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                    if (!z8 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda12
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$2$0(store);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ButtonItem.TextButtonItem textButtonItem2 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue6, R.string.button_ok);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257535166, str);
                                    z7 = i6 == 4;
                                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                    if (!z7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue7 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$3$0(store);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(stringRes, stringRes2, textButtonItem2, null, null, (Function0) objRememberedValue7, 0L, 0L, composerStartRestartGroup, 0, JfifUtil.MARKER_SOI);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.MFASetup.INSTANCE)) {
                                    composerStartRestartGroup.startReplaceGroup(329056193);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4603L58,99@4440L261");
                                    InboxItemCollaborationKt$InboxItemCollaboration$6$5 inboxItemCollaborationKt$InboxItemCollaboration$6$5 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$InboxItemCollaboration$6$5
                                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                        public Object get(Object obj) {
                                            return ((InboxItemCollaborationReducer.State) obj).getMfaSetupDialogState();
                                        }
                                    };
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257546262, str);
                                    inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = InboxItemCollaborationKt$InboxItemCollaboration$6$6$1.INSTANCE;
                                        composerStartRestartGroup.updateRememberedValue(inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    MfaSetupDialogKt.MfaSetupDialog(store.scope(inboxItemCollaborationKt$InboxItemCollaboration$6$5, (Function1) ((KFunction) inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue)), composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.DeclineConfirmation.INSTANCE)) {
                                        composerStartRestartGroup.startReplaceGroup(1257496820);
                                        composerStartRestartGroup.endReplaceGroup();
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    composerStartRestartGroup.startReplaceGroup(329443507);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "113@5088L80,118@5393L66,121@5579L66,108@4812L851");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257561804, str);
                                    if (i6 == 4) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda2
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$5$0(store);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ButtonItem.TextButtonItem textButtonItem3 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue3, R.string.inbox_collaboration_decline);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257571550, str);
                                    if (i6 == 4) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (!z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$6$0(store);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ButtonItem.TextButtonItem textButtonItem4 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue4, R.string.box_sharesdk_cancel);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257577502, str);
                                    z7 = i6 == 4;
                                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (!z7 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue5 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$7$0(store);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_decline_invite_title, R.string.inbox_decline_invite_message, textButtonItem3, textButtonItem4, null, (Function0) objRememberedValue5, 0L, 0L, composerStartRestartGroup, 54, 208);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit3 = Unit.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier5;
                    }
                }
                str = "CC(remember):InboxItemCollaboration.kt#9igjgp";
                dialogState = InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).getDialogState();
                if (dialogState == null) {
                    composerStartRestartGroup.startReplaceGroup(-680895601);
                    composerStartRestartGroup.endReplaceGroup();
                    modifier5 = modifier4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-680895600);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (dialogState instanceof InboxItemCollaborationReducer.DialogState.CollaborationError) {
                        composerStartRestartGroup.startReplaceGroup(327729455);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@3379L66,81@3576L66,73@3093L567");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257507102, str);
                        if (i6 == 4) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ButtonItem.TextButtonItem textButtonItem5 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue8, R.string.button_ok);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257513406, str);
                        if (i6 == 4) {
                        }
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue9 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier5 = modifier4;
                        BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_collaboration_error_title, R.string.inbox_collaboration_error_message, textButtonItem5, null, null, (Function0) objRememberedValue9, 0L, 0L, composerStartRestartGroup, 54, JfifUtil.MARKER_SOI);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier5 = modifier4;
                        if (dialogState instanceof InboxItemCollaborationReducer.DialogState.RequirementDetails) {
                            composerStartRestartGroup.startReplaceGroup(328404015);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "91@4059L66,94@4256L66,86@3773L567");
                            InboxItemCollaborationReducer.DialogState.RequirementDetails requirementDetails2 = (InboxItemCollaborationReducer.DialogState.RequirementDetails) dialogState;
                            int stringRes3 = toStringRes(requirementDetails2.getRequirementType());
                            int stringRes4 = toStringRes(requirementDetails2.getRequirementType());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257528862, str);
                            if (i6 == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$2$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$2$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ButtonItem.TextButtonItem textButtonItem6 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue6, R.string.button_ok);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257535166, str);
                            if (i6 == 4) {
                            }
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (!z7) {
                                objRememberedValue7 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$3$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            } else {
                                objRememberedValue7 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$3$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(stringRes3, stringRes4, textButtonItem6, null, null, (Function0) objRememberedValue7, 0L, 0L, composerStartRestartGroup, 0, JfifUtil.MARKER_SOI);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.MFASetup.INSTANCE)) {
                            composerStartRestartGroup.startReplaceGroup(329056193);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "102@4603L58,99@4440L261");
                            InboxItemCollaborationKt$InboxItemCollaboration$6$5 inboxItemCollaborationKt$InboxItemCollaboration$6$6 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$InboxItemCollaboration$6$5
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((InboxItemCollaborationReducer.State) obj).getMfaSetupDialogState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257546262, str);
                            inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = InboxItemCollaborationKt$InboxItemCollaboration$6$6$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            MfaSetupDialogKt.MfaSetupDialog(store.scope(inboxItemCollaborationKt$InboxItemCollaboration$6$6, (Function1) ((KFunction) inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.DeclineConfirmation.INSTANCE)) {
                                composerStartRestartGroup.startReplaceGroup(1257496820);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(329443507);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "113@5088L80,118@5393L66,121@5579L66,108@4812L851");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257561804, str);
                            if (i6 == 4) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z5) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$5$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$5$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ButtonItem.TextButtonItem textButtonItem7 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue3, R.string.inbox_collaboration_decline);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257571550, str);
                            if (i6 == 4) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$6$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$6$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ButtonItem.TextButtonItem textButtonItem8 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue4, R.string.box_sharesdk_cancel);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257577502, str);
                            if (i6 == 4) {
                            }
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!z7) {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$7$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$7$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_decline_invite_title, R.string.inbox_decline_invite_message, textButtonItem7, textButtonItem8, null, (Function0) objRememberedValue5, 0L, 0L, composerStartRestartGroup, 54, 208);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    Unit unit4 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit5 = Unit.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$7(store, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i7 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(898588439, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaboration (InboxItemCollaboration.kt:24)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Unit unit6 = Unit.INSTANCE;
            str = "CC(remember):InboxItemCollaboration.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255071266, "CC(remember):InboxItemCollaboration.kt#9igjgp");
            i5 = i4 & 14;
            if (i5 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue = new InboxItemCollaborationKt$InboxItemCollaboration$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue);
            } else {
                inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue = new InboxItemCollaborationKt$InboxItemCollaboration$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) inboxItemCollaborationKt$InboxItemCollaboration$1$1RememberedValue, composerStartRestartGroup, 6);
            displayState = InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).getDisplayState();
            if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Actions.AcceptDecline) {
                composerStartRestartGroup.startReplaceGroup(-682498176);
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1482L72,35@1589L73,33@1419L339");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255080767, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                if (i5 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue10 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                Function0 function1 = (Function0) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255084192, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                if (i5 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue11 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier8 = modifier3;
                i6 = i5;
                InboxItemCollaborationActionsKt.InboxItemCollaborationActions(function1, (Function0) objRememberedValue11, modifier8, InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).isEnabled(), composerStartRestartGroup, (i4 << 3) & 896, 0);
                modifier4 = modifier8;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                Modifier modifier9 = modifier3;
                i6 = i5;
                modifier4 = modifier9;
                if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Actions.RequirementDetails) {
                    composerStartRestartGroup.startReplaceGroup(-682042073);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "43@1948L105,42@1881L268");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255095712, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                    if (i6 == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChanged = z4 | composerStartRestartGroup.changed(displayState);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$4$0(store, displayState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$4$0(store, displayState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton((Function0) objRememberedValue2, modifier4, InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).isEnabled(), 0, composerStartRestartGroup, i4 & 112, 8);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Actions.MFASetup) {
                        composerStartRestartGroup.startReplaceGroup(-681663749);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "51@2329L65,50@2262L280");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 255107864, "CC(remember):InboxItemCollaboration.kt#9igjgp");
                        if (i6 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton((Function0) objRememberedValue, modifier4, InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).isEnabled(), R.string.inbox_setup_mfa, composerStartRestartGroup, (i4 & 112) | 3072, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Status) {
                        composerStartRestartGroup.startReplaceGroup(-681288215);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "59@2645L138");
                        InboxItemCollaborationStatusKt.InboxItemCollaborationStatus(((InboxItemCollaborationReducer.CollaborationDisplayState.Status) displayState).getStatus(), modifier4, composerStartRestartGroup, i4 & 112, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (displayState instanceof InboxItemCollaborationReducer.CollaborationDisplayState.Hidden) {
                            composerStartRestartGroup.startReplaceGroup(255075438);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-681052832);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    dialogState = InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).getDialogState();
                    if (dialogState == null) {
                        composerStartRestartGroup.startReplaceGroup(-680895601);
                        composerStartRestartGroup.endReplaceGroup();
                        modifier5 = modifier4;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-680895600);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (dialogState instanceof InboxItemCollaborationReducer.DialogState.CollaborationError) {
                            composerStartRestartGroup.startReplaceGroup(327729455);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "78@3379L66,81@3576L66,73@3093L567");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257507102, str);
                            if (i6 == 4) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (!z9) {
                                objRememberedValue8 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            } else {
                                objRememberedValue8 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ButtonItem.TextButtonItem textButtonItem9 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue8, R.string.button_ok);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257513406, str);
                            if (i6 == 4) {
                            }
                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (!z7) {
                                objRememberedValue9 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            modifier5 = modifier4;
                            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_collaboration_error_title, R.string.inbox_collaboration_error_message, textButtonItem9, null, null, (Function0) objRememberedValue9, 0L, 0L, composerStartRestartGroup, 54, JfifUtil.MARKER_SOI);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            modifier5 = modifier4;
                            if (dialogState instanceof InboxItemCollaborationReducer.DialogState.RequirementDetails) {
                                composerStartRestartGroup.startReplaceGroup(328404015);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "91@4059L66,94@4256L66,86@3773L567");
                                InboxItemCollaborationReducer.DialogState.RequirementDetails requirementDetails3 = (InboxItemCollaborationReducer.DialogState.RequirementDetails) dialogState;
                                int stringRes5 = toStringRes(requirementDetails3.getRequirementType());
                                int stringRes6 = toStringRes(requirementDetails3.getRequirementType());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257528862, str);
                                if (i6 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (!z8) {
                                    objRememberedValue6 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$2$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                } else {
                                    objRememberedValue6 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$2$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ButtonItem.TextButtonItem textButtonItem10 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue6, R.string.button_ok);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257535166, str);
                                if (i6 == 4) {
                                }
                                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (!z7) {
                                    objRememberedValue7 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$3$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                } else {
                                    objRememberedValue7 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$3$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(stringRes5, stringRes6, textButtonItem10, null, null, (Function0) objRememberedValue7, 0L, 0L, composerStartRestartGroup, 0, JfifUtil.MARKER_SOI);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.MFASetup.INSTANCE)) {
                                composerStartRestartGroup.startReplaceGroup(329056193);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4603L58,99@4440L261");
                                InboxItemCollaborationKt$InboxItemCollaboration$6$5 inboxItemCollaborationKt$InboxItemCollaboration$6$7 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$InboxItemCollaboration$6$5
                                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                    public Object get(Object obj) {
                                        return ((InboxItemCollaborationReducer.State) obj).getMfaSetupDialogState();
                                    }
                                };
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257546262, str);
                                inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = InboxItemCollaborationKt$InboxItemCollaboration$6$6$1.INSTANCE;
                                    composerStartRestartGroup.updateRememberedValue(inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                MfaSetupDialogKt.MfaSetupDialog(store.scope(inboxItemCollaborationKt$InboxItemCollaboration$6$7, (Function1) ((KFunction) inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue)), composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.DeclineConfirmation.INSTANCE)) {
                                    composerStartRestartGroup.startReplaceGroup(1257496820);
                                    composerStartRestartGroup.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                                composerStartRestartGroup.startReplaceGroup(329443507);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "113@5088L80,118@5393L66,121@5579L66,108@4812L851");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257561804, str);
                                if (i6 == 4) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z5) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$5$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$5$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ButtonItem.TextButtonItem textButtonItem11 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue3, R.string.inbox_collaboration_decline);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257571550, str);
                                if (i6 == 4) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!z6) {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$6$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                } else {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$6$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ButtonItem.TextButtonItem textButtonItem12 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue4, R.string.box_sharesdk_cancel);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257577502, str);
                                if (i6 == 4) {
                                }
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (!z7) {
                                    objRememberedValue5 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$7$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                } else {
                                    objRememberedValue5 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$7$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_decline_invite_title, R.string.inbox_decline_invite_message, textButtonItem11, textButtonItem12, null, (Function0) objRememberedValue5, 0L, 0L, composerStartRestartGroup, 54, 208);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        Unit unit7 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit8 = Unit.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier5;
                }
            }
            str = "CC(remember):InboxItemCollaboration.kt#9igjgp";
            dialogState = InboxItemCollaboration$lambda$0(stateCollectAsStateWithLifecycle).getDialogState();
            if (dialogState == null) {
                composerStartRestartGroup.startReplaceGroup(-680895601);
                composerStartRestartGroup.endReplaceGroup();
                modifier5 = modifier4;
            } else {
                composerStartRestartGroup.startReplaceGroup(-680895600);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (dialogState instanceof InboxItemCollaborationReducer.DialogState.CollaborationError) {
                    composerStartRestartGroup.startReplaceGroup(327729455);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3379L66,81@3576L66,73@3093L567");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257507102, str);
                    if (i6 == 4) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue8 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonItem.TextButtonItem textButtonItem13 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue8, R.string.button_ok);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257513406, str);
                    if (i6 == 4) {
                    }
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier5 = modifier4;
                    BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_collaboration_error_title, R.string.inbox_collaboration_error_message, textButtonItem13, null, null, (Function0) objRememberedValue9, 0L, 0L, composerStartRestartGroup, 54, JfifUtil.MARKER_SOI);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier5 = modifier4;
                    if (dialogState instanceof InboxItemCollaborationReducer.DialogState.RequirementDetails) {
                        composerStartRestartGroup.startReplaceGroup(328404015);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "91@4059L66,94@4256L66,86@3773L567");
                        InboxItemCollaborationReducer.DialogState.RequirementDetails requirementDetails4 = (InboxItemCollaborationReducer.DialogState.RequirementDetails) dialogState;
                        int stringRes7 = toStringRes(requirementDetails4.getRequirementType());
                        int stringRes8 = toStringRes(requirementDetails4.getRequirementType());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257528862, str);
                        if (i6 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$2$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$2$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ButtonItem.TextButtonItem textButtonItem14 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue6, R.string.button_ok);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257535166, str);
                        if (i6 == 4) {
                        }
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue7 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        } else {
                            objRememberedValue7 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(stringRes7, stringRes8, textButtonItem14, null, null, (Function0) objRememberedValue7, 0L, 0L, composerStartRestartGroup, 0, JfifUtil.MARKER_SOI);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.MFASetup.INSTANCE)) {
                        composerStartRestartGroup.startReplaceGroup(329056193);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "102@4603L58,99@4440L261");
                        InboxItemCollaborationKt$InboxItemCollaboration$6$5 inboxItemCollaborationKt$InboxItemCollaboration$6$8 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$InboxItemCollaboration$6$5
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((InboxItemCollaborationReducer.State) obj).getMfaSetupDialogState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257546262, str);
                        inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue = InboxItemCollaborationKt$InboxItemCollaboration$6$6$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        MfaSetupDialogKt.MfaSetupDialog(store.scope(inboxItemCollaborationKt$InboxItemCollaboration$6$8, (Function1) ((KFunction) inboxItemCollaborationKt$InboxItemCollaboration$6$6$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (Intrinsics.areEqual(dialogState, InboxItemCollaborationReducer.DialogState.DeclineConfirmation.INSTANCE)) {
                            composerStartRestartGroup.startReplaceGroup(1257496820);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(329443507);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "113@5088L80,118@5393L66,121@5579L66,108@4812L851");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257561804, str);
                        if (i6 == 4) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z5) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ButtonItem.TextButtonItem textButtonItem15 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue3, R.string.inbox_collaboration_decline);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257571550, str);
                        if (i6 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$6$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$6$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ButtonItem.TextButtonItem textButtonItem16 = new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue4, R.string.box_sharesdk_cancel);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1257577502, str);
                        if (i6 == 4) {
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$7$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$6$7$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_decline_invite_title, R.string.inbox_decline_invite_message, textButtonItem15, textButtonItem16, null, (Function0) objRememberedValue5, 0L, 0L, composerStartRestartGroup, 54, 208);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                Unit unit9 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit10 = Unit.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCollaborationKt.InboxItemCollaboration$lambda$7(store, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$2$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.AcceptCollaboration.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$3$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.DeclineCollaboration.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$4$0(Store store, InboxItemCollaborationReducer.CollaborationDisplayState collaborationDisplayState) {
        store.send(new InboxItemCollaborationReducer.Action.ShowRequirementDetails(((InboxItemCollaborationReducer.CollaborationDisplayState.Actions.RequirementDetails) collaborationDisplayState).getRequirementType()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$5$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.ShowSetUpMFA.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$6$0$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.DismissDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$6$1$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.DismissDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$6$2$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.DismissDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$6$3$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.DismissDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$6$5$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.ConfirmDeclineCollaboration.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$6$6$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.DismissDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaboration$lambda$6$7$0(Store store) {
        store.send(InboxItemCollaborationReducer.Action.DismissDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final int toStringRes(AcceptanceRequirementType acceptanceRequirementType) {
        if (acceptanceRequirementType instanceof AcceptanceRequirementType.TermsOfService) {
            return R.string.inbox_collaboration_blocked_on_tos;
        }
        if (acceptanceRequirementType instanceof AcceptanceRequirementType.MFA) {
            return R.string.inbox_collaboration_blocked_on_2fa;
        }
        if (acceptanceRequirementType instanceof AcceptanceRequirementType.StrongPassword) {
            return R.string.inbox_collaboration_blocked_on_strong_password;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final void InboxItemCollaborationPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1160424909);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCollaborationPreview)140@6251L283:InboxItemCollaboration.kt#46vz6n");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1160424909, i, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationPreview (InboxItemCollaboration.kt:139)");
            }
            InboxItemCollaboration(ComposePreviewUtilsKt.createMockStore(new InboxItemCollaborationReducer.State(InboxNotificationModel.copy$default(PreviewModels.Inbox.INSTANCE.getMOCK_NOTIFICATION(), null, null, null, false, false, PreviewModels.Inbox.createMockInviteCollabPayload$default(PreviewModels.Inbox.INSTANCE, null, false, 3, null), null, null, 223, null), false, null, null, null, 30, null)), null, composerStartRestartGroup, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCollaborationKt.InboxItemCollaborationPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InboxItemCollaborationReducer.State InboxItemCollaboration$lambda$0(State<InboxItemCollaborationReducer.State> state) {
        return state.getValue();
    }
}
