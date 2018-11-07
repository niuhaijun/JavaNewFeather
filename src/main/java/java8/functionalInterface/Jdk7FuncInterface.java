package java8.functionalInterface;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.FileFilter;
import java.lang.reflect.InvocationHandler;
import java.nio.file.PathMatcher;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.swing.event.ChangeListener;
import org.junit.Test;

/**
 * JDK8之前的函数式接口
 *
 * @author niuhaijun
 * @date 2018/9/3 14:18
 */
public class Jdk7FuncInterface {

  /**
   * java.lang.Runnable
   */
  @Test
  public void runnableTest() {
    Runnable runnable = () -> System.out.println("Runnable");
    Thread thread = new Thread(runnable);
    thread.run();
  }

  /**
   * java.util.concurrent.Callable
   */
  @Test
  public void callableTest() throws ExecutionException, InterruptedException {
    Callable<Integer> callable = () -> 1 + 2;
    FutureTask<Integer> futureTask = new FutureTask<>(callable);
    Executor executor = Executors.newSingleThreadExecutor();
    executor.execute(futureTask);
    if (!futureTask.isDone()) {
      System.out.println(futureTask.get());
    }
  }

  /**
   * java.security.PrivilegedAction
   */
  @Test
  public void privilegedActionTest() {
    PrivilegedAction privilegedAction = null;
  }

  /**
   * java.util.Comparator
   */
  @Test
  public void comparatorTest() {
    Comparator<Integer> comparator = Integer::compareTo;
    List<Integer> list = Arrays.asList(3, 2, 1);
    Collections.sort(list, comparator);
    System.out.println(list);
  }


  /**
   * java.io.FileFilter
   */
  @Test
  public void fileFilterTest() {
    FileFilter fileFilter = null;
  }

  /**
   * java.nio.file.PathMatcher
   */
  @Test
  public void pathMatcherTest() {
    PathMatcher pathMatcher = null;
  }

  /**
   * java.lang.reflect.InvocationHandler
   */
  @Test
  public void invocationHandlerTest() {
    InvocationHandler invocationHandler = null;
  }

  /**
   * java.beans.PropertyChangeListener
   */
  @Test
  public void propertyChangeListenerTest() {
    PropertyChangeListener propertyChangeListener = null;
  }

  /**
   * java.awt.event.ActionListener
   */
  @Test
  public void actionListenerTest() {
    ActionListener actionListener = null;
  }

  /**
   * ChangeListener
   */
  @Test
  public void changeListenerTest() {
    ChangeListener changeListener = null;
  }


}
