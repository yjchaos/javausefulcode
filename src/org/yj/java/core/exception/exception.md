## java异常类结构图
![Throwable picture](https://github.com/yjchaos/javausefulcode/blob/master/resources/images/Throwable.png)

java异常类都在java.lang包下，顶层父类为Throwable，派生出两个子类Error和Exception。Error类以及他的子类的实例，代表了JVM本身的错误。错误不能被程序员通过代码处理，Error很少出现。因此，程序员应该关注Exception为父类的分支下的各种异常类。


非检查异常（unckecked exception）：**Error** 和 **RuntimeException** 以及他们的子类。javac在编译时，不会提示和发现这样的异常，不要求在程序处理这些异常。所以如果愿意，我们可以编写代码处理（使用try…catch…finally）这样的异常，也可以不处理。对于这些异常，我们应该修正代码，而不是去通过异常处理器处理 。这样的异常发生的原因多半是代码写的有问题。如除0错误**ArithmeticException**，错误的强制类型转换错误**ClassCastException**，数组索引越界**ArrayIndexOutOfBoundsException**，使用了空对象**NullPointerException**等等。

检查异常（checked exception）：除了**Error** 和 **RuntimeException**的其它异常。javac强制要求程序员为这样的异常做预备处理工作（使用try…catch…finally或者throws）。在方法中要么用try-catch语句捕获它并处理，要么用throws子句声明抛出它，否则编译不会通过。这样的异常一般是由程序的运行环境导致的。因为程序可能被运行在各种未知的环境下，而程序员无法干预用户如何使用他编写的程序，于是程序员就应该为这样的异常时刻准备着。如**SQLException** , **IOException**,**ClassNotFoundException** 等。

## 异常处理方式

#### try…catch…finally语句块
**try…catch…finally**语句块代码的执行流程：

1.执行try语句块中的语句。若有异常执行步骤2，若无异常执行步骤3
2.执行catch块中的语句
3.执行finally语句块中的语句

>`重要提示：`
>* `try语句块中发生异常之后，出现异常的语句之后的代码不会被执行`
>* `finally语句块中不需要有return。如果有，一旦finally块中的return语句被执行，后面的所有代码均无效`
>* `try语句块中有return语句的情况下：若return语句因为异常未被执行时，finally语句块毫无疑问会执行，要注意的是finally语句块之后的代码也会被执行，执行顺序是先finally代码块再执行后面的代码；若return语句执行了，finally语句块依然会执行，但此时finally语句块之后的代码将不会被执行`
>* `finally语句块中的return值会覆盖try语句块中的return值`

顺带提一下**try-with-resources**语句，任何实现了`java.lang.AutoCloseable`接口的对象，和实现了`java.io.Closeable`接口的对象，都可以当做资源使用。用法示例：
```java
try (
       FileOutputStream out = new FileOutputStream("output");
       FileInputStream  in1 = new FileInputStream(“input1”);
       FileInputStream  in2 = new FileInputStream(“input2”)
   ) {
       // Do something useful with those 3 streams!
   }  
```
这样就不用再finally代码快中手动释放资源了

#### 直接抛出
在方法后面加上`throws XXXException`，直接抛出交给调用方去处理异常，若发起调用的方法都没有异常处理机制，那么异常最终会抛给jre来处理

**最后强调一点，检查异常是必须要处理的，否则编译不能通过；而非检查异常代码中是可以不处理的。这就引申出一个问题，当我在方法中手动抛出一个异常即`throw new XXXException`的时候，该方法是否需要加`throws XXXException`，答案当然是和你手动抛出的是检查异常还是非检查异常有关喽。**
```java
    public void testArithmeticException() {
        int i = 0;
        try {
            i = 1 / 0;
        } catch (ArithmeticException e) {
            throw e;
        } finally {
            System.out.println("testArithmeticException finally");
        }
    }
```
方法里捕获到`ArithmeticException`时直接向外抛出，可以看到方法名后面并没有加`throws ArithmeticException`，因为`ArithmeticException`是个检查异常

```java
    public void testIOException() throws FileNotFoundException {
        File file = new File("src/org/yj/java/core/io/directory4Test/english.txt");
        Reader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```
而`FileNotFoundException`则不然，因为它是个检查异常

## 异常中的信息

#### public string getMessage()
`Throwable`类中定义的方法，返回异常发生时的详细信息
```java
public String getMessage()
{    
    return detailMessage;
}
```

#### public string getLocalizedMessage()
`Throwable`类中定义的方法
```java
public String getLocalizedMessage() 
{    
    return getMessage();
}
```
可以看出如果`Throwable`子类没有重写`getLocalizedMessage`方法的话，它的返回值就是`getMessage`的返回值

####  public string toString()
`Throwable`类中定义的方法
```java
    public String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage();
        return (message != null) ? (s + ": " + message) : s;
    }
```
不多bb了，代码应该写得很清楚了

####  public void printStackTrace()
`Throwable`类中定义的方法，用于将方法调用的堆栈信息打印到控制台
```java
    private void printStackTrace(PrintStreamOrWriter s) {
        // Guard against malicious overrides of Throwable.equals by
        // using a Set with identity equality semantics.
        Set<Throwable> dejaVu =
            Collections.newSetFromMap(new IdentityHashMap<Throwable, Boolean>());
        dejaVu.add(this);

        synchronized (s.lock()) {
            // Print our stack trace
            s.println(this);
            StackTraceElement[] trace = getOurStackTrace();
            for (StackTraceElement traceElement : trace)
                s.println("\tat " + traceElement);

            // Print suppressed exceptions, if any
            for (Throwable se : getSuppressed())
                se.printEnclosedStackTrace(s, trace, SUPPRESSED_CAPTION, "\t", dejaVu);

            // Print cause, if any
            Throwable ourCause = getCause();
            if (ourCause != null)
                ourCause.printEnclosedStackTrace(s, trace, CAUSE_CAPTION, "", dejaVu);
        }
    }
```

#### 获取方法调用堆栈信息
`printStackTrace`只能将信息打印到控制台，然而我们经常需要将信息打印到日志文件中。想打印到日志文件首先我们得能获取到日志信息，那么如何才能获取到方法调用的堆栈信息呢？参考上面`printStackTrace`最终实现的源码其实结果就很明朗了。`StackTraceElement[] trace = getOurStackTrace()`，获取到`StackTraceElement`的数组，遍历数组，逐条打印即可。`Throwable`类中是通过`getOurStackTrace`方法获取到`StackTraceElement`的数组，不过这个方法我们无法调用，我们需要调用的是`public StackTraceElement[] getStackTrace()`，该方法对`getOurStackTrace`方法的返回结果进行了拷贝，顺带提一下，这儿的拷贝是浅拷贝，也就是说在堆内存中没有分配新的空间，而是增加一个引用变量和之前的引用指向相同的堆空间
```java
    public StackTraceElement[] getStackTrace() {
        return getOurStackTrace().clone();
    }
```




