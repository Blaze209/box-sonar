package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSSpan {
    final NativeJSAlignment mAlignment;
    final ArrayList<String> mFontFamily;
    final String mFontStretch;
    final NativeJSTextStyle mFontStyle;
    final int mFontWeight;
    final boolean mStrikethrough;
    final boolean mSubscript;
    final boolean mSuperscript;
    final String mText;
    final ArrayList<NativeJSColor> mTextColor;
    final int mTextSize;
    final boolean mUnderline;

    public NativeJSSpan(NativeJSAlignment nativeJSAlignment, ArrayList<String> arrayList, String str, NativeJSTextStyle nativeJSTextStyle, int i, boolean z, boolean z2, boolean z3, String str2, ArrayList<NativeJSColor> arrayList2, int i2, boolean z4) {
        this.mAlignment = nativeJSAlignment;
        this.mFontFamily = arrayList;
        this.mFontStretch = str;
        this.mFontStyle = nativeJSTextStyle;
        this.mFontWeight = i;
        this.mStrikethrough = z;
        this.mSubscript = z2;
        this.mSuperscript = z3;
        this.mText = str2;
        this.mTextColor = arrayList2;
        this.mTextSize = i2;
        this.mUnderline = z4;
    }

    public NativeJSAlignment getAlignment() {
        return this.mAlignment;
    }

    public ArrayList<String> getFontFamily() {
        return this.mFontFamily;
    }

    public String getFontStretch() {
        return this.mFontStretch;
    }

    public NativeJSTextStyle getFontStyle() {
        return this.mFontStyle;
    }

    public int getFontWeight() {
        return this.mFontWeight;
    }

    public boolean getStrikethrough() {
        return this.mStrikethrough;
    }

    public boolean getSubscript() {
        return this.mSubscript;
    }

    public boolean getSuperscript() {
        return this.mSuperscript;
    }

    public String getText() {
        return this.mText;
    }

    public ArrayList<NativeJSColor> getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public boolean getUnderline() {
        return this.mUnderline;
    }

    public String toString() {
        return "NativeJSSpan{mAlignment=" + this.mAlignment + ",mFontFamily=" + this.mFontFamily + ",mFontStretch=" + this.mFontStretch + ",mFontStyle=" + this.mFontStyle + ",mFontWeight=" + this.mFontWeight + ",mStrikethrough=" + this.mStrikethrough + ",mSubscript=" + this.mSubscript + ",mSuperscript=" + this.mSuperscript + ",mText=" + this.mText + ",mTextColor=" + this.mTextColor + ",mTextSize=" + this.mTextSize + ",mUnderline=" + this.mUnderline + "}";
    }
}
