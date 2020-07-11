package com.anupkunwar.textviewplayground

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.view.View

class Pattern : AbstractFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val builder = SpannableStringBuilder()
            .append("Add")
            .append("\n")
            .append("Patterns", BitmapShader(requireContext()), Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            .append(" with spans")

        builder.setSpan(RelativeSizeSpan(3f), 0, builder.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)

        setSpan(builder)
    }
}