package com.anupkunwar.textviewplayground

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*

class Emoji : AbstractFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spannableString = SpannableStringBuilder()
            .append("Nepal is unique. Our")
            .append(
                "Flag",
                ImageSpan(ScaledDrawable(textView, R.drawable.flag), ImageSpan.ALIGN_BASELINE),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            .append("is different, also")
            .append(
                "Map",
                ImageSpan(ScaledDrawable(textView, R.drawable.map), ImageSpan.ALIGN_BASELINE),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            .append("with newly added point bit. Also ")
            .append(
                "Buddha",
                ImageSpan(ScaledDrawable(textView, R.drawable.buddha), ImageSpan.ALIGN_BASELINE),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            ).append(" was born here. And also we have ")
            .append(
                "mount_everest",
                ImageSpan(
                    ScaledDrawable(textView, R.drawable.mount_everest),
                    ImageSpan.ALIGN_BASELINE
                ),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            ).append(("tallest peak is here."))

        setSpan(spannableString)
    }

}