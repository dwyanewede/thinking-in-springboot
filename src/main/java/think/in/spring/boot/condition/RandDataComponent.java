package think.in.spring.boot.condition;

import java.util.function.Supplier;

public class RandDataComponent<T> {
    private Supplier<T> rand;

    public RandDataComponent(Supplier<T> rand) {
        this.rand = rand;
    }

    public T rand() {
        return rand.get();
    }
}