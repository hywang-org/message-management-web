package com.flash.message.utils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

public class ExcelUtil extends AbstractXlsxStreamingView {

	private String filename;

	private List<Object[]> list;

	private String[] title;

	private String[] customTitles = null;

	private boolean hasCustomTitle = false;

	// 构造函数 传输参数
	public ExcelUtil(String fileName, List<Object[]> data, String[] titles) {
		filename = fileName;
		list = data;
		title = titles;
	}

	// 构造函数 传输参数
	public ExcelUtil(String fileName, List<Object[]> data, String[] titles, boolean hasTitle, String[] customTitle) {
		filename = fileName;
		list = data;
		customTitles = customTitle;
		title = titles;
		hasCustomTitle = hasTitle;
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			filename = ExcelUtils.encodeFilename(filename, request);
			response.setHeader("Content-disposition", "attachment;filename=" + filename);
			// 创建Sheet
			Sheet sheet = workbook.createSheet("sheet");
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			cellStyle.setWrapText(true);
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 12);
			font.setFontName("微软雅黑");
			cellStyle.setFont(font);
			if (list.isEmpty()) {
				Row row = sheet.createRow(0);
				Cell cell = row.createCell(0);
				cell.setCellType(CellType.STRING);
				cell.setCellValue("无数据");
				return;
			}
			Cell cell = null;
			int rowNum = 0;
			if (hasCustomTitle) {
				CellStyle cellStyle2 = workbook.createCellStyle();
				cellStyle2.setFont(font);
				cellStyle2.setWrapText(true);
				for (int i = 0; i < customTitles.length; i++) {
					Row row = sheet.createRow(i);
					cell = row.createCell(0);
					cell.setCellValue(customTitles[i]);
					row.setHeight((short) 400);
					if (i == 1) {
						row.setHeight((short) 1500);
						cell.setCellStyle(cellStyle2);
					} else {
						cell.setCellStyle(cellStyle);
					}
					sheet.addMergedRegion(new CellRangeAddress(i, i, 0, title.length - 1));
				}
				rowNum = customTitles.length;
			}
			Row row = sheet.createRow(rowNum);
			for (int i = 0; i < title.length; i++) {
				cell = row.createCell(i);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(title[i]);
				cell.setCellStyle(cellStyle);
			}
			int index = rowNum + 1;
			for (Object[] data : list) {
				row = sheet.createRow(index);
				for (int i = 0; i < data.length; i++) {
					cell = row.createCell(i);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(Objects.toString(data[i], ""));
					cell.setCellStyle(cellStyle);
				}
				index++;
			}
			for (int i = 0; i < title.length; i++) {
				sheet.setColumnWidth(i, 20 * 256);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
