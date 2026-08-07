package com.pspdfkit.internal.jni;

import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.datastructures.Range;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeTextParser {

    public static final class CppProxy extends NativeTextParser {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        private native int native_charIndexAt(long j, PointF pointF, float f);

        private native int native_charIndexToTextIndex(long j, int i);

        private native int native_count(long j);

        private native NativeParagraphResult native_getParagraphs(long j);

        private native String native_getTextForRanges(long j, ArrayList<Range> arrayList);

        private native String native_getTextForRect(long j, RectF rectF);

        private native String native_getTextForRects(long j, ArrayList<RectF> arrayList);

        private native ArrayList<NativeExtractedLink> native_links(long j);

        private native String native_text(long j);

        private native String native_textForRange(long j, int i, int i2);

        private native int native_textIndexToCharIndex(long j, int i);

        private native ArrayList<NativeTextBlock> native_textLines(long j, NativeTextLinesTrimWhitespace nativeTextLinesTrimWhitespace);

        private native NativeRectDescriptor native_textRectAt(long j, PointF pointF, float f);

        private native NativeTextRange native_textRects(long j);

        private native NativeTextRange native_textRectsBetweenPoints(long j, PointF pointF, PointF pointF2);

        private native ArrayList<NativeRectDescriptor> native_textRectsBoundedByRect(long j, RectF rectF, boolean z, boolean z2, boolean z3);

        private native NativeTextRange native_textRectsForRange(long j, int i, int i2);

        private native NativeTextRange native_wordAt(long j, PointF pointF);

        private native ArrayList<NativeTextRange> native_wordsAt(long j, PointF pointF, float f);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public int charIndexAt(PointF pointF, float f) {
            return native_charIndexAt(this.nativeRef, pointF, f);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public int charIndexToTextIndex(int i) {
            return native_charIndexToTextIndex(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public int count() {
            return native_count(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public NativeParagraphResult getParagraphs() {
            return native_getParagraphs(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public String getTextForRanges(ArrayList<Range> arrayList) {
            return native_getTextForRanges(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public String getTextForRect(RectF rectF) {
            return native_getTextForRect(this.nativeRef, rectF);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public String getTextForRects(ArrayList<RectF> arrayList) {
            return native_getTextForRects(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public ArrayList<NativeExtractedLink> links() {
            return native_links(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public String text() {
            return native_text(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public String textForRange(int i, int i2) {
            return native_textForRange(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public int textIndexToCharIndex(int i) {
            return native_textIndexToCharIndex(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public ArrayList<NativeTextBlock> textLines(NativeTextLinesTrimWhitespace nativeTextLinesTrimWhitespace) {
            return native_textLines(this.nativeRef, nativeTextLinesTrimWhitespace);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public NativeRectDescriptor textRectAt(PointF pointF, float f) {
            return native_textRectAt(this.nativeRef, pointF, f);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public NativeTextRange textRects() {
            return native_textRects(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public NativeTextRange textRectsBetweenPoints(PointF pointF, PointF pointF2) {
            return native_textRectsBetweenPoints(this.nativeRef, pointF, pointF2);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public ArrayList<NativeRectDescriptor> textRectsBoundedByRect(RectF rectF, boolean z, boolean z2, boolean z3) {
            return native_textRectsBoundedByRect(this.nativeRef, rectF, z, z2, z3);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public NativeTextRange textRectsForRange(int i, int i2) {
            return native_textRectsForRange(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public NativeTextRange wordAt(PointF pointF) {
            return native_wordAt(this.nativeRef, pointF);
        }

        @Override // com.pspdfkit.internal.jni.NativeTextParser
        public ArrayList<NativeTextRange> wordsAt(PointF pointF, float f) {
            return native_wordsAt(this.nativeRef, pointF, f);
        }
    }

    public abstract int charIndexAt(PointF pointF, float f);

    public abstract int charIndexToTextIndex(int i);

    public abstract int count();

    public abstract NativeParagraphResult getParagraphs();

    public abstract String getTextForRanges(ArrayList<Range> arrayList);

    public abstract String getTextForRect(RectF rectF);

    public abstract String getTextForRects(ArrayList<RectF> arrayList);

    public abstract ArrayList<NativeExtractedLink> links();

    public abstract String text();

    public abstract String textForRange(int i, int i2);

    public abstract int textIndexToCharIndex(int i);

    public abstract ArrayList<NativeTextBlock> textLines(NativeTextLinesTrimWhitespace nativeTextLinesTrimWhitespace);

    public abstract NativeRectDescriptor textRectAt(PointF pointF, float f);

    public abstract NativeTextRange textRects();

    public abstract NativeTextRange textRectsBetweenPoints(PointF pointF, PointF pointF2);

    public abstract ArrayList<NativeRectDescriptor> textRectsBoundedByRect(RectF rectF, boolean z, boolean z2, boolean z3);

    public abstract NativeTextRange textRectsForRange(int i, int i2);

    public abstract NativeTextRange wordAt(PointF pointF);

    public abstract ArrayList<NativeTextRange> wordsAt(PointF pointF, float f);
}
