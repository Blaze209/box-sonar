package com.pspdfkit.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.sharing.DefaultDocumentSharingController;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.document.sharing.ShareAction;
import com.pspdfkit.document.sharing.ShareTarget;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.actionmenu.SharingMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class s4 extends Fragment implements SharingMenu.SharingMenuListener {
    public static final /* synthetic */ int e = 0;
    public PdfFragment a;
    public Annotation b;
    public SharingMenu c;
    public DefaultDocumentSharingController d;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            a = iArr;
            try {
                iArr[AnnotationType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AnnotationType.SOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AnnotationType.STAMP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AnnotationType.FREETEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AnnotationType.NOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public s4() {
        if (getParentFragment() == null) {
            setRetainInstance(true);
        }
    }

    public final void a() {
        Context context = getContext();
        if (context == null || getActivity() == null || this.a == null || this.b == null) {
            return;
        }
        SharingMenu sharingMenu = new SharingMenu(getActivity(), this);
        int i = a.a[this.b.getType().ordinal()];
        if (i == 1) {
            EmbeddedFile file = ((FileAnnotation) this.b).getFile();
            if (file == null) {
                return;
            }
            sharingMenu.setTitle(file.getFileName());
            sharingMenu.setSharedFileName(file.getFileName());
            ArrayList arrayList = new ArrayList();
            ShareAction shareAction = ShareAction.VIEW;
            Intent shareIntent = DocumentSharingIntentHelper.getShareIntent(context, shareAction, file.getFileName());
            if (shareIntent != null) {
                shareIntent.setPackage(context.getPackageName());
                arrayList.add(shareIntent);
            }
            arrayList.add(DocumentSharingIntentHelper.getShareIntent(context, shareAction, file.getFileName()));
            arrayList.add(DocumentSharingIntentHelper.getShareIntent(context, ShareAction.SEND, file.getFileName()));
            sharingMenu.setShareIntents(arrayList);
        } else if (i == 2) {
            Annotation annotation = this.b;
            float f = ww.a;
            annotation.getClass();
            String strReplaceAll = ww.a(context, annotation, true).concat(".wav").replaceAll("[:\\\\/*\"?|<>']", "");
            sharingMenu.setSharedFileName(strReplaceAll);
            sharingMenu.setShareIntents(Arrays.asList(DocumentSharingIntentHelper.getShareIntent(context, ShareAction.VIEW, strReplaceAll), DocumentSharingIntentHelper.getShareIntent(context, ShareAction.SEND, strReplaceAll)));
        } else if (i == 3) {
            StampAnnotation stampAnnotation = (StampAnnotation) this.b;
            if (stampAnnotation.getBitmap() == null) {
                return;
            }
            String strReplaceAll2 = ww.a(context, (Annotation) stampAnnotation, true).concat(".jpg").replaceAll("[:\\\\/*\"?|<>']", "");
            sharingMenu.setSharedFileName(strReplaceAll2);
            sharingMenu.setShareIntents(Arrays.asList(DocumentSharingIntentHelper.getShareIntent(context, ShareAction.VIEW, strReplaceAll2), DocumentSharingIntentHelper.getShareIntent(context, ShareAction.SEND, strReplaceAll2)));
        } else if (i == 4 || i == 5) {
            String contents = this.b.getContents();
            if (TextUtils.isEmpty(contents)) {
                return;
            } else {
                sharingMenu.setShareIntents(Collections.singletonList(DocumentSharingIntentHelper.getShareTextIntent(contents)));
            }
        }
        this.c = sharingMenu;
        sharingMenu.show();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.a = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        SharingMenu sharingMenu = this.c;
        if (sharingMenu != null) {
            sharingMenu.onDetach();
        }
        DefaultDocumentSharingController defaultDocumentSharingController = this.d;
        if (defaultDocumentSharingController != null) {
            defaultDocumentSharingController.onDetach();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (getActivity() == null) {
            return;
        }
        SharingMenu sharingMenu = this.c;
        if (sharingMenu != null) {
            sharingMenu.onAttach(getActivity());
        }
        DefaultDocumentSharingController defaultDocumentSharingController = this.d;
        if (defaultDocumentSharingController != null) {
            defaultDocumentSharingController.onAttach(getActivity());
        }
    }

    @Override // com.pspdfkit.ui.actionmenu.SharingMenu.SharingMenuListener
    public final void performShare(ShareTarget shareTarget) {
        Annotation annotation;
        if (getActivity() == null || (annotation = this.b) == null) {
            return;
        }
        int i = a.a[annotation.getType().ordinal()];
        if (i == 1) {
            EmbeddedFile file = ((FileAnnotation) this.b).getFile();
            if (file == null) {
                return;
            }
            DefaultDocumentSharingController defaultDocumentSharingController = new DefaultDocumentSharingController(getActivity(), shareTarget);
            this.d = defaultDocumentSharingController;
            DocumentSharingManager.shareEmbeddedFile(file, defaultDocumentSharingController);
            return;
        }
        if (i == 2) {
            SoundAnnotation soundAnnotation = (SoundAnnotation) this.b;
            DefaultDocumentSharingController defaultDocumentSharingController2 = new DefaultDocumentSharingController(getActivity(), shareTarget);
            this.d = defaultDocumentSharingController2;
            DocumentSharingManager.shareSoundAnnotation(soundAnnotation, defaultDocumentSharingController2);
            return;
        }
        if (i == 3) {
            Bitmap bitmap = ((StampAnnotation) this.b).getBitmap();
            if (bitmap == null) {
                return;
            }
            DefaultDocumentSharingController defaultDocumentSharingController3 = new DefaultDocumentSharingController(getActivity(), shareTarget);
            this.d = defaultDocumentSharingController3;
            DocumentSharingManager.shareBitmap(bitmap, defaultDocumentSharingController3);
            return;
        }
        if (i == 4 || i == 5) {
            String contents = this.b.getContents();
            if (TextUtils.isEmpty(contents)) {
                return;
            }
            Intent shareTextIntent = DocumentSharingIntentHelper.getShareTextIntent(contents);
            shareTextIntent.setPackage(shareTarget.getPackageName());
            startActivity(shareTextIntent);
        }
    }
}
