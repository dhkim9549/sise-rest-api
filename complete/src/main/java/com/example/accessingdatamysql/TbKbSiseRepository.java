package com.example.accessingdatamysql;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TbKbSiseRepository extends CrudRepository<TbKbSise, Integer> {

	@Query(
		value = "select * from tb_kb_sise where kb_hs_dstg_no = :kbHsDstgNo order by pyng_area, pty_type_nm",
		nativeQuery = true
	)
	Iterable<TbKbSise> selectKbSiseNative(@Param("kbHsDstgNo") String kbHsDstgNo);

}

