package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import com.pspdfkit.R;
import com.pspdfkit.internal.f00;
import com.pspdfkit.internal.g20;
import com.pspdfkit.internal.l20;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.SignatureUiData;
import io.reactivex.rxjava3.core.Completable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends MAMRelativeLayout implements e.b, SignatureControllerView.a {
    public final SignatureControllerView a;
    public final LegacySignatureCanvasView b;
    public final ComposeView c;
    public final FloatingActionButton d;
    public final CheckBox e;
    public InterfaceC0289a f;

    /* JADX INFO: renamed from: com.pspdfkit.internal.ui.dialog.signatures.a$a, reason: collision with other inner class name */
    public interface InterfaceC0289a {
        void onSignatureCreated(Signature signature, boolean z);

        void onSignatureUiDataCollected(Signature signature, SignatureUiData signatureUiData);
    }

    public static final class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new C0290a();
        public int a;
        public boolean b;

        /* JADX INFO: renamed from: com.pspdfkit.internal.ui.dialog.signatures.a$b$a, reason: collision with other inner class name */
        public static final class C0290a implements Parcelable.Creator<b> {
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
            parcel.writeInt(this.a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readByte() == 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        context.getClass();
        LayoutInflater.from(context).inflate(R.layout.pspdf__signature_layout_add_new_signature, (ViewGroup) this, true);
        final g20 g20Var = new g20(context);
        setGravity(17);
        View viewFindViewById = findViewById(R.id.pspdf__signature_canvas_view);
        viewFindViewById.getClass();
        LegacySignatureCanvasView legacySignatureCanvasView = (LegacySignatureCanvasView) viewFindViewById;
        this.b = legacySignatureCanvasView;
        legacySignatureCanvasView.setListener(this);
        View viewFindViewById2 = findViewById(R.id.pspdf__signature_controller_view);
        viewFindViewById2.getClass();
        SignatureControllerView signatureControllerView = (SignatureControllerView) viewFindViewById2;
        this.a = signatureControllerView;
        signatureControllerView.setListener(this);
        View viewFindViewById3 = findViewById(R.id.pspdf__signature_store_checkbox);
        viewFindViewById3.getClass();
        this.e = (CheckBox) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.pspdf__signature_fab_accept_edited_signature);
        viewFindViewById4.getClass();
        ComposeView composeView = (ComposeView) viewFindViewById4;
        this.c = composeView;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1568433728, true, new Function2() { // from class: com.pspdfkit.internal.ui.dialog.signatures.a$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return a.a(g20Var, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        View viewFindViewById5 = findViewById(R.id.pspdf__signature_fab_clear_edited_signature);
        viewFindViewById5.getClass();
        FloatingActionButton floatingActionButton = (FloatingActionButton) viewFindViewById5;
        this.d = floatingActionButton;
        floatingActionButton.setImageResource(g20Var.d);
        floatingActionButton.setColorFilter(g20Var.e, PorterDuff.Mode.SRC_ATOP);
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(g20Var.f));
        floatingActionButton.setScaleX(0.0f);
        floatingActionButton.setScaleY(0.0f);
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ui.dialog.signatures.a$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.a(this.f$0, view);
            }
        });
    }

    public static final Unit a(g20 g20Var, final a aVar, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1568433728, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.AddNewSignatureLayout.<anonymous>.<anonymous> (AddNewSignatureLayout.kt:82)");
            }
            int i2 = g20Var.a;
            long jColor = ColorKt.Color(g20Var.b);
            long jColor2 = ColorKt.Color(g20Var.c);
            float fDimensionResource = PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_fab_elevation, composer, 0);
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "PSPDF_ACCEPT_EDITED_SIGNATURE");
            boolean zChangedInstance = composer.changedInstance(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return a.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            l20.a(modifierTestTag, i2, jColor, jColor2, fDimensionResource, null, (Function0) objRememberedValue, composer, 6, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void b() {
        if (this.c.getVisibility() == 0) {
            return;
        }
        List<e.a> currentLines = this.b.getCurrentLines();
        if (currentLines.size() > 1 || (currentLines.size() == 1 && currentLines.get(0).b.size() > 1)) {
            Completable completableCreate = Completable.create(new f00(this.c, 2));
            completableCreate.getClass();
            completableCreate.subscribe();
        }
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void c() {
        Completable completableCreate = Completable.create(new f00(this.c, 1));
        completableCreate.getClass();
        Completable completableCreate2 = Completable.create(new f00((View) this.d, 1));
        completableCreate2.getClass();
        completableCreate.mergeWith(completableCreate2).subscribe();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void d() {
        Completable completableCreate = Completable.create(new f00((View) this.d, 2));
        completableCreate.getClass();
        completableCreate.subscribe();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        parcelable.getClass();
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.b.setInkColor(bVar.a);
        this.a.setCurrentlySelectedColor(bVar.a);
        setStoreSignatureCheckboxVisible(bVar.b);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = this.b.getInkColor();
        bVar.b = this.e.getVisibility() == 0;
        return bVar;
    }

    public final void setListener(InterfaceC0289a interfaceC0289a) {
        this.f = interfaceC0289a;
    }

    public final void setStoreSignatureCheckboxVisible(boolean z) {
        this.e.setVisibility(z ? 0 : 8);
    }

    public static final Unit a(a aVar) {
        InterfaceC0289a interfaceC0289a;
        Signature currentlyDrawnSignature = aVar.b.getCurrentlyDrawnSignature();
        if (currentlyDrawnSignature != null && (interfaceC0289a = aVar.f) != null) {
            interfaceC0289a.onSignatureUiDataCollected(currentlyDrawnSignature, aVar.b.e());
            interfaceC0289a.onSignatureCreated(currentlyDrawnSignature, aVar.e.isChecked());
        }
        return Unit.INSTANCE;
    }

    public static final void a(a aVar, View view) {
        aVar.b.c();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void a() {
        List<e.a> currentLines = this.b.getCurrentLines();
        if (currentLines.size() > 1 || (currentLines.size() == 1 && currentLines.get(0).b.size() > 1)) {
            this.c.setVisibility(0);
            this.c.setScaleX(1.0f);
            this.c.setScaleY(1.0f);
        }
        this.d.setVisibility(0);
        this.d.setScaleX(1.0f);
        this.d.setScaleY(1.0f);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.SignatureControllerView.a
    public final void a(int i) {
        this.b.setInkColor(i);
    }
}
