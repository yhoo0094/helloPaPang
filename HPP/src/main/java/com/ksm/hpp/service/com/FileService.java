package com.ksm.hpp.service.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ksm.hpp.framework.exception.ConfigurationException;
import com.ksm.hpp.framework.util.Configuration;
import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.framework.util.FileUtil;
import com.ksm.hpp.framework.util.OSValidator;
import com.ksm.hpp.framework.util.OS_Type;

@Service("FileService")
public class FileService extends BaseService {
	
	@Autowired
	SqlSession sqlSession; //SqlSession 빈 DI	
	
	List<String> excludedExtsList = Arrays.asList("exe");	//첨부파일 제외되는 확장자
	
	/**
	 * @메소드명: selectFile
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 27. 오후 5:27:44
	 * @설명: 파일목록 조회
	 */
	public Map<String, Object> selectFile(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object> list = sqlSession.selectList("mapper.com.FileMapper.selectFile", inData);
		result.put("list", list);
		
		return result;
	}

	/**
	 * @메소드명: downloadFile
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 27. 오후 5:28:45
	 * @설명: 파일 다운로드
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> downloadFile(StringBuilder logStr, Map<String, Object> inData) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Object> list = sqlSession.selectList("mapper.com.FileMapper.selectFile", inData);
		if(list.isEmpty()) {	//DB조회를 실패한 경우
			throw new RuntimeException("해당 파일을 찾을 수 없습니다.");
		}
		
		Map<String, Object> fileInfo = new HashMap<String, Object>();
		fileInfo = (Map<String, Object>) list.get(0);

		result.put("fileInfo", fileInfo);
		return result;
	}	
	
	/**
	 * @메소드명: insertFile
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 14. 오후 2:22:01
	 * @설명: 첨부파일 저장
	 */
	public Map<String, Object> insertFile(StringBuilder logStr, Map<String, Object> inData, List<MultipartFile> fileList) throws Exception
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		//현재 시간 구하기
		LocalTime time = LocalTime.now();
		DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HHmmss");
		String nowTime = time.format(dtfTime);
		
		do {
			if(fileList == null) {
				result.put(Constant.RESULT, Constant.RESULT_FAILURE);
				result.put(Constant.OUT_RESULT_MSG, "첨부파일이 존재하지 않습니다.");	
				break;
			}
			
			//오늘 날짜로 디렉토리 생성
			String ATC_FILE_PATH = this.makeDir();
			
			//파일 검증
			for(MultipartFile multiFile : fileList) {
				String ATC_FILE_NM = multiFile.getOriginalFilename();	//원본 파일명
				int pos = ATC_FILE_NM.lastIndexOf(".");
				//수정필요!! (break가 do while 문이 아닌 for문에 대해서 동작)
				if(pos == -1) {
					result.put(Constant.RESULT, Constant.RESULT_FAILURE);
					result.put(Constant.OUT_RESULT_MSG, ATC_FILE_NM + " 파일의 확장자가 존재하지 않습니다.");	
					break;					
				}
				String ATC_FILE_EXTS = ATC_FILE_NM.substring(pos + 1);	//확장자명			
				
				//허용된 확장자인지 검증
				//수정필요!! (break가 do while 문이 아닌 for문에 대해서 동작)
				if(excludedExtsList.contains(ATC_FILE_EXTS)) {
					result.put(Constant.RESULT, Constant.RESULT_FAILURE);
					result.put(Constant.OUT_RESULT_MSG, ATC_FILE_EXTS + "는 허용되지 않은 확장자입니다.");	
					break;					
				}			
			}
			
			//파일 저장
			for(MultipartFile multiFile : fileList) {
				InputStream fi = multiFile.getInputStream();
				String ATC_FILE_NM = multiFile.getOriginalFilename();	//원본 파일명
				long ATC_FILE_CAPA_VAL = multiFile.getSize();			//파일 사이즈
				int pos = ATC_FILE_NM.lastIndexOf(".");
				String ATC_FILE_EXTS = ATC_FILE_NM.substring(pos + 1);	//확장자명
				
				//파일명에 현재 시간 입력(파일명_현재시간.확장자)
				String SAVE_ATC_FILE_NM = ATC_FILE_NM.substring(0, pos) + "_" + nowTime + "." + ATC_FILE_EXTS;
				//중복된 파일명 변경
				SAVE_ATC_FILE_NM = this.getUniqueFileName(ATC_FILE_PATH, SAVE_ATC_FILE_NM);
				
				//업로드할 파일명(경로+파일명)
				File uploadFile = new File(ATC_FILE_PATH + SAVE_ATC_FILE_NM);
				FileOutputStream fo = new FileOutputStream(uploadFile);
				
				//물리적인 공간에 파일 저장
				FileUtil.saveFileOri(fi, fo);
				
				inData.put("ATC_FILE_NM", ATC_FILE_NM);					//파일명
				inData.put("SAVE_ATC_FILE_NM", SAVE_ATC_FILE_NM);		//파일 저장명
				inData.put("ATC_FILE_PATH", ATC_FILE_PATH);				//파일 경로
				inData.put("ATC_FILE_CAPA_VAL", ATC_FILE_CAPA_VAL);		//파일 용량
				inData.put("ATC_FILE_EXTS", ATC_FILE_EXTS);				//파일 확장자
				
				sqlSession.insert("mapper.com.FileMapper.insertFile", inData);
			}
		} while(false);
		
		return result;
	}	
	
	/**
	 * @메소드명: getUniqueFileName
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 14. 오후 3:59:44
	 * @설명: 중복된 파일명 변경
	 */
	public String getUniqueFileName(String path, String file) {
		File tmp = new File(path + file.toLowerCase());
		String fileName = file.toLowerCase();
		int i = 1;
		while(tmp.exists()) {
			int pos = file.lastIndexOf(".");
			String exts = file.substring(pos + 1);	//확장자
			fileName = fileName.substring(0, pos) + "(" + i + ")" + "." + exts;	//파일명_현재시간(i).확장자
			tmp = new File(path + fileName);
			i++;
		}
		return fileName;
	}
	
	/**
	 * @메소드명: makeDir
	 * @작성자: 김상민
	 * @생성일: 2022. 12. 14. 오후 2:37:37
	 * @설명: 오늘 날짜의 디렉토리 생성
	 */
	public String makeDir() throws ConfigurationException {
		//현재 날짜 구하기
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyyMMdd");
		String nowDate = date.format(dtfDate);	
		
		String ATC_FILE_PATH = "";	//첨부파일 저장 경로
		
		/**
		getResource("") => 현재파일 경로 반환(URL타입)
		(java.net.URL) file:/C:/eclipes-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/HPP/WEB-INF/classes/com/ksm/hpp/service/info/
		getResource("").getPath() => 현재파일 경로 반환(String타입)
		(java.lang.String) /C:/eclipes-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/HPP/WEB-INF/classes/com/ksm/hpp/service/info/
		**/
		/*기존 프레임워크 소스
		ATC_FILE_PATH = NoticeService.class.getResource("").getPath();	
		System.out.println(ATC_FILE_PATH);
		Properties props = new Properties();
		ATC_FILE_PATH = props.getProperty("Global.LOCAL.getComATC_FILE_PATH");
		System.out.println(ATC_FILE_PATH);			
		*/			
		
		//기존 소스 변형
		OS_Type os = OSValidator.getOS();	//OS타입 구하기(UNKNOWN(0), WINDOWS(1), LINUX(2), MAC(3), SOLARIS(4))
		Configuration conf = new Configuration();
		ATC_FILE_PATH = conf.getString("Global." + os + ".getComFilePath") + nowDate + "/";	
		File dir = new File(ATC_FILE_PATH);
		if(!dir.isDirectory()) {	//해당 경로가 디렉토리인지 확인
			if(!dir.exists()) {		//해당 경로 디렉토리가 있는지 확인
				dir.mkdir();		//해당 디렉토리가 없으면 생성
			}
		}
		
		return ATC_FILE_PATH;
	}
}
