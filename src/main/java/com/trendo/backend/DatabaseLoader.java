//declaring package
package com.trendo.backend;

//imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//spring component
@Component
public class DatabaseLoader implements CommandLineRunner {

	private final DataRepository repository;

	// repo
	@Autowired
	public DatabaseLoader(DataRepository repository) {
		this.repository = repository;
	}

	// overriding run to save repo
	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new DataGets());
	}
}
