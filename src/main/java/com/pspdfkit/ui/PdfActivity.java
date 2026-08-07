package com.pspdfkit.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.R;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.sm;
import com.pspdfkit.internal.uw;
import com.pspdfkit.listeners.PdfActivityListener;
import com.pspdfkit.utils.PdfLog;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfActivity extends AppCompatActivity implements PdfUi, PdfActivityListener, PdfActivityComponentsApi {
    private static final String PARAM_HIERARCHY_STATE_STATE = "PdfActivity.HierarchyState";
    private static final String STATE_FRAGMENT = "PdfActivity.ConfigurationChanged.FragmentState";
    private PdfActivityConfiguration configurationToApply;
    cw implementation;
    public static final int MENU_OPTION_THUMBNAIL_GRID = R.id.pspdf__menu_option_thumbnail_grid;
    public static final int MENU_OPTION_SEARCH = R.id.pspdf__menu_option_search;
    public static final int MENU_OPTION_OUTLINE = R.id.pspdf__menu_option_outline;
    public static final int MENU_OPTION_EDIT_ANNOTATIONS = R.id.pspdf__menu_option_edit_annotations;
    public static final int MENU_OPTION_EDIT_CONTENT = R.id.pspdf__menu_option_edit_content;
    public static final int MENU_OPTION_AI_ASSISTANT = R.id.pspdf__menu_option_ai_assistant;
    public static final int MENU_OPTION_SIGNATURE = R.id.pspdf__menu_option_signature;
    public static final int MENU_OPTION_SHARE = R.id.pspdf__menu_option_share;
    public static final int MENU_OPTION_SETTINGS = R.id.pspdf__menu_option_settings;
    public static final int MENU_OPTION_READER_VIEW = R.id.pspdf__menu_option_reader_view;
    public static final int MENU_OPTION_DOCUMENT_INFO = R.id.pspdf__menu_option_info_view;
    private final String LOG_TAG = "Nutri.PdfActivity";
    protected final InternalPdfUiImpl internalPdfUi = new InternalPdfUiImpl(this);

    public static class InternalPdfUiImpl implements sm {
        private final PdfActivity activity;

        public InternalPdfUiImpl(PdfActivity pdfActivity) {
            this.activity = pdfActivity;
        }

        @Override // com.pspdfkit.internal.sm
        public FragmentManager getFragmentManager() {
            return this.activity.getSupportFragmentManager();
        }

        @Override // com.pspdfkit.internal.sm
        public Bundle getPdfParameters() {
            return this.activity.getIntent().getBundleExtra("Nutri.InternalExtras");
        }

        @Override // com.pspdfkit.internal.sm
        public void performApplyConfiguration(PdfActivityConfiguration pdfActivityConfiguration) {
            this.activity.applyConfiguration();
        }

        @Override // com.pspdfkit.internal.sm
        public void setPdfView(View view) {
            this.activity.setContentView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyConfiguration() {
        Intent intent = getIntent();
        if (intent == null || intent.getBundleExtra("Nutri.InternalExtras") == null) {
            throw new IllegalArgumentException("PdfActivity was not initialized with proper arguments.");
        }
        Intent intent2 = new Intent(intent);
        Bundle bundleExtra = intent2.getBundleExtra("Nutri.InternalExtras");
        Bundle bundle = new Bundle();
        this.implementation.onSaveInstanceState(bundle, true, true);
        bundleExtra.putBundle(cw.PARAM_ACTIVITY_STATE, bundle);
        bundleExtra.putBundle(PARAM_HIERARCHY_STATE_STATE, getWindow().saveHierarchyState());
        cw.retainedDocument = this.implementation.getDocument();
        PdfFragment fragment = this.implementation.getFragment();
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent2);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private Bundle requirePdfParameters() {
        Bundle pdfParameters = this.internalPdfUi.getPdfParameters();
        if (pdfParameters != null) {
            return pdfParameters;
        }
        throw new IllegalStateException("PdfActivity was not initialized with proper arguments!");
    }

    public static void showDocument(Context context, Uri uri, String str, PdfActivityConfiguration pdfActivityConfiguration) {
        uw.a(context, "context", null);
        uw.a(uri, "documentUri", null);
        context.startActivity(PdfActivityIntentBuilder.fromUri(context, uri).passwords(str).configuration(pdfActivityConfiguration).build());
    }

    public static void showImage(Context context, Uri uri, PdfActivityConfiguration pdfActivityConfiguration) {
        uw.a(context, "context", null);
        uw.a(uri, "imageUri", null);
        context.startActivity(PdfActivityIntentBuilder.fromImageUri(context, uri).configuration(pdfActivityConfiguration).build());
    }

    public cw createImplementation() {
        return new cw(this, this, this.internalPdfUi);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.implementation.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.pspdfkit.ui.PdfUi
    public PdfActivityConfiguration getConfiguration() {
        cw cwVar = this.implementation;
        if (cwVar != null) {
            return cwVar.getConfiguration();
        }
        PdfActivityConfiguration pdfActivityConfiguration = (PdfActivityConfiguration) requirePdfParameters().getParcelable("Nutri.Configuration");
        uw.b(pdfActivityConfiguration != null, "PdfActivity requires a configuration extra!");
        return pdfActivityConfiguration;
    }

    @Override // com.pspdfkit.ui.PdfUi
    public cw getImplementation() {
        return this.implementation;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        cw cwVar = this.implementation;
        if (cwVar != null) {
            cwVar.invalidateMenu();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getImplementation().onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.implementation.onCreateOptionsMenu(menu);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoadFailed(Throwable th) {
        setResult(0);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument pdfDocument) {
        setResult(-1);
    }

    @Override // com.pspdfkit.listeners.OnMenuItemsGenerateListener
    public List<Integer> onGenerateMenuItemIds(List<Integer> list) {
        return list;
    }

    @Override // com.pspdfkit.ui.PdfUi, com.pspdfkit.internal.av.a
    public int onGetShowAsAction(int i, int i2) {
        return i2;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        super.onMAMActivityResult(i, i2, intent);
        this.implementation.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        supportRequestWindowFeature(108);
        supportRequestWindowFeature(109);
        supportRequestWindowFeature(10);
        long jA = hn.a(this);
        if (jA != 48 && jA != 0) {
            PdfLog.w("Nutri.PdfActivity", "Soft input mode in PdfActivity window is set to `" + (jA == 16 ? "adjustResize" : "adjustPan") + "`. Using soft input mode other than `adjustNothing` could lead to unpredictable behavior!", new Object[0]);
        }
        super.onMAMCreate(bundle);
        this.implementation = createImplementation();
        PdfActivityConfiguration pdfActivityConfiguration = this.configurationToApply;
        if (pdfActivityConfiguration != null) {
            cw.applyConfigurationToParamsAndState(pdfActivityConfiguration, requirePdfParameters(), bundle);
            this.configurationToApply = null;
        }
        this.implementation.onCreate(bundle);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.pspdfkit.ui.PdfActivity.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (PdfActivity.this.implementation.onBackPressed()) {
                    return;
                }
                setEnabled(false);
                PdfActivity.this.getOnBackPressedDispatcher().onBackPressed();
                setEnabled(true);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        this.implementation.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        super.onMAMPause();
        this.implementation.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPostCreate(Bundle bundle) {
        super.onMAMPostCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra("Nutri.InternalExtras");
        if (bundle == null && bundleExtra != null && bundleExtra.containsKey(PARAM_HIERARCHY_STATE_STATE)) {
            getWindow().restoreHierarchyState(bundleExtra.getBundle(PARAM_HIERARCHY_STATE_STATE));
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public boolean onMAMPrepareOptionsMenu(Menu menu) {
        return this.implementation.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        this.implementation.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        super.onMAMSaveInstanceState(bundle);
        this.implementation.onSaveInstanceState(bundle);
        if (getPdfFragment() != null) {
            bundle.putParcelable(STATE_FRAGMENT, getPdfFragment().getState());
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.implementation.onOptionsItemSelected(menuItem);
    }

    @Override // com.pspdfkit.listeners.PdfActivityListener
    public void onSetActivityTitle(PdfActivityConfiguration pdfActivityConfiguration, PdfDocument pdfDocument) {
        this.implementation.onSetActivityTitle(pdfDocument);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.implementation.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getSupportFragmentManager().executePendingTransactions();
        this.implementation.onStop();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.implementation.onTrimMemory(i);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        this.implementation.onUserInteraction();
    }

    @Override // com.pspdfkit.listeners.PdfActivityListener
    public void onUserInterfaceVisibilityChanged(boolean z) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.implementation.onWindowFocusChanged(z);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public static void showDocument(Context context, Uri uri, PdfActivityConfiguration pdfActivityConfiguration) {
        showDocument(context, uri, null, pdfActivityConfiguration);
    }
}
