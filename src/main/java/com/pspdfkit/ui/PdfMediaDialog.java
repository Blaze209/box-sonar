package com.pspdfkit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.pspdfkit.R;
import com.pspdfkit.media.MediaGalleryView;
import com.pspdfkit.media.MediaUri;
import com.pspdfkit.media.MediaViewListener;
import com.pspdfkit.media.MediaWebView;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public class PdfMediaDialog extends MAMActivity implements MediaViewListener {
    public static final String ARG_MEDIA_URI = "Nutri.MediaURI";
    public static final String TAG = "Nutri.MediaDialog";
    private final String LOG_TAG = "Nutri.PdfMediaDialog";
    private View inflatedView;
    private MediaUri mediaUri;
    private ProgressBar progressBar;
    private RelativeLayout rootView;

    /* JADX INFO: renamed from: com.pspdfkit.ui.PdfMediaDialog$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$media$MediaUri$UriType;

        static {
            int[] iArr = new int[MediaUri.UriType.values().length];
            $SwitchMap$com$pspdfkit$media$MediaUri$UriType = iArr;
            try {
                iArr[MediaUri.UriType.GALLERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$media$MediaUri$UriType[MediaUri.UriType.VIDEO_YOUTUBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$media$MediaUri$UriType[MediaUri.UriType.WEB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pspdfkit$media$MediaUri$UriType[MediaUri.UriType.MEDIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.pspdfkit.media.MediaViewListener
    public void onContentError() {
        finish();
    }

    @Override // com.pspdfkit.media.MediaViewListener
    public void onContentReady() {
        this.progressBar.setVisibility(8);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        setContentView(R.layout.pspdf__media_dialog);
        this.mediaUri = (MediaUri) getIntent().getParcelableExtra(ARG_MEDIA_URI);
        this.rootView = (RelativeLayout) findViewById(R.id.pspdf__media_dialog_root);
        this.progressBar = (ProgressBar) findViewById(R.id.pspdf__loading_progress);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        View view = this.inflatedView;
        if (view instanceof MediaWebView) {
            ((MediaWebView) view).destroy();
        }
        this.inflatedView = null;
        super.onMAMDestroy();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        int i = AnonymousClass1.$SwitchMap$com$pspdfkit$media$MediaUri$UriType[this.mediaUri.getType().ordinal()];
        if (i == 1) {
            MediaGalleryView mediaGalleryView = new MediaGalleryView(this);
            mediaGalleryView.setMediaViewListener(this);
            mediaGalleryView.start(this.mediaUri.getOptions(), this.mediaUri.getUri());
            this.inflatedView = mediaGalleryView;
        } else {
            if (i != 2 && i != 3) {
                finish();
                return;
            }
            try {
                MediaWebView mediaWebView = new MediaWebView(this);
                mediaWebView.start(this.mediaUri.getOptions(), this.mediaUri.getUri());
                mediaWebView.setMediaViewListener(this);
                this.inflatedView = mediaWebView;
            } catch (Throwable th) {
                PdfLog.w("Nutri.PdfMediaDialog", th, "Can't initialize WebView for media display.", new Object[0]);
                finish();
                return;
            }
        }
        View view = this.inflatedView;
        if (view != null) {
            view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.rootView.addView(this.inflatedView, 0);
        }
    }
}
