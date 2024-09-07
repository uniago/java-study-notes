package spring;

public class BeanDefinition {

    /**
     * class 完全限定名
     */
    private Class<?> type;

    /**
     * scope 范围
     */
    private String scope;

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
