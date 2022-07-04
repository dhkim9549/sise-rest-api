package com.example.accessingdatamysql;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TbAddrRepository extends CrudRepository<TbAddr, String> {

        @Query(
                value = "select a.* from tb_addr a where a.lwdg_cd = :lwdgCd and a.sggu_bldg_nm like %:sgguBldgNm%"
			+ " and exists (select 1 from tb_map b where b.stnm_unon_cd = a.stnm_unon_cd) ",
                nativeQuery = true
        )
        Iterable<TbAddr> selectAddrNative(@Param("lwdgCd") String lwdgCd, @Param("sgguBldgNm") String sgguBldgNm);

	@Query(
                value = "select a.* from tb_addr a where a.lwdg_cd = :lwdgCd and a.ltno_bno = :ltnoBno"
                        + " and exists (select 1 from tb_map b where b.stnm_unon_cd = a.stnm_unon_cd) ",
                nativeQuery = true
        )
        Iterable<TbAddr> selectAddrNative2(@Param("lwdgCd") String lwdgCd, @Param("ltnoBno") String ltnoBno);

}

