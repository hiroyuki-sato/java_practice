import com.google.common.base.Optional;
import com.google.common.base.Throwables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.util.Locale.ENGLISH;

public abstract class AbstractJdbcConnectionConfig
{
    public abstract String host();

    public abstract int port();

    public abstract boolean ssl();

    public abstract String user();

    public abstract Optional<String> password();

    public abstract String database();

//    public abstract DurationParam connectTimeout();

//    public abstract DurationParam socketTimeout();

    public abstract int connectTimeout();

    public abstract int socketTimeout();

    public abstract String jdbcProtocolName();

    public abstract String jdbcDriverName();

    public abstract Properties buildProperties();

    public String url()
    {
        return String.format(ENGLISH, "jdbc:%s://%s:%d/%s", jdbcProtocolName(), host(), port(), database());
    }

    public Connection openConnection()
    {
        try {
            Class.forName(jdbcDriverName());
        }
        catch (ClassNotFoundException e) {
            throw Throwables.propagate(e);
        }

        try {
            return DriverManager.getConnection(url(), buildProperties());
        }
        catch (SQLException ex) {
            throw new RuntimeException("Failed to connect to the database", ex);
        }
    }
}
