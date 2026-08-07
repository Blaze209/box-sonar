package com.amplitude.api;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ConfigManager {
    private static String KEY_INGESTION_ENDPOINT = "ingestionEndpoint";
    private static ConfigManager instance;
    private String ingestionEndpoint = Constants.EVENT_LOG_URL;

    interface RefreshListener {
        void onFinished();
    }

    public String getIngestionEndpoint() {
        return this.ingestionEndpoint;
    }

    private ConfigManager() {
    }

    public void refresh(RefreshListener refreshListener, AmplitudeServerZone amplitudeServerZone) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(AmplitudeServerZone.getDynamicConfigApi(amplitudeServerZone)).openConnection();
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        stringBuffer.append(line);
                    }
                }
                bufferedReader.close();
                JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                if (jSONObject.has(KEY_INGESTION_ENDPOINT)) {
                    this.ingestionEndpoint = AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX + jSONObject.getString(KEY_INGESTION_ENDPOINT);
                }
            }
        } catch (MalformedURLException | IOException | JSONException | Exception unused) {
        }
        refreshListener.onFinished();
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
}
