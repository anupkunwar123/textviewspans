package com.anupkunwar.textviewplayground

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View

class ColorGradient : AbstractFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val builder = SpannableStringBuilder()
            .append("This is where ")
            .append("\n")
            .append("colourful", ShaderSpan(), SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE)
            .append("\n")
            .append("spans starts")
        setSpan(builder)
    }
}