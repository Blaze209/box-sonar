package com.pspdfkit.internal.jni;

import com.pspdfkit.datastructures.Range;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentLibraryQuery {
    final boolean mExcludeAnnotations;
    final boolean mExcludeDocumentText;
    final boolean mGenerateTextPreviews;
    final boolean mMatchExactPhrases;
    final boolean mMatchExactWords;
    final int mMaximumPreviewResultsPerDocument;
    final int mMaximumPreviewResultsTotal;
    final int mMaximumSearchResultsPerDocument;
    final int mMaximumSearchResultsTotal;
    final Range mPreviewRange;
    final String mSearchString;

    public NativeDocumentLibraryQuery(String str, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, int i3, int i4, boolean z5, Range range) {
        this.mSearchString = str;
        this.mExcludeAnnotations = z;
        this.mExcludeDocumentText = z2;
        this.mMatchExactPhrases = z3;
        this.mMatchExactWords = z4;
        this.mMaximumSearchResultsPerDocument = i;
        this.mMaximumSearchResultsTotal = i2;
        this.mMaximumPreviewResultsPerDocument = i3;
        this.mMaximumPreviewResultsTotal = i4;
        this.mGenerateTextPreviews = z5;
        this.mPreviewRange = range;
    }

    public boolean getExcludeAnnotations() {
        return this.mExcludeAnnotations;
    }

    public boolean getExcludeDocumentText() {
        return this.mExcludeDocumentText;
    }

    public boolean getGenerateTextPreviews() {
        return this.mGenerateTextPreviews;
    }

    public boolean getMatchExactPhrases() {
        return this.mMatchExactPhrases;
    }

    public boolean getMatchExactWords() {
        return this.mMatchExactWords;
    }

    public int getMaximumPreviewResultsPerDocument() {
        return this.mMaximumPreviewResultsPerDocument;
    }

    public int getMaximumPreviewResultsTotal() {
        return this.mMaximumPreviewResultsTotal;
    }

    public int getMaximumSearchResultsPerDocument() {
        return this.mMaximumSearchResultsPerDocument;
    }

    public int getMaximumSearchResultsTotal() {
        return this.mMaximumSearchResultsTotal;
    }

    public Range getPreviewRange() {
        return this.mPreviewRange;
    }

    public String getSearchString() {
        return this.mSearchString;
    }

    public String toString() {
        return "NativeDocumentLibraryQuery{mSearchString=" + this.mSearchString + ",mExcludeAnnotations=" + this.mExcludeAnnotations + ",mExcludeDocumentText=" + this.mExcludeDocumentText + ",mMatchExactPhrases=" + this.mMatchExactPhrases + ",mMatchExactWords=" + this.mMatchExactWords + ",mMaximumSearchResultsPerDocument=" + this.mMaximumSearchResultsPerDocument + ",mMaximumSearchResultsTotal=" + this.mMaximumSearchResultsTotal + ",mMaximumPreviewResultsPerDocument=" + this.mMaximumPreviewResultsPerDocument + ",mMaximumPreviewResultsTotal=" + this.mMaximumPreviewResultsTotal + ",mGenerateTextPreviews=" + this.mGenerateTextPreviews + ",mPreviewRange=" + this.mPreviewRange + "}";
    }
}
