package com.university.ip.ui.editor

import android.graphics.Bitmap
import com.university.ip.repository.Operators
import com.university.ip.ui.base.BasePresenter

class EditorPresenter : BasePresenter<EditorContract.View>(), EditorContract.Presenter {

    private val operators = Operators()


   override fun toBinary(bitmap: Bitmap,threshold: Int) {
       val result = operators.toBinary(bitmap,threshold)
       if (result != null) {
           getView()?.setBitmap(result)
       }
   }

    override fun toAdaptiveBinary(bitmap: Bitmap,threshold: Int) {
        val result = operators.toAdaptiveBinary(bitmap,threshold)
        if (result != null) {
            getView()?.setBitmap(result)
        }
    }
}