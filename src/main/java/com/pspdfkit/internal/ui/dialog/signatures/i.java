package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.pspdfkit.R;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.internal.ct;
import com.pspdfkit.internal.eh;
import com.pspdfkit.internal.f00;
import com.pspdfkit.internal.g20;
import com.pspdfkit.internal.rf;
import com.pspdfkit.internal.sf;
import com.pspdfkit.internal.t60;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.yz;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends rf implements e.b, ElectronicSignatureControllerView.d, ct, TypingElectronicSignatureCanvasView.a {
    public ElectronicSignatureControllerView c;
    public TypingElectronicSignatureCanvasView d;
    public ViewGroup e;
    public ViewGroup f;
    public ComposeView g;
    public final ArrayList<Font> h;
    public final MutableState<String> i;
    public final MutableIntState j;
    public FloatingActionButton k;
    public SaveSignatureChip l;
    public boolean m;
    public Disposable n;
    public g20 o;

    public static final class b<T> implements Consumer {
        public b() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Signature signature = (Signature) obj;
            signature.getClass();
            i iVar = i.this;
            sf sfVar = iVar.a;
            if (sfVar != null) {
                TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = iVar.d;
                SaveSignatureChip saveSignatureChip = null;
                if (typingElectronicSignatureCanvasView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
                    typingElectronicSignatureCanvasView = null;
                }
                sfVar.onSignatureUiDataCollected(signature, typingElectronicSignatureCanvasView.e());
                SaveSignatureChip saveSignatureChip2 = iVar.l;
                if (saveSignatureChip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("saveSignatureChip");
                } else {
                    saveSignatureChip = saveSignatureChip2;
                }
                sfVar.onSignatureCreated(signature, saveSignatureChip.isSelected());
            }
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = new c<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.TypingESignLayout", th, "Can't import typed signature: Bitmap conversion failed.", new Object[0]);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, ElectronicSignatureOptions electronicSignatureOptions, g20 g20Var) {
        super(context, g20Var);
        context.getClass();
        electronicSignatureOptions.getClass();
        ElectronicSignatureOptions.Companion companion = ElectronicSignatureOptions.INSTANCE;
        Context context2 = getContext();
        context2.getClass();
        this.h = new ArrayList<>(companion.getAvailableFonts(context2));
        this.i = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.j = SnapshotIntStateKt.mutableIntStateOf(ContextCompat.getColor(getContext(), R.color.pspdf__primaryLight));
        a(context, electronicSignatureOptions, g20Var);
    }

    public static final void b(i iVar, View view) {
        Single singleFlatMap;
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = iVar.d;
        EditText editText = null;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        Font selectedFontOrDefault = typingElectronicSignatureCanvasView.getSelectedFontOrDefault();
        if (selectedFontOrDefault == null) {
            throw new IllegalStateException("Selected font used for creating a signature was null.");
        }
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView2 = iVar.d;
        if (typingElectronicSignatureCanvasView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView2 = null;
        }
        typingElectronicSignatureCanvasView2.getClass();
        EditText editText2 = typingElectronicSignatureCanvasView2.s;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
        } else {
            editText = editText2;
        }
        Editable text = editText.getText();
        if (text == null) {
            singleFlatMap = Single.error(new IllegalStateException("Can't create signature image: Signature text is null."));
            singleFlatMap.getClass();
        } else {
            String string = text.toString();
            int inkColor = typingElectronicSignatureCanvasView2.getInkColor();
            DisplayMetrics displayMetrics = typingElectronicSignatureCanvasView2.getContext().getResources().getDisplayMetrics();
            displayMetrics.getClass();
            singleFlatMap = TypingElectronicSignatureCanvasView.a(string, selectedFontOrDefault, inkColor, displayMetrics).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).flatMap(t60.a);
            singleFlatMap.getClass();
        }
        iVar.n = singleFlatMap.subscribe(iVar.new b(), c.a);
    }

    private final void setSaveSignatureChipVisible(boolean z) {
        SaveSignatureChip saveSignatureChip = this.l;
        ViewGroup viewGroup = null;
        if (saveSignatureChip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveSignatureChip");
            saveSignatureChip = null;
        }
        saveSignatureChip.setVisibility(z ? 0 : 8);
        int i = getResources().getConfiguration().orientation;
        if (this.m || i != 2) {
            return;
        }
        ElectronicSignatureControllerView electronicSignatureControllerView = this.c;
        if (electronicSignatureControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureControllerView");
            electronicSignatureControllerView = null;
        }
        electronicSignatureControllerView.setOrientation(z ? ElectronicSignatureControllerView.e.HORIZONTAL : ElectronicSignatureControllerView.e.VERTICAL);
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureControllerContainer");
            viewGroup2 = null;
        }
        viewGroup2.setBackgroundResource(z ? R.drawable.pspdf__electronic_signature_controls_view_background : 0);
        ViewGroup viewGroup3 = this.f;
        if (z) {
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signatureCanvasContainer");
                viewGroup3 = null;
            }
            ViewGroup.LayoutParams layoutParams = viewGroup3.getLayoutParams();
            layoutParams.getClass();
            ((RelativeLayout.LayoutParams) layoutParams).addRule(2, R.id.pspdf__signature_fab_accept_edited_signature);
            ViewGroup viewGroup4 = this.e;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signatureControllerContainer");
            } else {
                viewGroup = viewGroup4;
            }
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            layoutParams2.getClass();
            ((RelativeLayout.LayoutParams) layoutParams2).addRule(6, R.id.pspdf__signature_fab_accept_edited_signature);
            return;
        }
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureCanvasContainer");
            viewGroup3 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = viewGroup3.getLayoutParams();
        layoutParams3.getClass();
        ((RelativeLayout.LayoutParams) layoutParams3).removeRule(2);
        ViewGroup viewGroup5 = this.e;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureControllerContainer");
        } else {
            viewGroup = viewGroup5;
        }
        ViewGroup.LayoutParams layoutParams4 = viewGroup.getLayoutParams();
        layoutParams4.getClass();
        ((RelativeLayout.LayoutParams) layoutParams4).removeRule(6);
    }

    public final void a(Context context, ElectronicSignatureOptions electronicSignatureOptions, g20 g20Var) {
        setId(R.id.pspdf__electronic_signatures_typing_signature);
        this.m = uc.a(context.getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        this.o = g20Var;
        this.j.setIntValue(g20Var.t);
        int i = g20Var.a;
        int i2 = g20Var.b;
        int i3 = g20Var.c;
        LayoutInflater.from(context).inflate(this.m ? R.layout.pspdf__typing_electronic_signature_dialog_layout : R.layout.pspdf__typing_electronic_signature_layout, (ViewGroup) this, true);
        g20 g20Var2 = this.o;
        ElectronicSignatureControllerView electronicSignatureControllerView = null;
        if (g20Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureLayoutStyle");
            g20Var2 = null;
        }
        setBackgroundColor(g20Var2.l);
        View viewFindViewById = findViewById(R.id.pspdf__signature_controller_container);
        viewFindViewById.getClass();
        this.e = (ViewGroup) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.pspdf__signature_canvas_container);
        viewFindViewById2.getClass();
        this.f = (ViewGroup) viewFindViewById2;
        ComposeView composeView = (ComposeView) findViewById(R.id.pspdf__electronic_signature_typing_font_list);
        if (composeView != null) {
            composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1309294103, true, new Function2() { // from class: com.pspdfkit.internal.ui.dialog.signatures.i$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return i.a(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }));
        } else {
            composeView = null;
        }
        this.g = composeView;
        View viewFindViewById3 = findViewById(R.id.pspdf__signature_canvas_view);
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = (TypingElectronicSignatureCanvasView) viewFindViewById3;
        typingElectronicSignatureCanvasView.setInkColor(electronicSignatureOptions.getSignatureColorOptions().option1(context));
        typingElectronicSignatureCanvasView.setListener(this);
        typingElectronicSignatureCanvasView.setOnSignatureTypedListener(this);
        viewFindViewById3.getClass();
        this.d = typingElectronicSignatureCanvasView;
        View viewFindViewById4 = findViewById(R.id.pspdf__signature_controller_view);
        ElectronicSignatureControllerView electronicSignatureControllerView2 = (ElectronicSignatureControllerView) viewFindViewById4;
        electronicSignatureControllerView2.setListener(this);
        electronicSignatureControllerView2.setOnFontSelectionListener(this);
        viewFindViewById4.getClass();
        this.c = electronicSignatureControllerView2;
        ElectronicSignatureControllerView.e eVar = (this.m || getResources().getConfiguration().orientation == 2) ? ElectronicSignatureControllerView.e.HORIZONTAL : ElectronicSignatureControllerView.e.VERTICAL;
        electronicSignatureControllerView2.setOrientation(eVar);
        ElectronicSignatureControllerView electronicSignatureControllerView3 = this.c;
        if (electronicSignatureControllerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureControllerView");
        } else {
            electronicSignatureControllerView = electronicSignatureControllerView3;
        }
        electronicSignatureControllerView.a(electronicSignatureOptions.getSignatureColorOptions());
        View viewFindViewById5 = findViewById(R.id.pspdf__electronic_signature_save_chip);
        SaveSignatureChip saveSignatureChip = (SaveSignatureChip) viewFindViewById5;
        saveSignatureChip.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ui.dialog.signatures.i$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.a(this.f$0, view);
            }
        });
        viewFindViewById5.getClass();
        this.l = saveSignatureChip;
        View viewFindViewById6 = findViewById(R.id.pspdf__signature_fab_accept_edited_signature);
        FloatingActionButton floatingActionButton = (FloatingActionButton) viewFindViewById6;
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(i3));
        floatingActionButton.setImageResource(i);
        floatingActionButton.setColorFilter(i2);
        floatingActionButton.setScaleX(0.0f);
        floatingActionButton.setScaleY(0.0f);
        ShapeAppearanceModel.Builder builder = floatingActionButton.getShapeAppearanceModel().toBuilder();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        floatingActionButton.setShapeAppearanceModel(builder.setAllCorners(0, TypedValue.applyDimension(1, 16.0f, displayMetrics)).build());
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ui.dialog.signatures.i$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.b(this.f$0, view);
            }
        });
        viewFindViewById6.getClass();
        this.k = floatingActionButton;
        setSaveSignatureChipVisible(electronicSignatureOptions.getSignatureSavingStrategy() == SignatureSavingStrategy.SAVE_IF_SELECTED);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.TypingElectronicSignatureCanvasView.a
    public final void afterTextChanged(Editable editable) {
        this.i.setValue(String.valueOf(editable));
        ElectronicSignatureControllerView electronicSignatureControllerView = this.c;
        if (electronicSignatureControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureControllerView");
            electronicSignatureControllerView = null;
        }
        electronicSignatureControllerView.setTypedSignature(editable != null ? editable.toString() : null);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void c() {
        FloatingActionButton floatingActionButton = this.k;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
            floatingActionButton = null;
        }
        Completable.create(new f00(floatingActionButton, 1)).subscribe();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void d() {
    }

    @Override // com.pspdfkit.internal.rf
    public final void e() {
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        typingElectronicSignatureCanvasView.c();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    public final boolean f() {
        boolean z;
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        EditText editText = null;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        EditText editText2 = typingElectronicSignatureCanvasView.s;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText2 = null;
        }
        if (editText2.getText() == null) {
            z = true;
        } else {
            EditText editText3 = typingElectronicSignatureCanvasView.s;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            } else {
                editText = editText3;
            }
            Editable text = editText.getText();
            text.getClass();
            if (StringsKt.trim(text).length() == 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return !z;
    }

    @Override // com.pspdfkit.internal.rf
    public e getCanvasView() {
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        if (typingElectronicSignatureCanvasView != null) {
            return typingElectronicSignatureCanvasView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        yz.a(this.n);
        this.n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ComposeView composeView;
        super.onLayout(z, i, i2, i3, i4);
        if (this.m || (composeView = this.g) == null) {
            return;
        }
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        FloatingActionButton floatingActionButton = null;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        int measuredHeight = typingElectronicSignatureCanvasView.getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight2 = getMeasuredHeight();
        FloatingActionButton floatingActionButton2 = this.k;
        if (floatingActionButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
        } else {
            floatingActionButton = floatingActionButton2;
        }
        composeView.layout(0, measuredHeight, measuredWidth, measuredHeight2 - floatingActionButton.getMeasuredHeight());
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        ComposeView composeView;
        super.onMeasure(i, i2);
        if (this.m || (composeView = this.g) == null) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        FloatingActionButton floatingActionButton = null;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        int measuredHeight2 = measuredHeight - typingElectronicSignatureCanvasView.getMeasuredHeight();
        FloatingActionButton floatingActionButton2 = this.k;
        if (floatingActionButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
        } else {
            floatingActionButton = floatingActionButton2;
        }
        composeView.getLayoutParams().height = measuredHeight2 - floatingActionButton.getMeasuredHeight();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        parcelable.getClass();
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        SaveSignatureChip saveSignatureChip = null;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        typingElectronicSignatureCanvasView.setInkColor(aVar.a);
        ElectronicSignatureControllerView electronicSignatureControllerView = this.c;
        if (electronicSignatureControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signatureControllerView");
            electronicSignatureControllerView = null;
        }
        electronicSignatureControllerView.setCurrentlySelectedColor(aVar.a);
        setSaveSignatureChipVisible(aVar.b);
        SaveSignatureChip saveSignatureChip2 = this.l;
        if (saveSignatureChip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveSignatureChip");
        } else {
            saveSignatureChip = saveSignatureChip2;
        }
        saveSignatureChip.setSelected(aVar.c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView2 = null;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        aVar.a = typingElectronicSignatureCanvasView.getInkColor();
        SaveSignatureChip saveSignatureChip = this.l;
        if (saveSignatureChip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveSignatureChip");
            saveSignatureChip = null;
        }
        aVar.b = saveSignatureChip.getVisibility() == 0;
        SaveSignatureChip saveSignatureChip2 = this.l;
        if (saveSignatureChip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveSignatureChip");
            saveSignatureChip2 = null;
        }
        aVar.c = saveSignatureChip2.isSelected();
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView3 = this.d;
        if (typingElectronicSignatureCanvasView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
        } else {
            typingElectronicSignatureCanvasView2 = typingElectronicSignatureCanvasView3;
        }
        Font selectedFontOrDefault = typingElectronicSignatureCanvasView2.getSelectedFontOrDefault();
        aVar.d = selectedFontOrDefault != null ? selectedFontOrDefault.hashCode() : -1;
        return aVar;
    }

    public static final class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0292a();
        public int a;
        public boolean b;
        public boolean c;
        public int d;

        /* JADX INFO: renamed from: com.pspdfkit.internal.ui.dialog.signatures.i$a$a, reason: collision with other inner class name */
        public static final class C0292a implements Parcelable.Creator<a> {
            @Override // android.os.Parcelable.Creator
            public final a createFromParcel(Parcel parcel) {
                parcel.getClass();
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcelable parcelable) {
            super(parcelable);
            this.d = -1;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.getClass();
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.d);
        }

        public a(Parcel parcel) {
            super(parcel);
            this.d = -1;
            this.a = parcel.readInt();
            this.b = parcel.readByte() == 1;
            this.c = parcel.readByte() == 1;
            this.d = parcel.readInt();
        }
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void b() {
        FloatingActionButton floatingActionButton = this.k;
        FloatingActionButton floatingActionButton2 = null;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
            floatingActionButton = null;
        }
        if (floatingActionButton.getVisibility() != 0 && f()) {
            FloatingActionButton floatingActionButton3 = this.k;
            if (floatingActionButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
            } else {
                floatingActionButton2 = floatingActionButton3;
            }
            Completable.create(new f00(floatingActionButton2, 2)).subscribe();
        }
    }

    public static final Unit a(final i iVar, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1309294103, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.TypingElectronicSignatureLayout.init.<anonymous>.<anonymous> (TypingElectronicSignatureLayout.kt:155)");
            }
            Object[] objArr = new Object[0];
            boolean zChangedInstance = composer.changedInstance(iVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.ui.dialog.signatures.i$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return i.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composer, 0);
            ArrayList<Font> arrayList = iVar.h;
            g20 g20Var = iVar.o;
            if (g20Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signatureLayoutStyle");
                g20Var = null;
            }
            g20 g20Var2 = g20Var;
            String str = (String) mutableState.getValue();
            int intValue = iVar.j.getIntValue();
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean zChangedInstance2 = composer.changedInstance(iVar);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.ui.dialog.signatures.i$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return i.a(this.f$0, (Font) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            eh.a(arrayList, (Function1) objRememberedValue2, companion, intValue, str, g20Var2, composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final MutableState a(i iVar) {
        return iVar.i;
    }

    public static final Unit a(i iVar, Font font) {
        font.getClass();
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = iVar.d;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        typingElectronicSignatureCanvasView.setSelectedFont(font);
        return Unit.INSTANCE;
    }

    public static final void a(i iVar, View view) {
        SaveSignatureChip saveSignatureChip = iVar.l;
        SaveSignatureChip saveSignatureChip2 = null;
        if (saveSignatureChip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveSignatureChip");
            saveSignatureChip = null;
        }
        SaveSignatureChip saveSignatureChip3 = iVar.l;
        if (saveSignatureChip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveSignatureChip");
        } else {
            saveSignatureChip2 = saveSignatureChip3;
        }
        saveSignatureChip.setSelected(!saveSignatureChip2.isSelected());
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e.b
    public final void a() {
        if (f()) {
            FloatingActionButton floatingActionButton = this.k;
            FloatingActionButton floatingActionButton2 = null;
            if (floatingActionButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
                floatingActionButton = null;
            }
            floatingActionButton.setVisibility(0);
            FloatingActionButton floatingActionButton3 = this.k;
            if (floatingActionButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
                floatingActionButton3 = null;
            }
            floatingActionButton3.setScaleX(1.0f);
            FloatingActionButton floatingActionButton4 = this.k;
            if (floatingActionButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("acceptSignatureFab");
            } else {
                floatingActionButton2 = floatingActionButton4;
            }
            floatingActionButton2.setScaleY(1.0f);
        }
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView.d
    public final void a(int i) {
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        typingElectronicSignatureCanvasView.setInkColor(i);
        this.j.setIntValue(i);
    }

    @Override // com.pspdfkit.internal.ct
    public final void a(Font font) {
        TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView = this.d;
        if (typingElectronicSignatureCanvasView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typingElectronicSignatureCanvasView");
            typingElectronicSignatureCanvasView = null;
        }
        typingElectronicSignatureCanvasView.setSelectedFont(font);
    }
}
