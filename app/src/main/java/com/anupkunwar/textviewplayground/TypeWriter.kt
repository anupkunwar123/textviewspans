package com.anupkunwar.textviewplayground

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.view.View
import android.view.animation.Animation

class TypeWriter : AbstractFragment() {
    lateinit var animator: ValueAnimator
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "Span can give you type writer effect . . ."
        animator = ObjectAnimator.ofInt(0, text.length + 1)
        animator.addUpdateListener {
            val builder = SpannableStringBuilder(text)
            builder.setSpan(HideSpan(), 0, text.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
            var currAnimatedValue = it.animatedValue as Int
            if (currAnimatedValue > builder.length) {
                currAnimatedValue = builder.length
            }
            builder.setSpan(
                ShowSpan(),
                0,
                currAnimatedValue,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )

            setSpan(builder)
        }
        animator.repeatCount = Animation.INFINITE
        animator.duration = 2000
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