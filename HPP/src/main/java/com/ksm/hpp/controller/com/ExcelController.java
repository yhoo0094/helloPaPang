package com.ksm.hpp.controller.com;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksm.hpp.framework.util.Constant;
import com.ksm.hpp.framework.util.RequestUtil;
import com.ksm.hpp.service.com.CommonService;

@Controller
@RequestMapping("/excel")
public class ExcelController {
	
	@Resource(name = "CommonService")
	protected CommonService commonService;
	
	/**
	 * @메소드명: downloadData
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 13. 오후 1:40:53
	 * @설명: 엑셀 다운로드
	 */
	@RequestMapping("/downloadData.do")
	@SuppressWarnings("unchecked")
	public void downloadData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> inData = RequestUtil.getParameterMap(request);
		String fileName = (String) inData.get(Constant.EXCEL_FILENM);
		String sheetName = (String) inData.get(Constant.EXCEL_SHEETNM);
		ArrayList<Map<String, Object>> columns = (ArrayList<Map<String, Object>>) inData.get(Constant.EXCEL_COLUMN);
		ArrayList<Map<String, Object>> datas = (ArrayList<Map<String, Object>>) inData.get(Constant.EXCEL_DATA);
		
		//엑셀 관련 변수 정의
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet((String) inData.get(Constant.EXCEL_SHEETNM));    // sheet 생성
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		int rowCnt = 1;		//행 위치(첫 행은 비우기 위해 1부터 시작)
		int cellCnt = 1;	//열 위치(첫 행은 비우기 위해 1부터 시작, 행 바뀔 때마다 1로 초기화할 것)
		int colSize = columns.size();	//열 개수
		int dataSize = datas.size();	//행 개수
		List<XSSFCell> cellArr = new ArrayList<XSSFCell>();	//셀 저장을 위한 배열(행 생성할 때 초기화)
		
		//셀 스타일 생성
		XSSFCellStyle titleStyle = papangTitleStyle(workbook);		//제목 스타일
		XSSFCellStyle headerStyle = papangHeaderStyle(workbook);	//헤더 스타일
		XSSFCellStyle cellStyle = papangCellStyle(workbook);		//일반 셀 스타일
		
		//시트 상단에 제목 입력
		sheet.addMergedRegion(new CellRangeAddress(rowCnt, rowCnt, cellCnt, cellCnt + columns.size() -1));	//시작행, 끝행, 시작열, 끝열
		row = sheet.createRow(rowCnt++);
		
		for(int i = 0; i < colSize; i++) {
			cell = row.createCell(cellCnt++);
			cell.setCellStyle(titleStyle);
			cellArr.add(cell);
		}
		cellArr.get(0).setCellValue(sheetName);
		
		//헤더 입력
		rowCnt++;	//제목이랑 헤더 사이에 한 줄 띄우기
		row = sheet.createRow(rowCnt++);
		cellCnt = 1;
		for(int i = 0; i < colSize; i++) {
			cell = row.createCell(cellCnt++);
			cell.setCellStyle(headerStyle);
			cell.setCellValue((String)columns.get(i).get("title"));
		}
		
		//데이터 입력
		String dataKey;
		for(int i = 0; i < dataSize; i++) {
			row = sheet.createRow(rowCnt++);
			cellCnt = 1;
			for(int k = 0; k < colSize; k++) {
				cell = row.createCell(cellCnt++);
				cell.setCellStyle(cellStyle);
				dataKey = (String)columns.get(k).get("data");
				cell.setCellValue((String)datas.get(i).get(dataKey));
			}
		}
		
		response.setContentType("application.octet-stream; charset=UTF-8");
		String downloadFileName = URLEncoder.encode(fileName + ".xlsx", "UTF-8") + "\";";
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downloadFileName.replaceAll("\\+", "%20"));
		
		ServletOutputStream sos = response.getOutputStream();
		workbook.write(sos);
		workbook.close();
		sos.close();
	}
	
	/**
	 * @메소드명: papangTitleStyle
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 13. 오후 1:41:05
	 * @설명: 엑셀 제목 스타일 지정
	 */
	private static XSSFCellStyle papangTitleStyle(XSSFWorkbook workbook) {
		XSSFCellStyle result = workbook.createCellStyle();
		result.setAlignment(HorizontalAlignment.CENTER);		//가운데 정렬
		result.setVerticalAlignment(VerticalAlignment.CENTER);	//세로 가운데 정렬
		result.setWrapText(true);	//true: 여러 줄에 표시하여 셀 내에서 모든 콘텐츠를 볼 수 있도록 함
		
		//폰트 설정
		Font font = new XSSFFont();
		font.setBold(true);
		result.setFont(font);
		
		//테두리
		BorderStyle borderStyle = BorderStyle.MEDIUM;
		result.setBorderTop(borderStyle);
		result.setBorderBottom(borderStyle);				
		result.setBorderLeft(borderStyle);
		result.setBorderRight(borderStyle);
		result.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM , new XSSFColor(new byte[] {(byte) 0,(byte) 0,(byte) 0}, null));
		
		return result;
	}
	
	/**
	 * @메소드명: papangHeaderStyle
	 * @작성자: 김상민
	 * @생성일: 2023. 1. 13. 오후 1:41:05
	 * @설명: 엑셀 헤더 스타일 지정
	 */
	private static XSSFCellStyle papangHeaderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle result = workbook.createCellStyle();
		result.setAlignment(HorizontalAlignment.CENTER);		//가운데 정렬
		result.setVerticalAlignment(VerticalAlignment.CENTER);	//세로 가운데 정렬
		result.setWrapText(false);	//true: 여러 줄에 표시하여 셀 내에서 모든 콘텐츠를 볼 수 있도록 함
		
		//폰트 설정
		Font font = new XSSFFont();
		font.setBold(true);
		result.setFont(font);
		
		//테두리
		BorderStyle borderStyle = BorderStyle.THIN;
		result.setBorderTop(borderStyle);
		result.setBorderBottom(borderStyle);				
		result.setBorderLeft(borderStyle);
		result.setBorderRight(borderStyle);
		result.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM , new XSSFColor(new byte[] {(byte) 0,(byte) 0,(byte) 0}, null));
		
		return result;
	}	
	
	private static XSSFCellStyle papangCellStyle(XSSFWorkbook workbook) {
		XSSFCellStyle result = workbook.createCellStyle();
		result.setAlignment(HorizontalAlignment.CENTER);		//가운데 정렬
		result.setVerticalAlignment(VerticalAlignment.CENTER);	//세로 가운데 정렬
		result.setWrapText(false);	//true: 여러 줄에 표시하여 셀 내에서 모든 콘텐츠를 볼 수 있도록 함
		
		//폰트 설정
		Font font = new XSSFFont();
		font.setBold(true);
		result.setFont(font);
		
		//테두리
		BorderStyle borderStyle = BorderStyle.THIN;
		result.setBorderTop(borderStyle);
		result.setBorderBottom(borderStyle);				
		result.setBorderLeft(borderStyle);
		result.setBorderRight(borderStyle);
		result.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM , new XSSFColor(new byte[] {(byte) 0,(byte) 0,(byte) 0}, null));
		
		return result;
	}		
	
}
