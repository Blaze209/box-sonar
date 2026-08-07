package com.pspdfkit.document.search;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityManagerCompat;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.internal.n5;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchOptions {
    public static final int UNLIMITED_SEARCH_RESULTS = Integer.MAX_VALUE;
    public final EnumSet<CompareOptions> compareOptionsFlags;
    public final int maxSearchResults;
    public final List<Range> priorityPages;
    public final boolean searchAnnotations;
    public final boolean searchOnlyInPriorityPages;
    public final int snippetLength;

    private SearchOptions(int i, int i2, boolean z, List<Range> list, boolean z2, EnumSet<CompareOptions> enumSet) {
        this.maxSearchResults = i;
        this.snippetLength = i2;
        this.searchAnnotations = z;
        this.priorityPages = list;
        this.searchOnlyInPriorityPages = z2;
        this.compareOptionsFlags = enumSet;
    }

    public static final class Builder {
        static final int DEFAULT_SNIPPET_LENGTH = 80;
        static final int MAX_SEARCH_RESULTS = 500;
        static final int MAX_SEARCH_RESULTS_LOW_MEM = 350;
        private int maxSearchResults;
        private int snippetLength = 80;
        private List<Range> priorityPages = new ArrayList();
        private boolean searchOnlyInPriorityPages = false;
        private boolean searchAnnotations = true;
        private final EnumSet<CompareOptions> compareOptionsFlags = EnumSet.of(CompareOptions.CASE_INSENSITIVE, CompareOptions.DIACRITIC_INSENSITIVE, CompareOptions.SMART_SEARCH);

        public Builder() {
            int i;
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            if (ActivityManagerCompat.isLowRamDevice((ActivityManager) context.getSystemService("activity"))) {
                i = MAX_SEARCH_RESULTS_LOW_MEM;
            } else if (Runtime.getRuntime().maxMemory() / 1048576 < 96) {
                if (Build.FINGERPRINT.startsWith("generic")) {
                    PdfLog.e("Nutri.DeviceUtils", "================ WARNING - Heap size in your emulator is set unrealistically low and might cause OOM issues which will not appear on actual devices. ================", new Object[0]);
                }
                i = MAX_SEARCH_RESULTS_LOW_MEM;
            } else {
                i = 500;
            }
            this.maxSearchResults = i;
        }

        public SearchOptions build() {
            return new SearchOptions(this.maxSearchResults, this.snippetLength, this.searchAnnotations, this.priorityPages, this.searchOnlyInPriorityPages, this.compareOptionsFlags);
        }

        public Builder compareOptions(EnumSet<CompareOptions> enumSet) {
            uw.a(enumSet, "compareOptions", null);
            this.compareOptionsFlags.clear();
            this.compareOptionsFlags.addAll(enumSet);
            return this;
        }

        public Builder maxSearchResults(int i) {
            this.maxSearchResults = i;
            return this;
        }

        public Builder priorityPages(List<Range> list, boolean z) {
            uw.a(list, "priorityPages", null);
            this.priorityPages = list;
            this.searchOnlyInPriorityPages = z;
            return this;
        }

        public Builder searchAnnotations(boolean z) {
            this.searchAnnotations = z;
            return this;
        }

        public Builder snippetLength(int i) {
            this.snippetLength = i;
            return this;
        }

        public Builder compareOptions(CompareOptions... compareOptionsArr) {
            uw.a(compareOptionsArr, "compareOptions", null);
            this.compareOptionsFlags.clear();
            this.compareOptionsFlags.addAll(Arrays.asList(compareOptionsArr));
            return this;
        }

        public Builder priorityPages(List<Range> list) {
            priorityPages(list, false);
            return this;
        }
    }
}
