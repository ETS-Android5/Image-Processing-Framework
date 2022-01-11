package com.university.ip.ui.editor

import android.graphics.Bitmap
import com.university.ip.ui.base.BaseContract

interface EditorContract {

    interface View : BaseContract.View {
        //view functions for each change of activity
        fun setBitmap(bitmap: Bitmap)
    }

    interface Presenter {

        fun toBinary(bitmap: Bitmap,threshold: Int)

        fun toAdaptiveBinary(bitmap: Bitmap,threshold: Int)
    }
}