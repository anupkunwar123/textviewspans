package com.anupkunwar.textviewplayground

import android.content.Context
import android.graphics.*
import android.graphics.BitmapShader
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance

class HideSpan : CharacterStyle(), UpdateAppearance {
    override fun updateDrawState(tp: TextPaint?) {
        tp?.alpha = 0x00
    }

}

class ShowSpan : CharacterStyle(), UpdateAppearance {
    override fun updateDrawState(tp: TextPaint?) {
        tp?.alpha = 0xFF
    }
}

class ShaderSpan(var percent: Float = 0f) : CharacterStyle(), UpdateAppearance {
    private val matrix = Matrix()
    private var shader: LinearGradient? = null
    override fun updateDrawState(tp: TextPaint?) {
        val color = intArrayOf(
            Color.RED,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA
        )
        val paintWidth = tp!!.textSize * color.size
        if (shader == null) {
            shader = LinearGradient(
                0f,
                0f,
                0f,
                paintWidth,
                color,
                null, Shader.TileMode.MIRROR
            )
        }
        tp.style = Paint.Style.FILL
        matrix.reset()
        matrix.setRotate(90f)
        print(percent)
        matrix.postTranslate(paintWidth * percent, 0f)
        shader?.setLocalMatrix(matrix)
        tp.shader = shader
    }
}

class BitmapShader(context: Context) : CharacterStyle(), UpdateAppearance {
    private val shader = BitmapShader(
        BitmapFactory.decodeResource(context.resources, R.drawable.img),
        Shader.TileMode.REPEAT,
        Shader.TileMode.REPEAT
    )

    override fun updateDrawState(tp: TextPaint?) {
        tp?.shader = shader
    }
}
