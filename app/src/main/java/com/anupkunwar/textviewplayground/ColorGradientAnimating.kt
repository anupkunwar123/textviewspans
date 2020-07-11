package com.anupkunwar.textviewplayground

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.format.DateUtils
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator

class ColorGradientAnimating : AbstractFragment() {
    lateinit var animator: ValueAnimator
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animator = ObjectAnimator.ofFloat(0f, 100f)
        animator.addUpdateListener {
            val builder = SpannableStringBuilder()
                .append("Animating  ")
                .append(
                    "colours",
                    ShaderSpan(percent = it.animatedValue as Float),
                    SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                .append(" with span. You can have so much fun")
                .append(
                    " animating.", ShaderSpan(percent = 100f - it.animatedValue as Float),
                    SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            setSpan(builder)
        }
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = Animation.INFINITE
        animator.duration = DateUtils.MINUTE_IN_MILLIS * 2
    }

    override fun onPause() {
        animator.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        animator.start()
    }

}