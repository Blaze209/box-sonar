package com.pspdfkit.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.pspdfkit.R;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.UriAction;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.media.MediaUri;
import com.pspdfkit.ui.PdfMediaDialog;
import com.pspdfkit.utils.PdfLog;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class j70 implements c<UriAction> {
    public final DocumentView a;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MediaUri.UriType.values().length];
            try {
                iArr[MediaUri.UriType.VIDEO_YOUTUBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaUri.UriType.GALLERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaUri.UriType.WEB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaUri.UriType.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MediaUri.UriType.MEDIA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public j70(DocumentView documentView) {
        documentView.getClass();
        this.a = documentView;
    }

    public static void a(Context context, UriAction uriAction) {
        String uri = uriAction.getUri();
        uri.getClass();
        MediaUri mediaUri = MediaUri.parse(uri);
        mediaUri.getClass();
        int i = a.a[mediaUri.getType().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            Intent intent = new Intent(context, (Class<?>) PdfMediaDialog.class);
            intent.putExtra(PdfMediaDialog.ARG_MEDIA_URI, mediaUri);
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                PdfLog.e("Nutri.UriActionExecutor", e, "Activity PdfMediaDialog doesn't exist (make sure it's declared in manifest).", new Object[0]);
                return;
            }
        }
        if (i != 4) {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", mediaUri.getParsedUri()));
        } catch (Exception e2) {
            new AlertDialog.Builder(context).setTitle(no.a(context, R.string.pspdf__file_not_found_title, null)).setMessage(no.a(context, R.string.pspdf__file_not_found_message, (View) null, mediaUri.getUri())).setPositiveButton(no.a(context, R.string.pspdf__ok, null), (DialogInterface.OnClickListener) null).show();
            PdfLog.e("Nutri.UriActionExecutor", e2, "Could not find an activity to open " + mediaUri.getUri(), new Object[0]);
        }
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        Context context;
        UriAction uriAction = (UriAction) action;
        if (uriAction.getUri() == null || (context = this.a.getContext()) == null) {
            return false;
        }
        a(context, uriAction);
        return true;
    }
}
