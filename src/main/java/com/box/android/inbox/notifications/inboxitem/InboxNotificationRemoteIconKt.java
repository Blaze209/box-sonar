package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.compose.GlideImageKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InboxNotificationRemoteIcon.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"InboxNotificationRemoteIcon", "", "resourceId", "", "remoteUrl", "", "contentDescription", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "InboxNotificationRemoteIcon-Sj8uqqQ", "(ILjava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationRemoteIconKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxNotificationRemoteIcon_Sj8uqqQ$lambda$2(int i, String str, String str2, Color color, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        m12682InboxNotificationRemoteIconSj8uqqQ(i, str, str2, color, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:87:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x020d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0233  */
    /* JADX WARN: Code duplicated, block: B:96:0x023a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0246  */
    /* JADX INFO: renamed from: InboxNotificationRemoteIcon-Sj8uqqQ, reason: not valid java name */
    public static final void m12682InboxNotificationRemoteIconSj8uqqQ(final int i, final String str, final String str2, Color color, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        String str3;
        Color color2;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z;
        Composer composer2;
        final Color color3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Color color4;
        String str4;
        ColorFilter colorFilterM6855tintxETnrds$default;
        Modifier modifier4;
        ColorFilter colorFilterM6855tintxETnrds$default2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1126830111);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxNotificationRemoteIcon)N(resourceId,remoteUrl,contentDescription,tint:c#ui.graphics.Color,modifier):InboxNotificationRemoteIcon.kt#2fg1pg");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            str3 = str2;
            i4 |= composerStartRestartGroup.changed(str3) ? 256 : 128;
        } else {
            str3 = str2;
        }
        int i7 = i3 & 8;
        if (i7 == 0) {
            if ((i2 & 3072) == 0) {
                color2 = color;
                i4 |= composerStartRestartGroup.changed(color2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                if ((i4 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    color3 = color2;
                    modifier3 = modifier2;
                } else {
                    if (i7 != 0) {
                        color4 = null;
                    } else {
                        color4 = color2;
                    }
                    if (i5 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1126830111, i4, -1, "com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIcon (InboxNotificationRemoteIcon.kt:37)");
                    }
                    str4 = str;
                    if (str4 == null && !StringsKt.isBlank(str4)) {
                        composerStartRestartGroup.startReplaceGroup(-68311707);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "39@1429L494");
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 821032811, "C46@1774L139,40@1505L408:InboxNotificationRemoteIcon.kt#2fg1pg");
                        ContentScale fit = ContentScale.INSTANCE.getFit();
                        if (color4 != null) {
                            colorFilterM6855tintxETnrds$default2 = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                        } else {
                            colorFilterM6855tintxETnrds$default2 = null;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1358980053, "CC(remember):InboxNotificationRemoteIcon.kt#9igjgp");
                        boolean z2 = (i4 & 14) == 4;
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIconKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return InboxNotificationRemoteIconKt.InboxNotificationRemoteIcon_Sj8uqqQ$lambda$0$1$0(i, (RequestBuilder) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function1 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i8 = i4 >> 3;
                        int i9 = (i8 & 112) | (i8 & 14) | 24576 | ((i4 >> 6) & 896);
                        modifier4 = modifier2;
                        composer2 = composerStartRestartGroup;
                        GlideImageKt.GlideImage(str, str3, modifier4, null, fit, 0.0f, colorFilterM6855tintxETnrds$default2, null, null, null, function1, composer2, i9, 0, 936);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        Modifier modifier5 = modifier2;
                        composerStartRestartGroup.startReplaceGroup(-67807120);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "54@1974L27,53@1945L259");
                        Painter painterPainterResource = PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14);
                        ContentScale fit2 = ContentScale.INSTANCE.getFit();
                        if (color4 != null) {
                            colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                        } else {
                            colorFilterM6855tintxETnrds$default = null;
                        }
                        ImageKt.Image(painterPainterResource, str2, modifier5, (Alignment) null, fit2, 0.0f, colorFilterM6855tintxETnrds$default, composerStartRestartGroup, Painter.$stable | 24576 | ((i4 >> 3) & 112) | ((i4 >> 6) & 896), 40);
                        modifier4 = modifier5;
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    color3 = color4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIconKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InboxNotificationRemoteIconKt.InboxNotificationRemoteIcon_Sj8uqqQ$lambda$2(i, str, str2, color3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            modifier2 = modifier;
            if ((i4 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                color3 = color2;
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    color4 = null;
                } else {
                    color4 = color2;
                }
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1126830111, i4, -1, "com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIcon (InboxNotificationRemoteIcon.kt:37)");
                }
                str4 = str;
                if (str4 == null) {
                    Modifier modifier6 = modifier2;
                    composerStartRestartGroup.startReplaceGroup(-67807120);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@1974L27,53@1945L259");
                    Painter painterPainterResource2 = PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14);
                    ContentScale fit3 = ContentScale.INSTANCE.getFit();
                    if (color4 != null) {
                        colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                    } else {
                        colorFilterM6855tintxETnrds$default = null;
                    }
                    ImageKt.Image(painterPainterResource2, str2, modifier6, (Alignment) null, fit3, 0.0f, colorFilterM6855tintxETnrds$default, composerStartRestartGroup, Painter.$stable | 24576 | ((i4 >> 3) & 112) | ((i4 >> 6) & 896), 40);
                    modifier4 = modifier6;
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    Modifier modifier7 = modifier2;
                    composerStartRestartGroup.startReplaceGroup(-67807120);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@1974L27,53@1945L259");
                    Painter painterPainterResource3 = PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14);
                    ContentScale fit4 = ContentScale.INSTANCE.getFit();
                    if (color4 != null) {
                        colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                    } else {
                        colorFilterM6855tintxETnrds$default = null;
                    }
                    ImageKt.Image(painterPainterResource3, str2, modifier7, (Alignment) null, fit4, 0.0f, colorFilterM6855tintxETnrds$default, composerStartRestartGroup, Painter.$stable | 24576 | ((i4 >> 3) & 112) | ((i4 >> 6) & 896), 40);
                    modifier4 = modifier7;
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                color3 = color4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxNotificationRemoteIconKt.InboxNotificationRemoteIcon_Sj8uqqQ$lambda$2(i, str, str2, color3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        color2 = color;
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i4 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                color3 = color2;
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    color4 = null;
                } else {
                    color4 = color2;
                }
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1126830111, i4, -1, "com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIcon (InboxNotificationRemoteIcon.kt:37)");
                }
                str4 = str;
                if (str4 == null) {
                    Modifier modifier8 = modifier2;
                    composerStartRestartGroup.startReplaceGroup(-67807120);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@1974L27,53@1945L259");
                    Painter painterPainterResource4 = PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14);
                    ContentScale fit5 = ContentScale.INSTANCE.getFit();
                    if (color4 != null) {
                        colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                    } else {
                        colorFilterM6855tintxETnrds$default = null;
                    }
                    ImageKt.Image(painterPainterResource4, str2, modifier8, (Alignment) null, fit5, 0.0f, colorFilterM6855tintxETnrds$default, composerStartRestartGroup, Painter.$stable | 24576 | ((i4 >> 3) & 112) | ((i4 >> 6) & 896), 40);
                    modifier4 = modifier8;
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    Modifier modifier9 = modifier2;
                    composerStartRestartGroup.startReplaceGroup(-67807120);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@1974L27,53@1945L259");
                    Painter painterPainterResource5 = PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14);
                    ContentScale fit6 = ContentScale.INSTANCE.getFit();
                    if (color4 != null) {
                        colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                    } else {
                        colorFilterM6855tintxETnrds$default = null;
                    }
                    ImageKt.Image(painterPainterResource5, str2, modifier9, (Alignment) null, fit6, 0.0f, colorFilterM6855tintxETnrds$default, composerStartRestartGroup, Painter.$stable | 24576 | ((i4 >> 3) & 112) | ((i4 >> 6) & 896), 40);
                    modifier4 = modifier9;
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                color3 = color4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxNotificationRemoteIconKt.InboxNotificationRemoteIcon_Sj8uqqQ$lambda$2(i, str, str2, color3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        if ((i4 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            color3 = color2;
            modifier3 = modifier2;
        } else {
            if (i7 != 0) {
                color4 = null;
            } else {
                color4 = color2;
            }
            if (i5 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1126830111, i4, -1, "com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIcon (InboxNotificationRemoteIcon.kt:37)");
            }
            str4 = str;
            if (str4 == null) {
                Modifier modifier10 = modifier2;
                composerStartRestartGroup.startReplaceGroup(-67807120);
                ComposerKt.sourceInformation(composerStartRestartGroup, "54@1974L27,53@1945L259");
                Painter painterPainterResource6 = PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14);
                ContentScale fit7 = ContentScale.INSTANCE.getFit();
                if (color4 != null) {
                    colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                } else {
                    colorFilterM6855tintxETnrds$default = null;
                }
                ImageKt.Image(painterPainterResource6, str2, modifier10, (Alignment) null, fit7, 0.0f, colorFilterM6855tintxETnrds$default, composerStartRestartGroup, Painter.$stable | 24576 | ((i4 >> 3) & 112) | ((i4 >> 6) & 896), 40);
                modifier4 = modifier10;
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                Modifier modifier11 = modifier2;
                composerStartRestartGroup.startReplaceGroup(-67807120);
                ComposerKt.sourceInformation(composerStartRestartGroup, "54@1974L27,53@1945L259");
                Painter painterPainterResource7 = PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14);
                ContentScale fit8 = ContentScale.INSTANCE.getFit();
                if (color4 != null) {
                    colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, color4.m6824unboximpl(), 0, 2, null);
                } else {
                    colorFilterM6855tintxETnrds$default = null;
                }
                ImageKt.Image(painterPainterResource7, str2, modifier11, (Alignment) null, fit8, 0.0f, colorFilterM6855tintxETnrds$default, composerStartRestartGroup, Painter.$stable | 24576 | ((i4 >> 3) & 112) | ((i4 >> 6) & 896), 40);
                modifier4 = modifier11;
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            color3 = color4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxNotificationRemoteIconKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxNotificationRemoteIconKt.InboxNotificationRemoteIcon_Sj8uqqQ$lambda$2(i, str, str2, color3, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestBuilder InboxNotificationRemoteIcon_Sj8uqqQ$lambda$0$1$0(int i, RequestBuilder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RequestBuilder requestBuilderFallback = it.placeholder(i).error(i).fallback(i);
        Intrinsics.checkNotNullExpressionValue(requestBuilderFallback, "fallback(...)");
        return requestBuilderFallback;
    }
}
