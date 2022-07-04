package com.example.accessingdatamysql;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TbEhprRepository extends CrudRepository<TbEhpr, Integer> {

        @Query(
                value = "select * from tb_ehpr where lwdg_cd = :lwdgCd and ltno_bno = :ltnoBno and ltno_buno = :ltnoBuno ",
                nativeQuery = true
        )
        Iterable<TbEhpr> selectEhprNative(@Param("lwdgCd") String lwdgCd, @Param("ltnoBno") String ltnoBno, @Param("ltnoBuno") String ltnoBuno);

}

