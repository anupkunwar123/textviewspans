package com.anupkunwar.textviewplayground

import android.content.Context
import android.graphics.*
import android.graphics.BitmapShader
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance
import android.widget.TextView
import androidx.annotation.DrawableRes

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

class ScaledDrawable(private val textView: TextView, @DrawableRes resId: Int) : Drawable() {

    private val drawable: Drawable = textView.context.getDrawable(resId)!!

    init {
        val ascent = -textView.paint.ascent().toInt()
        textView.paint.descent()
        drawable.setBounds(
            0,
            -ascent,
            (ascent * drawable.intrinsicWidth.toFloat() / drawable.intrinsicHeight).toInt(),
            0
        )
        setBounds(
            0,
            -ascent,
            (ascent * drawable.intrinsicWidth.toFloat() / drawable.intrinsicHeight).toInt(),
            0
        )

    }

    override fun draw(canvas: Canvas) {
        drawable.draw(canvas)
    }


    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

}