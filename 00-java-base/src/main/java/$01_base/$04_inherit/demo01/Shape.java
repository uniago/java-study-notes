package $01_base.$04_inherit.demo01;

// public sealed class Shape permits Rect, Circle, Triangle {
// }

public class Shape {}

class Rect extends Shape {}

class Ellipse extends Shape {}
// Compile error: class is not allowed to extend sealed class: Shape