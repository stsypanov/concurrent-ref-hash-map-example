package tsypanov.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@Fork(jvmArgsAppend = {"-XX:+UseParallelGC", "-Xms2g", "-Xmx2g"})
public class CRHMInstantiation {

  @Benchmark
  public Object original() {
    return new tsypanov.map.original.ConcurrentReferenceHashMap();
  }

  @Benchmark
  public Object nonVolatileSegmentReferences() {
    return new tsypanov.map.nonvolatile.ConcurrentReferenceHashMap();
  }

  @Benchmark
  public Object patched() {
    return new tsypanov.map.patched.ConcurrentReferenceHashMap();
  }

}
