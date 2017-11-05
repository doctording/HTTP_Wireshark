package utils;

import java.awt.image.BufferedImage;  
import java.io.FileInputStream;  
import java.io.IOException;  
  
import javax.imageio.ImageIO;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.http.HttpServletResponse;

// http://m.blog.csdn.net/article/details?id=53433490

public class ImgUtil {
	  public static final String JPG = "jpg";  
      public static final String PNG = "png";  
      public static final String BMP = "bmp";  
      public static final String GIF = "gif";  
    
      /**  
       * ��servlet�е��ø÷���, jspҳ����img��ǩ��srcָ���servlet, �����ʾͼƬ  
       *   
       * @param response  
       * @param path  
       * @param isResponseClose  
       */  
      public static void showImage(HttpServletResponse response, String path, boolean isResponseClose) {  
          try {  
              ServletOutputStream outStream = response.getOutputStream();// �õ���ͻ���������������ݵĶ���  
              FileInputStream fis = new FileInputStream(path); // ��byte���ķ�ʽ���ļ�  
              // ������  
              byte data[] = new byte[1000];  
              while (fis.read(data) > 0) {  
                  outStream.write(data);  
              }  
              fis.close();  
              response.setContentType("image/*"); // ���÷��ص��ļ�����  
              outStream.write(data); // �������  
              if (isResponseClose) {  
                  outStream.close();  
              }  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
    
      /**  
       * ��servlet�е��ø÷���, jspҳ����img��ǩ��srcָ���servlet, �����ʾͼƬ  
       *   
       * @param response  
       * @param data  
       * @param isResponseClose  
       */  
      public static void showImage(HttpServletResponse response, byte[] data, boolean isResponseClose) {  
          try {  
              ServletOutputStream outStream = response.getOutputStream();// �õ���ͻ���������������ݵĶ���  
              // ������  
              outStream.write(data);  
              response.setContentType("image/*"); // ���÷��ص��ļ�����  
              outStream.write(data); // �������  
              if (isResponseClose) {  
                  outStream.close();  
              }  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
    
      /**  
       * ��servlet�е��ø÷���, jspҳ����img��ǩ��srcָ���servlet, �����ʾͼƬ  
       *   
       * @param response  
       * @param image  
       * @param imgType  
       * @param isResponseClose  
       */  
      public static void showImage(HttpServletResponse response, BufferedImage image, String imgType, boolean isResponseClose) {  
          try {  
              ImageIO.write(image, imgType, response.getOutputStream());  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
    
}
