package $01_base.$10_scope.demo04.xyz;

class Main {
    void foo() {
        // 不同包不能访问package权限的类:
        // Hello h = new Hello();
        // 不同包不能调用package权限的方法:
        // h.hi();
    }
}