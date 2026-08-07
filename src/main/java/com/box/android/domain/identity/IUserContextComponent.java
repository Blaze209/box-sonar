package com.box.android.domain.identity;

/* JADX INFO: loaded from: classes11.dex */
public interface IUserContextComponent {
    String getContextId();

    void onCreate(String str) throws UserContextComponentCreationException;

    void onHardDestroy();

    void onSoftDestroy();

    public static class UserContextComponentCreationException extends Exception {
        private static final long serialVersionUID = 1;

        public UserContextComponentCreationException(String str) {
            super(str);
        }
    }
}
