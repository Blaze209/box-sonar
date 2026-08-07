package com.callstack.reactnativebrownfield;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.callstack.reactnativebrownfield.constants.ReactNativeFragmentArgNames;
import com.facebook.react.ReactDelegate;
import com.facebook.react.ReactFragment;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J+\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0002\u0010!J \u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\nH\u0016J-\u0010'\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/callstack/reactnativebrownfield/ReactNativeFragment;", "Lcom/facebook/react/ReactFragment;", "Lcom/facebook/react/modules/core/PermissionAwareActivity;", "<init>", "()V", "permissionsCallback", "Lcom/facebook/react/bridge/Callback;", "permissionListener", "Lcom/facebook/react/modules/core/PermissionListener;", "moduleName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "()Lcom/facebook/react/ReactHost;", "onResume", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "checkPermission", "permission", "pid", "uid", "checkSelfPermission", "requestPermissions", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "([Ljava/lang/String;ILcom/facebook/react/modules/core/PermissionListener;)V", "Companion", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeFragment extends ReactFragment implements PermissionAwareActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String moduleName;
    private PermissionListener permissionListener;
    private Callback permissionsCallback;

    @JvmStatic
    public static final ReactNativeFragment createReactNativeFragment(String str) {
        return INSTANCE.createReactNativeFragment(str);
    }

    @JvmStatic
    public static final ReactNativeFragment createReactNativeFragment(String str, Bundle bundle) {
        return INSTANCE.createReactNativeFragment(str, bundle);
    }

    @JvmStatic
    public static final ReactNativeFragment createReactNativeFragment(String str, WritableMap writableMap) {
        return INSTANCE.createReactNativeFragment(str, writableMap);
    }

    @JvmStatic
    public static final ReactNativeFragment createReactNativeFragment(String str, HashMap<String, ?> map) {
        return INSTANCE.createReactNativeFragment(str, map);
    }

    @Override // com.facebook.react.ReactFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
        } catch (IllegalStateException e) {
            Log.w("ReactNativeFragment", "ReactFragment threw due to missing arg_component_name: " + e.getMessage() + " - This is an expected behaviour.");
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ReactNativeFragmentArgNames.ARG_MODULE_NAME) : null;
        Intrinsics.checkNotNull(string);
        this.moduleName = string;
        FragmentActivity activity = getActivity();
        ReactHost reactHost = getReactHost();
        String str = this.moduleName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moduleName");
            str = null;
        }
        Bundle arguments2 = getArguments();
        setReactDelegate(new ReactDelegateWrapper(activity, reactHost, str, arguments2 != null ? arguments2.getBundle(ReactNativeFragmentArgNames.ARG_LAUNCH_OPTIONS) : null));
    }

    @Override // com.facebook.react.ReactFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ReactNativeBrownfield shared = ReactNativeBrownfield.INSTANCE.getShared();
        FragmentActivity activity = getActivity();
        String str = this.moduleName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moduleName");
            str = null;
        }
        ReactDelegate reactDelegate = getReactDelegate();
        Intrinsics.checkNotNull(reactDelegate, "null cannot be cast to non-null type com.callstack.reactnativebrownfield.ReactDelegateWrapper");
        return ReactNativeBrownfield.createView$default(shared, activity, str, (ReactDelegateWrapper) reactDelegate, null, 8, null);
    }

    @Override // com.facebook.react.ReactFragment
    protected ReactHost getReactHost() {
        return ReactNativeBrownfield.INSTANCE.getShared().getReactHost();
    }

    @Override // com.facebook.react.ReactFragment, androidx.fragment.app.Fragment
    public void onResume() {
        try {
            super.onResume();
        } catch (ClassCastException unused) {
            ReactDelegate reactDelegate = getReactDelegate();
            Intrinsics.checkNotNull(reactDelegate, "null cannot be cast to non-null type com.callstack.reactnativebrownfield.ReactDelegateWrapper");
            ((ReactDelegateWrapper) reactDelegate).onReactHostResume();
        }
    }

    @Override // com.facebook.react.ReactFragment, androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(final int requestCode, final String[] permissions, final int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        this.permissionsCallback = new Callback() { // from class: com.callstack.reactnativebrownfield.ReactNativeFragment$$ExternalSyntheticLambda0
            @Override // com.facebook.react.bridge.Callback
            public final void invoke(Object[] objArr) {
                ReactNativeFragment.onRequestPermissionsResult$lambda$0(this.f$0, requestCode, permissions, grantResults, objArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestPermissionsResult$lambda$0(ReactNativeFragment reactNativeFragment, int i, String[] strArr, int[] iArr, Object[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PermissionListener permissionListener = reactNativeFragment.permissionListener;
        if (permissionListener != null) {
            if (permissionListener != null) {
                permissionListener.onRequestPermissionsResult(i, strArr, iArr);
            }
            reactNativeFragment.permissionListener = null;
        }
    }

    @Override // com.facebook.react.ReactFragment, com.facebook.react.modules.core.PermissionAwareActivity
    public int checkPermission(String permission, int pid, int uid) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return requireActivity().checkPermission(permission, pid, uid);
    }

    @Override // com.facebook.react.ReactFragment, com.facebook.react.modules.core.PermissionAwareActivity
    public int checkSelfPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return requireActivity().checkSelfPermission(permission);
    }

    @Override // com.facebook.react.ReactFragment, com.facebook.react.modules.core.PermissionAwareActivity
    public void requestPermissions(String[] permissions, int requestCode, PermissionListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissionListener = listener;
        requestPermissions(permissions, requestCode);
    }

    /* JADX INFO: compiled from: ReactNativeFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030\nj\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u0003`\u000bH\u0007J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/callstack/reactnativebrownfield/ReactNativeFragment$Companion;", "", "<init>", "()V", "createReactNativeFragment", "Lcom/callstack/reactnativebrownfield/ReactNativeFragment;", "moduleName", "", "initialProps", "Landroid/os/Bundle;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lcom/facebook/react/bridge/WritableMap;", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ReactNativeFragment createReactNativeFragment(String moduleName) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            return createReactNativeFragment$default(this, moduleName, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ ReactNativeFragment createReactNativeFragment$default(Companion companion, String str, Bundle bundle, int i, Object obj) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            return companion.createReactNativeFragment(str, bundle);
        }

        @JvmStatic
        public final ReactNativeFragment createReactNativeFragment(String moduleName, Bundle initialProps) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            ReactNativeFragment reactNativeFragment = new ReactNativeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ReactNativeFragmentArgNames.ARG_MODULE_NAME, moduleName);
            if (initialProps != null) {
                bundle.putBundle(ReactNativeFragmentArgNames.ARG_LAUNCH_OPTIONS, initialProps);
            }
            reactNativeFragment.setArguments(bundle);
            return reactNativeFragment;
        }

        @JvmStatic
        public final ReactNativeFragment createReactNativeFragment(String moduleName, HashMap<String, ?> initialProps) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Intrinsics.checkNotNullParameter(initialProps, "initialProps");
            return createReactNativeFragment(moduleName, PropsBundle.INSTANCE.fromHashMap(initialProps));
        }

        @JvmStatic
        public final ReactNativeFragment createReactNativeFragment(String moduleName, WritableMap initialProps) {
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Intrinsics.checkNotNullParameter(initialProps, "initialProps");
            return createReactNativeFragment(moduleName, (HashMap<String, ?>) initialProps.toHashMap());
        }
    }
}
