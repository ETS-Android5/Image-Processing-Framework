package com.university.ip.repository

import android.R.attr.src
import android.graphics.Bitmap
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.core.Core.*
import org.opencv.imgproc.Imgproc
import org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY


class Operators {

    fun toBinary(bmpOriginal: Bitmap, threshold: Int): Bitmap? {
        val imageMat = Mat(bmpOriginal.height, bmpOriginal.width, CvType.CV_8UC1)
        Utils.bitmapToMat(bmpOriginal, imageMat)
        Imgproc.cvtColor(imageMat, imageMat, Imgproc.COLOR_BGR2GRAY)
        Imgproc.threshold(imageMat, imageMat, threshold.toDouble(), 255.0, Imgproc.THRESH_BINARY)
        val result = Bitmap.createBitmap(imageMat.cols(), imageMat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(imageMat, result)
        return result
    }

    fun toAdaptiveBinary(bmpOriginal: Bitmap, threshold: Int): Bitmap? {
        val imageMat = Mat(bmpOriginal.height, bmpOriginal.width, CvType.CV_8UC1)
        Utils.bitmapToMat(bmpOriginal, imageMat)
        Imgproc.cvtColor(imageMat, imageMat, Imgproc.COLOR_BGR2GRAY)
        if(threshold%2==0){
            Imgproc.adaptiveThreshold(imageMat, imageMat, 255.0, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, threshold+1, 2.0);
        } else{
            Imgproc.adaptiveThreshold(imageMat, imageMat, 255.0, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, threshold, 2.0);
        }

        val result = Bitmap.createBitmap(imageMat.cols(), imageMat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(imageMat, result)
        return result
    }

}