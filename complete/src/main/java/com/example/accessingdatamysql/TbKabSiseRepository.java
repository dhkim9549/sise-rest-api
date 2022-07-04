package com.example.accessingdatamysql;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TbKabSiseRepository extends CrudRepository<TbKabSise, Integer> {

	@Query(
                value = "select * from tb_kab_sise where kab_dnji_no = :kabDnjiNo order by pyng_area, pty_type_nm",
                nativeQuery = true
        )
        Iterable<TbKabSise> selectKabSiseNative(@Param("kabDnjiNo") String kabDnjiNo);

}

