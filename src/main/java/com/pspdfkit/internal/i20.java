package com.pspdfkit.internal;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.signatures.Signature;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class i20 {

    @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.signatures.composables.SignatureListKt$SignatureList$1$1", f = "SignatureList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SnapshotStateList<Signature> b;
        public final /* synthetic */ Function1<y10, Unit> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z, SnapshotStateList<Signature> snapshotStateList, Function1<? super y10, Unit> function1, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = z;
            this.b = snapshotStateList;
            this.c = function1;
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
            if (this.a) {
                this.b.clear();
                this.c.invoke(y10.b.a);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function0<Unit> {
        public final /* synthetic */ SnapshotStateList<Signature> a;
        public final /* synthetic */ Signature b;
        public final /* synthetic */ Function1<y10, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(SnapshotStateList<Signature> snapshotStateList, Signature signature, Function1<? super y10, Unit> function1) {
            this.a = snapshotStateList;
            this.b = signature;
            this.c = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            boolean zContains = this.a.contains(this.b);
            SnapshotStateList<Signature> snapshotStateList = this.a;
            if (zContains) {
                snapshotStateList.remove(this.b);
            } else if (snapshotStateList.isEmpty()) {
                this.c.invoke(new y10.c(this.b));
            } else {
                this.a.add(this.b);
            }
            this.c.invoke(new y10.a(this.a));
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function0<Unit> {
        public final /* synthetic */ SnapshotStateList<Signature> a;
        public final /* synthetic */ Signature b;
        public final /* synthetic */ Function1<y10, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public c(SnapshotStateList<Signature> snapshotStateList, Signature signature, Function1<? super y10, Unit> function1) {
            this.a = snapshotStateList;
            this.b = signature;
            this.c = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            if (this.a.isEmpty()) {
                this.a.add(this.b);
                this.c.invoke(new y10.a(this.a));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function1<Integer, Object> {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ List b;

        public d(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            int iIntValue = num.intValue();
            return this.a.invoke(Integer.valueOf(iIntValue), this.b.get(iIntValue));
        }
    }

    public static final class e implements Function1<Integer, Object> {
        public final /* synthetic */ List a;

        public e(List list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            this.a.get(num.intValue());
            return null;
        }
    }

    public static final class f implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ SnapshotStateList b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ g20 d;

        public f(List list, SnapshotStateList snapshotStateList, Function1 function1, g20 g20Var) {
            this.a = list;
            this.b = snapshotStateList;
            this.c = function1;
            this.d = g20Var;
        }

        public final void a(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
            }
            Signature signature = (Signature) this.a.get(i);
            composer.startReplaceGroup(-465940769);
            boolean zChanged = composer.changed(this.b) | composer.changedInstance(signature) | composer.changed(this.c);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new b(this.b, signature, this.c);
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChanged2 = composer.changed(this.b) | composer.changedInstance(signature) | composer.changed(this.c);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new c(this.b, signature, this.c);
                composer.updateRememberedValue(objRememberedValue2);
            }
            h20.a(signature, function0, (Function0) objRememberedValue2, this.b.contains(signature), TestTagKt.testTag(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signature_list_item_height, composer, 0)), "PSPDF_SIGNATURE_ITEM_" + i), this.d, composer, 0);
            DividerKt.m3284HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function4
        public final /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            a(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(List list, Function1 function1, boolean z, Modifier modifier, g20 g20Var, int i, Composer composer, int i2) {
        a(list, function1, z, modifier, g20Var, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final List<Signature> list, final Function1<? super y10, Unit> function1, final boolean z, final Modifier modifier, final g20 g20Var, Composer composer, final int i) {
        int i2;
        list.getClass();
        function1.getClass();
        modifier.getClass();
        g20Var.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(671828891);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(g20Var) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(671828891, i2, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.SignatureList (SignatureList.kt:43)");
            }
            final SnapshotStateList snapshotStateListA = o40.a(new Signature[0], composerStartRestartGroup);
            Boolean boolValueOf = Boolean.valueOf(z);
            int i3 = i2 & 112;
            boolean zChanged = ((i2 & 896) == 256) | composerStartRestartGroup.changed(snapshotStateListA) | (i3 == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a(z, snapshotStateListA, function1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, (i2 >> 6) & 14);
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
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
            if (list.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-939952595);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-941643955);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(snapshotStateListA) | (i3 == 32) | ((i2 & 57344) == 16384);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.i20$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return i20.a(list, snapshotStateListA, function1, g20Var, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                LazyDslKt.LazyColumn(modifierFillMaxSize$default, null, null, false, null, null, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 6, 510);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            AnimatedVisibilityKt.AnimatedVisibility(list.isEmpty(), boxScopeInstance.align(Modifier.INSTANCE, companion.getCenter()), (EnterTransition) null, (ExitTransition) null, (String) null, s9.a, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.i20$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return i20.a(list, function1, z, modifier, g20Var, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(List list, SnapshotStateList snapshotStateList, Function1 function1, g20 g20Var, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        lazyListScope.items(list.size(), new d(new Function2() { // from class: com.pspdfkit.internal.i20$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return i20.a(((Integer) obj).intValue(), (Signature) obj2);
            }
        }, list), new e(list), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new f(list, snapshotStateList, function1, g20Var)));
        return Unit.INSTANCE;
    }

    public static final Object a(int i, Signature signature) {
        signature.getClass();
        return Long.valueOf(signature.getId());
    }
}
