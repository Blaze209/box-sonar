package com.pspdfkit.internal;

import android.view.KeyEvent;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public final class gn {
    public final cw a;
    public final PdfActivityConfiguration b;

    public interface a {
        boolean attemptPrinting();

        void navigateNextPage();

        void navigatePreviousPage();

        void showSearchView();
    }

    public gn(cw cwVar, PdfActivityConfiguration pdfActivityConfiguration) {
        pdfActivityConfiguration.getClass();
        this.a = cwVar;
        this.b = pdfActivityConfiguration;
    }

    public final boolean a(KeyEvent keyEvent) {
        keyEvent.getClass();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 24) {
            if (!this.b.isVolumeButtonsNavigationEnabled()) {
                return false;
            }
            if (keyEvent.getAction() == 0) {
                this.a.navigateNextPage();
            }
            return true;
        }
        if (keyCode == 25) {
            if (!this.b.isVolumeButtonsNavigationEnabled()) {
                return false;
            }
            if (keyEvent.getAction() == 0) {
                this.a.navigatePreviousPage();
            }
            return true;
        }
        if (keyCode != 34) {
            if (keyCode == 44) {
                if (!keyEvent.isCtrlPressed()) {
                    return false;
                }
                if (keyEvent.getAction() == 1) {
                    return this.a.attemptPrinting();
                }
                return true;
            }
            if (keyCode != 84) {
                return false;
            }
        }
        if (keyEvent.getKeyCode() == 34 && !keyEvent.isCtrlPressed()) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            this.a.showSearchView();
        }
        return true;
    }
}
