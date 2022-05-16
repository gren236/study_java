package exceptiontasks;

public class StackTrace {
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        if (stackTrace.length < 3) return null;

        StackTraceElement caller = stackTrace[2];
        return caller.getClassName() + "#" + caller.getMethodName();
    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
    }
}
