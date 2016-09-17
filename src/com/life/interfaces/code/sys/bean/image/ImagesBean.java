package com.life.interfaces.code.sys.bean.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * ClassName: ImagesBean
 * 
 * @Description: TODO
 * @author 刘强
 * @date 2015年8月1日下午11:03:10
 */
public class ImagesBean
{
	private File file = null; // 文件对象
	private String inputDir; // 输入图路径
	private String outputDir; // 输出图路径
	private String inputFileName; // 输入图文件名
	private String outputFileName; // 输出图文件名
	private int outputWidth = 100; // 默认输出图片宽
	private int outputHeight = 100; // 默认输出图片高
	private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)

	/**
	 * 初始化变量
	 */
	public ImagesBean()
	{
		inputDir = "";
		outputDir = "";
		inputFileName = "";
		outputFileName = "";
		outputWidth = 100;
		outputHeight = 100;
	}

	/**
	 * 
	 * @Description: TODO
	 * @param @param width
	 * @param @param height   
	 * @return void  
	 * @throws
	 * @author 刘强
	 * @date 2015年8月1日下午11:05:17
	 */
	public void setWidthAndHeight(int width, int height)
	{
		this.outputWidth = width;
		this.outputHeight = height;
	}

	/**
	 * 
	 * @Description: TODO
	 * @param @param path
	 * @param @return   
	 * @return long  
	 * @throws
	 * @author 刘强
	 * @date 2015年8月1日下午11:05:21
	 */
	public long getPicSize(String path)
	{
		file = new File(path);
		return file.length();
	}

	/**
	 * 
	 * @Description: TODO
	 * @param @return
	 * @param @throws IOException   
	 * @return String  
	 * @throws
	 * @author 刘强
	 * @date 2015年8月1日下午11:05:25
	 */
	public String compressPic() throws IOException
	{
		// 获得源文件
		file = new File(inputDir + File.separator + inputFileName);
		if (!file.exists())
		{
			return "";
		}
		Image img = ImageIO.read(file);
		// 判断图片格式是否正确
		if (img.getWidth(null) == -1)
		{
			System.out.println(" can't read,retry!" + "<BR>");
			return "no";
		} else
		{
			int newWidth;
			int newHeight;
			// 判断是否是等比缩放
			if (this.proportion == true)
			{
				// 为等比缩放计算输出的图片宽度及高度
				double rate1 = ((double) img.getWidth(null)) / (double) outputWidth + 0.1;
				double rate2 = ((double) img.getHeight(null)) / (double) outputHeight + 0.1;
				// 根据缩放比率大的进行缩放控制
				double rate = rate1 > rate2 ? rate1 : rate2;
				newWidth = (int) (((double) img.getWidth(null)) / rate);
				newHeight = (int) (((double) img.getHeight(null)) / rate);
			} else
			{
				newWidth = outputWidth; // 输出的图片宽度
				newHeight = outputHeight; // 输出的图片高度
			}
			BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);

			/*
			 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
			 */
			// tag.getGraphics().drawImage(img.getScaledInstance(newWidth,
			// newHeight, Image.SCALE_DEFAULT), 0, 0, null);
			tag.getGraphics().drawImage(img, 0, 0, newWidth, newHeight, null);
			FileOutputStream out = new FileOutputStream(outputDir + File.separator + outputFileName);
			// JPEGImageEncoder可适用于其他图片类型的转换
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
			out.close();
		}
		return "ok";
	}

	/**
	 * 
	 * @Description: TODO
	 * @param @param inputDir
	 * @param @param outputDir
	 * @param @param inputFileName
	 * @param @param outputFileName
	 * @param @return
	 * @param @throws IOException   
	 * @return String  
	 * @throws
	 * @author 刘强
	 * @date 2015年8月1日下午11:05:30
	 */
	public String compressPic(String inputDir, String outputDir, String inputFileName, String outputFileName)
			throws IOException
	{
		// 输入图路径
		this.inputDir = inputDir;
		// 输出图路径
		this.outputDir = outputDir;
		// 输入图文件名
		this.inputFileName = inputFileName;
		// 输出图文件名
		this.outputFileName = outputFileName;
		return compressPic();
	}

	/**
	 * 
	 * @Description: TODO
	 * @param @param inputDir
	 * @param @param outputDir
	 * @param @param inputFileName
	 * @param @param outputFileName
	 * @param @param width
	 * @param @param height
	 * @param @param gp
	 * @param @return
	 * @param @throws IOException   
	 * @return String  
	 * @throws
	 * @author 刘强
	 * @date 2015年8月1日下午11:05:35
	 */
	public String compressPic(String inputDir, String outputDir, String inputFileName, String outputFileName, int width,
			int height, boolean gp) throws IOException
	{
		// 输入图路径
		this.inputDir = inputDir;
		// 输出图路径
		this.outputDir = outputDir;
		// 输入图文件名
		this.inputFileName = inputFileName;
		// 输出图文件名
		this.outputFileName = outputFileName;
		// 设置图片长宽
		setWidthAndHeight(width, height);
		// 是否是等比缩放 标记
		this.proportion = gp;
		return compressPic();
	}
}
