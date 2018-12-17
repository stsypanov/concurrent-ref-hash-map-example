package tsypanov;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import tsypanov.benchmark.CRHMInstantiation;

public class BenchmarkRunner {

  public static void main(String[] args) throws Exception {
    Options opt = new OptionsBuilder()
            .include(CRHMInstantiation.class.getSimpleName())
            .warmupIterations(10)
            .warmupTime(TimeValue.seconds(1))
            .measurementIterations(10)
            .measurementTime(TimeValue.seconds(1))
            .forks(10) //0 makes debugging possible
            .shouldFailOnError(true)
            .jvmArgsAppend(
//						"-Xint"
//            ,
//            "-XX:TieredStopAtLevel=1"
//            ,
//            "-noverify"
//						,
//						"-XX:+UnlockDiagnosticVMOptions"
//						,
//						"-XX:+PrintCompilation"
//						,
//						"-XX:+PrintInlining"
//						,
//						"-XX:+LogCompilation"
            )
//            .addProfiler(GCProfiler.class)// memory and GC profiler
            .build();

    new Runner(opt).run();
  }
}