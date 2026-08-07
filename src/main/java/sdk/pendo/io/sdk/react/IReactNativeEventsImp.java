package sdk.pendo.io.sdk.react;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H&J&\u0010\f\u001a\u00020\u00032\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/sdk/react/IReactNativeEventsImp;", "", "newScreenIdentified", "", "rnScreenName", "", "rnRootTags", "", "", "rnInfo", "", "clickableElementsArray", "sendFailureInfo", "errorMap", "shouldSendErrorToBE", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IReactNativeEventsImp {
    void newScreenIdentified(String rnScreenName, List<Integer> rnRootTags, Map<String, ? extends Object> rnInfo, List<? extends Object> clickableElementsArray);

    void sendFailureInfo(Map<String, ? extends Object> errorMap, boolean shouldSendErrorToBE);
}
