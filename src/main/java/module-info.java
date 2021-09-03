@io.inverno.core.annotation.Module
module com.mitchellbosecke.benchmark {
	requires io.inverno.core;
    requires io.inverno.mod.irt;
    
    requires jmh.core;
    
    requires freemarker; // Freemarker
    requires compiler; // Mustache
    requires io.pebbletemplates; // Pebble
    requires rocker.runtime; // Rocker
    requires thymeleaf; // Thumeleaf
    requires trimou.core; // Trimou
    requires velocity; // Velocity
	
    exports com.mitchellbosecke.benchmark;
    exports com.mitchellbosecke.benchmark.model;
    exports templates;
    
    opens com.mitchellbosecke.benchmark to compiler;
}