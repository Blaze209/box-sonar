package com.pspdfkit.internal.jni;

import com.pspdfkit.datastructures.Range;
import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentSearcherQuery {
    final EnumSet<NativeCompareOptionsFlags> mCompareOptions;
    final boolean mGenerateTextPreviews;
    final int mMaximumSearchResults;
    final Range mPreviewRange;
    final ArrayList<Range> mPriorityPages;
    final boolean mReturnEmptyResults;
    final boolean mSearchAllPages;
    final boolean mSearchAnnotationReplies;
    final boolean mSearchAnnotations;
    final String mSearchString;

    public NativeDocumentSearcherQuery(String str, EnumSet<NativeCompareOptionsFlags> enumSet, boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5, ArrayList<Range> arrayList, Range range) {
        this.mSearchString = str;
        this.mCompareOptions = enumSet;
        this.mGenerateTextPreviews = z;
        this.mSearchAnnotations = z2;
        this.mSearchAnnotationReplies = z3;
        this.mMaximumSearchResults = i;
        this.mSearchAllPages = z4;
        this.mReturnEmptyResults = z5;
        this.mPriorityPages = arrayList;
        this.mPreviewRange = range;
    }

    public EnumSet<NativeCompareOptionsFlags> getCompareOptions() {
        return this.mCompareOptions;
    }

    public boolean getGenerateTextPreviews() {
        return this.mGenerateTextPreviews;
    }

    public int getMaximumSearchResults() {
        return this.mMaximumSearchResults;
    }

    public Range getPreviewRange() {
        return this.mPreviewRange;
    }

    public ArrayList<Range> getPriorityPages() {
        return this.mPriorityPages;
    }

    public boolean getReturnEmptyResults() {
        return this.mReturnEmptyResults;
    }

    public boolean getSearchAllPages() {
        return this.mSearchAllPages;
    }

    public boolean getSearchAnnotationReplies() {
        return this.mSearchAnnotationReplies;
    }

    public boolean getSearchAnnotations() {
        return this.mSearchAnnotations;
    }

    public String getSearchString() {
        return this.mSearchString;
    }

    public String toString() {
        return "NativeDocumentSearcherQuery{mSearchString=" + this.mSearchString + ",mCompareOptions=" + this.mCompareOptions + ",mGenerateTextPreviews=" + this.mGenerateTextPreviews + ",mSearchAnnotations=" + this.mSearchAnnotations + ",mSearchAnnotationReplies=" + this.mSearchAnnotationReplies + ",mMaximumSearchResults=" + this.mMaximumSearchResults + ",mSearchAllPages=" + this.mSearchAllPages + ",mReturnEmptyResults=" + this.mReturnEmptyResults + ",mPriorityPages=" + this.mPriorityPages + ",mPreviewRange=" + this.mPreviewRange + "}";
    }
}
