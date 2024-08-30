package $01_base.$10_scope.demo01.xyz;

import $01_base.$10_scope.demo01.abc.Hello;

class Main {
    void foo() {
        // Main可以访问Hello
        Hello h = new Hello();
        h.hi();
    }
}