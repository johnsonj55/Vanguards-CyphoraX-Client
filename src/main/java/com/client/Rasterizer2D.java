package com.client;


import net.runelite.rs.api.RSRasterizer2D;

import static com.client.MathUtils.map;

public class Rasterizer2D extends Cacheable implements RSRasterizer2D {

    public static void drawItemBox(int leftX, int topY, int width, int height, int rgbColour) {
        if (leftX < Rasterizer2D.leftX) {
            width -= Rasterizer2D.leftX - leftX;
            leftX = Rasterizer2D.leftX;
        }
        if (topY < Rasterizer2D.topY) {
            height -= Rasterizer2D.topY - topY;
            topY = Rasterizer2D.topY;
        }
        if (leftX + width > bottomX)
            width = bottomX - leftX;
        if (topY + height > bottomY)
            height = bottomY - topY;
        int leftOver = Rasterizer2D.width - width;
        int pixelIndex = leftX + topY * Rasterizer2D.width;
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++)
                //pixels[pixelIndex++] = rgbColour;
                drawAlpha(pixels, pixelIndex++, rgbColour, 0);
            pixelIndex += leftOver;
        }
    }

    public static void initDrawingArea(int i, int j, int[] ai) {
        pixels = ai;
        width = j;
        height = i;
        setDrawingArea(i, 0, j, 0);
    }

    public static void drawBubble(int x, int y, int radius, int colour, int initialAlpha) {
        fillCircleAlpha(x, y, radius, colour, initialAlpha);
        fillCircleAlpha(x, y, radius + 2, colour, 8);
        fillCircleAlpha(x, y, radius + 4, colour, 6);
        fillCircleAlpha(x, y, radius + 6, colour, 4);
        fillCircleAlpha(x, y, radius + 8, colour, 2);
    }


	public static void fillCircle(int x, int y, int radius, int color) {
		int y1 = y - radius;
		if (y1 < 0) {
			y1 = 0;
		}
		int y2 = y + radius;
		if (y2 >= height) {
			y2 = height - 1;
		}
		for (int iy = y1; iy <= y2; iy++) {
			int dy = iy - y;
			int dist = (int) Math.sqrt(radius * radius - dy * dy);
			int x1 = x - dist;
			if (x1 < 0) {
				x1 = 0;
			}
			int x2 = x + dist;
			if (x2 >= width) {
				x2 = width - 1;
			}
			int pos = x1 + iy * width;
			for (int ix = x1; ix <= x2; ix++) {
				pixels[pos++] = color;
			}
		}
	}
    public static void fillCircleAlpha(int posX, int posY, int radius, int colour, int alpha) {
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int i3 = posY - radius;
        if (i3 < 0)
            i3 = 0;
        int j3 = posY + radius;
        if (j3 >= height)
            j3 = height - 1;
        for (int y = i3; y <= j3; y++) {
            int l3 = y - posY;
            int i4 = (int) Math.sqrt(radius * radius - l3 * l3);
            int x = posX - i4;
            if (x < 0)
                x = 0;
            int k4 = posX + i4;
            if (k4 >= width)
                k4 = width - 1;
            int pixel_offset = x + y * width;
            for (int i5 = x; i5 <= k4; i5++) {
                int dest_red = (pixels[pixel_offset] >> 16 & 0xff) * dest_intensity;
                int dest_green = (pixels[pixel_offset] >> 8 & 0xff) * dest_intensity;
                int dest_blue = (pixels[pixel_offset] & 0xff) * dest_intensity;
                int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8) + (src_blue + dest_blue >> 8);

                drawAlpha(pixels, pixel_offset++, result_rgb, 255);
            }
        }
    }

    public static void drawAlpha(int[] pixels, int index, int value, int alpha) {
        if (! Client.instance.isGpu() || pixels != Client.instance.getBufferProvider().getPixels())
        {
            pixels[index] = value;
            return;
        }

        // (int) x * 0x8081 >>> 23 is equivalent to (short) x / 255
        int outAlpha = alpha + ((pixels[index] >>> 24) * (255 - alpha) * 0x8081 >>> 23);
        pixels[index] = value & 0x00FFFFFF | outAlpha << 24;
    }

    public static void drawRectangle(int x, int y, int width, int height, int color) {
        drawHorizontalLine(x, y, width, color);
        drawHorizontalLine(x, (y + height) - 1, width, color);
        drawVerticalLine(x, y, height, color);
        drawVerticalLine((x + width) - 1, y, height, color);
    }


    protected static void drawHorizontalLineNew(int i, int j, int k, int l, int i1) {
        if (k < topY || k >= bottomY)
            return;
        if (i1 < leftX) {
            j -= leftX - i1;
            i1 = leftX;
        }
        if (i1 + j > bottomX)
            j = bottomX - i1;
        int j1 = 256 - l;
        int k1 = (i >> 16 & 0xff) * l;
        int l1 = (i >> 8 & 0xff) * l;
        int i2 = (i & 0xff) * l;
        int i3 = i1 + k * width;
        for (int j3 = 0; j3 < j; j3++) {
            int j2 = (pixels[i3] >> 16 & 0xff) * j1;
            int k2 = (pixels[i3] >> 8 & 0xff) * j1;
            int l2 = (pixels[i3] & 0xff) * j1;
            int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
            drawAlpha(pixels, i3++, k3, 255);
        }
    }

    public static void drawVerticalLineNew(int i, int j, int k, int l) {
        if (l < leftX || l >= bottomX)
            return;
        if (i < topY) {
            k -= topY - i;
            i = topY;
        }
        if (i + k > bottomY)
            k = bottomY - i;
        int j1 = l + i * width;
        for (int k1 = 0; k1 < k; k1++)
            drawAlpha(pixels, j1 + k1 * width, j, 255);

    }

    protected static void drawVerticleLineNew(int i, int j, int k, int l, int i1) {
        if (j < leftX || j >= bottomX)
            return;
        if (l < topY) {
            i1 -= topY - l;
            l = topY;
        }
        if (l + i1 > bottomY)
            i1 = bottomY - l;
        int j1 = 256 - k;
        int k1 = (i >> 16 & 0xff) * k;
        int l1 = (i >> 8 & 0xff) * k;
        int i2 = (i & 0xff) * k;
        int i3 = j + l * width;
        for (int j3 = 0; j3 < i1; j3++) {
            int j2 = (pixels[i3] >> 16 & 0xff) * j1;
            int k2 = (pixels[i3] >> 8 & 0xff) * j1;
            int l2 = (pixels[i3] & 0xff) * j1;
            int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
            drawAlpha(pixels, i3, k3, 255);
            i3 += width;
        }
    }

    public static void renderGlow(int drawX, int drawY, int glowColor, int r) {
        // center
        drawX += r / 2;
        drawY += r / 2;

        int startX = drawX - r;
        int endX = drawX + r;
        int startY = drawY - r;
        int endY = drawY + r;

        // clipping
        if (startX < leftX) {
            startX = leftX;
        }

        if (endX > bottomX) {
            endX = bottomX;
        }

        if (startY < topY) {
            startY = topY;
        }

        if (endY > bottomY) {
            endY = bottomY;
        }

        float edge0 = -(r / 2f);
        float edge1 = map((float) Math.sin(Client.loopCycle / 20f), -1, 1, edge0 + (r / 1.35f), r);
        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) { // what did i have to get working again, texture animation? Yeah uhh, new boxes textures 96>100 not aniamting
                int index = x + y * width;
                float d = MathUtils.dist(x, y, drawX, drawY);
                float dist = MathUtils.smoothstep(edge0, edge1, d);
                int oldColor = pixels[index];
                int newColor = blend(oldColor, glowColor, 1f - dist);
                drawAlpha(pixels, index, newColor, r);
            }
        }
    }

    public static int blend(int rgb1, int rgb2, float factor) {
        if (factor >= 1f) {
            return rgb2;
        }
        if (factor <= 0f) {
            return rgb1;
        }

        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >> 8) & 0xff;
        int b1 = (rgb1) & 0xff;

        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >> 8) & 0xff;
        int b2 = (rgb2) & 0xff;

        int r3 = r2 - r1;
        int g3 = g2 - g1;
        int b3 = b2 - b1;

        int r = (int) (r1 + (r3 * factor));
        int g = (int) (g1 + (g3 * factor));
        int b = (int) (b1 + (b3 * factor));

        return (r << 16) + (g << 8) + b;
    }

    public static void drawTransparentBox(int leftX, int topY, int width, int height, int rgbColour, int opacity) {
        if (leftX < Rasterizer2D.leftX) {
            width -= Rasterizer2D.leftX - leftX;
            leftX = Rasterizer2D.leftX;
        }
        if (topY < Rasterizer2D.topY) {
            height -= Rasterizer2D.topY - topY;
            topY = Rasterizer2D.topY;
        }
        if (leftX + width > bottomX)
            width = bottomX - leftX;
        if (topY + height > bottomY)
            height = bottomY - topY;
        int transparency = 256 - opacity;
        int red = (rgbColour >> 16 & 0xff) * opacity;
        int green = (rgbColour >> 8 & 0xff) * opacity;
        int blue = (rgbColour & 0xff) * opacity;
        int leftOver = Rasterizer2D.width - width;
        int pixelIndex = leftX + topY * Rasterizer2D.width;
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                int otherRed = (pixels[pixelIndex] >> 16 & 0xff) * transparency;
                int otherGreen = (pixels[pixelIndex] >> 8 & 0xff) * transparency;
                int otherBlue = (pixels[pixelIndex] & 0xff) * transparency;
                int transparentColour = ((red + otherRed >> 8) << 16) + ((green + otherGreen >> 8) << 8) + (blue + otherBlue >> 8);
                drawAlpha(pixels, pixelIndex++, transparentColour, opacity);
            }
            pixelIndex += leftOver;
        }
    }

    public static void clear(int color) {
        int length = width * height;
        int mod = length - (length & 0x7);
        int offset = 0;
        while (offset < mod) {
            pixels[(offset++)] = color;
            pixels[(offset++)] = color;
            pixels[(offset++)] = color;
            pixels[(offset++)] = color;
            pixels[(offset++)] = color;
            pixels[(offset++)] = color;
            pixels[(offset++)] = color;
            pixels[(offset++)] = color;
        }
        while (offset < length) {
            pixels[(offset++)] = color;
        }
    }

    public static void method336(int i, int j, int k, int l, int i1) {
        if (k < leftX) {
            i1 -= leftX - k;
            k = leftX;
        }
        if (j < topY) {
            i -= topY - j;
            j = topY;
        }
        if (k + i1 > bottomX)
            i1 = bottomX - k;
        if (j + i > bottomY)
            i = bottomY - j;
        int k1 = width - i1;
        int l1 = k + j * width;
        for (int i2 = -i; i2 < 0; i2++) {
            for (int j2 = -i1; j2 < 0; j2++)
                drawAlpha(pixels, l1++, l, 255);
            l1 += k1;
        }

    }

    public static void drawRoundedRectangle(int x, int y, int width, int height, int color,
                                            int alpha, boolean filled, boolean shadowed) {
        if (shadowed)
            drawRoundedRectangle(x + 1, y + 1, width, height, 0, alpha, filled,
                    false);
        if (alpha == -1) {
            if (filled) {
                drawHorizontalLine(y + 1, color, width - 4, x + 2);// method339
                drawHorizontalLine(y + height - 2, color, width - 4, x + 2);// method339
                drawPixels(height - 4, y + 2, x + 1, color, width - 2);// method336
            }
            drawHorizontalLine(y, color, width - 4, x + 2);// method339
            drawHorizontalLine(y + height - 1, color, width - 4, x + 2);// method339
            method341(y + 2, color, height - 4, x);// method341
            method341(y + 2, color, height - 4, x + width - 1);// method341
            drawPixels(1, y + 1, x + 1, color, 1);// method336
            drawPixels(1, y + 1, x + width - 2, color, 1);// method336
            drawPixels(1, y + height - 2, x + width - 2, color, 1);// method336
            drawPixels(1, y + height - 2, x + 1, color, 1);// method336
        } else if (alpha != -1) {
            if (filled) {
                method340(color, width - 4, y + 1, alpha, x + 2);// method340
                method340(color, width - 4, y + height - 2, alpha, x + 2);// method340
                method335(color, y + 2, width - 2, height - 4, alpha, x + 1);// method335
            }
            method340(color, width - 4, y, alpha, x + 2);// method340
            method340(color, width - 4, y + height - 1, alpha, x + 2);// method340
            method342(color, x, alpha, y + 2, height - 4);// method342
            method342(color, x + width - 1, alpha, y + 2, height - 4);// method342
            method335(color, y + 1, 1, 1, alpha, x + 1);// method335
            method335(color, y + 1, 1, 1, alpha, x + width - 2);// method335
            method335(color, y + height - 2, 1, 1, alpha, x + 1);// method335
            method335(color, y + height - 2, 1, 1, alpha, x + width - 2);// method335
        }
    }

    public static void drawAlphaGradient(int x, int y, int gradientWidth, int gradientHeight, int startColor, int endColor, int alpha) {
        int k1 = 0;
        int l1 = 0x10000 / gradientHeight;
        if (x < leftX) {
            gradientWidth -= leftX - x;
            x = leftX;
        }
        if (y < topY) {
            k1 += (topY - y) * l1;
            gradientHeight -= topY - y;
            y = topY;
        }
        if (x + gradientWidth > bottomX)
            gradientWidth = bottomX - x;
        if (y + gradientHeight > bottomY)
            gradientHeight = bottomY - y;
        int i2 = width - gradientWidth;
        int result_alpha = 256 - alpha;
        int total_pixels = x + y * width;
        for (int k2 = -gradientHeight; k2 < 0; k2++) {
            int gradient1 = 0x10000 - k1 >> 8;
            int gradient2 = k1 >> 8;
            int gradient_color = ((startColor & 0xff00ff) * gradient1 + (endColor & 0xff00ff) * gradient2 & 0xff00ff00) + ((startColor & 0xff00) * gradient1 + (endColor & 0xff00) * gradient2 & 0xff0000) >>> 8;
            int color = ((gradient_color & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((gradient_color & 0xff00) * alpha >> 8 & 0xff00);
            for (int k3 = -gradientWidth; k3 < 0; k3++) {
                int colored_pixel = pixels[total_pixels];
                colored_pixel = ((colored_pixel & 0xff00ff) * result_alpha >> 8 & 0xff00ff) + ((colored_pixel & 0xff00) * result_alpha >> 8 & 0xff00);
                drawAlpha(pixels, total_pixels++, color + colored_pixel, alpha);
            }
            total_pixels += i2;
            k1 += l1;
        }
    }

    public static void drawPixelsWithOpacity2(int xPos, int yPos, int pixelWidth, int pixelHeight, int color, int opacityLevel) {
        drawPixelsWithOpacity(color, yPos, pixelWidth, pixelHeight, opacityLevel, xPos);
    }

    public static void drawPixelsWithOpacity(int color, int yPos, int pixelWidth, int pixelHeight, int opacityLevel,
                                             int xPos) {
        if (xPos < leftX) {
            pixelWidth -= leftX - xPos;
            xPos = leftX;
        }
        if (yPos < topY) {
            pixelHeight -= topY - yPos;
            yPos = topY;
        }
        if (xPos + pixelWidth > bottomX) {
            pixelWidth = bottomX - xPos;
        }
        if (yPos + pixelHeight > bottomY) {
            pixelHeight = bottomY - yPos;
        }
        int l1 = 256 - opacityLevel;
        int i2 = (color >> 16 & 0xFF) * opacityLevel;
        int j2 = (color >> 8 & 0xFF) * opacityLevel;
        int k2 = (color & 0xFF) * opacityLevel;
        int k3 = width - pixelWidth;
        int l3 = xPos + yPos * width;
        if (l3 > pixels.length - 1) {
            l3 = pixels.length - 1;
        }
        for (int i4 = 0; i4 < pixelHeight; i4++) {
            for (int j4 = -pixelWidth; j4 < 0; j4++) {
                int l2 = (pixels[l3] >> 16 & 0xFF) * l1;
                int i3 = (pixels[l3] >> 8 & 0xFF) * l1;
                int j3 = (pixels[l3] & 0xFF) * l1;
                int k4 = (i2 + l2 >> 8 << 16) + (j2 + i3 >> 8 << 8) + (k2 + j3 >> 8);
                drawAlpha(pixels, l3++, k4, opacityLevel);
            }
            l3 += k3;
        }
    }

    public static void method338(int i, int j, int k, int l, int i1, int j1) {
        method340(l, i1, i, k, j1);
        method340(l, i1, (i + j) - 1, k, j1);
        if (j >= 3) {
            method342(l, j1, k, i + 1, j - 2);
            method342(l, (j1 + i1) - 1, k, i + 1, j - 2);
        }
    }

    public static void method339(int i, int j, int k, int l) {
        if (i < topY || i >= bottomY)
            return;
        if (l < leftX) {
            k -= leftX - l;
            l = leftX;
        }
        if (l + k > bottomX)
            k = bottomX - l;
        int i1 = l + i * width;
        for (int j1 = 0; j1 < k; j1++)
            drawAlpha(pixels, i1 + j1, j, 255);

    }

    private static void method340(int i, int j, int k, int l, int i1) {
        if (k < topY || k >= bottomY)
            return;
        if (i1 < leftX) {
            j -= leftX - i1;
            i1 = leftX;
        }
        if (i1 + j > bottomX)
            j = bottomX - i1;
        int j1 = 256 - l;
        int k1 = (i >> 16 & 0xff) * l;
        int l1 = (i >> 8 & 0xff) * l;
        int i2 = (i & 0xff) * l;
        int i3 = i1 + k * width;
        for (int j3 = 0; j3 < j; j3++) {
            int j2 = (pixels[i3] >> 16 & 0xff) * j1;
            int k2 = (pixels[i3] >> 8 & 0xff) * j1;
            int l2 = (pixels[i3] & 0xff) * j1;
            int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
            drawAlpha(pixels, i3++, k3, 255);
        }

    }

    public static void method341(int i, int j, int k, int l) {
        if (l < leftX || l >= bottomX)
            return;
        if (i < topY) {
            k -= topY - i;
            i = topY;
        }
        if (i + k > bottomY)
            k = bottomY - i;
        int j1 = l + i * width;
        for (int k1 = 0; k1 < k; k1++)
            drawAlpha(pixels, j1 + k1 * width, j, 255);

    }

    private static void method342(int i, int j, int k, int l, int i1) {
        if (j < leftX || j >= bottomX)
            return;
        if (l < topY) {
            i1 -= topY - l;
            l = topY;
        }
        if (l + i1 > bottomY)
            i1 = bottomY - l;
        int j1 = 256 - k;
        int k1 = (i >> 16 & 0xff) * k;
        int l1 = (i >> 8 & 0xff) * k;
        int i2 = (i & 0xff) * k;
        int i3 = j + l * width;
        for (int j3 = 0; j3 < i1; j3++) {
            int j2 = (pixels[i3] >> 16 & 0xff) * j1;
            int k2 = (pixels[i3] >> 8 & 0xff) * j1;
            int l2 = (pixels[i3] & 0xff) * j1;
            int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
            drawAlpha(pixels, i3, k3, 255);
            i3 += width;
        }
    }

    public static void drawBox(int leftX, int topY, int width, int height, int rgbColour) {
        if (leftX < Rasterizer2D.leftX) {
            width -= Rasterizer2D.leftX - leftX;
            leftX = Rasterizer2D.leftX;
        }
        if (topY < Rasterizer2D.topY) {
            height -= Rasterizer2D.topY - topY;
            topY = Rasterizer2D.topY;
        }
        if (leftX + width > bottomX)
            width = bottomX - leftX;
        if (topY + height > bottomY)
            height = bottomY - topY;
        int leftOver = Rasterizer2D.width - width;
        int pixelIndex = leftX + topY * Rasterizer2D.width;
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++)
                drawAlpha(pixels, pixelIndex++, rgbColour, 255);

            pixelIndex += leftOver;
        }
    }

    public static void drawVerticalLine2(int xPosition, int yPosition, int height, int rgbColour) {
        if (xPosition < leftX || xPosition >= bottomX)
            return;
        if (yPosition < topY) {
            height -= topY - yPosition;
            yPosition = topY;
        }
        if (yPosition + height > bottomY)
            height = bottomY - yPosition;
        int pixelIndex = xPosition + yPosition * width;
        for (int rowIndex = 0; rowIndex < height; rowIndex++)
            drawAlpha(pixels, pixelIndex + rowIndex * width, rgbColour, 255);
    }

    public static void drawHorizontalLine2(int xPosition, int yPosition, int width, int rgbColour) {
        if (yPosition < topY || yPosition >= bottomY)
            return;
        if (xPosition < leftX) {
            width -= leftX - xPosition;
            xPosition = leftX;
        }
        if (xPosition + width > bottomX)
            width = bottomX - xPosition;
        int pixelIndex = xPosition + yPosition * Rasterizer2D.width;
        for (int i = 0; i < width; i++)
            drawAlpha(pixels, pixelIndex + i, rgbColour, 255);

    }

    public static void drawBoxOutline(int leftX, int topY, int width, int height, int rgbColour) {
        drawHorizontalLine2(leftX, topY, width, rgbColour);
        drawHorizontalLine2(leftX, (topY + height) - 1, width, rgbColour);
        drawVerticalLine2(leftX, topY, height, rgbColour);
        drawVerticalLine2((leftX + width) - 1, topY, height, rgbColour);
    }

    public static void drawVerticalLine(int xPosition, int yPosition, int height, int rgbColour) {
        if (xPosition < leftX || xPosition >= bottomX)
            return;
        if (yPosition < topY) {
            height -= topY - yPosition;
            yPosition = topY;
        }
        if (yPosition + height > bottomY)
            height = bottomY - yPosition;
        int pixelIndex = xPosition + yPosition * width;
        for (int rowIndex = 0; rowIndex < height; rowIndex++)
            drawAlpha(pixels, pixelIndex + rowIndex * width, rgbColour, 255);
    }

    public static void drawAlphaBox(int x, int y, int lineWidth, int lineHeight, int color, int alpha) {// drawAlphaHorizontalLine
        if (y < topY) {
            if (y > (topY - lineHeight)) {
                lineHeight -= (topY - y);
                y += (topY - y);
            } else {
                return;
            }
        }
        if (y + lineHeight > bottomY) {
            lineHeight -= y + lineHeight - bottomY;
        }
        //if (y >= bottomY - lineHeight)
        //return;
        if (x < leftX) {
            lineWidth -= leftX - x;
            x = leftX;
        }
        if (x + lineWidth > bottomX)
            lineWidth = bottomX - x;
        for (int yOff = 0; yOff < lineHeight; yOff++) {
            int i3 = x + (y + (yOff)) * width;
            for (int j3 = 0; j3 < lineWidth; j3++) {
                //int alpha2 = (lineWidth-j3) / (lineWidth/alpha);
                int j1 = 256 - alpha;//alpha2 is for gradient
                int k1 = (color >> 16 & 0xff) * alpha;
                int l1 = (color >> 8 & 0xff) * alpha;
                int i2 = (color & 0xff) * alpha;
                int j2 = (pixels[i3] >> 16 & 0xff) * j1;
                int k2 = (pixels[i3] >> 8 & 0xff) * j1;
                int l2 = (pixels[i3] & 0xff) * j1;
                int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8)
                        + (i2 + l2 >> 8);
                drawAlpha(pixels, i3++, k3, alpha);
            }
        }
    }

    public static void defaultDrawingAreaSize() {
        leftX = 0;
        topY = 0;
        bottomX = width;
        bottomY = height;
        lastX = bottomX;
        viewportCenterX = bottomX / 2;
    }

    public void drawAlphaGradientOnSprite(Sprite sprite, int x, int y, int gradientWidth,
                                          int gradientHeight, int startColor, int endColor, int alpha) {
        int k1 = 0;
        int l1 = 0x10000 / gradientHeight;
        if (x < leftX) {
            gradientWidth -= leftX - x;
            x = leftX;
        }
        if (y < topY) {
            k1 += (topY - y) * l1;
            gradientHeight -= topY - y;
            y = topY;
        }
        if (x + gradientWidth > bottomX)
            gradientWidth = bottomX - x;
        if (y + gradientHeight > bottomY)
            gradientHeight = bottomY - y;
        int i2 = width - gradientWidth;
        int result_alpha = 256 - alpha;
        int total_pixels = x + y * width;
        for (int k2 = -gradientHeight; k2 < 0; k2++) {
            int gradient1 = 0x10000 - k1 >> 8;
            int gradient2 = k1 >> 8;
            int gradient_color = ((startColor & 0xff00ff) * gradient1
                    + (endColor & 0xff00ff) * gradient2 & 0xff00ff00)
                    + ((startColor & 0xff00) * gradient1 + (endColor & 0xff00)
                    * gradient2 & 0xff0000) >>> 8;
            int color = ((gradient_color & 0xff00ff) * alpha >> 8 & 0xff00ff)
                    + ((gradient_color & 0xff00) * alpha >> 8 & 0xff00);
            for (int k3 = -gradientWidth; k3 < 0; k3++) {
                int colored_pixel = pixels[total_pixels];
                colored_pixel = ((colored_pixel & 0xff00ff) * result_alpha >> 8 & 0xff00ff)
                        + ((colored_pixel & 0xff00) * result_alpha >> 8 & 0xff00);
                drawAlpha(pixels, total_pixels++, colored_pixel, alpha);
            }
            total_pixels += i2;
            k1 += l1;
        }
    }


    public static void setDrawingArea(int bottomY, int _topX, int rightX, int _topY) {
        if (_topX < 0)
            _topX = 0;
        if (_topY < 0)
            _topY = 0;
        if (rightX > width)
            rightX = width;
        if (bottomY > height)
            bottomY = height;
        leftX = _topX;
        topY = _topY;
        bottomX = rightX;
        Rasterizer2D.bottomY = bottomY;
        lastX = bottomX;
        viewportCenterX = bottomX / 2;
        viewportCenterY = Rasterizer2D.bottomY / 2;
    }

    public static void setAllPixelsToZero() {
        int i = width * height;
        for (int j = 0; j < i; j++)
            pixels[j] = 0;
    }

    public static boolean drawHorizontalLine(int yPos, int lineColor, int lineWidth, int xPos) {// method339
        if (yPos < topY || yPos >= bottomY) {
            return false;
        }
        if (xPos < leftX) {
            lineWidth -= leftX - xPos;
            xPos = leftX;
        }
        if (xPos + lineWidth > bottomX)
            lineWidth = bottomX - xPos;
        int i1 = xPos + yPos * width;
        for (int j1 = 0; j1 < lineWidth; j1++)
            drawAlpha(pixels, i1 + j1, lineColor, 255);
        return true;
    }

    public static void method335(int i, int j, int k, int l, int i1, int k1) {
        if (k1 < leftX) {
            k -= leftX - k1;
            k1 = leftX;
        }
        if (j < topY) {
            l -= topY - j;
            j = topY;
        }
        if (k1 + k > bottomX)
            k = bottomX - k1;
        if (j + l > bottomY)
            l = bottomY - j;
        int l1 = 256 - i1;
        int i2 = (i >> 16 & 0xff) * i1;
        int j2 = (i >> 8 & 0xff) * i1;
        int k2 = (i & 0xff) * i1;
        int k3 = width - k;
        int l3 = k1 + j * width;
        for (int i4 = 0; i4 < l; i4++) {
            for (int j4 = -k; j4 < 0; j4++) {
                int l2 = (pixels[l3] >> 16 & 0xff) * l1;
                int i3 = (pixels[l3] >> 8 & 0xff) * l1;
                int j3 = (pixels[l3] & 0xff) * l1;
                int k4 = ((i2 + l2 >> 8) << 16) + ((j2 + i3 >> 8) << 8)
                        + (k2 + j3 >> 8);
                drawAlpha(pixels, l3, k4, 255);
            }

            l3 += k3;
        }
    }

    public static void drawBorder(int x, int y, int width, int height, int color) {
        Rasterizer2D.drawPixels(1, y, x, color, width);
        Rasterizer2D.drawPixels(height, y, x, color, 1);
        Rasterizer2D.drawPixels(1, y + height, x, color, width + 1);
        Rasterizer2D.drawPixels(height, y, x + width, color, 1);
    }

    public static void drawPixels(int drawHeight, int yPosition, int xPositon, int color, int drawWidth) {
        if (xPositon < leftX) {
            drawWidth -= leftX - xPositon;
            xPositon = leftX;
        }
        if (yPosition < topY) {
            drawHeight -= topY - yPosition;
            yPosition = topY;
        }
        if (xPositon + drawWidth > bottomX)
            drawWidth = bottomX - xPositon;
        if (yPosition + drawHeight > bottomY)
            drawHeight = bottomY - yPosition;
        int k1 = width - drawWidth;
        int l1 = xPositon + yPosition * width;
        for (int i2 = -drawHeight; i2 < 0; i2++) {
            for (int j2 = -drawWidth; j2 < 0; j2++)
                drawAlpha(pixels, l1++, color, 255);
            l1 += k1;
        }

    }


    public static void fillRectangle(int x, int y, int width, int height, int colour) {
        if (x < leftX) {
            width -= leftX - x;
            x = leftX;
        }
        if (y < topY) {
            height -= topY - y;
            y = topY;
        }
        if (x + width > bottomX)
            width = bottomX - x;
        if (y + height > bottomY)
            height = bottomY - y;
        int k1 = Rasterizer2D.width - width;
        int l1 = x + y * Rasterizer2D.width;
        if (l1 > pixels.length - 1) {
            l1 = pixels.length - 1;
        }
        for (int i2 = -height; i2 < 0; i2++) {
            for (int j2 = -width; j2 < 0; j2++)
            drawAlpha(pixels, l1++, colour, 255);
            l1 += k1;
        }

    }

    public static void fillPixels(int i, int j, int k, int l, int i1) {
        method339(i1, l, j, i);
        method339((i1 + k) - 1, l, j, i);
        method341(i1, l, k, i);
        method341(i1, l, k, (i + j) - 1);
    }

    public static void clear()	{
        int i = width * height;
        for(int j = 0; j < i; j++) {
            pixels[j] = 0;
        }
    }

    Rasterizer2D() {
    }

    public static int pixels[];
    public static int width;
    public static int height;
    public static int topY;
    public static int bottomY;
    public static int leftX;
    public static int bottomX;
    public static int lastX;
    public static int viewportCenterX;
    public static int viewportCenterY;

}