package com.pspdfkit.internal;

import android.os.Handler;
import android.os.Trace;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.TextAttribute;
import com.pspdfkit.utils.PdfLog;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class pa extends BaseInputConnection {
    public final gb a;

    public pa(gb gbVar, EditorInfo editorInfo) {
        super(gbVar, false);
        this.a = gbVar;
    }

    public static final void a(pa paVar) {
        paVar.a.h();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        Trace.beginSection("IC.beginBatchEdit");
        try {
            PdfLog.d("ContentEditingInputConnection", "beginBatchEdit", new Object[0]);
            this.a.a();
            return super.beginBatchEdit();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final void closeConnection() {
        PdfLog.d("ContentEditingInputConnection", "closeConnection", new Object[0]);
        super.closeConnection();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        PdfLog.d("ContentEditingInputConnection", "commitCorrection: " + correctionInfo, new Object[0]);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        int iA;
        PdfLog.d("ContentEditingInputConnection", "commitText: text='" + ((Object) charSequence) + "', newCursorPosition=" + i + ", composing=[" + this.a.getComposingStart() + ", " + this.a.getComposingEnd() + "]", new Object[0]);
        if (charSequence == null || charSequence.length() == 0) {
            charSequence = null;
        }
        if (charSequence == null) {
            return true;
        }
        String strC = this.a.getTextBlock().c().c();
        PdfLog.d("ContentEditingInputConnection", "commitText: oldText='" + StringsKt.replace$default(strC, "\n", "\\n", false, 4, (Object) null) + "' (length=" + strC.length() + ")", new Object[0]);
        int composingStart = this.a.getComposingStart();
        gb gbVar = this.a;
        if (composingStart != -1) {
            int composingStart2 = gbVar.getComposingStart();
            int composingEnd = this.a.getComposingEnd();
            PdfLog.d("ContentEditingInputConnection", "commitText: replacing composing text [" + composingStart2 + ", " + composingEnd + "]='" + strC.substring(RangesKt.coerceIn(composingStart2, 0, strC.length()), RangesKt.coerceIn(composingEnd, 0, strC.length())) + "' with '" + ((Object) charSequence) + "'", new Object[0]);
            iA = this.a.a(composingStart2, composingEnd, charSequence.toString());
            this.a.d(-1, -1);
        } else {
            int selectionStart = gbVar.getSelectionStart();
            int selectionEnd = this.a.getSelectionEnd();
            gb gbVar2 = this.a;
            if (selectionStart != selectionEnd) {
                int selectionStart2 = gbVar2.getSelectionStart();
                int selectionEnd2 = this.a.getSelectionEnd();
                PdfLog.d("ContentEditingInputConnection", "commitText: replacing selection [" + selectionStart2 + ", " + selectionEnd2 + "] with '" + ((Object) charSequence) + "'", new Object[0]);
                iA = this.a.a(selectionStart2, selectionEnd2, charSequence.toString());
                this.a.e();
            } else {
                int cursor = gbVar2.getCursor();
                PdfLog.d("ContentEditingInputConnection", "commitText: inserting '" + ((Object) charSequence) + "' at cursor=" + cursor, new Object[0]);
                iA = this.a.a(cursor, charSequence.toString());
            }
        }
        String strC2 = this.a.getTextBlock().c().c();
        PdfLog.d("ContentEditingInputConnection", "commitText: newText='" + StringsKt.replace$default(strC2, "\n", "\\n", false, 4, (Object) null) + "' (length=" + strC2.length() + "), newCursor=" + iA, new Object[0]);
        this.a.b(iA, false);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        PdfLog.d("ContentEditingInputConnection", "deleteSurroundingText: before=" + i + ", after=" + i2, new Object[0]);
        int cursor = this.a.getCursor();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(cursor - i, 0);
        int iCoerceAtMost = RangesKt.coerceAtMost(cursor + i2, ((String) this.a.getTextBlock().e.i.getValue()).length());
        if (iCoerceAtLeast < iCoerceAtMost) {
            this.a.a(iCoerceAtLeast, iCoerceAtMost);
        }
        this.a.b(iCoerceAtLeast, true);
        this.a.invalidate();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        PdfLog.d("ContentEditingInputConnection", "deleteSurroundingTextInCodePoints: before=" + i + ", after=" + i2, new Object[0]);
        return super.deleteSurroundingTextInCodePoints(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        Trace.beginSection("IC.endBatchEdit");
        try {
            PdfLog.d("ContentEditingInputConnection", "endBatchEdit", new Object[0]);
            this.a.d();
            return super.endBatchEdit();
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        int composingStart = this.a.getComposingStart();
        PdfLog.d("ContentEditingInputConnection", "finishComposingText: was composing=[" + composingStart + ", " + this.a.getComposingEnd() + "]", new Object[0]);
        if (composingStart == -1) {
            return true;
        }
        this.a.d(-1, -1);
        this.a.post(new Runnable() { // from class: com.pspdfkit.internal.pa$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                pa.a(this.f$0);
            }
        });
        this.a.invalidate();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int i) {
        String strC = this.a.getTextBlock().c().c();
        int capsMode = TextUtils.getCapsMode(strC, RangesKt.coerceIn(this.a.getCursor(), 0, strC.length()), i);
        PdfLog.d("ContentEditingInputConnection", "getCursorCapsMode: reqModes=" + i + ", result=" + capsMode, new Object[0]);
        return capsMode;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        String str = (String) this.a.getTextBlock().e.i.getValue();
        int iCoerceIn = RangesKt.coerceIn(this.a.getSelectionStart(), 0, str.length());
        int iCoerceIn2 = RangesKt.coerceIn(this.a.getSelectionEnd(), 0, str.length());
        if (extractedTextRequest != null) {
            this.a.a(extractedTextRequest.token, (i & 1) != 0);
        }
        PdfLog.d("ContentEditingInputConnection", "getExtractedText: textLength=" + str.length(), new Object[0]);
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = str;
        extractedText.selectionStart = iCoerceIn;
        extractedText.selectionEnd = iCoerceIn2;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.flags = 0;
        return extractedText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int i) {
        String strC = this.a.getTextBlock().c().c();
        int iCoerceIn = RangesKt.coerceIn(this.a.getSelectionStart(), 0, strC.length());
        int iCoerceIn2 = RangesKt.coerceIn(this.a.getSelectionEnd(), 0, strC.length());
        if (iCoerceIn == iCoerceIn2) {
            PdfLog.d("ContentEditingInputConnection", "getSelectedText: no selection", new Object[0]);
            return null;
        }
        String strSubstring = strC.substring(iCoerceIn, iCoerceIn2);
        PdfLog.d("ContentEditingInputConnection", "getSelectedText: selection=[" + iCoerceIn + ", " + iCoerceIn2 + "], result='" + strSubstring + "'", new Object[0]);
        return strSubstring;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int i, int i2) {
        String strC = this.a.getTextBlock().c().c();
        int iCoerceIn = RangesKt.coerceIn(this.a.getCursor(), 0, strC.length());
        String strSubstring = strC.substring(iCoerceIn, RangesKt.coerceAtMost(iCoerceIn + i, strC.length()));
        PdfLog.d("ContentEditingInputConnection", "getTextAfterCursor: n=" + i + ", result='" + StringsKt.replace$default(strSubstring, "\n", "\\n", false, 4, (Object) null) + "'", new Object[0]);
        return strSubstring;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int i, int i2) {
        Trace.beginSection("IC.getTextBeforeCursor");
        try {
            String strC = this.a.getTextBlock().c().c();
            int iCoerceIn = RangesKt.coerceIn(this.a.getCursor(), 0, strC.length());
            String strSubstring = strC.substring(RangesKt.coerceAtLeast(iCoerceIn - i, 0), iCoerceIn);
            PdfLog.d("ContentEditingInputConnection", "getTextBeforeCursor: n=" + i + ", result='" + StringsKt.replace$default(strSubstring, "\n", "\\n", false, 4, (Object) null) + "'", new Object[0]);
            return strSubstring;
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i) {
        PdfLog.d("ContentEditingInputConnection", "performEditorAction: actionCode=" + i, new Object[0]);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean replaceText(int i, int i2, CharSequence charSequence, int i3, TextAttribute textAttribute) {
        charSequence.getClass();
        Trace.beginSection("IC.replaceText");
        try {
            PdfLog.d("ContentEditingInputConnection", "replaceText: start=" + i + ", end=" + i2 + ", text='" + ((Object) charSequence) + "', newCursorPosition=" + i3, new Object[0]);
            if (charSequence.length() == 0 && i == i2) {
                return true;
            }
            String strC = this.a.getTextBlock().c().c();
            PdfLog.d("ContentEditingInputConnection", "replaceText: oldText='" + StringsKt.replace$default(strC, "\n", "\\n", false, 4, (Object) null) + "' (length=" + strC.length() + ")", new Object[0]);
            int iCoerceIn = RangesKt.coerceIn(i, 0, strC.length());
            int iCoerceIn2 = RangesKt.coerceIn(i2, 0, strC.length());
            PdfLog.d("ContentEditingInputConnection", "replaceText: replacing [" + iCoerceIn + ", " + iCoerceIn2 + "]='" + strC.substring(iCoerceIn, iCoerceIn2) + "' with '" + ((Object) charSequence) + "'", new Object[0]);
            int iA = this.a.a(iCoerceIn, iCoerceIn2, charSequence.toString());
            String strC2 = this.a.getTextBlock().c().c();
            PdfLog.d("ContentEditingInputConnection", "replaceText: newText='" + StringsKt.replace$default(strC2, "\n", "\\n", false, 4, (Object) null) + "' (length=" + strC2.length() + "), cursorAfterReplace=" + iA, new Object[0]);
            this.a.d(-1, -1);
            if (i3 > 0) {
                iA = (iA + i3) - 1;
            } else if (i3 < 0) {
                iA = iCoerceIn + charSequence.length() + i3;
            }
            PdfLog.d("ContentEditingInputConnection", "replaceText: setting cursor to " + iA, new Object[0]);
            this.a.b(iA, false);
            return true;
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) != 0;
        PdfLog.d("ContentEditingInputConnection", "requestCursorUpdates: immediate=" + z + ", monitor=" + z2, new Object[0]);
        this.a.a(z, z2);
        if (z) {
            this.a.j();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        PdfLog.d("ContentEditingInputConnection", "sendKeyEvent: " + keyEvent, new Object[0]);
        if (keyEvent != null && keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 122 && keyCode != 123) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (this.a.getComposingStart() != -1) {
                            PdfLog.d("ContentEditingInputConnection", "sendKeyEvent: finishing composition before cursor navigation", new Object[0]);
                            finishComposingText();
                        }
                        break;
                }
            } else if (this.a.getComposingStart() != -1) {
                PdfLog.d("ContentEditingInputConnection", "sendKeyEvent: finishing composition before cursor navigation", new Object[0]);
                finishComposingText();
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int i, int i2) {
        Trace.beginSection("IC.setComposingRegion");
        try {
            if (i < 0 || i2 < 0 || i > i2) {
                PdfLog.w("ContentEditingInputConnection", "setComposingRegion: invalid indices [" + i + ", " + i2 + "], ignoring", new Object[0]);
                Trace.endSection();
                return false;
            }
            String strC = this.a.getTextBlock().c().c();
            int iCoerceIn = RangesKt.coerceIn(i, 0, strC.length());
            int iCoerceIn2 = RangesKt.coerceIn(i2, 0, strC.length());
            PdfLog.d("ContentEditingInputConnection", "setComposingRegion: [" + i + ", " + i2 + "] → clamped [" + iCoerceIn + ", " + iCoerceIn2 + "]", new Object[0]);
            this.a.d(iCoerceIn, iCoerceIn2);
            Trace.endSection();
            return true;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        int i2;
        int i3;
        int iA;
        int i4;
        PdfLog.d("ContentEditingInputConnection", "setComposingText: text='" + ((Object) charSequence) + "', newCursorPosition=" + i + ", composing=[" + this.a.getComposingStart() + ", " + this.a.getComposingEnd() + "]", new Object[0]);
        if (charSequence == null) {
            finishComposingText();
            return true;
        }
        int composingStart = this.a.getComposingStart();
        if (charSequence.length() == 0 && composingStart == -1) {
            finishComposingText();
            return true;
        }
        int cursor = this.a.getCursor();
        int composingEnd = this.a.getComposingEnd();
        int selectionStart = this.a.getSelectionStart();
        int selectionEnd = this.a.getSelectionEnd();
        boolean z = selectionStart != selectionEnd;
        PdfLog.d("ContentEditingInputConnection", "setComposingText BEFORE: cursor=" + cursor + ", compStart=" + composingStart + ", compEnd=" + composingEnd + ", selection=[" + selectionStart + ", " + selectionEnd + "], hasSelection=" + z, new Object[0]);
        String str = (String) this.a.getTextBlock().e.i.getValue();
        if (composingStart != -1) {
            i2 = composingStart;
            i3 = composingEnd;
        } else if (z) {
            i2 = selectionStart;
            i3 = selectionEnd;
        } else {
            i3 = cursor;
            i2 = i3;
        }
        PdfLog.d("ContentEditingInputConnection", "setComposingText: modifying [" + i2 + ", " + i3 + "] in old text (length=" + str.length() + ")", new Object[0]);
        if (i2 < 0 || i3 < 0 || i2 > i3 || i2 > str.length() || i3 > str.length()) {
            PdfLog.e("ContentEditingInputConnection", "setComposingText: INVALID modification range [" + i2 + ", " + i3 + "] for text length " + str.length() + "! Clearing composing and aborting.", new Object[0]);
            this.a.d(-1, -1);
            return false;
        }
        gb gbVar = this.a;
        if (composingStart != -1) {
            iA = gbVar.a(composingStart, composingEnd, charSequence.toString());
        } else if (z) {
            gbVar.e();
            iA = this.a.a(selectionStart, selectionEnd, charSequence.toString());
        } else {
            iA = gbVar.a(cursor, charSequence.toString());
        }
        String str2 = (String) this.a.getTextBlock().e.i.getValue();
        PdfLog.d("ContentEditingInputConnection", "setComposingText: oldText length=" + str.length() + ", newText length=" + str2.length() + ", cursor=" + iA, new Object[0]);
        int length = charSequence.length() + i2;
        if (i > 0) {
            i4 = (length + i) - 1;
        } else {
            i4 = i < 0 ? i2 + i : length;
        }
        int iCoerceIn = RangesKt.coerceIn(i4, 0, str2.length());
        gb gbVar2 = this.a;
        int iCoerceIn2 = RangesKt.coerceIn(iCoerceIn, 0, ((String) gbVar2.b.e.i.getValue()).length());
        gbVar2.q = new q00(iCoerceIn2, iCoerceIn2);
        if (charSequence.length() == 0 && composingStart != -1) {
            length = i2;
        }
        this.a.d(i2, length);
        PdfLog.d("ContentEditingInputConnection", "setComposingText: setting composing region [" + i2 + ", " + length + "]", new Object[0]);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        PdfLog.d("ContentEditingInputConnection", "setSelection: start=" + i + ", end=" + i2, new Object[0]);
        this.a.a(i, i2, true);
        this.a.invalidate();
        return true;
    }
}
