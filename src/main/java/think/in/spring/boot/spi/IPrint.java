package think.in.spring.boot.spi;

public interface IPrint extends ISpi<Integer> {

    default void execute(int level, Object... msg) {
        print(msg.length > 0 ? (String) msg[0] : null);
    }

    void print(String msg);
}
