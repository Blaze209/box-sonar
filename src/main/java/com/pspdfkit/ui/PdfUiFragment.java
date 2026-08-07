package com.pspdfkit.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.tools.r8.RecordTag;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.n70$a$$ExternalSyntheticRecord0;
import com.pspdfkit.internal.sm;
import com.pspdfkit.internal.uw;
import com.pspdfkit.listeners.OnToolbarMenuChangedListener;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PdfUiFragment extends Fragment implements PdfUi {
    private static final String STATE_FRAGMENT = "PdfActivity.ConfigurationChanged.FragmentState";
    private PdfActivityConfiguration configurationToApply;
    private cw implementation;
    protected final InternalPdfUiImpl internalPdfUi = new InternalPdfUiImpl(this);
    private OnToolbarMenuChangedListener toolbarMenuListener;
    private FrameLayout viewContainer;

    public static final class InternalPdfUiImpl extends RecordTag implements sm {
        private final PdfUiFragment fragment;

        private /* synthetic */ boolean $record$equals(Object obj) {
            return (obj instanceof InternalPdfUiImpl) && Objects.equals(this.fragment, ((InternalPdfUiImpl) obj).fragment);
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{this.fragment};
        }

        public InternalPdfUiImpl(PdfUiFragment pdfUiFragment) {
            this.fragment = pdfUiFragment;
        }

        public final boolean equals(Object obj) {
            return $record$equals(obj);
        }

        public PdfUiFragment fragment() {
            return this.fragment;
        }

        @Override // com.pspdfkit.internal.sm
        public FragmentManager getFragmentManager() {
            return this.fragment.getChildFragmentManager();
        }

        @Override // com.pspdfkit.internal.sm
        public Bundle getPdfParameters() {
            return this.fragment.getArguments();
        }

        public final int hashCode() {
            return Objects.hashCode(this.fragment);
        }

        @Override // com.pspdfkit.internal.sm
        public void performApplyConfiguration(PdfActivityConfiguration pdfActivityConfiguration) {
            this.fragment.applyConfiguration();
        }

        @Override // com.pspdfkit.internal.sm
        public void setPdfView(View view) {
            this.fragment.viewContainer.removeAllViews();
            this.fragment.viewContainer.addView(view);
        }

        public final String toString() {
            return n70$a$$ExternalSyntheticRecord0.m($record$getFieldsAsObjects(), InternalPdfUiImpl.class, BuildConfig.FLAVOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyConfiguration() {
        Bundle bundle = new Bundle();
        this.implementation.onSaveInstanceState(bundle, true, true);
        requirePdfParameters().putBundle(cw.PARAM_ACTIVITY_STATE, bundle);
        cw.retainedDocument = this.implementation.getDocument();
        PdfFragment fragment = this.implementation.getFragment();
        if (fragment != null) {
            this.internalPdfUi.getFragmentManager().beginTransaction().remove(fragment).commit();
        }
        this.implementation.onPause();
        this.implementation.onStop();
        this.implementation.onDestroy();
        cw cwVar = new cw((AppCompatActivity) requireActivity(), this, this.internalPdfUi);
        this.implementation = cwVar;
        OnToolbarMenuChangedListener onToolbarMenuChangedListener = this.toolbarMenuListener;
        if (onToolbarMenuChangedListener != null) {
            cwVar.setOnToolbarMenuChangedListener(onToolbarMenuChangedListener);
        }
        this.implementation.onCreate(null);
        this.implementation.onStart();
        this.implementation.onResume();
    }

    private Bundle requirePdfParameters() {
        Bundle pdfParameters = this.internalPdfUi.getPdfParameters();
        if (pdfParameters != null) {
            return pdfParameters;
        }
        throw new IllegalStateException("PdfUiFragment was not initialized with proper arguments!");
    }

    public cw createImplementation() {
        return new cw((AppCompatActivity) requireActivity(), this, this.internalPdfUi);
    }

    @Override // com.pspdfkit.ui.PdfUi
    public PdfActivityConfiguration getConfiguration() {
        cw cwVar = this.implementation;
        if (cwVar != null) {
            return cwVar.getConfiguration();
        }
        PdfActivityConfiguration pdfActivityConfiguration = this.configurationToApply;
        if (pdfActivityConfiguration != null) {
            return pdfActivityConfiguration;
        }
        PdfActivityConfiguration pdfActivityConfiguration2 = (PdfActivityConfiguration) requirePdfParameters().getParcelable("Nutri.Configuration");
        uw.b(pdfActivityConfiguration2 != null, "PdfConfiguration may not be null!");
        return pdfActivityConfiguration2;
    }

    @Override // com.pspdfkit.ui.PdfUi
    public cw getImplementation() {
        return this.implementation;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.implementation.onActivityResult(i, i2, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if ((context instanceof OnToolbarMenuChangedListener) && this.toolbarMenuListener == null) {
            this.toolbarMenuListener = (OnToolbarMenuChangedListener) context;
        }
    }

    public boolean onBackPressed() {
        cw cwVar = this.implementation;
        if (cwVar != null) {
            return cwVar.onBackPressed();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getImplementation().onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.implementation.onCreateOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        cw cwVarCreateImplementation = createImplementation();
        this.implementation = cwVarCreateImplementation;
        OnToolbarMenuChangedListener onToolbarMenuChangedListener = this.toolbarMenuListener;
        if (onToolbarMenuChangedListener != null) {
            cwVarCreateImplementation.setOnToolbarMenuChangedListener(onToolbarMenuChangedListener);
        }
        this.viewContainer = new FrameLayout(requireContext());
        PdfActivityConfiguration pdfActivityConfiguration = this.configurationToApply;
        if (pdfActivityConfiguration != null) {
            cw.applyConfigurationToParamsAndState(pdfActivityConfiguration, requirePdfParameters(), bundle);
            this.configurationToApply = null;
        }
        this.implementation.onCreate(bundle);
        return this.viewContainer;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.implementation.onDestroy();
    }

    @Override // com.pspdfkit.listeners.OnMenuItemsGenerateListener
    public List<Integer> onGenerateMenuItemIds(List<Integer> list) {
        return list;
    }

    @Override // com.pspdfkit.ui.PdfUi, com.pspdfkit.internal.av.a
    public int onGetShowAsAction(int i, int i2) {
        return i2;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.implementation.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.implementation.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.implementation.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.implementation.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.implementation.onSaveInstanceState(bundle);
        if (getPdfFragment() != null) {
            bundle.putParcelable(STATE_FRAGMENT, getPdfFragment().getState());
        }
    }

    @Override // com.pspdfkit.listeners.PdfActivityListener
    public void onSetActivityTitle(PdfActivityConfiguration pdfActivityConfiguration, PdfDocument pdfDocument) {
        this.implementation.onSetActivityTitle(pdfDocument);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.implementation.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.implementation.onStop();
    }

    @Override // com.pspdfkit.listeners.PdfActivityListener
    public void onUserInterfaceVisibilityChanged(boolean z) {
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setConfiguration(PdfActivityConfiguration pdfActivityConfiguration) {
        uw.a(pdfActivityConfiguration, "configuration", null);
        cw cwVar = this.implementation;
        if (cwVar != null) {
            cwVar.setConfiguration(pdfActivityConfiguration);
        } else {
            this.configurationToApply = pdfActivityConfiguration;
        }
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setOnToolbarMenuChangedListener(OnToolbarMenuChangedListener onToolbarMenuChangedListener) {
        this.toolbarMenuListener = onToolbarMenuChangedListener;
        cw cwVar = this.implementation;
        if (cwVar != null) {
            cwVar.setOnToolbarMenuChangedListener(onToolbarMenuChangedListener);
        }
    }
}
