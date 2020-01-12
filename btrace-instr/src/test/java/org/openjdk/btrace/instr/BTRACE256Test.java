package org.openjdk.btrace.instr;

import org.junit.Test;

/**
 * @author Jaroslav Bachorik
 */
public class BTRACE256Test extends InstrumentorTestBase {
    @Test
    public void bytecodeValidation() throws Exception {
        originalBC = loadTargetClass("issues/BTRACE256");
        transform("issues/BTRACE256");
        checkTransformation(
                "LCONST_0\n" +
                        "LSTORE 1\n" +
                        "INVOKESTATIC java/lang/System.nanoTime ()J\n" +
                        "LSTORE 3\n" +
                        "LDC \"public void resources.issues.BTRACE256#doStuff\"\n" +
                        "INVOKESTATIC resources/issues/BTRACE256.$btrace$org$openjdk$btrace$runtime$aux$BTRACE256$entry (Ljava/lang/String;)V\n" +
                        "INVOKESTATIC java/lang/System.nanoTime ()J\n" +
                        "LLOAD 3\n" +
                        "LSUB\n" +
                        "LSTORE 1\n" +
                        "LDC \"public void resources.issues.BTRACE256#doStuff\"\n" +
                        "LLOAD 1\n" +
                        "INVOKESTATIC resources/issues/BTRACE256.$btrace$org$openjdk$btrace$runtime$aux$BTRACE256$exit (Ljava/lang/String;J)V\n" +
                        "MAXSTACK = 4\n" +
                        "MAXLOCALS = 5\n" +
                        "\n" +
                        "// access flags 0xA\n" +
                        "private static $btrace$org$openjdk$btrace$runtime$aux$BTRACE256$entry(Ljava/lang/String;)V\n" +
                        "@Lorg/openjdk/btrace/core/annotations/OnMethod;(clazz=\"/.*\\\\.BTRACE256/\", method=\"doStuff\")\n" +
                        "// annotable parameter count: 1 (visible)\n" +
                        "@Lorg/openjdk/btrace/core/annotations/ProbeMethodName;(fqn=true) // parameter 0\n" +
                        "TRYCATCHBLOCK L0 L1 L1 java/lang/Throwable\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "INVOKESTATIC org/openjdk/btrace/runtime/BTraceRuntimeAccess.enter (Lorg/openjdk/btrace/core/BTraceRuntime$Impl;)Z\n" +
                        "IFNE L0\n" +
                        "RETURN\n" +
                        "L0\n" +
                        "FRAME SAME\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.swingProfiler : Lorg/openjdk/btrace/core/Profiler;\n" +
                        "ALOAD 0\n" +
                        "INVOKESTATIC org/openjdk/btrace/core/BTraceUtils$Profiling.recordEntry (Lorg/openjdk/btrace/core/Profiler;Ljava/lang/String;)V\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "INVOKEVIRTUAL org/openjdk/btrace/runtime/BTraceRuntimeImplBase.leave ()V\n" +
                        "RETURN\n" +
                        "L1\n" +
                        "FRAME SAME1 java/lang/Throwable\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "DUP_X1\n" +
                        "SWAP\n" +
                        "INVOKEVIRTUAL org/openjdk/btrace/runtime/BTraceRuntimeImplBase.handleException (Ljava/lang/Throwable;)V\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "INVOKEVIRTUAL org/openjdk/btrace/runtime/BTraceRuntimeImplBase.leave ()V\n" +
                        "RETURN\n" +
                        "MAXSTACK = 3\n" +
                        "\n" +
                        "// access flags 0xA\n" +
                        "private static $btrace$org$openjdk$btrace$runtime$aux$BTRACE256$exit(Ljava/lang/String;J)V\n" +
                        "@Lorg/openjdk/btrace/core/annotations/OnMethod;(clazz=\"/.*\\\\.BTRACE256/\", method=\"doStuff\", location=@Lorg/openjdk/btrace/core/annotations/Location;(value=Lorg/openjdk/btrace/core/annotations/Kind;.RETURN))\n" +
                        "// annotable parameter count: 2 (visible)\n" +
                        "@Lorg/openjdk/btrace/core/annotations/ProbeMethodName;(fqn=true) // parameter 0\n" +
                        "@Lorg/openjdk/btrace/core/annotations/Duration;() // parameter 1\n" +
                        "TRYCATCHBLOCK L0 L1 L1 java/lang/Throwable\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "INVOKESTATIC org/openjdk/btrace/runtime/BTraceRuntimeAccess.enter (Lorg/openjdk/btrace/core/BTraceRuntime$Impl;)Z\n" +
                        "IFNE L0\n" +
                        "RETURN\n" +
                        "L0\n" +
                        "FRAME SAME\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.swingProfiler : Lorg/openjdk/btrace/core/Profiler;\n" +
                        "ALOAD 0\n" +
                        "LLOAD 1\n" +
                        "INVOKESTATIC org/openjdk/btrace/core/BTraceUtils$Profiling.recordExit (Lorg/openjdk/btrace/core/Profiler;Ljava/lang/String;J)V\n" +
                        "INVOKESTATIC org/openjdk/btrace/statsd/Statsd.getInstance ()Lorg/openjdk/btrace/statsd/Statsd;\n" +
                        "DUP\n" +
                        "ASTORE 3\n" +
                        "LDC \"my.metric.b\"\n" +
                        "LDC \"regular,distribution:gaussian\"\n" +
                        "INVOKEVIRTUAL org/openjdk/btrace/statsd/Statsd.increment (Ljava/lang/String;Ljava/lang/String;)V\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "INVOKEVIRTUAL org/openjdk/btrace/runtime/BTraceRuntimeImplBase.leave ()V\n" +
                        "RETURN\n" +
                        "L1\n" +
                        "FRAME SAME1 java/lang/Throwable\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "DUP_X1\n" +
                        "SWAP\n" +
                        "INVOKEVIRTUAL org/openjdk/btrace/runtime/BTraceRuntimeImplBase.handleException (Ljava/lang/Throwable;)V\n" +
                        "GETSTATIC org/openjdk/btrace/runtime/aux/BTRACE256.runtime : Lorg/openjdk/btrace/runtime/BTraceRuntimeImplBase;\n" +
                        "INVOKEVIRTUAL org/openjdk/btrace/runtime/BTraceRuntimeImplBase.leave ()V\n" +
                        "RETURN\n" +
                        "MAXSTACK = 4\n" +
                        "MAXLOCALS = 4"
        );
    }
}
