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

	@Query(
		value = "select * from tb_olpr where twprc_dnji_no = :twprcDnjiNo and twprc_dong_no = :twprcDongNo ",
                nativeQuery = true
        )
        Iterable<TbOlpr> selectOlprNative2(@Param("twprcDnjiNo") String twprcDnjiNo, @Param("twprcDongNo") String twprcDongNo);

	@Query(
                value = ""
			+ "select twprc_dong_no as twprcDongNo, max(dtl_bldg_nm) as dtlBldgNm "
			+ "  from tb_olpr "
			+ " where twprc_dnji_no = :twprcDnjiNo "
			+ " group by twprc_dong_no ",
                nativeQuery = true
        )
        Iterable<TbOlprD> selectOlprNativeD(@Param("twprcDnjiNo") String twprcDnjiNo);

}

