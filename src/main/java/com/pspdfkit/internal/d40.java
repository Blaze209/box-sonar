package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class d40 {

    @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridItemKt$StampGridItem$1$1$1", f = "StampGridItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ StampPickerItem a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ MutableState<Bitmap> c;

        /* JADX INFO: renamed from: com.pspdfkit.internal.d40$a$a, reason: collision with other inner class name */
        public static final class C0260a<T> implements Consumer {
            public final /* synthetic */ MutableState<Bitmap> a;

            public C0260a(MutableState<Bitmap> mutableState) {
                this.a = mutableState;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                bitmap.getClass();
                this.a.setValue(bitmap);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(StampPickerItem stampPickerItem, Context context, MutableState<Bitmap> mutableState, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = stampPickerItem;
            this.b = context;
            this.c = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            StampAnnotation stampAnnotationCreateStampAnnotation = this.a.createStampAnnotation(0);
            stampAnnotationCreateStampAnnotation.getClass();
            z30 z30Var = new z30(this.b, stampAnnotationCreateStampAnnotation);
            RectF boundingBox = stampAnnotationCreateStampAnnotation.getBoundingBox();
            boundingBox.sort();
            int iA = (int) a80.a(this.b, boundingBox.width());
            int iA2 = (int) a80.a(this.b, boundingBox.height());
            z30Var.r = iA;
            z30Var.s = iA2;
            this.c.setValue(AndroidImageBitmap_androidKt.asAndroidBitmap(AndroidImageBitmap_androidKt.asImageBitmap(DrawableKt.toBitmap$default(z30Var, 0, 0, null, 7, null))));
            if (this.a.getAppearanceStreamGenerator() != null) {
                this.a.renderAppearanceStreamToBitmapAsync(this.b).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0260a(this.c));
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridItemKt$StampGridItem$1$2$1$1", f = "StampGridItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ StampPickerItem b;
        public final /* synthetic */ MutableState<Bitmap> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Bitmap bitmap, StampPickerItem stampPickerItem, MutableState<Bitmap> mutableState, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = bitmap;
            this.b = stampPickerItem;
            this.c = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            this.c.setValue(Bitmap.createScaledBitmap(this.a, (int) this.b.getDefaultPdfWidth(), (int) this.b.getDefaultPdfHeight(), false));
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Modifier modifier, StampPickerItem stampPickerItem, int i, Composer composer, int i2) {
        a(modifier, stampPickerItem, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final Modifier modifier, final StampPickerItem stampPickerItem, Composer composer, final int i) {
        int i2;
        modifier.getClass();
        stampPickerItem.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(592917300);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(stampPickerItem) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(592917300, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridItem (StampGridItem.kt:41)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (stampPickerItem.getAppearanceStreamGenerator() != null || stampPickerItem.getBitmap() == null) {
                composerStartRestartGroup.startReplaceGroup(-349182414);
                AppearanceStreamGenerator appearanceStreamGenerator = stampPickerItem.getAppearanceStreamGenerator();
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(stampPickerItem) | composerStartRestartGroup.changedInstance(context);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new a(stampPickerItem, context, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(appearanceStreamGenerator, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-347807471);
                Bitmap bitmap = stampPickerItem.getBitmap();
                if (bitmap == null) {
                    composerStartRestartGroup.startReplaceGroup(-347807472);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-347807471);
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(bitmap) | composerStartRestartGroup.changedInstance(stampPickerItem);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new b(bitmap, stampPickerItem, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    EffectsKt.LaunchedEffect(bitmap, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            AnimatedVisibilityKt.AnimatedVisibility(((Bitmap) mutableState.getValue()) != null, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(2033915542, true, new Function3() { // from class: com.pspdfkit.internal.d40$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return d40.a(mutableState, stampPickerItem, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.d40$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return d40.a(modifier, stampPickerItem, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(MutableState mutableState, StampPickerItem stampPickerItem, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2033915542, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridItem.<anonymous>.<anonymous> (StampGridItem.kt:88)");
        }
        Bitmap bitmap = (Bitmap) mutableState.getValue();
        if (bitmap == null) {
            composer.startReplaceGroup(-1020669245);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1020669244);
            ImageKt.m656Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), stampPickerItem.getTitle(), null, null, ContentScale.INSTANCE.getFit(), 0.0f, null, 0, composer, 24576, 236);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
