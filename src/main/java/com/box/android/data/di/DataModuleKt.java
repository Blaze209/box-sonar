package com.box.android.data.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: DataModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005¨\u0006\u000b"}, d2 = {"recentSearchDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getRecentSearchDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "recentSearchDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "lastUsedTabDataStore", "getLastUsedTabDataStore", "lastUsedTabDataStore$delegate", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DataModuleKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DataModuleKt.class, "recentSearchDataStore", "getRecentSearchDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)), Reflection.property1(new PropertyReference1Impl(DataModuleKt.class, "lastUsedTabDataStore", "getLastUsedTabDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    private static final ReadOnlyProperty recentSearchDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("com.box.android.recent_search_queries", null, null, null, 14, null);
    private static final ReadOnlyProperty lastUsedTabDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("com.box.android.last_used_tab", null, null, null, 14, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataStore<Preferences> getRecentSearchDataStore(Context context) {
        return (DataStore) recentSearchDataStore$delegate.getValue(context, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataStore<Preferences> getLastUsedTabDataStore(Context context) {
        return (DataStore) lastUsedTabDataStore$delegate.getValue(context, $$delegatedProperties[1]);
    }
}
