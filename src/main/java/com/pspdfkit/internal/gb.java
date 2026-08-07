package com.pspdfkit.internal;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.google.android.material.internal.CollapsingTextHelper;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import com.pspdfkit.contentediting.ContentEditingFormatter;
import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.FaceMismatch;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.exceptions.ContentEditingUnavailableException;
import com.pspdfkit.undo.edit.contentediting.ContentEditingNativeChangeEdit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingTextBlockAlignmentEdit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingTextBlockLineSpacingEdit;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class gb extends View implements ContentEditingFormatter, View.OnFocusChangeListener, hn.d {
    public static final /* synthetic */ int b0 = 0;
    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public String F;
    public int G;
    public hn.c H;
    public boolean I;
    public boolean J;
    public final Handler K;
    public final b L;
    public final Paint M;
    public final Paint N;
    public final Lazy O;
    public boolean P;
    public float Q;
    public float R;
    public boolean S;
    public final int T;
    public final GestureDetector U;
    public ActionMode V;
    public final a W;
    public final int a;
    public final Lazy a0;
    public i50 b;
    public final mb c;
    public float d;
    public final t50 e;
    public sa f;
    public at g;
    public final int h;
    public final int i;
    public vo j;
    public final s00 k;
    public final int[] l;
    public int m;
    public int n;
    public final ViewTreeObserver.OnPreDrawListener o;
    public StyleInfo p;
    public q00 q;
    public int r;
    public int s;
    public x60 t;
    public Job u;
    public boolean v;
    public boolean w;
    public boolean x;
    public Integer y;
    public int z;

    public static final class a implements ActionMode.Callback {
        public final /* synthetic */ Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            actionMode.getClass();
            menuItem.getClass();
            int itemId = menuItem.getItemId();
            if (itemId == 1001) {
                actionMode.finish();
                return true;
            }
            switch (itemId) {
                case R.id.selectAll:
                    gb gbVar = gb.this;
                    gbVar.a(0, gbVar.b.c().c().length(), true);
                    gbVar.invalidate();
                    PdfLog.d("ContentEditingTextInputView", "selectAll: selected all text", new Object[0]);
                    actionMode.invalidate();
                    return true;
                case R.id.cut:
                    gb gbVar2 = gb.this;
                    if (!gbVar2.q.a()) {
                        gbVar2.c();
                        q00 q00Var = gbVar2.q;
                        gbVar2.a(q00Var.a, q00Var.b);
                        gbVar2.b(gbVar2.q.a, true);
                        PdfLog.d("ContentEditingTextInputView", "cutSelection: cut and deleted selection", new Object[0]);
                    }
                    actionMode.finish();
                    return true;
                case R.id.copy:
                    gb gbVar3 = gb.this;
                    int i = gbVar3.q.b;
                    gbVar3.c();
                    gb.this.b(i, true);
                    actionMode.finish();
                    return true;
                case R.id.paste:
                    gb.this.g();
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getClass();
            menu.getClass();
            menu.add(0, R.id.copy, 0, R.string.copy);
            menu.add(0, R.id.cut, 0, R.string.cut);
            menu.add(0, R.id.paste, 0, R.string.paste);
            menu.add(0, R.id.selectAll, 0, R.string.selectAll);
            menu.add(0, 1001, 0, "╳");
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            actionMode.getClass();
            gb.this.V = null;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getClass();
            menu.getClass();
            boolean zA = gb.this.q.a();
            gb gbVar = gb.this;
            boolean z = false;
            boolean z2 = gbVar.E && gbVar.q.a();
            MenuItem menuItemFindItem = menu.findItem(R.id.copy);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible((zA || z2) ? false : true);
            }
            MenuItem menuItemFindItem2 = menu.findItem(R.id.cut);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible((zA || z2) ? false : true);
            }
            Object systemService = this.b.getSystemService("clipboard");
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            boolean z3 = clipboardManager != null && MAMClipboard.hasPrimaryClip(clipboardManager);
            MenuItem menuItemFindItem3 = menu.findItem(R.id.paste);
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setVisible(z3);
            }
            gb gbVar2 = gb.this;
            q00 q00Var = gbVar2.q;
            if (q00Var.a == 0 && q00Var.b == ((String) gbVar2.getTextBlock$sdk_nutrient().e.i.getValue()).length()) {
                z = true;
            }
            MenuItem menuItemFindItem4 = menu.findItem(R.id.selectAll);
            if (menuItemFindItem4 != null) {
                menuItemFindItem4.setVisible(!z);
            }
            MenuItem menuItemFindItem5 = menu.findItem(1001);
            if (menuItemFindItem5 != null) {
                menuItemFindItem5.setVisible(true);
            }
            return true;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (gb.this.q.a()) {
                gb gbVar = gb.this;
                gbVar.I = !gbVar.I;
                gbVar.invalidate();
                gb.this.K.postDelayed(this, 500L);
            }
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            motionEvent.getClass();
            gb gbVar = gb.this;
            gbVar.P = true;
            gb.this.a(gbVar.a(motionEvent.getX(), motionEvent.getY()), motionEvent.getX(), motionEvent.getY());
            gb.this.k();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            motionEvent.getClass();
            gb gbVar = gb.this;
            gbVar.P = true;
            int iA = gbVar.a(motionEvent.getX(), motionEvent.getY());
            gb.this.a(iA, motionEvent.getX(), motionEvent.getY());
            gb.this.k();
            PdfLog.d("ContentEditingTextInputView", "onLongPress: entered selection mode, selected word at offset=" + iA, new Object[0]);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            motionEvent.getClass();
            int iA = gb.this.a(motionEvent.getX(), motionEvent.getY());
            gb.this.b(iA, true);
            s00 s00Var = gb.this.k;
            s00Var.j = true;
            s00Var.c();
            gb.this.invalidate();
            ActionMode actionMode = gb.this.V;
            if (actionMode != null) {
                actionMode.finish();
            }
            if (!gb.this.isFocused()) {
                gb.this.requestFocus();
            }
            hn.a(gb.this, (f7) null);
            PdfLog.d("ContentEditingTextInputView", "showSoftInput: requested keyboard via KeyboardUtils", new Object[0]);
            PdfLog.d("ContentEditingTextInputView", "onSingleTapUp: offset=" + iA + " (cleared selection)", new Object[0]);
            return true;
        }
    }

    public static final class d {
        public final uf a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public d(uf ufVar, int i, int i2, int i3, int i4) {
            this.a = ufVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.a, dVar.a) && this.b == dVar.b && this.c == dVar.c && this.d == dVar.d && this.e == dVar.e;
        }

        public final int hashCode() {
            return Integer.hashCode(this.e) + nd.a(this.d, nd.a(this.c, nd.a(this.b, this.a.hashCode() * 31, 31), 31), 31);
        }

        public final String toString() {
            return "ElementWithPosition(element=" + this.a + ", lineIndex=" + this.b + ", indexWithinLine=" + this.c + ", textStart=" + this.d + ", textEnd=" + this.e + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb(final Context context, int i, i50 i50Var, mb mbVar, float f) {
        super(context);
        context.getClass();
        mbVar.getClass();
        this.a = i;
        this.b = i50Var;
        this.c = mbVar;
        this.d = f;
        this.e = new t50(i50Var, f);
        this.h = (int) un.a(context, 1, 10);
        this.i = (int) un.a(context, 1, 32);
        this.k = new s00(this);
        this.l = new int[2];
        this.o = new ViewTreeObserver.OnPreDrawListener() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda4
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return gb.c(this.f$0);
            }
        };
        this.q = new q00(0, 0);
        this.r = -1;
        this.s = -1;
        this.F = "";
        this.G = 32;
        this.I = true;
        this.K = new Handler(Looper.getMainLooper());
        this.L = new b();
        Paint paint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.colorControlActivated}, 0, 0);
        paint.setColor(typedArrayObtainStyledAttributes.getColor(0, -14575885));
        typedArrayObtainStyledAttributes.recycle();
        paint.setStrokeWidth(4.0f);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.M = paint;
        Paint paint2 = new Paint();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, new int[]{R.attr.textColorHighlight}, 0, 0);
        paint2.setColor(typedArrayObtainStyledAttributes2.getColor(0, 1073742079));
        typedArrayObtainStyledAttributes2.recycle();
        Paint.Style style2 = Paint.Style.FILL;
        paint2.setStyle(style2);
        this.N = paint2;
        this.O = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return gb.a(this.f$0);
            }
        });
        Paint paint3 = new Paint();
        paint3.setColor(553582592);
        paint3.setStyle(style2);
        Paint paint4 = new Paint();
        paint4.setColor(-16777216);
        paint4.setStrokeWidth(4.0f);
        paint4.setStyle(style);
        Paint paint5 = new Paint();
        paint5.setColor(CollapsingTextHelper.SEMITRANSPARENT_MAGENTA);
        paint5.setStrokeWidth(1.0f);
        paint5.setStyle(style);
        this.T = ViewConfiguration.get(context).getScaledTouchSlop();
        this.U = new GestureDetector(context, new c());
        this.W = new a(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setBackgroundColor(0);
        PdfLog.d("ContentEditingTextInputView", "ContentEditingTextInputView initialized", new Object[0]);
        this.a0 = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return gb.a(context);
            }
        });
    }

    public static final Paint a(gb gbVar) {
        Paint paint = new Paint();
        paint.setColor(gbVar.M.getColor());
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    public static final void b(gb gbVar) {
        if (!gbVar.hasFocus() || gbVar.q.a()) {
            return;
        }
        gbVar.k.c();
        gbVar.k();
        PdfLog.d("ContentEditingTextInputView", "Focus gained: restored selection UI", new Object[0]);
    }

    public static final boolean c(gb gbVar) {
        if (gbVar.hasFocus()) {
            gbVar.getLocationInWindow(gbVar.l);
            int[] iArr = gbVar.l;
            int i = iArr[0];
            int i2 = iArr[1];
            if (i != gbVar.m || i2 != gbVar.n) {
                gbVar.m = i;
                gbVar.n = i2;
                gbVar.k.c();
            }
        }
        return true;
    }

    private final Paint getCompositionUnderlinePaint() {
        return (Paint) this.O.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSelection$lambda$0(gb gbVar) {
        if (gbVar.E && gbVar.q.a() && gbVar.hasFocus() && !gbVar.J) {
            gbVar.k();
            PdfLog.d("ContentEditingTextInputView", "setSelection: showing paste-only menu after copy", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSelection$lambda$1(gb gbVar) {
        if (gbVar.E && gbVar.q.a() && gbVar.hasFocus() && !gbVar.J) {
            gbVar.k();
            PdfLog.d("ContentEditingTextInputView", "setSelection: showing paste-only menu after cursor move", new Object[0]);
        }
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public final void applyFormat(StyleInfo styleInfo) {
        styleInfo.getClass();
        boolean zA = this.q.a();
        i50 i50Var = this.b;
        if (zA) {
            g70 g70Var = i50Var.e;
            zq zqVarA = i50.a(i50Var, styleInfo);
            FaceMismatch faceMismatch = this.b.e.e.b;
            if (styleInfo.isFontResolved()) {
                faceMismatch = null;
            }
            tc tcVar = new tc(zqVarA, faceMismatch, this.b.e.e.c);
            g70Var.getClass();
            g70Var.e = tcVar;
            i50 i50Var2 = this.b;
            StyleInfo styleInfoA = i50Var2.a(i50Var2.e);
            sa saVar = this.f;
            if (saVar != null) {
                i50 i50Var3 = this.b;
                int i = this.q.b;
                saVar.a(i50Var3, styleInfoA, i, i, true);
                return;
            }
            return;
        }
        x60 x60VarA = jb.a(i50Var);
        int iA = this.b.a(this.q.a);
        int iA2 = this.b.a(this.q.b);
        q00 q00Var = this.q;
        PdfLog.d("ContentEditingTextInputView", "applyFormat: SAVED selection chars=[" + q00Var.a + ", " + q00Var.b + "] as clusters=[" + iA + ", " + iA2 + "]", new Object[0]);
        try {
            g70 g70Var2 = this.c.a(this.b, styleInfo).a;
            int iB = this.b.b(iA);
            int iB2 = this.b.b(iA2);
            PdfLog.d("ContentEditingTextInputView", "applyFormat: CONVERTED clusters=[" + iA + ", " + iA2 + "] back to chars=[" + iB + ", " + iB2 + "]", new Object[0]);
            try {
                g70 g70Var3 = this.c.a(this.b, iB, iB2).a;
                i50 i50Var4 = this.b;
                i50Var4.getClass();
                g70Var3.getClass();
                g70 g70Var4 = i50Var4.e;
                g70Var4.getClass();
                g70Var4.d = g70Var3.d;
                g70Var4.h = g70Var3.h;
                PdfLog.d("ContentEditingTextInputView", "applyFormat: synced selection with native editor", new Object[0]);
            } catch (ContentEditingUnavailableException unused) {
                PdfLog.w("ContentEditingTextInputView", "Content editing session unavailable, ignoring selection restore", new Object[0]);
            }
            this.q = new q00(iB, iB2);
            this.v = true;
            PdfLog.d("ContentEditingTextInputView", "applyFormat: RESTORED selection=[" + iB + ", " + iB2 + "], flag=true", new Object[0]);
            sa saVar2 = this.f;
            if (saVar2 != null) {
                saVar2.a(this.b, false, true, false);
            }
            m();
            x60 x60VarA2 = jb.a(this.b);
            at atVar = this.g;
            if (atVar != null) {
                int i2 = this.a;
                i50 i50Var5 = this.b;
                atVar.a(new ContentEditingNativeChangeEdit(i2, i50Var5.c, x60VarA, x60VarA2, i50Var5.e(), null, 32, null));
            }
        } catch (ContentEditingUnavailableException unused2) {
            PdfLog.w("ContentEditingTextInputView", "Content editing session unavailable, ignoring style change", new Object[0]);
        }
    }

    public final void d(int i, int i2) {
        boolean z = this.r != -1;
        this.r = i;
        this.s = i2;
        if (z && i == -1) {
            b();
        }
        if (this.x) {
            j();
        }
        if (hasFocus()) {
            n();
        }
        PdfLog.d("ContentEditingTextInputView", "setComposingRegion: [" + this.r + ", " + this.s + "]", new Object[0]);
    }

    public final void e() {
        ActionMode actionMode = this.V;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.V = null;
    }

    public final void f() {
        Integer num = this.y;
        if (num != null) {
            int iIntValue = num.intValue();
            Context context = getContext();
            context.getClass();
            InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
            if (inputMethodManager == null) {
                return;
            }
            String strC = this.b.c().c();
            int iCoerceIn = RangesKt.coerceIn(this.q.a, 0, strC.length());
            int iCoerceIn2 = RangesKt.coerceIn(this.q.b, 0, strC.length());
            ExtractedText extractedText = new ExtractedText();
            extractedText.text = strC;
            extractedText.selectionStart = iCoerceIn;
            extractedText.selectionEnd = iCoerceIn2;
            extractedText.startOffset = 0;
            extractedText.partialStartOffset = -1;
            extractedText.partialEndOffset = -1;
            extractedText.flags = 0;
            Unit unit = Unit.INSTANCE;
            inputMethodManager.updateExtractedText(this, iIntValue, extractedText);
            PdfLog.d("ContentEditingTextInputView", "notifyExtractedTextChanged: pushed textLength=" + strC.length() + ", sel=[" + iCoerceIn + ", " + iCoerceIn2 + "]", new Object[0]);
        }
    }

    public final void g() {
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        ClipData primaryClip = clipboardManager != null ? MAMClipboard.getPrimaryClip(clipboardManager) : null;
        if (primaryClip == null || primaryClip.getItemCount() == 0) {
            PdfLog.d("ContentEditingTextInputView", "paste: no clipboard data", new Object[0]);
            return;
        }
        CharSequence text = primaryClip.getItemAt(0).getText();
        String string = text != null ? text.toString() : null;
        if (string == null || string.length() == 0) {
            PdfLog.d("ContentEditingTextInputView", "paste: clipboard text is empty", new Object[0]);
            return;
        }
        this.E = false;
        boolean zA = this.q.a();
        q00 q00Var = this.q;
        int iA = !zA ? a(q00Var.a, q00Var.b, string) : a(q00Var.b, string);
        b(iA, false);
        PdfLog.d("ContentEditingTextInputView", "paste: pasted '" + string + "', newCursor=" + iA, new Object[0]);
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public List<Integer> getAvailableFontSizes() {
        return (List) this.a0.getValue();
    }

    public final int getComposingEnd() {
        return this.s;
    }

    public final int getComposingStart() {
        return this.r;
    }

    public final int getCursor() {
        return this.q.b;
    }

    public final int getMaxLineHeightForMagnifier$sdk_nutrient() {
        return this.i;
    }

    public final int getMinLineHeightForMagnifier$sdk_nutrient() {
        return this.h;
    }

    public final q00 getSelection() {
        return this.q;
    }

    public final int getSelectionEnd() {
        return this.q.b;
    }

    public final int getSelectionStart() {
        return this.q.a;
    }

    public final boolean getSuppressCursorBlink$sdk_nutrient() {
        return this.J;
    }

    public final i50 getTextBlock() {
        return this.b;
    }

    public final i50 getTextBlock$sdk_nutrient() {
        return this.b;
    }

    public final t50 getTextMetrics$sdk_nutrient() {
        return this.e;
    }

    public final void h() {
        this.y = null;
        if (hasFocus()) {
            this.k.c();
        }
        PdfLog.d("ContentEditingTextInputView", "exitExtractMode", new Object[0]);
        Context context = getContext();
        context.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.restartInput(this);
        PdfLog.d("ContentEditingTextInputView", "restartImeInput: restarted IME connection", new Object[0]);
    }

    public final void i() {
        sa saVar = this.f;
        if (saVar == null) {
            return;
        }
        RectF pageRect = this.b.e.a.getPageRect();
        pageRect.getClass();
        saVar.a(pageRect);
        PdfLog.d("ContentEditingTextInputView", "scrollToTextBlock: scrolled to rect=" + pageRect, new Object[0]);
    }

    public final void j() {
        int i;
        if (this.w || this.x) {
            if (this.b.e.f.a.size() == 0) {
                PdfLog.d("ContentEditingTextInputView", "sendCursorUpdateToIme: No lines available", new Object[0]);
                return;
            }
            try {
                int iB = b(this.q.b);
                float fA = a(this.q.b);
                t50.a aVarB = this.e.b(iB);
                float fE = e(iB);
                float f = aVarB.a;
                CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
                q00 q00Var = this.q;
                float f2 = fE + f;
                CursorAnchorInfo.Builder insertionMarkerLocation = builder.setSelectionRange(q00Var.a, q00Var.b).setInsertionMarkerLocation(fA, fE, f2, f2, 5);
                int i2 = this.r;
                if (i2 != -1 && (i = this.s) != -1 && i2 < i) {
                    insertionMarkerLocation.setComposingText(this.r, this.b.c().c().substring(this.r, this.s));
                    int i3 = this.r;
                    int i4 = this.s;
                    for (int i5 = i3; i5 < i4; i5++) {
                        float fA2 = a(i5);
                        float fA3 = this.e.a(i5);
                        int iB2 = b(i5);
                        float fE2 = e(iB2);
                        RectF rectF = new RectF(fA2, fE2, fA3 + fA2, this.e.b(iB2).a + fE2);
                        insertionMarkerLocation.addCharacterBounds(i5, rectF.left, rectF.top, rectF.right, rectF.bottom, 1);
                    }
                }
                insertionMarkerLocation.setMatrix(getMatrix());
                CursorAnchorInfo cursorAnchorInfoBuild = insertionMarkerLocation.build();
                Context context = getContext();
                context.getClass();
                InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
                if (inputMethodManager == null) {
                    return;
                }
                inputMethodManager.updateCursorAnchorInfo(this, cursorAnchorInfoBuild);
                q00 q00Var2 = this.q;
                int i6 = q00Var2.b;
                PdfLog.d("ContentEditingTextInputView", "sendCursorUpdateToIme: sent update, cursor=" + i6 + ", selection=[" + q00Var2.a + ", " + i6 + "], composing=[" + this.r + ", " + this.s + "]", new Object[0]);
            } catch (Exception e) {
                PdfLog.w("ContentEditingTextInputView", "Failed to send cursor update to IME", e);
            }
        }
    }

    public final void k() {
        Context context = getContext();
        context.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager == null || inputMethodManager.isFullscreenMode() || this.V != null) {
            return;
        }
        this.V = startActionMode(this.W, 1);
    }

    public final void l() {
        this.K.removeCallbacks(this.L);
        if (this.q.a() && hasFocus()) {
            this.I = true;
            this.K.postDelayed(this.L, 500L);
        }
    }

    public final void m() {
        try {
            mb mbVar = this.c;
            i50 i50Var = this.b;
            q00 q00Var = this.q;
            g70 g70Var = mbVar.a(i50Var, q00Var.a, q00Var.b).a;
            StyleInfo styleInfoA = this.b.a(g70Var);
            boolean z = !Intrinsics.areEqual(styleInfoA, this.p);
            q00 q00Var2 = this.q;
            int i = q00Var2.a;
            int i2 = q00Var2.b;
            Boolean bold = styleInfoA.getBold();
            StyleInfo styleInfo = this.p;
            PdfLog.d("ContentEditingTextInputView", "syncSelectionWithNativeEditor: selection=[" + i + ", " + i2 + "], bold=" + bold + ", previousBold=" + (styleInfo != null ? styleInfo.getBold() : null) + ", styleChanged=" + z, new Object[0]);
            sa saVar = this.f;
            if (saVar != null) {
                i50 i50Var2 = this.b;
                q00 q00Var3 = this.q;
                saVar.a(i50Var2, styleInfoA, q00Var3.a, q00Var3.b, z);
            }
            i50 i50Var3 = this.b;
            i50Var3.getClass();
            g70 g70Var2 = i50Var3.e;
            g70Var2.getClass();
            g70Var2.d = g70Var.d;
            g70Var2.h = g70Var.h;
            this.p = styleInfoA;
        } catch (Exception e) {
            PdfLog.w("ContentEditingTextInputView", "syncSelectionWithNativeEditor: failed", e);
        }
    }

    public final void n() {
        Context context = getContext();
        context.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager == null || inputMethodManager.isFullscreenMode()) {
            return;
        }
        this.k.c();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.o);
        vo voVar = this.j;
        if (voVar == null || !voVar.e || voVar.d) {
            return;
        }
        voVar.c.a.a();
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.getClass();
        editorInfo.inputType = 131073;
        editorInfo.imeOptions = 1;
        q00 q00Var = this.q;
        int i = q00Var.a;
        editorInfo.initialSelStart = i;
        int i2 = q00Var.b;
        editorInfo.initialSelEnd = i2;
        PdfLog.d("ContentEditingTextInputView", "onCreateInputConnection called, initial selection=[" + i + ", " + i2 + "]", new Object[0]);
        return new pa(this, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.o);
        vo voVar = this.j;
        if (voVar == null || !voVar.e || voVar.d) {
            return;
        }
        voVar.c.a.b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        super.onDraw(canvas);
        if (!this.q.a()) {
            c(canvas);
        }
        b(canvas);
        if (this.r != -1) {
            a(canvas);
        }
        vo voVar = this.j;
        if (voVar != null) {
            voVar.a(canvas);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            hn.a(this, (f7) null);
            l();
            if (!this.q.a()) {
                postDelayed(new Runnable() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        gb.b(this.f$0);
                    }
                }, 150L);
            }
            PdfLog.d("ContentEditingTextInputView", "Focus gained", new Object[0]);
            return;
        }
        this.y = null;
        if (hasFocus()) {
            this.k.c();
        }
        PdfLog.d("ContentEditingTextInputView", "exitExtractMode", new Object[0]);
        this.K.removeCallbacks(this.L);
        this.I = false;
        s00 s00Var = this.k;
        s00Var.a();
        s00Var.b();
        invalidate();
        PdfLog.d("ContentEditingTextInputView", "Focus lost", new Object[0]);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        l();
        if (keyEvent != null && keyEvent.isCtrlPressed()) {
            if (i == 29) {
                a(0, this.b.c().c().length(), true);
                invalidate();
                PdfLog.d("ContentEditingTextInputView", "selectAll: selected all text", new Object[0]);
                return true;
            }
            if (i == 31) {
                c();
                return true;
            }
            if (i == 50) {
                g();
                return true;
            }
            if (i == 52) {
                if (!this.q.a()) {
                    c();
                    q00 q00Var = this.q;
                    a(q00Var.a, q00Var.b);
                    b(this.q.a, true);
                    PdfLog.d("ContentEditingTextInputView", "cutSelection: cut and deleted selection", new Object[0]);
                }
                return true;
            }
        }
        if (i == 66) {
            boolean zA = this.q.a();
            q00 q00Var2 = this.q;
            if (zA) {
                a(q00Var2.b, "\n");
                b(this.q.b + 1, true);
            } else {
                a(q00Var2.a, q00Var2.b, "\n");
                b(this.q.a + 1, true);
            }
            invalidate();
            return true;
        }
        if (i == 67) {
            boolean zA2 = this.q.a();
            q00 q00Var3 = this.q;
            if (zA2) {
                int i2 = q00Var3.b;
                if (i2 > 0) {
                    a(i2 - 1, i2);
                    b(this.q.b - 1, true);
                }
            } else {
                a(q00Var3.a, q00Var3.b);
                b(this.q.a, true);
            }
            return true;
        }
        if (i == 112) {
            boolean zA3 = this.q.a();
            q00 q00Var4 = this.q;
            if (!zA3) {
                a(q00Var4.a, q00Var4.b);
                b(this.q.a, true);
            } else if (q00Var4.b < ((String) this.b.e.i.getValue()).length()) {
                int i3 = this.q.b;
                a(i3, i3 + 1);
            }
            return true;
        }
        switch (i) {
            case 19:
                int iB = b(this.q.b);
                if (iB > 0) {
                    b(a(a(this.q.b), e(iB - 1) + 1.0f), true);
                    invalidate();
                }
                return true;
            case 20:
                int iB2 = b(this.q.b) + 1;
                if (iB2 < this.b.e.f.a.size()) {
                    int iD = d(iB2);
                    if (((Number) this.b.c(iB2).d.getValue()).intValue() == 0 && iD == ((String) this.b.e.i.getValue()).length()) {
                        b(((String) this.b.e.i.getValue()).length(), true);
                    } else {
                        b(a(a(this.q.b), e(iB2) + 1.0f), true);
                    }
                    invalidate();
                }
                return true;
            case 21:
                int i4 = this.q.b;
                if (i4 > 0) {
                    b(i4 - 1, true);
                    invalidate();
                }
                return true;
            case 22:
                if (this.q.b < ((String) this.b.e.i.getValue()).length()) {
                    b(this.q.b + 1, true);
                    invalidate();
                }
                return true;
            default:
                if (keyEvent == null || (unicodeChar = keyEvent.getUnicodeChar()) == 0) {
                    return super.onKeyDown(i, keyEvent);
                }
                b(a(this.q.b, String.valueOf((char) unicodeChar)), true);
                return true;
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && hasFocus() && !this.q.a()) {
            this.k.c();
            PdfLog.d("ContentEditingTextInputView", "onLayout: layout changed, updating handles", new Object[0]);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getClass();
        int action = motionEvent.getAction();
        if (action == 0) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!hasFocus()) {
                requestFocus();
            }
            this.Q = motionEvent.getX();
            this.R = motionEvent.getY();
            this.S = false;
            this.U.onTouchEvent(motionEvent);
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                float fAbs = Math.abs(motionEvent.getX() - this.Q);
                float fAbs2 = Math.abs(motionEvent.getY() - this.R);
                float f = this.T;
                boolean z = fAbs > f || fAbs2 > f;
                this.U.onTouchEvent(motionEvent);
                if (z) {
                    this.S = true;
                }
                if (this.P && z) {
                    int iA = a(motionEvent.getX(), motionEvent.getY());
                    a(Math.min(this.q.a, iA), Math.max(this.q.a, iA), true);
                    invalidate();
                }
                return true;
            }
            if (action != 3) {
                return this.U.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
            }
        }
        this.U.onTouchEvent(motionEvent);
        if (this.S && !this.P) {
            i();
        }
        if (!this.S) {
            this.P = false;
            super.performClick();
        }
        ViewParent parent2 = getParent();
        if (parent2 != null) {
            parent2.requestDisallowInterceptTouchEvent(false);
        }
        return true;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        onFocusChange(this, z);
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public /* bridge */ void setBold(boolean z) {
        super.setBold(z);
    }

    public final void setEditRecordedListener(at atVar) {
        this.g = atVar;
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public /* bridge */ void setFaceName(String str) {
        super.setFaceName(str);
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public /* bridge */ void setFontColor(int i) {
        super.setFontColor(i);
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public /* bridge */ void setFontSize(float f) {
        super.setFontSize(f);
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public /* bridge */ void setItalic(boolean z) {
        super.setItalic(z);
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public void setLineSpacing(float f) {
        Float f2 = this.b.d.d;
        if (Intrinsics.areEqual(f2, f)) {
            return;
        }
        q00 q00Var = this.q;
        try {
            this.c.a(this.b, Float.valueOf(f));
            try {
                g70 g70Var = this.c.a(this.b, q00Var.a, q00Var.b).a;
                i50 i50Var = this.b;
                i50Var.getClass();
                g70Var.getClass();
                g70 g70Var2 = i50Var.e;
                g70Var2.getClass();
                g70Var2.d = g70Var.d;
                g70Var2.h = g70Var.h;
            } catch (ContentEditingUnavailableException unused) {
                PdfLog.w("ContentEditingTextInputView", "Content editing session unavailable, ignoring selection restore", new Object[0]);
            }
            at atVar = this.g;
            if (atVar != null) {
                atVar.a(new ContentEditingTextBlockLineSpacingEdit(this.a, this.b.c, f2, Float.valueOf(f)));
            }
            this.q = q00Var;
            this.v = true;
            sa saVar = this.f;
            if (saVar != null) {
                saVar.a(this.b, false, true, false);
            }
        } catch (ContentEditingUnavailableException unused2) {
            PdfLog.w("ContentEditingTextInputView", "Content editing session unavailable, ignoring line spacing change", new Object[0]);
        }
    }

    public final void setListener(sa saVar) {
        saVar.getClass();
        this.f = saVar;
    }

    public final void setMagnifierManager(vo voVar) {
        this.j = voVar;
        this.k.k = voVar;
    }

    public final void setSuppressCursorBlink$sdk_nutrient(boolean z) {
        this.J = z;
    }

    @Override // com.pspdfkit.contentediting.ContentEditingFormatter
    public void setTextAlignment(Alignment alignment) {
        alignment.getClass();
        Alignment alignment2 = this.b.d.b;
        PdfLog.d("ContentEditingTextInputView", "setTextAlignment: oldAlignment=" + alignment2 + ", newAlignment=" + alignment, new Object[0]);
        if (alignment2 == alignment) {
            PdfLog.d("ContentEditingTextInputView", "setTextAlignment: alignment unchanged, returning early", new Object[0]);
            return;
        }
        try {
            this.c.a(this.b, alignment);
            PdfLog.d("ContentEditingTextInputView", "setTextAlignment: editor.setAlignment() succeeded", new Object[0]);
            at atVar = this.g;
            if (atVar != null) {
                atVar.a(new ContentEditingTextBlockAlignmentEdit(this.a, this.b.c, alignment2, alignment));
            }
            PdfLog.d("ContentEditingTextInputView", "setTextAlignment: undo recorded", new Object[0]);
            sa saVar = this.f;
            if (saVar != null) {
                saVar.a(this.b, false, true, false);
            }
            PdfLog.d("ContentEditingTextInputView", "setTextAlignment: listener notified", new Object[0]);
        } catch (ContentEditingUnavailableException unused) {
            PdfLog.w("ContentEditingTextInputView", "Content editing session unavailable, ignoring alignment change", new Object[0]);
        }
    }

    public final void setTextBlock$sdk_nutrient(i50 i50Var) {
        i50Var.getClass();
        this.b = i50Var;
    }

    public final float e(int i) {
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += this.e.b(i2).a;
        }
        return f;
    }

    @Override // com.pspdfkit.internal.hn.d
    public final void a(boolean z) {
        PdfLog.d("ContentEditingTextInputView", "onKeyboardVisible: isVisible=" + z, new Object[0]);
        if (z) {
            postDelayed(new Runnable() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i();
                }
            }, 100L);
        }
    }

    public final void b(Canvas canvas) {
        if (this.q.a() && this.I && this.b.e.f.a.size() != 0) {
            int iB = b(this.q.b);
            float fA = a(this.q.b);
            try {
                float f = this.e.b(iB).a;
                float fE = e(iB);
                canvas.drawLine(fA, fE, fA, fE + f, this.M);
                ("drawCursor at offset=" + this.q.b + ", x=" + fA + ", line=" + iB).getClass();
            } catch (ArrayIndexOutOfBoundsException unused) {
                ("Failed to get height metric for cursor at line " + iB).getClass();
            }
        }
    }

    public final void a(i50 i50Var, boolean z) {
        q00 q00Var;
        q00 q00Var2 = this.q;
        int i = q00Var2.a;
        int i2 = q00Var2.b;
        boolean z2 = this.v;
        Alignment alignment = i50Var.d.b;
        StyleInfo styleInfo = this.p;
        PdfLog.d("ContentEditingTextInputView", "onExternalTextBlockChange: ENTRY, current selection=[" + i + ", " + i2 + "], flag=" + z2 + ", skipSelectionRestore=" + z + ", alignment=" + alignment + ", previousStyle=" + (styleInfo != null ? styleInfo.getBold() : null), new Object[0]);
        Job job = this.u;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.u = null;
        if (this.t != null) {
            PdfLog.d("ContentEditingTextInputView", "cancelPendingUndo: discarded pending undo data", new Object[0]);
            this.t = null;
        }
        if (this.r != -1) {
            this.r = -1;
            this.s = -1;
            h();
        }
        this.b = i50Var;
        t50 t50Var = this.e;
        t50Var.getClass();
        t50Var.a = i50Var;
        this.e.c = true;
        String str = (String) i50Var.e.i.getValue();
        if (!Intrinsics.areEqual(str, this.F)) {
            this.E = false;
            this.F = str;
            i();
        }
        if (this.z > 0) {
            invalidate();
            return;
        }
        if (this.v) {
            this.v = false;
        } else if (!z) {
            g70 g70Var = i50Var.e;
            t00 t00Var = g70Var.h;
            if (t00Var != null) {
                q00Var = new q00(i50Var.b(t00Var.a), i50Var.b(t00Var.b));
            } else {
                int iB = i50Var.b(g70Var.d.a);
                q00Var = new q00(iB, iB);
            }
            this.q = q00Var;
        }
        l();
        if (this.x) {
            j();
        }
        f();
        if (hasFocus()) {
            n();
        }
        invalidate();
    }

    public final void c(Canvas canvas) {
        Canvas canvas2;
        float fC;
        float fA;
        if (this.q.a()) {
            return;
        }
        if (this.b.e.f.a.size() == 0) {
            PdfLog.d("ContentEditingTextInputView", "drawSelection: No lines available", new Object[0]);
            return;
        }
        int iB = b(this.q.a);
        int iB2 = b(this.q.b);
        if (iB > iB2) {
            return;
        }
        int i = iB;
        while (true) {
            float fE = e(i);
            try {
                float f = this.e.b(i).a;
                if (i == iB) {
                    fC = a(this.q.a);
                } else {
                    fC = c(i);
                }
                float f2 = fC;
                if (i == iB2) {
                    fA = a(this.q.b);
                } else {
                    int iD = d(i);
                    int iIntValue = ((Number) this.b.c(i).d.getValue()).intValue() + iD;
                    String strC = this.b.c().c();
                    if (iIntValue > 0 && iIntValue <= strC.length()) {
                        int i2 = iIntValue - 1;
                        if (strC.charAt(i2) == '\n') {
                            iIntValue = i2;
                        }
                    }
                    float fC2 = c(i);
                    while (iD < iIntValue) {
                        fC2 += this.e.a(iD);
                        iD++;
                    }
                    fA = fC2;
                }
                PdfLog.d("ContentEditingTextInputView", "  Line " + i + ": lineTop=" + fE + ", startX=" + f2 + ", endX=" + fA + ", lineHeight=" + f, new Object[0]);
                canvas2 = canvas;
                canvas2.drawRect(f2, fE, fA, fE + f, this.N);
            } catch (ArrayIndexOutOfBoundsException e) {
                canvas2 = canvas;
                PdfLog.w("ContentEditingTextInputView", "Failed to get height metric for selection at line " + i, e);
            }
            if (i == iB2) {
                return;
            }
            i++;
            canvas = canvas2;
        }
    }

    public final void d() {
        int i = this.z - 1;
        this.z = i;
        PdfLog.d("ContentEditingTextInputView", "endBatchEdit: depth=" + i + ", pendingUpdate=" + this.A, new Object[0]);
        if (this.z == 0) {
            this.D = false;
            if (this.A) {
                c(this.B, this.C);
                this.A = false;
            }
            PdfLog.d("ContentEditingTextInputView", "endBatchEdit: executing deferred operations (handles + style sync)", new Object[0]);
            try {
                n();
            } catch (Exception e) {
                PdfLog.e("ContentEditingTextInputView", "endBatchEdit: Exception updating handles", e);
            }
            m();
            if (this.x) {
                j();
            }
        }
    }

    public final void b(int i, boolean z) {
        a(i, i, z);
        PdfLog.d("ContentEditingTextInputView", "setCursor: " + this.q.b, new Object[0]);
    }

    public final void b(int i, int i2) {
        if (this.z > 0) {
            this.A = true;
            this.B = i;
            this.C = i2;
            q00 q00Var = this.q;
            PdfLog.d("ContentEditingTextInputView", "notifySelectionChanged: DEFERRED (in batch), old=[" + i + ", " + i2 + "], new=[" + q00Var.a + ", " + q00Var.b + "], composing=[" + this.r + ", " + this.s + "]", new Object[0]);
            return;
        }
        c(i, i2);
    }

    public final int d(int i) {
        if (i == 0) {
            return 0;
        }
        int iIntValue = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iIntValue += ((Number) this.b.c(i2).d.getValue()).intValue();
        }
        return iIntValue;
    }

    public final void b() {
        x60 x60Var = this.t;
        if (x60Var == null) {
            return;
        }
        x60 x60VarA = jb.a(this.b);
        if (x60Var.a != x60VarA.a) {
            a(x60Var, x60VarA);
            PdfLog.d("ContentEditingTextInputView", "commitPendingUndo: recorded undo entry (version " + UInt.m14921toStringimpl(x60Var.a) + " -> " + UInt.m14921toStringimpl(x60VarA.a) + ")", new Object[0]);
        } else {
            PdfLog.d("ContentEditingTextInputView", "commitPendingUndo: skipped undo entry (version unchanged)", new Object[0]);
        }
        this.t = null;
    }

    public final int b(int i) {
        int size = this.b.e.f.a.size();
        int i2 = 0;
        int iIntValue = 0;
        while (true) {
            i50 i50Var = this.b;
            if (i2 < size) {
                iIntValue += ((Number) i50Var.c(i2).d.getValue()).intValue();
                if (i < iIntValue) {
                    return i2;
                }
                i2++;
            } else {
                return RangesKt.coerceAtLeast(i50Var.e.f.a.size() - 1, 0);
            }
        }
    }

    public final void c(int i, int i2) {
        Context context = getContext();
        context.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager == null) {
            return;
        }
        q00 q00Var = this.q;
        inputMethodManager.updateSelection(this, q00Var.a, q00Var.b, this.r, this.s);
        q00 q00Var2 = this.q;
        PdfLog.d("ContentEditingTextInputView", "notifySelectionChanged: SENT, old=[" + i + ", " + i2 + "], new=[" + q00Var2.a + ", " + q00Var2.b + "], composing=[" + this.r + ", " + this.s + "]", new Object[0]);
    }

    public static final List a(Context context) {
        int[] intArray = context.getResources().getIntArray(com.pspdfkit.R.array.pspdf__content_editing_standard_font_sizes);
        intArray.getClass();
        return CollectionsKt.sorted(ArraysKt.toList(intArray));
    }

    public final void a(Canvas canvas) {
        Canvas canvas2;
        float fA;
        float fA2;
        if (this.r == -1 || this.s == -1 || this.b.e.f.a.size() == 0) {
            return;
        }
        ("drawCompositionUnderline: textBlock.lineCount=" + this.b.e.f.a.size() + ", text='" + this.b.c().c() + "'").getClass();
        int iB = b(this.r);
        int iB2 = b(this.s);
        ("drawCompositionUnderline: composing=[" + this.r + ", " + this.s + "], startLine=" + iB + ", endLine=" + iB2).getClass();
        if (iB <= iB2) {
            int i = iB;
            while (true) {
                float fE = e(i);
                try {
                    float f = this.e.b(i).a;
                    if (i == iB) {
                        fA = a(this.r);
                    } else {
                        fA = a(d(i));
                    }
                    float f2 = fA;
                    if (i == iB2) {
                        fA2 = a(this.s);
                    } else {
                        int iD = d(i);
                        int iIntValue = ((Number) this.b.c(i).d.getValue()).intValue() + iD;
                        String strC = this.b.c().c();
                        if (iIntValue > 0 && iIntValue <= strC.length()) {
                            int i2 = iIntValue - 1;
                            if (strC.charAt(i2) == '\n') {
                                iIntValue = i2;
                            }
                        }
                        float fC = c(i);
                        while (iD < iIntValue) {
                            fC += this.e.a(iD);
                            iD++;
                        }
                        fA2 = fC;
                    }
                    float f3 = fE + f;
                    ("drawCompositionUnderline: line=" + i + ", lineTop=" + fE + ", lineHeight=" + f + ", underlineY=" + f3 + ", startX=" + f2 + ", endX=" + fA2 + ", viewHeight=" + getHeight() + ", canvasHeight=" + canvas.getHeight()).getClass();
                    canvas2 = canvas;
                    canvas2.drawLine(f2, f3, fA2, f3, getCompositionUnderlinePaint());
                } catch (ArrayIndexOutOfBoundsException e) {
                    canvas2 = canvas;
                    PdfLog.w("ContentEditingTextInputView", "Failed to get height metric for composition underline at line " + i, e);
                }
                if (i == iB2) {
                    break;
                }
                i++;
                canvas = canvas2;
            }
        }
        ("drawCompositionUnderline from=" + this.r + " to=" + this.s).getClass();
    }

    public final void a(boolean z, boolean z2) {
        this.w = z;
        this.x = z2;
        PdfLog.d("ContentEditingTextInputView", "setImeWantsCursorUpdates: immediate=" + z + ", monitor=" + z2, new Object[0]);
    }

    public final void a(int i, boolean z) {
        this.y = Integer.valueOf(i);
        if (z) {
            ActionMode actionMode = this.V;
            if (actionMode != null) {
                actionMode.finish();
            }
            this.V = null;
            s00 s00Var = this.k;
            s00Var.a();
            s00Var.b();
            PdfLog.d("ContentEditingTextInputView", "onExtractedTextRequested: extract mode active, token=" + i, new Object[0]);
        }
    }

    public final void a(int i, int i2, boolean z) {
        q00 q00Var = this.q;
        this.q = new q00(RangesKt.coerceIn(i, 0, ((String) this.b.e.i.getValue()).length()), RangesKt.coerceIn(i2, 0, ((String) this.b.e.i.getValue()).length()));
        this.k.j = false;
        if (!q00Var.a() && this.q.a()) {
            if (this.E && !this.J) {
                postDelayed(new Runnable() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        gb.setSelection$lambda$0(this.f$0);
                    }
                }, 150L);
            } else if (!this.J) {
                e();
            }
        } else if (this.q.a() && this.E && hasFocus() && !this.J) {
            postDelayed(new Runnable() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    gb.setSelection$lambda$1(this.f$0);
                }
            }, 150L);
        }
        if (!this.D && this.z == 0) {
            this.r = -1;
            this.s = -1;
        }
        b(q00Var.a, q00Var.b);
        if (hasFocus() && !this.J) {
            this.I = true;
            this.K.removeCallbacks(this.L);
            this.K.postDelayed(this.L, 500L);
        }
        if (this.x && this.z == 0) {
            j();
        }
        if (this.z > 0) {
            if (z) {
                invalidate();
                return;
            }
            return;
        }
        try {
            n();
        } catch (Exception e) {
            PdfLog.e("ContentEditingTextInputView", "setSelection: Exception calling updateHandles()", e);
        }
        m();
        if (z) {
            invalidate();
        }
    }

    public final void a() {
        int i = this.z + 1;
        this.z = i;
        this.D = true;
        PdfLog.d("ContentEditingTextInputView", "beginBatchEdit: depth=" + i + ", imeIsCommitting=true", new Object[0]);
    }

    public final <T> T a(i50 i50Var, Function0<? extends T> function0) {
        LifecycleCoroutineScope lifecycleScope;
        if (this.t == null) {
            this.t = jb.a(i50Var);
            PdfLog.d("ContentEditingTextInputView", "executeAndRecord: captured start state for pending undo", new Object[0]);
        }
        Job jobLaunch$default = null;
        try {
            T tInvoke = function0.invoke();
            Job job = this.u;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
            if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new hb(this, null), 3, null);
            }
            this.u = jobLaunch$default;
            return tInvoke;
        } catch (ContentEditingUnavailableException unused) {
            PdfLog.w("ContentEditingTextInputView", "Content editing session unavailable, ignoring native editor command", new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(final int i, final String str) {
        str.getClass();
        PdfLog.d("ContentEditingTextInputView", "insertText: position=" + i + ", text='" + str + "'", new Object[0]);
        ya yaVar = (ya) a(this.b, new Function0() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return gb.a(this.f$0, str, i);
            }
        });
        if (yaVar == null) {
            return 0;
        }
        int iB = this.b.b(((g70) yaVar.a).d.a);
        this.E = false;
        this.e.c = true;
        l();
        invalidate();
        sa saVar = this.f;
        if (saVar != null) {
            saVar.a(this.b, true, true, false);
        }
        f();
        PdfLog.d("ContentEditingTextInputView", "insertText: calling scrollToTextBlock()", new Object[0]);
        i();
        return iB;
    }

    public static final ya a(gb gbVar, String str, int i) {
        return gbVar.c.a(gbVar.b, str, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(final int i, final int i2, final String str) {
        str.getClass();
        PdfLog.d("ContentEditingTextInputView", "replaceText: [" + i + ", " + i2 + "], text='" + str + "'", new Object[0]);
        ViewTreeLifecycleOwner.get(this);
        ya yaVar = (ya) a(this.b, new Function0() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return gb.a(this.f$0, str, i, i2);
            }
        });
        if (yaVar == null) {
            return 0;
        }
        int iB = this.b.b(((g70) yaVar.a).d.a);
        this.E = false;
        this.e.c = true;
        l();
        invalidate();
        sa saVar = this.f;
        if (saVar != null) {
            saVar.a(this.b, true, true, false);
        }
        f();
        PdfLog.d("ContentEditingTextInputView", "replaceText: calling scrollToTextBlock()", new Object[0]);
        i();
        return iB;
    }

    public static final ya a(gb gbVar, String str, int i, int i2) {
        return gbVar.c.a(gbVar.b, str, i, i2);
    }

    public final void a(final int i, final int i2) {
        PdfLog.d("ContentEditingTextInputView", "deleteText: [" + i + ", " + i2 + "]", new Object[0]);
        if (((ya) a(this.b, new Function0() { // from class: com.pspdfkit.internal.gb$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return gb.a(this.f$0, i, i2);
            }
        })) == null) {
            return;
        }
        this.E = false;
        this.e.c = true;
        l();
        invalidate();
        sa saVar = this.f;
        if (saVar != null) {
            saVar.a(this.b, true, true, false);
        }
        f();
        PdfLog.d("ContentEditingTextInputView", "deleteText: calling scrollToTextBlock()", new Object[0]);
        i();
    }

    public static final ya a(gb gbVar, int i, int i2) {
        return gbVar.c.b(gbVar.b, i, i2);
    }

    public final void a(x60 x60Var, x60 x60Var2) {
        int i = this.a;
        i50 i50Var = this.b;
        ContentEditingNativeChangeEdit contentEditingNativeChangeEdit = new ContentEditingNativeChangeEdit(i, i50Var.c, x60Var, x60Var2, i50Var.e(), null, 32, null);
        at atVar = this.g;
        if (atVar != null) {
            atVar.a(contentEditingNativeChangeEdit);
        }
        PdfLog.d("ContentEditingTextInputView", "recordEdit: undo version=" + UInt.m14921toStringimpl(x60Var.a) + ", redo version=" + UInt.m14921toStringimpl(x60Var2.a), new Object[0]);
    }

    public final void a(int i, float f, float f2) {
        Pair<Integer, Integer> pairA = a(i, Float.valueOf(f), Float.valueOf(f2));
        if (pairA != null) {
            int iIntValue = pairA.component1().intValue();
            int iIntValue2 = pairA.component2().intValue();
            a(iIntValue, iIntValue2, true);
            invalidate();
            PdfLog.d("ContentEditingTextInputView", "selectWordAt: offset=" + i + ", selected=[" + iIntValue + ", " + iIntValue2 + "], text='" + ((String) this.b.e.i.getValue()).substring(iIntValue, iIntValue2) + "'", new Object[0]);
            return;
        }
        PdfLog.d("ContentEditingTextInputView", "selectWordAt: no word found at offset=" + i + " (clicked in empty space)", new Object[0]);
    }

    public final Pair<Integer, Integer> a(int i, Float f, Float f2) {
        Object obj;
        d dVar;
        Object objPrevious;
        if (this.b.e.f.a.size() == 0 || ((String) this.b.e.i.getValue()).length() == 0) {
            return null;
        }
        try {
            int iC = this.e.c(i);
            ArrayList arrayList = new ArrayList();
            int iMax = Math.max(0, iC - 1);
            int iMin = Math.min(this.b.e.f.a.size() - 1, iC + 1);
            int iD = d(iMax);
            if (iMax <= iMin) {
                int i2 = iMax;
                while (true) {
                    int i3 = 0;
                    int i4 = iD;
                    for (uf ufVar : this.b.c(i2).a) {
                        int length = i4 + ufVar.d.length();
                        arrayList.add(new d(ufVar, i2, i3, i4, length));
                        i3++;
                        i4 = length;
                    }
                    if (i2 == iMin) {
                        break;
                    }
                    i2++;
                    iD = i4;
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i5);
                i5++;
                d dVar2 = (d) obj;
                if (i >= dVar2.d && i < dVar2.e) {
                    break;
                }
            }
            d dVar3 = (d) obj;
            if (dVar3 == null) {
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                do {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                } while (i < ((d) objPrevious).e);
                dVar3 = (d) objPrevious;
            }
            if (dVar3 == null) {
                PdfLog.w("ContentEditingTextInputView", "getWordBoundariesAt: no element found at offset=" + i, new Object[0]);
                return null;
            }
            int iD2 = d(iC);
            int iIntValue = ((Number) this.b.c(iC).d.getValue()).intValue() + iD2;
            String str = (String) this.b.e.i.getValue();
            if (iIntValue > 0 && iIntValue <= str.length()) {
                int i6 = iIntValue - 1;
                if (str.charAt(i6) == '\n') {
                    iIntValue = i6;
                }
            }
            float fC = c(iC);
            float fA = fC;
            while (iD2 < iIntValue) {
                fA += this.e.a(iD2);
                iD2++;
            }
            PdfLog.d("ContentEditingTextInputView", "getWordBoundariesAt: empty space check - clickX=" + f + ", lineStartX=" + fC + ", lineEndX=" + fA + ", visualLineEnd=" + iIntValue, new Object[0]);
            if (f.floatValue() < fC - 5.0f) {
                PdfLog.d("ContentEditingTextInputView", "getWordBoundariesAt: clicked in empty space before text (clickX=" + f + ", lineStartX=" + fC + ", line=" + iC + ") - no word to select", new Object[0]);
                return null;
            }
            if (f.floatValue() > 5.0f + fA) {
                PdfLog.d("ContentEditingTextInputView", "getWordBoundariesAt: clicked in empty space beyond text (clickX=" + f + ", lineEndX=" + fA + ", line=" + iC + ") - no word to select", new Object[0]);
                return null;
            }
            int i7 = dVar3.e;
            if (i >= i7) {
                PdfLog.d("ContentEditingTextInputView", "getWordBoundariesAt: offset in empty space after text (offset=" + i + ", textEnd=" + i7 + ") - no word to select", new Object[0]);
                return null;
            }
            if (dVar3.a.f) {
                dVar = dVar3;
            } else {
                dVar = dVar3;
                for (int iIndexOf = arrayList.indexOf(dVar3) - 1; -1 < iIndexOf; iIndexOf--) {
                    dVar = (d) arrayList.get(iIndexOf);
                    if (dVar.a.f) {
                        break;
                    }
                }
            }
            if (!dVar3.a.g) {
                int size2 = arrayList.size();
                for (int iIndexOf2 = arrayList.indexOf(dVar3) + 1; iIndexOf2 < size2; iIndexOf2++) {
                    dVar3 = (d) arrayList.get(iIndexOf2);
                    if (dVar3.a.g) {
                        break;
                    }
                }
            }
            int i8 = dVar.d;
            int i9 = dVar3.e;
            String str2 = (String) this.b.e.i.getValue();
            while (i9 > i8 && i9 <= str2.length() && CharsKt.isWhitespace(str2.charAt(i9 - 1))) {
                i9--;
            }
            if (i8 < i9) {
                return new Pair<>(Integer.valueOf(i8), Integer.valueOf(i9));
            }
            return null;
        } catch (Exception e) {
            PdfLog.w("ContentEditingTextInputView", "getWordBoundariesAt: failed to get line index for offset=" + i, e);
            return null;
        }
    }

    public final void c() {
        if (this.q.a()) {
            return;
        }
        String strC = this.b.c().c();
        q00 q00Var = this.q;
        String strSubstring = strC.substring(q00Var.a, q00Var.b);
        String strReplace$default = StringsKt.replace$default(strSubstring, "\n", "", false, 4, (Object) null);
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            MAMClipboard.setPrimaryClip(clipboardManager, ClipData.newPlainText("text", strReplace$default));
        }
        this.E = true;
        String strReplace$default2 = StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\n", "\\n", false, 4, (Object) null), " ", "·", false, 4, (Object) null);
        String strReplace$default3 = StringsKt.replace$default(strReplace$default, " ", "·", false, 4, (Object) null);
        q00 q00Var2 = this.q;
        PdfLog.d("ContentEditingTextInputView", "copySelection: range=[" + q00Var2.a + ", " + q00Var2.b + "], raw='" + strReplace$default2 + "', filtered='" + strReplace$default3 + "', paste menu enabled", new Object[0]);
    }

    public final float c(int i) {
        i50 i50Var = this.b;
        Alignment alignment = i50Var.d.b;
        if (alignment == Alignment.BEGIN || alignment == Alignment.JUSTIFIED) {
            return 0.0f;
        }
        return (i50Var.c(i).c.a - this.b.e.c.a.a) * this.d;
    }

    public final boolean f(int i) {
        if (i >= 0 && i < this.b.e.f.a.size()) {
            Rect rect = new Rect();
            if (!getLocalVisibleRect(rect)) {
                return false;
            }
            float fE = e(i);
            try {
                if (this.e.b(i).a + fE > rect.top && fE < rect.bottom) {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return false;
    }

    public final int a(float f, float f2) {
        if (this.b.e.f.a.size() == 0) {
            PdfLog.d("ContentEditingTextInputView", "getOffsetForPosition: no lines, returning 0", new Object[0]);
            return 0;
        }
        if (this.e.c) {
            PdfLog.w("ContentEditingTextInputView", "getOffsetForPosition: TextMetrics is dirty, forcing refresh", new Object[0]);
            this.e.b();
        }
        int size = this.b.e.f.a.size();
        float f3 = 0.0f;
        int iCoerceAtLeast = 0;
        int i = 0;
        float f4 = 0.0f;
        while (true) {
            if (iCoerceAtLeast >= size) {
                iCoerceAtLeast = i;
                break;
            }
            try {
                float f5 = this.e.b(iCoerceAtLeast).a;
                if (f2 >= f4 && f2 < f4 + f5) {
                    break;
                }
                f4 += f5;
                if (iCoerceAtLeast == this.b.e.f.a.size() - 1) {
                    i = iCoerceAtLeast;
                }
                iCoerceAtLeast++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                PdfLog.w("ContentEditingTextInputView", "getOffsetForPosition: line " + iCoerceAtLeast + " out of bounds in TextMetrics, using last line", new Object[0]);
                iCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(iCoerceAtLeast - 1, 0), 0);
            }
        }
        int iD = d(iCoerceAtLeast);
        int iIntValue = ((Number) this.b.c(iCoerceAtLeast).d.getValue()).intValue();
        float fC = f - c(iCoerceAtLeast);
        int i2 = 0;
        while (i2 < iIntValue) {
            try {
                int i3 = iD + i2;
                float fA = this.e.a(i3);
                int i4 = iD;
                if (fC < (fA / 2) + f3) {
                    PdfLog.d("ContentEditingTextInputView", "getOffsetForPosition: x=" + f + " (adjusted=" + fC + "), y=" + f2 + " -> line=" + iCoerceAtLeast + ", offset=" + i3 + " (before char " + i2 + ")", new Object[0]);
                    return i3;
                }
                f3 += fA;
                i2++;
                iD = i4;
            } catch (ArrayIndexOutOfBoundsException unused2) {
                int i5 = iD;
                PdfLog.w("ContentEditingTextInputView", "getOffsetForPosition: charIndex " + (i5 + i2) + " out of bounds in widths, returning line start", new Object[0]);
                return i5;
            }
        }
        int i6 = iD + iIntValue;
        int i7 = (iCoerceAtLeast == this.b.e.f.a.size() + (-1) || iIntValue == 0) ? i6 : i6 - 1;
        PdfLog.d("ContentEditingTextInputView", "getOffsetForPosition: x=" + f + ", y=" + f2 + " -> line=" + iCoerceAtLeast + ", offset=" + i7 + " (END OF LINE, charX=" + f3 + ", lineEnd=" + i6 + ")", new Object[0]);
        return i7;
    }

    public final float a(int i) {
        int iB = b(i);
        float fC = c(iB);
        for (int iD = d(iB); iD < i; iD++) {
            fC += this.e.a(iD);
        }
        return fC;
    }

    public final void a(int[] iArr) {
        int[] iArr2 = new int[2];
        getLocationInWindow(iArr2);
        iArr[0] = iArr[0] + iArr2[0];
        iArr[1] = iArr[1] + iArr2[1];
    }
}
