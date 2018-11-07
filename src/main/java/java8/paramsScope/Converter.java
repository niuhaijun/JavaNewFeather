package java8.paramsScope;

@FunctionalInterface
public interface Converter<T1, T2> {

  void convert(int i);
}
