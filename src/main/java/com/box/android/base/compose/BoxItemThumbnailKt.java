package com.box.android.base.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.R;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxItemThumbnail.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"BoxItemThumbnail", "", "thumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbnailRadius", "Landroidx/compose/ui/unit/Dp;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "overlayIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BoxItemThumbnail-TN_CM5M", "(Lcom/box/android/base/compose/ItemThumbnail;Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;II)V", "ThumbnailContent", "(Lcom/box/android/base/compose/ItemThumbnail;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxItemThumbnailKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxItemThumbnail_TN_CM5M$lambda$1(ItemThumbnail itemThumbnail, Modifier modifier, float f, ContentScale contentScale, ImageVector imageVector, int i, int i2, Composer composer, int i3) {
        m11589BoxItemThumbnailTN_CM5M(itemThumbnail, modifier, f, contentScale, imageVector, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThumbnailContent$lambda$2(ItemThumbnail itemThumbnail, ContentScale contentScale, ImageVector imageVector, int i, int i2, Composer composer, int i3) {
        ThumbnailContent(itemThumbnail, contentScale, imageVector, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:33:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:47:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:67:0x0112  */
    /* JADX WARN: Code duplicated, block: B:70:0x011e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0122  */
    /* JADX WARN: Code duplicated, block: B:74:0x0197  */
    /* JADX WARN: Code duplicated, block: B:76:0x019d  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: BoxItemThumbnail-TN_CM5M, reason: not valid java name */
    public static final void m11589BoxItemThumbnailTN_CM5M(final ItemThumbnail thumbnail, final Modifier modifier, float f, ContentScale contentScale, ImageVector imageVector, Composer composer, final int i, final int i2) {
        int i3;
        float fM9687constructorimpl;
        int i4;
        ContentScale crop;
        int i5;
        int i6;
        ImageVector imageVector2;
        int i7;
        boolean z;
        final ContentScale contentScale2;
        final ImageVector imageVector3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<ComposeUiNode> constructor;
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1807170285);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxItemThumbnail)N(thumbnail,modifier,thumbnailRadius:c#ui.unit.Dp,contentScale,overlayIcon)36@1315L285:BoxItemThumbnail.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(thumbnail) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 384) == 0) {
                fM9687constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM9687constructorimpl) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    crop = contentScale;
                    if (composerStartRestartGroup.changed(crop)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        imageVector2 = imageVector;
                        if (composerStartRestartGroup.changed(imageVector2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        contentScale2 = crop;
                        imageVector3 = imageVector2;
                    } else {
                        if (i8 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(2);
                        }
                        if (i4 != 0) {
                            crop = ContentScale.INSTANCE.getCrop();
                        }
                        if (i6 != 0) {
                            imageVector2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
                        }
                        Modifier modifierClip = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
                        int i9 = i3 & 14;
                        int i10 = i3 >> 6;
                        int i11 = i9 | (i10 & 112) | (i10 & 896);
                        ContentScale contentScale3 = crop;
                        ImageVector imageVector4 = imageVector2;
                        ThumbnailContent(thumbnail, contentScale3, imageVector4, composerStartRestartGroup, i11, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        contentScale2 = contentScale3;
                        imageVector3 = imageVector4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final float f2 = fM9687constructorimpl;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f2, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                imageVector2 = imageVector;
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    contentScale2 = crop;
                    imageVector3 = imageVector2;
                } else {
                    if (i8 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(2);
                    }
                    if (i4 != 0) {
                        crop = ContentScale.INSTANCE.getCrop();
                    }
                    if (i6 != 0) {
                        imageVector2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
                    }
                    Modifier modifierClip2 = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
                    int i12 = i3 & 14;
                    int i13 = i3 >> 6;
                    int i14 = i12 | (i13 & 112) | (i13 & 896);
                    ContentScale contentScale4 = crop;
                    ImageVector imageVector5 = imageVector2;
                    ThumbnailContent(thumbnail, contentScale4, imageVector5, composerStartRestartGroup, i14, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    contentScale2 = contentScale4;
                    imageVector3 = imageVector5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final float f3 = fM9687constructorimpl;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f3, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            crop = contentScale;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    imageVector2 = imageVector;
                    if (composerStartRestartGroup.changed(imageVector2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    contentScale2 = crop;
                    imageVector3 = imageVector2;
                } else {
                    if (i8 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(2);
                    }
                    if (i4 != 0) {
                        crop = ContentScale.INSTANCE.getCrop();
                    }
                    if (i6 != 0) {
                        imageVector2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
                    }
                    Modifier modifierClip3 = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
                    int i15 = i3 & 14;
                    int i16 = i3 >> 6;
                    int i17 = i15 | (i16 & 112) | (i16 & 896);
                    ContentScale contentScale5 = crop;
                    ImageVector imageVector6 = imageVector2;
                    ThumbnailContent(thumbnail, contentScale5, imageVector6, composerStartRestartGroup, i17, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    contentScale2 = contentScale5;
                    imageVector3 = imageVector6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final float f4 = fM9687constructorimpl;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f4, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            imageVector2 = imageVector;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                contentScale2 = crop;
                imageVector3 = imageVector2;
            } else {
                if (i8 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(2);
                }
                if (i4 != 0) {
                    crop = ContentScale.INSTANCE.getCrop();
                }
                if (i6 != 0) {
                    imageVector2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
                }
                Modifier modifierClip4 = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
                int i18 = i3 & 14;
                int i19 = i3 >> 6;
                int i110 = i18 | (i19 & 112) | (i19 & 896);
                ContentScale contentScale6 = crop;
                ImageVector imageVector7 = imageVector2;
                ThumbnailContent(thumbnail, contentScale6, imageVector7, composerStartRestartGroup, i110, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contentScale2 = contentScale6;
                imageVector3 = imageVector7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final float f5 = fM9687constructorimpl;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f5, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        fM9687constructorimpl = f;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                crop = contentScale;
                if (composerStartRestartGroup.changed(crop)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    imageVector2 = imageVector;
                    if (composerStartRestartGroup.changed(imageVector2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    contentScale2 = crop;
                    imageVector3 = imageVector2;
                } else {
                    if (i8 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(2);
                    }
                    if (i4 != 0) {
                        crop = ContentScale.INSTANCE.getCrop();
                    }
                    if (i6 != 0) {
                        imageVector2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
                    }
                    Modifier modifierClip5 = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip5);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
                    int i111 = i3 & 14;
                    int i112 = i3 >> 6;
                    int i113 = i111 | (i112 & 112) | (i112 & 896);
                    ContentScale contentScale7 = crop;
                    ImageVector imageVector8 = imageVector2;
                    ThumbnailContent(thumbnail, contentScale7, imageVector8, composerStartRestartGroup, i113, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    contentScale2 = contentScale7;
                    imageVector3 = imageVector8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final float f6 = fM9687constructorimpl;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f6, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            imageVector2 = imageVector;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                contentScale2 = crop;
                imageVector3 = imageVector2;
            } else {
                if (i8 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(2);
                }
                if (i4 != 0) {
                    crop = ContentScale.INSTANCE.getCrop();
                }
                if (i6 != 0) {
                    imageVector2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
                }
                Modifier modifierClip6 = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip6);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
                int i114 = i3 & 14;
                int i115 = i3 >> 6;
                int i116 = i114 | (i115 & 112) | (i115 & 896);
                ContentScale contentScale8 = crop;
                ImageVector imageVector9 = imageVector2;
                ThumbnailContent(thumbnail, contentScale8, imageVector9, composerStartRestartGroup, i116, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contentScale2 = contentScale8;
                imageVector3 = imageVector9;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final float f7 = fM9687constructorimpl;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f7, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        crop = contentScale;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                imageVector2 = imageVector;
                if (composerStartRestartGroup.changed(imageVector2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                contentScale2 = crop;
                imageVector3 = imageVector2;
            } else {
                if (i8 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(2);
                }
                if (i4 != 0) {
                    crop = ContentScale.INSTANCE.getCrop();
                }
                if (i6 != 0) {
                    imageVector2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
                }
                Modifier modifierClip7 = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
                int i117 = i3 & 14;
                int i118 = i3 >> 6;
                int i119 = i117 | (i118 & 112) | (i118 & 896);
                ContentScale contentScale9 = crop;
                ImageVector imageVector10 = imageVector2;
                ThumbnailContent(thumbnail, contentScale9, imageVector10, composerStartRestartGroup, i119, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contentScale2 = contentScale9;
                imageVector3 = imageVector10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final float f8 = fM9687constructorimpl;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f8, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        imageVector2 = imageVector;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            contentScale2 = crop;
            imageVector3 = imageVector2;
        } else {
            if (i8 != 0) {
                fM9687constructorimpl = Dp.m9687constructorimpl(2);
            }
            if (i4 != 0) {
                crop = ContentScale.INSTANCE.getCrop();
            }
            if (i6 != 0) {
                imageVector2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1807170285, i3, -1, "com.box.android.base.compose.BoxItemThumbnail (BoxItemThumbnail.kt:35)");
            }
            Modifier modifierClip8 = ClipKt.clip(modifier, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip8);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1944580375, "C40@1453L141:BoxItemThumbnail.kt#vejmn0");
            int i1110 = i3 & 14;
            int i1111 = i3 >> 6;
            int i1112 = i1110 | (i1111 & 112) | (i1111 & 896);
            ContentScale contentScale10 = crop;
            ImageVector imageVector11 = imageVector2;
            ThumbnailContent(thumbnail, contentScale10, imageVector11, composerStartRestartGroup, i1112, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentScale2 = contentScale10;
            imageVector3 = imageVector11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final float f9 = fM9687constructorimpl;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxItemThumbnailKt.BoxItemThumbnail_TN_CM5M$lambda$1(thumbnail, modifier, f9, contentScale2, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:57:0x0102  */
    /* JADX WARN: Code duplicated, block: B:59:0x0151  */
    /* JADX WARN: Code duplicated, block: B:62:0x015d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0161  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:69:0x025b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0263  */
    /* JADX WARN: Code duplicated, block: B:72:0x028e  */
    /* JADX WARN: Code duplicated, block: B:76:0x029d  */
    /* JADX WARN: Code duplicated, block: B:78:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:81:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    private static final void ThumbnailContent(final ItemThumbnail itemThumbnail, ContentScale contentScale, ImageVector imageVector, Composer composer, final int i, final int i2) {
        int i3;
        ContentScale contentScale2;
        int i4;
        ImageVector imageVector2;
        int i5;
        boolean z;
        final ContentScale contentScale3;
        final ImageVector imageVector3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ContentScale crop;
        String strStringResource;
        ImageVector imageVector4;
        ContentScale contentScale4;
        Function0<ComposeUiNode> constructor;
        BoxScopeInstance boxScopeInstance;
        Integer contentDescription;
        Composer composerStartRestartGroup = composer.startRestartGroup(510287709);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ThumbnailContent)N(thumbnail,contentScale,overlayIcon):BoxItemThumbnail.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(itemThumbnail) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                contentScale2 = contentScale;
                i3 |= composerStartRestartGroup.changed(contentScale2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    imageVector2 = imageVector;
                    if (composerStartRestartGroup.changed(imageVector2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i3 & Token.DOTQUERY) != 146) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    contentScale3 = contentScale2;
                } else {
                    if (i6 != 0) {
                        crop = ContentScale.INSTANCE.getCrop();
                    } else {
                        crop = contentScale2;
                    }
                    strStringResource = null;
                    if (i4 != 0) {
                        imageVector4 = null;
                    } else {
                        imageVector4 = imageVector2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(510287709, i3, -1, "com.box.android.base.compose.ThumbnailContent (BoxItemThumbnail.kt:49)");
                    }
                    if (itemThumbnail instanceof ItemThumbnail.Icon) {
                        composerStartRestartGroup.startReplaceGroup(2092066385);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "52@1835L34,51@1806L244");
                        ItemThumbnail.Icon icon = (ItemThumbnail.Icon) itemThumbnail;
                        Painter painterPainterResource = PainterResources_androidKt.painterResource(icon.getIconRes(), composerStartRestartGroup, 0);
                        Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:" + icon.getIconRes());
                        contentDescription = icon.getContentDescription();
                        if (contentDescription == null) {
                            composerStartRestartGroup.startReplaceGroup(2092265962);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2092265963);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*54@2020L18");
                            strStringResource = StringResources_androidKt.stringResource(contentDescription.intValue(), composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ImageKt.Image(painterPainterResource, strStringResource, modifierTestTag, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable, 120);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                        contentScale4 = crop;
                        imageVector2 = imageVector4;
                    } else if (itemThumbnail instanceof ItemThumbnail.PreviewThumbnail) {
                        contentScale4 = crop;
                        imageVector2 = imageVector4;
                        if (itemThumbnail instanceof ItemThumbnail.Placeholder) {
                            composerStartRestartGroup.startReplaceGroup(2090266277);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2093279880);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "84@3147L6,81@3042L141");
                            BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11532getItemListingDivider0d7_KjU(), null, 2, null), composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2092388382);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "57@2121L855");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023125109, "C64@2425L45,58@2139L345:BoxItemThumbnail.kt#vejmn0");
                        ContentScale contentScale5 = crop;
                        ImageKt.m656Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(((ItemThumbnail.PreviewThumbnail) itemThumbnail).getThumbnail()), StringResources_androidKt.stringResource(R.string.file_thumbnail_label, composerStartRestartGroup, 0), SizeKt.fillMaxSize$default(TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:BitmapThumbnail"), 0.0f, 1, null), null, contentScale5, 0.0f, null, 0, composerStartRestartGroup, ((i3 << 9) & 57344) | 384, 232);
                        contentScale4 = contentScale5;
                        if (imageVector4 == null) {
                            composerStartRestartGroup.startReplaceGroup(2023482599);
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup = composerStartRestartGroup;
                            imageVector2 = imageVector4;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2023482600);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*76@2894L6,68@2541L411");
                            long jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize(boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(2)), Alignment.INSTANCE.getBottomEnd()), 0.2f), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11573getThumbnailFileIconBackgroundColor0d7_KjU(), null, 2, null);
                            composerStartRestartGroup = composerStartRestartGroup;
                            ImageVector imageVector5 = imageVector4;
                            IconKt.m3576Iconww6aTOc(imageVector5, (String) null, modifierM589backgroundbw27NRU$default, jM6851getWhite0d7_KjU, composerStartRestartGroup, 3120, 0);
                            imageVector2 = imageVector5;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    contentScale3 = contentScale4;
                }
                imageVector3 = imageVector2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxItemThumbnailKt.ThumbnailContent$lambda$2(itemThumbnail, contentScale3, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            imageVector2 = imageVector;
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                contentScale3 = contentScale2;
            } else {
                if (i6 != 0) {
                    crop = ContentScale.INSTANCE.getCrop();
                } else {
                    crop = contentScale2;
                }
                strStringResource = null;
                if (i4 != 0) {
                    imageVector4 = null;
                } else {
                    imageVector4 = imageVector2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(510287709, i3, -1, "com.box.android.base.compose.ThumbnailContent (BoxItemThumbnail.kt:49)");
                }
                if (itemThumbnail instanceof ItemThumbnail.Icon) {
                    composerStartRestartGroup.startReplaceGroup(2092066385);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "52@1835L34,51@1806L244");
                    ItemThumbnail.Icon icon2 = (ItemThumbnail.Icon) itemThumbnail;
                    Painter painterPainterResource2 = PainterResources_androidKt.painterResource(icon2.getIconRes(), composerStartRestartGroup, 0);
                    Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:" + icon2.getIconRes());
                    contentDescription = icon2.getContentDescription();
                    if (contentDescription == null) {
                        composerStartRestartGroup.startReplaceGroup(2092265962);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2092265963);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*54@2020L18");
                        strStringResource = StringResources_androidKt.stringResource(contentDescription.intValue(), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ImageKt.Image(painterPainterResource2, strStringResource, modifierTestTag2, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable, 120);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    contentScale4 = crop;
                    imageVector2 = imageVector4;
                } else if (itemThumbnail instanceof ItemThumbnail.PreviewThumbnail) {
                    contentScale4 = crop;
                    imageVector2 = imageVector4;
                    if (itemThumbnail instanceof ItemThumbnail.Placeholder) {
                        composerStartRestartGroup.startReplaceGroup(2090266277);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2093279880);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "84@3147L6,81@3042L141");
                        BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11532getItemListingDivider0d7_KjU(), null, 2, null), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(2092388382);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "57@2121L855");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023125109, "C64@2425L45,58@2139L345:BoxItemThumbnail.kt#vejmn0");
                    ContentScale contentScale6 = crop;
                    ImageKt.m656Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(((ItemThumbnail.PreviewThumbnail) itemThumbnail).getThumbnail()), StringResources_androidKt.stringResource(R.string.file_thumbnail_label, composerStartRestartGroup, 0), SizeKt.fillMaxSize$default(TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:BitmapThumbnail"), 0.0f, 1, null), null, contentScale6, 0.0f, null, 0, composerStartRestartGroup, ((i3 << 9) & 57344) | 384, 232);
                    contentScale4 = contentScale6;
                    if (imageVector4 == null) {
                        composerStartRestartGroup.startReplaceGroup(2023482599);
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup = composerStartRestartGroup;
                        imageVector2 = imageVector4;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2023482600);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*76@2894L6,68@2541L411");
                        long jM6851getWhite0d7_KjU2 = Color.INSTANCE.m6851getWhite0d7_KjU();
                        Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize(boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(2)), Alignment.INSTANCE.getBottomEnd()), 0.2f), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11573getThumbnailFileIconBackgroundColor0d7_KjU(), null, 2, null);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ImageVector imageVector6 = imageVector4;
                        IconKt.m3576Iconww6aTOc(imageVector6, (String) null, modifierM589backgroundbw27NRU$default2, jM6851getWhite0d7_KjU2, composerStartRestartGroup, 3120, 0);
                        imageVector2 = imageVector6;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contentScale3 = contentScale4;
            }
            imageVector3 = imageVector2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxItemThumbnailKt.ThumbnailContent$lambda$2(itemThumbnail, contentScale3, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        contentScale2 = contentScale;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                imageVector2 = imageVector;
                if (composerStartRestartGroup.changed(imageVector2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                contentScale3 = contentScale2;
            } else {
                if (i6 != 0) {
                    crop = ContentScale.INSTANCE.getCrop();
                } else {
                    crop = contentScale2;
                }
                strStringResource = null;
                if (i4 != 0) {
                    imageVector4 = null;
                } else {
                    imageVector4 = imageVector2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(510287709, i3, -1, "com.box.android.base.compose.ThumbnailContent (BoxItemThumbnail.kt:49)");
                }
                if (itemThumbnail instanceof ItemThumbnail.Icon) {
                    composerStartRestartGroup.startReplaceGroup(2092066385);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "52@1835L34,51@1806L244");
                    ItemThumbnail.Icon icon3 = (ItemThumbnail.Icon) itemThumbnail;
                    Painter painterPainterResource3 = PainterResources_androidKt.painterResource(icon3.getIconRes(), composerStartRestartGroup, 0);
                    Modifier modifierTestTag3 = TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:" + icon3.getIconRes());
                    contentDescription = icon3.getContentDescription();
                    if (contentDescription == null) {
                        composerStartRestartGroup.startReplaceGroup(2092265962);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2092265963);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*54@2020L18");
                        strStringResource = StringResources_androidKt.stringResource(contentDescription.intValue(), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ImageKt.Image(painterPainterResource3, strStringResource, modifierTestTag3, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable, 120);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    contentScale4 = crop;
                    imageVector2 = imageVector4;
                } else if (itemThumbnail instanceof ItemThumbnail.PreviewThumbnail) {
                    contentScale4 = crop;
                    imageVector2 = imageVector4;
                    if (itemThumbnail instanceof ItemThumbnail.Placeholder) {
                        composerStartRestartGroup.startReplaceGroup(2090266277);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2093279880);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "84@3147L6,81@3042L141");
                        BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11532getItemListingDivider0d7_KjU(), null, 2, null), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(2092388382);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "57@2121L855");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023125109, "C64@2425L45,58@2139L345:BoxItemThumbnail.kt#vejmn0");
                    ContentScale contentScale7 = crop;
                    ImageKt.m656Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(((ItemThumbnail.PreviewThumbnail) itemThumbnail).getThumbnail()), StringResources_androidKt.stringResource(R.string.file_thumbnail_label, composerStartRestartGroup, 0), SizeKt.fillMaxSize$default(TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:BitmapThumbnail"), 0.0f, 1, null), null, contentScale7, 0.0f, null, 0, composerStartRestartGroup, ((i3 << 9) & 57344) | 384, 232);
                    contentScale4 = contentScale7;
                    if (imageVector4 == null) {
                        composerStartRestartGroup.startReplaceGroup(2023482599);
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup = composerStartRestartGroup;
                        imageVector2 = imageVector4;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2023482600);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*76@2894L6,68@2541L411");
                        long jM6851getWhite0d7_KjU3 = Color.INSTANCE.m6851getWhite0d7_KjU();
                        Modifier modifierM589backgroundbw27NRU$default3 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize(boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(2)), Alignment.INSTANCE.getBottomEnd()), 0.2f), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11573getThumbnailFileIconBackgroundColor0d7_KjU(), null, 2, null);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ImageVector imageVector7 = imageVector4;
                        IconKt.m3576Iconww6aTOc(imageVector7, (String) null, modifierM589backgroundbw27NRU$default3, jM6851getWhite0d7_KjU3, composerStartRestartGroup, 3120, 0);
                        imageVector2 = imageVector7;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contentScale3 = contentScale4;
            }
            imageVector3 = imageVector2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxItemThumbnailKt.ThumbnailContent$lambda$2(itemThumbnail, contentScale3, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        imageVector2 = imageVector;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            contentScale3 = contentScale2;
        } else {
            if (i6 != 0) {
                crop = ContentScale.INSTANCE.getCrop();
            } else {
                crop = contentScale2;
            }
            strStringResource = null;
            if (i4 != 0) {
                imageVector4 = null;
            } else {
                imageVector4 = imageVector2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(510287709, i3, -1, "com.box.android.base.compose.ThumbnailContent (BoxItemThumbnail.kt:49)");
            }
            if (itemThumbnail instanceof ItemThumbnail.Icon) {
                composerStartRestartGroup.startReplaceGroup(2092066385);
                ComposerKt.sourceInformation(composerStartRestartGroup, "52@1835L34,51@1806L244");
                ItemThumbnail.Icon icon4 = (ItemThumbnail.Icon) itemThumbnail;
                Painter painterPainterResource4 = PainterResources_androidKt.painterResource(icon4.getIconRes(), composerStartRestartGroup, 0);
                Modifier modifierTestTag4 = TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:" + icon4.getIconRes());
                contentDescription = icon4.getContentDescription();
                if (contentDescription == null) {
                    composerStartRestartGroup.startReplaceGroup(2092265962);
                } else {
                    composerStartRestartGroup.startReplaceGroup(2092265963);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*54@2020L18");
                    strStringResource = StringResources_androidKt.stringResource(contentDescription.intValue(), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                ImageKt.Image(painterPainterResource4, strStringResource, modifierTestTag4, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable, 120);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
                contentScale4 = crop;
                imageVector2 = imageVector4;
            } else if (itemThumbnail instanceof ItemThumbnail.PreviewThumbnail) {
                contentScale4 = crop;
                imageVector2 = imageVector4;
                if (itemThumbnail instanceof ItemThumbnail.Placeholder) {
                    composerStartRestartGroup.startReplaceGroup(2090266277);
                } else {
                    composerStartRestartGroup.startReplaceGroup(2093279880);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "84@3147L6,81@3042L141");
                    BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11532getItemListingDivider0d7_KjU(), null, 2, null), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(2092388382);
                ComposerKt.sourceInformation(composerStartRestartGroup, "57@2121L855");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion4 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023125109, "C64@2425L45,58@2139L345:BoxItemThumbnail.kt#vejmn0");
                ContentScale contentScale8 = crop;
                ImageKt.m656Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(((ItemThumbnail.PreviewThumbnail) itemThumbnail).getThumbnail()), StringResources_androidKt.stringResource(R.string.file_thumbnail_label, composerStartRestartGroup, 0), SizeKt.fillMaxSize$default(TestTagKt.testTag(Modifier.INSTANCE, "Item.Thumbnail:BitmapThumbnail"), 0.0f, 1, null), null, contentScale8, 0.0f, null, 0, composerStartRestartGroup, ((i3 << 9) & 57344) | 384, 232);
                contentScale4 = contentScale8;
                if (imageVector4 == null) {
                    composerStartRestartGroup.startReplaceGroup(2023482599);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup = composerStartRestartGroup;
                    imageVector2 = imageVector4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(2023482600);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*76@2894L6,68@2541L411");
                    long jM6851getWhite0d7_KjU4 = Color.INSTANCE.m6851getWhite0d7_KjU();
                    Modifier modifierM589backgroundbw27NRU$default4 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize(boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(2)), Alignment.INSTANCE.getBottomEnd()), 0.2f), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11573getThumbnailFileIconBackgroundColor0d7_KjU(), null, 2, null);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ImageVector imageVector8 = imageVector4;
                    IconKt.m3576Iconww6aTOc(imageVector8, (String) null, modifierM589backgroundbw27NRU$default4, jM6851getWhite0d7_KjU4, composerStartRestartGroup, 3120, 0);
                    imageVector2 = imageVector8;
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentScale3 = contentScale4;
        }
        imageVector3 = imageVector2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxItemThumbnailKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxItemThumbnailKt.ThumbnailContent$lambda$2(itemThumbnail, contentScale3, imageVector3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
