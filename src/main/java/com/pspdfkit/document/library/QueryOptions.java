package com.pspdfkit.document.library;

import com.pspdfkit.datastructures.Range;

/* JADX INFO: loaded from: classes3.dex */
public class QueryOptions {
    private final boolean generateTextPreviews;
    private final boolean ignoreAnnotations;
    private final boolean ignoreDocumentText;
    private final boolean matchExactPhrases;
    private final boolean matchExactWords;
    private final int maximumPreviewResultsPerDocument;
    private final int maximumPreviewResultsTotal;
    private final int maximumSearchResultsPerDocument;
    private final int maximumSearchResultsTotal;
    private final Range previewRange;

    public static final class Builder {
        private static final int DEFAULT_SEARCH_RESULTS_LIMIT = 500;
        private boolean matchExactPhrases = false;
        private boolean matchExactWords = false;
        private boolean ignoreAnnotations = false;
        private boolean ignoreDocumentText = false;
        private int maximumSearchResultsPerDocument = Integer.MAX_VALUE;
        private int maximumSearchResultsTotal = 500;
        private int maximumPreviewResultsPerDocument = Integer.MAX_VALUE;
        private int maximumPreviewResultsTotal = 500;
        private boolean generateTextPreviews = false;
        private Range previewRange = new Range(20, 160);

        public QueryOptions build() {
            return new QueryOptions(this);
        }

        public Builder generateTextPreviews(boolean z) {
            this.generateTextPreviews = z;
            return this;
        }

        public Builder ignoreAnnotations(boolean z) {
            this.ignoreAnnotations = z;
            return this;
        }

        public Builder ignoreDocumentText(boolean z) {
            this.ignoreDocumentText = z;
            return this;
        }

        public Builder matchExactPhrases(boolean z) {
            this.matchExactPhrases = z;
            return this;
        }

        public Builder matchExactWords(boolean z) {
            this.matchExactWords = z;
            return this;
        }

        public Builder maximumPreviewResultsPerDocument(int i) {
            this.maximumPreviewResultsPerDocument = i;
            return this;
        }

        public Builder maximumPreviewResultsTotal(int i) {
            this.maximumPreviewResultsTotal = i;
            return this;
        }

        public Builder maximumSearchResultsPerDocument(int i) {
            this.maximumSearchResultsPerDocument = i;
            return this;
        }

        public Builder maximumSearchResultsTotal(int i) {
            this.maximumSearchResultsTotal = i;
            return this;
        }

        public Builder previewRange(int i, int i2) {
            this.previewRange = new Range(i, i2);
            return this;
        }
    }

    public QueryOptions(Builder builder) {
        this.matchExactPhrases = builder.matchExactPhrases;
        this.matchExactWords = builder.matchExactWords;
        this.ignoreAnnotations = builder.ignoreAnnotations;
        this.ignoreDocumentText = builder.ignoreDocumentText;
        this.maximumSearchResultsPerDocument = builder.maximumSearchResultsPerDocument;
        this.maximumSearchResultsTotal = builder.maximumSearchResultsTotal;
        this.maximumPreviewResultsPerDocument = builder.maximumPreviewResultsPerDocument;
        this.maximumPreviewResultsTotal = builder.maximumPreviewResultsTotal;
        this.generateTextPreviews = builder.generateTextPreviews;
        this.previewRange = builder.previewRange;
    }

    public int getMaximumPreviewResultsPerDocument() {
        return this.maximumPreviewResultsPerDocument;
    }

    public int getMaximumPreviewResultsTotal() {
        return this.maximumPreviewResultsTotal;
    }

    public int getMaximumSearchResultsPerDocument() {
        return this.maximumSearchResultsPerDocument;
    }

    public int getMaximumSearchResultsTotal() {
        return this.maximumSearchResultsTotal;
    }

    public Range getPreviewRange() {
        return this.previewRange;
    }

    public boolean shouldGenerateTextPreviews() {
        return this.generateTextPreviews;
    }

    public boolean shouldIgnoreAnnotations() {
        return this.ignoreAnnotations;
    }

    public boolean shouldIgnoreDocumentText() {
        return this.ignoreDocumentText;
    }

    public boolean shouldMatchExactPhrases() {
        return this.matchExactPhrases;
    }

    public boolean shouldMatchExactWords() {
        return this.matchExactWords;
    }
}
