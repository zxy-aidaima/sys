package vms.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 * 验证码生成类
 * 
 * @author ZhangXinyu
 *
 */
public class Captcha {

	private ByteArrayInputStream image;// 图像
	private String str;// 验证码
	// 验证码序列。
	private static final char[] randomSequence = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9' };

	private Captcha(){  
	       init();//初始化属性  
	   }

	public static Captcha Instance() {
		return new Captcha();
	}

	public ByteArrayInputStream getImage() {
		return this.image;
	}

	public String getString() {
		return this.str;
	}

	private void init() {  
	       // 在内存中创建图象  
	       int width = 90, height = 25;  
	       BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
	       // 获取图形上下文  
	       Graphics g = image.getGraphics();  
	       // 生成随机类  
	       Random random = new Random();  
	       // 设定背景色  
	       g.setColor(getRandColor(200,250));  
	       g.fillRect(0, 0, width, height);
	       // 创建字体，字体的大小应该根据图片的高度来定。
	       Font font = new Font("Times New Roman", Font.PLAIN, height-5);
	       // 设置字体。
	       g.setFont(font);

	       // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到  
	       g.setColor(getRandColor(120, 160));  
	       for (int i = 0;i < 155;i ++)
	       {
	        int x = random.nextInt(width);
	        int y = random.nextInt(height);
	               int xl = random.nextInt(12);
	               int yl = random.nextInt(12);
	        g.drawLine(x, y, x + xl, y + yl);
	       }
	       // 取随机产生的认证码(4位数字)  
	       String sRand = "";  
	       for (int i = 0;i < 4; i ++){  
	         int index = random.nextInt(35);
	           String rand = String.valueOf(randomSequence[index]);
	           sRand = sRand + rand;  
	           // 将认证码显示到图象中  
	           g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));  
	           // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成  
	           g.drawString(rand, 23 * i + 4, 16);  
	       }  
	       this.str = sRand; 
	       // 图象生效  
	       g.dispose();  
	       ByteArrayInputStream input = null;  
	       ByteArrayOutputStream output = new ByteArrayOutputStream();  
	       try{  
	           ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);  
	           ImageIO.write(image, "JPEG", imageOut);  
	           imageOut.close();  
	           input = new ByteArrayInputStream(output.toByteArray());  
	       }catch(Exception e){  
	           System.out.println("验证码图片产生出现错误：" + e.toString());  
	       }  
	          
	       this.image=input; 
	   }

	private Color getRandColor(int fc,int bc){  
	       Random random = new Random();  
	       if(fc > 255) fc = 255;  
	       if(bc > 255) bc = 255;  
	       int r = fc + random.nextInt(bc - fc);  
	       int g = fc + random.nextInt(bc - fc);  
	       int b = fc + random.nextInt(bc - fc);  
	       return new Color(r,g,b);  
	  }

}
