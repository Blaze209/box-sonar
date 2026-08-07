package com.pspdfkit.internal;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.core.content.ContextCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import com.pspdfkit.R;
import com.pspdfkit.configuration.signatures.SignatureCreationMode;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeLicense;
import com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import com.pspdfkit.ui.signatures.SignatureUiData;
import com.pspdfkit.utils.ParcelExtensions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
public final class qf extends MAMRelativeLayout implements sf {
    public final ElectronicSignatureOptions a;
    public final MutableState<List<Signature>> b;
    public final MutableState c;
    public final MutableState d;
    public final MutableState e;
    public final MutableState f;
    public final MutableState g;
    public x10 h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final MutableState<Boolean> l;
    public final MutableState m;
    public final LinkedHashSet n;

    public static final class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0285a();
        public boolean a;
        public boolean b;
        public List<Signature> c;
        public List<Signature> d;

        /* JADX INFO: renamed from: com.pspdfkit.internal.qf$a$a, reason: collision with other inner class name */
        public static final class C0285a implements Parcelable.Creator<a> {
            public static a[] a() {
                return a();
            }

            @Override // android.os.Parcelable.Creator
            public final a createFromParcel(Parcel parcel) {
                parcel.getClass();
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final a[] newArray(int i) {
                return a();
            }
        }

        public a(Parcelable parcelable) {
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

        public a(Parcel parcel) {
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

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SignatureCreationMode.values().length];
            try {
                iArr[SignatureCreationMode.DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SignatureCreationMode.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SignatureCreationMode.TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qf(Context context, ElectronicSignatureOptions electronicSignatureOptions) {
        super(context);
        context.getClass();
        electronicSignatureOptions.getClass();
        this.a = electronicSignatureOptions;
        this.b = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        this.c = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        Boolean bool = Boolean.FALSE;
        this.d = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        Boolean bool2 = Boolean.TRUE;
        this.e = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.f = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.g = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.j = true;
        this.l = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool2, null, 2, null);
        this.m = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.n = new LinkedHashSet();
        a(context);
    }

    public static final Unit a(g20 g20Var, final qf qfVar, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(967146326, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureDialogLayout.initializeView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ElectronicSignatureDialogLayout.kt:295)");
        }
        long jColor = ColorKt.Color(g20Var.o);
        float f = 16;
        Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 3, null), "PSPDF_PICKER_ADD_SIGNATURE_FAB");
        float fM9687constructorimpl = Dp.m9687constructorimpl(4);
        int i2 = g20Var.m;
        long jColor2 = ColorKt.Color(g20Var.n);
        boolean zChangedInstance = composer.changedInstance(qfVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return qf.d(this.f$0);
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

    public static final Unit b(qf qfVar) {
        qfVar.b();
        return Unit.INSTANCE;
    }

    public static final Unit c(qf qfVar) {
        if (qfVar.h != null && !qfVar.getCheckedSignatureList().isEmpty()) {
            x10 x10Var = qfVar.h;
            x10Var.getClass();
            x10Var.onSignaturesDeleted(new ArrayList(qfVar.getCheckedSignatureList()));
            List<Signature> value = qfVar.b.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (!qfVar.getCheckedSignatureList().contains((Signature) obj)) {
                    arrayList.add(obj);
                }
            }
            qfVar.b.setValue(arrayList);
            qfVar.setShouldClearCheckedItems(true);
        }
        return Unit.INSTANCE;
    }

    public static final Unit d(qf qfVar) {
        qfVar.l.setValue(Boolean.TRUE);
        qfVar.a();
        rf currentLayout = qfVar.getCurrentLayout();
        if (currentLayout != null) {
            if (currentLayout instanceof com.pspdfkit.internal.ui.dialog.signatures.i) {
                currentLayout.setActive(true);
            } else {
                currentLayout.setActive(false);
            }
        }
        return Unit.INSTANCE;
    }

    private final List<Signature> getCheckedSignatureList() {
        return (List) this.c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final rf getCurrentLayout() {
        return (rf) this.m.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShouldClearCheckedItems() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShouldShowBackButton() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShouldShowCloseButton() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShouldShowTitleContent() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    private final void setCheckedSignatureList(List<Signature> list) {
        this.c.setValue(list);
    }

    private final void setCurrentLayout(rf rfVar) {
        this.m.setValue(rfVar);
    }

    private final void setShouldClearCheckedItems(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }

    private final void setShouldShowBackButton(boolean z) {
        this.f.setValue(Boolean.valueOf(z));
    }

    private final void setShouldShowCloseButton(boolean z) {
        this.g.setValue(Boolean.valueOf(z));
    }

    private final void setShouldShowTitleContent(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
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
        b();
        return true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        parcelable.getClass();
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.i = true;
        MutableState<List<Signature>> mutableState = this.b;
        List<Signature> list = aVar.c;
        List<Signature> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatures");
            list = null;
        }
        mutableState.setValue(list);
        this.l.setValue(Boolean.valueOf(aVar.a));
        List<Signature> list3 = aVar.d;
        if (list3 != null) {
            list2 = list3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("checkedSignatures");
        }
        setCheckedSignatureList(list2);
        Context context = getContext();
        context.getClass();
        a(context);
        this.j = aVar.b;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.a = this.l.getValue().booleanValue();
        aVar.b = this.j;
        List<Signature> mutableList = CollectionsKt.toMutableList((Collection) this.b.getValue());
        mutableList.getClass();
        aVar.c = mutableList;
        List<Signature> mutableList2 = CollectionsKt.toMutableList((Collection) getCheckedSignatureList());
        mutableList2.getClass();
        aVar.d = mutableList2;
        return aVar;
    }

    @Override // com.pspdfkit.internal.sf
    public final void onSignatureCreated(Signature signature, boolean z) {
        signature.getClass();
        x10 x10Var = this.h;
        if (x10Var != null) {
            x10Var.onSignatureCreated(signature, z);
        }
    }

    @Override // com.pspdfkit.internal.sf
    public final void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData) {
        signature.getClass();
        x10 x10Var = this.h;
        if (x10Var != null) {
            x10Var.onSignatureUiDataCollected(signature, signatureUiData);
        }
    }

    public final void setFullscreen(boolean z) {
        this.k = z;
        a();
        setShouldShowCloseButton(!z);
    }

    public final void setItems(List<Signature> list) {
        list.getClass();
        this.b.setValue(list);
        this.l.setValue(Boolean.valueOf(list.isEmpty()));
        if (!this.i && list.isEmpty()) {
            this.j = false;
            this.l.setValue(Boolean.TRUE);
            a();
            rf currentLayout = getCurrentLayout();
            if (currentLayout != null) {
                if (currentLayout instanceof com.pspdfkit.internal.ui.dialog.signatures.i) {
                    currentLayout.setActive(true);
                } else {
                    currentLayout.setActive(false);
                }
            }
        }
        this.i = true;
    }

    public final void setListener(x10 x10Var) {
        x10Var.getClass();
        this.h = x10Var;
    }

    public static final LinearLayout b(Context context) {
        context.getClass();
        return new LinearLayout(context);
    }

    public final void b() {
        if (this.l.getValue().booleanValue()) {
            if (this.j) {
                this.l.setValue(Boolean.FALSE);
                rf currentLayout = getCurrentLayout();
                if (currentLayout != null) {
                    currentLayout.setActive(false);
                }
                a();
                Iterator it = this.n.iterator();
                while (it.hasNext()) {
                    ((rf) it.next()).e();
                }
                return;
            }
            x10 x10Var = this.h;
            if (x10Var != null) {
                x10Var.onDismiss();
                return;
            }
            return;
        }
        x10 x10Var2 = this.h;
        if (x10Var2 != null) {
            x10Var2.onDismiss();
        }
    }

    public static final Unit a(g20 g20Var, BoxScope boxScope, final qf qfVar, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(982049581, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureDialogLayout.initializeView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ElectronicSignatureDialogLayout.kt:272)");
        }
        long jColor = ColorKt.Color(g20Var.r);
        float f = 16;
        Modifier modifierAlign = boxScope.align(TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 3, null), "PSPDF_PICKER_DELETE_SIGNATURE_FAB"), Alignment.INSTANCE.getBottomEnd());
        float fM9687constructorimpl = Dp.m9687constructorimpl(4);
        int i2 = g20Var.p;
        long jColor2 = ColorKt.Color(g20Var.q);
        boolean zChangedInstance = composer.changedInstance(qfVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return qf.c(this.f$0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        l20.a(modifierAlign, i2, jColor2, jColor, fM9687constructorimpl, null, (Function0) objRememberedValue, composer, 24576, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public final void a(final Context context) {
        synchronized (ar.b()) {
            if (NativeLicense.license().signatureFeatureAvailability() == NativeSignatureFeatureAvailability.ELECTRONICSIGNATURES) {
                removeAllViews();
                final yq yqVar = new yq(context);
                final float fM9687constructorimpl = Dp.m9687constructorimpl(a80.a(yqVar.getTitlePadding(), context));
                final float fM9687constructorimpl2 = Dp.m9687constructorimpl(this.k ? 0 : yqVar.getCornerRadius() + 2);
                final g20 g20Var = new g20(context);
                final int i = g20Var.l;
                final int i2 = g20Var.s;
                ComposeView composeViewA = y9.a(context, p9.a);
                final com.pspdfkit.internal.ui.dialog.signatures.b bVar = new com.pspdfkit.internal.ui.dialog.signatures.b(context, this.a, g20Var);
                final com.pspdfkit.internal.ui.dialog.signatures.d dVar = new com.pspdfkit.internal.ui.dialog.signatures.d(context, this.a, g20Var);
                final com.pspdfkit.internal.ui.dialog.signatures.i iVar = new com.pspdfkit.internal.ui.dialog.signatures.i(context, this.a, g20Var);
                composeViewA.setContent(ComposableLambdaKt.composableLambdaInstance(1497659923, true, new Function2() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return qf.a(this.f$0, fM9687constructorimpl2, i, yqVar, context, bVar, dVar, iVar, i2, fM9687constructorimpl, g20Var, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }));
                composeViewA.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                addView(composeViewA);
                setFocusableInTouchMode(true);
                requestFocus();
                return;
            }
            throw new InvalidNutrientLicenseException("Creating signature annotations requires Electronic Signatures.");
        }
    }

    public static final Unit a(final qf qfVar, final float f, int i, final yq yqVar, final Context context, final com.pspdfkit.internal.ui.dialog.signatures.b bVar, final com.pspdfkit.internal.ui.dialog.signatures.d dVar, final com.pspdfkit.internal.ui.dialog.signatures.i iVar, int i2, final float f2, final g20 g20Var, Composer composer, int i3) {
        final qf qfVar2;
        Modifier.Companion companion;
        if (composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1497659923, i3, -1, "com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureDialogLayout.initializeView.<anonymous>.<anonymous> (ElectronicSignatureDialogLayout.kt:146)");
            }
            boolean zChanged = composer.changed(qfVar.b.getValue());
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = qfVar.b;
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierStatusBarsPadding = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(f)), ColorKt.Color(i), null, 2, null));
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierStatusBarsPadding);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            f2.a(companion4, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion4, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            AnimatedVisibilityKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, qfVar.getShouldShowTitleContent(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1251211525, true, new Function3() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return qf.a(this.f$0, f, yqVar, context, f2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 30);
            Composer composer2 = composer;
            if (!qfVar.a.getSignatureCreationModes().isEmpty() && qfVar.l.getValue().booleanValue()) {
                composer2.startReplaceGroup(230646292);
                int titleColor = yqVar.getTitleColor();
                int titleTextColor = yqVar.getTitleTextColor();
                int color = ContextCompat.getColor(context, R.color.pspdf__inversePrimaryLight);
                List<SignatureCreationMode> signatureCreationModes = qfVar.a.getSignatureCreationModes();
                long jColor = ColorKt.Color(titleColor);
                long jColor2 = ColorKt.Color(titleTextColor);
                long jColor3 = ColorKt.Color(color);
                boolean zChangedInstance = composer2.changedInstance(bVar) | composer2.changedInstance(dVar) | composer2.changedInstance(iVar) | composer2.changedInstance(qfVar);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return qf.a(bVar, dVar, iVar, qfVar, (SignatureCreationMode) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function1 function1 = (Function1) objRememberedValue2;
                float f3 = 48;
                Modifier modifierM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(companion2, 0.0f, Dp.m9687constructorimpl(f3), 1, null);
                boolean z = (qfVar.getShouldShowBackButton() || qfVar.getShouldShowTitleContent()) ? false : true;
                long jColor4 = ColorKt.Color(yqVar.getTitleIconsColor());
                long jColor5 = ColorKt.Color(i2);
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1270sizeInqDBjuR0$default(BackgroundKt.m589backgroundbw27NRU$default(companion2, ColorKt.Color(titleColor), null, 2, null), Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f3), 0.0f, 0.0f, 12, null), f2, 0.0f, f2, 0.0f, 10, null);
                boolean zChangedInstance2 = composer2.changedInstance(qfVar);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return qf.b(this.f$0);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                companion = companion2;
                tf.a(signatureCreationModes, jColor, jColor2, jColor3, function1, modifierM1251defaultMinSizeVpY3zN4$default, z, jColor4, jColor5, modifierM1222paddingqDBjuR0$default, (Function0) objRememberedValue3, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 0);
                composer2 = composer;
                final rf currentLayout = qfVar.getCurrentLayout();
                if (currentLayout == null) {
                    composer2.startReplaceGroup(233470825);
                    composer2.endReplaceGroup();
                    qfVar2 = qfVar;
                } else {
                    composer2.startReplaceGroup(233470826);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    Composer.Companion companion5 = Composer.INSTANCE;
                    if (objRememberedValue4 == companion5.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return qf.b((Context) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function2 = (Function1) objRememberedValue4;
                    qfVar2 = qfVar;
                    boolean zChangedInstance3 = composer2.changedInstance(qfVar2) | composer2.changedInstance(currentLayout);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue5 == companion5.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return qf.a(this.f$0, currentLayout, (LinearLayout) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    AndroidView_androidKt.AndroidView(function2, null, (Function1) objRememberedValue5, composer2, 6, 2);
                    Unit unit = Unit.INSTANCE;
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                qfVar2 = qfVar;
                companion = companion2;
                composer2.startReplaceGroup(234076101);
                composer2.endReplaceGroup();
            }
            if (!qfVar2.l.getValue().booleanValue()) {
                composer2.startReplaceGroup(234264953);
                qfVar2.setShouldShowTitleContent(true);
                Modifier.Companion companion6 = companion;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                Function0<ComposeUiNode> constructor2 = r19.getConstructor();
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
                f2.a(companion4, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion4, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                final BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                List list = (List) mutableState.getValue();
                boolean zChangedInstance4 = composer2.changedInstance(qfVar2);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return qf.a(this.f$0, (y10) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                i20.a(list, (Function1) objRememberedValue6, qfVar2.getShouldClearCheckedItems(), SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null), g20Var, composer2, 3072);
                AnimatedVisibilityKt.AnimatedVisibility(!qfVar2.getCheckedSignatureList().isEmpty(), boxScopeInstance.align(companion6, companion3.getBottomEnd()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(982049581, true, new Function3() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return qf.a(g20Var, boxScopeInstance, qfVar2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                AnimatedVisibilityKt.AnimatedVisibility(qfVar2.getCheckedSignatureList().isEmpty(), boxScopeInstance.align(companion6, companion3.getBottomEnd()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(967146326, true, new Function3() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return qf.a(g20Var, qfVar2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(238212741);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final qf qfVar, float f, yq yqVar, Context context, float f2, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1251211525, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureDialogLayout.initializeView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ElectronicSignatureDialogLayout.kt:157)");
        }
        String strStringResource = StringResources_androidKt.stringResource(qfVar.l.getValue().booleanValue() ? R.string.pspdf__add_signature : R.string.pspdf__signatures, composer, 0);
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), RoundedCornerShapeKt.m1575RoundedCornerShapea9UjIt4$default(f, f, 0.0f, 0.0f, 12, null)), ColorKt.Color(yqVar.getTitleColor()), null, 2, null);
        long jColor = ColorKt.Color(yqVar.getTitleTextColor());
        float titleTextSize = yqVar.getTitleTextSize();
        context.getClass();
        TextStyle textStyle = new TextStyle(jColor, TextUnitKt.getSp(titleTextSize / context.getResources().getDisplayMetrics().scaledDensity), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
        Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(companion, f2, 0.0f, f2, 0.0f, 10, null);
        int i2 = !qfVar.getShouldShowCloseButton() ? R.drawable.pspdf__ic_arrow_back : R.drawable.pspdf__ic_close;
        long jColor2 = ColorKt.Color(yqVar.getTitleIconsColor());
        boolean shouldShowCloseButton = true ^ qfVar.getShouldShowCloseButton();
        float f3 = 48;
        Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.m1270sizeInqDBjuR0$default(companion, Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f3), 0.0f, 0.0f, 12, null), f2);
        boolean zChangedInstance = composer.changedInstance(qfVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.qf$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return qf.a(this.f$0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        vc.a(strStringResource, textStyle, modifierM589backgroundbw27NRU$default, i2, jColor2, shouldShowCloseButton, (Function0) objRememberedValue, modifierM1218padding3ABfNKs, modifierM1222paddingqDBjuR0$default, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(qf qfVar) {
        qfVar.b();
        return Unit.INSTANCE;
    }

    public static final Unit a(com.pspdfkit.internal.ui.dialog.signatures.b bVar, com.pspdfkit.internal.ui.dialog.signatures.d dVar, com.pspdfkit.internal.ui.dialog.signatures.i iVar, qf qfVar, SignatureCreationMode signatureCreationMode) {
        signatureCreationMode.getClass();
        int i = b.a[signatureCreationMode.ordinal()];
        rf rfVar = bVar;
        if (i != 1) {
            if (i == 2) {
                rfVar = dVar;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                rfVar = iVar;
            }
        }
        if (rfVar instanceof com.pspdfkit.internal.ui.dialog.signatures.i) {
            qfVar.getClass();
            rfVar.setActive(true);
        } else {
            qfVar.getClass();
            iVar.setActive(false);
        }
        qfVar.n.add(rfVar);
        qfVar.setCurrentLayout(rfVar);
        rfVar.setListener(qfVar);
        return Unit.INSTANCE;
    }

    public static final Unit a(qf qfVar, rf rfVar, LinearLayout linearLayout) {
        linearLayout.getClass();
        qfVar.getClass();
        ObjectAnimator duration = ObjectAnimator.ofFloat((Object) null, "translationX", linearLayout.getWidth(), 0.0f).setDuration(200L);
        duration.getClass();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat((Object) null, "translationX", 0.0f, linearLayout.getWidth()).setDuration(200L);
        duration2.getClass();
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(2, duration);
        layoutTransition.setAnimator(3, duration2);
        linearLayout.setLayoutTransition(layoutTransition);
        linearLayout.removeAllViews();
        ViewParent parent = rfVar.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(rfVar);
        }
        linearLayout.addView(rfVar);
        return Unit.INSTANCE;
    }

    public static final Unit a(qf qfVar, y10 y10Var) {
        y10Var.getClass();
        if (y10Var instanceof y10.a) {
            qfVar.setCheckedSignatureList(((y10.a) y10Var).a);
        } else if (Intrinsics.areEqual(y10Var, y10.b.a)) {
            qfVar.setShouldClearCheckedItems(false);
        } else if (y10Var instanceof y10.c) {
            x10 x10Var = qfVar.h;
            if (x10Var != null) {
                x10Var.onSignaturePicked(((y10.c) y10Var).a);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    public final void a() {
        if (getResources().getConfiguration().orientation == 2 && this.l.getValue().booleanValue() && this.k && this.a.getSignatureCreationModes().size() > 1) {
            setShouldShowBackButton(false);
            setShouldShowTitleContent(false);
        } else {
            setShouldShowBackButton(true);
            setShouldShowTitleContent(true);
        }
    }
}
