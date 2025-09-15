class Foo {
    std::mutex f; // mutex for first function
    std:: mutex s; // mutex for second function
public:
    Foo() {
        // lock the second and third mutexes
        f.lock();
        s.lock();
    }

    void first(function<void()> printFirst) {
        printFirst();
        f.unlock(); // unlock the first mutex, so that the second function can be executed
    }

    void second(function<void()> printSecond) {
        // try to lock the first mutex, but it is already lock,
        // so the thread will wait until the first function is executed, and the first mutex is unlocked
        f.lock();
        printSecond();
        s.unlock(); // unlock the second mutex, so that the third function can be executed
    }

    void third(function<void()> printThird) {
        s.lock();
        printThird();
    }
};