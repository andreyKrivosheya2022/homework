package logging_system.company.logger;

import java.io.InputStream;

public abstract class ConfigurationLoader {

    abstract public Configuration load(InputStream path);
}
