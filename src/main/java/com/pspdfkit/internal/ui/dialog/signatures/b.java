package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import com.pspdfkit.R;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.internal.g20;
import com.pspdfkit.internal.p9;
import com.pspdfkit.internal.rf;
import com.pspdfkit.internal.sf;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.y9;
import com.pspdfkit.internal.ye;
import com.pspdfkit.internal.ze;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends rf implements e.b {
    public final ye c;
    public final MutableState<Boolean> d;
    public final MutableState<Boolean> e;
    public final boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, final ElectronicSignatureOptions electronicSignatureOptions, final g20 g20Var) {
        super(context, g20Var);
        context.getClass();
        electronicSignatureOptions.getClass();
        this.c = new ye(context);
        Boolean bool = Boolean.FALSE;
        this.d = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.e = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        setId(R.id.pspdf__electronic_signatures_draw_signature);
        this.f = uc.a(context.getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        final int i = g20Var.l;
        final ComposeView composeViewA = y9.a(context, p9.a);
        composeViewA.setContent(ComposableLambdaKt.composableLambdaInstance(699753543, true, new Function2() { // from class: com.pspdfkit.internal.ui.dialog.signatures.b$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return b.a(electronicSignatureOptions, this, composeViewA, i, g20Var, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        addView(composeViewA, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(final ElectronicSignatureOptions electronicSignatureOptions, final b bVar, ComposeView composeView, int i, g20 g20Var, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(699753543, i2, -1, "com.pspdfkit.internal.ui.dialog.signatures.DrawElectronicSignatureLayout.<anonymous>.<anonymous> (DrawElectronicSignatureLayout.kt:57)");
            }
            Object[] objArr = new Object[0];
            boolean zChangedInstance = composer.changedInstance(electronicSignatureOptions);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.b$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.a(electronicSignatureOptions);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composer, 0);
            Object[] objArr2 = new Object[0];
            boolean zChangedInstance2 = composer.changedInstance(bVar);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.b$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composer, 0);
            ye yeVar = bVar.c;
            boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
            boolean zBooleanValue2 = ((Boolean) mutableState.getValue()).booleanValue();
            boolean zBooleanValue3 = bVar.d.getValue().booleanValue();
            boolean z = composeView.getResources().getConfiguration().orientation == 2;
            boolean z2 = bVar.f;
            long jColor = ColorKt.Color(i);
            boolean zChangedInstance3 = composer.changedInstance(bVar);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.ui.dialog.signatures.b$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b.a(this.f$0, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(bVar);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.b$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.b(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ze.a(yeVar, zBooleanValue, zBooleanValue2, zBooleanValue3, z, z2, bVar, electronicSignatureOptions, jColor, function1, (Function0) objRememberedValue4, g20Var, null, composer, 0, 0, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(b bVar) {
        Signature currentlyDrawnSignature = bVar.c.getCurrentlyDrawnSignature();
        sf sfVar = bVar.a;
        if (sfVar != null && currentlyDrawnSignature != null) {
            sfVar.onSignatureUiDataCollected(currentlyDrawnSignature, bVar.c.e());
            sfVar.onSignatureCreated(currentlyDrawnSignature, bVar.e.getValue().booleanValue());
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void c() {
        this.d.setValue(Boolean.FALSE);
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

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void b() {
        List<e.a> currentLines = this.c.getCurrentLines();
        if (currentLines == null || currentLines.isEmpty()) {
            return;
        }
        Iterator<T> it = currentLines.iterator();
        while (it.hasNext()) {
            if (((e.a) it.next()).b.size() >= 10) {
                this.d.setValue(Boolean.TRUE);
                return;
            }
        }
    }

    public static final MutableState a(ElectronicSignatureOptions electronicSignatureOptions) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(electronicSignatureOptions.getSignatureSavingStrategy() == SignatureSavingStrategy.SAVE_IF_SELECTED), null, 2, null);
    }

    public static final MutableState a(b bVar) {
        return bVar.e;
    }

    public static final Unit a(b bVar, boolean z) {
        bVar.e.setValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void a() {
        List<e.a> currentLines = this.c.getCurrentLines();
        if (currentLines == null || currentLines.isEmpty()) {
            return;
        }
        Iterator<T> it = currentLines.iterator();
        while (it.hasNext()) {
            if (((e.a) it.next()).b.size() >= 10) {
                this.d.setValue(Boolean.TRUE);
                return;
            }
        }
    }
}
