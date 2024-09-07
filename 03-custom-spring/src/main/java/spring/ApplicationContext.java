package spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    /**
     * bean处理器
     */
    private List<BeanPostProcess> beanPostProcessList = new ArrayList<>();

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
            // 解析包路径
            if (direction.isDirectory()) {
                // 这里只模拟扫描一层
                for (File file : direction.listFiles()) {
                    if (file.getName().endsWith(".class")) {
                        String beanClassName = packagePath + "." + file.getName().replace(".class", "");
                        try {
                            // 加载class
                            Class<?> aClass = classLoader.loadClass(beanClassName);
                            // 若有Component注解
                            if (aClass.isAnnotationPresent(Component.class)) {
                                // class是由BeanPostProcess派生
                                if (BeanPostProcess.class.isAssignableFrom(aClass)) {
                                    BeanPostProcess instance = (BeanPostProcess)aClass.newInstance();
                                    //添加到处理器容器
                                    beanPostProcessList.add(instance);
                                }

                                Component beanNameAnnotation = aClass.getAnnotation(Component.class);
                                String beanName = beanNameAnnotation.value();
                                if ("".equals(beanName)) {
                                    // 首字母小写
                                    beanName = Introspector.decapitalize(aClass.getSimpleName());
                                }
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
                                beanDefinitionMap.put(beanName, beanDefinition);
                            }
                        } catch (ClassNotFoundException | IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InstantiationException e) {
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
            Object instance = aClass.getConstructor().newInstance();

            // 依赖注入 字段注入
            for (Field field : aClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(AutoWired.class)) {
                    field.setAccessible(true);
                    // 给字段设置bean byName方式
                    field.set(instance, getBean(field.getName()));
                }
            }

            // 执行aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName("Aware beanName:" + beanName);
            }

            // Bean前置处理
            for (BeanPostProcess process : beanPostProcessList) {
                process.postProcessBeforeInitialization(beanName, instance);
            }

            // 执行初始化回调
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }

            // Bean后置处理 AOP
            for (BeanPostProcess process : beanPostProcessList) {
                process.postProcessBeforeInitialization(beanName, instance);
            }


            return instance;
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
