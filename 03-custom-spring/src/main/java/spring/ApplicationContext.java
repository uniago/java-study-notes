package spring;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private Class<?> clazz;
    /**
     * bean定义
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    /**
     * 单例池
     */
    private Map<String, Object> singletonObject = new ConcurrentHashMap<>();

    public ApplicationContext(Class<?> clazz) {
        this.clazz = clazz;

        // 扫描
        if (clazz.isAnnotationPresent(ComponentScan.class)) {
            // 获取包路径
            ComponentScan annotation = clazz.getAnnotation(ComponentScan.class);
            String packagePath = annotation.value();
            String path = packagePath.replace(".", "/");
            ClassLoader classLoader = ApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File direction = new File(resource.getPath());
            if (direction.isDirectory()) {
                // 这里只模拟扫描一层
                for (File file : direction.listFiles()) {
                    if (file.getName().endsWith(".class")) {
                        String beanClassName = packagePath + "." + file.getName().replace(".class", "");
                        try {
                            Class<?> aClass = classLoader.loadClass(beanClassName);
                            // 若有Component注解
                            if (aClass.isAnnotationPresent(Component.class)) {
                                Component beanName = aClass.getAnnotation(Component.class);
                                // 存入BeanDefinition
                                BeanDefinition beanDefinition = new BeanDefinition();
                                // 若有scope注解
                                if (aClass.isAnnotationPresent(Scope.class)) {
                                    Scope scopeAnnotation = aClass.getAnnotation(Scope.class);
                                    beanDefinition.setScope(scopeAnnotation.value());
                                } else {
                                    beanDefinition.setScope("singleton");
                                }
                                beanDefinition.setType(aClass);

                                // 保存到map
                                beanDefinitionMap.put(beanName.value(), beanDefinition);
                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }

        }

        // 实例化Bean
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            Object bean = createBean(beanName, beanDefinition);
            if (beanDefinition.getScope().equals("singleton")) {
                // 存入单例池
                singletonObject.put(beanName, bean);
            }
        }
    }

    /**
     * 通过beanDefinition创建Bean
     * @param beanName bean名称
     * @param beanDefinition 定义信息
     * @return bean对象
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> aClass = beanDefinition.getType();
        try {
            // 暂时通过无参构造创建对象
            return aClass.getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取Bean对象
     * @param name bean名称
     * @return bean对象
     */
    public Object getBean(String name) {
        // 通过bean名称找到bean定义
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new NullPointerException("没有找到Bean");
        }
        // 单例
        if (beanDefinition.getScope().equals("singleton")) {
            // 从单例池中获取
            Object o = singletonObject.get(name);
            if (o == null) {
                createBean(name, beanDefinition);
                singletonObject.put(name, beanDefinition);
            }
            return o;
        } else {
            // 多例直接创建
            return createBean(name, beanDefinition);
        }
    }
}
