package com.box.android.browse.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.browse.R;
import com.box.android.browse.fragments.BoxFilterSearchResultsFragment;
import com.box.android.browse.models.BoxSearchFilters;

/* JADX INFO: loaded from: classes10.dex */
public class FilterSearchResultsActivity extends Hilt_FilterSearchResultsActivity {
    private static String EXTRA_FILTERS = "extraFilters";
    private BoxSearchFilters mFilters;
    private BoxFilterSearchResultsFragment mFragment;

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (bundle != null) {
            this.mFilters = (BoxSearchFilters) bundle.getSerializable(EXTRA_FILTERS);
        } else {
            this.mFilters = (BoxSearchFilters) getIntent().getExtras().getSerializable(EXTRA_FILTERS);
        }
        setupToolbar();
        if (isLightModeEnabled()) {
            EdgeToEdge.enable(this);
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

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.activity_filter_search_results);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationContentDescription(R.string.refine_search_results_talkback_close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.activities.FilterSearchResultsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FilterSearchResultsActivity.this.setResult(0);
                FilterSearchResultsActivity.this.finish();
            }
        });
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        if (this.mFeatureFlips.getMainScreenRedesign().getEnabled()) {
            getSupportActionBar().setTitle(getString(R.string.filter_by_title));
            toolbar.setNavigationIcon(R.drawable.ic_arrow_left);
        } else {
            getSupportActionBar().setTitle(getString(R.string.filter_search_results));
            toolbar.setNavigationIcon(R.drawable.ic_toolbar_clear_24);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        BoxFilterSearchResultsFragment boxFilterSearchResultsFragment = this.mFragment;
        if (boxFilterSearchResultsFragment != null) {
            this.mFilters = boxFilterSearchResultsFragment.getCurrentFilters();
        }
        bundle.putSerializable(EXTRA_FILTERS, this.mFilters);
        super.onMAMSaveInstanceState(bundle);
    }

    public static Intent newFilterSearchResultsIntent(Context context, BoxSearchFilters boxSearchFilters) {
        Intent intent = new Intent(context, (Class<?>) FilterSearchResultsActivity.class);
        String str = EXTRA_FILTERS;
        if (boxSearchFilters == null) {
            boxSearchFilters = new BoxSearchFilters();
        }
        intent.putExtra(str, boxSearchFilters);
        return intent;
    }
}
