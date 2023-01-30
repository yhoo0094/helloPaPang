package com.ksm.hpp.controller.com;

import java.io.File;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONObject;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.ksm.hpp.framework.exception.ConfigurationException;
import com.ksm.hpp.framework.util.Configuration;
import com.ksm.hpp.framework.util.OSValidator;
import com.ksm.hpp.framework.util.OS_Type;
import com.ksm.hpp.service.com.CommonService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Resource(name = "CommonService")
	protected CommonService commonService;

	/**
	* @메소드명: ckUploadImage
	* @작성자: KimSangMin
	* @생성일: 2023. 1. 26. 오후 5:47:15
	* @설명: CK에디터 이미지 업로드
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/ckUploadImage.do")
	public void ckUploadImage(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
	    PrintWriter printWriter = null;
		
		String originalImageName = ""; //원본이름
	    String imageName = ""; //저장본이름
	    String extension = ""; //확장자

	    MultipartFile file = request.getFile("upload");
        originalImageName = file.getOriginalFilename();
        extension = FilenameUtils.getExtension(originalImageName);
        imageName = "img_" + UUID.randomUUID() + "." + extension;	  
        
        StringBuffer tmp = new StringBuffer();
        
        //파일 저장 경로 만들기 (추후 구현)

		//현재 날짜 구하기
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyyMMdd");
		String nowDate = date.format(dtfDate);	
		
		OS_Type os = OSValidator.getOS();	//OS타입 구하기(UNKNOWN(0), WINDOWS(1), LINUX(2), MAC(3), SOLARIS(4))
		Configuration conf = new Configuration();
		String filePath = new String(conf.getString("Global." + os + ".getComImagePath").getBytes("ISO-8859-1"), "UTF-8") + nowDate;	
		
		/*
		File dir = new File(filePath);
		if(!dir.isDirectory()) {	//해당 경로가 디렉토리인지 확인
			if(!dir.exists()) {		//해당 경로 디렉토리가 있는지 확인
				dir.mkdir();		//해당 디렉토리가 없으면 생성
			}
		}		
		*/
		
        File imageUpload = new File(filePath + "/" + imageName);
        file.transferTo(imageUpload);
	    
        //jsonObject.put("url", "/resources/images/editor/" + nowDate + "/" + imageName);
        jsonObject.put("url", "/common/images/" + nowDate + "/" + imageName);
        
        //리턴 response 작성
//        printWriter = response.getWriter();
//        response.setContentType("text/html");
//        printWriter.println(jsonObject);
        
		Gson gson = new Gson();
		String json = gson.toJson(jsonObject);
		response.getWriter().print(json);	//결과 json형태로 담아서 보내기
		response.setContentType("text/html");
	}	
	
	@ResponseBody
	@GetMapping("/images/{folder}/{filename}.{extension}")
	public org.springframework.core.io.Resource showImage(@PathVariable String folder, @PathVariable String filename, @PathVariable String extension) throws Exception {
		OS_Type os = OSValidator.getOS();	//OS타입 구하기(UNKNOWN(0), WINDOWS(1), LINUX(2), MAC(3), SOLARIS(4))
		Configuration conf = new Configuration();
		String filePath = new String(conf.getString("Global." + os + ".getComImagePath").getBytes("ISO-8859-1"), "UTF-8");
		
	 	return new UrlResource("file:///" + filePath + folder + "/" + filename + "." + extension);
	 }	
	
}
