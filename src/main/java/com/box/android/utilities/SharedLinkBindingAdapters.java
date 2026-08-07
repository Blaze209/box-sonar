package com.box.android.utilities;

import android.widget.TextView;
import com.box.android.R;
import com.box.android.usx.fragments.UsxFragment;
import com.box.androidsdk.content.models.BoxSharedLink;

/* JADX INFO: loaded from: classes13.dex */
public class SharedLinkBindingAdapters {
    public static void onLinkClick(boolean z, UsxFragment.UsxNotifiers usxNotifiers) {
        if (z) {
            usxNotifiers.linkClicked();
        }
    }

    public static void onSharedLinkToggle(boolean z, BoxSharedLink boxSharedLink, UsxFragment.UsxNotifiers usxNotifiers) {
        if (z && boxSharedLink == null) {
            usxNotifiers.notifyShare();
        } else {
            if (z || boxSharedLink == null) {
                return;
            }
            usxNotifiers.notifyUnshare();
        }
    }

    public static void setAccess(TextView textView, BoxSharedLink boxSharedLink) {
        String string = "";
        if (boxSharedLink != null) {
            BoxSharedLink.Access effectiveAccess = boxSharedLink.getEffectiveAccess();
            if (effectiveAccess != null) {
                int i = AnonymousClass1.$SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[effectiveAccess.ordinal()];
                if (i == 1) {
                    string = textView.getResources().getString(R.string.box_sharesdk_accessible_public);
                } else if (i == 2) {
                    textView.setText(textView.getResources().getString(R.string.box_sharesdk_accessible_collaborator));
                    return;
                } else if (i == 3) {
                    string = textView.getResources().getString(R.string.box_sharesdk_accessible_company);
                }
            }
            if (!string.isEmpty()) {
                string = string + "\n";
            }
            if (boxSharedLink.getEffectivePermission() != null && boxSharedLink.getEffectivePermission().canEdit()) {
                string = string + textView.getResources().getString(R.string.box_sharesdk_edit_allowed);
            } else if (boxSharedLink.getEffectivePermission() != null && boxSharedLink.getEffectivePermission().canDownload()) {
                string = string + textView.getResources().getString(R.string.box_sharesdk_downloads_allowed);
            } else {
                string = string + textView.getResources().getString(R.string.box_sharesdk_downloads_disabled);
            }
        }
        textView.setText(string);
    }

    /* JADX INFO: renamed from: com.box.android.utilities.SharedLinkBindingAdapters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access;

        static {
            int[] iArr = new int[BoxSharedLink.Access.values().length];
            $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access = iArr;
            try {
                iArr[BoxSharedLink.Access.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[BoxSharedLink.Access.COLLABORATORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[BoxSharedLink.Access.COMPANY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[BoxSharedLink.Access.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
