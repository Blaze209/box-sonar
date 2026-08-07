package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.bookmarks.Bookmark;
import com.pspdfkit.utils.Size;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d8 {

    @DebugMetadata(c = "io.nutrient.internal.ui.bookmarks.BookmarkListItemKt$BookmarkListItem$1$1", f = "BookmarkListItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ f8 a;
        public final /* synthetic */ Bookmark b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ MutableState<Bitmap> e;

        /* JADX INFO: renamed from: com.pspdfkit.internal.d8$a$a, reason: collision with other inner class name */
        public static final class C0261a<T> implements Consumer {
            public final /* synthetic */ MutableState<Bitmap> a;
            public final /* synthetic */ f8 b;

            public C0261a(MutableState<Bitmap> mutableState, f8 f8Var) {
                this.a = mutableState;
                this.b = f8Var;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                bitmap.getClass();
                this.a.setValue(bitmap);
                this.b.i.clear();
            }
        }

        public static final class b<T> implements Consumer {
            public static final b<T> a = new b<>();

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                ((Throwable) obj).getClass();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f8 f8Var, Bookmark bookmark, float f, float f2, MutableState<Bitmap> mutableState, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = f8Var;
            this.b = bookmark;
            this.c = f;
            this.d = f2;
            this.e = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            f8 f8Var = this.a;
            j8 j8Var = f8Var.d;
            if (j8Var != null) {
                j8Var.a(this.b, new Size(this.c, this.d)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0261a(this.e, f8Var), b.a);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.bookmarks.BookmarkListItemKt$BookmarkListItem$2$1", f = "BookmarkListItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ f8 a;
        public final /* synthetic */ Bookmark b;
        public final /* synthetic */ MutableState<String> c;
        public final /* synthetic */ MutableState<String> d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;
        public final /* synthetic */ MutableState<Bitmap> g;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ MutableState<String> a;

            public a(MutableState<String> mutableState) {
                this.a = mutableState;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                String str = (String) obj;
                str.getClass();
                this.a.setValue(str);
            }
        }

        /* JADX INFO: renamed from: com.pspdfkit.internal.d8$b$b, reason: collision with other inner class name */
        public static final class C0262b<T> implements Consumer {
            public final /* synthetic */ MutableState<Bitmap> a;

            public C0262b(MutableState<Bitmap> mutableState) {
                this.a = mutableState;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                bitmap.getClass();
                this.a.setValue(bitmap);
            }
        }

        public static final class c<T> implements Consumer {
            public static final c<T> a = new c<>();

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                ((Throwable) obj).getClass();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f8 f8Var, Bookmark bookmark, MutableState<String> mutableState, MutableState<String> mutableState2, float f, float f2, MutableState<Bitmap> mutableState3, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = f8Var;
            this.b = bookmark;
            this.c = mutableState;
            this.d = mutableState2;
            this.e = f;
            this.f = f2;
            this.g = mutableState3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            f8 f8Var = this.a;
            j8 j8Var = f8Var.d;
            if (j8Var != null) {
                Bookmark bookmark = this.b;
                MutableState<String> mutableState = this.c;
                MutableState<String> mutableState2 = this.d;
                float f = this.e;
                float f2 = this.f;
                MutableState<Bitmap> mutableState3 = this.g;
                String strB = f8Var.e ? j8Var.b(bookmark) : null;
                if (strB != null) {
                    mutableState.setValue(strB);
                }
                String strC = j8Var.c(bookmark);
                if (strC != null) {
                    mutableState2.setValue(strC);
                } else {
                    j8Var.a(bookmark).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(mutableState2)).getClass();
                }
                j8Var.a(bookmark, new Size(f, f2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0262b(mutableState3), c.a);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.bookmarks.BookmarkListItemKt$BookmarkListItem$3$1", f = "BookmarkListItem.kt", i = {}, l = {Token.LAST_TOKEN}, m = "invokeSuspend", n = {}, nl = {168}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ MutableState<Boolean> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z, MutableState<Boolean> mutableState, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = z;
            this.c = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new c(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b) {
                    this.c.setValue(Boolean.TRUE);
                    this.a = 1;
                    if (DelayKt.delay(750L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.c.setValue(Boolean.FALSE);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function1<Color, Unit> {
        public final /* synthetic */ Function0<Unit> a;

        public d(Function0<Unit> function0) {
            this.a = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Color color) {
            color.m6824unboximpl();
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Bookmark bookmark, f8 f8Var, e8 e8Var, boolean z, boolean z2, boolean z3, Function0 function0, g8 g8Var, Modifier modifier, Modifier modifier2, int i, int i2, Composer composer, int i3) {
        a(bookmark, f8Var, e8Var, z, z2, z3, function0, g8Var, modifier, modifier2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final Bookmark bookmark, final f8 f8Var, final e8 e8Var, final boolean z, final boolean z2, final boolean z3, final Function0<Unit> function0, final g8 g8Var, final Modifier modifier, Modifier modifier2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        long jColor;
        Object aVar;
        Boolean bool;
        MutableState mutableState;
        float f;
        float f2;
        Object bVar;
        MutableState mutableState2;
        MutableState mutableState3;
        char c2;
        Bookmark bookmark2;
        Modifier modifier5;
        bookmark.getClass();
        f8Var.getClass();
        e8Var.getClass();
        function0.getClass();
        g8Var.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(97548425);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(bookmark) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(f8Var) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(e8Var) ? 256 : 128;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(g8Var) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 67108864 : 33554432;
        }
        int i4 = i2 & 512;
        if (i4 != 0) {
            i3 |= 805306368;
            modifier3 = modifier2;
        } else {
            modifier3 = modifier2;
            if ((i & 805306368) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306782355) != 306782354, i3 & 1)) {
            Modifier modifier6 = i4 != 0 ? Modifier.INSTANCE : modifier3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(97548425, i3, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListItem (BookmarkListItem.kt:86)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                float f3 = g8Var.b;
                density.getClass();
                objRememberedValue = Float.valueOf(density.mo754toPx0680j_4(f3));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            float fFloatValue = ((Number) objRememberedValue).floatValue();
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            int i5 = i3;
            if (objRememberedValue2 == companion.getEmpty()) {
                float f4 = g8Var.a;
                density.getClass();
                objRememberedValue2 = Float.valueOf(density.mo754toPx0680j_4(f4));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            float fFloatValue2 = ((Number) objRememberedValue2).floatValue();
            int i6 = R.string.pspdf__annotation_list_page;
            Integer pageIndex = bookmark.getPageIndex();
            String strA = no.a(context, i6, (View) null, Integer.valueOf(pageIndex != null ? pageIndex.intValue() + 1 : 0));
            strA.getClass();
            boolean zChanged = composerStartRestartGroup.changed(bookmark);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(strA, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue3;
            boolean zChanged2 = composerStartRestartGroup.changed(bookmark);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue4 = mutableStateMutableStateOf$default;
            }
            MutableState mutableState5 = (MutableState) objRememberedValue4;
            boolean zChanged3 = composerStartRestartGroup.changed(bookmark);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
                MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                objRememberedValue5 = mutableStateMutableStateOf$default2;
            }
            MutableState mutableState6 = (MutableState) objRememberedValue5;
            Object[] objArr = {bookmark};
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.pspdfkit.internal.d8$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return d8.a();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState7 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue6, composerStartRestartGroup, 48);
            if (((Boolean) mutableState7.getValue()).booleanValue()) {
                int i7 = e8Var.d;
                jColor = ColorKt.Color(i7, i7, i7, 64);
            } else {
                ot otVar = f8Var.a;
                jColor = otVar != null ? ColorKt.Color(otVar.a) : Color.INSTANCE.m6851getWhite0d7_KjU();
            }
            long j = jColor;
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null);
            boolean z4 = (i5 & 3670016) == 1048576;
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = new d(function0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(j, tweenSpecTween$default, "bookmark_item_color", (Function1) objRememberedValue7, composerStartRestartGroup, 384, 0);
            Boolean boolValueOf = Boolean.valueOf(!f8Var.i.isEmpty());
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(f8Var) | composerStartRestartGroup.changedInstance(bookmark) | composerStartRestartGroup.changed(mutableState6);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue8 == companion.getEmpty()) {
                bool = boolValueOf;
                mutableState = mutableState6;
                f = fFloatValue;
                f2 = fFloatValue2;
                aVar = new a(f8Var, bookmark, f, f2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(aVar);
            } else {
                bool = boolValueOf;
                aVar = objRememberedValue8;
                mutableState = mutableState6;
                f = fFloatValue;
                f2 = fFloatValue2;
            }
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aVar, composerStartRestartGroup, 0);
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(f8Var) | composerStartRestartGroup.changedInstance(bookmark) | composerStartRestartGroup.changed(mutableState4) | composerStartRestartGroup.changed(r23) | composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue9 == companion.getEmpty()) {
                float f5 = f;
                mutableState2 = mutableState4;
                float f6 = f2;
                composer2 = composerStartRestartGroup;
                mutableState3 = r23;
                c2 = 0;
                MutableState mutableState8 = mutableState;
                bVar = new b(f8Var, bookmark, mutableState2, mutableState3, f5, f6, mutableState8, null);
                bookmark2 = bookmark;
                mutableState = mutableState8;
                composer2.updateRememberedValue(bVar);
            } else {
                bookmark2 = bookmark;
                mutableState2 = mutableState4;
                mutableState3 = mutableState5;
                bVar = objRememberedValue9;
                c2 = 0;
                composer2 = composerStartRestartGroup;
            }
            EffectsKt.LaunchedEffect(bookmark2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) bVar, composer2, i5 & 14);
            Unit unit = Unit.INSTANCE;
            boolean zChanged4 = composer2.changed(r30) | ((i5 & 458752) == c2);
            Object objRememberedValue10 = composer2.rememberedValue();
            if (zChanged4 || objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new c(z3, mutableState7, null);
                composer2.updateRememberedValue(objRememberedValue10);
            }
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue10, composer2, 6);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifier, stateM437animateColorAsStateeuL9pac.getValue().m6824unboximpl(), null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM589backgroundbw27NRU$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(companion4, g8Var.g, 0.0f, 2, null);
            float f7 = g8Var.e;
            float f8 = g8Var.f;
            Modifier modifierM1221paddingqDBjuR0 = PaddingKt.m1221paddingqDBjuR0(modifierM1254heightInVpY3zN4$default, f7, f8, f7, f8);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1221paddingqDBjuR0);
            MutableState mutableState9 = mutableState2;
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            MutableState mutableState10 = mutableState3;
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            final Bitmap bitmap = (Bitmap) mutableState.getValue();
            if (bitmap == null) {
                composer2.startReplaceGroup(-373538416);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-373538415);
                CardKt.Card(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1268sizeVpY3zN4(companion4, g8Var.b, g8Var.a), 0.0f, 0.0f, g8Var.e, 0.0f, 11, null), null, null, CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(g8Var.h, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, CardDefaults.$stable << 18, 62), null, ComposableLambdaKt.rememberComposableLambda(1128093745, true, new Function3() { // from class: com.pspdfkit.internal.d8$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return d8.a(bitmap, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 22);
                composer2.endReplaceGroup();
            }
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion4, 2.0f, false, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl3, currentCompositionLocalMap3);
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl3, Integer.valueOf(iHashCode3), composerM6062constructorimpl3));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String name = bookmark.getName();
            if (name == null) {
                composer2.startReplaceGroup(-683404938);
                name = StringResources_androidKt.stringResource(R.string.pspdf__bookmark, composer2, 0);
            } else {
                composer2.startReplaceGroup(-683405465);
            }
            composer2.endReplaceGroup();
            String str = name;
            TextOverflow.Companion companion5 = TextOverflow.INSTANCE;
            int iM9584getEllipsisgIe3tQ8 = companion5.m9584getEllipsisgIe3tQ8();
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i8 = MaterialTheme.$stable;
            Composer composer3 = composer2;
            TextKt.m4494TextNvy7gAk(str, PaddingKt.m1222paddingqDBjuR0$default(companion4, 0.0f, g8Var.i, 0.0f, 0.0f, 13, null), 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(e8Var.f), 0L, null, null, 0L, iM9584getEllipsisgIe3tQ8, false, 1, 0, null, TextStyle.m9104copyp1EtxEg$default(materialTheme.getTypography(composer2, i8).getTitleLarge(), ColorKt.Color(e8Var.b), g8Var.j, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer3, 0, 24960, 110460);
            TextKt.m4494TextNvy7gAk((String) mutableState10.getValue(), null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(e8Var.g), 0L, null, null, 0L, companion5.m9584getEllipsisgIe3tQ8(), false, 5, 0, null, TextStyle.m9104copyp1EtxEg$default(materialTheme.getTypography(composer2, i8).getBodyMedium(), ColorKt.Color(e8Var.c), g8Var.k, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer3, 0, 24960, 110462);
            composer2.endNode();
            Modifier modifierM1253heightInVpY3zN4 = SizeKt.m1253heightInVpY3zN4(companion4, g8Var.g, g8Var.a);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getEnd(), composer2, 48);
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM1253heightInVpY3zN4);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl4, measurePolicyColumnMeasurePolicy2, composerM6062constructorimpl4, currentCompositionLocalMap4);
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl4, Integer.valueOf(iHashCode4), composerM6062constructorimpl4));
            int i9 = f8Var.c;
            Integer pageIndex2 = bookmark.getPageIndex();
            final int i10 = (pageIndex2 != null && pageIndex2.intValue() == i9) ? e8Var.d : e8Var.c;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer2, 48);
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, companion4);
            Function0<ComposeUiNode> constructor5 = companion3.getConstructor();
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl5, measurePolicyRowMeasurePolicy2, composerM6062constructorimpl5, currentCompositionLocalMap5);
            Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl5, Integer.valueOf(iHashCode5), composerM6062constructorimpl5));
            Integer pageIndex3 = bookmark.getPageIndex();
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, pageIndex3 != null && pageIndex3.intValue() == i9, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1778672106, true, new Function3() { // from class: com.pspdfkit.internal.d8$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return d8.a(i10, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 1572870, 30);
            String upperCase = ((String) mutableState9.getValue()).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            TextKt.m4494TextNvy7gAk(upperCase, null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(e8Var.e), 0L, null, null, 0L, companion5.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, TextStyle.m9104copyp1EtxEg$default(materialTheme.getTypography(composer2, i8).getTitleLarge(), ColorKt.Color(i10), g8Var.k, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, 0, 24960, 110462);
            composer2.endNode();
            Modifier modifierWeight$default2 = ColumnScope.weight$default(columnScopeInstance, companion4, 1.0f, false, 2, null);
            String str2 = "Edit Bookmark Handle " + bookmark.getName();
            modifierWeight$default2.getClass();
            str2.getClass();
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenterEnd(), false);
            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default2);
            Function0<ComposeUiNode> constructor6 = companion3.getConstructor();
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor6);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composer2);
            f2.a(companion3, composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM6062constructorimpl6, currentCompositionLocalMap6);
            Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl6, Integer.valueOf(iHashCode6), composerM6062constructorimpl6));
            if (z2) {
                composer2.startReplaceGroup(953545973);
                modifier5 = modifier6;
                IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(e8Var.a, composer2, 0), (String) null, modifier5, ColorKt.Color(i10), composer2, Painter.$stable | 48 | ((i5 >> 21) & 896), 0);
                composer2.endReplaceGroup();
            } else {
                modifier5 = modifier6;
                composer2.startReplaceGroup(953845526);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.d8$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return d8.a(bookmark, f8Var, e8Var, z, z2, z3, function0, g8Var, modifier, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final MutableState a() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    public static final Unit a(Bitmap bitmap, ColumnScope columnScope, Composer composer, int i) {
        columnScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1128093745, i, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookmarkListItem.kt:195)");
            }
            ImageKt.m656Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), null, null, null, ContentScale.INSTANCE.getInside(), 0.0f, null, 0, composer, 24624, 236);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i2) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778672106, i2, -1, "io.nutrient.internal.ui.bookmarks.BookmarkListItem.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookmarkListItem.kt:255)");
        }
        IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.pspdf__arrow_right, composer, 0), (String) null, (Modifier) null, ColorKt.Color(i), composer, Painter.$stable | 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
