/**
 * @author verphen
 * @date 2014年6月13日  下午4:34:22
 */

package com.verphen.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiWriter;
import com.sun.jimi.core.options.JPGOptions;

public class ImgUtils {

	/* 支持图片文件格式：jpg、bmp、jpeg、wbmp、png、gif */
	String[] fileSuffix = { "jpg", "bmp", "jpeg", "wbmp", "png", "gif" };

	public static void mycut(String srcpath, String subpath, int x, int y,
			int width, int height) throws IOException {

		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			is = new FileInputStream(srcpath);
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			iis = ImageIO.createImageInputStream(is);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, "jpg", new File(subpath)); /* 保存新图片 */
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}
	}

	/* 图片转换为JPG格式 */
	public static void toJPG(String source, String dest, int quality) {

		if (dest == null || dest.trim().equals(""))
			dest = source;

		if (!dest.toLowerCase().trim().endsWith("jpg")) {
			dest += ".jpg";
			System.out.println("Overriding to JPG, output file: " + dest);
		}
		if (quality < 0 || quality > 100 || (quality + "") == null
				|| (quality + "").equals("")) {
			quality = 100;
		}
		try {
			JPGOptions options = new JPGOptions();
			options.setQuality(quality);
			ImageProducer image = Jimi.getImageProducer(source);
			JimiWriter writer = Jimi.createJimiWriter(dest);
			writer.setSource(image);

			writer.setOptions(options);

			writer.putImage(dest);
		} catch (JimiException je) {
			System.err.println("Error: " + je);
		}
	}

	/* 图片压缩（修改图片长和宽） */
	public static void resize(String source, String desc, int width, int height) {
		try {
			// 读入文件
			BufferedImage src = ImageIO.read(new File(source));
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_3BYTE_BGR);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "JPEG", new File(desc));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 图片裁剪 */
	public static void cut(String source, String desc, int x, int y, int width,
			int height) {
		try {

			FileInputStream is = new FileInputStream(source);

			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			ImageInputStream iis = ImageIO.createImageInputStream(is);

			reader.setInput(iis, true);

			ImageReadParam param = reader.getDefaultReadParam();

			Rectangle rect = new Rectangle(x, y, width, height);

			param.setSourceRegion(rect);

			BufferedImage bi = reader.read(0, param);

			ImageIO.write(bi, "jpg", new File(desc));
		} catch (FileNotFoundException e) {
			System.out.println("Can't find the image file： " + source);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to get the input stream :" + source);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			mycut("/springDemo/resources/imgs/pic.jpg", "d:\\2.jpg", 0, 0, 200,
					200);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
