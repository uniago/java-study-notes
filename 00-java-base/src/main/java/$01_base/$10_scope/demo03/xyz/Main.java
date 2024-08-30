package $01_base.$10_scope.demo03.xyz;

import $01_base.$10_scope.demo01.abc.Hello;

class Main extends Hello {
    void foo() {
        // 可以访问protected方法:
        hi();
    }
}