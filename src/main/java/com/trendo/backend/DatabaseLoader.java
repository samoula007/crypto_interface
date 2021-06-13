
package com.trendo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final DataRepository repository;

	@Autowired
	public DatabaseLoader(DataRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new DataGets(DataGets.uuidEth, DataGets.uuidDOGE, DataGets.uuidNEO, DataGets.uuidLINK,
				DataGets.uuidEOS));
	}
}
