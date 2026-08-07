package com.box.android.domain.localrepo;

import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxOrder;

/* JADX INFO: loaded from: classes11.dex */
public class LocalSortPreferences {
    private static final String SORT_BY_PREFS_KEY = "sort_by";
    private static final String SORT_ORDER_PREFS_KEY = "sort_order";
    private SortPreferencesListener mListener;
    private final IUserContextManager mUserConextManager;

    public enum SortOrder {
        ASC,
        DESC
    }

    public interface SortPreferencesListener {
        void onSortPreferencesChanged();
    }

    /* JADX INFO: renamed from: com.box.android.domain.localrepo.LocalSortPreferences$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy;

        static {
            int[] iArr = new int[SortBy.values().length];
            $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy = iArr;
            try {
                iArr[SortBy.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy[SortBy.SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum SortBy {
        NAME,
        SIZE,
        MODIFIED_AT;

        public String toApiSort() {
            int i = AnonymousClass1.$SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy[ordinal()];
            if (i == 1) {
                return "name";
            }
            if (i == 2) {
                return "size";
            }
            return BoxOrder.SORT_DATE;
        }
    }

    public LocalSortPreferences(IUserContextManager iUserContextManager) {
        this.mUserConextManager = iUserContextManager;
    }

    public SortBy getSortBy() {
        return SortBy.valueOf(this.mUserConextManager.getUserSharedPrefs().getString(SORT_BY_PREFS_KEY, SortBy.MODIFIED_AT.toString()));
    }

    public void saveSortBy(SortBy sortBy) {
        this.mUserConextManager.getUserSharedPrefs().edit().putString(SORT_BY_PREFS_KEY, sortBy.toString()).commit();
        notifyListener();
    }

    public SortOrder getSortOrder() {
        return SortOrder.valueOf(this.mUserConextManager.getUserSharedPrefs().getString(SORT_ORDER_PREFS_KEY, SortOrder.DESC.toString()));
    }

    public void saveSortOrder(SortOrder sortOrder) {
        this.mUserConextManager.getUserSharedPrefs().edit().putString(SORT_ORDER_PREFS_KEY, sortOrder.toString()).commit();
        notifyListener();
    }

    public void setChangeListener(SortPreferencesListener sortPreferencesListener) {
        this.mListener = sortPreferencesListener;
    }

    private void notifyListener() {
        SortPreferencesListener sortPreferencesListener = this.mListener;
        if (sortPreferencesListener != null) {
            sortPreferencesListener.onSortPreferencesChanged();
        }
    }
}
