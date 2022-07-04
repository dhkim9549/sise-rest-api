package com.example.accessingdatamysql;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TbOlprRepository extends CrudRepository<TbOlpr, Integer> {

        @Query(
                value = "select * from tb_olpr where twprc_dnji_no = :twprcDnjiNo ",
                nativeQuery = true
        )
        Iterable<TbOlpr> selectOlprNative(@Param("twprcDnjiNo") String twprcDnjiNo);

}

