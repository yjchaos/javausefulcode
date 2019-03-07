# java�е��쳣�ʹ���
[TOC]
## java�쳣��ṹͼ
![Throwable picture](https://github.com/yjchaos/javausefulcode/blob/master/resources/images/Throwable.png)

java�쳣�඼��java.lang���£����㸸��ΪThrowable����������������Error��Exception��Error���Լ����������ʵ����������JVM����Ĵ��󡣴����ܱ�����Աͨ�����봦��Error���ٳ��֡���ˣ�����ԱӦ�ù�עExceptionΪ����ķ�֧�µĸ����쳣�ࡣ


�Ǽ���쳣��unckecked exception����**Error** �� **RuntimeException** �Լ����ǵ����ࡣjavac�ڱ���ʱ��������ʾ�ͷ����������쳣����Ҫ���ڳ�������Щ�쳣���������Ը�⣬���ǿ��Ա�д���봦��ʹ��try��catch��finally���������쳣��Ҳ���Բ�����������Щ�쳣������Ӧ���������룬������ȥͨ���쳣���������� ���������쳣������ԭ�����Ǵ���д�������⡣���0����**ArithmeticException**�������ǿ������ת������**ClassCastException**����������Խ��**ArrayIndexOutOfBoundsException**��ʹ���˿ն���**NullPointerException**�ȵȡ�

����쳣��checked exception��������**Error** �� **RuntimeException**�������쳣��javacǿ��Ҫ�����ԱΪ�������쳣��Ԥ����������ʹ��try��catch��finally����throws�����ڷ�����Ҫô��try-catch��䲶����������Ҫô��throws�Ӿ������׳�����������벻��ͨ�����������쳣һ�����ɳ�������л������µġ���Ϊ������ܱ������ڸ���δ֪�Ļ����£�������Ա�޷���Ԥ�û����ʹ������д�ĳ������ǳ���Ա��Ӧ��Ϊ�������쳣ʱ��׼���š���**SQLException** , **IOException**,**ClassNotFoundException** �ȡ�

## �쳣����ʽ

#### try��catch��finally����
**try��catch��finally**��������ִ�����̣�

1.ִ��try�����е���䡣�����쳣ִ�в���2�������쳣ִ�в���3
2.ִ��catch���е����
3.ִ��finally�����е����

>`��Ҫ��ʾ��`
>* `try�����з����쳣֮�󣬳����쳣�����֮��Ĵ��벻�ᱻִ��`
>* `finally�����в���Ҫ��return������У�һ��finally���е�return��䱻ִ�У���������д������Ч`
>* `try��������return��������£���return�����Ϊ�쳣δ��ִ��ʱ��finally����������ʻ�ִ�У�Ҫע�����finally����֮��Ĵ���Ҳ�ᱻִ�У�ִ��˳������finally�������ִ�к���Ĵ��룻��return���ִ���ˣ�finally������Ȼ��ִ�У�����ʱfinally����֮��Ĵ��뽫���ᱻִ��`
>* `finally�����е�returnֵ�Ḳ��try�����е�returnֵ`

˳����һ��**try-with-resources**��䣬�κ�ʵ����`java.lang.AutoCloseable`�ӿڵĶ��󣬺�ʵ����`java.io.Closeable`�ӿڵĶ��󣬶����Ե�����Դʹ�á��÷�ʾ����
```java
try (
       FileOutputStream out = new FileOutputStream("output");
       FileInputStream  in1 = new FileInputStream(��input1��);
       FileInputStream  in2 = new FileInputStream(��input2��)
   ) {
       // Do something useful with those 3 streams!
   }  
```
�����Ͳ�����finally��������ֶ��ͷ���Դ��

#### ֱ���׳�
�ڷ����������`throws XXXException`��ֱ���׳��������÷�ȥ�����쳣����������õķ�����û���쳣������ƣ���ô�쳣���ջ��׸�jre������

**���ǿ��һ�㣬����쳣�Ǳ���Ҫ����ģ�������벻��ͨ�������Ǽ���쳣�������ǿ��Բ�����ġ���������һ�����⣬�����ڷ������ֶ��׳�һ���쳣��`throw new XXXException`��ʱ�򣬸÷����Ƿ���Ҫ��`throws XXXException`���𰸵�Ȼ�Ǻ����ֶ��׳����Ǽ���쳣���ǷǼ���쳣�й�ඡ�**
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
�����ﲶ��`ArithmeticException`ʱֱ�������׳������Կ������������沢û�м�`throws ArithmeticException`����Ϊ`ArithmeticException`�Ǹ�����쳣

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
��`FileNotFoundException`��Ȼ����Ϊ���Ǹ�����쳣

## �쳣�е���Ϣ

#### public string getMessage()
`Throwable`���ж���ķ����������쳣����ʱ����ϸ��Ϣ
```java
public String getMessage()
{??? 
    return detailMessage;
}
```

#### public string getLocalizedMessage()
`Throwable`���ж���ķ���
```java
public String getLocalizedMessage() 
{??? 
    return getMessage();
}
```
���Կ������`Throwable`����û����д`getLocalizedMessage`�����Ļ������ķ���ֵ����`getMessage`�ķ���ֵ

#### ?public string toString()
`Throwable`���ж���ķ���
```java
    public String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage();
        return (message != null) ? (s + ": " + message) : s;
    }
```
����bb�ˣ�����Ӧ��д�ú������

#### ?public void printStackTrace()
`Throwable`���ж���ķ��������ڽ��������õĶ�ջ��Ϣ��ӡ������̨
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

#### ��ȡ�������ö�ջ��Ϣ
`printStackTrace`ֻ�ܽ���Ϣ��ӡ������̨��Ȼ�����Ǿ�����Ҫ����Ϣ��ӡ����־�ļ��С����ӡ����־�ļ��������ǵ��ܻ�ȡ����־��Ϣ����ô��β��ܻ�ȡ���������õĶ�ջ��Ϣ�أ��ο�����`printStackTrace`����ʵ�ֵ�Դ����ʵ����ͺ������ˡ�`StackTraceElement[] trace = getOurStackTrace()`����ȡ��`StackTraceElement`�����飬�������飬������ӡ���ɡ�`Throwable`������ͨ��`getOurStackTrace`������ȡ��`StackTraceElement`�����飬����������������޷����ã�������Ҫ���õ���`public StackTraceElement[] getStackTrace()`���÷�����`getOurStackTrace`�����ķ��ؽ�������˿�����˳����һ�£�����Ŀ�����ǳ������Ҳ����˵�ڶ��ڴ���û�з����µĿռ䣬��������һ�����ñ�����֮ǰ������ָ����ͬ�Ķѿռ�
```java
    public StackTraceElement[] getStackTrace() {
        return getOurStackTrace().clone();
    }
```




