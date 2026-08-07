package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.net.Uri;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import com.pspdfkit.R;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.internal.ak;
import com.pspdfkit.internal.bk;
import com.pspdfkit.internal.ck;
import com.pspdfkit.internal.dk;
import com.pspdfkit.internal.g20;
import com.pspdfkit.internal.p9;
import com.pspdfkit.internal.rf;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.y9;
import com.pspdfkit.internal.yl;
import com.pspdfkit.internal.yz;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends rf implements e.b, yl.c {
    public final ak c;
    public final MutableState<Boolean> d;
    public final MutableState<Boolean> e;
    public Disposable f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, ElectronicSignatureOptions electronicSignatureOptions, g20 g20Var) {
        super(context, g20Var);
        context.getClass();
        electronicSignatureOptions.getClass();
        Context context2 = getContext();
        context2.getClass();
        this.c = new ak(context2);
        Boolean bool = Boolean.FALSE;
        this.d = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.e = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        a(context, electronicSignatureOptions, g20Var);
    }

    public final void a(Context context, final ElectronicSignatureOptions electronicSignatureOptions, final g20 g20Var) {
        setId(R.id.pspdf__electronic_signatures_image_signature);
        final boolean zA = uc.a(context.getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        final boolean z = getResources().getConfiguration().orientation == 2;
        final int i = g20Var.l;
        ComposeView composeViewA = y9.a(context, p9.a);
        composeViewA.setContent(ComposableLambdaKt.composableLambdaInstance(1773689791, true, new Function2() { // from class: com.pspdfkit.internal.ui.dialog.signatures.d$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return d.a(this.f$0, electronicSignatureOptions, z, zA, g20Var, i, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        addView(composeViewA, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void b() {
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void c() {
        this.d.setValue(Boolean.FALSE);
        this.c.setSignatureUri(null);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void d() {
    }

    @Override // com.pspdfkit.internal.rf
    public final void e() {
        this.c.c();
    }

    @Override // com.pspdfkit.internal.rf
    public e getCanvasView() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        yz.a(this.f);
        this.f = null;
        super.onDetachedFromWindow();
    }

    @Override // com.pspdfkit.internal.yl.c
    public final void onImagePicked(Uri uri) {
        uri.getClass();
        this.c.setSignatureUri(uri);
        ak akVar = this.c;
        akVar.m = false;
        if (akVar.getSignatureUri() != null) {
            this.d.setValue(Boolean.TRUE);
        }
    }

    @Override // com.pspdfkit.internal.yl.c
    public final void onImagePickerCancelled() {
    }

    @Override // com.pspdfkit.internal.yl.c
    public final void onImagePickerUnknownError() {
        Toast.makeText(getContext(), R.string.pspdf__file_not_available, 1).show();
    }

    public static final Unit b(d dVar) {
        dVar.f = dVar.c.getSignatureImage().subscribe(new bk(dVar), ck.a);
        dVar.d.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    public static final MutableState a(d dVar) {
        return dVar.e;
    }

    public static final boolean a(ElectronicSignatureOptions electronicSignatureOptions) {
        return electronicSignatureOptions.getSignatureSavingStrategy() == SignatureSavingStrategy.SAVE_IF_SELECTED;
    }

    public static final Unit a(d dVar, boolean z) {
        dVar.e.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void a() {
        if (this.c.getSignatureUri() != null) {
            this.d.setValue(Boolean.TRUE);
        }
    }

    public static final Unit a(final d dVar, final ElectronicSignatureOptions electronicSignatureOptions, boolean z, boolean z2, g20 g20Var, int i, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1773689791, i2, -1, "com.pspdfkit.internal.ui.dialog.signatures.ImageElectronicSignatureLayout.init.<anonymous>.<anonymous> (ImageElectronicSignatureLayout.kt:96)");
            }
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = dVar.d;
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object[] objArr = new Object[0];
            boolean zChangedInstance = composer.changedInstance(dVar);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.d$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return d.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue2, composer, 0);
            Object[] objArr2 = new Object[0];
            boolean zChangedInstance2 = composer.changedInstance(electronicSignatureOptions);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.d$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(d.a(electronicSignatureOptions));
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            boolean zBooleanValue = ((Boolean) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue3, composer, 0)).booleanValue();
            ak akVar = dVar.c;
            boolean zChangedInstance3 = composer.changedInstance(dVar);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.d$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return d.b(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function0 function0 = (Function0) objRememberedValue4;
            boolean zBooleanValue2 = ((Boolean) mutableState.getValue()).booleanValue();
            boolean zBooleanValue3 = ((Boolean) mutableState2.getValue()).booleanValue();
            boolean zChangedInstance4 = composer.changedInstance(dVar);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.ui.dialog.signatures.d$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return d.a(this.f$0, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            dk.a(akVar, dVar, dVar, function0, zBooleanValue2, zBooleanValue, zBooleanValue3, (Function1) objRememberedValue5, z, z2, g20Var, BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.Color(i), null, 2, null), composer, 0, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
