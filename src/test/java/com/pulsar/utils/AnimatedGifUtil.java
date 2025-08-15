package com.pulsar.utils;

import com.madgag.gif.fmsware.AnimatedGifEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Utility for encoding a sequence of PNG screenshots into an animated GIF.
 */
public final class AnimatedGifUtil {

    private AnimatedGifUtil() {}

    /**
     * Encode PNG frames (as byte arrays) into a single animated GIF.
     *
     * @param pngFrames array of PNG-encoded frames
     * @param frameDelayMs delay between frames in milliseconds
     * @return GIF bytes
     * @throws IOException if an image cannot be read or encoding fails
     */
    public static byte[] encode(byte[][] pngFrames, int frameDelayMs) throws IOException {
        if (pngFrames == null || pngFrames.length == 0) {
            return new byte[0];
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        AnimatedGifEncoder encoder = new AnimatedGifEncoder();
        encoder.setDelay(frameDelayMs);
        encoder.setRepeat(0); // loop forever
        encoder.start(outputStream);

        for (byte[] frameBytes : pngFrames) {
            if (frameBytes == null || frameBytes.length == 0) {
                continue;
            }
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(frameBytes));
            if (image != null) {
                encoder.addFrame(image);
            }
        }

        encoder.finish();
        return outputStream.toByteArray();
    }
}


