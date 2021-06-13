//package declaration
package com.trendo.backend;

//importing
import org.springframework.data.repository.CrudRepository;

//The repository used for data
public interface DataRepository extends CrudRepository<DataGets, Long> {

}
