package game.board;

public interface Converter<T, V> {
    T read(V v);
}
