package spring;

/**
 * bean初始化 环绕处理器
 */
public interface BeanPostProcess {
    /**
     * bean初始化 前置处理器
     * @param beanName bean名称
     * @param bean bean对象
     * @return bean对象 或 代理对象
     */
    Object postProcessBeforeInitialization(String beanName, Object bean);

    /**
     * bean初始化 前置处理器
     * @param beanName bean名称
     * @param bean bean对象
     * @return bean对象 或 代理对象
     */
    Object postProcessAfterInitialization(String beanName, Object bean);
}
