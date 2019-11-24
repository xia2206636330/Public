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
 * servlet�������Ϣ�޸�
 * @author �Ķ���
 *
 */
public class UploadServlet extends HttpServlet   {
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//�������ı����ʽ
			request.setCharacterEncoding("UTF-8");
			

			//ʹ��Commons-fileuoload  ���
			
			//ServletFileUpload
			boolean f = ServletFileUpload.isMultipartContent(request);
			
			if(f){
				//ʹ�ù���
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(factory);
				
				
			List<FileItem> fis = null;
			try {
				fis = sfu.parseRequest(request);
			} catch (FileUploadException e1) {				
				e1.printStackTrace();
			}
			
			
			
			//������ͨ����ı���	
				//�ϴ���Ϣ
				News news = new News();
				for(FileItem fi:fis){
					if(fi.isFormField()){    //��ͨ��
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
				
				
					}else{   //�ļ���
						
						
						String filevalue = fi.getName();  //��ȡ·��
						
						if(filevalue!=null && filevalue.length()>0){
							File file  = new File(filevalue);  //���ļ���ɶ��󣬻�ȡ����
							
							String fileName = file.getName();   //�õ�����
							
							
							//��ȡ����������ϴ��ļ���·��
							String target  = request.getSession().getServletContext().getRealPath("/upload/");
							
							File NF = new File(target,fileName);
							try {
								fi.write(NF);
							} catch (Exception e) {
								e.printStackTrace();
							}								
							//����ͼƬ
							news.setNimg("upload/"+fileName);
							}				
														
						}
					}
					NewsBiz nb  = new NewsBizimpl();
					int count = nb.addNews(news);
			 		if(count>0){
						//��ӳɹ���������ҳ
						response.sendRedirect("index.jsp");
					}else{
						//��Ӳ��ɹ����������ҳ�� 
						response.sendRedirect("addNews.jsp");
					} 		
				}else{   
						response.setCharacterEncoding("UTF-8");
						PrintWriter out = response.getWriter();
						out.print("����֧���ϴ��ļ���������������������1");
			}
		}
	
	
}
