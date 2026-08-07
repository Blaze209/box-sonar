package com.box.android.data.datasource.gql.cache.partial;

import com.box.android.data.datasource.gql.cache.partial.models.PartialMiniItem;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLPartialMiniItemsSorter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialMiniItemsSorter;", "", "localSortPreferences", "Lcom/box/android/domain/localrepo/LocalSortPreferences;", "<init>", "(Lcom/box/android/domain/localrepo/LocalSortPreferences;)V", "getLocalSortPreferences", "()Lcom/box/android/domain/localrepo/LocalSortPreferences;", "sortItems", "", "Lcom/box/android/data/datasource/gql/cache/partial/models/PartialMiniItem;", AlertFragment.ARG_ITEMS, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLPartialMiniItemsSorter {
    private final LocalSortPreferences localSortPreferences;

    /* JADX INFO: compiled from: GQLPartialMiniItemsSorter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LocalSortPreferences.SortBy.values().length];
            try {
                iArr[LocalSortPreferences.SortBy.MODIFIED_AT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalSortPreferences.SortBy.NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalSortPreferences.SortBy.SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public GQLPartialMiniItemsSorter(LocalSortPreferences localSortPreferences) {
        Intrinsics.checkNotNullParameter(localSortPreferences, "localSortPreferences");
        this.localSortPreferences = localSortPreferences;
    }

    public final LocalSortPreferences getLocalSortPreferences() {
        return this.localSortPreferences;
    }

    public final List<PartialMiniItem> sortItems(List<PartialMiniItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        LocalSortPreferences.SortBy sortBy = this.localSortPreferences.getSortBy();
        if (sortBy == null) {
            sortBy = LocalSortPreferences.SortBy.MODIFIED_AT;
        }
        final Function1 function1 = new Function1() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(GQLPartialMiniItemsSorter.sortItems$lambda$0((PartialMiniItem) obj));
            }
        };
        if (this.localSortPreferences.getSortOrder() == LocalSortPreferences.SortOrder.ASC) {
            int i = WhenMappings.$EnumSwitchMapping$0[sortBy.ordinal()];
            if (i == 1) {
                final Comparator comparator = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$compareBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Function1 function2 = function1;
                        return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                    }
                };
                final Comparator comparator2 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator.compare(t, t2);
                        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t).getContentUpdatedAt(), ((PartialMiniItem) t2).getContentUpdatedAt());
                    }
                };
                return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator2.compare(t, t2);
                        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t).getId(), ((PartialMiniItem) t2).getId());
                    }
                });
            }
            if (i == 2) {
                final Comparator comparator3 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$compareBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Function1 function2 = function1;
                        return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                    }
                };
                final Comparator comparator4 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenBy$3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator3.compare(t, t2);
                        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t).getName(), ((PartialMiniItem) t2).getName());
                    }
                };
                return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenBy$4
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator4.compare(t, t2);
                        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t).getId(), ((PartialMiniItem) t2).getId());
                    }
                });
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            final Comparator comparator5 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$compareBy$3
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Function1 function2 = function1;
                    return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                }
            };
            final Comparator comparator6 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenBy$5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator5.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t).getSize(), ((PartialMiniItem) t2).getSize());
                }
            };
            return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenBy$6
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator6.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t).getId(), ((PartialMiniItem) t2).getId());
                }
            });
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[sortBy.ordinal()];
        if (i2 == 1) {
            final Comparator comparator7 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$compareBy$4
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Function1 function2 = function1;
                    return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                }
            };
            final Comparator comparator8 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator7.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t2).getContentUpdatedAt(), ((PartialMiniItem) t).getContentUpdatedAt());
                }
            };
            return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator8.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t2).getId(), ((PartialMiniItem) t).getId());
                }
            });
        }
        if (i2 == 2) {
            final Comparator comparator9 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$compareBy$5
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Function1 function2 = function1;
                    return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                }
            };
            final Comparator comparator10 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenByDescending$3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator9.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t2).getName(), ((PartialMiniItem) t).getName());
                }
            };
            return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenByDescending$4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator10.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t2).getId(), ((PartialMiniItem) t).getId());
                }
            });
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        final Comparator comparator11 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$compareBy$6
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Function1 function2 = function1;
                return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
            }
        };
        final Comparator comparator12 = new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenByDescending$5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator11.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t2).getSize(), ((PartialMiniItem) t).getSize());
            }
        };
        return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter$sortItems$$inlined$thenByDescending$6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator12.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((PartialMiniItem) t2).getId(), ((PartialMiniItem) t).getId());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortItems$lambda$0(PartialMiniItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String type = it.getType();
        if (Intrinsics.areEqual(type, "folder")) {
            return 0;
        }
        return Intrinsics.areEqual(type, "file") ? 1 : 2;
    }
}
