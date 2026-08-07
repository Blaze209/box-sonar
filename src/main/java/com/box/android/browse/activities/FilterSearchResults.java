package com.box.android.browse.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.box.android.browse.R;
import com.box.android.browse.fragments.BoxFilterSearchResultsFragment;
import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.domain.configuration.FeatureFlips;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes10.dex */
public class FilterSearchResults extends Hilt_FilterSearchResults {
    private static String EXTRA_FILTERS = "extraFilters";

    @Inject
    protected FeatureFlips mFeatureFlips;
    private BoxSearchFilters mFilters;
    private BoxFilterSearchResultsFragment mFragment;

    @Override // com.box.android.browse.activities.Hilt_FilterSearchResults, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        setContentView(R.layout.activity_filter_search_results2);
        if (bundle != null) {
            this.mFilters = (BoxSearchFilters) bundle.getSerializable(EXTRA_FILTERS);
        } else {
            this.mFilters = (BoxSearchFilters) getIntent().getExtras().getSerializable(EXTRA_FILTERS);
        }
        BoxFilterSearchResultsFragment boxFilterSearchResultsFragment = (BoxFilterSearchResultsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        this.mFragment = boxFilterSearchResultsFragment;
        if (boxFilterSearchResultsFragment == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.setTransition(0);
            this.mFragment = BoxFilterSearchResultsFragment.newInstance(this.mFilters, this.mFeatureFlips.getMainScreenRedesign().getEnabled());
            fragmentTransactionBeginTransaction.add(R.id.fragmentContainer, this.mFragment);
            fragmentTransactionBeginTransaction.commit();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        BoxFilterSearchResultsFragment boxFilterSearchResultsFragment = this.mFragment;
        if (boxFilterSearchResultsFragment != null) {
            this.mFilters = boxFilterSearchResultsFragment.getCurrentFilters();
        }
        bundle.putSerializable(EXTRA_FILTERS, this.mFilters);
        super.onMAMSaveInstanceState(bundle);
    }

    public static Intent newFilterSearchResultsIntent(Context context, BoxSearchFilters boxSearchFilters) {
        Intent intent = new Intent(context, (Class<?>) FilterSearchResults.class);
        String str = EXTRA_FILTERS;
        if (boxSearchFilters == null) {
            boxSearchFilters = new BoxSearchFilters();
        }
        intent.putExtra(str, boxSearchFilters);
        return intent;
    }
}
