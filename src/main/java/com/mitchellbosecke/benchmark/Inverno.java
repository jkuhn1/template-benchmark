package com.mitchellbosecke.benchmark;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import com.mitchellbosecke.benchmark.inverno.Stocks;
import com.mitchellbosecke.benchmark.inverno.Stocks.Renderer;
import com.mitchellbosecke.benchmark.model.Stock;

/**
 * Benchmark for Inverno Reactive Template
 * 
 * https://inverno.io
 * 
 * @author <a href="mailto:jeremy.kuhn@inverno.io">Jeremy Kuhn</a>
 */
public class Inverno extends BaseBenchmark {
	
	private List<Stock> items;
	
	private Renderer<CompletableFuture<String>> stringRenderer;

    @Setup
    public void setup() throws IOException {
        this.items = Stock.dummyItems();
        this.stringRenderer = Stocks.string();
    }

    @Benchmark
    public String benchmark() throws InterruptedException, ExecutionException {
    	return this.stringRenderer.render(this.items).get();
    }
}
