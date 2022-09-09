package br.com.atox.optionals;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
public class Benchmark {

    @org.openjdk.jmh.annotations.Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public long somaCondicionalSemOptional() {
        long val = 0L;
        for (long i = 0; i < 1_000_000; ++i) {

            Long parcela = null;
            if(i % 2 == 0) {
                parcela = 2L;
            }

            if(null != parcela){
                val += parcela;
            }
        }
        return val;
    }

    @org.openjdk.jmh.annotations.Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public long somaCondicionalComOptional() {
        long val = 0L;
        for (long i = 0; i < 1_000_000; ++i) {

           Optional<Long> parcelaOpcional = Optional.empty();
           if(i % 2 == 0) {
               parcelaOpcional = Optional.of(2L);
           }

           if(parcelaOpcional.isPresent()){
               val += parcelaOpcional.get();
           }
        }
        return val;
    }
}
