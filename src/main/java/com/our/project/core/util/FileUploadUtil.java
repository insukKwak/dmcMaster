package com.our.project.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * ?��?�� ?��로드 �??�� ?��?�� ?��?��?�� FileUploadUtil
 *
 */
@Component("fileUploadUtil")
public class FileUploadUtil {

	public static final int BUFF_SIZE = 2048;
	
	public List<HashMap<String, Object>> fileUpload(Map<String, MultipartFile> files, String uploadPath, String uploadDtlPath) throws Exception {
		
		String uploadPaths = uploadPath;
		if(uploadDtlPath != null && !"".equals(uploadDtlPath)){
			uploadPaths += File.separator + uploadDtlPath;
		}
		
		File saveFolder = new File (filePathBlackList(uploadPaths));
		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}

		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
		
		MultipartFile file;
		List<HashMap<String, Object>> fileList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> fileMap;
		
		while (itr.hasNext()) {
			Entry<String, MultipartFile> entry = itr.next();
			String key = entry.getKey();
			file = entry.getValue();
			String origFileName = file.getOriginalFilename();
			
			if(file.getSize() > 0){
			
				int index = origFileName.lastIndexOf(".");
				
				String fileExt = origFileName.substring(index + 1);
				String newName = getTimeStamp();
				String filePath = uploadPaths + File.separator + newName + "." + fileExt;
				File newFile = new File(filePathBlackList(filePath));
				int filecnt = 1;
				while(newFile.exists()){
					filecnt++;
					newFile = new File(filePathBlackList(uploadPaths + File.separator + newName + "[" + filecnt + "]" + "." + fileExt));
				}
				if(filecnt > 1){
					newName = newName + "[" + filecnt + "]" ;
				}
				file.transferTo(newFile);
				
				fileMap = new HashMap<String, Object>();
				fileMap.put("key", key);
				fileMap.put("c_name", file.getName());
				fileMap.put("file_name", origFileName);
				fileMap.put("real_file_name", newName + "." + fileExt);
				fileMap.put("file_size", Integer.parseInt((file.getSize()/1024)+""));
				fileList.add(fileMap);
			
			}
		}
		
		return fileList;
	}

	public HashMap<String, Object> fileCopy(String fileName, String uploadPath, String uploadDtlPath) throws Exception {
		
		String uploadPaths = uploadPath;
		if(uploadDtlPath != null && !"".equals(uploadDtlPath)){
			uploadPaths += File.separator + uploadDtlPath;
		}
		
		String newName = getTimeStamp();
		int index = fileName.lastIndexOf(".");
		String fileExt = fileName.substring(index + 1);
		File oldFile = new File(uploadPaths + File.separator + fileName);
		File newFile = new File(uploadPaths + File.separator + newName + "." + fileExt);
		
		FileInputStream inputStream = new FileInputStream(oldFile);
		FileOutputStream outputStream = new FileOutputStream(newFile);
		  
		int filecnt = 1;
		while(newFile.exists()){
			filecnt++;
			newFile = new File(filePathBlackList(uploadPaths + File.separator + newName + "[" + filecnt + "]" + "." + fileExt));
		}
		HashMap<String, Object> fileMap = null;
		
		if(oldFile.exists()) {
			FileChannel fcin =  inputStream.getChannel();
			FileChannel fcout = outputStream.getChannel();
			
			long size = fcin.size();
			fcin.transferTo(0, size, fcout);
			
			fcout.close();
			fcin.close();
			
			outputStream.close();
			inputStream.close();
			
			fileMap = new HashMap<String, Object>();
			fileMap.put("real_file_name", newName + "." + fileExt);
		}
		return fileMap;
	}
	
	public static String filePathBlackList(String value) {
		String returnValue = value;
		if (returnValue == null || returnValue.trim().equals("")) {
			return "";
		}

		returnValue = returnValue.replaceAll("\\.\\./", ""); // ../
		returnValue = returnValue.replaceAll("\\.\\.\\\\", ""); // ..\

		return returnValue;
	}

	/**
	 * ?��?��?��?��리�??��?��?��?�� 고유값을 ?��?��?���? ?��?�� ?��?��?��?��?��17?��리의TIMESTAMP값을 구하?�� 기능
	 *
	 * @param
	 * @return Timestamp �?
	 * @exception MyException
	 * @see
	 */
	private static String getTimeStamp() {

		String rtnStr = null;

		// 문자?���? �??��?���? ?��?�� ?��?�� ?��?��(?��?��-?��-?�� ?��:�?:�?:�?(?��?��?��?�� �?))
		String pattern = "yyyyMMddhhmmssSSS";
		try {
			SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
			Timestamp ts = new Timestamp(System.currentTimeMillis());

			rtnStr = sdfCurrent.format(ts.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rtnStr;
	}
	
	public void fileDelete(String fileName, String uploadPath, String uploadDtlPath) throws Exception{
		
		String uploadPaths = uploadPath;
		if(uploadDtlPath != null && !"".equals(uploadDtlPath)){
			uploadPaths += File.separator + uploadDtlPath;
		}
		 
		File deleteFile = new File(uploadPaths + File.separator + fileName);
		
		if(deleteFile.exists()){
			try{
				boolean delFlag = deleteFile.delete();
				
				 if(delFlag) {
//                     logger.info(fileName+" ==> ?��?�� ?��?�� ?���?!");
                 } else {
//                	 logger.info(fileName+" ==> ?��?�� ?��?�� ?��?��!");
                 }
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
		}
		
	}
	
	
	public static boolean fileDownload(HttpServletRequest request, HttpServletResponse response, String filePath, String fileName, String realFileName)
			throws Exception {
		InputStream is = null;
		try {
			File file = new File(filePath + File.separator + realFileName);
			// ?��?��?�� 존재 ?���? ?��?��경우
			if (!file.exists()) {
				PrintWriter out = response.getWriter();

				String mgr = "Can not file DownLoad.";

				out.println("<script language=\"javascript\">");
				out.println("<!--");
				out.println("	alert(\"" + new String(mgr.getBytes("euc-kr"), "8859_1") + " \");");
				out.println("	history.back();");
				out.println("-->");
				out.println("</script>");
				out.close();
				return false;
			} else {
				is = new FileInputStream(file);
				if (is != null) {
					response.setHeader("Content-Transfer-Encoding", "binary;");
					response.setHeader("Pragma", "no-cache;");
					response.setHeader("Expires", "-1;");

					String Agent = request.getHeader("USER-AGENT");
					response.reset();
					String filename = "";
					filename = java.net.URLEncoder.encode(fileName, "UTF-8");
					filename = filename.toString().replaceAll("\\+", "%20");
					filename = filename.toString().replaceAll("%28", "\\(");
					filename = filename.toString().replaceAll("%29", "\\)");

					filename = filename.toString().replace("%21", "!");
					filename = filename.toString().replace("%23", "#");
					filename = filename.toString().replace("%24", "$");
					filename = filename.toString().replace("%25", "%");
					filename = filename.toString().replace("%26", "&");
					filename = filename.toString().replace("%27", "'");
					filename = filename.toString().replace("%2B", "+");
					filename = filename.toString().replace("%3D", "=");
					filename = filename.toString().replace("%40", "@");
					filename = filename.toString().replace("%5B", "[");
					filename = filename.toString().replace("%5D", "]");
					filename = filename.toString().replace("%5E", "^");
					filename = filename.toString().replace("%60", "`");
					filename = filename.toString().replace("%7B", "{");
					filename = filename.toString().replace("%7D", "}");
					if (Agent.indexOf("MSIE") > -1) {
						int x = Agent.indexOf('M', 2);
						String IEV = Agent.substring(x + 5, x + 8);
						if (IEV.equalsIgnoreCase("5.5")) {
							response.setHeader("Content-Disposition", "filename=" + new String(filename.getBytes("euc-kr"), "8859_1"));
						} else {
							response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("euc-kr"), "8859_1"));
						}
					} else {
						response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8"), "latin1"));
					}
					// response.setContentType("application/octet-stream");

					ServletOutputStream servletOut = response.getOutputStream();
					byte[] buffer = new byte[1024];

					int n = 0;
					while (-1 != (n = is.read(buffer))) {
						servletOut.write(buffer, 0, n);
					}
					safeClose(servletOut);
					safeClose(is);
				}
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			safeClose(is);
		}
		return true;
	}
	
	private static void safeClose(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception e) {
			}
		}
	}
	

	private static void zipEntry(File sourceFile, String sourcePath, ZipOutputStream zos) throws Exception {
	     
	        // sourceFile ?�� ?��?��?��리인 경우 ?��?�� ?��?�� 리스?�� �??��?? ?���??���?
	        if (sourceFile.isDirectory()) {
	            if (sourceFile.getName().equalsIgnoreCase(".metadata")) { // .metadata ?��?��?���? return
	                return;
	            }
	            File[] fileArray = sourceFile.listFiles(); // sourceFile ?�� ?��?�� ?��?�� 리스?��
	            for (int i = 0; i < fileArray.length; i++) {
	                zipEntry(fileArray[i], sourcePath, zos); // ?���? ?���?
	            }
	        } else { // sourcehFile ?�� ?��?��?��리�? ?��?�� 경우
	            BufferedInputStream bis = null;
	            try {
	                String sFilePath = sourceFile.getPath();
	//LogUtil.write(" sFilePath : "+sFilePath);
	                String zipEntryName = sFilePath.substring(sourcePath.length() + 1, sFilePath.length());
	//LogUtil.write(" zipEntryName : "+zipEntryName);
	                bis = new BufferedInputStream(new FileInputStream(sourceFile));
	                ZipEntry zentry = new ZipEntry(zipEntryName);
	                zentry.setTime(sourceFile.lastModified());
	                zos.putNextEntry(zentry);
	                byte[] buffer = new byte[8];
	                int cnt = 0;
	                while ((cnt = bis.read(buffer, 0, 8)) != -1) {
	                    zos.write(buffer, 0, cnt);
	                }
	                zos.closeEntry();
	            } finally {
	                if (bis != null) {
	                    bis.close();
	                }
	            }
	        }
	}
	 
	public static boolean makeZip(String sourcePath, String output, String movPath) throws Exception {
	 	// ?���? ???��(sourcePath)?�� ?��?��?��리나 ?��?��?�� ?��?���? 리턴?��?��.
	    File sourceFile = new File(sourcePath);
	    if (!sourceFile.isFile() && !sourceFile.isDirectory()) {
	        throw new Exception("?���? ???��?�� ?��?��?�� 찾을 ?���? ?��?��?��?��.");
	    }
	
	    FileOutputStream fos = null;
	    BufferedOutputStream bos = null;
	    ZipOutputStream zos = null;
	
	    try {
	        fos = new FileOutputStream(output); // FileOutputStream
	        bos = new BufferedOutputStream(fos); // BufferedStream
	        zos = new ZipOutputStream(bos); // ZipOutputStream
	        zos.setLevel(8); // ?���? ?���? - 최�? ?��축률?? 9, ?��?��?�� 8
	        zipEntry(sourceFile, sourcePath, zos); // Zip ?��?�� ?��?��
	        zos.finish(); // ZipOutputStream finish
	    } finally {
	        if (zos != null) {
	            zos.close();
	        }
	        if (bos != null) {
	            bos.close();
	        }
	        if (fos != null) {
	            fos.close();
	        }
	    }
	    
	    boolean result = false;
	    File outFile = new File(output);
	    if(outFile.exists()) result = true;	//?��?��?�� ?��?��?��?�� ?��?���? true
	    
	    if(movPath != null) {
	    	File mf = new File(movPath+output);
	    	outFile.renameTo(mf);
	    }
	    
	    return result;
	}
	
	//?��?? ?��?�� s_seq ?��?��?�� ???�� /WEB-INF/files/report
	public static void makeReportExcel(HSSFWorkbook workbook,String s_seq, String filename, HttpServletRequest request) throws Exception {	
		
		@SuppressWarnings("deprecation")
		String savepath = request.getRealPath("/")+"WEB-INF/files/report/"+s_seq;
		File sp = new File(savepath);
		if(!sp.exists()) {
			sp.mkdirs();
		}
		String file = savepath + "/" + filename;
		FileOutputStream fileOut = null;
		try {
			File xlsFile = new File(file);
			fileOut = new FileOutputStream(xlsFile);
			workbook.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			fileOut.close();
		}
	 }
	
	//?��?��?���? ?��?��
	public static boolean deleteDirectory(File path) {
		if(!path.exists()) {
		return false;
		}

		File[] files = path.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				deleteDirectory(file);
			} else {
				file.delete();
			}
		}
		
		return path.delete();
	}

}
