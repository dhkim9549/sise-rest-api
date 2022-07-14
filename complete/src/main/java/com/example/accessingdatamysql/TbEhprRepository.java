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

	@Query(
                value = "select a.* "
			+ "  from tb_ehpr a, "
			+ "       tb_addr b "
			+ " where a.lwdg_cd = b.lwdg_cd "
			+ "   and a.ltno_bno = lpad(b.ltno_bno, 4, '0') "
			+ "   and a.ltno_buno = lpad(b.ltno_buno, 4, '0') "
			+ "   and b.stnm = :stnm "
			+ "   and b.bldg_bno = :bldgBno "
			+ "   and b.bldg_buno = :bldgBuno ",
                nativeQuery = true
        )
        Iterable<TbEhpr> selectEhprNative2(@Param("stnm") String stnm, @Param("bldgBno") String bldgBno, @Param("bldgBuno") String bldgBuno);

}

