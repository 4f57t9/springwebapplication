package com.mycompany.springwebapp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch13Board {
	private int bno;
	private String btitle;
	private String bcontent;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bdate;
	private String mid;
	private int bhitcount;
	// Client -> Controller
	private MultipartFile battach;
	// Controller -> Service -> Dao -> DB
	private String battachoname;
	private String battachtype;
	// 방법1: 서버 파일 시스템에 파일로 저장
	private String battachsname;
	// 방법2: DB에 BLOB으로 저장
	// byte[] <- MyBatis -> BLOB
	private byte[] battachdata;
}
