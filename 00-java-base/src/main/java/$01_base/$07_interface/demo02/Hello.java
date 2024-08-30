package $01_base.$07_interface.demo02;

interface Hello {
    void hello();
}

interface Person extends Hello {
    void run();
    String getName();
}