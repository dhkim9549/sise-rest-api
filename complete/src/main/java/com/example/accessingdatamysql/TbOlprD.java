package com.example.accessingdatamysql;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface TbOlprD {

	String getTwprcDongNo();
	String getDtlBldgNm();
	String getBldgNm();

}
