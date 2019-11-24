package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Biz.NewsBiz;
import Biz.impl.NewsBizimpl;
import Dao.entity.News;
/**
 * servlet添加新聞信息修改
 * @author 夏冬旺
 *
 */
public class UploadServlet extends HttpServlet   {
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//设置中文编码格式
			request.setCharacterEncoding("UTF-8");
			

			//使用Commons-fileuoload  组件
			
			//ServletFileUpload
			boolean f = ServletFileUpload.isMultipartContent(request);
			
			if(f){
				//使用工厂
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(factory);
				
				
			List<FileItem> fis = null;
			try {
				fis = sfu.parseRequest(request);
			} catch (FileUploadException e1) {				
				e1.printStackTrace();
			}
			
			
			
			//解析普通域和文本域	
				//上传信息
				News news = new News();
				for(FileItem fi:fis){
					if(fi.isFormField()){    //普通域
						String fname = fi.getFieldName();
					
						String type ="";
						String title ="";
						String neirong = "";
						String writer = "";
						
						
					if(fname.equals("type")){
						type = fi.getString("UTF-8");
						news.setTypeid(Integer.parseInt(type));
						
					}
					
					if(fname.equals("title")){
						 title = fi.getString("UTF-8");
						 news.setTitle(title);
						
					}
					if(fname.equals("neirong")){
						 neirong = fi.getString("UTF-8");
						news.setNeirong(neirong);
						
					}
					if(fname.equals("writer")){
						 writer = fi.getString("UTF-8");
						news.setWriter(writer);
						
					}
				
				
					}else{   //文件域
						
						
						String filevalue = fi.getName();  //获取路径
						
						if(filevalue!=null && filevalue.length()>0){
							File file  = new File(filevalue);  //将文件变成对象，获取对象
							
							String fileName = file.getName();   //得到对象
							
							
							//获取服务器存放上传文件的路径
							String target  = request.getSession().getServletContext().getRealPath("/upload/");
							
							File NF = new File(target,fileName);
							try {
								fi.write(NF);
							} catch (Exception e) {
								e.printStackTrace();
							}								
							//保存图片
							news.setNimg("upload/"+fileName);
							}				
														
						}
					}
					NewsBiz nb  = new NewsBizimpl();
					int count = nb.addNews(news);
			 		if(count>0){
						//添加成功，进入首页
						response.sendRedirect("index.jsp");
					}else{
						//添加不成功，返回添加页面 
						response.sendRedirect("addNews.jsp");
					} 		
				}else{   
						response.setCharacterEncoding("UTF-8");
						PrintWriter out = response.getWriter();
						out.print("表单不支持上传文件！！！！！！！！！！1");
			}
		}
	
	
}
