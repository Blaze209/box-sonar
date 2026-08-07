package com.box.android.search.navigation.notes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotesSearchDestination.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/search/navigation/notes/NotesSearchDestination;", "", "<init>", "()V", "InnerDestination", "Companion", "Lcom/box/android/search/navigation/notes/NotesSearchDestination$InnerDestination;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class NotesSearchDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ NotesSearchDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NotesSearchDestination() {
    }

    /* JADX INFO: compiled from: NotesSearchDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/search/navigation/notes/NotesSearchDestination$InnerDestination;", "Lcom/box/android/search/navigation/notes/NotesSearchDestination;", "<init>", "()V", "Search", "Lcom/box/android/search/navigation/notes/NotesSearchDestination$InnerDestination$Search;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InnerDestination extends NotesSearchDestination {
        public static final int $stable = 0;

        public /* synthetic */ InnerDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NotesSearchDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/navigation/notes/NotesSearchDestination$InnerDestination$Search;", "Lcom/box/android/search/navigation/notes/NotesSearchDestination$InnerDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Search extends InnerDestination {
            public static final int $stable = 0;
            public static final Search INSTANCE = new Search();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Search)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1026896069;
            }

            public String toString() {
                return "Search";
            }

            private Search() {
                super(null);
            }
        }

        private InnerDestination() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: NotesSearchDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/navigation/notes/NotesSearchDestination$Companion;", "", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
