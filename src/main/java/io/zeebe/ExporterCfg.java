package io.zeebe;

import io.zeebe.broker.system.configuration.BrokerCfg;
import io.zeebe.broker.system.configuration.ConfigurationUtil;
import io.zeebe.util.Environment;
import java.util.Map;

/**
 * Exporter component configuration. To be expanded eventually to allow enabling/disabling
 * exporters, and other general configuration.
 */
public class ExporterCfg {
    /** locally unique ID of the exporter */
    private String id;

    /**
     * path to the JAR file containing the exporter class
     *
     * <p>optional field: if missing, will lookup the class in the zeebe classpath
     */
    private String jarPath;

    /** fully qualified class name pointing to the class implementing the exporter interface */
    private String className;

    /** map of arguments to use when instantiating the exporter */
    private Map<String, Object> args;

    public void init(BrokerCfg globalConfig, String brokerBase, Environment environment) {
        if (isExternal()) {
            jarPath = ConfigurationUtil.toAbsolutePath(jarPath, brokerBase);
        }
    }

    public boolean isExternal() {
        return !isEmpty(jarPath);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }

    private boolean isEmpty(final String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public String toString() {
        return "ExporterCfg{"
                + "id='"
                + id
                + '\''
                + ", jarPath='"
                + jarPath
                + '\''
                + ", className='"
                + className
                + '\''
                + ", args="
                + args
                + '}';
    }
}
