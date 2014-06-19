/**
 * @author verphen
 * @date 2014年6月13日  下午4:34:22
 */

package com.verphen.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import com.sun.jimi.core.*;

public class ImgUtils {

	/* 支持图片文件格式：jpg、bmp、jpeg、wbmp、png、gif */
	String[] fileSuffix = { "jpg", "bmp", "jpeg", "wbmp", "png", "gif" };

	public static void cut(String srcpath, String subpath, int x, int y,
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

	public static void main(String[] args) {
		try {
			cut("/springDemo/resources/imgs/pic.jpg", "d:\\2.jpg", 0, 0, 200, 200);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
