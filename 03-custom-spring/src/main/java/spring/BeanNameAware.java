package spring;

/**
 * 给bean设置名称的回调
 */
public interface BeanNameAware {
    void setBeanName(String beanName);
}
