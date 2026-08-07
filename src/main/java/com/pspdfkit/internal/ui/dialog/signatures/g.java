package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.fragment.app.FragmentActivity;
import androidx.profileinstaller.ProfileVerifier;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import com.pspdfkit.R;
import com.pspdfkit.configuration.forms.SignaturePickerOrientation;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.e2;
import com.pspdfkit.internal.f2;
import com.pspdfkit.internal.g20;
import com.pspdfkit.internal.i20;
import com.pspdfkit.internal.l20;
import com.pspdfkit.internal.p9;
import com.pspdfkit.internal.tg;
import com.pspdfkit.internal.vc;
import com.pspdfkit.internal.x10;
import com.pspdfkit.internal.y10;
import com.pspdfkit.internal.y9;
import com.pspdfkit.internal.yq;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.SignatureUiData;
import com.pspdfkit.utils.ParcelExtensions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends MAMRelativeLayout implements com.pspdfkit.internal.ui.dialog.signatures.a.InterfaceC0289a {
    public final SignaturePickerOrientation a;
    public final SignatureSavingStrategy b;
    public final MutableState<List<Signature>> c;
    public final MutableState d;
    public final MutableState e;
    public a f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final MutableState k;
    public final com.pspdfkit.internal.ui.dialog.signatures.a l;

    public interface a extends x10 {
    }

    public static final class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public boolean a;
        public boolean b;
        public List<Signature> c;
        public List<Signature> d;

        public static final class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                parcel.getClass();
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.getClass();
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            List<Signature> list = this.c;
            List<Signature> list2 = null;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signatures");
                list = null;
            }
            parcel.writeParcelableList(list, 0);
            List<Signature> list3 = this.d;
            if (list3 != null) {
                list2 = list3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("checkedSignatures");
            }
            parcel.writeParcelableList(list2, 0);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readByte() == 1;
            this.b = parcel.readByte() == 1;
            ArrayList arrayList = new ArrayList();
            ParcelExtensions.readSupportList(parcel, arrayList, Signature.class);
            this.c = arrayList;
            ArrayList arrayList2 = new ArrayList();
            ParcelExtensions.readSupportList(parcel, arrayList2, Signature.class);
            this.d = arrayList2;
        }
    }

    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SignaturePickerOrientation.values().length];
            try {
                iArr[SignaturePickerOrientation.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SignaturePickerOrientation.LOCKED_LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SignaturePickerOrientation.LOCKED_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(Context context, SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy) {
        context.getClass();
        signaturePickerOrientation.getClass();
        signatureSavingStrategy.getClass();
        int i = g20.C;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{g20.B});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, i);
        typedArrayObtainStyledAttributes.recycle();
        super(new ContextThemeWrapper(context, resourceId));
        this.a = signaturePickerOrientation;
        this.b = signatureSavingStrategy;
        this.c = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        this.d = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        Boolean bool = Boolean.FALSE;
        this.e = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.j = true;
        this.k = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.l = new com.pspdfkit.internal.ui.dialog.signatures.a(context);
        a(context);
    }

    public static final Unit b(g20 g20Var, final g gVar, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2050017020, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.SignaturePickerDialogLayout.init.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignaturePickerDialogLayout.kt:269)");
        }
        long jColor = ColorKt.Color(g20Var.r);
        float f = 16;
        Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 3, null), "PSPDF_PICKER_DELETE_SIGNATURE_FAB");
        float fM9687constructorimpl = Dp.m9687constructorimpl(4);
        int i2 = g20Var.p;
        long jColor2 = ColorKt.Color(g20Var.q);
        boolean zChangedInstance = composer.changedInstance(gVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return g.c(this.f$0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        l20.a(modifierTestTag, i2, jColor2, jColor, fM9687constructorimpl, null, (Function0) objRememberedValue, composer, 24582, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit c(g gVar) {
        if (gVar.f != null && !gVar.getCheckedSignatureList().isEmpty()) {
            a aVar = gVar.f;
            aVar.getClass();
            ArrayList arrayList = new ArrayList(gVar.getCheckedSignatureList());
            x10 x10Var = ((f) aVar).c;
            if (x10Var != null) {
                x10Var.onSignaturesDeleted(arrayList);
            }
            List<Signature> value = gVar.c.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                if (!gVar.getCheckedSignatureList().contains((Signature) obj)) {
                    arrayList2.add(obj);
                }
            }
            gVar.c.setValue(arrayList2);
            gVar.setShouldClearCheckedItems(true);
        }
        return Unit.INSTANCE;
    }

    private final List<Signature> getCheckedSignatureList() {
        return (List) this.d.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShouldAnimateAddSignature() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShouldClearCheckedItems() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    private final void setCheckedSignatureList(List<Signature> list) {
        this.d.setValue(list);
    }

    private final void setShouldAnimateAddSignature(boolean z) {
        this.k.setValue(Boolean.valueOf(z));
    }

    private final void setShouldClearCheckedItems(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
    }

    public final void a(final Context context) {
        ar.b().getClass();
        if (!tg.b()) {
            throw new InvalidNutrientLicenseException("Creating signature annotations requires Electronic Signatures.");
        }
        removeAllViews();
        setFocusableInTouchMode(true);
        requestFocus();
        final yq yqVar = new yq(context);
        int cornerRadius = yqVar.getCornerRadius();
        final float fM9687constructorimpl = Dp.m9687constructorimpl(a80.a(yqVar.getTitlePadding(), context));
        final float fM9687constructorimpl2 = this.g ? Dp.m9687constructorimpl(0) : Dp.m9687constructorimpl(cornerRadius + 2);
        final g20 g20Var = new g20(context);
        final ComposeView composeViewA = y9.a(context, p9.a);
        composeViewA.setContent(ComposableLambdaKt.composableLambdaInstance(-1871307998, true, new Function2() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return g.a(fM9687constructorimpl2, g20Var, this, yqVar, context, fM9687constructorimpl, composeViewA, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        addView(composeViewA, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        a();
        return true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        parcelable.getClass();
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.h = bVar.a;
        this.i = true;
        MutableState<List<Signature>> mutableState = this.c;
        List<Signature> list = bVar.c;
        List<Signature> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatures");
            list = null;
        }
        mutableState.setValue(list);
        List<Signature> list3 = bVar.d;
        if (list3 != null) {
            list2 = list3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("checkedSignatures");
        }
        setCheckedSignatureList(list2);
        Context context = getContext();
        context.getClass();
        a(context);
        this.j = bVar.b;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = this.h;
        bVar.b = this.j;
        List<Signature> mutableList = CollectionsKt.toMutableList((Collection) this.c.getValue());
        mutableList.getClass();
        bVar.c = mutableList;
        List<Signature> mutableList2 = CollectionsKt.toMutableList((Collection) getCheckedSignatureList());
        mutableList2.getClass();
        bVar.d = mutableList2;
        return bVar;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.a.InterfaceC0289a
    public final void onSignatureCreated(Signature signature, boolean z) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.onSignatureCreated(signature, z);
            a aVar2 = this.f;
            aVar2.getClass();
            f fVar = (f) aVar2;
            if (fVar.getActivity() == null || fVar.a == null) {
                return;
            }
            fVar.getActivity().setRequestedOrientation(fVar.a.intValue());
            fVar.a = null;
        }
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.a.InterfaceC0289a
    public final void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.onSignatureUiDataCollected(signature, signatureUiData);
        }
    }

    public final void setFullscreen(boolean z) {
        this.g = z;
    }

    public final void setItems(List<Signature> list) {
        list.getClass();
        this.c.setValue(list);
        if (!this.i && list.isEmpty()) {
            this.j = false;
            a(false);
        }
        this.i = true;
    }

    public final void setListener(a aVar) {
        aVar.getClass();
        this.f = aVar;
    }

    public static final Unit a(float f, final g20 g20Var, final g gVar, yq yqVar, Context context, float f2, final ComposeView composeView, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1871307998, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.SignaturePickerDialogLayout.init.<anonymous>.<anonymous> (SignaturePickerDialogLayout.kt:152)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierStatusBarsPadding = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(f)), ColorKt.Color(g20Var.l), null, 2, null));
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierStatusBarsPadding);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String strStringResource = StringResources_androidKt.stringResource(gVar.h ? R.string.pspdf__add_signature : R.string.pspdf__signatures, composer, 0);
            long jColor = ColorKt.Color(yqVar.getTitleTextColor());
            float titleTextSize = yqVar.getTitleTextSize();
            context.getClass();
            TextStyle textStyle = new TextStyle(jColor, TextUnitKt.getSp(titleTextSize / context.getResources().getDisplayMetrics().scaledDensity), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), RoundedCornerShapeKt.m1575RoundedCornerShapea9UjIt4$default(f, f, 0.0f, 0.0f, 12, null)), ColorKt.Color(yqVar.getTitleColor()), null, 2, null);
            int i2 = R.drawable.pspdf__ic_arrow_back;
            long jColor2 = ColorKt.Color(yqVar.getTitleIconsColor());
            boolean zChangedInstance = composer.changedInstance(gVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return g.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            float f3 = 48;
            vc.a(strStringResource, textStyle, modifierM589backgroundbw27NRU$default, i2, jColor2, true, (Function0) objRememberedValue, PaddingKt.m1218padding3ABfNKs(SizeKt.m1270sizeInqDBjuR0$default(companion, Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f3), 0.0f, 0.0f, 12, null), f2), PaddingKt.m1222paddingqDBjuR0$default(companion, f2, 0.0f, f2, 0.0f, 10, null), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            boolean z = gVar.h;
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(gVar.getShouldAnimateAddSignature() ? 200 : 0, 0, null, 6, null);
            boolean zChangedInstance2 = composer.changedInstance(composeView);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(g.a(composeView, ((Integer) obj).intValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            EnterTransition enterTransitionSlideInHorizontally = EnterExitTransitionKt.slideInHorizontally(tweenSpecTween$default, (Function1) objRememberedValue2);
            TweenSpec tweenSpecTween$default2 = AnimationSpecKt.tween$default(gVar.getShouldAnimateAddSignature() ? 200 : 0, 0, null, 6, null);
            boolean zChangedInstance3 = composer.changedInstance(composeView);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(g.b(composeView, ((Integer) obj).intValue()));
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z, (Modifier) null, enterTransitionSlideInHorizontally, EnterExitTransitionKt.slideOutHorizontally(tweenSpecTween$default2, (Function1) objRememberedValue3), (String) null, ComposableLambdaKt.rememberComposableLambda(2079903764, true, new Function3() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return g.a(this.f$0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 18);
            if (!gVar.h) {
                composer.startReplaceGroup(-2095977471);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
                f2.a(companion3, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                List<Signature> value = gVar.c.getValue();
                boolean zChangedInstance4 = composer.changedInstance(gVar);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return g.a(this.f$0, (y10) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                i20.a(value, (Function1) objRememberedValue4, gVar.getShouldClearCheckedItems(), TestTagKt.testTag(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), "PSPDF_PICKER_SIGNATURE_ITEMS_LIST"), g20Var, composer, 3072);
                AnimatedVisibilityKt.AnimatedVisibility(gVar.getCheckedSignatureList().isEmpty(), boxScopeInstance.align(companion, companion2.getBottomEnd()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(56544659, true, new Function3() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return g.a(g20Var, gVar, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                AnimatedVisibilityKt.AnimatedVisibility(!gVar.getCheckedSignatureList().isEmpty(), boxScopeInstance.align(companion, companion2.getBottomEnd()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(2050017020, true, new Function3() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return g.b(g20Var, gVar, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2091898026);
                composer.endReplaceGroup();
            }
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final int b(ComposeView composeView, int i) {
        return (-composeView.getWidth()) / 2;
    }

    public static final Unit b(g gVar) {
        gVar.a(true);
        return Unit.INSTANCE;
    }

    public static final Unit a(g gVar) {
        gVar.a();
        return Unit.INSTANCE;
    }

    public static final int a(ComposeView composeView, int i) {
        return composeView.getWidth() / 2;
    }

    public static final Unit a(final g gVar, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2079903764, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.SignaturePickerDialogLayout.init.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignaturePickerDialogLayout.kt:210)");
        }
        boolean zChangedInstance = composer.changedInstance(gVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return g.a(this.f$0, (Context) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        AndroidView_androidKt.AndroidView((Function1) objRememberedValue, null, null, composer, 0, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final com.pspdfkit.internal.ui.dialog.signatures.a a(g gVar, Context context) {
        context.getClass();
        com.pspdfkit.internal.ui.dialog.signatures.a aVar = gVar.l;
        aVar.setId(R.id.pspdf__signature_layout_add_new_signature);
        aVar.setStoreSignatureCheckboxVisible(gVar.b == SignatureSavingStrategy.SAVE_IF_SELECTED);
        aVar.setListener(gVar);
        return aVar;
    }

    public static final Unit a(g gVar, y10 y10Var) {
        y10Var.getClass();
        if (y10Var instanceof y10.a) {
            gVar.setCheckedSignatureList(((y10.a) y10Var).a);
        } else if (Intrinsics.areEqual(y10Var, y10.b.a)) {
            gVar.setShouldClearCheckedItems(false);
        } else if (y10Var instanceof y10.c) {
            a aVar = gVar.f;
            if (aVar != null) {
                aVar.onSignaturePicked(((y10.c) y10Var).a);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    public final void a() {
        if (this.h) {
            boolean z = this.j;
            a aVar = this.f;
            if (!z) {
                if (aVar != null) {
                    f fVar = (f) aVar;
                    if (fVar.getActivity() != null && fVar.a != null) {
                        fVar.getActivity().setRequestedOrientation(fVar.a.intValue());
                        fVar.a = null;
                    }
                    a aVar2 = this.f;
                    aVar2.getClass();
                    aVar2.onDismiss();
                    return;
                }
                return;
            }
            if (aVar != null) {
                f fVar2 = (f) aVar;
                if (fVar2.getActivity() != null && fVar2.a != null) {
                    fVar2.getActivity().setRequestedOrientation(fVar2.a.intValue());
                    fVar2.a = null;
                }
            }
            this.h = false;
            a aVar3 = this.f;
            if (aVar3 != null) {
                ((f) aVar3).getDialog().setCanceledOnTouchOutside(true);
                return;
            }
            return;
        }
        a aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.onDismiss();
        }
    }

    public final void a(boolean z) {
        if (this.f != null) {
            int i = c.a[this.a.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    a aVar = this.f;
                    aVar.getClass();
                    f fVar = (f) aVar;
                    FragmentActivity activity = fVar.getActivity();
                    if (activity != null) {
                        fVar.a = Integer.valueOf(activity.getRequestedOrientation());
                        activity.setRequestedOrientation(6);
                    }
                } else if (i == 3) {
                    a aVar2 = this.f;
                    aVar2.getClass();
                    f fVar2 = (f) aVar2;
                    FragmentActivity activity2 = fVar2.getActivity();
                    if (activity2 != null) {
                        fVar2.a = Integer.valueOf(activity2.getRequestedOrientation());
                        activity2.setRequestedOrientation(1);
                    }
                }
            } else if (this.g) {
                a aVar3 = this.f;
                aVar3.getClass();
                f fVar3 = (f) aVar3;
                FragmentActivity activity3 = fVar3.getActivity();
                if (activity3 != null) {
                    fVar3.a = Integer.valueOf(activity3.getRequestedOrientation());
                    activity3.setRequestedOrientation(6);
                }
            }
        }
        this.h = true;
        setShouldAnimateAddSignature(z);
        a aVar4 = this.f;
        if (aVar4 != null) {
            ((f) aVar4).getDialog().setCanceledOnTouchOutside(false);
        }
    }

    public static final Unit a(g20 g20Var, final g gVar, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(56544659, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.SignaturePickerDialogLayout.init.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignaturePickerDialogLayout.kt:250)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        f2.a(companion2, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        long jColor = ColorKt.Color(g20Var.o);
        float f = 16;
        Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 3, null), "PSPDF_PICKER_ADD_SIGNATURE_FAB");
        float fM9687constructorimpl = Dp.m9687constructorimpl(4);
        int i2 = g20Var.m;
        long jColor2 = ColorKt.Color(g20Var.n);
        boolean zChangedInstance = composer.changedInstance(gVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.g$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return g.b(this.f$0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        l20.a(modifierTestTag, i2, jColor2, jColor, fM9687constructorimpl, null, (Function0) objRememberedValue, composer, 24582, 32);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
