package com.box.android.inbox.notifications.inboxitem.collab;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemCollaborationViewDetailsButton.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a9\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"InboxItemCollaborationViewDetailsButton", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "", "textRes", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZILandroidx/compose/runtime/Composer;II)V", "InboxItemCollaborationViewDetailsButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemCollaborationViewDetailsButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaborationViewDetailsButton$lambda$1(Function0 function0, Modifier modifier, boolean z, int i, int i2, int i3, Composer composer, int i4) {
        InboxItemCollaborationViewDetailsButton(function0, modifier, z, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaborationViewDetailsButtonPreview$lambda$1(int i, Composer composer, int i2) {
        InboxItemCollaborationViewDetailsButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:46:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0099  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x013c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0144  */
    /* JADX WARN: Code duplicated, block: B:67:0x0150  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemCollaborationViewDetailsButton(final Function0<Unit> onClick, Modifier modifier, boolean z, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        final int i10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final int i11;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(78010005);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCollaborationViewDetailsButton)N(onClick,modifier,isEnabled,textRes)35@1337L6,34@1285L86,37@1378L187,26@980L585:InboxItemCollaborationViewDetailsButton.kt#46vz6n");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 8;
                if (i7 != 0) {
                    if ((i2 & 3072) == 0) {
                        i8 = i;
                        if (composerStartRestartGroup.changed(i8)) {
                            i9 = 2048;
                        } else {
                            i9 = 1024;
                        }
                        i4 |= i9;
                    }
                    if ((i4 & 1171) != 1170) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        i10 = i8;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i7 != 0) {
                            i11 = R.string.inbox_view_details;
                        } else {
                            i11 = i8;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
                        }
                        Modifier modifier5 = modifier4;
                        int i13 = (i4 & 14) | 817889280 | (i4 & 896);
                        int i14 = i11;
                        boolean z5 = z2;
                        ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z5, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i13, 352);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z5;
                        i10 = i14;
                        modifier3 = modifier5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 3072;
                i8 = i;
                if ((i4 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    i10 = i8;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i7 != 0) {
                        i11 = R.string.inbox_view_details;
                    } else {
                        i11 = i8;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
                    }
                    Modifier modifier6 = modifier4;
                    int i15 = (i4 & 14) | 817889280 | (i4 & 896);
                    int i16 = i11;
                    boolean z6 = z2;
                    ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i15, 352);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                    i10 = i16;
                    modifier3 = modifier6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 384;
            z2 = z;
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i4 |= i9;
                }
                if ((i4 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    i10 = i8;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i7 != 0) {
                        i11 = R.string.inbox_view_details;
                    } else {
                        i11 = i8;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
                    }
                    Modifier modifier7 = modifier4;
                    int i17 = (i4 & 14) | 817889280 | (i4 & 896);
                    int i18 = i11;
                    boolean z7 = z2;
                    ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z7, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i17, 352);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z7;
                    i10 = i18;
                    modifier3 = modifier7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            i8 = i;
            if ((i4 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                i10 = i8;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if (i7 != 0) {
                    i11 = R.string.inbox_view_details;
                } else {
                    i11 = i8;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
                }
                Modifier modifier8 = modifier4;
                int i19 = (i4 & 14) | 817889280 | (i4 & 896);
                int i110 = i11;
                boolean z8 = z2;
                ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z8, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i19, 352);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z8;
                i10 = i110;
                modifier3 = modifier8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 != 0) {
            if ((i2 & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i4 |= i6;
            }
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i4 |= i9;
                }
                if ((i4 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    i10 = i8;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i7 != 0) {
                        i11 = R.string.inbox_view_details;
                    } else {
                        i11 = i8;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
                    }
                    Modifier modifier9 = modifier4;
                    int i111 = (i4 & 14) | 817889280 | (i4 & 896);
                    int i112 = i11;
                    boolean z9 = z2;
                    ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z9, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i111, 352);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z9;
                    i10 = i112;
                    modifier3 = modifier9;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            i8 = i;
            if ((i4 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                i10 = i8;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if (i7 != 0) {
                    i11 = R.string.inbox_view_details;
                } else {
                    i11 = i8;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
                }
                Modifier modifier10 = modifier4;
                int i113 = (i4 & 14) | 817889280 | (i4 & 896);
                int i114 = i11;
                boolean z10 = z2;
                ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z10, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i113, 352);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z10;
                i10 = i114;
                modifier3 = modifier10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        z2 = z;
        i7 = i3 & 8;
        if (i7 != 0) {
            if ((i2 & 3072) == 0) {
                i8 = i;
                if (composerStartRestartGroup.changed(i8)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i4 |= i9;
            }
            if ((i4 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                i10 = i8;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if (i7 != 0) {
                    i11 = R.string.inbox_view_details;
                } else {
                    i11 = i8;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
                }
                Modifier modifier11 = modifier4;
                int i115 = (i4 & 14) | 817889280 | (i4 & 896);
                int i116 = i11;
                boolean z11 = z2;
                ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z11, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i115, 352);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z11;
                i10 = i116;
                modifier3 = modifier11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        i8 = i;
        if ((i4 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            i10 = i8;
        } else {
            if (i12 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i5 != 0) {
                z2 = true;
            }
            if (i7 != 0) {
                i11 = R.string.inbox_view_details;
            } else {
                i11 = i8;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(78010005, i4, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton (InboxItemCollaborationViewDetailsButton.kt:25)");
            }
            Modifier modifier12 = modifier4;
            int i117 = (i4 & 14) | 817889280 | (i4 & 896);
            int i118 = i11;
            boolean z12 = z2;
            ButtonKt.Button(onClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier4, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z12, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(334254245, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$0(i11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i117, 352);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z12;
            i10 = i118;
            modifier3 = modifier12;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButton$lambda$1(onClick, modifier3, z4, i10, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaborationViewDetailsButton$lambda$0(int i, RowScope Button, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C39@1413L23,40@1467L6,38@1388L171:InboxItemCollaborationViewDetailsButton.kt#46vz6n");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(334254245, i2, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButton.<anonymous> (InboxItemCollaborationViewDetailsButton.kt:38)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11535getMainActiveControlContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void InboxItemCollaborationViewDetailsButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1266519219);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCollaborationViewDetailsButtonPreview)52@1778L3,51@1719L94:InboxItemCollaborationViewDetailsButton.kt#46vz6n");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1266519219, i, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonPreview (InboxItemCollaborationViewDetailsButton.kt:50)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1649220912, "CC(remember):InboxItemCollaborationViewDetailsButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            InboxItemCollaborationViewDetailsButton((Function0) objRememberedValue, null, true, 0, composerStartRestartGroup, 390, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationViewDetailsButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCollaborationViewDetailsButtonKt.InboxItemCollaborationViewDetailsButtonPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
