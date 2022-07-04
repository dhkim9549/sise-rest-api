package com.example.accessingdatamysql;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TbMapRepository extends CrudRepository<TbMap, Integer> {

	@Query(
		value = "select * from tb_map where stnm_unon_cd = :stnmUnonCd",
		nativeQuery = true
	)
	Iterable<TbMap> selectMapNative(@Param("stnmUnonCd") String stnmUnonCd);

}

