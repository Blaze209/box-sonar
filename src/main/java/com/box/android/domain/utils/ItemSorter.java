package com.box.android.domain.utils;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemSorter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/utils/ItemSorter;", "", "localSortPreferences", "Lcom/box/android/domain/localrepo/LocalSortPreferences;", "<init>", "(Lcom/box/android/domain/localrepo/LocalSortPreferences;)V", "sort", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/domain/models/item/ItemModel;", AlertFragment.ARG_ITEMS, "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemSorter {
    private final LocalSortPreferences localSortPreferences;

    /* JADX INFO: compiled from: ItemSorter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LocalSortPreferences.SortBy.values().length];
            try {
                iArr[LocalSortPreferences.SortBy.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalSortPreferences.SortBy.SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalSortPreferences.SortBy.MODIFIED_AT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ItemSorter(LocalSortPreferences localSortPreferences) {
        Intrinsics.checkNotNullParameter(localSortPreferences, "localSortPreferences");
        this.localSortPreferences = localSortPreferences;
    }

    public final <T extends ItemModel> List<T> sort(List<? extends T> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        LocalSortPreferences.SortBy sortBy = this.localSortPreferences.getSortBy();
        if (sortBy == null) {
            sortBy = LocalSortPreferences.SortBy.MODIFIED_AT;
        }
        boolean z = this.localSortPreferences.getSortOrder() == LocalSortPreferences.SortOrder.ASC;
        final Function1 function1 = new Function1() { // from class: com.box.android.domain.utils.ItemSorter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ItemSorter.sort$lambda$0((ItemModel) obj));
            }
        };
        if (z) {
            int i = WhenMappings.$EnumSwitchMapping$0[sortBy.ordinal()];
            if (i == 1) {
                final Comparator comparator = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$compareBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Function1 function2 = function1;
                        return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                    }
                };
                final Comparator comparator2 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator.compare(t, t2);
                        if (iCompare != 0) {
                            return iCompare;
                        }
                        String lowerCase = ((ItemModel) t).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((ItemModel) t2).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                };
                return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator2.compare(t, t2);
                        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t).getItemId().toString(), ((ItemModel) t2).getItemId().toString());
                    }
                });
            }
            if (i == 2) {
                final Comparator comparator3 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$compareBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Function1 function2 = function1;
                        return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                    }
                };
                final Comparator comparator4 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenBy$3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator3.compare(t, t2);
                        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t).getSize(), ((ItemModel) t2).getSize());
                    }
                };
                return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenBy$4
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int iCompare = comparator4.compare(t, t2);
                        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t).getItemId().toString(), ((ItemModel) t2).getItemId().toString());
                    }
                });
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            final Comparator comparator5 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$compareBy$3
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Function1 function2 = function1;
                    return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                }
            };
            final Comparator comparator6 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenBy$5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator5.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t).getContentModifiedDate(), ((ItemModel) t2).getContentModifiedDate());
                }
            };
            return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenBy$6
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator6.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t).getItemId().toString(), ((ItemModel) t2).getItemId().toString());
                }
            });
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[sortBy.ordinal()];
        if (i2 == 1) {
            final Comparator comparator7 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$compareBy$4
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Function1 function2 = function1;
                    return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                }
            };
            final Comparator comparator8 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator7.compare(t, t2);
                    if (iCompare != 0) {
                        return iCompare;
                    }
                    String lowerCase = ((ItemModel) t2).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((ItemModel) t).getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            };
            return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator8.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t2).getItemId().toString(), ((ItemModel) t).getItemId().toString());
                }
            });
        }
        if (i2 == 2) {
            final Comparator comparator9 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$compareBy$5
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Function1 function2 = function1;
                    return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
                }
            };
            final Comparator comparator10 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenByDescending$3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator9.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t2).getSize(), ((ItemModel) t).getSize());
                }
            };
            return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenByDescending$4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator10.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t2).getItemId().toString(), ((ItemModel) t).getItemId().toString());
                }
            });
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        final Comparator comparator11 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$compareBy$6
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Function1 function2 = function1;
                return ComparisonsKt.compareValues((Comparable) function2.invoke(t), (Comparable) function2.invoke(t2));
            }
        };
        final Comparator comparator12 = new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenByDescending$5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator11.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t2).getContentModifiedDate(), ((ItemModel) t).getContentModifiedDate());
            }
        };
        return CollectionsKt.sortedWith(items, new Comparator() { // from class: com.box.android.domain.utils.ItemSorter$sort$$inlined$thenByDescending$6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator12.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((ItemModel) t2).getItemId().toString(), ((ItemModel) t).getItemId().toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sort$lambda$0(ItemModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof FolderModel) {
            return 0;
        }
        return item instanceof FileModel ? 1 : 2;
    }
}
