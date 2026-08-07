package org.tinylog.writers;

import com.box.androidsdk.content.BoxApiMetadata;
import com.box.androidsdk.content.models.BoxSimpleMessage;
import com.microsoft.identity.client.internal.MsalUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.tinylog.Level;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.pattern.FormatPatternParser;
import org.tinylog.pattern.Token;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class JdbcWriter extends AbstractWriter {
    private static final String FIELD_PREFIX = "field.";
    private static final long MAX_BATCH_SIZE = 100;
    private static final long MIN_RETRY_INTERVAL = 1000;
    private final boolean batch;
    private Connection connection;
    private final List<LogEntry> entries;
    private long lostCount;
    private final Object mutex;
    private final String password;
    private final boolean reconnect;
    private long reconnectTimestamp;
    private final String sql;
    private PreparedStatement statement;
    private final List<Token> tokens;
    private final String url;
    private final String user;

    public JdbcWriter() throws SQLException, NamingException {
        this(Collections.emptyMap());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
    public JdbcWriter(Map<String, String> map) throws SQLException, NamingException {
        super(map);
        String url = getUrl();
        this.url = url;
        String stringValue = getStringValue("user");
        this.user = stringValue;
        String stringValue2 = getStringValue("password");
        this.password = stringValue2;
        this.reconnect = getBooleanValue(BoxSimpleMessage.MESSAGE_RECONNECT);
        this.batch = getBooleanValue("batch");
        this.mutex = getBooleanValue("writingthread") ? null : new Object();
        this.entries = new ArrayList();
        Connection connectionConnect = connect(url, stringValue, stringValue2);
        this.connection = connectionConnect;
        String strRenderSql = renderSql(map, connectionConnect.getMetaData().getIdentifierQuoteString());
        this.sql = strRenderSql;
        this.statement = this.connection.prepareStatement(strRenderSql);
        this.tokens = createTokens(map);
    }

    @Override // org.tinylog.writers.Writer
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        EnumSet enumSetNoneOf = EnumSet.noneOf(LogEntryValue.class);
        Iterator<Token> it = this.tokens.iterator();
        while (it.hasNext()) {
            enumSetNoneOf.addAll(it.next().getRequiredLogEntryValues());
        }
        return enumSetNoneOf;
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws SQLException {
        Object obj = this.mutex;
        if (obj == null) {
            doWrite(logEntry);
        } else {
            synchronized (obj) {
                doWrite(logEntry);
            }
        }
    }

    @Override // org.tinylog.writers.Writer
    public void flush() throws SQLException {
        if (this.batch) {
            Object obj = this.mutex;
            if (obj == null) {
                doFlush();
            } else {
                synchronized (obj) {
                    doFlush();
                }
            }
        }
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws SQLException {
        Object obj = this.mutex;
        if (obj == null) {
            doClose();
        } else {
            synchronized (obj) {
                doClose();
            }
        }
    }

    private void doWrite(LogEntry logEntry) throws SQLException {
        if (checkConnection()) {
            if (this.batch) {
                this.entries.add(logEntry);
            }
            try {
                applyLogEntry(logEntry);
                try {
                    if (this.batch) {
                        this.statement.addBatch();
                        if (this.entries.size() >= 100) {
                            this.statement.executeBatch();
                            this.entries.clear();
                            return;
                        }
                        return;
                    }
                    this.statement.executeUpdate();
                    return;
                } catch (SQLException e) {
                    resetConnection();
                    throw e;
                }
            } catch (SQLException e2) {
                resetConnection();
                throw e2;
            }
        }
        if (this.batch && this.entries.size() < 100) {
            this.entries.add(logEntry);
        } else {
            this.lostCount++;
        }
    }

    private void doFlush() throws SQLException {
        if (this.entries.size() > 0) {
            try {
                this.statement.executeBatch();
                this.entries.clear();
            } catch (SQLException e) {
                resetConnection();
                throw e;
            }
        }
    }

    private void doClose() throws SQLException {
        try {
            if (this.batch) {
                doFlush();
            }
        } finally {
            if (!this.entries.isEmpty()) {
                this.lostCount += (long) this.entries.size();
            }
            if (this.lostCount > 0) {
                InternalLogger.log(Level.ERROR, "Lost log entries due to broken database connection: " + this.lostCount);
            }
            Connection connection = this.connection;
            if (connection != null) {
                connection.close();
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
    private boolean checkConnection() {
        if (this.connection != null) {
            return true;
        }
        if (System.currentTimeMillis() >= this.reconnectTimestamp) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                Connection connectionConnect = connect(this.url, this.user, this.password);
                this.connection = connectionConnect;
                this.statement = connectionConnect.prepareStatement(this.sql);
                if (!this.entries.isEmpty()) {
                    Iterator<LogEntry> it = this.entries.iterator();
                    while (it.hasNext()) {
                        applyLogEntry(it.next());
                        this.statement.addBatch();
                    }
                    this.statement.executeBatch();
                    this.entries.clear();
                }
                if (this.lostCount > 0) {
                    InternalLogger.log(Level.ERROR, "Lost log entries due to broken database connection: " + this.lostCount);
                    this.lostCount = 0L;
                }
                return true;
            } catch (NamingException unused) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                this.reconnectTimestamp = jCurrentTimeMillis2 + Math.max(1000L, (jCurrentTimeMillis2 - jCurrentTimeMillis) * 2);
                closeConnectionSilently();
            } catch (SQLException unused2) {
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                this.reconnectTimestamp = jCurrentTimeMillis3 + Math.max(1000L, (jCurrentTimeMillis3 - jCurrentTimeMillis) * 2);
                closeConnectionSilently();
                return false;
            }
        }
        return false;
    }

    private void resetConnection() {
        if (this.reconnect) {
            closeConnectionSilently();
            this.statement = null;
            this.lostCount = this.batch ? 0L : 1L;
            this.reconnectTimestamp = 0L;
        }
    }

    private void closeConnectionSilently() {
        Connection connection = this.connection;
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException unused) {
            } finally {
                this.connection = null;
            }
        }
    }

    private void applyLogEntry(LogEntry logEntry) throws SQLException {
        int i = 0;
        while (i < this.tokens.size()) {
            i++;
            this.tokens.get(i).apply(logEntry, this.statement, i);
        }
    }

    private static Connection connect(String str, String str2, String str3) throws SQLException, NamingException {
        if (!str.toLowerCase(Locale.ROOT).startsWith("java:")) {
            if (str2 == null) {
                return DriverManager.getConnection(str);
            }
            return DriverManager.getConnection(str, str2, str3);
        }
        DataSource dataSource = (DataSource) new InitialContext().lookup(str);
        if (str2 == null) {
            return dataSource.getConnection();
        }
        return dataSource.getConnection(str2, str3);
    }

    private String getUrl() {
        String stringValue = getStringValue("url");
        if (stringValue != null) {
            return stringValue;
        }
        throw new IllegalArgumentException("URL is missing for JDBC writer");
    }

    private static String getTable(Map<String, String> map) {
        String str = map.get("table");
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Name of database table is missing for JDBC writer");
    }

    private static String renderSql(Map<String, String> map, String str) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        if (map.get(BoxApiMetadata.BOX_API_METADATA_SCHEMA) != null) {
            append(sb, map.get(BoxApiMetadata.BOX_API_METADATA_SCHEMA), str);
            sb.append(".");
        }
        append(sb, getTable(map), str);
        sb.append(" (");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.toLowerCase(Locale.ROOT).startsWith(FIELD_PREFIX)) {
                String strSubstring = key.substring(FIELD_PREFIX.length());
                int i2 = i + 1;
                if (i != 0) {
                    sb.append(", ");
                }
                append(sb, strSubstring, str);
                i = i2;
            }
        }
        sb.append(") VALUES (");
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb.append(", ?");
            } else {
                sb.append(MsalUtils.QUERY_STRING_SYMBOL);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private static void append(StringBuilder sb, String str, String str2) throws SQLException {
        if (str.indexOf(10) >= 0 || str.indexOf(13) >= 0) {
            throw new SQLException("Identifier contains line breaks: " + str);
        }
        if (" ".equals(str2)) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_' && cCharAt != '@' && cCharAt != '$' && cCharAt != '#') {
                    throw new SQLException("Illegal identifier: " + str);
                }
            }
            sb.append(str);
            return;
        }
        sb.append(str2).append(str.replace(str2, str2 + str2)).append(str2);
    }

    private static List<Token> createTokens(Map<String, String> map) {
        FormatPatternParser formatPatternParser = new FormatPatternParser(map.get("exception"));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().toLowerCase(Locale.ROOT).startsWith(FIELD_PREFIX)) {
                arrayList.add(formatPatternParser.parse(entry.getValue()));
            }
        }
        return arrayList;
    }
}
