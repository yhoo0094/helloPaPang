package com.ksm.hpp.controller.com;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String ckUploadImage(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
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
        
        File imageUpload = new File("C:/data/hppnas/20230126/" + imageName + "." +  extension);
        file.transferTo(imageUpload);
	    
        jsonObject.put("url", imageUpload);
        
        //리턴 response 작성
        printWriter = response.getWriter();
        response.setContentType("text/html");
        printWriter.println(jsonObject);
        
	    return null;
	}		
	
}
